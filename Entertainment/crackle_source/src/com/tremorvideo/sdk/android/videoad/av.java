// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            br, ad, n

public class av
{

    private br a;
    private int b;
    private boolean c;
    private String d;
    private int e;

    public av(br br1, String s)
    {
        a = br1;
        d = s;
        b = 0;
        e = 0;
        c = false;
    }

    public void a()
    {
        b = b + 1;
        c = false;
    }

    public boolean b()
    {
        return e > b;
    }

    public boolean c()
    {
        ad.d((new StringBuilder()).append(e).append(" out of ").append(a.b().size()).toString());
        return e >= a.b().size();
    }

    public n d()
    {
        n n1 = (n)a.b().get(e);
        if (e < a.b().size())
        {
            e = e + 1;
        }
        c = true;
        return n1;
    }

    public boolean e()
    {
        return b >= a.b().size();
    }

    public n f()
    {
        return (n)a.b().get(b);
    }

    public n g()
    {
        if (e < a.b().size())
        {
            return (n)a.b().get(e);
        } else
        {
            return null;
        }
    }

    public String h()
    {
        return d;
    }

    public br i()
    {
        return a;
    }

    public void j()
    {
        a.b().remove(e);
    }
}
