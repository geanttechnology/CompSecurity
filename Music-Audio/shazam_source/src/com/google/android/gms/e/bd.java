// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, e, cj

final class bd extends o
{

    private static final String b;
    private final com.google.android.gms.e.e c;

    public bd(Context context)
    {
        this(e.a(context));
    }

    private bd(com.google.android.gms.e.e e1)
    {
        super(b, new String[0]);
        c = e1;
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        boolean flag1 = true;
        map = c;
        map.a();
        boolean flag;
        if (((com.google.android.gms.e.e) (map)).a == null)
        {
            flag = true;
        } else
        {
            flag = ((com.google.android.gms.e.e) (map)).a.isLimitAdTrackingEnabled();
        }
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        return cj.a(Boolean.valueOf(flag));
    }

    public final boolean a()
    {
        return false;
    }

    static 
    {
        b = e.b.toString();
    }
}
