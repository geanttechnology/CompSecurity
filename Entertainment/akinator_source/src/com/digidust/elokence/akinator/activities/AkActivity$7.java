// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.Handler;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class val.amountGz
    implements Runnable
{

    final AkActivity this$0;
    final int val$amountGz;

    public void run()
    {
    /* block-local class not found */
    class _cls1 {}

        if (uiTextScoreGz != null)
        {
            (new Thread(new _cls1(new Handler()))).start();
        }
    }

    _cls1()
    {
        this$0 = final_akactivity;
        val$amountGz = I.this;
        super();
    }
}
