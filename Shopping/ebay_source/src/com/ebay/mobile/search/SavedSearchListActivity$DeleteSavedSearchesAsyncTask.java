// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.fuss.EbayFussApi;
import com.ebay.common.util.EbayAsyncTask;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SavedSearchListActivity

private static final class ids extends EbayAsyncTask
{

    private final EbayFussApi api;
    private final String iafToken;
    private final List ids;

    protected Boolean doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.en, com.ebay.nautilus.kernel.net.en, com.ebay.common.net.sk, com.ebay.nautilus.kernel.net.en, IOException, InterruptedException
    {
        boolean flag = true;
        obj = ids.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            if (!api.removeFavoriteSearch(iafToken, s, null))
            {
                flag = false;
            }
        } while (true);
        return Boolean.valueOf(flag);
    }

    protected volatile Object doInBackgroundInternal(Object obj)
        throws com.ebay.nautilus.kernel.net.en, com.ebay.nautilus.kernel.net.en, com.ebay.common.net.sk, com.ebay.nautilus.kernel.net.en, IOException, InterruptedException
    {
        return doInBackgroundInternal(obj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected Q(EbayContext ebaycontext, String s, List list)
    {
        api = EbayApiUtil.getFindingUserSettingsApi(ebaycontext);
        iafToken = s;
        ids = list;
    }
}
