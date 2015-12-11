// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

// Referenced classes of package com.target.ui.util:
//            ah, o, q

public class s
{

    private static final int LABEL_TEXT_PADDING_FOR_NINE_PATCH_DP = 25;
    private static final int LABEL_TEXT_SIZE_DP = 10;
    private static final int LABEL_TEXT_VERTICAL_OFFSET_DP = 15;
    public static final String TAG = com/target/ui/util/s.getSimpleName();

    public s()
    {
    }

    private static Paint a(Context context, int i)
    {
        Paint paint = new Paint();
        paint.setTypeface(ah.a(context, ah.a.REGULAR));
        paint.setTextSize(10F * context.getResources().getDisplayMetrics().density);
        paint.setColor(context.getResources().getColor(i));
        paint.setAntiAlias(true);
        return paint;
    }

    public static BitmapDrawable a(Context context, int i, int j, int k)
    {
        Bitmap bitmap = BitmapFactoryInstrumentation.decodeResource(context.getResources(), i).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        Bitmap bitmap1 = BitmapFactoryInstrumentation.decodeResource(context.getResources(), j).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        o.a(bitmap1, k);
        canvas.drawBitmap(bitmap1, (bitmap.getWidth() - bitmap1.getWidth()) / 2, (bitmap.getHeight() - bitmap1.getHeight()) / 2 - bitmap.getHeight() / 6, paint);
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static BitmapDrawable a(Context context, int i, String s1, int j)
    {
        Bitmap bitmap = BitmapFactoryInstrumentation.decodeResource(context.getResources(), i).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        float f = context.getResources().getDisplayMetrics().density;
        Paint paint = a(context, j);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(s1, ((float)canvas.getWidth() - paint.measureText(s1)) / 2.0F, f * 15F, paint);
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static BitmapDrawable b(Context context, int i, String s1, int j)
    {
        Bitmap bitmap = BitmapFactoryInstrumentation.decodeResource(context.getResources(), i);
        if (bitmap.getNinePatchChunk() == null)
        {
            q.a(TAG, "Attempted to call labelMapPinWithNinePatch without a valid 9-patch");
            return a(context, i, s1, j);
        } else
        {
            Paint paint = a(context, j);
            float f = context.getResources().getDisplayMetrics().density;
            i = Math.round(paint.measureText(s1));
            j = Math.max(0, ((Math.round(25F * f) * 2 + i) - bitmap.getWidth()) / 2);
            Object obj = new Rect(j, 0, j, 0);
            NinePatchDrawable ninepatchdrawable = new NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), ((Rect) (obj)), null);
            bitmap = Bitmap.createBitmap(bitmap.getWidth() + ((Rect) (obj)).left + ((Rect) (obj)).right, bitmap.getHeight() + ((Rect) (obj)).top + ((Rect) (obj)).bottom, android.graphics.Bitmap.Config.ARGB_8888);
            obj = new Canvas(bitmap);
            ninepatchdrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            ninepatchdrawable.draw(((Canvas) (obj)));
            ((Canvas) (obj)).drawText(s1, (((Canvas) (obj)).getWidth() - i) / 2, 15F * f, paint);
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

}
