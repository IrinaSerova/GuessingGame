import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;


public class GuessingGame extends JFrame {
	private JTextField txtGuess; // text field for the user's input 'guess'
	private JLabel lblOutput; // label for  output
	private int theNumber; // the number we're trying to guess
	private int attemptsLeft = 7; // give 7 tries
	
	
	public void checkGuess() { // method to check the user's input 'guess'
		String guessText = txtGuess.getText();
		String message = "";
		try {
		// check the guess 
		int guess = Integer.parseInt(guessText);
		//count tries
		attemptsLeft--;
		// too high
		if (guess > theNumber) {
			message = guess + " is too high. Guess again!";
			message += "You have " + attemptsLeft + " tries left.";
			lblOutput.setText(message);
			
		}
		// too low
		else if (guess < theNumber) {
			message = guess + " is too low. Guess again!";
			lblOutput.setText(message);
			
		}
		else { // correct
			
			message = guess + " is correct. Congratulations! You Won!  Play again";
			message += "You have " + attemptsLeft + " tries left.";
			lblOutput.setText(message);
			newGame();
		}
		if(attemptsLeft <= 0) {
			javax.swing.JOptionPane.showConfirmDialog(null, "Sorry, you ran out of tries. The number was " 
		+ theNumber + " Play again!");
			newGame();
		}
		}
		catch(Exception e) {
			lblOutput.setText("Enter a whole number between 1 and 100");
		}
		finally {
		
		txtGuess.requestFocus();
		txtGuess.selectAll(); 
		
		}
	}
	public void newGame() { // create a new random number from 1 to 100
		
		theNumber = (int)(Math.random() * 100 +1);
		attemptsLeft = 7;
		
	}
	public GuessingGame() {
		setTitle("Guessing Game");
		getContentPane().setBackground(new Color(102, 205, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblGuessingGame = new JLabel("Guessing Game");
		lblGuessingGame.setForeground(new Color(0, 100, 0));
		lblGuessingGame.setBounds(0, 27, 450, 48);
		lblGuessingGame.setFont(new Font("Lato", Font.BOLD, 18));
		lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		panel.setBounds(74, 102, 302, 48);
		getContentPane().add(panel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
		lblGuessANumber.setForeground(new Color(0, 128, 0));
		panel.add(lblGuessANumber);
		lblGuessANumber.setFont(new Font("Lato", Font.PLAIN, 13));
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtGuess);
		txtGuess.setColumns(4);
		
		JButton btnGuess = new JButton("GUESS!");
		btnGuess.setBackground(new Color(30, 144, 255));
		btnGuess.setForeground(new Color(0, 100, 0));
		btnGuess.setFont(new Font("Lato", Font.PLAIN, 13));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(182, 177, 87, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number and click GUESS!");
		lblOutput.setForeground(new Color(0, 100, 0));
		lblOutput.setFont(new Font("Lato", Font.PLAIN, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 233, 450, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		
		GuessingGame theGame =  new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 400));
		theGame.setVisible(true);

	}
}
