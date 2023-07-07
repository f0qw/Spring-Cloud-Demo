package leetcode.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> st = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        st.add(1);
        q.add(1);
        int[] fac = new int[]{2,3,5};
        int res = 0;
        for(int i = 0 ; i  < n ; i++){
            res = q.poll();
            for (int f : fac) {
                if (st.add(f * res)){
                    q.add(f * res);
                }
            }
        }
        return res;

    }
}