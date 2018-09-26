package edii;

import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import tratacolisao.*;

class Main {

  public static void main(String[] args){
    //Deputies[] dep = Loader.loadRandomList("deputies_dataset.csv", 10);
    /*double[] array = {6, 5, 3, 1, 8, 7, 2, 4, 20, 0, 15, 36, -3, -56};
    (new InsertionSort()).sort(array);
    System.out.println(Arrays.toString(array));*/
    scn2();
  }

  public static void scn1(){
    int n = 100000;
    for(int i = 5; i < 6; i++){
      if(i%2==0) n *= 2;
      else n *= 5;

      double[] sumComp = new double[3];
      double[] sumCopy = new double[3];
      double[] sumTime = new double[3];
      for(int j = 0; j < 5; j++){
        Deputies[] dep = Loader.loadRandomList("deputies_dataset.csv", n);

        //DOUBLE
        double[] d1 = new double[dep.length];
        for(int k = 0; k < dep.length; k++){
          d1[k] = dep[k].getValue();
        }
        QuickSort qs1 = new QuickSort();
        qs1.sort(d1);
        sumComp[0] += qs1.getComp();
        sumCopy[0] += qs1.getCopy();
        sumTime[0] += qs1.getTime();
        System.out.println("N="+n+" "+(sumComp[0])+" "+(sumCopy[0])+" "+(sumTime[0]));

        //INT
        int[] d2 = new int[dep.length];
        for(int k = 0; k < dep.length; k++){
          d2[k] = dep[k].getID();
        }
        QuickSortI qs2 = new QuickSortI();
        qs2.sort(d2);
        sumComp[1] += qs2.getComp();
        sumCopy[1] += qs2.getCopy();
        sumTime[1] += qs2.getTime();
        System.out.println("N="+n+" "+(sumComp[1])+" "+(sumCopy[1])+" "+(sumTime[1]));

        //STRING
        String[] d3 = new String[dep.length];
        for(int k = 0; k < dep.length; k++){
          d3[k] = dep[k].getDate();
        }
        QuickSortS qs3 = new QuickSortS();
        qs3.sort(d3);
        sumComp[2] += qs3.getComp();
        sumCopy[2] += qs3.getCopy();
        sumTime[2] += qs3.getTime();
        System.out.println("N="+n+" "+(sumComp[2])+" "+(sumCopy[2])+" "+(sumTime[2]));
      }
      printToFile("results.txt", n+" "+(sumComp[0]/5)+" "+(sumCopy[0]/5)+" "+(sumTime[0]/5)+"\n");
      printToFile("results.txt", n+" "+(sumComp[1]/5)+" "+(sumCopy[1]/5)+" "+(sumTime[1]/5)+"\n");
      printToFile("results.txt", n+" "+(sumComp[2]/5)+" "+(sumCopy[2]/5)+" "+(sumTime[2]/5)+"\n\n");
    }
  }

  public static void scn2(){
    int n = 500;
    for(int i = 0; i < 6; i++){
      if(i%2==0) n *= 2;
      else n *= 5;

      double[] sumComp = new double[3];
      double[] sumCopy = new double[3];
      double[] sumTime = new double[3];
      for(int j = 0; j < 5; j++){
        Deputies[] dep = Loader.loadRandomList("deputies_dataset.csv", n);

        int[] d1 = new int[dep.length];
        int[] d2 = new int[dep.length];
        int[] d3 = new int[dep.length];
        for(int k = 0; k < dep.length; k++){
          d1[k] = d2[k] = d3[k] = dep[k].getID();
        }

        //RECURSIVE
        QuickSortI qs1 = new QuickSortI();
        qs1.sort(d1, "R");
        sumComp[0] += qs1.getComp();
        sumCopy[0] += qs1.getCopy();
        sumTime[0] += qs1.getTime();
        System.out.println("N="+n+" "+(sumComp[0])+" "+(sumCopy[0])+" "+(sumTime[0]));

        //MEDIAN
        QuickSortI qs2 = new QuickSortI();
        qs2.sort(d2, "M");
        sumComp[1] += qs2.getComp();
        sumCopy[1] += qs2.getCopy();
        sumTime[1] += qs2.getTime();
        System.out.println("N="+n+" "+(sumComp[1])+" "+(sumCopy[1])+" "+(sumTime[1]));

        //TAIL RECURSION (INSERTION)
        QuickSortI qs3 = new QuickSortI();
        qs3.sort(d3, "I");
        sumComp[2] += qs3.getComp();
        sumCopy[2] += qs3.getCopy();
        sumTime[2] += qs3.getTime();
        System.out.println("N="+n+" "+(sumComp[2])+" "+(sumCopy[2])+" "+(sumTime[2]));
      }
      printToFile("resultsQ.txt", n+" "+(sumComp[0]/5)+" "+(sumCopy[0]/5)+" "+(sumTime[0]/5)+"\n");
      printToFile("resultsQ.txt", n+" "+(sumComp[1]/5)+" "+(sumCopy[1]/5)+" "+(sumTime[1]/5)+"\n");
      printToFile("resultsQ.txt", n+" "+(sumComp[2]/5)+" "+(sumCopy[2]/5)+" "+(sumTime[2]/5)+"\n\n");
    }
  }

