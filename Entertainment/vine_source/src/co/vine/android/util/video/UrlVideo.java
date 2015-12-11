// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util.video;

import co.vine.android.util.UrlResource;
import java.io.File;

public class UrlVideo extends UrlResource
{

    private static final long LONG_HIGH_BITS = 0xffffffff80000000L;
    private File mFile;
    private Integer mSize;

    public UrlVideo(String s, File file)
    {
        super(s);
        value = file;
        if (file != null)
        {
            mFile = file;
        }
    }

    private int getSize()
    {
        if (mSize == null || mSize.intValue() == 0)
        {
            if (value != null)
            {
                mSize = Integer.valueOf(safeLongToInt(((File)value).length()));
            } else
            {
                mSize = Integer.valueOf(0);
            }
        }
        return mSize.intValue();
    }

    private static int safeLongToInt(long l)
    {
        if ((l & 0xffffffff80000000L) == 0L || (l & 0xffffffff80000000L) == 0xffffffff80000000L)
        {
            return (int)l;
        } else
        {
            throw new IllegalArgumentException("File is too large to store in cache.");
        }
    }

    public String getAbsolutePath()
    {
        return mFile.getAbsolutePath();
    }

    public int originalSize()
    {
        return getSize();
    }

    public int size()
    {
        return getSize();
    }
}
