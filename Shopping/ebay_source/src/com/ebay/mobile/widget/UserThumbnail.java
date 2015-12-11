// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.nautilus.domain.content.dm.UserAvatarUrlDataManager;
import com.ebay.nautilus.kernel.util.FwLog;

public class UserThumbnail extends RemoteImageView
    implements com.ebay.nautilus.domain.content.dm.UserAvatarUrlDataManager.Observer
{

    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo errorLog = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBay", 6, "UserThumbnail Non-Fatal Error Occurred");
    private static float screenScale;
    private UserAvatarUrlDataManager avatarDm;
    private int borderColor;
    private Paint borderPaint;
    private float borderWidthDip;
    private final int defaultBorderColor;
    private final float defaultBorderWidthDip;
    private final int defaultFillColor;
    private int fillColor;
    private String requestedUrl;
    private Paint shaderPaint;
    private Bitmap unprocessedBitmap;

    public UserThumbnail(Context context)
    {
        this(context, null);
    }

    public UserThumbnail(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public UserThumbnail(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        defaultFillColor = -1;
        defaultBorderColor = 0xff000000;
        defaultBorderWidthDip = 0.0F;
        getXmlAttributes(attributeset);
        missingImageResId = 0x7f020241;
        emptyLoadingColor = 0;
    }

    private Bitmap createCroppedBitmap(Bitmap bitmap)
    {
        BitmapShader bitmapshader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        Paint paint = getShaderPaint();
        paint.setShader(bitmapshader);
        int j = Math.min(getWidth(), getHeight());
        if (j <= 0)
        {
            unprocessedBitmap = bitmap;
            return bitmap;
        } else
        {
            bitmap = Bitmap.createBitmap(j, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawOval(new RectF(0.0F, 0.0F, j, j), getBorderPaint());
            int i = scaleToScreen(borderWidthDip);
            j -= scaleToScreen(borderWidthDip * 2.0F);
            canvas.drawRoundRect(new RectF(i, i, j + i, j + i), (float)j / 2.0F, (float)j / 2.0F, paint);
            paint.setShader(null);
            return bitmap;
        }
    }

    private Bitmap createScaledBitmap(Bitmap bitmap)
    {
        int i = Math.min(getWidth(), getHeight());
        if (i < 0)
        {
            unprocessedBitmap = bitmap;
        } else
        {
            int k = scaleToScreen(2.0F * borderWidthDip);
            int l = bitmap.getWidth();
            int j = bitmap.getHeight();
            float f = (float)(i - k) / (float)Math.max(l, j);
            k = Math.round((float)l * f);
            j = Math.round((float)j * f);
            if (k > 0 && j > 0)
            {
                Bitmap bitmap1 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap1);
                canvas.drawColor(fillColor);
                bitmap = Bitmap.createScaledBitmap(bitmap, k, j, false);
                canvas.drawBitmap(bitmap, (float)(i - bitmap.getWidth()) / 2.0F, (float)(i - bitmap.getHeight()) / 2.0F, null);
                return bitmap1;
            }
        }
        return bitmap;
    }

    private void ensureAvatarDm()
    {
        if (avatarDm == null && !isInEditMode())
        {
            if (ebayContext != null)
            {
                avatarDm = (UserAvatarUrlDataManager)UserAvatarUrlDataManager.get(ebayContext, UserAvatarUrlDataManager.KEY);
                avatarDm.registerObserver(this);
            } else
            if (errorLog.isLoggable)
            {
                FwLog.logMethod(errorLog, new Object[0]);
                return;
            }
        }
    }

    private Paint getBorderPaint()
    {
        if (borderPaint == null)
        {
            borderPaint = new Paint();
            borderPaint.setAntiAlias(true);
        }
        return borderPaint;
    }

    private Paint getShaderPaint()
    {
        if (shaderPaint == null)
        {
            shaderPaint = new Paint();
            shaderPaint.setAntiAlias(true);
        }
        return shaderPaint;
    }

    private void getXmlAttributes(AttributeSet attributeset)
    {
        attributeset = getContext().getTheme().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.UserThumbnail, 0, 0);
        fillColor = attributeset.getColor(2, -1);
        borderColor = attributeset.getColor(1, 0xff000000);
        borderWidthDip = attributeset.getDimension(0, 0.0F);
        attributeset.recycle();
        attributeset = getBorderPaint();
        attributeset.setStrokeWidth(borderWidthDip);
        attributeset.setColor(borderColor);
    }

    private void removeAvatarDm()
    {
        if (avatarDm != null)
        {
            avatarDm.unregisterObserver(this);
            avatarDm = null;
        }
        setTag(null);
    }

    private int scaleToScreen(float f)
    {
        if (screenScale == 0.0F)
        {
            screenScale = getResources().getDisplayMetrics().density;
        }
        return Math.round(screenScale * f);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        removeAvatarDm();
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (i > 0 && j > 0 && unprocessedBitmap != null)
        {
            Bitmap bitmap = unprocessedBitmap;
            unprocessedBitmap = null;
            setImageBitmap(bitmap);
        }
    }

    public void onUserAvatarUrlChanged(UserAvatarUrlDataManager useravatarurldatamanager, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        useravatarurldatamanager = ((UserAvatarUrlDataManager) (getTag()));
        if ((useravatarurldatamanager instanceof CharSequence) && useravatarurldatamanager.equals(s))
        {
            setRemoteImageUrl(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        useravatarurldatamanager;
        throw useravatarurldatamanager;
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            ensureAvatarDm();
            return;

        case 4: // '\004'
        case 8: // '\b'
            removeAvatarDm();
            break;
        }
    }

    public void postImageResource(final int drawableResourceId)
    {
        post(new Runnable() {

            final UserThumbnail this$0;
            final int val$drawableResourceId;

            public void run()
            {
                setImageResource(drawableResourceId);
            }

            
            {
                this$0 = UserThumbnail.this;
                drawableResourceId = i;
                super();
            }
        });
    }

    public void setBorderColor(int i)
    {
        borderColor = i;
        getBorderPaint().setColor(borderColor);
        if (requestedUrl != null)
        {
            setRemoteImageUrl(requestedUrl);
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        }
        try
        {
            Bitmap bitmap1 = createCroppedBitmap(createScaledBitmap(bitmap));
            super.setImageDrawable(new BitmapDrawable(getResources(), bitmap1));
            return;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            super.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicHeight() > 0 && drawable.getIntrinsicWidth() > 0)
        {
            setImageBitmap(((BitmapDrawable)drawable).getBitmap());
            return;
        } else
        {
            super.setImageDrawable(drawable);
            return;
        }
    }

    public void setRemoteImageUrl(String s)
    {
        super.setRemoteImageUrl(s);
        requestedUrl = s;
        setTag(null);
    }

    public void setUserId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        ensureAvatarDm();
        s1 = avatarDm.getDataForUserIfExists(s);
        setRemoteImageUrl(s1);
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        setTag(s);
        avatarDm.loadDataForUser(this, s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
