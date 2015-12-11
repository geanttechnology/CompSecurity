// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.mdotm.android.listener.InterstitialActionListener;
import com.mdotm.android.model.MdotMAdResponse;
import com.mdotm.android.utils.MdotMLogger;

// Referenced classes of package com.mdotm.android.view:
//            MdotMActivity

class val.clickedUrl extends Thread
{

    final MdotMActivity this$0;
    private final String val$clickedUrl;

    public void run()
    {
        adClicked();
        MdotMLogger.i(this, (new StringBuilder("Launch type is ")).append(MdotMActivity.access$5(MdotMActivity.this).getLaunchType()).toString());
        if (MdotMActivity.access$5(MdotMActivity.this).getLaunchType() == 2)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(val$clickedUrl));
            intent.addFlags(0x10000000);
            try
            {
                startActivity(intent);
            }
            catch (Exception exception)
            {
                MdotMLogger.i(this, (new StringBuilder("Could not open browser on ad click to ")).append(exception).toString());
            }
            videoAdSelectionInProgress = false;
            if (MdotMActivity.access$1(MdotMActivity.this) != null)
            {
                MdotMActivity.access$1(MdotMActivity.this).onLeave();
            }
            return;
        } else
        {
    /* block-local class not found */
    class _cls1 {}

            handler.post(new _cls1(val$clickedUrl));
            return;
        }
    }


    _cls1()
    {
        this$0 = final_mdotmactivity;
        val$clickedUrl = String.this;
        super();
    }
}
