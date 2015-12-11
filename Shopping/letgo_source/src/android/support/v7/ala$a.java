// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.FutureTask;

// Referenced classes of package android.support.v7:
//            ala, akh

private static final class a extends FutureTask
    implements Comparable
{

    private final akh a;

    public int a(reTask retask)
    {
        reTask retask1 = a.n();
        reTask retask2 = retask.a.n();
        if (retask1 == retask2)
        {
            return a.a - retask.a.a;
        } else
        {
            return retask2.ordinal() - retask1.ordinal();
        }
    }

    public int compareTo(Object obj)
    {
        return a((a)obj);
    }

    public reTask(akh akh1)
    {
        super(akh1, null);
        a = akh1;
    }
}
