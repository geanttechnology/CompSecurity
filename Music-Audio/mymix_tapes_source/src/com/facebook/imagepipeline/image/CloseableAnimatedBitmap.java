// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.image:
//            CloseableBitmap

public class CloseableAnimatedBitmap extends CloseableBitmap
{

    private List mBitmapReferences;
    private volatile List mBitmaps;
    private volatile List mDurations;

    public CloseableAnimatedBitmap(List list, List list1)
    {
        boolean flag1 = true;
        super();
        Preconditions.checkNotNull(list);
        boolean flag;
        if (list.size() >= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Need at least 1 frame!");
        mBitmapReferences = new ArrayList();
        mBitmaps = new ArrayList();
        CloseableReference closeablereference;
        for (list = list.iterator(); list.hasNext(); mBitmaps.add(closeablereference.get()))
        {
            closeablereference = (CloseableReference)list.next();
            mBitmapReferences.add(closeablereference.clone());
        }

        mDurations = (List)Preconditions.checkNotNull(list1);
        if (mDurations.size() == mBitmaps.size())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Arrays length mismatch!");
    }

    public CloseableAnimatedBitmap(List list, List list1, ResourceReleaser resourcereleaser)
    {
        boolean flag1 = true;
        super();
        Preconditions.checkNotNull(list);
        boolean flag;
        if (list.size() >= 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Need at least 1 frame!");
        mBitmaps = new ArrayList();
        mBitmapReferences = new ArrayList();
        Bitmap bitmap;
        for (list = list.iterator(); list.hasNext(); mBitmaps.add(bitmap))
        {
            bitmap = (Bitmap)list.next();
            mBitmapReferences.add(CloseableReference.of(bitmap, resourcereleaser));
        }

        mDurations = (List)Preconditions.checkNotNull(list1);
        if (mDurations.size() == mBitmaps.size())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Arrays length mismatch!");
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mBitmapReferences != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        List list;
        list = mBitmapReferences;
        mBitmapReferences = null;
        mBitmaps = null;
        mDurations = null;
        this;
        JVM INSTR monitorexit ;
        CloseableReference.closeSafely(list);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getBitmaps()
    {
        return mBitmaps;
    }

    public List getDurations()
    {
        return mDurations;
    }

    public int getHeight()
    {
        List list = mBitmaps;
        if (list == null)
        {
            return 0;
        } else
        {
            return ((Bitmap)list.get(0)).getHeight();
        }
    }

    public int getSizeInBytes()
    {
        List list = mBitmaps;
        if (list == null || list.size() == 0)
        {
            return 0;
        } else
        {
            return BitmapUtil.getSizeInBytes((Bitmap)list.get(0)) * list.size();
        }
    }

    public Bitmap getUnderlyingBitmap()
    {
        List list = mBitmaps;
        if (list != null)
        {
            return (Bitmap)list.get(0);
        } else
        {
            return null;
        }
    }

    public int getWidth()
    {
        List list = mBitmaps;
        if (list == null)
        {
            return 0;
        } else
        {
            return ((Bitmap)list.get(0)).getWidth();
        }
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        List list = mBitmaps;
        boolean flag;
        if (list == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }
}
