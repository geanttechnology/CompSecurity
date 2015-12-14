// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifTag, ExifInterface

class IfdData
{

    private static final int sIfds[] = {
        0, 1, 2, 3, 4
    };
    private final Map mExifTags = new HashMap();
    private final int mIfdId;
    private int mOffsetToNextIfd;

    IfdData(int i)
    {
        mOffsetToNextIfd = 0;
        mIfdId = i;
    }

    protected static int[] getIfds()
    {
        return sIfds;
    }

    protected boolean checkCollision(short word0)
    {
        return mExifTags.get(Short.valueOf(word0)) != null;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof IfdData))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (IfdData)obj;
        if (((IfdData) (obj)).getId() != mIfdId || ((IfdData) (obj)).getTagCount() != getTagCount())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((IfdData) (obj)).getAllTags();
        int j = obj.length;
        int i = 0;
        while (i < j) 
        {
            ExifTag exiftag = obj[i];
            if (ExifInterface.isOffsetTag(exiftag.getTagId()) || exiftag.equals((ExifTag)mExifTags.get(Short.valueOf(exiftag.getTagId()))))
            {
                i++;
            } else
            {
                return false;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    protected ExifTag[] getAllTags()
    {
        return (ExifTag[])mExifTags.values().toArray(new ExifTag[mExifTags.size()]);
    }

    protected int getId()
    {
        return mIfdId;
    }

    protected int getOffsetToNextIfd()
    {
        return mOffsetToNextIfd;
    }

    protected ExifTag getTag(short word0)
    {
        return (ExifTag)mExifTags.get(Short.valueOf(word0));
    }

    protected int getTagCount()
    {
        return mExifTags.size();
    }

    protected void removeTag(short word0)
    {
        mExifTags.remove(Short.valueOf(word0));
    }

    protected void setOffsetToNextIfd(int i)
    {
        mOffsetToNextIfd = i;
    }

    protected ExifTag setTag(ExifTag exiftag)
    {
        exiftag.setIfd(mIfdId);
        return (ExifTag)mExifTags.put(Short.valueOf(exiftag.getTagId()), exiftag);
    }

}
