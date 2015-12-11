// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class ba extends o
{

    private static final String b;

    public ba()
    {
        super(b, new String[0]);
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        return cj.a(android.os.Build.VERSION.RELEASE);
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.u.toString();
    }
}
