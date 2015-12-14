// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;

import android.util.Log;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class DiskStorageUtils
{

    private static final String TAG = com/amazon/gallery/framework/data/store/DiskStorageUtils.getName();
    public static ThreadLocal byteBufferThreadLocal = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected byte[] initialValue()
        {
            return new byte[32768];
        }

    };
    private static DiskStorageUtils diskStorageUtils;

    private DiskStorageUtils()
    {
    }

    private void deleteFile(File file)
    {
        if (file.exists())
        {
            file.delete();
        }
    }

    public static DiskStorageUtils getInstance()
    {
        if (diskStorageUtils == null)
        {
            diskStorageUtils = new DiskStorageUtils();
        }
        return diskStorageUtils;
    }

    public File createFile(File file, String s)
    {
        return new File(file, s);
    }

    public File createFile(String s)
    {
        return new File(s);
    }

    public InputStream createInputStream(File file)
        throws FileNotFoundException
    {
        return new FileInputStream(file);
    }

    public FileOutputStream createOutputStream(File file)
        throws FileNotFoundException
    {
        return new FileOutputStream(file);
    }

    public File getMediaItemSizePartition(File file, ObjectID objectid, Asset.BoundingSize boundingsize)
    {
        file = getMediaItemSizesPartition(file, objectid);
        if (file == null)
        {
            file = null;
        } else
        {
            objectid = createFile(file, String.valueOf(boundingsize.getSize()));
            file = objectid;
            if (!objectid.exists())
            {
                file = objectid;
                if (!objectid.mkdirs())
                {
                    return null;
                }
            }
        }
        return file;
    }

    public File getMediaItemSizePartition(File file, MediaItem mediaitem, Asset.BoundingSize boundingsize)
    {
        return getMediaItemSizePartition(file, mediaitem.getObjectId(), boundingsize);
    }

    public File getMediaItemSizesPartition(File file, ObjectID objectid)
    {
        objectid = createFile(file, Integer.toHexString((int)(objectid.getLeastSignificantBits() & 255L)));
        file = objectid;
        if (!objectid.exists())
        {
            file = objectid;
            if (!objectid.mkdir())
            {
                file = null;
            }
        }
        return file;
    }

    public void storeFile(File file, File file1)
        throws IOException
    {
        File file2;
        if (file.renameTo(file1))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        file2 = null;
        file = createInputStream(file);
        file2 = file;
        writeFileFromStream(file, file1);
        file2 = file;
        GLogger.d(TAG, "Stored file: %s", new Object[] {
            file1.getAbsoluteFile()
        });
        IOUtils.closeQuietly(file);
        return;
        file;
        IOUtils.closeQuietly(file2);
        throw file;
    }

    public void storeFile(InputStream inputstream, long l, File file, File file1)
        throws IOException
    {
        long l1 = writeFileFromStream(inputstream, file);
        if (l1 != l)
        {
            deleteFile(file);
            inputstream = String.format("The destination file size was %d, but it was expected to be %d.", new Object[] {
                Long.valueOf(l1), Long.valueOf(l)
            });
            GLogger.i(TAG, inputstream, new Object[0]);
            throw new IOException(inputstream);
        }
        if (!file.renameTo(file1))
        {
            if (!file.delete())
            {
                Log.e(TAG, "Unable to delete temporary file");
            }
            GLogger.i(TAG, "Failed to rename temporary file", new Object[0]);
            throw new IOException("Failed to rename temporary file");
        } else
        {
            GLogger.d(TAG, "Stored file: %s", new Object[] {
                file1.getAbsoluteFile()
            });
            return;
        }
    }

    long writeFileFromStream(InputStream inputstream, File file)
        throws IOException
    {
        FileOutputStream fileoutputstream;
        long l;
        long l1;
        long l2;
        deleteFile(file);
        fileoutputstream = createOutputStream(file);
        l = 0L;
        l1 = l;
        l2 = l;
        byte abyte0[] = (byte[])byteBufferThreadLocal.get();
_L2:
        l1 = l;
        l2 = l;
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = l;
        l2 = l;
        fileoutputstream.write(abyte0, 0, i);
        l += i;
        if (true) goto _L2; else goto _L1
_L1:
        l1 = l;
        l2 = l;
        fileoutputstream.flush();
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream);
        if (!file.exists() || file.length() <= 0L)
        {
            file.delete();
            GLogger.i(TAG, "The destination file failed to write.", new Object[0]);
            throw new IOException("The destination file failed to write.");
        } else
        {
            return l;
        }
        Object obj;
        obj;
        l2 = l1;
        deleteFile(file);
        l2 = l1;
        throw obj;
        obj;
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream);
        if (!file.exists() || file.length() <= 0L)
        {
            file.delete();
            GLogger.i(TAG, "The destination file failed to write.", new Object[0]);
            throw new IOException("The destination file failed to write.");
        } else
        {
            return l2;
        }
    }

}
