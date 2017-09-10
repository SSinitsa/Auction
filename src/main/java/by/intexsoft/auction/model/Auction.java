package by.intexsoft.auction.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Auction extends AbstractEntity {

	private static final long serialVersionUID = 2493466916836151381L;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "trading_day_id")
	public TradingDay tradingDay;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "queue_day_id")
	public TradingDay queueDay;
	
	@Column(name = "start_time", nullable = false)
	public Calendar startTime;
	
	@Column
	public int duration;
	
	@Column(name = "step_price", scale = 2)
	public BigDecimal stepPrice;

	@Column(name = "current_bid", scale = 2)
	public BigDecimal currentBid;
	
	@OneToOne
    @JoinColumn(name = "bid_holder_id")
	public User bidHolder;

	@ManyToOne(fetch = EAGER)
	@JoinColumn(name = "manager_id")
	public User manager;
	
	@OneToOne(fetch = EAGER)
	@JoinColumn(name = "lot_id")
	public Lot lot;

}
