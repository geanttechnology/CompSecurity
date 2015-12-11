// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;

// Referenced classes of package com.google.tagmanager:
//            InstallReferrerUtil

public final class InstallReferrerService extends IntentService
{

    Context contextOverride;
    CampaignTrackingService gaService;

    public InstallReferrerService()
    {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String s)
    {
        super(s);
    }

    private void forwardToGoogleAnalytics(Context context, Intent intent)
    {
        if (gaService == null)
        {
            gaService = new CampaignTrackingService();
        }
        gaService.processIntent(context, intent);
    }

    protected void onHandleIntent(Intent intent)
    {
        String s = intent.getStringExtra("referrer");
        Context context;
        if (contextOverride != null)
        {
            context = contextOverride;
        } else
        {
            context = getApplicationContext();
        }
        InstallReferrerUtil.saveInstallReferrer(context, s);
        forwardToGoogleAnalytics(context, intent);
    }
}
