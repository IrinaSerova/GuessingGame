import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class GuessingGame extends JFrame {
	private JTextField txtGuess; // text field for the user's input 'guess'
	private JLabel lblOutput; // label for  output
	private int theNumber; // the number we're trying to guess
	
	public void checkGuess() { // method to check the user's input 'guess'
		String guessText = txtGuess.getText();
		String message = "";
		
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
		else {
			message = guess + " is correct. Congratulations! You Won!";
			lblOutput.setText(message);
		}
		
	}
	public GuessingGame() {
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
		panel.add(txtGuess);
		txtGuess.setColumns(4);
		
		JButton btnGuess = new JButton("GUESS!");
		btnGuess.setFont(new Font("Lato", Font.PLAIN, 13));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		// TODO Auto-generated method stub

	}
}
