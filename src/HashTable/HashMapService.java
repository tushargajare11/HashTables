package HashTable;

public class HashMapService {
    LinkedList[] bucket;

    public HashMapService()
    {
        bucket = new LinkedList[16];
    }

    // method to add linked list at particular index of hash table
    public void put(String key , int value)
    {
        int bucketIndex = generateBucketIndex(key);
        LinkedList isLinkedListPresent = bucket[bucketIndex];

        //checks if already linked list present at index
        if (isLinkedListPresent != null)
        {
            Node searchNode  = isLinkedListPresent.search(key);
            if (searchNode != null)
            {
                searchNode.value += 1;
            }
            else
            {
                isLinkedListPresent.add(key, value);
            }
        }
        //creates a new linked list at that index
        else
        {
            LinkedList newLinkList = new LinkedList();
            newLinkList.add(key, value);
            bucket[bucketIndex] = newLinkList;
        }
    }

    //method to fetch a particular key value
    public int get(String key)
    {
        int bucketIndex = generateBucketIndex(key);
        LinkedList searchLinkList = bucket[bucketIndex];
        if (searchLinkList != null)
        {
            Node getLinkList = searchLinkList.search(key);
            return getLinkList.value;
        }
        return 0;
    }

    //method to remove a particular key value
    public void remove(String key)
    {
        int bucketIndex = generateBucketIndex(key);
        LinkedList searchLinkList = bucket[bucketIndex];
        searchLinkList.delete(key);
    }

    //method to print all the key values present in hash map
    public void print()
    {
        for (int i = 0; i < bucket.length; i++)
        {
            LinkedList node = bucket[i];
            if(node != null)
            {
                if(node.head == null)
                {
                    System.out.println("The HashMap is empty");
                }
                else
                {
                    Node traverseNode = node.head;
                    while(traverseNode != null)
                    {
                        System.out.println("The frequency of \""+ traverseNode.key + "\" is : " +traverseNode.value);
                        traverseNode = traverseNode.next;
                    }
                }
            }
        }
        System.out.println("-------------------------");
    }

    private int generateBucketIndex(String key) {
        int hashCode = key.hashCode();
        int bucketIndex =Math.abs(hashCode) % 10;
        return bucketIndex;
    }
}
