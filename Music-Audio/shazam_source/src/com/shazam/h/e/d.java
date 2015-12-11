// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.e;

import com.shazam.h.e.a.b;

// Referenced classes of package com.shazam.h.e:
//            b

public final class d
    implements com.shazam.h.e.b
{

    private final String a;
    private final String b;

    public d(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public final void a(b b1)
    {
        b1.a();
        b1.a(String.format("name=\"%s\"\r\n\r\n", new Object[] {
            a
        }).getBytes());
        if (b != null)
        {
            b1.a(b.getBytes());
        }
        b1.b();
    }
}
