// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.os.Bundle;
import com.amazon.client.framework.acf.Components;
import com.amazon.geo.mapsv2.internal.DelegateAccessor;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapsRuntimeUtil, MapsInitializerInternal

public final class AmazonMapsRuntimeUtilInternal
{

    private static final String ACCOUNT_COR_EXTRA = "com.amazon.geo.mapsv2.account.cor";
    private static final String ACCOUNT_EXTRA = "com.amazon.geo.mapsv2.account";
    private static final String ACCOUNT_PFM_EXTRA = "com.amazon.geo.mapsv2.account.pfm";

    public AmazonMapsRuntimeUtilInternal()
    {
    }

    public static void initEngineContext(Context context, Context context1)
    {
        AmazonMapsRuntimeUtil.initEngineContext(context, context1);
    }

    public static int isAmazonMapsRuntimeAvailable(Context context)
    {
        int j = AmazonMapsRuntimeUtil.isAmazonMapsRuntimeAvailable(context);
        int i = j;
        if (j == 1)
        {
            i = j;
            if (MapsInitializerInternal.isAssetAvailable(context))
            {
                i = 0;
            }
        }
        return i;
    }

    public static void setAccountInfo(String s, String s1)
    {
        DelegateAccessor delegateaccessor = new DelegateAccessor(com/amazon/geo/mapsv2/internal/IMapEngineDelegate);
        Bundle bundle = new Bundle();
        boolean flag;
        if (s != null || s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("com.amazon.geo.mapsv2.account", flag);
        bundle.putString("com.amazon.geo.mapsv2.account.cor", s);
        bundle.putString("com.amazon.geo.mapsv2.account.pfm", s1);
        ((IMapEngineDelegate)delegateaccessor.get()).setEngineOptions(bundle);
    }

    static 
    {
        Components.registerComponentName(com/amazon/geo/mapsv2/internal/IMapEngineDelegate, "amazon.geo.client.MapEngine");
    }
}
