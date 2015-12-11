// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.Availability;

public class AvailabilityModel
{
    public static class Builder
    {

        public AvailabilityModel build(Availability availability)
        {
            if (availability == null)
            {
                return null;
            } else
            {
                AvailabilityModel availabilitymodel = new AvailabilityModel();
                availabilitymodel.setLowStockMessage(availability.getLowStockMessage());
                availabilitymodel.setGeneralMessage(availability.getGeneralAvailability());
                return availabilitymodel;
            }
        }

        public Builder()
        {
        }
    }


    private String generalMessage;
    private String lowStockMessage;

    public AvailabilityModel()
    {
    }

    private void setGeneralMessage(String s)
    {
        generalMessage = s;
    }

    private void setLowStockMessage(String s)
    {
        lowStockMessage = s;
    }

    public String getGeneralMessage()
    {
        return generalMessage;
    }

    public String getLowStockMessage()
    {
        return lowStockMessage;
    }

    public boolean isEmpty()
    {
        return TextUtils.isEmpty(generalMessage) && TextUtils.isEmpty(lowStockMessage);
    }


}
