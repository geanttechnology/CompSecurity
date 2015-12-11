// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.analytics.java.util:
//            FileIo, ObjectStream

public final class JsonFileIo
    implements FileIo
{
    public class JsonFileReadRunnable
        implements Runnable
    {

        final FileIo.FileReadListener listener;
        final JsonFileIo this$0;

        public void run()
        {
            try
            {
                List list = loadItems();
                listener.onItemsRead(list);
                return;
            }
            catch (Exception exception)
            {
                listener.onError(exception);
            }
        }
    }

    public class JsonFileWriteRunnable
        implements Runnable
    {

        final List items;
        final FileIo.FileWriteListener listener;
        final JsonFileIo this$0;

        public void run()
        {
            try
            {
                saveItems(items);
                listener.onItemsWritten();
                return;
            }
            catch (Exception exception)
            {
                listener.onError(exception);
            }
        }
    }

    public static interface JsonInterpreter
    {

        public abstract Object fromJson(String s)
            throws IOException;

        public abstract String toJson(Object obj)
            throws IOException;
    }


    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/analytics/java/util/JsonFileIo);
    private List itemList;
    private final JsonInterpreter jsonInterpreter;
    private int maxItems;
    private final ObjectStream streams;

    private void closeStream(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        closeable.printStackTrace();
        return;
    }

    private List readItemsFromDisk(ObjectInputStream objectinputstream, int i)
        throws IOException, ClassNotFoundException
    {
        logger.debug("readItemsFromDisk");
        ArrayList arraylist = new ArrayList(i);
        for (int j = 0; j < i; j++)
        {
            arraylist.add(readNextObject(objectinputstream));
        }

        return arraylist;
    }

    private Object readNextObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream = (String)objectinputstream.readObject();
        return jsonInterpreter.fromJson(objectinputstream);
    }

    private int readNumSavedItems(ObjectInputStream objectinputstream)
        throws IOException
    {
        return objectinputstream.readInt();
    }

    private void saveItemsToDisk(ObjectOutputStream objectoutputstream, List list)
        throws IOException
    {
        logger.debug("saveItemsToDisk");
        objectoutputstream.writeInt(list.size());
        Object obj;
        for (list = list.iterator(); list.hasNext(); objectoutputstream.writeObject(jsonInterpreter.toJson(obj)))
        {
            obj = list.next();
        }

    }

    public void append(List list)
    {
        itemList.addAll(list);
    }

    public boolean hasSavedItems()
    {
        return itemList.size() > 0;
    }

    public List loadItems()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = Collections.emptyList();
        itemList = Collections.emptyList();
        Object obj1;
        Object obj2;
        ObjectInputStream objectinputstream1;
        obj1 = null;
        obj2 = null;
        objectinputstream1 = null;
        ObjectInputStream objectinputstream = streams.objectInputStream();
        objectinputstream1 = objectinputstream;
        obj1 = objectinputstream;
        obj2 = objectinputstream;
        int i = readNumSavedItems(objectinputstream);
        obj1 = list;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        objectinputstream1 = objectinputstream;
        obj1 = objectinputstream;
        obj2 = objectinputstream;
        itemList = readItemsFromDisk(objectinputstream, i);
        objectinputstream1 = objectinputstream;
        obj1 = objectinputstream;
        obj2 = objectinputstream;
        ArrayList arraylist = new ArrayList(itemList);
        obj1 = arraylist;
        closeStream(objectinputstream);
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj1));
        Object obj;
        obj;
        closeStream(objectinputstream1);
        obj1 = list;
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        obj;
        obj2 = obj1;
        logger.error("Exception while executing loadItems()", ((Throwable) (obj)));
        closeStream(((Closeable) (obj1)));
        obj1 = list;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        closeStream(((Closeable) (obj2)));
        throw obj;
    }

    public List removeItems(int i)
    {
        return removeItems(0, i);
    }

    public List removeItems(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (i <= j)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        throw new IllegalArgumentException("Start value must be smaller than end value.");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj = Collections.emptyList();
        int k = j - i;
        if (k <= 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = new ArrayList(k);
_L3:
        obj = arraylist;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(itemList.remove(0));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public void save()
    {
        saveItems(itemList);
    }

    public void saveItems(List list)
    {
        this;
        JVM INSTR monitorenter ;
        logger.debug((new StringBuilder()).append("saveItems: ").append(list.toString()).toString());
        Object obj;
        ObjectOutputStream objectoutputstream;
        obj = null;
        objectoutputstream = null;
        ArrayList arraylist = new ArrayList(list);
        list = objectoutputstream;
        objectoutputstream = streams.objectOutputStream();
        list = objectoutputstream;
        obj = objectoutputstream;
        int i = arraylist.size();
        Object obj1;
        obj1 = arraylist;
        list = objectoutputstream;
        obj = objectoutputstream;
        if (i <= maxItems)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        list = objectoutputstream;
        obj = objectoutputstream;
        obj1 = arraylist.subList(maxItems - i, i);
        list = objectoutputstream;
        obj = objectoutputstream;
        saveItemsToDisk(objectoutputstream, ((List) (obj1)));
        list = objectoutputstream;
        obj = objectoutputstream;
        itemList = ((List) (obj1));
        closeStream(objectoutputstream);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj = list;
        logger.error("Exception while executing saveItems()", exception);
        closeStream(list);
        if (true) goto _L2; else goto _L1
_L1:
        list;
        throw list;
        list;
        closeStream(((Closeable) (obj)));
        throw list;
    }

    public int size()
    {
        return itemList.size();
    }


    // Unreferenced inner class com/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable$1

/* anonymous class */
    class JsonFileWriteRunnable._cls1
        implements FileIo.FileWriteListener
    {

        public void onError(Throwable throwable)
        {
        }

        public void onItemsWritten()
        {
        }
    }

}
