// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.view;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.Configuration;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import com.apptentive.android.sdk.module.engagement.interaction.model.UpgradeMessageInteraction;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.view:
//            InteractionView

public class UpgradeMessageInteractionView extends InteractionView
{

    private static final String CODE_POINT_DISMISS = "dismiss";

    public UpgradeMessageInteractionView(UpgradeMessageInteraction upgrademessageinteraction)
    {
        super(upgrademessageinteraction);
    }

    private Drawable getIconDrawableResourceId(Activity activity)
    {
        try
        {
            PackageInfo packageinfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            activity = activity.getResources().getDrawable(packageinfo.applicationInfo.icon);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e("Error loading app icon.", activity, new Object[0]);
            return null;
        }
        return activity;
    }

    public void doOnCreate(Activity activity, Bundle bundle)
    {
        activity.setContentView(com.apptentive.android.sdk.R.layout.apptentive_upgrade_message_interaction);
        bundle = (ImageView)activity.findViewById(com.apptentive.android.sdk.R.id.icon);
        Drawable drawable = getIconDrawableResourceId(activity);
        if (drawable != null)
        {
            bundle.setImageDrawable(drawable);
        } else
        {
            bundle.setVisibility(8);
        }
        bundle = (WebView)activity.findViewById(com.apptentive.android.sdk.R.id.webview);
        bundle.loadData(((UpgradeMessageInteraction)interaction).getBody(), "text/html", "UTF-8");
        bundle.setBackgroundColor(0);
        bundle = activity.findViewById(com.apptentive.android.sdk.R.id.apptentive_branding_view);
        if (bundle != null && (!((UpgradeMessageInteraction)interaction).isShowPoweredBy() || Configuration.load(activity).isHideBranding(activity)))
        {
            bundle.setVisibility(8);
        }
    }

    public boolean onBackPressed(Activity activity)
    {
        EngagementModule.engageInternal(activity, interaction, "dismiss");
        return true;
    }
}
