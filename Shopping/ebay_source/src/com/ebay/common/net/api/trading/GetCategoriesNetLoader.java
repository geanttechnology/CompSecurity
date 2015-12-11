// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.ResponseCache;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetCategoriesRequest, GetCategoriesResponse

public class GetCategoriesNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final EbayCategory category;

    public GetCategoriesNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, EbayCategory ebaycategory)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        category = ebaycategory;
    }

    protected EbayRequest createRequest()
    {
        return new GetCategoriesRequest(api, category);
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        Object obj1 = getContext();
        Object obj2 = (new StringBuilder()).append("GetCategories").append(api.site.id);
        Object obj;
        if (category != null)
        {
            obj = Long.valueOf(category.id);
        } else
        {
            obj = "";
        }
        obj2 = ((StringBuilder) (obj2)).append(obj).toString();
        obj = ResponseCache.getResponse(((android.content.Context) (obj1)), ((String) (obj2)));
        if (obj != null)
        {
            obj1 = new GetCategoriesResponse(true);
            ((GetCategoriesResponse) (obj1)).parse(new DirectByteArrayInputStream(((String) (obj)).getBytes()));
            response = ((com.ebay.nautilus.domain.net.EbayResponse) (obj1));
        } else
        {
            super.doInBackgroundInternal();
            if (response != null)
            {
                ResponseCache.setResponse(((android.content.Context) (obj1)), ((String) (obj2)), ((GetCategoriesResponse)response).xml, 0x5265c00L);
                return;
            }
        }
    }

    public EbayCategory getCategory()
    {
        return category;
    }
}
