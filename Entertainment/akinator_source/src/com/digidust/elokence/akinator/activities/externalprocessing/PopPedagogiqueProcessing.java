// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.digidust.elokence.akinator.activities.PopPedagogiqueActivity;
import com.digidust.elokence.akinator.factories.AkApplicationProcessing;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.TraductionFactory;
import com.intentsoftware.addapptr.AATKit;

public class PopPedagogiqueProcessing
{

    private static final String TAG = "PopPedagogiqueActivity";
    private final PopPedagogiqueActivity activity;

    public PopPedagogiqueProcessing(PopPedagogiqueActivity poppedagogiqueactivity)
    {
        activity = poppedagogiqueactivity;
    }

    public void processRewardedVideo()
    {
        int i = AkApplicationProcessing.getInstance().getAAtkitPlacementId(10);
        if (AkApplicationProcessing.getInstance().getVideoRewardedState() == 1 && AATKit.hasAdForPlacement(i))
        {
            AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
            AkLog.d("PopPedagogiqueActivity", "Click video addapptr");
            AATKit.showPlacement(i);
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            builder.setCancelable(false);
            builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("PAS_DE_VIDEO_DISPONIBLE"));
            builder.setCancelable(false);
            builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final PopPedagogiqueProcessing this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = PopPedagogiqueProcessing.this;
                super();
            }
            });
            builder.create().show();
            return;
        }
    }
}
