// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.PlacesContainer;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase2, LoginService

public class PlacesService extends ApiServiceBase2
{

    private CurrentCountryManager currentCountryManager;
    private LoginService loginService;

    public PlacesService(Context context)
    {
        super(context, com/groupon/models/PlacesContainer);
    }

    public void getPlaces(Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        withCallbacks(function1, returningfunction1, function0).uri(String.format("https:/users/%s/places", new Object[] {
            loginService.getUserId()
        })).method("GET").execute();
    }

    public boolean isSupported()
    {
        return currentCountryManager.getCurrentCountry().isUSACompatible() && loginService.isLoggedIn();
    }
}
