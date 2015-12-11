// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class FeaturedLocationBarClickListener
    implements android.view.View.OnClickListener
{

    private Channel channel;
    private Context context;
    private IntentFactory intentFactory;
    private String locationBarText;
    private Logger logger;

    public FeaturedLocationBarClickListener(Context context1, String s, Channel channel1)
    {
        context = context1;
        locationBarText = s;
        channel = channel1;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public void onClick(View view)
    {
        logger.logClick("", "click_country_selector", channel.toString(), locationBarText);
        context.startActivity(intentFactory.newCountryOrDivisionSelector());
    }
}
