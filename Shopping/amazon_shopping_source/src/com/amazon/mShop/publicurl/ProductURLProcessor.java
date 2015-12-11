// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import java.util.List;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessor

public class ProductURLProcessor extends PublicURLProcessor
{

    private String mMetricIdentity;

    public ProductURLProcessor(Uri uri)
    {
        super(uri);
        mMetricIdentity = "PD";
    }

    protected void doProcess(Context context)
    {
        Object obj1 = getRefmarker();
        Object obj;
        if (Util.isEmpty(((String) (obj1))))
        {
            obj = ClickStreamTag.ORIGIN_PUBLIC_URL;
        } else
        {
            obj = new ClickStreamTag("");
        }
        if (mPathSegments.size() >= 2)
        {
            String s = (String)mPathSegments.get(1);
            obj1 = null;
            if (!Util.isEmpty(s))
            {
                obj = new ProductController(s, ((ClickStreamTag) (obj)));
                mMetricIdentity = "PD";
                obj1 = obj;
                if (mPathSegments.size() == 4)
                {
                    obj1 = obj;
                    if (((String)mPathSegments.get(2)).equalsIgnoreCase("merchants"))
                    {
                        ((ProductController) (obj)).setMerchantId((String)mPathSegments.get(3));
                        mMetricIdentity = "PD_M";
                        obj1 = obj;
                    }
                }
            }
            if (obj1 != null)
            {
                if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
                {
                    RefMarkerObserver.logRefMarker("pn_product_detail_t");
                }
                ActivityUtils.launchDetailsPage(context, ((ProductController) (obj1)), getParams(), 0x80000);
            }
        } else
        if (mPathSegments.size() == 1)
        {
            Object obj2 = mUri.getQueryParameter("q");
            if (!Util.isEmpty(((String) (obj2))))
            {
                String as[] = ((String) (obj2)).split("\\+");
                obj2 = new StringBuilder();
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    ((StringBuilder) (obj2)).append(as[i]).append(" ");
                }

                mMetricIdentity = "SEARCH";
                if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
                {
                    RefMarkerObserver.logRefMarker("pn_search_t");
                }
                context = (AmazonActivity)context;
                ActivityUtils.startSearchActivity(context, (new SearchIntentBuilder(context)).query(((StringBuilder) (obj2)).toString()).clickStreamOrigin(((ClickStreamTag) (obj)).getTag()).refmarker(((String) (obj1))).extraFlag(0x80000).build());
                return;
            }
            obj2 = mUri.getQueryParameter("searchtype");
            if (!Util.isEmpty(((String) (obj2))))
            {
                Intent intent = new Intent(context, com/amazon/mShop/search/SearchActivity);
                intent.setAction("android.intent.action.VIEW");
                if (((String) (obj2)).equals("barcode"))
                {
                    mMetricIdentity = "barcode";
                    if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
                    {
                        RefMarkerObserver.logRefMarker("pn_barcode_t");
                    }
                    intent.putExtra("barcodeActivatedFromDeepLink", true);
                    intent.setData(Uri.parse("BARCODE_SEARCH_QUERY_KEYWORD"));
                    context.startActivity(intent);
                    return;
                }
                if (((String) (obj2)).equals("flow"))
                {
                    mMetricIdentity = "flow";
                    if (ActivityUtils.isFlowEnabled(context))
                    {
                        if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
                        {
                            RefMarkerObserver.logRefMarker("pn_flow_t");
                        }
                        intent.putExtra("flowActivatedFromDeepLink", true);
                        intent.setData(Uri.parse("IMAGE_SEARCH_QUERY_KEYWORD"));
                        context.startActivity(intent);
                        return;
                    } else
                    {
                        Toast.makeText(context, context.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_flow_not_support), 1).show();
                        return;
                    }
                }
                if (((String) (obj2)).equals("searchEntry"))
                {
                    mMetricIdentity = "searchEntry";
                    context = (AmazonActivity)context;
                    ActivityUtils.startSearchActivity(context, (new SearchIntentBuilder(context)).showSearchEntryView(true).selectInitialQuery(false).clickStreamOrigin(((ClickStreamTag) (obj)).getTag()).refmarker(((String) (obj1))).extraFlag(0x80000).build());
                    return;
                }
            }
        }
    }

    public String getMetricIdentity()
    {
        return mMetricIdentity;
    }
}
