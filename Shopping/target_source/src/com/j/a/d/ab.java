// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

// Referenced classes of package com.j.a.d:
//            z, h

public class ab
{

    private static ab c;
    HashSet a;
    HashMap b;
    private Method d;
    private android.view.View.OnLayoutChangeListener e;
    private android.view.View.OnLayoutChangeListener f;

    public ab()
    {
        d = null;
        a = new HashSet();
        b = new HashMap();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            e = new z(this);
            f = new h(this);
        }
    }

    public static ab a()
    {
        if (c != null)
        {
            return c;
        } else
        {
            c = new ab();
            return c;
        }
    }

    public void a(Method method)
    {
        d = method;
    }

    public HashMap b()
    {
        return b;
    }

    public HashSet c()
    {
        return a;
    }

    public android.view.View.OnLayoutChangeListener d()
    {
        return e;
    }

    public android.view.View.OnLayoutChangeListener e()
    {
        return f;
    }

    public Method f()
    {
        return d;
    }
}
