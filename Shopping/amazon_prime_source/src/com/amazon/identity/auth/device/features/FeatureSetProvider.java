// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            FeatureSet, Feature

public class FeatureSetProvider extends FeatureSet
{

    private final Context mContext;

    public FeatureSetProvider(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context is null");
        } else
        {
            mContext = context;
            return;
        }
    }

    public boolean hasFeature(Feature feature)
    {
        return feature.fetchValue(mContext);
    }
}
