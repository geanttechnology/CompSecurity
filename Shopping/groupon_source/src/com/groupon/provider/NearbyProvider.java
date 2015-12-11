// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.NearbyDealsFragment;
import com.groupon.util.DivisionUtil;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class NearbyProvider
    implements FragmentProvider
{

    private Context context;
    private DivisionUtil divisionUtil;

    public NearbyProvider()
    {
    }

    public NearbyDealsFragment get()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("channel", Channel.NEARBY);
        return (NearbyDealsFragment)Fragment.instantiate(context, com/groupon/fragment/NearbyDealsFragment.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return context.getString(0x7f080288);
    }

    public boolean isFragmentEnabled()
    {
        return divisionUtil.isNearbyAllowedForCurrentDivision();
    }
}
