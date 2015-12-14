// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import javax.crypto.spec.SecretKeySpec;

public class brp
{

    protected String a;
    protected String b[];
    protected SecretKeySpec c;
    private String d;
    private String e;
    private long f;
    private String g;

    public brp(String s)
    {
        d = "";
        e = "";
        f = 0L;
        g = "";
        a = "";
        b = null;
        b = s.split("&");
        a = b("oauth_token_secret");
        d = b("oauth_token");
    }

    public brp(String s, String s1)
    {
        d = "";
        e = "";
        f = 0L;
        g = "";
        a = "";
        b = null;
        d = s;
        a = s1;
    }

    public String a()
    {
        return d;
    }

    public void a(String s)
    {
        g = s;
    }

    protected void a(SecretKeySpec secretkeyspec)
    {
        c = secretkeyspec;
    }

    public String b()
    {
        return g;
    }

    public String b(String s)
    {
        Object obj = null;
        String as[] = b;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                String s1 = obj;
                if (i < j)
                {
                    s1 = as[i];
                    if (!s1.startsWith((new StringBuilder()).append(s).append('=').toString()))
                    {
                        break label0;
                    }
                    s1 = s1.split("=")[1].trim();
                }
                return s1;
            }
            i++;
        } while (true);
    }

    public String c()
    {
        return a;
    }

    protected SecretKeySpec d()
    {
        return c;
    }
}
