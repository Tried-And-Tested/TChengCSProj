public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	private Object data;
	
	public Node(int key, Object data)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
		this.data = data;
	}
	
	public Node(int key)
	{
		this(key, null);
	}
	
	public int getKey()
	{
		return key;
	}
	
	public Node getParent()
	{
		return parent;
	}
	
	public Node getLeft()
	{
		return left;
	}
	
	public Node getRight()
	{
		return right;
	}
	
	public void setLeft(Node n)
	{
		this.left = n;
	}
	
	public void setRight(Node n)
	{
		this.right = n;
	}
	
	public void setParent(Node n)
	{
		this.parent = n;
	}
	
	public String toString()
	{
		StringBuilder str =  new StringBuilder();
		str.append("(" + key + ",");
		if(parent !=null) {
			str.append(parent.key);
		}
		str.append(",");
		if(getLeft() !=null) {
			str.append(left.key);
		}
		str.append(",");
		if(getRight() !=null) {
			str.append(right.key);
		}
		str.append(")");
		return str.toString();
	}
	
	public boolean equals(Object o)
	{
		if(o.getClass() == this.getClass()) {
			Node comp = (Node) o;
			return comp.getKey() == this.getKey();
		}
		return false;
	}
	
	public Object getData()
	{
		return data;
	}
	
	public void setData(Object o)
	{
		data = o;
	}
}
