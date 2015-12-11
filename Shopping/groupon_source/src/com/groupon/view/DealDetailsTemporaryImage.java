// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.groupon.util.Function0;
import com.groupon.util.ImageUrl;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class DealDetailsTemporaryImage extends UrlImageView
{

    public DealDetailsTemporaryImage(Context context)
    {
        this(context, null);
    }

    public DealDetailsTemporaryImage(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DealDetailsTemporaryImage(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
    }

    public void loadImageFromUrl(ImageUrl imageurl, final Function0 callback)
    {
        setCallback(new Callback() {

            final DealDetailsTemporaryImage this$0;
            final Function0 val$callback;

            public void onError(ImageView imageview)
            {
                if (callback != null)
                {
                    callback.execute();
                }
            }

            public void onSuccess(ImageView imageview)
            {
                if (callback != null)
                {
                    callback.execute();
                }
            }

            
            {
                this$0 = DealDetailsTemporaryImage.this;
                callback = function0;
                super();
            }
        });
        setImageUrl(imageurl);
    }

    public void setImageHeight(float f)
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.width = -1;
        layoutparams.height = (int)TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        setLayoutParams(layoutparams);
    }

    public void setImageSize(float f, float f1)
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.width = (int)TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
        layoutparams.height = (int)TypedValue.applyDimension(1, f1, getResources().getDisplayMetrics());
        setLayoutParams(layoutparams);
    }
}
