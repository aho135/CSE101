import java.util.HashSet;
import java.util.ArrayList;

public class HW1
{
  
  private class Pair{
    int x;
    int y;

    public Pair(int x, int y)
    {
      this.x = x;
      this.y = y;
    }

    public boolean equals(Object o)
    {
      if (o instanceof Pair)
      {
        Pair p = (Pair)o;
        return p.x == x && p.y == y;
      }
      return false;
    }

    public int hashCode()
    {
      return new Integer(x).hashCode() * 31 + new Integer(y).hashCode();
    }

  }
  
  public  boolean existTriangle(int [][] arr)
  {
    HashSet<Pair> set = new HashSet<Pair>();
    ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();

    for (int i = 0; i < arr.length; i++)
    {
      ArrayList<Pair> level = new ArrayList<Pair>();
      
      for (int j = 0; j < arr.length; j++)
      {
        if (arr[i][j] == 1)
        {
          Pair p = new Pair(i,j);
          level.add(p);
          set.add(p);
        }
      }
      list.add(level);
    }
    
    for (int i = 0; i < list.size(); i++)
    {
      ArrayList<Pair> level = list.get(i);
      ArrayList<Integer> values = new ArrayList<Integer>();

      for (int j = 0; j < level.size(); j++)
      {
        values.add(level.get(j).y);
      }
      
      for (int j = 0; j < values.size(); j++)
      {
        for (int k = j + 1; k < values.size(); k++)
        {
          Pair p = new Pair(values.get(j),values.get(k));
          if (set.contains(p))
          {
            return true;
          }
        }
      }
    }

    return false;
  }
  
  
  public static void main(String [] args)
  {
    HW1 hw = new HW1();
    int [][] arr = new int[][]{ {0,1,1},{1,0,1},{1,1,0} };
    
    int [][] arr1 = new int[][] { {0,1,0,0,0}, {1,0,1,1,0}, {0,1,0,1,1}, {0,1,1,0,1}, {0,0,1,1,0}};
    
    
    System.out.println(hw.existTriangle(arr));
    System.out.println(hw.existTriangle(arr1));
  }

}
