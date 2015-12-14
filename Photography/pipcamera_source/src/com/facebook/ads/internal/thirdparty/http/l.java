// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;


// Referenced classes of package com.facebook.ads.internal.thirdparty.http:
//            o, j

public abstract class l
{

    protected String a;
    protected j b;
    protected String c;
    protected byte d[];

    public l(String s, o o1)
    {
        a = "";
        if (s != null)
        {
            a = s;
        }
        if (o1 != null)
        {
            s = o1.a();
            a = (new StringBuilder()).append(a).append("?").append(s).toString();
        }
    }

    public String a()
    {
        return a;
    }

    public j b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public byte[] d()
    {
        return d;
    }
}
