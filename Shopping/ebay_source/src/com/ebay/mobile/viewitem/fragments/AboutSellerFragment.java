// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.UserThumbnail;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class AboutSellerFragment extends ViewItemBaseFragment
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{

    private ImageDataManager imageDataManager;
    private UserThumbnail sellerAvatar;
    private View sellersOtherItemsLayout;

    public AboutSellerFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof BaseActivity)
        {
            imageDataManager = (ImageDataManager)DataManager.get(((BaseActivity)activity).getEbayContext(), ImageDataManager.KEY);
            imageDataManager.registerObserver(this);
        }
    }

    public void onClick(View view)
    {
        int i = view.getId();
        switch (i)
        {
        default:
            if (this.view != null && i == this.view.getId())
            {
                startUserDetails();
                return;
            } else
            {
                super.onClick(view);
                return;
            }

        case 2131755142: 
            ActivityStarter.startSellerItemsSearchResultList((BaseActivity)getActivity(), item.sellerUserId, false, null);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f03001a, viewgroup, false);
        view.setOnClickListener(this);
        sellerAvatar = (UserThumbnail)view.findViewById(0x7f100082);
        sellersOtherItemsLayout = view.findViewById(0x7f100086);
        return view;
    }

    public void onDetach()
    {
        super.onDetach();
        if (imageDataManager != null)
        {
            imageDataManager.unregisterObserver(this);
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        if (!content.getStatus().hasError())
        {
            sellerAvatar.setImageBitmap(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
        }
    }

    protected void render(Item item, ViewItemViewData viewitemviewdata, ViewItemBaseFragment.ExpandState expandstate)
    {
        int i = 0;
        super.render(item, viewitemviewdata, expandstate);
        Float float1;
        TextView textview;
        TextView textview1;
        if (!TextUtils.isEmpty(item.sellerAvatarUrl) && imageDataManager != null)
        {
            imageDataManager.loadImage(this, item.sellerAvatarUrl);
        } else
        {
            sellerAvatar.postImageResource(0x7f020241);
        }
        viewitemviewdata = item.sellerUserId;
        expandstate = Integer.valueOf(item.sellerFeedbackScore);
        float1 = Float.valueOf(item.sellerPositiveFeedbackPercent);
        textview = (TextView)view.findViewById(0x7f100084);
        textview1 = (TextView)view.findViewById(0x7f100085);
        if (expandstate != null)
        {
            textview.setText(getString(0x7f07050c, new Object[] {
                viewitemviewdata, expandstate
            }));
        } else
        {
            textview.setText(viewitemviewdata);
        }
        if (float1 != null)
        {
            textview1.setText(Util.getFeedbackPercentString(getActivity(), float1.floatValue()));
        } else
        {
            textview1.setVisibility(8);
        }
        viewitemviewdata = sellersOtherItemsLayout;
        if (item.isSeller)
        {
            i = 8;
        }
        viewitemviewdata.setVisibility(i);
        viewitemviewdata = sellersOtherItemsLayout;
        if (!item.isSeller)
        {
            item = this;
        } else
        {
            item = null;
        }
        viewitemviewdata.setOnClickListener(item);
    }

    public void startUserDetails()
    {
        Activity activity = getActivity();
        UserDetailActivity.StartActivityForSeller(activity, viewData, item.sellerUserId, null, item.sellerFeedbackRatingStar, activity.getIntent().getBooleanExtra("is_sellers_other_item", false), false, viewData.searchOtherCountries);
    }
}
