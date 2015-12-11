// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.n;

import com.shazam.android.j.u.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.a.a.b.a.c;
import org.a.a.b.a.d;
import org.a.a.b.a.e;

// Referenced classes of package com.shazam.n:
//            b, m, c, d

public final class f
    implements com.shazam.n.b
{

    private final com.shazam.n.d a;
    private final com.shazam.n.c b;
    private final m c;
    private final b d;
    private long e;
    private Long f;

    public f(com.shazam.n.d d1, com.shazam.n.c c1, m m1, b b1)
    {
        a = d1;
        b = c1;
        c = m1;
        d = b1;
    }

    public final long a()
    {
        long l = c.b();
        long l1 = f.longValue();
        return (l - e) + l1;
    }

    public final boolean b()
    {
        return f != null;
    }

    public final void c()
    {
        Long long1;
        Iterator iterator;
        long1 = f;
        f = null;
        iterator = d.a().iterator();
_L10:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (String)iterator.next();
        long l2;
        e = c.b();
        l2 = c.a();
        obj = a.a(b.a(((String) (obj))));
        if (((d) (obj)).f) goto _L4; else goto _L3
_L3:
        e e1;
        e e2;
        e e3;
        long l3;
        long l4;
        long l5;
        obj.f = true;
        if (((d) (obj)).b == null)
        {
            obj.b = new ArrayList();
        }
        e1 = ((d) (obj)).a.c();
        l3 = org.a.a.b.a.e.a(e1.a);
        e2 = ((d) (obj)).a.d();
        l4 = org.a.a.b.a.e.a(e2.a);
        e3 = ((d) (obj)).a.b();
        l5 = org.a.a.b.a.e.a(e3.a);
        if (e1.a != 0L) goto _L6; else goto _L5
_L5:
        if (e3.a == 0L) goto _L8; else goto _L7
_L7:
        obj.d = Long.valueOf(l5 - ((d) (obj)).e);
        ((d) (obj)).b.add("Error: zero orig time -- cannot compute delay");
_L4:
        if (((d) (obj)).d == null) goto _L10; else goto _L9
_L9:
        f = Long.valueOf(((d) (obj)).d.longValue() + l2);
        return;
_L8:
        ((d) (obj)).b.add("Error: zero orig time -- cannot compute delay/offset");
          goto _L4
_L6:
        if (e2.a != 0L && e3.a != 0L)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        ((d) (obj)).b.add("Warning: zero rcvNtpTime or xmitNtpTime");
        if (l3 <= ((d) (obj)).e) goto _L12; else goto _L11
_L11:
        ((d) (obj)).b.add("Error: OrigTime > DestRcvTime");
_L15:
        if (e2.a == 0L) goto _L14; else goto _L13
_L13:
        obj.d = Long.valueOf(l4 - l3);
          goto _L4
_L12:
        obj.c = Long.valueOf(((d) (obj)).e - l3);
          goto _L15
_L14:
        if (e3.a == 0L) goto _L4; else goto _L16
_L16:
        obj.d = Long.valueOf(l5 - ((d) (obj)).e);
          goto _L4
        long l1 = ((d) (obj)).e - l3;
        if (l5 >= l4) goto _L18; else goto _L17
_L17:
        ((d) (obj)).b.add("Error: xmitTime < rcvTime");
        long l = l1;
_L20:
        obj.c = Long.valueOf(l);
        if (l3 > ((d) (obj)).e)
        {
            ((d) (obj)).b.add("Error: OrigTime > DestRcvTime");
        }
        obj.d = Long.valueOf(((l4 - l3) + (l5 - ((d) (obj)).e)) / 2L);
          goto _L4
_L22:
        if (l - l1 != 1L)
        {
            break MISSING_BLOCK_LABEL_520;
        }
        l = l1;
        if (l1 == 0L) goto _L20; else goto _L19
_L19:
        ((d) (obj)).b.add("Info: processing time > total network time by 1 ms -> assume zero delay");
        l = 0L;
          goto _L20
        ((d) (obj)).b.add("Warning: processing time > total network time");
        l = l1;
          goto _L20
_L2:
        if (f == null)
        {
            f = long1;
        }
        return;
        IOException ioexception;
        ioexception;
          goto _L10
_L18:
        l = l5 - l4;
        if (l > l1) goto _L22; else goto _L21
_L21:
        l = l1 - l;
          goto _L20
    }
}
