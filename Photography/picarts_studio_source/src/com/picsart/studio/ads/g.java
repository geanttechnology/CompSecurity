// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import com.socialin.android.adapter.RecyclerViewAdapter;

public abstract class g extends RecyclerViewAdapter
{

    public g(Context context)
    {
        super(context);
    }

    public abstract void destroyAds();

    public abstract void loadNativeAds(Bundle bundle);

    public abstract void notifyItemDataChanged(int i);

    public abstract void setAdapterConfigs(com.socialin.android.apiv3.model.AppProps.AdType adtype, Point point);
}
