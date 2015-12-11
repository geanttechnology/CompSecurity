// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;

// Referenced classes of package android.support.v7:
//            amq, aoc

public class aog
    implements Runnable
{

    private final Context a;
    private final aoc b;

    public aog(Context context, aoc aoc1)
    {
        a = context;
        b = aoc1;
    }

    public void run()
    {
        try
        {
            amq.a(a, "Performing time based file roll over.");
            if (!b.rollFileOver())
            {
                b.cancelTimeBasedFileRollOver();
            }
            return;
        }
        catch (Exception exception)
        {
            amq.a(a, "Failed to roll over file", exception);
        }
    }
}
