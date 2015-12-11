// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.util.Maps;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDefault, GNODebugSettingsActivity, GNODrawer

class val.context
    implements lickListener
{

    Resources res;
    final GNOMenuItemProviderDefault this$0;
    final Context val$context;
    final int val$stringId;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        String s = res.getString(val$stringId);
        gnodrawer = s;
        if (DebugSettings.isDebugEnabled())
        {
            s = GNODebugSettingsActivity.getTargetUrlOverride(s);
            gnodrawer = s;
            if (GNODebugSettingsActivity.isUrlToastEnabled().booleanValue())
            {
                Toast.makeText(amazonactivity.getApplicationContext(), s, 0).show();
                gnodrawer = s;
            }
        }
        AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.abled, Maps.of("url", gnodrawer));
    }

    lickListener()
    {
        this$0 = final_gnomenuitemproviderdefault;
        val$context = context1;
        val$stringId = I.this;
        super();
        res = val$context.getResources();
    }
}
