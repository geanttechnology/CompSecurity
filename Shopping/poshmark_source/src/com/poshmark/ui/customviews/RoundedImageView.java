// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.AttributeSet;
import android.view.View;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.poshmark.application.PMApplication;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMAvataarImageView

public class RoundedImageView extends PMAvataarImageView
{

    private boolean attachedToWindow;
    private boolean hasBorder;
    private Bitmap imageBmp;
    public ImageLoadingListener listener = new ImageLoadingListener() {

        final RoundedImageView this$0;

        public void onLoadingCancelled(String s, View view)
        {
            view = ImageLoader.getInstance();
            imageBmp = view.loadImageSync(s);
            if (attachedToWindow)
            {
                setBitmap();
            }
        }

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            imageBmp = bitmap;
            if (attachedToWindow)
            {
                setBitmap();
            }
        }

        public void onLoadingFailed(String s, View view, FailReason failreason)
        {
        }

        public void onLoadingStarted(String s, View view)
        {
            int i = getResources().getIdentifier("ic_user_default", "drawable", PMApplication.getContext().getPackageName());
            imageBmp = BitmapFactoryInstrumentation.decodeResource(PMApplication.getContext().getResources(), i);
            if (attachedToWindow)
            {
                setBitmap();
            }
        }

            
            {
                this$0 = RoundedImageView.this;
                super();
            }
    };

    public RoundedImageView(Context context)
    {
        super(context);
        hasBorder = false;
        attachedToWindow = false;
    }

    public RoundedImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        hasBorder = false;
        attachedToWindow = false;
        hasBorder = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.RoundedImageView).getBoolean(0, false);
    }

    public static Bitmap getCroppedBitmap(Bitmap bitmap, int i)
    {
        boolean flag = false;
        Bitmap bitmap1;
        Canvas canvas;
        Paint paint;
        Rect rect;
        if (bitmap.getWidth() != i || bitmap.getHeight() != i)
        {
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i, false);
            i = 1;
        } else
        {
            i = ((flag) ? 1 : 0);
        }
        bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        paint = new Paint();
        rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (i != 0)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        attachedToWindow = true;
        setBitmap();
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        attachedToWindow = false;
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj = getDrawable();
        if (obj != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                super.onDraw(canvas);
                return;
            }
            if (getWidth() != 0 && getHeight() != 0)
            {
                obj = ((BitmapDrawable)obj).getBitmap();
                int i = 0;
                float f;
                Bitmap bitmap;
                int j;
                int k;
                int l;
                if (obj == null)
                {
                    i = getResources().getIdentifier("ic_user_default", "drawable", PMApplication.getContext().getPackageName());
                    obj = BitmapFactoryInstrumentation.decodeResource(PMApplication.getContext().getResources(), i);
                    i = 1;
                } else
                {
                    obj = ((Bitmap) (obj)).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                }
                k = getWidth();
                l = getHeight();
                f = 0.0F;
                j = k;
                if (hasBorder)
                {
                    f = 2.0F;
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setColor(Color.parseColor("#99ffffff"));
                    canvas.drawCircle(k / 2, l / 2, k / 2, paint);
                    j = (int)((float)k - 2.0F * 2.0F);
                }
                bitmap = getCroppedBitmap(((Bitmap) (obj)), j);
                canvas.drawBitmap(bitmap, f, f, null);
                bitmap.recycle();
                if (i == 0)
                {
                    ((Bitmap) (obj)).recycle();
                    return;
                }
            }
        }
    }

    public void setBitmap()
    {
label0:
        {
            if (imageBmp != null)
            {
                if (android.os.Build.VERSION.SDK_INT < 18)
                {
                    break label0;
                }
                RoundedBitmapDrawable roundedbitmapdrawable = RoundedBitmapDrawableFactory.create(PMApplication.getContext().getResources(), imageBmp);
                roundedbitmapdrawable.setCornerRadius((float)Math.max(imageBmp.getWidth(), imageBmp.getHeight()) / 2.0F);
                setImageDrawable(roundedbitmapdrawable);
            }
            return;
        }
        setImageBitmap(imageBmp);
    }

    public void setBitmap(int i)
    {
        imageBmp = BitmapFactoryInstrumentation.decodeResource(PMApplication.getContext().getResources(), i);
        if (attachedToWindow)
        {
            setBitmap();
        }
    }

    public void setBitmap(Bitmap bitmap)
    {
        imageBmp = bitmap;
        if (attachedToWindow)
        {
            setBitmap();
        }
    }

    public void setHasBorder(boolean flag)
    {
        hasBorder = flag;
    }


/*
    static Bitmap access$002(RoundedImageView roundedimageview, Bitmap bitmap)
    {
        roundedimageview.imageBmp = bitmap;
        return bitmap;
    }

*/

}
