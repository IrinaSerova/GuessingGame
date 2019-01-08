import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class GuessingGame extends JFrame {
	private JTextField txtGuess; // text field for the user's input 'guess'
	private JLabel lblOutput; // label for  output
	private int theNumber; // the number we're trying to guess
	
	public void checkGuess() { // method to check the user's input 'guess'
		String guessText = txtGuess.getText();
		String message = "";
		try {
		// check the guess 
		int guess = Integer.parseInt(guessText);
		
		// too high
		if (guess > theNumber) {
			message = guess + " is too high. Guess again!";
			lblOutput.setText(message);
		}
		// too low
		else if (guess < theNumber) {
			message = guess + " is too low. Guess again!";
			lblOutput.setText(message);
		}
		else { // correct
			message = guess + " is correct. Congratulations! You Won! Play again";
			lblOutput.setText(message);
			newGame();
		}
		}
		catch(Exception e) {
			lblOutput.setText("Enter a whole number between 1 and 100");
		}
		
		txtGuess.requestFocus();
		txtGuess.selectAll(); 
		
		
	}
	public void newGame() { // create a new random number from 1 to 100
		
		theNumber = (int)(Math.random() * 100 +1);
		
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblGuessingGame = new JLabel("Guessing Game");
		lblGuessingGame.setBounds(0, 27, 450, 48);
		lblGuessingGame.setFont(new Font("Lato", Font.BOLD, 18));
		lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 102, 450, 48);
		getContentPane().add(panel);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100");
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
		btnGuess.setBackground(UIManager.getColor("Button.light"));
		btnGuess.setForeground(Color.DARK_GRAY);
		btnGuess.setFont(new Font("Lato", Font.PLAIN, 13));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(182, 177, 87, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number and click GUESS!");
		lblOutput.setFont(new Font("Lato", Font.PLAIN, 13));
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
