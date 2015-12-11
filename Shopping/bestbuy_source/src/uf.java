// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class uf
{

    private String a;
    private String b;
    private String c;
    private String d;

    public uf()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        a = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        b = null;
        c = null;
        d = null;
    }

    public uf(String s, String s1, String s2, String s3)
    {
        a = null;
        b = null;
        c = null;
        d = null;
        if (TextUtils.isEmpty(s))
        {
            a = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
        } else
        {
            a = s;
        }
        b = s1;
        c = s2;
        d = s3;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }
}
