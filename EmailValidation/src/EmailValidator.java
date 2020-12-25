import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Microsoft
 *
 */
public class EmailValidator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SearchingClass searcher = new SearchingClass(20);

		searcher.addSuspect("bob@bezanga.com");
		searcher.addSuspect("sally@zimmers.com");
		searcher.addSuspect("peter@pinkelton.com");
		searcher.addSuspect("bobby.drop@tables.com");
		searcher.addSuspect("rudolph@rednose.com");
		searcher.addSuspect("bob@ross.com");
		searcher.addSuspect("ubiga@altman.com");
		searcher.addSuspect("tony@ross.com");
		searcher.addSuspect("aaron@rogers.com");
		searcher.addSuspect("yolo@once.com");
		searcher.addSuspect("yoka@yamalla.com");
		searcher.addSuspect("big@show.com");
		searcher.addSuspect("boug@dimmadome.com");

		System.out.println("Provide an email to search for:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String searchFor = scanner.nextLine();
		boolean process = true;
		while (process) {
			boolean emailValidation = emailValidationMethod(searchFor);

			if (emailValidation) {
				boolean foundMatch = searcher.foundMatch(searchFor);
				if (foundMatch) {
					System.out.println(searchFor + " is found in the email list.");
					process = false;
				} else {
					System.out.println("Sorry! " + searchFor + " is not found in the email list.");
					process = false;
				}
			} else {
				System.out.println("Please enter a correct Email ID!");
				searchFor = scanner.nextLine();
				process = true;
			}
		}

	}

	private static boolean emailValidationMethod(String searchFor) {
		String message = searchFor;
		//
		//
		// ^ marks the begining of line
		// The username part can have lowercase, uppercase letters, numbers and
		// -+_&* symbols and hence [a-zA-Z0-9-+_&*]
		// + is used as there can be 1 or more characters from the box[]
		// ?: is used as the group can have . symbol 0 times or more in between
		// After the dot symbol, there can be letters etc as the first check
		// group
		// + is used as there can be 1 or more characters from the box[]
		// * symbol to check whether the before part combines with @ symbol
		// The "@gmail" part of the domain name can have lowercase, uppercase
		// letters, numbers and - symbol and hence [a-zA-Z0-9-]
		// + is used as there can be 1 or more characters from the box[]
		// It should be followed by dot symbol and hence \\.
		// + is used to connect the group with last part
		// The ".com" part of domain name should have only lowercase and
		// uppercase alphabets and hence [a-zA-z]
		// It can have only 2 to 7 letters and hence {2,7}
		// $ marks the ending of the Id
		//
		//
		Pattern emailPattern = Pattern
				.compile("^[a-zA-Z0-9-+_&*]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

		Matcher emailMatcher = emailPattern.matcher(message);

		if (emailMatcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
