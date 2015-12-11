// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.operations;

import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Ln;

public class ClearCountryForMxUsers
{

    CurrentCountryManager currentCountryManager;

    public ClearCountryForMxUsers()
    {
    }

    private void clearCountry()
    {
        currentCountryManager.clearCountry();
    }

    private boolean isMxUser()
    {
        return currentCountryManager.getCurrentCountry().isMexico();
    }

    public void run()
    {
        try
        {
            if (isMxUser())
            {
                clearCountry();
            }
            return;
        }
        catch (Throwable throwable)
        {
            Ln.e(throwable);
        }
    }
}
