// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.cyberlink.you.utility:
//            l, m

class k extends BitmapDrawable
{

    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;

    public k(Resources resources, Bitmap bitmap, LoadImageUtils.LoadBitmapTask loadbitmaptask)
    {
        super(resources, bitmap);
        a = new WeakReference(loadbitmaptask);
        b = null;
        c = null;
    }

    public k(Resources resources, Bitmap bitmap, l l1)
    {
        super(resources, bitmap);
        a = null;
        b = new WeakReference(l1);
        c = null;
    }

    public k(Resources resources, Bitmap bitmap, m m1)
    {
        super(resources, bitmap);
        a = null;
        b = null;
        c = new WeakReference(m1);
    }

    public LoadImageUtils.LoadBitmapTask a()
    {
        if (a != null)
        {
            return (LoadImageUtils.LoadBitmapTask)a.get();
        } else
        {
            return null;
        }
    }

    public l b()
    {
        if (b != null)
        {
            return (l)b.get();
        } else
        {
            return null;
        }
    }

    public m c()
    {
        if (c != null)
        {
            return (m)c.get();
        } else
        {
            return null;
        }
    }
}
