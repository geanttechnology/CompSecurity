// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class bnx
    implements cqk
{

    final boa a;
    final Context b;
    volatile ConcurrentHashMap c;
    private final Executor d;

    protected bnx()
    {
        b = null;
        a = null;
        d = null;
        c = new ConcurrentHashMap();
    }

    public bnx(Context context, boa boa1, Executor executor)
    {
        b = (Context)b.a(context);
        a = (boa)b.a(boa1);
        d = (Executor)b.a(executor);
        c = new ConcurrentHashMap();
    }

    private Future a(cpl cpl1, boolean flag)
    {
        String s;
        bhw bhw1;
        boolean flag1;
        flag1 = false;
        s = cpl1.c();
        bhw1 = bhw.a();
        cpl1 = a;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Account aaccount[];
        int i;
        int j;
        aaccount = cpl1.a();
        j = aaccount.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L3
_L3:
        cpl1 = aaccount[i];
        if (!TextUtils.equals(((Account) (cpl1)).name, s)) goto _L5; else goto _L4
_L4:
        i = ((flag1) ? 1 : 0);
        if (cpl1 != null)
        {
            i = 1;
        }
        if (i == 0)
        {
            bhw1.a(null, bnz.a(new IllegalStateException("Account removed from device.")));
            return bhw1;
        }
        break; /* Loop/switch isn't completed */
_L5:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        cpl1 = null;
        if (true) goto _L4; else goto _L6
_L6:
        cpl1 = (String)c.get(s);
        if (!flag && cpl1 != null)
        {
            bhw1.a(null, bnz.a(cpl1));
            return bhw1;
        }
        d.execute(new bny(this, s, bhw1));
        return bhw1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final Future a(cpl cpl1)
    {
        return a(cpl1, false);
    }

    public final void a()
    {
        String s;
        for (Iterator iterator = c.values().iterator(); iterator.hasNext(); atz.a(b, s))
        {
            s = (String)iterator.next();
        }

        c.clear();
    }

    public final Future b(cpl cpl1)
    {
        return a(cpl1, true);
    }
}
