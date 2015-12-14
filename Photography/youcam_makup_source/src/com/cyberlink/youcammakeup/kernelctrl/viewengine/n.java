// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            k, f, ViewEngine, a, 
//            q

public abstract class n
{

    protected long a;
    protected long b;
    protected ViewEngine.TaskRole c;
    protected HashMap d;
    protected a e;
    protected f f;
    private Object g;

    n()
    {
        g = null;
        f = null;
    }

    static Object a(n n1)
    {
        return n1.g;
    }

    static Object a(n n1, Object obj)
    {
        n1.g = obj;
        return obj;
    }

    public abstract q a();

    protected void a(String s)
    {
        getClass().getName();
    }

    public void b()
    {
        a((new StringBuilder()).append("Self-Cancel the Task Due to the Role Canceled.:").append(k.a(d)).toString());
        com.cyberlink.youcammakeup.kernelctrl.viewengine.f.a(f).put(Long.valueOf(a), com.cyberlink.youcammakeup.kernelctrl.viewengine.f.c(f));
        ViewEngine.a(com.cyberlink.youcammakeup.kernelctrl.viewengine.f.d(f), a);
        a((new StringBuilder()).append("Canceled the handling Task imageID:").append(d.get("imageID")).append(" func_name:").append(getClass().getName()).toString());
    }
}
