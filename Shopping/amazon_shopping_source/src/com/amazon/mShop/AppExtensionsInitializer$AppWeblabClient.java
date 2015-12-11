// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import com.amazon.mShop.feature.Features;
import com.amazon.mShop.feature.WeblabCsmUtils;
import com.amazon.retailsearch.android.api.experimentation.WeblabClient;

// Referenced classes of package com.amazon.mShop:
//            AppExtensionsInitializer

private static class <init>
    implements WeblabClient
{

    public String getTreatment(String s)
    {
        return Features.getInstance().getFeatureState(s);
    }

    public void postFeatureTrigger(String s)
    {
        WeblabCsmUtils.postFeatureTrigger(s);
    }

    private Client()
    {
    }

    Client(Client client)
    {
        this();
    }
}
