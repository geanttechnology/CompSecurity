// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;

// Referenced classes of package com.ebay.mobile.events:
//            EventViewModel, EventItemsFragment

public class EventItemsActivity extends BaseActivity
{

    public static final String EXTRA_DEPARTMENT_SUB_CHANNEL = "departmentSubChannel";
    public static final String EXTRA_EVENT_ENDS_TEXT = "endsText";
    public static final String EXTRA_EVENT_GROUP_ID = "eventGroupId";
    public static final String EXTRA_EVENT_ID = "eventId";
    public static final String EXTRA_EVENT_IMAGE_URL = "coverImageUrl";
    public static final String EXTRA_EVENT_SEO_NAME = "eventSeoName";
    public static final String EXTRA_EVENT_SHARE_URL = "shareUrl";
    public static final String EXTRA_EVENT_TITLE = "eventTitle";
    private static boolean isTablet;
    private EventItemsFragment currentFragment;

    public EventItemsActivity()
    {
    }

    public static void startActivity(Activity activity, EventViewModel eventviewmodel, String s, String s1, SourceIdentification sourceidentification)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/events/EventItemsActivity);
        intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
        intent.putExtra("eventId", eventviewmodel.eventId);
        intent.putExtra("eventGroupId", eventviewmodel.eventGroupId);
        intent.putExtra("departmentSubChannel", s);
        intent.putExtra("eventTitle", eventviewmodel.title);
        intent.putExtra("coverImageUrl", eventviewmodel.rppEvent.skinnyHeroImageUrl);
        intent.putExtra("endsText", s1);
        intent.putExtra("shareUrl", eventviewmodel.rppEvent.url);
        activity.startActivity(intent);
    }

    public String getTrackingEventName()
    {
        return "SalesEventsDetail";
    }

    public void onBackPressed()
    {
        if (currentFragment.isRefinePanelOpen())
        {
            currentFragment.closeRefinePanel();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300a4);
        currentFragment = (EventItemsFragment)getFragmentManager().findFragmentById(0x7f1001ad);
        currentFragment.processArguments(getIntent());
        isTablet = getResources().getBoolean(0x7f0b0006);
    }

    protected void onDestroy()
    {
        currentFragment = null;
        super.onDestroy();
    }

    protected void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        Intent intent = getIntent();
        trackingdata.addKeyValuePair("chnl", intent.getStringExtra("departmentSubChannel"));
        trackingdata.addKeyValuePair("eid", intent.getStringExtra("eventId"));
        trackingdata.addKeyValuePair("egid", intent.getStringExtra("eventGroupId"));
        trackingdata.addSourceIdentification(getIntent());
        trackingdata.send(this);
    }
}
