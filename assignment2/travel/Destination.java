package assignment2.travel;

public enum Destination { BERLIN("01:34"),
                          ROME("01:45"),
                          AMSTERDAM("02:05"),
                          PARIS("02:20"),
                          HELSINKI("02:43");
public final String label;
private Destination (String label){
    this.label=label;
}
  public String getLabel() 
  {
      return this.label;
   }
}