// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cc;


// Referenced classes of package myobfuscated.cc:
//            a

public final class b
{

    public int a;
    public int b;
    public int c;
    private a d;

    public b(a a1, int i, int j, int k)
    {
        d = a1;
        super();
        a = i;
        b = j;
        c = k;
    }

    public final Object clone()
    {
        return new b(d, a, b, c);
    }
}
