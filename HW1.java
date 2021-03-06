import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

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

  public void zeroMatrix(int [][] arr)
  {
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < arr.length; j++)
      {
        arr[i][j] = 0;
      }

    }
  }

  public void randMatrix(int [][] arr)
  {
    Random rand = new Random();

    int index = 1;
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < index; j++)
      {
        if (i == j)
        {
          arr[i][j] = 0;
          continue;
        }

        int val = rand.nextInt(2);
        arr[i][j] = val;
        arr[j][i] = val;
      }
      index++;
    }   
  }

  private void printMatrix(int [][] arr)
  {
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < arr.length; j++)
      {
        System.out.print(arr[i][j] + " ");
      }
      System.out.print("\n");
    }
  }

  public void oneMatrix(int [][] arr)
  {
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < arr.length; j++)
      {
        arr[i][j] = 1;
      }
    } 
  }

  public boolean existTriangle2(int [][] arr)
  {
    HashSet<Pair> set = new HashSet<Pair>();
    ArrayList<Pair> edges = new ArrayList<Pair>();

    int index = 1;
    for (int i = 0; i < arr.length; i++)
    {
      for (int j = 0; j < index; j++)
      {
        if (arr[i][j] == 1)
        {
          Pair p = new Pair(i,j);
          Pair p1 = new Pair(j,i);
          edges.add(p);
          set.add(p);
          set.add(p1);
        }
      }
      index++;
    }

    //iterate through edges array
    System.out.println("# of edges:" + edges.size());
    for (int i = 0; i < edges.size(); i++)
    {
      Pair edge = edges.get(i);

      for (int vertex = 0; vertex < arr.length; vertex++)
      {
        int xval = edge.x;
        int yval = edge.y;

        Pair p = new Pair(xval,vertex);
        Pair p1 = new Pair(yval,vertex);

        if (set.contains(p) && set.contains(p1))
        {
          return true;
        }
      }
    }
    return false;

  }

  public void bipartiteGraph(int [][] arr)
  {
    Random rand = new Random();
    
    //top right
    for (int i = 0; i < arr.length/2; i++)
    {
      for (int j = arr.length/2; j < arr.length; j++)
      {
        arr[i][j] = rand.nextInt(2);
      }
    }

    //bottom left
    for (int i = arr.length/2; i < arr.length; i++)
    {
      for (int j = 0; j < arr.length/2; j++)
      {
        arr[i][j] = rand.nextInt(2);
      }
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

    /*
       int [][] arr = new int[][]{ {0,1,1},{1,0,1},{1,1,0} };

       int [][] arr1 = new int[][] { {0,1,0,0,0}, {1,0,1,1,0}, {0,1,0,1,1}, {0,1,1,0,1}, {0,0,1,1,0}};
     */


    //int [][] arr = new int[(int)Math.pow(2,0)][(int)Math.pow(2,0)];
    int [][] arr1 = new int[(int)Math.pow(2,1)][(int)Math.pow(2,1)];
    int [][] arr2 = new int[(int)Math.pow(2,2)][(int)Math.pow(2,2)];
    int [][] arr3 = new int[(int)Math.pow(2,3)][(int)Math.pow(2,3)];
    int [][] arr4 = new int[(int)Math.pow(2,4)][(int)Math.pow(2,4)];
    int [][] arr5 = new int[(int)Math.pow(2,5)][(int)Math.pow(2,5)];
    int [][] arr6 = new int[(int)Math.pow(2,6)][(int)Math.pow(2,6)];
    int [][] arr7 = new int[(int)Math.pow(2,7)][(int)Math.pow(2,7)];
    int [][] arr8 = new int[(int)Math.pow(2,8)][(int)Math.pow(2,8)];
    int [][] arr9 = new int[(int)Math.pow(2,9)][(int)Math.pow(2,9)];
    int [][] arr10 = new int[(int)Math.pow(2,10)][(int)Math.pow(2,10)];
    int [][] arr11 = new int[(int)Math.pow(2,11)][(int)Math.pow(2,11)];

    //hw.randMatrix(arr);
    hw.randMatrix(arr1);
    hw.randMatrix(arr2);
    hw.randMatrix(arr3);
    hw.randMatrix(arr4);
    hw.randMatrix(arr5);
    hw.randMatrix(arr6);
    hw.randMatrix(arr7);
    hw.randMatrix(arr8);
    hw.randMatrix(arr9);
    hw.randMatrix(arr10);
    hw.randMatrix(arr11);
    long startTime = 0;
    long endTime = 0;
    long duration = 0;

    /*
       startTime = System.nanoTime();
       System.out.println(hw.existTriangle(arr));
       endTime = System.nanoTime();
       duration = (endTime - startTime);
       System.out.println(duration);

       startTime = System.nanoTime();
       System.out.println(hw.existTriangle(arr1));
       endTime = System.nanoTime();
       duration = (endTime - startTime);
       System.out.println(duration);
     */
    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle(arr1));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr2));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr3));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr4));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr5));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr6));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr7));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr8));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr9));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr10));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle(arr11));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    /*
       System.out.println(hw.existTriangle(arr));
       System.out.println(hw.existTriangle(arr1));
     */
    System.out.println("\nTesting existTriangle2");

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr1));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr2));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr3));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr4));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr5));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr6));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr7));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr8));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr9));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr10));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime(); 
    System.out.println(hw.existTriangle2(arr11));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    System.out.println("\nStarting runtime for bipartite graphs");

    
    hw.zeroMatrix(arr2);
    hw.zeroMatrix(arr3);
    hw.zeroMatrix(arr4);
    hw.zeroMatrix(arr5);
    hw.zeroMatrix(arr6);
    hw.zeroMatrix(arr7);
    hw.zeroMatrix(arr8);
    hw.zeroMatrix(arr9);
    hw.zeroMatrix(arr10);
    hw.zeroMatrix(arr11);
    
    hw.bipartiteGraph(arr2);
    hw.bipartiteGraph(arr3);
    hw.bipartiteGraph(arr4);
    hw.bipartiteGraph(arr5);
    hw.bipartiteGraph(arr6);
    hw.bipartiteGraph(arr7);
    hw.bipartiteGraph(arr8);
    hw.bipartiteGraph(arr9);
    hw.bipartiteGraph(arr10);
    hw.bipartiteGraph(arr11);
    
    System.out.println("Arr2");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr2));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr3");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr3));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr4");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr4));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr5");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr5));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr6");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr6));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr7");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr7));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr8");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr8));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr9");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr9));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr10");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr10));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    System.out.println("Arr11");
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr11));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
    
    /*
    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr1));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr2));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr3));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr4));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);


    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr5));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr6));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr7));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr8));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr9));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr10));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);

    startTime = System.nanoTime();
    System.out.println(hw.existTriangle2(arr11));
    endTime = System.nanoTime();
    duration = (endTime - startTime);
    System.out.println(duration);
*/
    /*
       hw.oneMatrix(arr2);
       hw.oneMatrix(arr3);
       hw.oneMatrix(arr4);
       hw.oneMatrix(arr5);
       hw.oneMatrix(arr6);
       hw.oneMatrix(arr7);
       hw.oneMatrix(arr8);
       hw.oneMatrix(arr9);
       hw.oneMatrix(arr10);
       hw.oneMatrix(arr11);
     */
  }

}
