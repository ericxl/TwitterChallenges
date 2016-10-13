import java.io.BufferedWriter;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Eric on 10/12/2016.
 */
public class Solution {
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser, int minLikeThreshold){
        ArrayList<Integer> peopleTargetFollow = new ArrayList<>();
        for(int[] follow : followGraph_edges){
            if(follow[0] == targetUser){
                peopleTargetFollow.add(new Integer(follow[1]));
            }
        }
        HashMap<Integer, Integer> likes = new HashMap<>();
        for (int[] like : likeGraph_edges ) {
            if(peopleTargetFollow.contains(like[0])){
                if(likes.containsKey(new Integer(like[1]))){
                    Integer s = likes.get(new Integer(like[1]));
                    s = s +1;
                    likes.put(new Integer(like[1]), s);
                } else{
                    likes.put(new Integer(like[1]), new Integer(1));
                }
            }
        }

        return null;
    }
    public static void main(String[] args){
        Scanner in = new Scanner("4 3\n" +
                "1 2\n" +
                "1 3\n" +
                "1 4\n" +
                "5 6\n" +
                "2 10\n" +
                "3 10\n" +
                "4 10\n" +
                "2 11\n" +
                "3 12\n" +
                "4 11\n" +
                "1\n" +
                "3\n");

        String[] _followGraph_nodesm = in.nextLine().split(" ");
        int _followGraph_nodes = Integer.parseInt(_followGraph_nodesm[0]);
        int _followGraph_edges = Integer.parseInt(_followGraph_nodesm[1]);

        int[] _followGraph_from = new int[_followGraph_edges];
        int[] _followGraph_to = new int[_followGraph_edges];

        for (int _followGraph_i = 0; _followGraph_i < _followGraph_edges; _followGraph_i++) {
            String[] _followGraph_fromv = in.nextLine().split(" ");
            _followGraph_from[_followGraph_i] = Integer.parseInt(_followGraph_fromv[0]);
            _followGraph_to[_followGraph_i] = Integer.parseInt(_followGraph_fromv[1]);
        }


        String[] _likeGraph_nodesm = in.nextLine().split(" ");
        int _likeGraph_nodes = Integer.parseInt(_likeGraph_nodesm[0]);
        int _likeGraph_edges = Integer.parseInt(_likeGraph_nodesm[1]);

        int[] _likeGraph_from = new int[_likeGraph_edges];
        int[] _likeGraph_to = new int[_likeGraph_edges];

        for (int _likeGraph_i = 0; _likeGraph_i < _likeGraph_edges; _likeGraph_i++) {
            String[] _likeGraph_fromv = in.nextLine().split(" ");
            _likeGraph_from[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[0]);
            _likeGraph_to[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[1]);
        }

        // generate follow Graph
        int[][] followGraph = new int[_followGraph_edges][2];
        for (int i = 0; i < _followGraph_edges; i++) {
            followGraph[i][0] = _followGraph_from[i];
            followGraph[i][1] = _followGraph_to[i];
        }
        // generate like Graph
        int[][] likeGraph = new int[_likeGraph_edges][2];
        for (int i = 0; i < _likeGraph_edges; i++) {
            likeGraph[i][0] = _likeGraph_from[i];
            likeGraph[i][1] = _likeGraph_to[i];
        }
        int _targetUser;
        _targetUser = Integer.parseInt(in.nextLine().trim());

        int _minLikeThreshold;
        _minLikeThreshold = Integer.parseInt(in.nextLine().trim());

        int[]res = getRecommendedTweets(followGraph, likeGraph, _targetUser, _minLikeThreshold);
    }
}
