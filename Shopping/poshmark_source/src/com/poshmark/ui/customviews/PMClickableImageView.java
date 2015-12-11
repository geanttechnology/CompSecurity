// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMListingImageView, PMImageViewOnClickListener

public class PMClickableImageView extends PMListingImageView
{

    static final float THRESHOLD_DIP = 16F;
    Bundle bundleForDestinationFragment;
    Class destination;
    String displayString;
    boolean isImageSet;
    boolean isTextOverlay;
    Paint paint;
    Rect rect;
    StaticLayout textLayout;
    TextPaint textPaint;

    public PMClickableImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bundleForDestinationFragment = null;
        isTextOverlay = false;
        isImageSet = false;
        paint = new Paint();
        textPaint = new TextPaint();
        paint.setFlags(1);
        textPaint.setFlags(1);
    }

    public void launchFragmentOnClick()
    {
        if (customOnCLickListener != null)
        {
            customOnCLickListener.onClick(this, bundleForDestinationFragment);
        } else
        {
            if (destination != null)
            {
                ((PMActivity)getContext()).launchFragmentInNewActivity(bundleForDestinationFragment, destination, null);
                return;
            }
            Object obj = bundleForDestinationFragment.getString("DEEP_LINK", null);
            if (obj != null)
            {
                PMActivity pmactivity = (PMActivity)getContext();
                if (pmactivity instanceof MainActivity)
                {
                    obj = Uri.parse(((String) (obj)));
                    ((MainActivity)pmactivity).handleDeepLinkLaunch(((Uri) (obj)), false);
                    return;
                }
            }
        }
    }

    public void loadImage(String s)
    {
        displayString = null;
        releaseInternalBitmap();
        setImageBitmap(null);
        if (s != null)
        {
            ImageLoader.getInstance().displayImage(s, this);
            isImageSet = true;
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

    public void loadImageWithString(String s, boolean flag)
    {
        if (!flag)
        {
            releaseInternalBitmap();
            setImageBitmap(null);
        }
        textLayout = null;
        rect = null;
        displayString = s;
        isTextOverlay = flag;
        invalidate();
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (displayString == null)
        {
            return;
        }
        if (textLayout == null)
        {
            float f = getContext().getResources().getDisplayMetrics().density;
            android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_CENTER;
            float f1;
            float f2;
            float f3;
            if (isTextOverlay)
            {
                alignment = android.text.Layout.Alignment.ALIGN_NORMAL;
                textPaint.setTextSize(13F * f + 0.5F);
            } else
            {
                textPaint.setTextSize(16F * f + 0.5F);
            }
            textLayout = new StaticLayout(displayString, textPaint, getWidth() - 20, alignment, 1.0F, 0.0F, false);
        }
        if (rect == null)
        {
            if (isTextOverlay)
            {
                rect = new Rect(0, getHeight() - textLayout.getHeight() - 30, getWidth(), getHeight());
            } else
            {
                rect = new Rect(0, 0, getWidth(), getHeight());
            }
        }
        if (isTextOverlay)
        {
            paint.setColor(getResources().getColor(0x7f090002));
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect(rect, paint);
            textPaint.setColor(getResources().getColor(0x7f090040));
        } else
        {
            paint.setColor(-1);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect(rect, paint);
            paint.setColor(getResources().getColor(0x7f090016));
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setStrokeWidth(2.0F);
            canvas.drawRect(rect, paint);
            textPaint.setColor(0xff000000);
        }
        f3 = textLayout.getHeight();
        f = textLayout.getWidth();
        f1 = rect.top;
        f2 = rect.height() / 2;
        f3 /= 2.0F;
        canvas.translate((float)rect.left + ((float)(rect.width() / 2) - f / 2.0F), f1 + (f2 - f3));
        textLayout.draw(canvas);
        canvas.restore();
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
    }

    public void requestLayout()
    {
        if (!isImageSet)
        {
            super.requestLayout();
        }
    }

    public void setBundle(Bundle bundle)
    {
        bundleForDestinationFragment = bundle;
    }

    public void setDestinationFragment(Class class1)
    {
        destination = class1;
    }
}
