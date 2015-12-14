// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            g

class a extends m
{

    final boolean a;
    final g b;

    protected void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            g.i(b).setImageBitmap(bitmap);
            g.i(b).setVisibility(0);
            g.b(b, true);
            if (g.k(b) && a)
            {
                g.a(b, 0);
                g.a(b, false);
            }
            g.d(b);
        }
    }

    protected void b(Object obj)
    {
        a((Bitmap)obj);
    }

    (g g1, boolean flag)
    {
        b = g1;
        a = flag;
        super();
    }
}
