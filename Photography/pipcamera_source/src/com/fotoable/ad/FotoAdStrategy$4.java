// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.util.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package com.fotoable.ad:
//            FotoAdStrategy

final class val.suc
    implements Runnable
{

    final boolean val$suc;
    final WeakReference val$weakReference;

    public void run()
    {
        if (val$weakReference.get() != null)
        {
            ((toAdStrategyListener)val$weakReference.get()).onAdInReterund(val$suc);
            return;
        } else
        {
            Log.e("FotoAdStrategy", "error listener get null");
            return;
        }
    }

    toAdStrategyListener()
    {
        val$weakReference = weakreference;
        val$suc = flag;
        super();
    }
}
