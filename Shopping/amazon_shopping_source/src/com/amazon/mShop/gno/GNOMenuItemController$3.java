// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.util.Maps;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemController, GNODebugSettingsActivity

class stomRunnable extends stomRunnable
{

    final GNOMenuItemController this$0;
    final boolean val$isAIVGateway;
    final boolean val$isIdContainingAIV;
    final String val$targetUrl;

    public void run(AmazonActivity amazonactivity)
    {
        String s;
        if (DebugSettings.isDebugEnabled())
        {
            String s1 = GNODebugSettingsActivity.getTargetUrlOverride(val$targetUrl);
            s = s1;
            if (GNODebugSettingsActivity.isUrlToastEnabled().booleanValue())
            {
                Toast.makeText(amazonactivity, s1, 0).show();
                s = s1;
            }
        } else
        {
            s = val$targetUrl;
        }
        if (val$isIdContainingAIV)
        {
            if (val$isAIVGateway)
            {
                AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.gateway, Maps.of("url", val$targetUrl));
                return;
            } else
            {
                AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.webview, Maps.of("url", s, "forceClearHistory", Boolean.valueOf(false)));
                return;
            }
        } else
        {
            AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.iew, Maps.of("url", s));
            return;
        }
    }

    et()
    {
        this$0 = final_gnomenuitemcontroller;
        val$targetUrl = s;
        val$isIdContainingAIV = flag;
        val$isAIVGateway = Z.this;
        super(final_gnomenuitemcontroller, null);
    }
}
