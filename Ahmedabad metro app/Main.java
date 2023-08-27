import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metro m = new Metro();
        m.StationList();
        String source;
        String destination;
        System.out.print(
                "1) North-South corridor route \n2) East-West corridor route \n3) Find distance between two stations \n4) Find time to travel between two stations \n5) Find fare for travel between two stations \n6) Admin pannel \n7) Exit ");
        int choice = 0;
        while (choice != 7) {
            try {
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        m.North_South_corridor_display();
                        break;
                    case 2:
                        m.East_West_corridor_display();
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Enter the source station : ");
                        source = sc.nextLine();
                        System.out.println("Enter the destination station : ");
                        destination = sc.nextLine();
                        int distance_between_station = m.get_distance(source, destination);
                        if (distance_between_station >= 0)
                            System.out.println("Distance between " + source + " and " + destination + " is : "
                                    + distance_between_station);
                        else {
                            System.out.println("Invalid station");
                        }
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Enter the source station : ");
                        source = sc.nextLine();
                        System.out.println("Enter the destination station : ");
                        destination = sc.nextLine();
                        System.out.println("Time to reach from " + source + " to " + destination + " is : "
                                + m.get_time(source, destination));
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Enter the source station : ");
                        source = sc.nextLine();
                        System.out.println("Enter the destination station : ");
                        destination = sc.nextLine();
                        System.out.println("Fare between " + source + " to " + destination + " is : "
                                + m.get_fare(source, destination));
                        break;
                    case 6:
                        System.out.println(
                                "1) Add route at east \n2) Add route at west \n3) Add route at north \n4)  Add route at South \nEnter your choice : ");
                        int c = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the name of the new Station : ");
                        String name = sc.nextLine();
                        System.out.println("Enter the distance of the station from previous station");
                        int distance = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the time to travel from previous station to new station : ");
                        int time = sc.nextInt();
                        sc.nextLine();
                        switch (c) {
                            case 1:
                                m.addAtEast(name, distance, time);
                            case 2:
                                m.addAtWest(name, distance, time);
                            case 3:
                                m.addAtNorth(name, distance, time);
                            case 4:
                                m.addAtSouth(name, distance, time);
                        }
                        break;
                    case 7:
                        System.out.println("Thanks for using Ahmedabad Metro!");
                        System.exit(0);
                    default:
                        System.out.println("Enter the valid choice!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter valid choice!");
            }
        }
        sc.close();
    }
}