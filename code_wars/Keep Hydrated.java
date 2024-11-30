public class KeepHydrated  {

  public int Liters(double time)  {
      int water_value = (int) Math.round(time * 0.5);
      return water_value;
    }
}