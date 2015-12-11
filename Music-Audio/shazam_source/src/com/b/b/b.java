// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.b;

import android.os.Build;
import com.b.c.a;
import com.b.e.m;

// Referenced classes of package com.b.b:
//            c, d

public final class b extends c
{

    protected b(com.b.a.b b1, d d, String s, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        flag2 = true;
        super(b1, d, s, flag, true, true);
        a(new a("ns_ap_gs", String.valueOf(b1.l()), Boolean.valueOf(false)));
        a(new a("ns_ap_install", String.valueOf(b1.k()), Boolean.valueOf(false)));
        a(new a("ns_ap_runs", String.valueOf(b1.j()), Boolean.valueOf(false)));
        if (flag)
        {
            a(new a("ns_ap_csf", "1", Boolean.valueOf(false)));
        }
        d = "0";
        s = Build.TAGS;
        if (s != null && s.contains("test-keys"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
_L4:
        if (flag1)
        {
            d = "1";
        }
        a(new a("ns_ap_jb", d, Boolean.valueOf(false)));
        a(new a("ns_ap_lastrun", String.valueOf(b1.w()), Boolean.valueOf(false)));
        b1 = b1.p();
        if (b1 != null && b1.length() > 0)
        {
            a(new a("ns_ap_updated", b1, Boolean.valueOf(false)));
        }
        return;
_L2:
        flag1 = flag2;
        if (!m.a())
        {
            flag1 = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
