// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.ArrayList;

final class aeq
    implements Runnable
{

    private aep a;

    aeq(aep aep1)
    {
        a = aep1;
        super();
    }

    public final void run()
    {
        int j;
        int k;
        j = a.c();
        k = a.a.size();
        int i = 0;
_L2:
        if (i >= j - k)
        {
            break; /* Loop/switch isn't completed */
        }
        a.a.add(a.b());
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Log.e("PresenterPool", exception.getMessage());
_L1:
    }
}
