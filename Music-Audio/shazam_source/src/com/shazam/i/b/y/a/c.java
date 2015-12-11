// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.y.a;

import com.shazam.android.y.e.a;
import com.shazam.i.b.y.d;

// Referenced classes of package com.shazam.i.b.y.a:
//            a

public final class c
{

    private static final a a;

    public static com.shazam.android.y.e.d a()
    {
        return a;
    }

    static 
    {
        com.shazam.android.m.b b = com.shazam.i.b.y.a.a.a();
        if (d.a == null)
        {
            throw new IllegalArgumentException("Mapper instance was not injected. Please call GuaranteedHttpMapperInjector.setLoggerInstance() before using");
        } else
        {
            a = new a(b, d.a);
        }
    }
}
