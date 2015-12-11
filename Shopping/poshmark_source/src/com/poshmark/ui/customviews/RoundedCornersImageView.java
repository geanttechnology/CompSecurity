// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.application.PMApplication;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMAvataarImageView

public class RoundedCornersImageView extends PMAvataarImageView
{

    public RoundedCornersImageView(Context context)
    {
        super(context);
    }

    public RoundedCornersImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public static Bitmap getCroppedBitmapFromView(RoundedCornersImageView roundedcornersimageview, int i)
    {
        Bitmap bitmap = ((BitmapDrawable)roundedcornersimageview.getDrawable()).getBitmap();
        int j = 0;
        float f;
        Bitmap bitmap1;
        Canvas canvas;
        Paint paint;
        RectF rectf;
        if (bitmap == null)
        {
            j = PMApplication.getContext().getResources().getIdentifier("ic_user_default", "drawable", PMApplication.getContext().getPackageName());
            bitmap = BitmapFactoryInstrumentation.decodeResource(PMApplication.getContext().getResources(), j);
            j = 1;
        } else
        {
            bitmap = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        bitmap1 = Bitmap.createBitmap(roundedcornersimageview.getWidth(), roundedcornersimageview.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap1);
        paint = new Paint();
        roundedcornersimageview = new Rect(0, 0, roundedcornersimageview.getWidth(), roundedcornersimageview.getHeight());
        rectf = new RectF(roundedcornersimageview);
        f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawRoundRect(rectf, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), roundedcornersimageview, paint);
        if (j == 0)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    protected void onDraw(Canvas canvas)
    {
        while (getDrawable() == null || getWidth() == 0 || getHeight() == 0) 
        {
            return;
        }
        Bitmap bitmap = getCroppedBitmapFromView(this, 8);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        bitmap.recycle();
    }
}
