// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Business;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.view.BusinessNonExactMatchCardListView;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

protected class trackingPositionOffset extends BaseAdapter
{

    public List businesses;
    private Activity context;
    final GlobalSearchResultFragment this$0;
    private int trackingPositionOffset;

    public int getCount()
    {
        return GlobalSearchResultFragment.access$700(GlobalSearchResultFragment.this)[5];
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, final View business, ViewGroup viewgroup)
    {
        if (business != null && business.getTag() != null && ((Integer)business.getTag()).intValue() == i)
        {
            return business;
        }
        business = (Business)businesses.get(i);
        viewgroup = new BusinessNonExactMatchCardListView(context);
        if (business != null)
        {
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalSearchResultFragment.BusinessNonExactMatchAdapter this$1;
                final Business val$business;

                public void onClick(View view)
                {
                    loggingUtils.logClick("", "merchant_impression_click", Channel.MERCHANT_PAGE.toString(), loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(business.remoteId)));
                    startActivity(GlobalSearchResultFragment.access$1000(this$0).newMerchantPageIntent(business.remoteId));
                }

            
            {
                this$1 = GlobalSearchResultFragment.BusinessNonExactMatchAdapter.this;
                business = business1;
                super();
            }
            });
            viewgroup.setInfo(business);
        }
        viewgroup.setTag(Integer.valueOf(i));
        if (i != 0) goto _L2; else goto _L1
_L1:
        int j = (int)(10F * context.getResources().getDisplayMetrics().density);
        FrameLayout framelayout = (FrameLayout)viewgroup.findViewById(0x7f100156);
        android.view.Adapter adapter = new android.view.Adapter.context(framelayout.getLayoutParams());
        adapter.context(0, j, 0, 0);
        framelayout.setLayoutParams(new android.widget.apter.context(adapter));
_L4:
        if (trackingPositionOffset == -1)
        {
            trackingPositionOffset = getTrackingPositionOffset(5);
        }
        if (business != null)
        {
            loggingUtils.logImpression("", "merchant", ((Business) (business)).remoteId, (new StringBuilder()).append(trackingPositionOffset + i).append("").toString(), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        }
        return viewgroup;
_L2:
        if (i == businesses.size() - 1)
        {
            int k = (int)(10F * context.getResources().getDisplayMetrics().density);
            FrameLayout framelayout1 = (FrameLayout)viewgroup.findViewById(0x7f100156);
            android.view.Adapter adapter1 = new android.view.Adapter.context(framelayout1.getLayoutParams());
            adapter1.context(0, 0, 0, k);
            framelayout1.setLayoutParams(new android.widget.apter.context(adapter1));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public _cls1.val.business(Activity activity)
    {
        this$0 = GlobalSearchResultFragment.this;
        super();
        trackingPositionOffset = 0;
        context = activity;
        activity = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(activity);
        trackingPositionOffset = -1;
    }
}
