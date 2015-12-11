// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.details.ProductImagesView;
import com.amazon.rio.j2me.client.services.mShop.MultiImage;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.title
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$imageUrls[];
    final int val$startIndex;
    final String val$title;

    public void run()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = val$imageUrls;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            MultiImage multiimage = new MultiImage();
            multiimage.setStandardUrl(s);
            arraylist.add(multiimage);
        }

        ProductImagesView productimagesview = (ProductImagesView)View.inflate(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this), com.amazon.mShop.android.lib.ardUrl, null);
        productimagesview.setStartIndex(val$startIndex);
        productimagesview.setImagesAndTitle(val$title, arraylist);
        ((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).pushView(productimagesview);
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$imageUrls = as;
        val$startIndex = i;
        val$title = String.this;
        super();
    }
}
