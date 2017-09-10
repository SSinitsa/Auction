package by.intexsoft.auction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.intexsoft.auction.service.AuctionService;
import by.intexsoft.auction.service.LotService;
import by.intexsoft.auction.service.TradingDayService;
import by.intexsoft.auction.service.UserService;

public class Runner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		UserService userService = context.getBean(UserService.class);
		TradingDayService dayService = context.getBean(TradingDayService.class);
		AuctionService auctionService = context.getBean(AuctionService.class);
		LotService lotService = context.getBean(LotService.class);
		
		
		
		
		
		
	}
}
