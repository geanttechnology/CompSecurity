// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.fragment.Featured;

// Referenced classes of package com.groupon.provider:
//            FragmentProvider

public class FeaturedProvider
    implements FragmentProvider
{

    private Context context;

    public FeaturedProvider()
    {
    }

    public Featured get()
    {
        Bundle bundle = new Bundle();
        String s = Channel.FEATURED.toString();
        bundle.putParcelable("channel", Channel.FEATURED);
        bundle.putString("tracking", s);
        return (Featured)Fragment.instantiate(context, com/groupon/fragment/Featured.getName(), bundle);
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
