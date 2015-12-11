// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.utils.ViewUtils;

public class PMEditListingImageView extends ImageView
{

    private String imageId;
    private Uri imageUri;
    private boolean isCovershot;
    private boolean isNextSelector;
    private boolean isSet;
    private Uri originalImageUri;
    private String url;

    public PMEditListingImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isCovershot = false;
        isSet = false;
        isNextSelector = false;
    }

    private void setImageUrl(String s)
    {
        url = s;
        if (s != null)
        {
            ImageLoader.getInstance().displayImage(s, this);
        } else
        {
            setImageBitmap(null);
        }
        isSet = true;
    }

    public Uri getFileUri()
    {
        return imageUri;
    }

    public String getImageId()
    {
        return imageId;
    }

    public String getImageUrl()
    {
        return url;
    }

    public Uri getOriginalFileUri()
    {
        return originalImageUri;
    }

    public void imageAssignedState(boolean flag)
    {
        isSet = flag;
        isNextSelector = false;
    }

    public boolean isCovershot()
    {
        return isCovershot;
    }

    public boolean isImageSet()
    {
        return isSet;
    }

    public boolean isNextSelector()
    {
        return isNextSelector;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isSet)
        {
            return;
        }
        Paint paint = new Paint();
        if (isNextSelector)
        {
            paint.setColor(getResources().getColor(0x7f090039));
            String s = getResources().getString(0x7f060036);
            Rect rect = new Rect();
            paint.setTextSize(ViewUtils.dipToPixels(getContext(), 9F));
            paint.getTextBounds(s, 0, s.length(), rect);
            Bitmap bitmap = BitmapFactoryInstrumentation.decodeResource(getResources(), 0x7f02006e);
            int i = getHeight() / 2 - bitmap.getHeight() / 2 - rect.height() / 2;
            canvas.drawBitmap(bitmap, getWidth() / 2 - bitmap.getWidth() / 2, i, paint);
            int j = bitmap.getHeight();
            canvas.drawText(s, getWidth() / 2 - rect.width() / 2, i + (j + 25), paint);
            paint.setColor(getResources().getColor(0x7f090016));
        } else
        {
            paint.setColor(getResources().getColor(0x7f090018));
        }
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(4F);
        paint.setPathEffect(new DashPathEffect(new float[] {
            10F, 5F, 10F, 5F
        }, 1.0F));
        canvas.drawRoundRect(new RectF(0.0F, 0.0F, getWidth() - 1, getHeight() - 1), 10F, 10F, paint);
    }

    public void resetImageView()
    {
        setImageResource(0);
        isSet = false;
        url = null;
        imageUri = null;
        originalImageUri = null;
        isNextSelector = false;
    }

    public void setAsNextEmptyImageView(boolean flag)
    {
        isNextSelector = flag;
    }

    public void setCovershotStatus(boolean flag)
    {
        isCovershot = flag;
    }

    public void setFileUri(Uri uri)
    {
        imageUri = uri;
    }

    public void setOriginalFileUri(Uri uri)
    {
        originalImageUri = uri;
    }

    public void setRemoteImageInfo(String s, String s1)
    {
        setImageUrl(s);
        imageId = s1;
    }

    public void setURL(String s)
    {
        url = s;
    }
}
