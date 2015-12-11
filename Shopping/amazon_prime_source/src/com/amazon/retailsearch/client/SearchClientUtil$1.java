// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.RetailSearchServiceCall;
import java.io.IOException;

// Referenced classes of package com.amazon.retailsearch.client:
//            SearchClientUtil

static final class val.searchCall
    implements Runnable
{

    final RetailSearchServiceCall val$searchCall;

    public void run()
    {
        try
        {
            val$searchCall.execute();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    rchServiceCall(RetailSearchServiceCall retailsearchservicecall)
    {
        val$searchCall = retailsearchservicecall;
        super();
    }
}
