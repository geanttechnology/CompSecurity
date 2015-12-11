// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class cjj
    implements apm
{

    cku a;
    bwb b;
    bwb c;
    private cjh d;

    cjj(cjh cjh1)
    {
        d = cjh1;
        super();
    }

    final void a(int i)
    {
        if (!cjh.b(d) && b != null && c != null || cjh.b(d) && c != null)
        {
            cjh.c(d).a(b, c, a.c, a.d, a.e, i);
        }
    }

    public final void a(int i, String s, int j)
    {
        if (i == d.a.get() && cjh.a(d) != null && a != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        j;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 172
    //                   1 177
    //                   2 182;
           goto _L3 _L4 _L5 _L6
_L3:
        i = -1;
_L12:
        if (i == -1) goto _L1; else goto _L7
_L7:
        String s1;
        Object obj;
        obj = cjh.a(d);
        j = bxa.a(s);
        s1 = bxa.b(s);
        obj = ((bww) (obj)).a.iterator();
_L11:
        if (!((Iterator) (obj)).hasNext()) goto _L9; else goto _L8
_L8:
        s = (bwb)((Iterator) (obj)).next();
        if (((bwb) (s)).a.b != j || !TextUtils.equals(((bwb) (s)).a.q, s1)) goto _L11; else goto _L10
_L10:
        s = (bwb)b.a(s);
        if (!s.f())
        {
            continue; /* Loop/switch isn't completed */
        }
        b = s;
_L14:
        a(i);
        return;
_L4:
        i = 0;
          goto _L12
_L5:
        i = 1;
          goto _L12
_L6:
        i = 2;
          goto _L12
_L9:
        s = null;
          goto _L10
        if (!s.g()) goto _L1; else goto _L13
_L13:
        c = s;
          goto _L14
    }
}
