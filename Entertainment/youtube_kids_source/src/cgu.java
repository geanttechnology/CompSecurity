// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public abstract class cgu
    implements Serializable
{

    private final String a;

    public cgu(String s)
    {
        b.a(s);
        a = s;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof cgu))
        {
            return false;
        } else
        {
            obj = (cgu)obj;
            return a.equals(((cgu) (obj)).a);
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public String toString()
    {
        return a;
    }
}
