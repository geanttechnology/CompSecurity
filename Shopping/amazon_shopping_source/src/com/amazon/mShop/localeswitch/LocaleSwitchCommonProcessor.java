// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.locale.LocaleController;
import com.amazon.mShop.control.locale.LocaleSwitchSubscriber;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.share.WechatSDKManager;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.Locale;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchProcessor, LocaleSwitchChain

public class LocaleSwitchCommonProcessor
    implements LocaleSwitchProcessor
{

    public LocaleSwitchCommonProcessor()
    {
    }

    private Intent getLocaleChangedIntent()
    {
        Intent intent = new Intent();
        intent.setAction("com.amazon.mShop.LOCALE_SWITCHED");
        intent.putExtra("locale", AppLocale.getInstance().getCurrentLocale().getCountry());
        return intent;
    }

    private void localeChangedCompleted(Context context, Intent intent)
    {
        LocaleUtils.ensureAppLocale(context);
        WechatSDKManager.clearPendingTransaction();
        AppUtils.restartApp(intent);
        context.sendBroadcast(getLocaleChangedIntent());
    }

    public void doProcess(String s, final Context context, final LocaleSwitchChain chain)
    {
        final boolean switchLocaleInCA = true;
        final Locale localeFrom = AppLocale.getInstance().getCurrentLocale();
        LocaleUtils.setCurrentAppLocale(s);
        final Locale localeTo = AppLocale.getInstance().getCurrentLocale();
        if (AppLocale.isLocaleOfCA(s) && !s.equals(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("latestLocaleOfCanada")))
        {
            int i;
            if (!AppLocale.isLocaleOfCA(localeFrom.toString()) || !AppLocale.isLocaleOfCA(localeTo.toString()))
            {
                switchLocaleInCA = false;
            }
            localeFrom = new LocaleController(new LocaleSwitchSubscriber() {

                final LocaleSwitchCommonProcessor this$0;
                final LocaleSwitchChain val$chain;
                final Context val$context;
                final Locale val$localeFrom;
                final Locale val$localeTo;
                final boolean val$switchLocaleInCA;

                public void onError(Exception exception, ServiceCall servicecall)
                {
                    LocaleUtils.setCurrentAppLocale(localeFrom.toString());
                    exception = context;
                    int j;
                    if (switchLocaleInCA)
                    {
                        j = com.amazon.mShop.android.lib.R.string.error_message_switching_language;
                    } else
                    {
                        j = com.amazon.mShop.android.lib.R.string.error_message_switching_country;
                    }
                    UIUtils.info(exception, j);
                    ((Activity)context).finish();
                }

                public void onLocaleSwitchCompleted(String s1)
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("latestLocaleOfCanada", s1);
                    LocaleUtils.setCurrentAppLocale(s1);
                    RefMarkerObserver.logRefMarker(String.format("ch_lc_%1$s", new Object[] {
                        localeTo.toString()
                    }));
                    localeChangedCompleted(context, chain.getLaunchIntent());
                }

            
            {
                this$0 = LocaleSwitchCommonProcessor.this;
                localeFrom = locale;
                context = context1;
                switchLocaleInCA = flag;
                localeTo = locale1;
                chain = localeswitchchain;
                super();
            }
            });
            if (switchLocaleInCA)
            {
                i = com.amazon.mShop.android.lib.R.string.config_notifications_changing_language;
            } else
            {
                i = com.amazon.mShop.android.lib.R.string.config_notifications_changing_country;
            }
            if (chain.getExistentProgDiag() == null)
            {
                localeFrom.switchLanguage(s, (new TaskCallbackFactory(context)).getFinishTaskCallback(null, (AmazonActivity)context, ConfigUtils.getStringForSpecificLocale(context, i, s)));
                return;
            } else
            {
                localeFrom.switchLanguage(s, (new TaskCallbackFactory(context)).getLocaleSwitchFinishTaskCallback(null, (AmazonActivity)context, ConfigUtils.getStringForSpecificLocale(context, i, s), chain.getExistentProgDiag()));
                return;
            }
        } else
        {
            RefMarkerObserver.logRefMarker(String.format("ch_lc_%1$s", new Object[] {
                localeTo.toString()
            }));
            localeChangedCompleted(context, chain.getLaunchIntent());
            return;
        }
    }

}
