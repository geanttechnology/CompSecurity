// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public class cpl
{

    private static final cpl a = new cpm(null, null);
    private final String b;
    private final String c;

    cpl(String s, String s1)
    {
        b = s;
        c = s1;
    }

    public static cpl a(String s, String s1)
    {
        b.a(s);
        return new cpl(s, s1);
    }

    public static cpl e()
    {
        return a;
    }

    public final boolean a()
    {
        return this != a;
    }

    public final boolean b()
    {
        return !TextUtils.isEmpty(c);
    }

    public String c()
    {
        return b;
    }

    public String d()
    {
        return c;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof cpl))
            {
                return false;
            }
            obj = (cpl)obj;
            if (!TextUtils.equals(c, ((cpl) (obj)).c) || !TextUtils.equals(b, ((cpl) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        return String.format("IdentityProperties{managingAccountName='%s' onBehalfOfParameter='%s'}", new Object[] {
            c(), d()
        });
    }

}
