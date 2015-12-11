// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            anp

public class anr
    implements anp
{

    private final long a;
    private final int b;

    public anr(long l, int i)
    {
        a = l;
        b = i;
    }

    public long getDelayMillis(int i)
    {
        return (long)((double)a * Math.pow(b, i));
    }
}
