// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            js, hn, kg, ls

public class hm
{

    private static final String b = com/flurry/sdk/hm.getSimpleName();
    boolean a;
    private final hn c;
    private final File d;
    private String e;

    public hm()
    {
        this(js.a().c());
    }

    public hm(Context context)
    {
        c = new hn();
        d = context.getFileStreamPath(".flurryinstallreceiver.");
        kg.a(3, b, (new StringBuilder()).append("Referrer file name if it exists:  ").append(d).toString());
    }

    private void b(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            e = s;
            return;
        }
    }

    private void c()
    {
        if (a)
        {
            return;
        } else
        {
            a = true;
            kg.a(4, b, (new StringBuilder()).append("Loading referrer info from file: ").append(d.getAbsolutePath()).toString());
            String s = ls.c(d);
            kg.a(b, (new StringBuilder()).append("Referrer file contents: ").append(s).toString());
            b(s);
            return;
        }
    }

    private void d()
    {
        ls.a(d, e);
    }

    public Map a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Map map;
        c();
        map = c.a(e);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        a();
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        d.delete();
        e = null;
        a = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        a = true;
        b(s);
        d();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String b()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        c();
        s = e;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

}
