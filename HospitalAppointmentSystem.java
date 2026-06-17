import java.util.*;

public class HospitalAppointmentSystem {

    static Scanner sc = new Scanner(System.in);

    // doctor -> booked slots
    static Map<String, Set<String>> doctorBookings = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("===== HOSPITAL APPOINTMENT BOOKING SYSTEM =====");

        // ---------------- LOGIN ----------------
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("Login Successful!\n");

        // ---------------- PATIENT INFO ----------------
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        // ---------------- LOCATION ----------------
        String[] districts = {"Chennai", "Coimbatore", "Madurai"};
        System.out.println("\nSelect District:");
        for (int i = 0; i < districts.length; i++)
            System.out.println((i + 1) + ". " + districts[i]);
        int d = sc.nextInt() - 1;
        sc.nextLine();

        String[][] cities = {
                {"Tambaram", "Velachery", "Avadi"},
                {"Gandhipuram", "RS Puram", "Peelamedu"},
                {"Anna Nagar", "KK Nagar", "Thirunagar"}
        };

        System.out.println("Select City/Village:");
        for (int i = 0; i < cities[d].length; i++)
            System.out.println((i + 1) + ". " + cities[d][i]);
        int c = sc.nextInt() - 1;
        sc.nextLine();

        // ---------------- HOSPITAL ----------------
        String[][] hospitals = {
                {"Apollo", "Government GH", "Fortis"},
                {"KMCH", "PSG Hospital"},
                {"Meenakshi Mission", "Government Hospital"}
        };

        System.out.println("\nNearby Hospitals:");
        for (int i = 0; i < hospitals[d].length; i++)
            System.out.println((i + 1) + ". " + hospitals[d][i]);
        int h = sc.nextInt() - 1;
        sc.nextLine();
        String hospital = hospitals[d][h];

        // ---------------- APPOINTMENT TYPE ----------------
        System.out.println("\n1. Normal Appointment");
        System.out.println("2. Emergency Appointment");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 2) {
            System.out.println("\n🚑 EMERGENCY APPOINTMENT CONFIRMED!");
            System.out.println("Ambulance dispatched to your location.");
            return;
        }

        // ---------------- DEPARTMENT ----------------
        String[] departments = {"Cardiologist", "General Physician", "Gynecologist", "Orthopedic"};
        System.out.println("\nSelect Department:");
        for (int i = 0; i < departments.length; i++)
            System.out.println((i + 1) + ". " + departments[i]);
        int dept = sc.nextInt() - 1;
        sc.nextLine();

        // ---------------- DOCTORS ----------------
        Map<String, String[]> doctors = new HashMap<>();
        doctors.put("Cardiologist", new String[]{"Dr. Ravi", "Dr. Kumar"});
        doctors.put("General Physician", new String[]{"Dr. Anitha", "Dr. Mohan"});
        doctors.put("Gynecologist", new String[]{"Dr. Priya", "Dr. Lakshmi"});
        doctors.put("Orthopedic", new String[]{"Dr. Arjun", "Dr. Suresh"});

        String deptName = departments[dept];
        String[] docList = doctors.get(deptName);

        System.out.println("\nAvailable Doctors:");
        for (int i = 0; i < docList.length; i++)
            System.out.println((i + 1) + ". " + docList[i]);
        int doc = sc.nextInt() - 1;
        sc.nextLine();
        String doctor = docList[doc];

        // ---------------- DATE & TIME ----------------
        System.out.print("Enter Appointment Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        String[] times = {"10:00 AM", "11:00 AM", "12:00 PM", "4:00 PM"};
        System.out.println("Select Time:");
        for (int i = 0; i < times.length; i++)
            System.out.println((i + 1) + ". " + times[i]);
        int t = sc.nextInt() - 1;
        sc.nextLine();
        String time = times[t];

        String bookingKey = doctor + "_" + date;

        doctorBookings.putIfAbsent(bookingKey, new HashSet<>());

        if (doctorBookings.get(bookingKey).contains(time)) {
            System.out.println("\n❌ Doctor NOT available at this time.");
        } else {
            doctorBookings.get(bookingKey).add(time);

            System.out.println("\n✅ APPOINTMENT CONFIRMED");
            System.out.println("Patient Name : " + name);
            System.out.println("Hospital     : " + hospital);
            System.out.println("Department   : " + deptName);
            System.out.println("Doctor       : " + doctor);
            System.out.println("Date         : " + date);
            System.out.println("Time         : " + time);
            System.out.println("\n🔔 You will be notified at the selected time.");
        }
    }
}