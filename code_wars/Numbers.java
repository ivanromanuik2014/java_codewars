public class Numbers
{
  public static double TwoDecimalPlaces(double number)
  {
    return Math.round(number * 100.0d) / 100.0d;
  }
}