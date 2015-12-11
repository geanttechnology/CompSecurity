// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.Hotels;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class HotelsProvider
    implements FragmentProvider
{

    private AbTestService abTestService;
    private Context context;
    private CurrentCountryManager currentCountryManager;

    public HotelsProvider()
    {
    }

    public Hotels get()
    {
        Bundle bundle = new Bundle();
        String s = Channel.HOTELS.toString();
        bundle.putParcelable("channel", Channel.HOTELS);
        bundle.putString("tracking", s);
        bundle.putParcelable("sourceChannel", Channel.HOTELS);
        return get(bundle);
    }

    public Hotels get(Bundle bundle)
    {
        return (Hotels)Fragment.instantiate(context, com/groupon/fragment/Hotels.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return context.getString(0x7f080226);
    }

    public boolean isFragmentEnabled()
    {
        boolean flag;
        if (Strings.equalsIgnoreCase(abTestService.getVariant("getawaysUSCA1506"), "singleTab") || Strings.equalsIgnoreCase(abTestService.getVariant("getawaysUSCA1506"), "singleTabWithWidget"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return currentCountryManager.getCurrentCountry().isUSACompatible() && !flag;
    }
}
