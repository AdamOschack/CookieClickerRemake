import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class MyFrame extends JFrame implements ActionListener{
	
	JButton clicker = new JButton();
	JLabel cookies;
	JLabel shop;
	JLabel upgrades;
	JLabel perSecond;
	
	JButton cursor = new JButton();
	JButton gma = new JButton();
	JButton farm = new JButton();
	JButton mine = new JButton();
	JButton bank = new JButton();
	
	JButton cursorUpgradeOne = new JButton();
	JButton gmaUpgrade = new JButton();
	JButton farmUpgrade = new JButton();
	JButton mineUpgrade = new JButton();
	JButton bankUpgrade = new JButton();
	
	Timer timer = new Timer();
	
	int delay = 0;
	int period = 1000;
	
	double cps = 0.0;
	
	double w = 0.0;
	int clickAmt = 1;
	
	double cursorPrice = 15.0;
	int totalCursors = 0;
	double cursorPower = 0.1;
	double cursorUpgradePrice = 150.0;
	
	double gmaPrice = 100.0;
	int totalGmas = 0;
	double gmaPower = 1.0;
	double gmaUpgradePrice = 1000.0;
	
	double farmPrice = 1100.0;
	int totalFarms = 0;
	double farmPower = 8.0;
	double farmUpgradePrice = 2500.0;
	
	double minePrice = 5000.0;
	int totalMines = 0;
	double minePower = 20.0;
	double mineUpgradePrice = 10000.0;
	
	double bankPrice = 20000.0;
	int totalBanks = 0;
	double bankPower = 100.0;
	double bankUpgradePrice = 50000.0;
	
	MyFrame(){
		
		ImageIcon cookieIcon = new ImageIcon("cookie.png");
		Image image = cookieIcon.getImage();
		Image newImage = image.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
		cookieIcon = new ImageIcon(newImage);
		
		ImageIcon cursorIcon = new ImageIcon("cursor.jpg");
			Image imageTwo = cursorIcon.getImage();
			Image newImageTwo = imageTwo.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			cursorIcon = new ImageIcon(newImageTwo);
		
		ImageIcon gmaIcon = new ImageIcon("gma.jpg");
			Image imageThree = gmaIcon.getImage();
			Image newImageThree = imageThree.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			gmaIcon = new ImageIcon(newImageThree);
			
		ImageIcon farmIcon = new ImageIcon("images.png");
			Image imageFour = farmIcon.getImage();
			Image newImageFour = imageFour.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			farmIcon = new ImageIcon(newImageFour);
			
		ImageIcon mineIcon = new ImageIcon("mine.png");
			Image imageFive = mineIcon.getImage();
			Image newImageFive = imageFive.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			mineIcon = new ImageIcon(newImageFive);
		
		ImageIcon bankIcon = new ImageIcon("bank.png");
			Image imageSix = bankIcon.getImage();
			Image newImageSix = imageSix.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			bankIcon = new ImageIcon(newImageSix);
			
		cookies = new JLabel();
		cookies.setText((int)w + " Cookies");
		cookies.setBounds(215, 20, 200, 100);
		
		shop = new JLabel();
		shop.setText("Shop:");
		shop.setBounds(50, 30, 100, 100);
		
		upgrades = new JLabel();
		upgrades.setText("Upgrades:");
		upgrades.setBounds(400, 30, 100, 100);
		
		perSecond = new JLabel();
		perSecond.setText("per second: " + cps);
		perSecond.setBounds(200, 40, 200, 100);
		
		cursorUpgradeOne.setText("Multiply Cursor by 2 (" + (int)cursorUpgradePrice + ")");
		cursorUpgradeOne.setBounds(335, 90, 200, 50);
		cursorUpgradeOne.addActionListener(this);
		cursorUpgradeOne.setIcon(cursorIcon);
		cursorUpgradeOne.setHorizontalTextPosition(JButton.CENTER);
		cursorUpgradeOne.setHorizontalTextPosition(SwingConstants.LEFT);
		
		cursor.setText("Cursor: " + (int)cursorPrice);
		cursor.setBounds(0, 90, 150, 40);
		cursor.addActionListener(this);
		cursor.setIcon(cursorIcon);
		cursor.setHorizontalTextPosition(JButton.CENTER);
		cursor.setHorizontalTextPosition(SwingConstants.LEFT);
		
		gma.setText("G-ma: " + (int)gmaPrice);
		gma.setBounds(0, 140, 150, 40);
		gma.addActionListener(this);
		gma.setIcon(gmaIcon);
		gma.setHorizontalTextPosition(JButton.CENTER);
		gma.setHorizontalTextPosition(SwingConstants.LEFT);
		
		gmaUpgrade.setText("Multiply G-ma by 3 (" + (int)gmaUpgradePrice + ")");
		gmaUpgrade.setBounds(335, 140, 200, 50);
		gmaUpgrade.addActionListener(this);
		gmaUpgrade.setIcon(gmaIcon);
		gmaUpgrade.setHorizontalTextPosition(JButton.CENTER);
		gmaUpgrade.setHorizontalTextPosition(SwingConstants.LEFT);
		
		farm.setText("Farm: " + (int)farmPrice);
		farm.setBounds(0, 190, 150, 40);
		farm.addActionListener(this);
		farm.setIcon(farmIcon);
		farm.setHorizontalTextPosition(JButton.CENTER);
		farm.setHorizontalTextPosition(SwingConstants.LEFT);
		
		farmUpgrade.setText("Multiply farm by 5 (" + (int)farmUpgradePrice + ")");
		farmUpgrade.setBounds(335, 190, 200, 50);
		farmUpgrade.addActionListener(this);
		farmUpgrade.setIcon(farmIcon);
		farmUpgrade.setHorizontalTextPosition(JButton.CENTER);
		farmUpgrade.setHorizontalTextPosition(SwingConstants.LEFT);
		
		mine.setText("Mine: " + (int)minePrice);
		mine.setBounds(0, 240, 150, 40);
		mine.addActionListener(this);
		mine.setIcon(mineIcon);
		mine.setHorizontalTextPosition(JButton.CENTER);
		mine.setHorizontalTextPosition(SwingConstants.LEFT);
		
		mineUpgrade.setText("Multiply mine by 6 (" + (int)mineUpgradePrice + ")");
		mineUpgrade.setBounds(335, 240, 200, 50);
		mineUpgrade.addActionListener(this);
		mineUpgrade.setIcon(mineIcon);
		mineUpgrade.setHorizontalTextPosition(JButton.CENTER);
		mineUpgrade.setHorizontalTextPosition(SwingConstants.LEFT);
		
		bank.setText("Bank: " + (int)bankPrice);
		bank.setBounds(0, 290, 150, 40);
		bank.addActionListener(this);
		bank.setIcon(bankIcon);
		bank.setHorizontalTextPosition(JButton.CENTER);
		bank.setHorizontalTextPosition(SwingConstants.LEFT);
		
		bankUpgrade.setText("Multiply bank by 10 (" + (int)bankUpgradePrice + ")");
		bankUpgrade.setBounds(335, 290, 200, 50);
		bankUpgrade.addActionListener(this);
		bankUpgrade.setIcon(bankIcon);
		bankUpgrade.setHorizontalTextPosition(JButton.CENTER);
		bankUpgrade.setHorizontalTextPosition(SwingConstants.LEFT);
		
		clicker.setBounds(175, 150, 150, 150);
		clicker.addActionListener(this);
		clicker.setFocusable(false);
		clicker.setIcon(cookieIcon);
		clicker.setBackground(Color.LIGHT_GRAY);
		clicker.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(550, 550);
		this.setVisible(true);
		this.setBackground(Color.white);
		
		this.add(clicker);
		this.add(cookies);
		this.add(shop);
		this.add(upgrades);
		this.add(perSecond);
		
		this.add(cursorUpgradeOne);
		this.add(gmaUpgrade);
		this.add(farmUpgrade);
		this.add(mineUpgrade);
		this.add(bankUpgrade);
		
		this.add(cursor);
		this.add(gma);
		this.add(farm);
		this.add(mine);
		this.add(bank);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				w += (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
				cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
				cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
				cookies.setText((int)w + " Cookies");
			}
		}, delay, period);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clicker) {
			w = w + clickAmt;
			cookies.setText((int)w + " Cookies");
		}
		if(e.getSource() == cursor && w >= cursorPrice) {
			w = w - cursorPrice;
			cursorPrice = (int) (cursorPrice * 1.1645);
			totalCursors++;
			cursor.setText("Cursor: " + (int)cursorPrice + " (" + totalCursors + ")");
			cookies.setText((int)w + " Cookies");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == gma && w >= gmaPrice) {
			w = w - gmaPrice;
			gmaPrice = (int) (gmaPrice * 1.243521);
			totalGmas++;
			gma.setText("G-ma: " + (int)gmaPrice + " (" + totalGmas + ")");
			cookies.setText((int)w + " Cookies");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == mine && w >= minePrice) {
			w = w - minePrice;
			minePrice = (int) (minePrice * 1.4134789);
			totalMines++;
			mine.setText("Mine: " + (int)minePrice + " (" + totalMines + ")");
			cookies.setText((int)w + " Cookies");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == farm && w >= farmPrice) {
			w = w - farmPrice;
			farmPrice = (int) (farmPrice * 1.34765);
			totalFarms++;
			farm.setText("Farm: " + (int)farmPrice + " (" + totalFarms + ")");
			cookies.setText((int)w + " Cookies");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == bank && w >= bankPrice) {
			w = w - bankPrice;
			bankPrice = (int) (bankPrice * 1.34765);
			totalBanks++;
			bank.setText("Bank: " + (int)bankPrice + " (" + totalBanks + ")");
			cookies.setText((int)w + " Cookies");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == cursorUpgradeOne && w >= cursorUpgradePrice) {
			w = w - cursorUpgradePrice;
			cursorPower = cursorPower * 2;
			clickAmt = clickAmt * 2;
			cursorUpgradePrice = cursorUpgradePrice * 2.0687;
			cookies.setText((int)w + " Cookies");
			cursorUpgradeOne.setText("Multiply Cursor by 2 (" + (int)cursorUpgradePrice + ")");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == gmaUpgrade && w >= gmaUpgradePrice) {
			w = w - gmaUpgradePrice;
			gmaPower = gmaPower * 3;
			gmaUpgradePrice = gmaUpgradePrice * 3.0234;
			cookies.setText((int)w + " Cookies");
			gmaUpgrade.setText("Multiply Gma by 3 (" + (int)gmaUpgradePrice + ")");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == farmUpgrade && w >= farmUpgradePrice) {
			w = w - farmUpgradePrice;
			farmPower = farmPower * 5;
			farmUpgradePrice = farmUpgradePrice * 5.023456;
			cookies.setText((int)w + " Cookies");
			farmUpgrade.setText("Multiply Farm by 5 (" + (int)farmUpgradePrice + ")");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == mineUpgrade && w >= mineUpgradePrice) {
			w = w - mineUpgradePrice;
			minePower = minePower * 6;
			mineUpgradePrice = mineUpgradePrice * 6.0789453;
			cookies.setText((int)w + " Cookies");
			mineUpgrade.setText("Multiply Mine by 6 (" + (int)mineUpgradePrice + ")");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}
		if(e.getSource() == bankUpgrade && w >= bankUpgradePrice) {
			w = w - bankUpgradePrice;
			bankPower = bankPower * 10;
			bankUpgradePrice = bankUpgradePrice * 10.0789453;
			cookies.setText((int)w + " Cookies");
			bankUpgrade.setText("Multiply Bank by 10 (" + (int)bankUpgradePrice + ")");
			cps = (totalGmas * gmaPower) + (totalFarms * farmPower) + (totalCursors * cursorPower) + (totalMines * minePower) + (totalBanks * bankPower);
			cps = Double.parseDouble(new DecimalFormat("##.#").format(cps));
			perSecond.setText("per second: " + cps);
		}	
	}
	
	
	
}