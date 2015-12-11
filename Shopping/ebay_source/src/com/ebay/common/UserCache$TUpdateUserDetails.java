// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Handler;
import android.os.Process;
import com.ebay.common.model.UserDetail;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common:
//            UserCache, Preferences

private static final class api extends Thread
{

    private final EbayTradingApi api;
    private final EbayContext ebayContext;
    private final TradingApi i;

    public void run()
    {
        try
        {
            Process.setThreadPriority(10);
        }
        catch (Exception exception2) { }
        try
        {
            Runnable runnable = new Runnable() {

                final UserCache.TUpdateUserDetails this$0;
                final UserDetail val$profile;

                public void run()
                {
                    i.updateUserDetails(profile);
                    Preferences preferences = MyApp.getPrefs();
                    preferences.setPayPalAccountStatus(profile.payPalAccountStatus);
                    preferences.setUserIsPpa(profile.isPpa);
                }

            
            {
                this$0 = UserCache.TUpdateUserDetails.this;
                profile = userdetail;
                super();
            }
            };
            if (!i..post(runnable))
            {
                throw new Exception();
            }
            break MISSING_BLOCK_LABEL_80;
        }
        catch (Exception exception) { }
        finally
        {
            _mth2(i, null);
            throw exception1;
        }
        synchronized ((i))
        {
            _mth2(i, -3);
        }
        _mth2(i, null);
        return;
        _mth2(i, null);
        return;
        exception3;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception3;
    }


    public TradingApi(TradingApi tradingapi, EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
    {
        i = tradingapi;
        ebayContext = ebaycontext;
        api = ebaytradingapi;
    }
}
