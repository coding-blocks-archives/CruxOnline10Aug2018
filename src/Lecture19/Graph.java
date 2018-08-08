package Lecture19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVetex() {
		return this.vtces.size();
	}

	public boolean containsVertex(String vname) {
		return this.vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());

		for (String key : keys) {

			Vertex nbrVtx = vtces.get(key);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;

		for (String key : keys) {

			Vertex vtx = vtces.get(key);
			count = count + vtx.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1); // 2k
		Vertex vtx2 = vtces.get(vname2); // 4k

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("------------------");
		ArrayList<String> vnames = new ArrayList<>(vtces.keySet());

		for (String vname : vnames) {

			String str = vname + " => ";

			Vertex vtx = vtces.get(vname);
			str += vtx.nbrs;

			System.out.println(str);
		}
		System.out.println("------------------");

	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

		// direct edge
		if (containsEdge(vname1, vname2)) {
			return true;
		}

		processed.put(vname1, true);

		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		for (String nbr : nbrs) {

			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed))
				return true;
		}

		return false;
	}

	private class Pair {

		String vname;
		String psf;
	}

	public boolean bfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		queue.addLast(sp);

		// while queue is not empty keep on doing the work
		while (!queue.isEmpty()) {

			// remove a pair from queue
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean dfs(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;

		// put the new pair in queue
		stack.addFirst(sp);

		// while queue is not empty keep on doing the work
		while (!stack.isEmpty()) {

			// remove a pair from queue
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			// de
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// nbrs
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			// loop on nbrs
			for (String nbr : nbrs) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			stack.addFirst(sp);

			// while queue is not empty keep on doing the work
			while (!stack.isEmpty()) {

				// remove a pair from queue
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}

	}

	public boolean isCyclic() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

		return false;

	}

	public boolean isConnected() {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

		if (flag >= 2) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(vtces.keySet());

		// for every node repeat the process
		for (String key : keys) {

			if (processed.containsKey(key)) {
				continue;
			}

			// for new component create a new arrayList
			ArrayList<String> subans = new ArrayList<>();

			// create a new pair
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;

			// put the new pair in queue
			queue.addLast(sp);

			// while queue is not empty keep on doing the work
			while (!queue.isEmpty()) {

				// remove a pair from queue
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// processed put
				processed.put(rp.vname, true);

				// put in subans arraylist
				subans.add(rp.vname);

				// nbrs
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

				// loop on nbrs
				for (String nbr : nbrs) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a new pair of nbr and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

			// put subans in final ans
			ans.add(subans);

		}

		return ans;

	}

}
