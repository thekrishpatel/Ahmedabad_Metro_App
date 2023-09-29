import java.util.ArrayList;

class Metro {

    ArrayList<String> east = new ArrayList<>();
    ArrayList<String> west = new ArrayList<>();
    ArrayList<String> north = new ArrayList<>();
    ArrayList<String> south = new ArrayList<>();

    class Stations {
        String Station_name;
        Stations next_Station;
        Stations prev_Station;
        int distance_prev;
        int distance_next;
        int time_next;
        int time_prev;
        Stations east;
        Stations west;
        Stations north;
        Stations south;

        Stations(String Station) {
            this.Station_name = Station;
            next_Station = null;
            prev_Station = null;
            distance_next = 0;
            distance_prev = 0;
            time_next = 0;
            time_prev = 0;
        }

        Stations() {
            this.Station_name = "Old High Court";
            this.east = null;
            this.west = null;
            this.north = null;
            this.south = null;
        }
    }

    Stations Interchange = new Stations();

    void addStation(Stations direction, String name, int distance, int time) {
        Stations temp = direction;
        while (temp.next_Station != null) {
            temp = temp.next_Station;
        }
        temp.next_Station = new Stations(name);
        temp.next_Station.prev_Station = temp;
        temp.distance_next = distance;
        temp.next_Station.distance_prev = distance;
        temp.time_next = time;
        temp.next_Station.time_prev = time;
    }

    void addAtEast(String name, int distance, int time) {
        east.add(name);
        if (Interchange.east == null) {
            Interchange.east = new Stations(name);
            Interchange.distance_next = distance;
            Interchange.east.distance_prev = distance;
            Interchange.time_next = time;
            Interchange.east.time_prev = time;
            Interchange.east.prev_Station = Interchange;
            return;
        }
        addStation(Interchange.east, name, distance, time);
    }

    void addAtWest(String name, int distance, int time) {
        west.add(name);
        if (Interchange.west == null) {
            Interchange.west = new Stations(name);
            Interchange.distance_next = distance;
            Interchange.west.distance_prev = distance;
            Interchange.time_next = time;
            Interchange.west.time_prev = time;
            Interchange.west.prev_Station = Interchange;
            return;
        }
        addStation(Interchange.west, name, distance, time);
    }

    void addAtSouth(String name, int distance, int time) {
        south.add(name);
        if (Interchange.south == null) {
            Interchange.south = new Stations(name);
            Interchange.distance_next = distance;
            Interchange.south.distance_prev = distance;
            Interchange.time_next = time;
            Interchange.south.time_prev = time;
            Interchange.south.prev_Station = Interchange;
            return;
        }
        addStation(Interchange.south, name, distance, time);
    }

    void addAtNorth(String name, int distance, int time) {
        north.add(name);
        if (Interchange.north == null) {
            Interchange.north = new Stations(name);
            Interchange.distance_next = distance;
            Interchange.north.distance_prev = distance;
            Interchange.time_next = time;
            Interchange.north.time_prev = time;
            Interchange.north.prev_Station = Interchange;
            return;
        }
        addStation(Interchange.north, name, distance, time);
    }

    void StationList() {
        addAtEast("Shahpur", 2, 203);
        addAtEast("Ghee Kanta", 1, 88);
        addAtEast("Kalupur railway station", 2, 203);
        addAtEast("Kankariya east", 1, 88);
        addAtEast("Apparel Park", 2, 203);
        addAtEast("Amraiwadi", 1, 88);
        addAtEast("Rabari colony", 1, 36);
        addAtEast("Vastral", 1, 88);
        addAtEast("Nirant cross road", 1, 88);
        addAtEast("Vastral Gam", 1, 42);
        addAtWest("Stadium", 1, 88);
        addAtWest("Commerce Six Road", 1, 88);
        addAtWest("Gujrat University", 1, 88);
        addAtWest("Gurukul road", 1, 88);
        addAtWest("Doordarshan Kendra", 1, 88);
        addAtWest("Thaltej", 1, 88);
        addAtWest("Thaltej Gam", 1, 42);
        addAtNorth("UsmanPura", 1, 109);
        addAtNorth("VijayNagar", 1, 109);
        addAtNorth("Vadaj", 1, 109);
        addAtNorth("Ranip", 1, 109);
        addAtNorth("Sabarmati Railway Station", 1, 109);
        addAtNorth("AEC", 1, 109);
        addAtNorth("Sabarmati", 1, 109);
        addAtNorth("Motera Stadiam", 1, 109);
        addAtSouth("Gandhigram", 1, 109);
        addAtSouth("Paldi", 1, 109);
        addAtSouth("Shreyas", 1, 109);
        addAtSouth("Rajivnagar", 1, 109);
        addAtSouth("Jivraj", 1, 109);
        addAtSouth("APMC", 1, 109);
    }

