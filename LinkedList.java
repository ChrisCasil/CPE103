import java.io.*;
import java.util.Iterator;

public class LinkedList
{

   private class Node
   {
      private Object item;
      private Node next;
      private Node prev;

      private Node(Object x)
      {
         item = x;
         next = null;
         prev = null;
      }
   }

   // Self explanatory instance variables

   private Node first;
   private Node last;

   // Default Constructor

   public LinkedList()
   {
      first = null;
      last = null;
   }

   // Insert the given object at the beginning of the list.

   public void addFirst(Object item)
   {
      // Supply details as in the assignment description
	   if (this.first == null && this.last == null){
		   Node insertFirst = new Node(item);
		   this.first = insertFirst;
		   this.last = insertFirst;
		   
	   }else{//inserts object to the beginning of the list
		   Node insertFirst = new Node(item);
		   insertFirst.next = this.first;
		   this.first.prev = insertFirst;
		   this.first = insertFirst;
	   }
   }

   // Insert the given object at the end of the list.

   public void addLast(Object item)
   {
      // Supply details as in the assignment description
	   if (this.first == null && this.last == null){
		   Node insertLast = new Node(item);
		   this.first = insertLast;
		   this.last = insertLast;
		   
	   }else{//inserts object to the end of the list
		   Node insertLast = new Node(item);
		   insertLast.prev = this.last;
		   this.last.next = insertLast;
		   this.last = insertLast;
	   }
   }

   // Return the number of items in the list

   public int length()
   {
      // Supply details as in the assignment description
	   if( this.isEmpty()){
		   return 0;
	   }
	   Node count = this.first;
	   int i = 1;
	   while(count.next != null){
		   count = count.next;
		   i++;
	   }
	   return i;
   }

   // Determine if the list contains no items

   public boolean isEmpty()
   {
      // Supply details as in the assignment description
	   if(this.first == null && this.last==null){
		   return true;
	   }else{
		   return false;
   }
}

   // (Virtually) remove all items from the list

   public void clear()
   {
      first = null;
      last = null;
   }

   // Determine if the list contains the given item

   public boolean contains(Object item)
   {
      // Supply details as in the assignment description
		if(this.isEmpty()){
			return false;
			}
	   Node count = this.first;
	   while(!count.item.equals(item)){
			 count = count.next;
			 if(count == null)
			 {
				 return false;
			 }
	    }
	    return true;
   }

   // Remove first item on the list and return it
   
   public Object removeFirst()
   {
      // Supply details as in the assignment description
	   if(this.isEmpty()){
		   throw new LinkedList.Error("this is empty");
	   }
		if(this.last == this.first){
			Object theFirst = this.first.item;
			this.first = null;
			this.last = null;
			return theFirst;
		}else{
			Object theFirst = this.first.item;
			this.first = this.first.next;
			this.first.prev = null;
			return theFirst;	
	   }
	}

   // Remove last item on the list and return it
   
   public Object removeLast()
   {
      // Supply details as in the assignment description
	   if(this.isEmpty()){
		   throw new LinkedList.Error("this is empty");
	   }
			if(this.last == this.first){
				Object theLast = this.last.item;
				this.first = null;
				this.last = null;
				return theLast;
			}else{
				Object theLast = this.last.item;
				this.last = this.last.prev;
				this.last.next = null;
				return theLast;	
			}
   }
   
   // Determine if two LinkedLists are equal
	 public boolean equals(Object x)
	{
	// Supply details as in the assignment description

	if(!(x instanceof LinkedList)) {
		return false;
		}
	
	LinkedList list = (LinkedList) x;

	Node p = this.first;
	Node q = list.first;
	
	if(this.length() != list.length()) {
		return false;
		}
	while( p != null) {
	if(!(p.item.equals(q.item))) {
		return false;
		}
	p = p.next;
	q = q.next;
	}
	return true;
	}

   // **********************************************************************

   // FOR THE PURPOSES OF THIS LAB, YOU DON'T NEED TO SPEND TIME READING THE
   // REST OF THIS FILE.  HOWEVER, YOU SHOULD DO SO LATER ON YOUR OWN TIME.

   // The following specifies the maximum number of items in the list that
   // will be included in the toString method.
 
   private static int printLimit = 20;

   // This method allows the client to control the number of list items
   // that will be included in the toString method.

   public static void setPrintLimit(int limit)
   {
      if (limit >= 1)
         printLimit = limit;
   }

   // This method produces a string of the form {item1,item2,...} where item1 
   // is the first item in the list. The number of items included is the smaller 
   // of the number of items in the list and the value of printLimit. The "..."
   // is shown only if there are list items that were not included.  

   public String toString()
   {
      String answer = "{";
      int ctr = 0;
      for(Node curr=first;curr!=null;curr=curr.next)
      {
         answer = answer + curr.item;
         ++ctr;
         if (curr.next != null)
            if (ctr == printLimit)
               return answer + ",...}";
            else
               answer = answer + ",";
      }
      return answer + "}";
   }

   public static class Error extends RuntimeException
   {
      public Error(String message)
      {
         super(message);
      }
   }
}