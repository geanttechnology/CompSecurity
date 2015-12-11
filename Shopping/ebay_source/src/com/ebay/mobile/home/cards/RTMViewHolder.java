// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.home.cards:
//            RTMViewModel

public class RTMViewHolder extends ViewHolder
{

    private static final int PROMO_AD_WIDTH_WIDE = 768;
    private final TextView description;
    private final Button learnMoreButton;
    private final RemoteImageView logoUrl;
    private final RemoteImageView promoImage;
    private final boolean rtmStylingEnabled;
    private final TextView subTitle;
    private final TextView title;

    public RTMViewHolder(View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x7f100252);
        subTitle = (TextView)view.findViewById(0x7f100254);
        description = (TextView)view.findViewById(0x7f100255);
        logoUrl = (RemoteImageView)view.findViewById(0x7f100251);
        promoImage = (RemoteImageView)view.findViewById(0x7f100253);
        learnMoreButton = (Button)view.findViewById(0x7f10024e);
        if (learnMoreButton != null)
        {
            learnMoreButton.setOnClickListener(this);
        }
        view.setOnClickListener(this);
        rtmStylingEnabled = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.Verticals.B.rtmCardStyle);
    }

    public static boolean isValidModel(ViewModel viewmodel)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (viewmodel instanceof RTMViewModel)
        {
            viewmodel = (RTMViewModel)viewmodel;
            flag = flag1;
            if (((RTMViewModel) (viewmodel)).title != null)
            {
                flag = flag1;
                if (((RTMViewModel) (viewmodel)).description != null)
                {
                    flag = flag1;
                    if (((RTMViewModel) (viewmodel)).imageUrl != null)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof RTMViewModel)
        {
            viewmodel = (RTMViewModel)viewmodel;
            if (((RTMViewModel) (viewmodel)).cardStyle == 0 || !rtmStylingEnabled)
            {
                title.setText(((RTMViewModel) (viewmodel)).title);
                subTitle.setText(((RTMViewModel) (viewmodel)).subTitle);
                description.setText(((RTMViewModel) (viewmodel)).description);
                logoUrl.setRemoteImageUrl(((RTMViewModel) (viewmodel)).logoUrl);
                promoImage.setRemoteImageUrl(((RTMViewModel) (viewmodel)).imageUrl);
                RemoteImageView remoteimageview = promoImage;
                byte byte0;
                if (TextUtils.isEmpty(((RTMViewModel) (viewmodel)).imageUrl))
                {
                    byte0 = 8;
                } else
                {
                    byte0 = 0;
                }
                remoteimageview.setVisibility(byte0);
                learnMoreButton.setText(((RTMViewModel) (viewmodel)).buttonText);
            } else
            if (((RTMViewModel) (viewmodel)).cardStyle == 1)
            {
                title.setText(((RTMViewModel) (viewmodel)).title);
                subTitle.setText(((RTMViewModel) (viewmodel)).subTitle);
                promoImage.setRemoteImageUrl(((RTMViewModel) (viewmodel)).imageUrl);
                return;
            }
        }
    }
}
