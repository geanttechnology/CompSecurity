// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.util.Log;
import ix;
import iy;

// Referenced classes of package com.fotoable.ad:
//            FotoAdFactory

final class val.autoDisplay
    implements Runnable
{

    final boolean val$autoDisplay;
    final Context val$ctx;
    final String val$fbid;

    public void run()
    {
        Log.d("AbroadInterstitialAd", "onInterstitialRequest");
        if (FotoAdFactory.access$000() == null)
        {
            iy _tmp = FotoAdFactory.access$002(ix.d(val$ctx));
        }
        if (FotoAdFactory.access$000() != null)
        {
            FotoAdFactory.access$000().a(val$ctx, val$fbid, val$autoDisplay);
        }
    }

    ()
    {
        val$ctx = context;
        val$fbid = s;
        val$autoDisplay = flag;
        super();
    }
}
