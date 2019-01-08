import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField textField;
	public GuessingGame() {
		getContentPane().setLayout(null);
		
		JLabel lblGuessingGame = new JLabel("Guessing Game");
		lblGuessingGame.setBounds(0, 24, 450, 48);
		lblGuessingGame.setFont(new Font("Myriad Pro", Font.PLAIN, 13));
		lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblGuessingGame);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between1 and 100");
		lblGuessANumber.setBounds(32, 84, 233, 16);
		getContentPane().add(lblGuessANumber);
		
		textField = new JTextField();
		textField.setBounds(277, 84, 78, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGuess = new JButton("GUESS!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuess.setBounds(163, 122, 117, 29);
		getContentPane().add(btnGuess);
		
		JLabel lblEnter = new JLabel("Enter a number and click GUESS!");
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setBounds(0, 180, 450, 16);
		getContentPane().add(lblEnter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
