// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMImageViewOnClickListener

public abstract class PMImageView extends ImageView
{

    boolean bUsingResourceBitmap;
    PMImageViewOnClickListener customOnCLickListener;
    android.view.View.OnClickListener imageClickListener = new android.view.View.OnClickListener() {

        final PMImageView this$0;

        public void onClick(View view)
        {
            ((PMImageView)view).launchFragmentOnClick();
        }

            
            {
                this$0 = PMImageView.this;
                super();
            }
    };
    protected String imgURL;

    public PMImageView(Context context)
    {
        super(context);
        imgURL = "";
        bUsingResourceBitmap = true;
    }

    public PMImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        imgURL = "";
        bUsingResourceBitmap = true;
        context = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMImageView);
        if (context.getBoolean(0, true))
        {
            setOnClickListener(imageClickListener);
        }
        context.recycle();
    }

    public String getImageURL()
    {
        return imgURL;
    }

    public abstract void launchFragmentOnClick();

    public void loadImage(int i)
    {
        imgURL = "";
        bUsingResourceBitmap = true;
        setImageDrawable(getResources().getDrawable(i));
    }

    public void loadImage(String s)
    {
        releaseInternalBitmap();
        setImageBitmap(null);
        if (s != null)
        {
            ImageLoader.getInstance().displayImage(s, this);
            imgURL = s;
            bUsingResourceBitmap = false;
        } else
        {
            imgURL = "";
            bUsingResourceBitmap = true;
            s = getResources().getDrawable(0x7f0200d4);
            if (s instanceof BitmapDrawable)
            {
                setImageBitmap(((BitmapDrawable)s).getBitmap());
                return;
            }
        }
    }

    public void releaseInternalBitmap()
    {
        if (!bUsingResourceBitmap)
        {
            Object obj = (BitmapDrawable)getDrawable();
            if (obj != null)
            {
                obj = ((BitmapDrawable) (obj)).getBitmap();
                if (obj != null)
                {
                    ((Bitmap) (obj)).recycle();
                    setImageDrawable(null);
                    setImageBitmap(null);
                    imgURL = "";
                }
            }
        }
    }

    public void resetImageUrl()
    {
        imgURL = "";
    }

    public void setCustomOnClickListener(PMImageViewOnClickListener pmimageviewonclicklistener)
    {
        customOnCLickListener = pmimageviewonclicklistener;
    }
}
