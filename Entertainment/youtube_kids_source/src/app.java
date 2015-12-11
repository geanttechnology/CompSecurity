// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class app
{

    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;

    public app(String s, String s1, int i, int j, int k, int l, int i1, 
            String s2)
    {
        this(s, s1, i, j, k, l, i1, s2, null);
    }

    public app(String s, String s1, int i, int j, int k, int l, int i1, 
            String s2, String s3)
    {
        a = (String)a.b(s);
        b = s1;
        c = i;
        d = j;
        e = i1;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            return ((app)obj).a.equals(a);
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }
}
