// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aa;

import android.graphics.Bitmap;
import com.g.c.ad;
import com.g.c.u;
import com.g.c.y;

// Referenced classes of package com.shazam.android.aa:
//            b, c

public final class f
    implements b
{
    private static final class a
        implements ad
    {

        private final c a;

        public final void a()
        {
        }

        public final void a(Bitmap bitmap)
        {
            a.a(bitmap);
        }

        public a(c c1)
        {
            a = c1;
        }
    }


    private final u a;
    private a b;

    public f(u u1)
    {
        a = u1;
    }

    public final void a(String s, c c)
    {
        b = new a(c);
        a.a(s).a(b);
    }
}
