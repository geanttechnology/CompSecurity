// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import com.shazam.android.aq.h;
import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.server.legacy.orbitconfig.OrbitConfig;
import com.shazam.server.response.config.AmpConfig;

// Referenced classes of package com.shazam.android.j:
//            p, e

public final class l
    implements p
{

    private final h a;
    private final b b;

    public l(h h1, b b1)
    {
        a = h1;
        b = b1;
    }

    public final long a()
    {
        String s;
        boolean flag;
        long l1;
        long l2;
        l2 = 0xf731400L;
        flag = false;
        s = a.a().b().getStringConfigEntry("expires");
        l1 = l2;
        if (!com.shazam.b.e.a.c(s)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = s.length();
        i = 0;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (Character.isDigit(s.charAt(i))) goto _L4; else goto _L3
_L3:
        i = ((flag) ? 1 : 0);
_L6:
        l1 = l2;
        if (i != 0)
        {
            l1 = Math.min(Long.parseLong(s), 0xf731400L);
        }
_L2:
        return l1;
_L4:
        i++;
          goto _L5
        i = 1;
          goto _L6
    }

    public final boolean b()
    {
        return a.a().a().isEmpty();
    }

    public final boolean c()
    {
        return com.shazam.b.e.a.a(a.a().b().getStringConfigEntry("service"));
    }

    public final boolean d()
    {
        boolean flag = false;
        if (b.a("pk_f_rc", false))
        {
            flag = true;
        }
        return flag;
    }
}
