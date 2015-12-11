// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class ce extends o
{

    private static final String b;

    public ce()
    {
        super(b, new String[0]);
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        return cj.a(Long.valueOf(System.currentTimeMillis()));
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.C.toString();
    }
}
