// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.Goods;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class GoodsProvider
    implements FragmentProvider
{

    private Context context;
    private CurrentCountryManager currentCountryManager;

    public GoodsProvider()
    {
    }

    public Fragment get()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("channel", Channel.GOODS);
        bundle.putString("tracking", "goods");
        return Fragment.instantiate(context, com/groupon/fragment/Goods.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return context.getString(0x7f080206);
    }

    public boolean isFragmentEnabled()
    {
        return currentCountryManager.getCurrentCountry().isShoppingChannelEnabled() && currentCountryManager.getCurrentCountry().isUSACompatible();
    }
}