    void East_West_corridor_display() {
        Stations temp1 = Interchange.west;
        Stations temp2 = Interchange.east;
        while (temp1.next_Station != null) {
            temp1 = temp1.next_Station;
        }
        while (temp1.prev_Station != null) {
            System.out.print(temp1.Station_name + "--->");
            temp1 = temp1.prev_Station;
        }
        System.out.print(Interchange.Station_name + "(Interchanger Point)--->");
        while (temp2 != null) {
            System.out.print(temp2.Station_name + "--->");
            temp2 = temp2.next_Station;
        }
        System.out.println("East-West corridor terminal point");
    }

    void North_South_corridor_display() {
        Stations temp1 = Interchange.north;
        Stations temp2 = Interchange.south;
        while (temp1.next_Station != null) {
            temp1 = temp1.next_Station;
        }
        while (temp1.prev_Station != null) {
            System.out.print(temp1.Station_name + "--->");
            temp1 = temp1.prev_Station;
        }
        System.out.print(Interchange.Station_name + "(Interchanger Point)--->");
        while (temp2 != null) {
            System.out.print(temp2.Station_name + "--->");
            temp2 = temp2.next_Station;
        }
        System.out.println("North-South corridor terminal point");
    }

    int get_distance(String source, String destination) {
        Stations start;
        Stations end;
        int distance = 0;
        if (source.equals(Interchange.Station_name)) {
            start = Interchange;
            end = direction_checker(destination);
            distance += end.distance_prev;
        } else if (destination.equals(Interchange.Station_name)) {
            start = direction_checker(source);
            end = Interchange;
            distance += start.distance_prev;
        } else {
            start = direction_checker(source);
            end = direction_checker(destination);
            distance += start.distance_prev + end.distance_prev;
        }
        if (start == null || end == null) {
            System.out.println("Invalid station!");
            return -1;
        } else if (start == end) {
            distance = 0;
            while (start != null && (!start.Station_name.equals(source) && !start.Station_name.equals(destination))) {
                start = start.next_Station;
            }
            while (start != null && (!start.Station_name.equals(destination) || !start.Station_name.equals(source))) {
                distance += start.distance_next;
                start = start.next_Station;
            }
            return distance;
        }

        while (start != null && !start.Station_name.equals(source)) {
            distance += start.distance_next;
            start = start.next_Station;
        }
        while (end != null && !end.Station_name.equals(destination)) {
            distance += end.distance_next;
            end = end.next_Station;
        }
        return distance;
    }

    double get_time(String source, String destination) {
        Stations start;
        Stations end;
        int time = 0;
        if (source.equals(Interchange.Station_name)) {
            start = Interchange;
            end = direction_checker(destination);
            time += end.time_prev;
        } else if (destination.equals(Interchange.Station_name)) {
            start = direction_checker(source);
            end = Interchange;
            time += start.time_prev;
        } else {
            start = direction_checker(source);
            end = direction_checker(destination);
            time += start.time_prev + end.time_prev;
        }
        if (start == null || end == null) {
            System.out.println("Invalid station!");
            return -1;
        } else if (start == end) {
            time = 0;
            while (start != null && (!start.Station_name.equals(source) && !start.Station_name.equals(destination))) {
                start = start.next_Station;
            }
            while (start != null && (!start.Station_name.equals(destination) || !start.Station_name.equals(source))) {
                time += start.time_next;
                start = start.next_Station;
            }
            return time / 60;
        }

        while (start != null && !start.Station_name.equals(source)) {
            time += start.time_next;
            start = start.next_Station;
        }
        while (end != null && !end.Station_name.equals(destination)) {
            time += end.time_next;
            end = end.next_Station;
        }
        return time / 60;
    }

    Stations direction_checker(String station) {
        if (east.contains(station)) {
            return Interchange.east;
        } else if (west.contains(station)) {
            return Interchange.west;
        } else if (north.contains(station)) {
            return Interchange.north;
        } else if (south.contains(station)) {
            return Interchange.south;
        } else {
            return null;
        }
    }

    int get_fare(String station1, String Station2) {
        int fare = 0;
        int distance = get_distance(station1, Station2);
        if (distance <= 5)
            fare = 10;
        else if (distance <= 10)
            fare = 15;
        else if (distance <= 13)
            fare = 20;
        else
            fare = 30;
        return fare;
    }
}