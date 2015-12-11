// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ImageUtil;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemView, ViewItSlidingDrawerView, ViewItActivity, ViewItSlidingDrawerBrowser, 
//            ViewItMetricHelper, ViewItSearchResultWrapper

class tWrapper
    implements android.view.ner
{

    final ViewItItemView this$0;
    final boolean val$isAllMatchesItem;
    final SearchResult val$item;
    final ViewItSlidingDrawerView val$slidingDrawer;
    final ViewItSearchResultWrapper val$wrapper;

    public void onClick(View view)
    {
        Object obj;
        ProductController productcontroller;
        if (val$isAllMatchesItem)
        {
            RefMarkerObserver.logRefMarker("fl_allmatch_dp");
        } else
        if (val$slidingDrawer.isOpened())
        {
            ViewItItemView.access$400(ViewItItemView.this).getViewItMetricHelper().logCountMetricsPerSession("history-maximized-item-tap", 1);
            RefMarkerObserver.logRefMarker("fl_max_dp");
        } else
        {
            ViewItItemView.access$400(ViewItItemView.this).getViewItMetricHelper().logCountMetricsPerSession("history-minimized-item-tap", 1);
            RefMarkerObserver.logRefMarker("fl_mini_dp");
        }
        productcontroller = new ProductController(val$item);
        productcontroller.setClickStreamTag(ViewItItemView.access$500(ViewItItemView.this, val$wrapper, val$isAllMatchesItem, val$slidingDrawer.isOpened()));
        obj = (Bitmap)LRUCache.getValue(ImageUtil.getImageUrl(val$item.getBasicProduct().getImageUrl(), getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.tem_thumbnail_picture_max_dimension)), android/graphics/Bitmap);
        view = ((View) (obj));
        if (obj == null)
        {
            view = BitmapFactory.decodeResource(getResources(), com.amazon.mShop.android.lib.e);
        }
        obj = new ByteArrayOutputStream();
        if (view.compress(android.graphics.rmat.JPEG, 100, ((java.io.OutputStream) (obj))))
        {
            productcontroller.setThumbnail(((ByteArrayOutputStream) (obj)).toByteArray());
        }
        ViewItItemView.access$400(ViewItItemView.this).forward(productcontroller);
        ViewItItemView.access$300(ViewItItemView.this).deleteUndoObject();
    }

    tWrapper()
    {
        this$0 = final_viewititemview;
        val$isAllMatchesItem = flag;
        val$slidingDrawer = viewitslidingdrawerview;
        val$item = searchresult;
        val$wrapper = ViewItSearchResultWrapper.this;
        super();
    }
}
