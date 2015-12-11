// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            anp, ans

public class ant
{

    private final int a;
    private final anp b;
    private final ans c;

    public ant(int i, anp anp1, ans ans)
    {
        a = i;
        b = anp1;
        c = ans;
    }

    public ant(anp anp1, ans ans)
    {
        this(0, anp1, ans);
    }

    public long a()
    {
        return b.getDelayMillis(a);
    }

    public ant b()
    {
        return new ant(a + 1, b, c);
    }

    public ant c()
    {
        return new ant(b, c);
    }
}
