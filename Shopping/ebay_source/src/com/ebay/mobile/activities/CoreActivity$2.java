// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.shell.app.TrackingSupport;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

static final class le extends ActionBarDrawerToggle
{

    final Activity val$a;

    public void onDrawerOpened(View view)
    {
        super.onDrawerOpened(view);
        if (val$a instanceof TrackingSupport)
        {
            view = ((TrackingSupport)val$a).getTrackingEventName();
            TrackingData trackingdata = new TrackingData("Menu", TrackingType.EVENT);
            if (view != null)
            {
                trackingdata.addSourceIdentification(new SourceIdentification(view));
            }
            trackingdata.send(val$a);
        }
    }

    public void onDrawerSlide(View view, float f)
    {
        super.onDrawerSlide(view, f);
        val$a.findViewById(0x7f10016d).setTranslationX((float)view.getWidth() * f);
    }

    public void onDrawerStateChanged(int i)
    {
        super.onDrawerStateChanged(i);
    }

    tification(Activity activity, DrawerLayout drawerlayout, Toolbar toolbar, int i, int j, Activity activity1)
    {
        val$a = activity1;
        super(activity, drawerlayout, toolbar, i, j);
    }
}
