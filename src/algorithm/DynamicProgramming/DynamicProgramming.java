package algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DynamicProgramming {
  static FastReader scan = new FastReader();
  static StringBuilder sb = new StringBuilder();

  static int N;
  static int[] Dy;

  static void input() {
    N = scan.nextInt();
  }

  // Dy[][] 를 미리 계산해 놓기
  static void preprocess() {
    // Dy[i][k] :=

    /* TODO */
    // 초기값 구하기
    Dy[1] = 1;
    Dy[2] = 2;
    Dy[3] = 4;

    // 점화식을 토대로 Dy 배열 채우가
    for (int i = 4; i <= 11; i++) {
      Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
    }
  }

  static void pro() {
    Dy = new int[15];
    preprocess();
  }

  public static void main(String[] args) {
    input();
    pro();
    System.out.println(Dy[N]);
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
