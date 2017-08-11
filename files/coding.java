import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class coding {

	// Question 1

	public String longestPalindrome(String str) {

		int len = 0;
		String res = "";

		for (int i = 0; i < str.length(); i++) {
			if (isPalindrome(str, i - len - 1, i)) {
				len += 2;
				res = str.substring(i-len+1, i+1);
			} else if (isPalindrome(str, i - len, i)) {
				len += 1;
				res = str.substring(i-len+1,i+1);
			}
		}

		return res;
	}

	private boolean isPalindrome(String st, int start, int end) {
		if (start > end || start < 0 || end >= st.length()) return false;
		while (start < end) {
			if (st.charAt(start) != st.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}







	// 	Question 2

	public int[] removeDupArray(int[] a) {
		Set<Integer> iset = new HashSet<>();
		// List<Integer> l = new ArrayList<>();
		for (int i: a) {
			iset.add(i);
		}
		int[] res = new int[iset.size()];
		int j = 0;
		for (Integer i : iset) {
			res[j++] = i;
		}
		return res;

	}







	// Question 3

	public Character highestOccurence(String str) {

		int maxCnt = 0;
		Map<Character, Integer> imap = new HashMap<>();
		// char res = ' ';
		Character res = null;


		for (char ch: str.toCharArray()) {
			int cnt = imap.getOrDefault(ch, 0);
			imap.put(ch, cnt+1);
			if (imap.get(ch) > maxCnt) {
				res = ch;
				maxCnt = imap.get(ch);
			}
		}

		return res;

	}

	private Set<Character>[] mapToBucket(Map<Character, Integer> imap, int maxCnt) {

		Set<Character>[] bucket = new Set[maxCnt+1];

		for (Character ch : imap.keySet()) {
			if (bucket[imap.get(ch)] == null) {
				bucket[imap.get(ch)] = new HashSet<Character>();
			}
			bucket[imap.get(ch)].add(ch);
		}

		return bucket;
	}





	// Question 4

	public String removeChar(String str, char ch) {

		StringBuilder sb = new StringBuilder();

		for (char chr: str.toCharArray()) {
			if (chr != ch) sb.append(chr);
		}

		return sb.toString();

	}





	// Question 5

	public List<Integer> findCommon(List<List<Integer>> l) {
		return findCommon(l, 0, l.size()-1);
	}

	private List<Integer> findCommon(List<List<Integer>> l, int start, int end) {

		if (start > end) return new ArrayList<Integer>();
		if (start == end) return l.get(start);

		int m = start + (end - start)/2;
		List<Integer> left = findCommon(l, start, m);
		List<Integer> right = findCommon(l, m+1, end);

		return merge(left, right);
	}

	private List<Integer> merge(List<Integer> num1, List<Integer> num2) {

		List<Integer> res = new ArrayList<>();

		int i=0, j=0;

		while (i < num1.size() && j < num2.size()) {
			int iv = num1.get(i);
			int jv = num2.get(j);
			if (iv < jv) i++;
			else if (iv > jv) j++;
			else {
				res.add(iv);
				i++;
				j++;
			}
		}
		return res;
	}





	// Question 6

	public int findMaxSubarray(int[] nums) {

		int res = Integer.MIN_VALUE;
		int prev = 0;

		for (int n : nums) {
			prev = Math.max(prev + n, n);
			res = Math.max(prev, res);
		}

		return res;
	}





	// Question 7

	public String reverseString(String str) {

		char[] ch = str.toCharArray();

		int i = 0, j = ch.length - 1;

		while (i < j) {
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
			i++;
			j--;
		}

		return String.valueOf(ch);

	}






	// Question 8

	public String lineMaxWordCnt(String fileName) {

		String cur = null, res = null;
		int cnt = 0;

		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			while ((cur = br.readLine()) != null) {
				if (cur.split("\\s+").length > cnt) {
					res = cur;
					cnt = cur.split("\\s+").length;
				}
				// System.out.println(cur);
				// cnt++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
		// return cnt;
	}





	// Question 9

	public int reverseNumber(int num) {
		int res = 0;

		while (num > 0) {
			int r = num % 10;
			num /= 10;
			res = res * 10 + r;
		}

		return res;
	}





	// Question 10

	public String removeVowels(String str) {
		StringBuilder sb = new StringBuilder();
		// String vowel = "aeiou";
		Set<Character> iset = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		for (char ch: str.toCharArray()) {
			if (!iset.contains(ch)) sb.append(ch);
		}
		return sb.toString();
	}





	// Question 11

	public List<String> stringPermutation(String str) {
		List<String> res = new ArrayList<String>();

		char[] ch = str.toCharArray();
		Arrays.sort(ch);

		dfs(ch, "", res, new boolean[str.length()]);

		return res;
	}

	private void dfs(char[] str, String s, List<String> tmp, boolean[] visited) {
		if (s.length() == str.length) {
			tmp.add(new String(s));
			return;
		}
		for (int i = 0; i < str.length; i++) {
			if (visited[i] || (i != 0 && str[i] == str[i-1] && !visited[i-1])) continue;
			visited[i] = true;
			// s += str[i];
			dfs(str, s + str[i], tmp, visited);
			// s = s.substring(0,s.length()-1);
			visited[i] = false;
		}

	}






	// Question 12

	public Map<String, Double> percentChar(String s) {
		Map<String, Double> imap = new HashMap<>();
		double digit = 0, upper = 0, lower = 0, special = 0;
		int sz = s.length();

		for (char ch : s.toCharArray()) {
			if (ch <= '9' && ch >= '0') digit++;
			else if (ch <= 'Z' && ch >= 'A') upper++;
			else if (ch <= 'z' && ch >= 'a') lower++;
			else if (ch != ' ') special++;
		}

		imap.put("upper", upper * 100 / sz);
		imap.put("lower", lower * 100 / sz);
		imap.put("digit", digit * 100 / sz);
		imap.put("special", special * 100 / sz);

		return imap;

	}






	// Question 13

	public String removeDup(String str) {

		StringBuilder sb = new StringBuilder();
		Set<Character> iset = new HashSet<>(); 

		for (char ch: str.toCharArray()) {
			if (iset.add(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}






	// Question 14

	public String removeNum(String str) {

		StringBuilder sb = new StringBuilder();

		for (char ch: str.toCharArray()) {
			if (!Character.isDigit(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();

	}






	// Question 15

	public Map<String, Integer> cntDupWords(String str) {

		String[] s = str.split("\\s+");
		Map<String, Integer> imap = new HashMap<>();

		for (String sub : s) {
			int cnt = imap.getOrDefault(sub, 0);
			imap.put(sub, cnt+1);
		}

		imap.entrySet().removeIf(e -> e.getValue() == 1);

		return imap;

	}





	// Question 16

	public int cntChar(String str, char c) {

		// char[] ch = str.toCharArray();
		// List<Character> l = Arrays.asList(ch);

		return (int) str.chars().mapToObj(i -> (char)i).filter(i -> i == c).count();
	}






	// Question 17

	public boolean anagramString(String str1, String str2) {

		if (str1.length() != str2.length()) return false;
		int[] ch = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			ch[(int)str1.charAt(i)]++;
			ch[(int)str2.charAt(i)]--;
		}

		int res = 0;
		for (int i = 0; i < 256; i++) {
			if (ch[i] != 0) return false;
		}
			return true;
	}





	// Question 18

	public int cntVowels(String str) {

		String v = "aeiouAEIOU";
		int res = 0;

		for (char ch: str.toCharArray()) {
			if (v.contains(ch + "")) {
				res++;
				System.out.println(ch);
			}
		}

		return res;

	}





	// Question 19

	public String sortString(String str) {

		StringBuilder sb = new StringBuilder();
		int[] cnt = new int[256];

		for (char ch: str.toCharArray()) {
			cnt[(int)ch]++;
		}

		for (int i = 0; i < 256; i++) {
			for (int j = 0; j < cnt[i]; j++) {
				sb.append((char)i);
			}
		}

		return sb.toString();

	}





	// Question 20

	public String reverseSentence(String str) {

		String res = "", tmp = " ";
		int i = 0;

		while (i < str.length()) {
			if (str.charAt(i) == ' ') {
				if (tmp.length() > 1) {
					res = tmp + res;
					tmp = " ";
				}
			} else {
				tmp += str.charAt(i);
			}
			i++;
		}

		if (tmp.length() != 1) res = tmp + res;

		return res.length() == 0 ? res : res.substring(1,res.length()); 

	}





	public static void main(String[] args) {
		coding c = new coding();
		// System.out.println(c.longestPalindrome("abacaba"));
		// System.out.println(Arrays.asList(c.removeDupArray(new int[]{1,3,2,6,1,4,2,3})));
		// System.out.println(c.highestOccurence("abacaba"));
		// System.out.println(c.removeChar("abacaba", 'a'));
		// List<List<Integer>> input = new ArrayList<>();
		// input.add(Arrays.asList(1,5,10,20,40,80));
		// input.add(Arrays.asList(6,7,20,80,100));
		// input.add(Arrays.asList(3,4,15,20,20,30,70,80));
		// System.out.println(c.findCommon(input));
		// System.out.println(c.findMaxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		// System.out.println(c.reverseString("abcdefg"));
		// System.out.println(c.lineMaxWordCnt("test.txt"));
		// System.out.println(c.reverseNumber(10020));
		// System.out.println(c.removeVowels("abcrehoi"));
		// System.out.println(c.stringPermutation("abbc"));
		// System.out.println(c.percentChar("abc ABcr74"));
		// System.out.println(c.removeDup("abcacrea"));
		// System.out.println(c.removeNum("0bc1cr30"));
		// System.out.println(c.cntDupWords("I like using   key  and I also   like using    76"));
		// System.out.println(c.cntChar("abcabcad", 'a'));
		// System.out.println(c.anagramString("babc","cabb"));
		// System.out.println(c.cntVowels("baolwoca"));
		// System.out.println(c.sortString("hfsrahedshahah"));
		// System.out.println(c.reverseSentence("  Hello how  r   u ?  "));

		List<String> test = new ArrayList<String>();
		test.add("aaa");
		test.add("bbb");
		test.add("ccc");
		test.add("aaa");

		for (int i = 0; i < test.size(); i++) {
			if (test.get(i).equals("aaa")) test.remove(i);
		}

		System.out.println(test);

	}
}