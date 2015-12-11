// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.util.Log;
import com.crittercism.app.Crittercism;

// Referenced classes of package com.smule.android.network.core:
//            b

final class a
    implements Runnable
{

    final Runnable a;

    public void run()
    {
        try
        {
            a.run();
            return;
        }
        catch (Exception exception)
        {
            Log.e(b.j(), "Uncaught exception in a NETWORK thread!", exception);
            Crittercism.a("MagicNetwork.wrapRunnable()");
            Crittercism.a(exception);
            return;
        }
    }

    (Runnable runnable)
    {
        a = runnable;
        super();
    }
}
