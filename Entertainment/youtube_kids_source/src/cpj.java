// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public class cpj
{

    public static final cpj a = new cpk(cpl.e(), "");
    public final cpl b;
    public final String c;

    cpj(cpl cpl1, String s)
    {
        b = (cpl)b.a(cpl1);
        c = (String)b.a(s);
    }

    public cpj(String s, String s1, String s2)
    {
        this(cpl.a(s, s1), s2);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof cpj))
            {
                return false;
            }
            obj = (cpj)obj;
            if (!TextUtils.equals(c, ((cpj) (obj)).c) || !b.equals(((cpj) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return c.hashCode();
    }

    public String toString()
    {
        if (this == a)
        {
            return "Identity{NO_IDENTITY}";
        } else
        {
            return String.format("Identity{managingAccountName='%s' onBehalfOfParameter='%s' id='%s'}", new Object[] {
                b.c(), b.d(), c
            });
        }
    }

}
