package school.schedule;

import school.subject.StartingYear;
import school.subject.Subject;
import java.io.*;
import java.util.ArrayList;

public class Schedule {
    String arr[] = new String[1000];
    int numberofclass;
    ArrayList<ArrayList<Subject>> timetable = new ArrayList<ArrayList<Subject>>(5);

    public Schedule(String fileName) {
        File f = new File(fileName);
        if (!f.exists() || !fileName.startsWith("schedule")) {
            throw new IllegalArgumentException("File does not exist");
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            numberofclass = Integer.parseInt(reader.readLine());
            int counter = 0;
            String Linecounter = reader.readLine();
            while (Linecounter != null) {
                if (Linecounter.isEmpty()) {
                    Linecounter = reader.readLine();
                } else {
                    Linecounter = reader.readLine();
                    counter++;
                }
            }

            for (int i = 0; i < 5; i++) {
                timetable.add(new ArrayList<Subject>(numberofclass));
            }

            if (counter % 5 == 0) {
                String a = br.readLine();
                if (a == null) {
                    throw new IllegalStateException("Empty file");
                }
                for (int i = 0; i < numberofclass; i++) {
                    String tempo;
                    for (int j = 0; j < 5; j++) {
                        while ((tempo = br.readLine().trim()).isEmpty()) {}
                        timetable.get(j).add(i, Subject.valueOf(tempo));
                    }
                }
                reader.close();
                br.close();
            } else {
                throw new IllegalStateException("Incorrect file format");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Subject> getClassPerDay(int x) {
        return timetable.get(x);
    }

    public Subject get1(int day, int cls) {
        return timetable.get(day).get(cls);
    }

    public Boolean isSuitableForYear(int grade) {
        for (int i = 0; i < numberofclass; i++) {
            for (int j = 0; j < 5; j++) {
                if (StartingYear.values()[timetable.get(j).get(i).ordinal()].getYear() > grade) {
                    return false;
                }
            }
        }
        return true;
    }
}
