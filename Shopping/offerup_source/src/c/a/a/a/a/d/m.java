// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.d;

import android.content.Context;
import c.a.a.a.a.b.l;

// Referenced classes of package c.a.a.a.a.d:
//            j

public final class m
    implements Runnable
{

    private final Context a;
    private final j b;

    public m(Context context, j j1)
    {
        a = context;
        b = j1;
    }

    public final void run()
    {
        try
        {
            l.a(a, "Performing time based file roll over.");
            if (!b.rollFileOver())
            {
                b.cancelTimeBasedFileRollOver();
            }
            return;
        }
        catch (Exception exception)
        {
            l.b(a, "Failed to roll over file");
        }
    }
}
