// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.handlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.g;
import io.presage.formats.NewFormatDescriptor;
import io.presage.formats.NewHelperDescriptor;
import io.presage.utils.e;

public class LaunchActivityFormatHandler extends io.presage.activities.PresageActivity.ActivityHandler
{

    private NewAdController b;

    public LaunchActivityFormatHandler(Activity activity)
    {
        super(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = a.getIntent().getExtras();
        if (!bundle.containsKey("ad"))
        {
            e.c(new String[] {
                "Unable to display an ad.", "The ad is not provided in the extras in the tag 'ad'."
            });
        } else
        {
            NewAd newad = NewAd.fromJsonString(bundle.getString("ad"));
            Object obj = newad.getFormatDescriptor();
            String s = (String)((NewFormatDescriptor) (obj)).getParameterValue("helper", java/lang/String);
            if (s == null)
            {
                e.c(new String[] {
                    "Unable to display an ad.", " The helper name is not provided in the viewer in the tag 'params/helper'."
                });
            } else
            {
                obj = new NewHelperDescriptor(s, ((NewFormatDescriptor) (obj)).getParameters());
                g.a();
                b = g.a(bundle.getString("controller")).a(bundle.getInt("flags")).a(a, newad, ((io.presage.ads.NewAdViewerDescriptor) (obj)));
                b.showAd();
                return;
            }
        }
        a.finish();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (a.isFinishing() && b != null && b.isAdDisplayed())
        {
            b.hideAd();
            e.b(new String[] {
                "coin-coin", "destroy"
            });
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putBoolean("isResumed", true);
    }
}
