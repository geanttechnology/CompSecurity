// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.groupon.activity.BookingMetaData;
import com.groupon.activity.IntentFactory;
import com.groupon.service.LoginService;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            VolatileTravelerNameProvider, ImageUrl

public class TravelerNameHelper
{

    private static final String TRAVEL_NAME_PENDING = "traveler_name_pending";
    private final Activity activity;
    private BookingMetaData bookingMetaData;
    private ImageUrl dealImageUrl;
    private boolean dealIsReady;
    private String dealTitle;
    private String firstname;
    private final IntentFactory intentFactory;
    private String lastname;
    private final LoginService loginService;
    private final TextView textView;
    private boolean travelerNamePending;
    private final VolatileTravelerNameProvider volatileTravelerNameProvider;

    public TravelerNameHelper(Activity activity1, VolatileTravelerNameProvider volatiletravelernameprovider, LoginService loginservice, TextView textview, IntentFactory intentfactory)
    {
        travelerNamePending = false;
        dealIsReady = false;
        activity = activity1;
        volatileTravelerNameProvider = volatiletravelernameprovider;
        loginService = loginservice;
        textView = textview;
        intentFactory = intentfactory;
    }

    private boolean setTravelerName()
    {
        firstname = volatileTravelerNameProvider.getFirstName();
        lastname = volatileTravelerNameProvider.getLastName();
        if (Strings.isEmpty(firstname) && Strings.isEmpty(lastname))
        {
            firstname = loginService.getFirstName();
            lastname = loginService.getLastName();
        }
        if (Strings.isEmpty(firstname) || Strings.isEmpty(lastname))
        {
            return false;
        } else
        {
            textView.setText(String.format("%s %s", new Object[] {
                firstname, lastname
            }));
            return true;
        }
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void onActivityResult(int i)
    {
        if (i == 10130)
        {
            travelerNamePending = false;
            if (!setTravelerName())
            {
                activity.finish();
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        if (bundle != null)
        {
            travelerNamePending = bundle.getBoolean("traveler_name_pending");
        }
    }

    public void onDealReady(String s, ImageUrl imageurl, BookingMetaData bookingmetadata)
    {
        dealTitle = s;
        dealImageUrl = imageurl;
        bookingMetaData = bookingmetadata;
        dealIsReady = true;
        if (!travelerNamePending && !setTravelerName())
        {
            travelerNamePending = true;
            startEditing();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putBoolean("traveler_name_pending", travelerNamePending);
    }

    public void startEditing()
    {
        if (!dealIsReady)
        {
            throw new IllegalStateException("Deal is not ready yet");
        } else
        {
            activity.startActivityForResult(intentFactory.newTravelerNameIntent(dealTitle, dealImageUrl, bookingMetaData), 10130);
            return;
        }
    }
}
