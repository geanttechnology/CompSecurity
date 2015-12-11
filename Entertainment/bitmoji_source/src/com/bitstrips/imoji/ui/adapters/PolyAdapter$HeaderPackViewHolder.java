// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.bitstrips.imoji.models.BitshopPack;
import com.crashlytics.android.Crashlytics;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public static class _cls1.val.topImageUrl extends android.support.v7.widget.older
    implements _cls1.val.topImageUrl
{

    ImageView mHeaderBottomImage;
    ImageView mHeaderTopImage;
    mTitleView mItem;
    TextView mTitleView;
    View mTopShadowLine;

    private void onErrorLogo(String s)
    {
        mHeaderTopImage.setVisibility(8);
        mTitleView.setVisibility(0);
        StringBuilder stringbuilder = (new StringBuilder()).append("Failed to load Bitshop pack header logo image: ");
        if (s == null)
        {
            s = "null";
        }
        s = stringbuilder.append(s).toString();
        Log.e("error", s);
        Crashlytics.log(s);
    }

    public void setBackground(String s)
    {
        Picasso.with(mHeaderTopImage.getContext()).load(s).placeholder(new ColorDrawable(mItem.().getBgColor())).fit().centerInside().into(mHeaderBottomImage);
    }

    public void setImage(final String topImageUrl)
    {
        if (TextUtils.isEmpty(topImageUrl))
        {
            onErrorLogo(topImageUrl);
        }
        mHeaderTopImage.setVisibility(0);
        Picasso.with(mHeaderTopImage.getContext()).load(topImageUrl).fit().centerInside().into(mHeaderTopImage, new Callback() {

            final PolyAdapter.HeaderPackViewHolder this$0;
            final String val$topImageUrl;

            public void onError()
            {
                onErrorLogo(topImageUrl);
            }

            public void onSuccess()
            {
                mTitleView.setVisibility(8);
            }

            
            {
                this$0 = PolyAdapter.HeaderPackViewHolder.this;
                topImageUrl = s;
                super();
            }
        });
    }

    public void setItem(mTitleView mtitleview)
    {
        mItem = mtitleview;
    }

    public void setTitle(String s)
    {
        mTitleView.setTextColor(mItem.().getFgColor());
        mTitleView.setText(s);
    }


    public _cls1.val.topImageUrl(View view)
    {
        super(view);
        ButterKnife.bind(this, view);
    }
}
