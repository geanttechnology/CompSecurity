// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.graphics.Bitmap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.github.ignition.support.cache:
//            AbstractCache, CacheHelper

public abstract class AbstractImageCache extends AbstractCache
{

    public AbstractImageCache(String s, int i, int j, long l, int k)
    {
        super(s, i, j, l, k);
    }

    public abstract Bitmap decodeToBitmap(Object obj);

    public abstract Bitmap getBitmap(Object obj);

    public abstract Bitmap getBitmapFromMemory(String s);

    public volatile String getFileNameForKey(Object obj)
    {
        return getFileNameForKey((String)obj);
    }

    public String getFileNameForKey(String s)
    {
        return CacheHelper.getFileNameFromUrl(s);
    }

    protected volatile Object readValueFromDisk(File file)
        throws IOException
    {
        return readValueFromDisk(file);
    }

    protected byte[] readValueFromDisk(File file)
        throws IOException
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
        long l = file.length();
        if (l > 0x7fffffffL)
        {
            throw new IOException("Cannot read files larger than 2147483647 bytes");
        } else
        {
            int i = (int)l;
            file = new byte[i];
            bufferedinputstream.read(file, 0, i);
            bufferedinputstream.close();
            return file;
        }
    }

    protected volatile void writeValueToDisk(File file, Object obj)
        throws IOException
    {
        writeValueToDisk(file, (byte[])obj);
    }

    protected void writeValueToDisk(File file, byte abyte0[])
        throws IOException
    {
        file = new BufferedOutputStream(new FileOutputStream(file));
        file.write(abyte0);
        file.close();
    }
}
