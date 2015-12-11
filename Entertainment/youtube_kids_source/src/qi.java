// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Executor;

public final class qi
    implements qs
{

    final biz a;
    final Executor b;
    private final SharedPreferences c;
    private qj d;
    private volatile boolean e;
    private final qj f;

    public qi(Context context, SharedPreferences sharedpreferences, Executor executor)
    {
        f = new qj(this, cpj.a, qv.a);
        b.a(context);
        c = (SharedPreferences)b.a(sharedpreferences);
        a = new qn(context, "identity.db");
        b = bhz.a((Executor)b.a(executor));
        e = false;
    }

    private void c()
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        boolean flag = e;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        String s1;
        String s2;
        s1 = c.getString("user_account", null);
        s2 = c.getString("user_identity_id", null);
        if (s1 == null || s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        String s = c.getString("user_identity", null);
        if (!"No +Page Delegate".equals(s))
        {
            obj = s;
        }
        d = new qj(this, new cpj(s1, ((String) (obj)), s2));
        c.getString("username", null);
        c.getString("user_channel_id", null);
_L4:
        e = true;
        if (true) goto _L1; else goto _L3
        obj;
        throw obj;
_L3:
        d = f;
          goto _L4
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        cpj cpj1;
        cpj cpj2;
        if (!e)
        {
            c();
        }
        cpj1 = d.a;
        cpj2 = cpj.a;
        boolean flag;
        if (cpj1 != cpj2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final cpj b()
    {
        this;
        JVM INSTR monitorenter ;
        cpj cpj1;
        if (!e)
        {
            c();
        }
        cpj1 = d.a;
        this;
        JVM INSTR monitorexit ;
        return cpj1;
        Exception exception;
        exception;
        throw exception;
    }
}
