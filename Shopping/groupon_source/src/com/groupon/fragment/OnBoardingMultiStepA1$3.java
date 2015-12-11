// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.groupon.util.GeoUtils;
import com.groupon.view.SpinnerButton;
import java.io.IOException;
import java.util.List;
import roboguice.util.RoboAsyncTask;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            OnBoardingMultiStepA1

class val.zipCode extends RoboAsyncTask
{

    final OnBoardingMultiStepA1 this$0;
    final String val$zipCode;

    public Address call()
        throws Exception
    {
        List list = geocoder.getFromLocationName(val$zipCode, 1);
        if (list != null && list.size() > 0 && Strings.equalsIgnoreCase(((Address)list.get(0)).getCountryCode(), "us"))
        {
            return (Address)list.get(0);
        } else
        {
            return null;
        }
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    protected void onException(Exception exception)
    {
        super.onException(exception);
        if (exception instanceof IOException)
        {
            geoUtils.logGeocodeException(exception, com/groupon/fragment/OnBoardingMultiStepA1.getSimpleName());
            OnBoardingMultiStepA1.access$500(OnBoardingMultiStepA1.this);
            return;
        }
        if (exception instanceof NullPointerException)
        {
            OnBoardingMultiStepA1.access$600(OnBoardingMultiStepA1.this);
            return;
        } else
        {
            OnBoardingMultiStepA1.access$700(OnBoardingMultiStepA1.this);
            return;
        }
    }

    protected void onFinally()
    {
        super.onFinally();
        continueButton.stopSpinning();
    }

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
        continueButton.startSpinning();
    }

    protected void onSuccess(Address address)
        throws Exception
    {
        super.onSuccess(address);
        if (address != null)
        {
            OnBoardingMultiStepA1.access$400(OnBoardingMultiStepA1.this, address);
            OnBoardingMultiStepA1.access$500(OnBoardingMultiStepA1.this);
            return;
        } else
        {
            OnBoardingMultiStepA1.access$600(OnBoardingMultiStepA1.this);
            return;
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Address)obj);
    }

    (String s)
    {
        this$0 = final_onboardingmultistepa1;
        val$zipCode = s;
        super(Context.this);
    }
}
