// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Handler;
import android.os.Process;
import com.ebay.common.model.SavedSeller;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.common:
//            UserCache

private static final class api extends Thread
{

    private final EbayTradingApi api;
    private final EbayContext ebayContext;
    private final  i;

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

                final UserCache.TUpdateFavSellers this$0;
                final List val$savedSellers;

                public void run()
                {
                    if (savedSellers != null)
                    {
                        for (int j = 0; j < savedSellers.size(); j++)
                        {
                            String s = ((SavedSeller)savedSellers.get(j)).userId;
                            i.addToFavSeller(s);
                        }

                    }
                    i.updateFavSellers();
                }

            
            {
                this$0 = UserCache.TUpdateFavSellers.this;
                savedSellers = list;
                super();
            }
            };
            if (!i.r.post(runnable))
            {
                throw new Exception();
            }
            break MISSING_BLOCK_LABEL_80;
        }
        catch (Exception exception) { }
        finally
        {
            _mth02(i, null);
            throw exception1;
        }
        synchronized (_mth00(i))
        {
            _mth72(i, -3);
        }
        _mth02(i, null);
        return;
        _mth02(i, null);
        return;
        exception3;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception3;
    }


    public yTradingApi(yTradingApi ytradingapi, EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
    {
        i = ytradingapi;
        ebayContext = ebaycontext;
        api = ebaytradingapi;
    }
}
