using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace LongestPhrases
{
    public class Program
    {
        public
        static int maxLength(int[] a, int k)
        {
            if (a == null || a.Length == 0 || k == 0)
            {
                return 0;
            }

            var front = 0;
            var tail = 0;
            var result = 0;
            var currentSum = 0;
            while (tail < a.Length)
            {
                currentSum += a[tail];

                if (currentSum > k)
                {
                    currentSum = currentSum - a[front];
                    front++;
                    tail++;
                }
                else
                {
                    tail++;
                    result++;
                }
            }
            return result;
        }

        static void Main(string[] args)
        {
            var arr = new int[]{1, 2, 3};
            var s = maxLength(arr, 4);
            int x = 0;
        }
    }
}
