// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;

// Referenced classes of package android.support.v7:
//            nn, nj

public final class ng
{

    private String a;
    private int b;

    public ng()
    {
        this((String)nn.b.b(), -1);
    }

    public ng(String s)
    {
        this(s, -1);
    }

    public ng(String s, int i)
    {
        b = -1;
        if (TextUtils.isEmpty(s))
        {
            s = (String)nn.b.b();
        }
        a = s;
        b = i;
    }

    public String a()
    {
        return a;
    }

    public int b()
    {
        return b;
    }
}
