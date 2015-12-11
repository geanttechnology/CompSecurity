// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.b;

import com.shazam.android.persistence.n.b;

// Referenced classes of package com.shazam.android.fragment.b:
//            b

public final class d
    implements com.shazam.android.fragment.b.b
{

    private final b a;
    private final String b;

    public d(b b1, String s)
    {
        a = b1;
        b = s;
    }

    public final int a()
    {
        return a.d(b);
    }

    public final void a(int i)
    {
        a.a(b, i);
    }

    public final void b()
    {
        a(a() + 1);
    }
}
