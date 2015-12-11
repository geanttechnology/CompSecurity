// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.h;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.GooglePlusLogInEventFactory;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.i.b.g.b.a;

public class GooglePlusResolutionActivity extends BaseAppCompatActivity
{

    private final EventAnalytics a;

    public GooglePlusResolutionActivity()
    {
        this(com.shazam.i.b.g.b.a.a());
    }

    public GooglePlusResolutionActivity(EventAnalytics eventanalytics)
    {
        a = eventanalytics;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        com.shazam.android.analytics.event.Event event;
        if (j == 0)
        {
            event = GooglePlusLogInEventFactory.createGooglePlusLogInEvent(com.shazam.android.analytics.event.factory.GooglePlusLogInEventFactory.GooglePlusLoginActions.CANCEL);
        } else
        if (j == -1)
        {
            event = GooglePlusLogInEventFactory.createGooglePlusLogInEvent(com.shazam.android.analytics.event.factory.GooglePlusLogInEventFactory.GooglePlusLoginActions.SUCCESS);
        } else
        {
            event = GooglePlusLogInEventFactory.createGooglePlusLogInEvent(com.shazam.android.analytics.event.factory.GooglePlusLogInEventFactory.GooglePlusLoginActions.ERROR);
        }
        a.logEvent(event);
        setResult(j, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (PendingIntent)getIntent().getParcelableExtra("com.shazam.android.activities.GooglePlusResolutionActivity.pendingIntent");
        if (bundle != null)
        {
            try
            {
                startIntentSenderForResult(bundle.getIntentSender(), 1000, null, 0, 0, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                setResult(-1);
            }
            a.logEvent(GooglePlusLogInEventFactory.createGooglePlusLogInEvent(com.shazam.android.analytics.event.factory.GooglePlusLogInEventFactory.GooglePlusLoginActions.SUCCESS));
            finish();
            return;
        } else
        {
            int i = getIntent().getIntExtra("com.shazam.android.activities.GooglePlusResolutionActivity.errorCode", 0);
            bundle = getSupportFragmentManager();
            com.shazam.android.fragment.e.a.a.b(i).a(bundle, "errorDialog");
            return;
        }
    }
}
