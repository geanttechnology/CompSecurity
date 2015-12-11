// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Handler;
import android.os.Process;
import com.ebay.common.net.api.shopping.EbayShoppingApiHelper;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common:
//            UserCache

private static final class userId extends Thread
{

    private final EbayShoppingApi api;
    private final EbayContext ebayContext;
    private final yShoppingApi i;
    private final String userId;

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

                final UserCache.TUpdateUserProfile this$0;
                final UserProfile val$profile;

                public void run()
                {
                    i.updateUserProfile(profile);
                }

            
            {
                this$0 = UserCache.TUpdateUserProfile.this;
                profile = userprofile;
                super();
            }
            };
            if (!i..post(runnable))
            {
                throw new Exception();
            }
            break MISSING_BLOCK_LABEL_84;
        }
        catch (Exception exception) { }
        finally
        {
            (i, null);
            throw exception1;
        }
        synchronized ((i))
        {
            (i, -3);
        }
        (i, null);
        return;
        (i, null);
        return;
        exception3;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception3;
    }


    public yShoppingApi(yShoppingApi yshoppingapi, EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s)
    {
        i = yshoppingapi;
        ebayContext = ebaycontext;
        api = ebayshoppingapi;
        userId = s;
    }
}
