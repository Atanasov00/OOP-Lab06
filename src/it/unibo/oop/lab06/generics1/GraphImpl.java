package it.unibo.oop.lab06.generics1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class GraphImpl<N> implements Graph<N> {

	
	private Set<N> nodes;
	private Set<Edge<N>> edges;
	
	public GraphImpl() {
		nodes = new HashSet<>();
		edges = new HashSet<>();
	}
	@Override
	public void addNode(N node) {
		this.nodes.add(node);
	}

	@Override
	public void addEdge(N source, N target) {
		this.edges.add(new Edge<>(source, target));
	}

	@Override
	public Set<N> nodeSet() {
		Set<N> outNodes = new HashSet<>(this.nodes);
		return outNodes;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> linkNodes = new HashSet<>();
		for(Edge<N> n: edges) {
			if(n.getSource() == node) {
				linkNodes.add(n.getTarget());
			}
		}
		return linkNodes;
	}

	@Override
	public List<N> getPath(N source, N target) {
		List<N> path = new LinkedList<>();
		N res = null, currentSource = source;
		while (res != target) {
			for(Edge<N> n: edges) {
				if(n.getSource() == currentSource) {
					path.add(n.getSource());
					if(n.getTarget() == target) {
						res = target;
						break;
					}
					else {
						currentSource = n.getTarget();
					}
				}
			}
		}
		path.add(res);
		return path;
	}

}
