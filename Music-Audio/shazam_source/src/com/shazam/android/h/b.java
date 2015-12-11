// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.h;

import com.shazam.f.b.a;

// Referenced classes of package com.shazam.android.h:
//            a

public final class b
    implements com.shazam.android.h.a
{

    private final com.shazam.b.a.a a;
    private final com.shazam.b.a.a b;

    public b(com.shazam.b.a.a a1, com.shazam.b.a.a a2)
    {
        a = a1;
        b = a2;
    }

    public final Object a(Object obj)
    {
        obj = (Integer)obj;
        if (((Integer) (obj)).intValue() == 1)
        {
            return a;
        }
        if (((Integer) (obj)).intValue() > 1)
        {
            return b;
        } else
        {
            throw new a((new StringBuilder("Unable to select chooser for: ")).append(obj).toString());
        }
    }
}
