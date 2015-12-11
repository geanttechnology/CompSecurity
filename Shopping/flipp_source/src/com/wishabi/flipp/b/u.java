// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.os.Handler;
import com.wishabi.flipp.util.k;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.b:
//            w, v, x

public final class u extends Enum
{

    public static final u a;
    private static final u f[];
    public Context b;
    public Handler c;
    public HashMap d;
    private int e;

    private u(String s)
    {
        super(s, 0);
        e = 0;
        d = new HashMap();
    }

    static HashMap a(u u1)
    {
        return u1.d;
    }

    public static u valueOf(String s)
    {
        return (u)Enum.valueOf(com/wishabi/flipp/b/u, s);
    }

    public static u[] values()
    {
        return (u[])f.clone();
    }

    public final int a(String s, x x)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = k.a(null);
        }
        if (s1 == null)
        {
            c.post(new w(this, x));
            return -1;
        } else
        {
            int i = e;
            e = i + 1;
            (new v(this, s1, i, x)).execute(new Void[0]);
            return i;
        }
    }

    static 
    {
        a = new u("INSTANCE");
        f = (new u[] {
            a
        });
    }
}
