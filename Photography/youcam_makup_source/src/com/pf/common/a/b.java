// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;

// Referenced classes of package com.pf.common.a:
//            a

public class b extends a
{

    public b(int i, String s)
    {
        super(i, s);
    }

    protected int a(Object obj, Bitmap bitmap)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            i = bitmap.getAllocationByteCount();
        } else
        {
            i = bitmap.getByteCount();
        }
        return (i + 1023) / 1024;
    }

    public Bitmap a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap1 = (Bitmap)get(obj);
        Bitmap bitmap;
        bitmap = bitmap1;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        bitmap = bitmap1;
        if (!bitmap1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        remove(obj);
        bitmap = null;
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        obj;
        throw obj;
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return a(obj, (Bitmap)obj1);
    }
}
