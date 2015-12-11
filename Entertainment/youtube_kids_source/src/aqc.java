// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aqc
{

    public int a;
    public int b;
    public int c[];
    public int d[];
    public long e[];
    public boolean f[];
    public boolean g;
    public boolean h[];
    public int i;
    public ati j;
    public boolean k;

    aqc()
    {
    }

    public final void a(int l)
    {
        if (j == null || j.a.length < l)
        {
            j = new ati(l);
        }
        i = l;
        g = true;
        k = true;
    }

    public final long b(int l)
    {
        return e[l] + (long)d[l];
    }
}