  public static void scn3(){
    int n = 500;
    for(int i = 0; i < 6; i++){
      if(i%2==0) n *= 2;
      else n *= 5;

      double[] sumComp = new double[5];
      double[] sumCopy = new double[5];
      double[] sumTime = new double[5];
      for(int j = 0; j < 5; j++){
        Deputies[] dep = Loader.loadRandomList("deputies_dataset.csv", n);

        int[] d1 = new int[dep.length];
        int[] d2 = new int[dep.length];
        int[] d3 = new int[dep.length];
        int[] d4 = new int[dep.length];
        int[] d5 = new int[dep.length];
        for(int k = 0; k < dep.length; k++){
          d1[k] = d2[k] = d3[k] = d4[k] = d5[k] = dep[k].getID();
        }

        //QUICK (BEST)
        QuickSortI qs = new QuickSortI();
        qs.sort(d1, "I");
        sumComp[0] += qs.getComp();
        sumCopy[0] += qs.getCopy();
        sumTime[0] += qs.getTime();
        System.out.println("N="+n+" "+(sumComp[0])+" "+(sumCopy[0])+" "+(sumTime[0]));

        //INSERTION
        InsertionSort is = new InsertionSort();
        is.sort(d2);
        sumComp[1] += is.getComp();
        sumCopy[1] += is.getCopy();
        sumTime[1] += is.getTime();
        System.out.println("N="+n+" "+(sumComp[1])+" "+(sumCopy[1])+" "+(sumTime[1]));

        //HEAP
        HeapSort hs = new HeapSort();
        hs.sort(d3);
        sumComp[2] += hs.getComp();
        sumCopy[2] += hs.getCopy();
        sumTime[2] += hs.getTime();
        System.out.println("N="+n+" "+(sumComp[2])+" "+(sumCopy[2])+" "+(sumTime[2]));

        //MERGE
        Merge ms = new Merge();
        ms.sort(d4);
        sumComp[3] += ms.getComp();
        sumCopy[3] += ms.getCopy();
        sumTime[3] += ms.getTime();
        System.out.println("N="+n+" "+(sumComp[3])+" "+(sumCopy[3])+" "+(sumTime[3]));

        //SHELL
        Shell ss = new Shell();
        ss.sort(d5);
        sumComp[4] += ss.getComp();
        sumCopy[4] += ss.getCopy();
        sumTime[4] += ss.getTime();
        System.out.println("N="+n+" "+(sumComp[4])+" "+(sumCopy[4])+" "+(sumTime[4]));
      }
      printToFile("resultsT.txt", n+" "+(sumComp[0]/5)+" "+(sumCopy[0]/5)+" "+(sumTime[0]/5)+"\n");
      printToFile("resultsT.txt", n+" "+(sumComp[1]/5)+" "+(sumCopy[1]/5)+" "+(sumTime[1]/5)+"\n");
      printToFile("resultsT.txt", n+" "+(sumComp[2]/5)+" "+(sumCopy[2]/5)+" "+(sumTime[2]/5)+"\n");
      printToFile("resultsT.txt", n+" "+(sumComp[3]/5)+" "+(sumCopy[3]/5)+" "+(sumTime[3]/5)+"\n");
      printToFile("resultsT.txt", n+" "+(sumComp[4]/5)+" "+(sumCopy[4]/5)+" "+(sumTime[4]/5)+"\n\n");
    }
  }

  private static Deputies[] normalize(Deputies[] dep){
    ArrayList<Deputies> depUnique = new ArrayList<>();
    for(Deputies d0 : dep){
      boolean contains = false;
      for(Deputies d : depUnique){
        if(d0.getIDDep() == d.getIDDep()){
          contains = true;
          d.setValue(d.getValue() + d0.getValue());
          break;
        }
      }
      if(!contains){
        depUnique.add(d0);
      }
    }
    dep = new Deputies[depUnique.size()];
    return (depUnique.toArray(dep));
  }

  private static void printToFile(String filename, String data){
    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new FileWriter(filename, true));
      bw.write(data);
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try {
        if(bw!=null) bw.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
