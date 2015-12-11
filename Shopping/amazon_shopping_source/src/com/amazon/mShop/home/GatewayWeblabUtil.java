// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.feature.WeblabCsmUtils;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;

public class GatewayWeblabUtil
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static GatewayWeblabUtil sGatewayWeblabUtil = new GatewayWeblabUtil();

    private GatewayWeblabUtil()
    {
    }

    public static GatewayWeblabUtil getInstance()
    {
        return sGatewayWeblabUtil;
    }

    public void postGatewayFeatureTrigger(boolean flag)
    {
        String s = Features.getInstance().getFeatureState("Android_ShopAppHTMLGateway");
        Integer integer = Features.getInstance().getFeatureCacheStamp("Android_ShopAppHTMLGateway");
        if (flag)
        {
            postGatewayFeatureTriggerWithTreatment(s, integer);
            return;
        } else
        {
            WeblabCsmUtils.postFeatureTriggerWithTreatment("Android_ShopAppHTMLGateway", s, integer);
            return;
        }
    }

    public void postGatewayFeatureTriggerWithTreatment(final String treatment, final Integer cachedTimeStamp)
    {
        if (!ActivityUtils.isDebugSettingEnabled("debugHTMLGateway"))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final GatewayWeblabUtil this$0;
                final Integer val$cachedTimeStamp;
                final String val$treatment;

                public void run()
                {
                    WeblabCsmUtils.postFeatureTriggerWithTreatment("Android_ShopAppHTMLGateway", treatment, cachedTimeStamp);
                    if (GatewayWeblabUtil.DEBUG)
                    {
                        StringBuilder stringbuilder = (new StringBuilder()).append("post the Android_ShopAppHTMLGateway with treatment ");
                        String s;
                        if (Util.isEmpty(treatment))
                        {
                            s = "";
                        } else
                        {
                            s = treatment;
                        }
                        stringbuilder = stringbuilder.append(s).append(", and cached stamp ");
                        if (cachedTimeStamp == null)
                        {
                            s = "";
                        } else
                        {
                            s = cachedTimeStamp.toString();
                        }
                        Log.d("GatewayWeblabUtil", stringbuilder.append(s).toString());
                    }
                }

            
            {
                this$0 = GatewayWeblabUtil.this;
                treatment = s;
                cachedTimeStamp = integer;
                super();
            }
            }, 20000L);
        }
    }

    public com.amazon.mShop.feature.Features.FeatureStateChangeType updateGatewayWeblabState()
    {
        if (!ActivityUtils.isDebugSettingEnabled("debugHTMLGateway"))
        {
            String s = Features.getInstance().getFeatureState("Android_ShopAppHTMLGateway");
            Object obj = Features.getInstance().getFeatureCacheStamp("Android_ShopAppHTMLGateway");
            String s1;
            int i;
            int j;
            if (obj == null)
            {
                i = 0;
            } else
            {
                i = ((Integer) (obj)).intValue();
            }
            obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
            s1 = ((DataStore) (obj)).getString("GatewayTreatment");
            j = ((DataStore) (obj)).getInt("GatewayCacheStamp");
            if (!Util.isEmpty(s))
            {
                if (!s.equals(s1))
                {
                    ((DataStore) (obj)).putString("GatewayTreatment", s);
                    ((DataStore) (obj)).putInt("GatewayCacheStamp", i);
                    return com.amazon.mShop.feature.Features.FeatureStateChangeType.TREATMENT_CHANGE;
                }
                if (i != j)
                {
                    ((DataStore) (obj)).putInt("GatewayCacheStamp", i);
                    return com.amazon.mShop.feature.Features.FeatureStateChangeType.CACHETIMESTAMP_CHANGE;
                } else
                {
                    return com.amazon.mShop.feature.Features.FeatureStateChangeType.NO_CHANGE;
                }
            }
            if (!Util.isEmpty(s1))
            {
                ((DataStore) (obj)).putString("GatewayTreatment", "");
                return com.amazon.mShop.feature.Features.FeatureStateChangeType.TREATMENT_CHANGE;
            }
        }
        return com.amazon.mShop.feature.Features.FeatureStateChangeType.NO_CHANGE;
    }


}
