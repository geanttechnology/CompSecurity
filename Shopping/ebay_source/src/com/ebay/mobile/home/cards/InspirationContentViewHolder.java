// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingOverviewModel

public class InspirationContentViewHolder extends ViewHolder
{

    public final Button learnMoreButton;
    private final Resources resources;
    public final View step1;
    public final View step2;
    public final View step3;
    public final TextView valetDescription1;
    public final TextView valetDescription2;
    public final TextView valetDescription3;
    public final RemoteImageView valetImage1;
    public final RemoteImageView valetImage2;
    public final RemoteImageView valetImage3;
    public final TextView valetTitle;

    public InspirationContentViewHolder(View view)
    {
        super(view);
        valetTitle = (TextView)view.findViewById(0x7f10024a);
        step1 = view.findViewById(0x7f10024b);
        valetImage1 = (RemoteImageView)step1.findViewById(0x7f10024f);
        valetDescription1 = (TextView)step1.findViewById(0x7f100250);
        step2 = view.findViewById(0x7f10024c);
        valetImage2 = (RemoteImageView)step2.findViewById(0x7f10024f);
        valetDescription2 = (TextView)step2.findViewById(0x7f100250);
        step3 = view.findViewById(0x7f10024d);
        valetImage3 = (RemoteImageView)step3.findViewById(0x7f10024f);
        valetDescription3 = (TextView)step3.findViewById(0x7f100250);
        learnMoreButton = (Button)view.findViewById(0x7f10024e);
        learnMoreButton.setOnClickListener(this);
        resources = view.getResources();
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        while (!(viewmodel instanceof SellingOverviewModel) || ((SellingOverviewModel)viewmodel).sellingImageList == null) 
        {
            return false;
        }
        return true;
    }

    public void bind(ViewModel viewmodel)
    {
        boolean flag = false;
        super.bind(viewmodel);
        int i = getItemViewType();
        if (i == 20 || i == 16)
        {
            android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)learnMoreButton.getLayoutParams();
            layoutparams.width = resources.getDimensionPixelSize(0x7f09004e);
            learnMoreButton.setLayoutParams(layoutparams);
        }
        if (viewmodel instanceof SellingOverviewModel)
        {
            viewmodel = ((SellingOverviewModel)viewmodel).sellingImageList;
            valetTitle.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).title);
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList.Item item = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList.Item)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).items.get(0);
            if (item != null)
            {
                valetImage1.setRemoteImageUrl(item.image.url);
                valetDescription1.setText(item.subtext);
            }
            View view = step1;
            int j;
            if (item != null)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            item = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList.Item)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).items.get(1);
            if (item != null)
            {
                valetImage2.setRemoteImageUrl(item.image.url);
                valetDescription2.setText(item.subtext);
            }
            view = step2;
            if (item != null)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            item = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList.Item)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).items.get(2);
            if (item != null)
            {
                valetImage3.setRemoteImageUrl(item.image.url);
                valetDescription3.setText(item.subtext);
            }
            view = step3;
            if (item != null)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).button != null)
            {
                learnMoreButton.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (viewmodel)).button.text);
            }
        }
    }

    public String getVariationId()
    {
        if (model != null)
        {
            return ((SellingOverviewModel)model).sellingImageList.trackingId;
        } else
        {
            return null;
        }
    }
}
