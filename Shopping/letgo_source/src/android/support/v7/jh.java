// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import com.facebook.s;
import java.io.Serializable;
import java.util.Locale;

// Referenced classes of package android.support.v7:
//            jg, jv

class jh
    implements Serializable
{

    private static final String a = android/support/v7/jg.getCanonicalName();
    private static final long b[] = {
        0x493e0L, 0xdbba0L, 0x1b7740L, 0x36ee80L, 0x1499700L, 0x2932e00L, 0x5265c00L, 0xa4cb800L, 0xf731400L, 0x240c8400L, 
        0x48190800L, 0x6c258c00L, 0x90321000L, 0x134fd9000L, 0x1cf7c5800L, 0x269fb2000L, 0x30479e800L, 0x39ef8b000L, 0x757b12c00L
    };
    private boolean c;
    private boolean d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;
    private String j;

    jh()
    {
        a();
    }

    private static int a(long l)
    {
        int k;
        for (k = 0; k < b.length && b[k] < l; k++) { }
        return k;
    }

    private void a()
    {
        d = false;
        f = -1L;
        g = -1L;
        i = 0;
        h = 0L;
    }

    private void b(jg jg1, long l)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", i);
        bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[] {
            Integer.valueOf(a(l))
        }));
        bundle.putString("fb_mobile_launch_source", j);
        jg1.a("fb_mobile_deactivate_app", h / 1000L, bundle);
        a();
    }

    private boolean b()
    {
        return g != -1L;
    }

    private boolean c()
    {
        boolean flag;
        if (!c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = true;
        return flag;
    }

    void a(jg jg1, long l)
    {
        long l1 = 0L;
        if (!d)
        {
            jv.a(s.e, a, "Suspend for inactive app");
            return;
        }
        long l2 = l - f;
        if (l2 < 0L)
        {
            jv.a(s.e, a, "Clock skew detected");
        } else
        {
            l1 = l2;
        }
        h = l1 + h;
        g = l;
        d = false;
    }

    void a(jg jg1, long l, String s1)
    {
        long l1;
        long l2 = 0L;
        if (c() || l - e > 0x493e0L)
        {
            Bundle bundle = new Bundle();
            bundle.putString("fb_mobile_launch_source", s1);
            jg1.a("fb_mobile_activate_app", bundle);
            e = l;
        }
        if (d)
        {
            jv.a(s.e, a, "Resume for active app");
            return;
        }
        if (b())
        {
            l1 = l - g;
        } else
        {
            l1 = 0L;
        }
        if (l1 < 0L)
        {
            jv.a(s.e, a, "Clock skew detected");
            l1 = l2;
        }
        if (l1 <= 60000L) goto _L2; else goto _L1
_L1:
        b(jg1, l1);
_L4:
        if (i == 0)
        {
            j = s1;
        }
        f = l;
        d = true;
        return;
_L2:
        if (l1 > 1000L)
        {
            i = i + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
