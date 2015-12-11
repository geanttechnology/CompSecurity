// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingOverviewModel

public class ListAnItemContentViewHolder extends ViewHolder
{

    private static final int SCREEN_WIDTH_SMALL = 360;
    private static final int SCREEN_WIDTH_WIDE = 768;
    protected static boolean isTablet = false;
    private static final int wideScreenPhoneImageWidth = 150;
    public final View cardView;
    public final TextView cashDescription;
    public final RemoteImageView cashInImage;
    public final TextView cashTitle;
    private final int dp;
    public final Button sellSomethingButton;

    public ListAnItemContentViewHolder(View view)
    {
        super(view);
        cardView = view;
        Resources resources = view.getResources();
        isTablet = resources.getBoolean(0x7f0b0006);
        cashInImage = (RemoteImageView)view.findViewById(0x7f100232);
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        dp = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        if (dp > 360 && dp < 768)
        {
            cashInImage.getLayoutParams().width = (int)TypedValue.applyDimension(1, 150F, resources.getDisplayMetrics());
        }
        cashTitle = (TextView)view.findViewById(0x7f100233);
        cashDescription = (TextView)view.findViewById(0x7f100234);
        sellSomethingButton = (Button)view.findViewById(0x7f100235);
        cardView.setOnClickListener(this);
        sellSomethingButton.setOnClickListener(this);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        while (!(viewmodel instanceof SellingOverviewModel) || ((SellingOverviewModel)viewmodel).record == null) 
        {
            return false;
        }
        return true;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof SellingOverviewModel)
        {
            viewmodel = ((SellingOverviewModel)viewmodel).record.listAnItems;
            if (viewmodel != null && !viewmodel.isEmpty())
            {
                viewmodel = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate)viewmodel.get(0);
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).image != null)
                {
                    cashInImage.setRemoteImageUrl(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).image.url);
                    if (dp < 768 && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).image.originalSize != null)
                    {
                        itemView.measure(0, 0);
                        Object obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).image.originalSize;
                        float f = (float)cashInImage.getMeasuredHeight() / (float)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Image.ImageSize) (obj)).height;
                        obj = new Matrix();
                        ((Matrix) (obj)).postScale(f, f);
                        cashInImage.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                        cashInImage.setImageMatrix(((Matrix) (obj)));
                    }
                    cashInImage.setVisibility(0);
                } else
                {
                    int i = cardView.getResources().getColor(0x106000d);
                    cardView.setBackgroundColor(i);
                    cashInImage.setVisibility(8);
                }
                if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).title))
                {
                    cashTitle.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).title);
                    cashTitle.setVisibility(0);
                } else
                {
                    cashTitle.setVisibility(8);
                }
                if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).subtext))
                {
                    cashDescription.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).subtext);
                    cashDescription.setVisibility(0);
                } else
                {
                    cashDescription.setVisibility(8);
                }
                sellSomethingButton.setText(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate) (viewmodel)).button.text);
            }
        }
    }

    public String getVariationId()
    {
        if (model != null)
        {
            return ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageTemplate)((SellingOverviewModel)model).record.listAnItems.get(0)).trackingId;
        } else
        {
            return null;
        }
    }
}
