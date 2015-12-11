// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Gallery;
import android.widget.SpinnerAdapter;
import com.amazon.mShop.imageview.PinchImageView;
import com.amazon.mShop.ui.WeakReferenceBitmapDrawable;

// Referenced classes of package com.amazon.mShop.details:
//            CustomizedGallery

public class GalleryPinchImageView extends PinchImageView
{

    private boolean mCanSwitchImageView;
    private Gallery mGallery;

    public GalleryPinchImageView(Context context)
    {
        this(context, null);
    }

    public GalleryPinchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private static boolean equalFloat(float f, float f1)
    {
        return Math.abs(f - f1) < 0.1F;
    }

    private void switchGalleryImage(int i)
    {
        mGallery.setVisibility(0);
        setVisibility(4);
        mGallery.onKeyDown(i, null);
        mCanSwitchImageView = false;
    }

    public Gallery getGallery()
    {
        return mGallery;
    }

    public void setBackendResource()
    {
        int i = mGallery.getSelectedItemPosition();
        if (mGallery.getSelectedView() != null)
        {
            setInitialImageDisplaySize(mGallery.getSelectedView().getWidth(), mGallery.getSelectedView().getHeight());
        }
        android.graphics.Bitmap bitmap = null;
        if (mGallery.getAdapter() != null)
        {
            bitmap = ((WeakReferenceBitmapDrawable)((CustomizedGallery)mGallery).getAdapter().getItem(i)).getBitmap();
        }
        setImageBitmap(bitmap);
        mCanSwitchImageView = true;
    }

    public void setGallery(Gallery gallery)
    {
        mGallery = gallery;
    }

    protected void updateRect(RectF rectf, RectF rectf1)
    {
        int i;
        int j;
        i = getWidth();
        j = getHeight();
        if (rectf.top >= 0.0F && rectf.bottom <= (float)j)
        {
            rectf1.top = 0.0F;
        }
        if (rectf.left < 0.0F || rectf.right > (float)i) goto _L2; else goto _L1
_L1:
        if (rectf1.left <= 30F || !mCanSwitchImageView || mGallery.getSelectedItemPosition() <= 0) goto _L4; else goto _L3
_L3:
        switchGalleryImage(21);
_L6:
        rectf1.left = 0.0F;
_L2:
        if (rectf.top + rectf1.top >= 0.0F && rectf.bottom > (float)j)
        {
            rectf1.top = 0.0F - rectf.top;
        }
        if (rectf.bottom + rectf1.top <= (float)j && rectf.top < 0.0F)
        {
            rectf1.top = (float)j - rectf.bottom;
        }
        if (rectf.left + rectf1.left >= 0.0F)
        {
            if (equalFloat(rectf.left, 0.0F) && mCanSwitchImageView && rectf1.left > 30F && mGallery.getSelectedItemPosition() > 0)
            {
                switchGalleryImage(21);
            }
            rectf1.left = 0.0F - rectf.left;
        }
        if (rectf.right + rectf1.left <= (float)i)
        {
            if (equalFloat(rectf.right, i) && mCanSwitchImageView && rectf1.left <= -30F && mGallery.getSelectedItemPosition() < mGallery.getAdapter().getCount() - 1)
            {
                switchGalleryImage(22);
            }
            rectf1.left = (float)i - rectf.right;
        }
        return;
_L4:
        if (rectf1.left < -30F && mCanSwitchImageView && mGallery.getSelectedItemPosition() < mGallery.getAdapter().getCount() - 1)
        {
            switchGalleryImage(22);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void updateScale(ScaleGestureDetector scalegesturedetector)
    {
        super.updateScale(scalegesturedetector);
        if (scalegesturedetector.getScaleFactor() != 1.0F)
        {
            ((CustomizedGallery)mGallery).logImageZoomedRefMarker();
        }
    }

    public void zoomTo(float f, float f1, float f2)
    {
        if (f <= 1.0F)
        {
            getGallery().setVisibility(0);
            setVisibility(4);
            return;
        } else
        {
            super.zoomTo(f, f1, f2);
            return;
        }
    }
}
