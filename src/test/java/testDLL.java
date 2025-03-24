import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testDLL {
    @Test
    public void testAppend(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3", 0);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        Assert.assertEquals("4262:5 -- [Me]", dll.append(a1).toString());
        Assert.assertEquals("3452:2 -- [Me]", dll.append(a2).toString());
        Assert.assertEquals("1901:0 -- [Me]", dll.append(a3).toString());
    }

    @Test
    public void testToString(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        Assert.assertEquals("4262:5 -- [Me] --> 3452:2 -- [Me] --> 1901:0 -- [Me] --> NULL", dll.toString());
    }

    @Test
    public void testInsert(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);
        Album a4 = new Album(6291,artists,"Album4",11);
        Album a5 = new Album(7201,artists,"Album5",18);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        Assert.assertEquals("6291:11 -- [Me]",dll.insert(1,a4).toString());
        Assert.assertEquals("7201:18 -- [Me]",dll.insert(0,a5).toString());
        Assert.assertEquals("7201:18 -- [Me] --> 4262:5 -- [Me] --> 6291:11 -- [Me] --> 3452:2 -- [Me] --> 1901:0 -- [Me] --> NULL",
                            dll.toString());
    }

    @Test
    public void testDelete(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);
        Album a4 = new Album(6291,artists,"Album4",11);
        Album a5 = new Album(7201,artists,"Album5",18);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);
        dll.append(a5);
        Assert.assertEquals("4262:5 -- [Me]", dll.delete(0).toString());
        Assert.assertEquals("7201:18 -- [Me]", dll.delete(3).toString());
        Assert.assertEquals("1901:0 -- [Me]", dll.delete(1).toString());
        Assert.assertEquals("3452:2 -- [Me] --> 6291:11 -- [Me] --> NULL", dll.toString());
    }

    @Test
    public void testGetIndex(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);
        Album a4 = new Album(6291,artists,"Album4",11);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        Assert.assertEquals(2, dll.getIndex(a3));
        Assert.assertEquals(-1,dll.getIndex(a4));
        Assert.assertEquals(0,dll.getIndex(a1));
        Assert.assertEquals(1,dll.getIndex(a2));
    }

    @Test
    public void testShuffle(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);
        Album a4 = new Album(6291,artists,"Album4",11);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);
        Assert.assertEquals("4262:5 -- [Me] --> 3452:2 -- [Me] --> 1901:0 -- [Me] --> 6291:11 -- [Me] --> NULL",
                dll.toString());
        Assert.assertEquals(a2,dll.shuffle().data);
    }

    @Test
    public void testPartition(){
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Me");
        Album a1 = new Album(4262,artists,"Album1", 5);
        Album a2 = new Album(3452,artists,"Album2", 2);
        Album a3 = new Album(1901,artists,"Album3",0);
        Album a4 = new Album(6291,artists,"Album4",11);

        DoublyLinkedList dll = new DoublyLinkedList<>();
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);
        Assert.assertEquals("1901:0 -- [Me] --> 6291:11 -- [Me] --> NULL", dll.Partition(a3).toString());
    }
}
