// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.w;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class hq extends iy
{

    public final Map a = new HashMap();

    public hq()
    {
    }

    public static String a(String s)
    {
        w.a(s);
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("&"))
            {
                s1 = s.substring(1);
            }
        }
        w.a(s1, "Name can not be empty or \"&\"");
        return s1;
    }

    public final void a(iy iy1)
    {
        iy1 = (hq)iy1;
        w.a(iy1);
        ((hq) (iy1)).a.putAll(a);
    }

    public final String toString()
    {
        return iy.a(a, 0);
    }
}
