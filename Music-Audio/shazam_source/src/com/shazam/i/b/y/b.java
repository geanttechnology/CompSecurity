// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.y;

import com.shazam.i.i.c;
import com.shazam.i.j.a;

// Referenced classes of package com.shazam.i.b.y:
//            c, d

public final class b
{

    private static com.shazam.android.y.b a;

    public static com.shazam.android.y.b a()
    {
        if (a == null)
        {
            com.shazam.i.b.y.c.a = c.a();
            com.shazam.i.b.y.d.a = com.shazam.i.j.a.b();
            a = new com.shazam.android.y.a(com.shazam.i.b.c.a());
        }
        return a;
    }
}
