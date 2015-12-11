// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.app.Fragment;
import android.content.Context;
import com.groupon.models.country.Country;
import com.groupon.provider.FragmentProvider;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment

public class GetawaysFragmentProvider
    implements FragmentProvider
{

    private Context context;
    private CurrentCountryManager currentCountryManager;

    public GetawaysFragmentProvider()
    {
    }

    public GetawaysFragment get()
    {
        return (GetawaysFragment)Fragment.instantiate(context, com/groupon/getaways/carousel/GetawaysFragment.getName(), null);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        Context context1 = context;
        int i;
        if (currentCountryManager.getCurrentCountry().isGetawaysTitle())
        {
            i = 0x7f0801e5;
        } else
        {
            i = 0x7f0803e7;
        }
        return context1.getString(i);
    }

    public boolean isFragmentEnabled()
    {
        return currentCountryManager.getCurrentCountry().isTravelChannelEnabled();
    }
}
