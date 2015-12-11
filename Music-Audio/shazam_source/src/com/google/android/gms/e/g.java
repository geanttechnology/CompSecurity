// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.os.Build;
import com.google.android.gms.d.e;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class g extends o
{

    private static final String b;

    public g()
    {
        super(b, new String[0]);
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        String s1 = Build.MANUFACTURER;
        String s = Build.MODEL;
        map = s;
        if (!s.startsWith(s1))
        {
            map = s;
            if (!s1.equals("unknown"))
            {
                map = (new StringBuilder()).append(s1).append(" ").append(s).toString();
            }
        }
        return cj.a(map);
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.l.toString();
    }
}
