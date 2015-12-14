// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.b;
import java.lang.ref.SoftReference;
import java.util.HashSet;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            j

class a extends LruCache
{

    final j a;

    protected int a(String s, BitmapDrawable bitmapdrawable)
    {
        int k = j.a(bitmapdrawable) / 1024;
        int i = k;
        if (k == 0)
        {
            i = 1;
        }
        return i;
    }

    protected void a(boolean flag, String s, BitmapDrawable bitmapdrawable, BitmapDrawable bitmapdrawable1)
    {
        if (com/cyberlink/youcammakeup/pages/librarypicker/photozoompage/view/b.isInstance(bitmapdrawable))
        {
            ((b)bitmapdrawable).b(false);
        } else
        if (com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a.b.e())
        {
            j.a(a).add(new SoftReference(bitmapdrawable.getBitmap()));
            return;
        }
    }

    protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        a(flag, (String)obj, (BitmapDrawable)obj1, (BitmapDrawable)obj2);
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return a((String)obj, (BitmapDrawable)obj1);
    }

    (j j1, int i)
    {
        a = j1;
        super(i);
    }
}
