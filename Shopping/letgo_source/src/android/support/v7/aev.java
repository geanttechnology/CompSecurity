// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            afv, afj, aes, aep, 
//            agq, afk, aeu, aet

public final class aev
{

    private afv a;
    private afj b;
    private aet c;
    private final Map d = new HashMap();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private boolean g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    public aev()
    {
        a = afv.a;
        b = afj.a;
        c = aes.a;
        i = 2;
        j = 2;
        m = true;
    }

    private void a(String s, int i1, int j1, List list)
    {
        if (s == null || "".equals(s.trim())) goto _L2; else goto _L1
_L1:
        s = new aep(s);
_L6:
        list.add(afk.a(agq.b(java/util/Date), s));
        list.add(afk.a(agq.b(java/sql/Timestamp), s));
        list.add(afk.a(agq.b(java/sql/Date), s));
_L4:
        return;
_L2:
        if (i1 == 2 || j1 == 2) goto _L4; else goto _L3
_L3:
        s = new aep(i1, j1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public aeu a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(e);
        Collections.reverse(arraylist);
        arraylist.addAll(f);
        a(h, i, j, ((List) (arraylist)));
        return new aeu(a, c, d, g, k, o, m, n, l, b, arraylist);
    }
}
