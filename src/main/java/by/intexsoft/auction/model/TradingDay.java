package by.intexsoft.auction.model;

import static javax.persistence.FetchType.EAGER;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "trading_day")
public class TradingDay extends AbstractEntity{

	private static final long serialVersionUID = 4112777822259677565L;

	@Column (name = "trading_date")
	public Calendar tradingDate;
	
	@ManyToOne(fetch = EAGER)
	@JoinColumn(name = "manager_id")
	public User workingManager;
	
	@OneToMany(mappedBy = "tradingDay", fetch = FetchType.EAGER)
	public Set<Auction> auctions;
	
	@OneToMany(mappedBy = "queueDay", fetch = FetchType.EAGER)
	public Set<Auction> tradesQueue;
}
