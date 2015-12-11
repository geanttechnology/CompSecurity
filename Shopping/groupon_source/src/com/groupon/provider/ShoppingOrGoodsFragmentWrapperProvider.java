// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.Shopping;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class ShoppingOrGoodsFragmentWrapperProvider
    implements FragmentProvider
{

    private Context context;
    private CurrentCountryManager currentCountryManager;

    public ShoppingOrGoodsFragmentWrapperProvider()
    {
    }

    public Fragment get()
    {
        Bundle bundle = new Bundle();
        String s = Channel.SHOPPING.toString();
        bundle.putParcelable("channel", Channel.SHOPPING);
        bundle.putString("tracking", s);
        return Fragment.instantiate(context, com/groupon/fragment/Shopping.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return context.getString(0x7f08044b);
    }

    public boolean isFragmentEnabled()
    {
        return currentCountryManager.getCurrentCountry().isShoppingChannelEnabled() && !currentCountryManager.getCurrentCountry().isUSACompatible();
    }
}
