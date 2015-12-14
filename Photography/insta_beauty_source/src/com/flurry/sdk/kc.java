// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            jx, ka, kb, js, 
//            kq

public class kc
{

    private static kc a = null;
    private final jx b = new jx();
    private final jx c = new jx();

    private kc()
    {
    }

    public static kc a()
    {
        com/flurry/sdk/kc;
        JVM INSTR monitorenter ;
        kc kc1;
        if (a == null)
        {
            a = new kc();
        }
        kc1 = a;
        com/flurry/sdk/kc;
        JVM INSTR monitorexit ;
        return kc1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/kc;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.c();
            a = null;
        }
        com/flurry/sdk/kc;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(ka ka1)
    {
        if (ka1 != null)
        {
            Iterator iterator = c(ka1.a()).iterator();
            while (iterator.hasNext()) 
            {
                kb kb1 = (kb)iterator.next();
                js.a().b(new _cls1(kb1, ka1));
            }
        }
    }

    public void a(kb kb1)
    {
        this;
        JVM INSTR monitorenter ;
        if (kb1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kb1 = new kq(kb1);
        String s;
        for (Iterator iterator = c.a(kb1).iterator(); iterator.hasNext(); b.b(s, kb1))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_69;
        kb1;
        throw kb1;
        c.b(kb1);
          goto _L1
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kq kq1;
        for (Iterator iterator = b.a(s).iterator(); iterator.hasNext(); c.b(kq1, s))
        {
            kq1 = (kq)iterator.next();
        }

        break MISSING_BLOCK_LABEL_67;
        s;
        throw s;
        b.b(s);
          goto _L1
    }

    public void a(String s, kb kb1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag && kb1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kb1 = new kq(kb1);
        if (!b.c(s, kb1))
        {
            b.a(s, kb1);
            c.a(kb1, s);
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public int b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = b.a(s).size();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void b(String s, kb kb1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kb1 = new kq(kb1);
        b.b(s, kb1);
        c.b(kb1, s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    public List c(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = Collections.emptyList();
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        ArrayList arraylist;
        arraylist = new ArrayList();
        s = b.a(s).iterator();
_L3:
        kb kb1;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        kb1 = (kb)((kq)s.next()).get();
        if (kb1 != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        s.remove();
          goto _L3
        s;
        throw s;
        arraylist.add(kb1);
          goto _L3
        s = arraylist;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        b.a();
        c.a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1 extends ly
    {

        final kb a;
        final ka b;
        final kc c;

        public void a()
        {
            a.a(b);
        }

        _cls1(kb kb1, ka ka1)
        {
            c = kc.this;
            a = kb1;
            b = ka1;
            super();
        }
    }

}
