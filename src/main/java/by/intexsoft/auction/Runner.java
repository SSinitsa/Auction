package by.intexsoft.auction;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.intexsoft.auction.model.Authority;
import by.intexsoft.auction.model.User;
import by.intexsoft.auction.service.AuctionService;
import by.intexsoft.auction.service.AuthenticationService;
import by.intexsoft.auction.service.AuthorityService;
import by.intexsoft.auction.service.BidService;
import by.intexsoft.auction.service.LotService;
import by.intexsoft.auction.service.StatusService;
import by.intexsoft.auction.service.TradingDayService;
import by.intexsoft.auction.service.UserService;

public class Runner {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserService userService = context.getBean(UserService.class);
		TradingDayService dayService = context.getBean(TradingDayService.class);
		AuctionService auctionService = context.getBean(AuctionService.class);
		LotService lotService = context.getBean(LotService.class);
		BidService bidService = context.getBean(BidService.class);
		AuthorityService authorityService = context.getBean(AuthorityService.class);
		StatusService statusService = context.getBean(StatusService.class);
		AuthenticationService authenticationService = context.getBean(AuthenticationService.class);
		
		Authority userRole = new Authority();
		userRole.authority = "USER";
		authorityService.save(userRole);
		
		User user1 = new User();
		user1.username = "username";
		user1.password = "notpassword";
		user1.firstName = "First";
		user1.lastName = "Last";
		user1.email = "good@mail.com";
		user1.phone = "+375000000000";
		user1.registrated = new Date();
		Set<Authority> authorities = new HashSet<>();
		authorities.add(authorityService.findByAuthority("USER"));
		user1.authorities = authorities;
		userService.save(user1);
		
		String token = authenticationService.generateToken(user1, "notpassword");
		System.out.println(token);
		
		System.out.println(authenticationService.getAuthentication(token));
		
		context.close();
	}
}
