// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerBrowser, ViewItDBResultWrapper, ViewItSearchResultWrapper

class val.sc
    implements Runnable
{

    final ViewItSlidingDrawerBrowser this$0;
    final BasicProductsResponse val$response;
    final ServiceCall val$sc;

    public void run()
    {
        ArrayList arraylist;
        List list;
        Iterator iterator;
        int l;
        arraylist = new ArrayList();
        list = val$response.getProducts();
        l = list.size();
        iterator = ViewItSlidingDrawerBrowser.access$100(ViewItSlidingDrawerBrowser.this).iterator();
_L2:
        ViewItDBResultWrapper viewitdbresultwrapper;
        Vector vector;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        viewitdbresultwrapper = (ViewItDBResultWrapper)iterator.next();
        vector = new Vector();
        List list1 = viewitdbresultwrapper.getAsinList();
        int i;
        int j;
        if (Util.isEmpty(list1))
        {
            i = 0;
        } else
        {
            i = list1.size();
        }
        j = 0;
        do
        {
label0:
            {
                if (j >= i)
                {
                    break label0;
                }
                String s = (String)list1.get(j);
                int k = 0;
                do
                {
label1:
                    {
                        if (k < l)
                        {
                            SearchResult searchresult = (SearchResult)list.get(k);
                            if (!s.equals(searchresult.getBasicProduct().getAsin()))
                            {
                                break label1;
                            }
                            vector.add(searchresult);
                        }
                        j++;
                    }
                    if (true)
                    {
                        break;
                    }
                    k++;
                } while (true);
            }
        } while (true);
        if (!Util.isEmpty(vector))
        {
            arraylist.add(new ViewItSearchResultWrapper(viewitdbresultwrapper.getOriginalScannedOutput(), vector, null, viewitdbresultwrapper.getScannedDate(), false));
        }
        if (true) goto _L2; else goto _L1
_L1:
        objectsReceived(arraylist, val$sc);
        ViewItSlidingDrawerBrowser.access$100(ViewItSlidingDrawerBrowser.this).clear();
        return;
    }

    nse()
    {
        this$0 = final_viewitslidingdrawerbrowser;
        val$response = basicproductsresponse;
        val$sc = ServiceCall.this;
        super();
    }
}
