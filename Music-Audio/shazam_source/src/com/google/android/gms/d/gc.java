// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Bundle;
import com.google.android.gms.ads.internal.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.d:
//            gd

public final class gc
{
    private static final class a
    {

        public long a;
        public long b;

        public a()
        {
            a = -1L;
            b = -1L;
        }
    }


    public final gd a;
    public final LinkedList b;
    public final Object c;
    public long d;
    public long e;
    public boolean f;
    public long g;
    public long h;
    public long i;
    public long j;
    private final String k;
    private final String l;

    private gc(gd gd, String s, String s1)
    {
        c = new Object();
        d = -1L;
        e = -1L;
        f = false;
        g = -1L;
        h = 0L;
        i = -1L;
        j = -1L;
        a = gd;
        k = s;
        l = s1;
        b = new LinkedList();
    }

    public gc(String s, String s1)
    {
        this(p.h(), s, s1);
    }

    public final Bundle a()
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        ArrayList arraylist;
        obj1 = new Bundle();
        ((Bundle) (obj1)).putString("seq_num", k);
        ((Bundle) (obj1)).putString("slotid", l);
        ((Bundle) (obj1)).putBoolean("ismediation", f);
        ((Bundle) (obj1)).putLong("treq", i);
        ((Bundle) (obj1)).putLong("tresponse", j);
        ((Bundle) (obj1)).putLong("timp", e);
        ((Bundle) (obj1)).putLong("tload", g);
        ((Bundle) (obj1)).putLong("pcc", h);
        ((Bundle) (obj1)).putLong("tfetch", d);
        arraylist = new ArrayList();
        Bundle bundle;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); arraylist.add(bundle))
        {
            a a1 = (a)iterator.next();
            bundle = new Bundle();
            bundle.putLong("topen", a1.a);
            bundle.putLong("tclose", a1.b);
        }

        break MISSING_BLOCK_LABEL_192;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((Bundle) (obj1)).putParcelableArrayList("tclick", arraylist);
        obj;
        JVM INSTR monitorexit ;
        return ((Bundle) (obj1));
    }
}
