// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.app.Activity;
import android.content.Context;
import com.amazon.mShop.control.locale.LocaleSwitchSubscriber;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.Locale;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchCommonProcessor, LocaleSwitchChain

class val.chain
    implements LocaleSwitchSubscriber
{

    final LocaleSwitchCommonProcessor this$0;
    final LocaleSwitchChain val$chain;
    final Context val$context;
    final Locale val$localeFrom;
    final Locale val$localeTo;
    final boolean val$switchLocaleInCA;

    public void onError(Exception exception, ServiceCall servicecall)
    {
        LocaleUtils.setCurrentAppLocale(val$localeFrom.toString());
        exception = val$context;
        int i;
        if (val$switchLocaleInCA)
        {
            i = com.amazon.mShop.android.lib.ng_language;
        } else
        {
            i = com.amazon.mShop.android.lib.ng_country;
        }
        UIUtils.info(exception, i);
        ((Activity)val$context).finish();
    }

    public void onLocaleSwitchCompleted(String s)
    {
        com.amazon.mShop.platform.r().getDataStore().putString("latestLocaleOfCanada", s);
        LocaleUtils.setCurrentAppLocale(s);
        RefMarkerObserver.logRefMarker(String.format("ch_lc_%1$s", new Object[] {
            val$localeTo.toString()
        }));
        LocaleSwitchCommonProcessor.access$000(LocaleSwitchCommonProcessor.this, val$context, val$chain.getLaunchIntent());
    }

    A()
    {
        this$0 = final_localeswitchcommonprocessor;
        val$localeFrom = locale;
        val$context = context1;
        val$switchLocaleInCA = flag;
        val$localeTo = locale1;
        val$chain = LocaleSwitchChain.this;
        super();
    }
}
