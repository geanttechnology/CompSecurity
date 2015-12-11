// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.util.MShopUiOOMHandler;

public class Stars extends LinearLayout
{

    private int mStarHeight;

    public Stars(Context context)
    {
        super(context);
    }

    public Stars(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private Bitmap getResourceBitmap(int i)
    {
        android.graphics.drawable.Drawable drawable = getResources().getDrawable(i);
        Object obj = null;
        Bitmap bitmap = obj;
        if (drawable != null)
        {
            bitmap = obj;
            if (drawable instanceof BitmapDrawable)
            {
                bitmap = ((BitmapDrawable)drawable).getBitmap();
            }
        }
        return bitmap;
    }

    private Bitmap scaleBitmap(Bitmap bitmap)
    {
        if (mStarHeight == 0 || bitmap.getHeight() == mStarHeight)
        {
            return bitmap;
        } else
        {
            float f = (float)mStarHeight / ((float)bitmap.getHeight() * 1.0F);
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
    }

    public void setRating(final Integer rating)
    {
        (new MShopUiOOMHandler((Activity)getContext(), new com.amazon.mShop.util.MShopUiOOMHandler.UiRunnable(new Runnable() {

            final Stars this$0;
            final Integer val$rating;

            public void run()
            {
                boolean flag = false;
                if (rating != null) goto _L2; else goto _L1
_L1:
                setVisibility(8);
_L4:
                return;
_L2:
                for (; 5 > getChildCount(); addView(new ImageView(getContext()))) { }
                Bitmap bitmap5 = getResourceBitmap(com.amazon.mShop.android.lib.R.drawable.star_on);
                Bitmap bitmap4 = getResourceBitmap(com.amazon.mShop.android.lib.R.drawable.star_half);
                Bitmap bitmap3 = getResourceBitmap(com.amazon.mShop.android.lib.R.drawable.star_off);
                if (bitmap5 != null && bitmap4 != null && bitmap3 != null)
                {
                    Bitmap bitmap1 = bitmap3;
                    Bitmap bitmap2 = bitmap5;
                    Bitmap bitmap = bitmap4;
                    if (mStarHeight > 0)
                    {
                        bitmap2 = scaleBitmap(bitmap5);
                        bitmap = scaleBitmap(bitmap4);
                        bitmap1 = scaleBitmap(bitmap3);
                    }
                    setVisibility(0);
                    int k = rating.intValue();
                    if ((rating.intValue() & 1) != 0)
                    {
                        flag = true;
                    }
                    int i;
                    for (i = 0; i < k >> 1; i++)
                    {
                        ((ImageView)getChildAt(i)).setImageBitmap(bitmap2);
                    }

                    if (flag)
                    {
                        Stars stars = Stars.this;
                        int j = i + 1;
                        ((ImageView)stars.getChildAt(i)).setImageBitmap(bitmap);
                        i = j;
                    }
                    while (i < 5) 
                    {
                        ((ImageView)getChildAt(i)).setImageBitmap(bitmap1);
                        i++;
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = Stars.this;
                rating = integer;
                super();
            }
        }, true))).execute();
    }

    public void setStarHeight(int i)
    {
        mStarHeight = i;
    }



}
