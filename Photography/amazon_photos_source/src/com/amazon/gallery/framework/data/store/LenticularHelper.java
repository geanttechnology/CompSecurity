// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

public class LenticularHelper
{

    private static final String TAG = com/amazon/gallery/framework/data/store/LenticularHelper.toString();
    private final File lenticularFramesDirectory;

    public LenticularHelper(File file)
    {
        lenticularFramesDirectory = file;
        mkdir(file);
    }

    private File getFrameDirectory(ObjectID objectid)
    {
        return new File(lenticularFramesDirectory, objectid.toString());
    }

    private File getFrameFile(ObjectID objectid, int i)
    {
        File file = getFrameDirectory(objectid);
        mkdir(file);
        return new File(file, String.format("%s_%d.jpeg", new Object[] {
            objectid.toString(), Integer.valueOf(i)
        }));
    }

    private static List getFrameSizes(MappedByteBuffer mappedbytebuffer)
        throws IOException
    {
        LinkedList linkedlist = new LinkedList();
        int i = mappedbytebuffer.limit();
        mappedbytebuffer.position(i - 1);
        byte byte0 = mappedbytebuffer.get();
        if (byte0 < 1 || byte0 > 50)
        {
            throw new IOException(String.format("Invalid lenticular frame count: %d. File may be malformatted.", new Object[] {
                Byte.valueOf(byte0)
            }));
        }
        mappedbytebuffer.position(i - 1 - byte0 * 4);
        for (int j = 0; j < byte0; j++)
        {
            linkedlist.add(Integer.valueOf(mappedbytebuffer.getInt()));
        }

        mappedbytebuffer.position(0);
        return linkedlist;
    }

    public static boolean isLenticular(File file)
    {
        return isLenticular(FilenameUtils.getName(file.getAbsolutePath()));
    }

    public static boolean isLenticular(String s)
    {
        s = s.toLowerCase();
        return s.endsWith(".len.jpg") || s.endsWith(".len.jpeg");
    }

    private static void mkdir(File file)
    {
        if (!file.exists())
        {
            file.mkdir();
        }
    }

    private static void writeFrame(ByteBuffer bytebuffer, File file)
    {
        File file1;
        File file2;
        file2 = null;
        file1 = null;
        file = (new FileOutputStream(file)).getChannel();
        file1 = file;
        file2 = file;
        file.write(bytebuffer);
        IOUtils.closeQuietly(file);
        return;
        bytebuffer;
        file2 = file1;
        GLogger.ex(TAG, "IOException occured when writing frame to output file", bytebuffer);
        IOUtils.closeQuietly(file1);
        return;
        bytebuffer;
        IOUtils.closeQuietly(file2);
        throw bytebuffer;
    }

    public List getFrames(ObjectID objectid)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = null;
        obj = getFrameDirectory(objectid);
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        obj = arraylist;
_L4:
        return ((List) (obj));
_L2:
        String as[] = ((File) (obj)).list(new FilenameFilter() {

            final LenticularHelper this$0;

            public boolean accept(File file, String s)
            {
                file = s.toLowerCase();
                return file.endsWith(".jpeg") || file.endsWith(".jpg");
            }

            
            {
                this$0 = LenticularHelper.this;
                super();
            }
        });
        obj = arraylist;
        if (as == null)
        {
            continue;
        }
        obj = arraylist;
        if (as.length == 0)
        {
            continue;
        }
        arraylist = new ArrayList();
        int j = as.length;
        int i = 0;
        do
        {
            obj = arraylist;
            if (i >= j)
            {
                continue;
            }
            obj = getFrameFile(objectid, i);
            if (((File) (obj)).exists())
            {
                arraylist.add(new Frame(((File) (obj)).getAbsolutePath()));
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List splitFrames(File file, ObjectID objectid)
    {
        Object obj;
        Object obj1;
        ByteBuffer bytebuffer;
        ArrayList arraylist;
        bytebuffer = null;
        obj = null;
        obj1 = null;
        arraylist = new ArrayList();
        file = new FileInputStream(file);
        obj = file.getChannel();
        obj = ((FileChannel) (obj)).map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, ((FileChannel) (obj)).size());
        obj1 = getFrameSizes(((MappedByteBuffer) (obj)));
        int i;
        int j;
        i = 0;
        j = 0;
        obj1 = ((List) (obj1)).iterator();
_L1:
        int k;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        k = ((Integer)((Iterator) (obj1)).next()).intValue();
        ((MappedByteBuffer) (obj)).position(j);
        bytebuffer = ((MappedByteBuffer) (obj)).slice();
        bytebuffer.limit(k);
        j += k;
        File file1 = getFrameFile(objectid, i);
        writeFrame(bytebuffer, file1);
        arraylist.add(new Frame(file1.getAbsolutePath()));
        i++;
          goto _L1
        IOUtils.closeQuietly(file);
        return arraylist;
        objectid;
        file = ((File) (obj1));
_L7:
        obj = file;
        GLogger.ex(TAG, "IO exception splitting frames of lenticular", objectid);
        IOUtils.closeQuietly(file);
        return arraylist;
        objectid;
        file = bytebuffer;
_L5:
        obj = file;
        GLogger.ex(TAG, "Unexpected exception splitting frames of lenticular", objectid);
        IOUtils.closeQuietly(file);
        return arraylist;
        file;
_L3:
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw file;
        objectid;
        obj = file;
        file = objectid;
        if (true) goto _L3; else goto _L2
_L2:
        objectid;
        if (true) goto _L5; else goto _L4
_L4:
        objectid;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
