using System;
using System.Diagnostics;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LongestPhrases;
namespace LongestPhrasesTests
{
    [TestClass]
    public class UnitTest
    {
        [TestMethod]
        public void TestMethod1()
        {
            var arr = new[] { 1, 2, 3 };
            Assert.AreEqual(2, Program.maxLength(arr, 4));
        }

        [TestMethod]
        public void TestMethod2()
        {
            var arr = new[] { 3, 1, 2, 1 };
            Assert.AreEqual(3, Program.maxLength(arr, 4));
        }

        [TestMethod]
        public void TestMethod3()
        {
            var stopWatch = new Stopwatch();
            stopWatch.Start();
            var arr = new[] { 74, 659, 931, 273, 545, 879, 924, 710, 441, 166, 493, 43, 988, 504, 328, 730, 841, 613, 304, 170, 710, 158, 561, 934, 100, 279, 817, 336, 98, 827, 513, 268, 811, 634, 980, 150, 580, 822, 968, 673, 394, 337, 486, 746, 229, 92, 195, 358, 2, 154, 709, 945, 669, 491, 125, 197, 531, 904, 723, 667, 550 };
            Assert.AreEqual(46, Program.maxLength(arr, 22337));
            Debug.Print("elasped is " + stopWatch.Elapsed.TotalMilliseconds * 1000000);
        }

        [TestMethod]
        public void TestMethod4()
        {
            int[] arr = null;
            Assert.AreEqual(0, Program.maxLength(arr, 4));
        }

        [TestMethod]
        public void TestMethod5()
        {
            var arr = new int[] { };
            Assert.AreEqual(0, Program.maxLength(arr, 4));
        }

        [TestMethod]
        public void TestMethod6()
        {
            var arr = new[] { 3, 1, 2, 1 };
            Assert.AreEqual(0, Program.maxLength(arr, 0));
        }
    }
}
