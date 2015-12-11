// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ak.a;

import com.shazam.android.j.j.a;
import com.shazam.f.c;

// Referenced classes of package com.shazam.android.ak.a:
//            d

public final class e
    implements d
{

    private final a a;

    public e(a a1)
    {
        a = a1;
    }

    public final String a()
    {
        String s = a.a();
        if (s == null)
        {
            throw new c("Could not retrieve get smoid end point from orbit config");
        } else
        {
            return s;
        }
    }
}
