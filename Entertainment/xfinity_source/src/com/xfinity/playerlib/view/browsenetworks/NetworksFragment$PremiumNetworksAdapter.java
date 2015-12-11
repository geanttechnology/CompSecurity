// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.view.LayoutInflater;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.tags.Network;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

private class  extends 
{

    final NetworksFragment this$0;

    protected void bindImageViewItem( , Network network)
    {
        android.graphics.drawable.Drawable drawable = NetworksFragment.access$1700(NetworksFragment.this, network);
        NetworksFragment.access$1800(NetworksFragment.this).loadNetworkLogoLarge(network.getCompanyId(), .ViewItem, drawable, drawable);
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.miumNetworksAdapter;
    }

    public (LayoutInflater layoutinflater)
    {
        this$0 = NetworksFragment.this;
        super(NetworksFragment.this, layoutinflater);
    }
}
