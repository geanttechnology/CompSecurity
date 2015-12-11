// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.UserCache;
import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.ui_stuff.Util;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.myebay:
//            SavedSellerListActivity

private class sellerList extends ArrayAdapter
{

    private ArrayList sellerList;
    final SavedSellerListActivity this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (sellerList == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        viewgroup = view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = SavedSellerListActivity.access$000(SavedSellerListActivity.this).inflate(0x7f0300a5, null);
        }
        viewgroup = (FavoriteSeller)sellerList.get(i);
        if (SavedSellerListActivity.access$100(SavedSellerListActivity.this).isFavSeller(((FavoriteSeller) (viewgroup)).sellerId)) goto _L2; else goto _L1
_L1:
        return view;
_L2:
        Object obj;
        i = ((FavoriteSeller) (viewgroup)).feedbackScore;
        obj = ((FavoriteSeller) (viewgroup)).sellerId;
        obj = (new StringBuilder()).append(((String) (obj))).append("  (").append(i).append(") ").toString();
        ImageView imageview = (ImageView)view.findViewById(0x7f1001ae);
        imageview.setOnClickListener(new android.view.View.OnClickListener() {

            final SavedSellerListActivity.FavoriteSellerAdapter this$1;
            final String val$ratingStar;
            final String val$strSellerId;

            public void onClick(View view1)
            {
                if (!SavedSellerListActivity.access$200(this$0))
                {
                    SavedSellerListActivity.access$302(this$0, getListView().getFirstVisiblePosition());
                    UserDetailActivity.StartActivity(this$0, strSellerId, null, ratingStar, true);
                }
            }

            
            {
                this$1 = SavedSellerListActivity.FavoriteSellerAdapter.this;
                strSellerId = s;
                ratingStar = s1;
                super();
            }
        });
        if (((FavoriteSeller) (viewgroup)).myWorldSmallImg != null)
        {
            SavedSellerListActivity.access$400(SavedSellerListActivity.this).setImage(imageview, ((FavoriteSeller) (viewgroup)).myWorldSmallImg.toString());
        }
        ((TextView)view.findViewById(0x7f1001af)).setText(((CharSequence) (obj)));
        ((TextView)view.findViewById(0x7f1001b2)).setText(((FavoriteSeller) (viewgroup)).notes);
        obj = (TextView)view.findViewById(0x7f1001b1);
        if (!TextUtils.isEmpty(((FavoriteSeller) (viewgroup)).positiveFeedbackPercent))
        {
            ((TextView) (obj)).setText(Util.getFeedbackPercentString(getApplicationContext(), ((FavoriteSeller) (viewgroup)).positiveFeedbackPercent));
        }
        boolean flag = false;
        obj = (ImageView)view.findViewById(0x7f1001b0);
        i = ((flag) ? 1 : 0);
        if (!TextUtils.isEmpty(((FavoriteSeller) (viewgroup)).feedbackRatingStar))
        {
            int j = Util.getRatingStarResId(((FavoriteSeller) (viewgroup)).feedbackRatingStar);
            i = ((flag) ? 1 : 0);
            if (j != 0)
            {
                i = 1;
                ((ImageView) (obj)).setImageResource(j);
            }
        }
        if (i != 0) goto _L1; else goto _L3
_L3:
        ((ImageView) (obj)).setEnabled(false);
        return view;
        return null;
    }

    _cls1.val.ratingStar(Activity activity, ArrayList arraylist)
    {
        this$0 = SavedSellerListActivity.this;
        super(activity, 0x7f0300a5, arraylist);
        sellerList = null;
        sellerList = arraylist;
        SavedSellerListActivity.access$002(SavedSellerListActivity.this, activity.getLayoutInflater());
    }
}
