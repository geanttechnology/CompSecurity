// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.util.Log;
import com.amazon.mShop.feature.WeblabCsmUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.home:
//            GatewayWeblabUtil

class val.cachedTimeStamp
    implements Runnable
{

    final GatewayWeblabUtil this$0;
    final Integer val$cachedTimeStamp;
    final String val$treatment;

    public void run()
    {
        WeblabCsmUtils.postFeatureTriggerWithTreatment("Android_ShopAppHTMLGateway", val$treatment, val$cachedTimeStamp);
        if (GatewayWeblabUtil.access$000())
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("post the Android_ShopAppHTMLGateway with treatment ");
            String s;
            if (Util.isEmpty(val$treatment))
            {
                s = "";
            } else
            {
                s = val$treatment;
            }
            stringbuilder = stringbuilder.append(s).append(", and cached stamp ");
            if (val$cachedTimeStamp == null)
            {
                s = "";
            } else
            {
                s = val$cachedTimeStamp.toString();
            }
            Log.d("GatewayWeblabUtil", stringbuilder.append(s).toString());
        }
    }

    ()
    {
        this$0 = final_gatewayweblabutil;
        val$treatment = s;
        val$cachedTimeStamp = Integer.this;
        super();
    }
}
