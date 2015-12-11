// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.a.b:
//            b, ad, ao, aj

abstract class a
{

    final ad a;
    final ao b;
    final WeakReference c;
    final boolean d;
    final boolean e;
    final int f;
    final Drawable g;
    final String h;
    boolean i;

    a(ad ad1, Object obj, ao ao, boolean flag, boolean flag1, int j, Drawable drawable, 
            String s)
    {
        a = ad1;
        b = ao;
        c = new b(this, obj, ad1.i);
        d = flag;
        e = flag1;
        f = j;
        g = drawable;
        h = s;
    }

    abstract void a();

    abstract void a(Bitmap bitmap, aj aj);

    void b()
    {
        i = true;
    }
}
