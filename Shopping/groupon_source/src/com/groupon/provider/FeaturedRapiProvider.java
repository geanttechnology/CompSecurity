// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.FeaturedRapiFragment;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class FeaturedRapiProvider
    implements FragmentProvider
{

    private Context context;

    public FeaturedRapiProvider()
    {
    }

    public FeaturedRapiFragment get()
    {
        Bundle bundle = new Bundle();
        String s = Channel.FEATURED.toString();
        bundle.putString("channel", s);
        bundle.putString("tracking", s);
        return (FeaturedRapiFragment)Fragment.instantiate(context, com/groupon/fragment/FeaturedRapiFragment.getName(), bundle);
    }

    public volatile Object get()
    {
        return get();
    }

    public String getTitle()
    {
        return context.getString(0x7f0801b2);
    }

    public boolean isFragmentEnabled()
    {
        return true;
    }
}
