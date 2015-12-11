// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.c.a.b.a.a;
import com.c.a.b.a.d;

// Referenced classes of package com.smule.android.f:
//            c, d

final class c
    implements d
{

    final boolean a;
    final int b;
    final com.smule.android.f.d c;

    public void a(String s, View view)
    {
    }

    public void a(String s, View view, Bitmap bitmap)
    {
        if (a)
        {
            com.smule.android.f.c.a((ImageView)view, bitmap, b, true);
        }
        if (c != null)
        {
            c.a(s, view, bitmap);
        }
    }

    public void a(String s, View view, a a1)
    {
    }

    public void b(String s, View view)
    {
    }

    (boolean flag, int i, com.smule.android.f.d d1)
    {
        a = flag;
        b = i;
        c = d1;
        super();
    }
}
