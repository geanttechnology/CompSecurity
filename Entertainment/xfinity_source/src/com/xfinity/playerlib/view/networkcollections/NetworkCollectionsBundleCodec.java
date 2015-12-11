// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.os.Bundle;
import com.xfinity.playerlib.model.tags.Network;

public class NetworkCollectionsBundleCodec
{

    public NetworkCollectionsBundleCodec()
    {
    }

    public Bundle createBundle(Network network)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("companyId", network.getCompanyId());
        return bundle;
    }

    public long getNetworkCompanyId(Bundle bundle)
    {
        return bundle.getLong("companyId");
    }
}
