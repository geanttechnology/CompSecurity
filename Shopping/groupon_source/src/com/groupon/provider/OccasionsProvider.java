// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.Occasions;
import com.groupon.models.country.Country;
import com.groupon.service.core.CollectionsService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.OccasionUtil;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class OccasionsProvider
    implements FragmentProvider
{

    private CollectionsService collectionsService;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private OccasionUtil occasionUtil;

    public OccasionsProvider()
    {
    }

    public Occasions get()
    {
        Bundle bundle = new Bundle();
        String s = Channel.OCCASIONS.toString();
        bundle.putParcelable("channel", Channel.OCCASIONS);
        bundle.putString("tracking", s);
        return (Occasions)Fragment.instantiate(context, com/groupon/fragment/Occasions.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return occasionUtil.getOccasionsTitle();
    }

    public boolean isFragmentEnabled()
    {
        com.groupon.models.collections.Collections.Occasion occasion = occasionUtil.getValidOccasion(collectionsService.getCollections());
        return currentCountryManager.getCurrentCountry().isUSACompatible() && occasion != null || currentCountryManager.getCurrentCountry().isIntlOccasionsChannelEnabled();
    }
}
