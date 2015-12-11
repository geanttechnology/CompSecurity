// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class tf
{

    final long a;
    final String b;

    tf(long l, String s)
    {
        a = l;
        b = s;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof tf) || ((tf)obj).a != a) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return (int)a;
    }
}
