// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            ne

public static class b
{

    final long a;
    final String b;

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof b) || ((b)obj).a != a) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return (int)a;
    }

    (long l, String s)
    {
        a = l;
        b = s;
    }
}
