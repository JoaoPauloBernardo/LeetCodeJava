package Array;
import java.sql.Array;
import java.util.Arrays;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> Integer.compare(score[b], score[a]));

        String[] ranks = new String[n];
        String[] medalhas = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        //tem que ser em ingles se nao o leetcode nao aceita
        for(int i=0; i < n; i++){
            if(i<3){
                ranks[indices[i]] = medalhas[i];
            } //para caso seja ganhador de medalha
            else{
                ranks[indices[i]] = String.valueOf(i + 1);
            }
        }
    return ranks;
    }
}
