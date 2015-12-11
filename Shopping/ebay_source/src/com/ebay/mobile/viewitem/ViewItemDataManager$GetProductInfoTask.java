// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.model.EbayProduct;
import com.ebay.common.net.api.shopping.FindProductsRequest;
import com.ebay.common.net.api.shopping.FindProductsResponse;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.DataRequest;
import com.ebay.nautilus.domain.net.DataResponse;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class INFO extends AsyncTask
{

    private final EbayShoppingApi api;
    private final String productId;
    private final boolean reportError;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
        Object obj1;
        Object obj2;
        ResultStatusOwner resultstatusowner;
        boolean flag1;
        obj1 = null;
        obj2 = null;
        flag1 = false;
        resultstatusowner = new ResultStatusOwner();
        obj = new FindProductsRequest(api, productId, "Reference");
        obj = (FindProductsResponse)ViewItemDataManager.access$2200(ViewItemDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), resultstatusowner);
        if (resultstatusowner.getResultStatus() == ResultStatus.CANCELED) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (resultstatusowner.getResultStatus().hasError())
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj1 = ((EbayProduct)((FindProductsResponse) (obj)).products.get(0)).detailsUrl;
        flag = flag1;
        obj = obj2;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = new DataRequest(new URL(((String) (obj1))));
        ((Item)acontent[0].getData()).productDescription = ((DataResponse)com.ebay.nautilus.kernel.net.._mth0(getEbayContext(), ((com.ebay.nautilus.kernel.net.Request) (obj)))).getText();
        obj = acontent[0];
        flag = flag1;
_L3:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (reportError)
            {
                if (!flag)
                {
                    acontent = resultstatusowner.getResultStatus();
                } else
                {
                    acontent = ResultStatus.UNKNOWN;
                }
                obj1 = new Content(null, acontent);
            }
        }
_L2:
        return ((Content) (obj1));
        acontent;
        ViewItemDataManager.logTag.tError((new StringBuilder()).append("product info failure for URL ").append(((String) (obj1))).toString(), acontent);
        flag = true;
        obj = obj2;
          goto _L3
        flag = flag1;
        obj = obj2;
        if (reportError)
        {
            obj = new Content(null, resultstatusowner.getResultStatus());
            flag = flag1;
        }
          goto _L3
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        ViewItemDataManager.access$2300(ViewItemDataManager.this, INFO);
        handleProductInfoResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleProductInfoResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayShoppingApi ebayshoppingapi, String s, boolean flag)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebayshoppingapi;
        productId = s;
        reportError = flag;
        ViewItemDataManager.access$000(ViewItemDataManager.this, INFO);
    }
}
