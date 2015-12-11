// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public abstract class azg
{

    public final azv a;
    public final String b;
    public azy c;

    protected azg(String s, String s1, String s2)
    {
        a.j(s);
        b = s;
        a = new azv(s1);
        if (!TextUtils.isEmpty(s2))
        {
            s1 = a;
            if (TextUtils.isEmpty(s2))
            {
                s = null;
            } else
            {
                s = String.format("[%s] ", new Object[] {
                    s2
                });
            }
            s1.b = s;
        }
    }

    public void a(String s)
    {
    }

    protected final void a(String s, long l, String s1)
    {
        s1 = a;
        c.a(b, s, l);
    }

    protected final long c()
    {
        return c.a();
    }

    public void d()
    {
    }
}
