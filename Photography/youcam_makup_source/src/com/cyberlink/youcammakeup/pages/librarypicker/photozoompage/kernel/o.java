// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            p

class o extends BitmapDrawable
{

    private final WeakReference a;

    public o(Resources resources, Bitmap bitmap, p p1)
    {
        super(resources, bitmap);
        a = new WeakReference(p1);
    }

    public p a()
    {
        return (p)a.get();
    }
}
