// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public class RoundedBitmapDisplayer
    implements BitmapDisplayer
{

    private static int $SWITCH_TABLE$android$widget$ImageView$ScaleType[];
    private final int roundPixels;

    static int[] $SWITCH_TABLE$android$widget$ImageView$ScaleType()
    {
        int ai[] = $SWITCH_TABLE$android$widget$ImageView$ScaleType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[android.widget.ImageView.ScaleType.values().length];
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$android$widget$ImageView$ScaleType = ai;
        return ai;
    }

    public RoundedBitmapDisplayer(int i)
    {
        roundPixels = i;
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i, Rect rect, Rect rect1, int j, int k)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        rect1 = new RectF(rect1);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff000000);
        canvas.drawRoundRect(rect1, i, i, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect1, paint);
        return bitmap1;
    }

    public static Bitmap roundCorners(Bitmap bitmap, ImageView imageview, int i)
    {
        int j;
        int k;
        int l;
        int i1;
        i1 = bitmap.getWidth();
        l = bitmap.getHeight();
        j = imageview.getWidth();
        int j1 = imageview.getHeight();
        k = j;
        if (j <= 0)
        {
            k = i1;
        }
        j = j1;
        if (j1 <= 0)
        {
            j = l;
        }
        $SWITCH_TABLE$android$widget$ImageView$ScaleType()[imageview.getScaleType().ordinal()];
        JVM INSTR tableswitch 1 8: default 108
    //                   1 536
    //                   2 347
    //                   3 190
    //                   4 108
    //                   5 108
    //                   6 108
    //                   7 493
    //                   8 536;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5 _L2
_L1:
        Rect rect;
        int l1;
        int j2;
        int l2;
        int j3;
        if ((float)k / (float)j > (float)i1 / (float)l)
        {
            int k1 = (int)((float)i1 / ((float)l / (float)j));
            k = j;
            j = k1;
        } else
        {
            j = k;
            k = (int)((float)l / ((float)i1 / (float)k));
        }
        imageview = new Rect(0, 0, i1, l);
        rect = new Rect(0, 0, j, k);
_L7:
        int i2;
        int k2;
        int i3;
        int k3;
        try
        {
            imageview = getRoundedCornerBitmap(bitmap, i, imageview, rect, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview)
        {
            L.e(imageview, "Can't create bitmap with rounded corners. Not enough memory.", new Object[0]);
            return bitmap;
        }
        return imageview;
_L4:
        if ((float)k / (float)j > (float)i1 / (float)l)
        {
            l1 = Math.min(j, l);
            j2 = (int)((float)i1 / ((float)l / (float)l1));
        } else
        {
            j2 = Math.min(k, i1);
            l1 = (int)((float)l / ((float)i1 / (float)j2));
        }
        l2 = (k - j2) / 2;
        j3 = (j - l1) / 2;
        imageview = new Rect(0, 0, i1, l);
        rect = new Rect(l2, j3, l2 + j2, j3 + l1);
        l = j;
        j = k;
        k = l;
        continue; /* Loop/switch isn't completed */
_L3:
        if ((float)k / (float)j > (float)i1 / (float)l)
        {
            k2 = i1;
            i2 = (int)((float)j * ((float)i1 / (float)k));
            i3 = 0;
            k3 = (l - i2) / 2;
        } else
        {
            k2 = (int)((float)k * ((float)l / (float)j));
            i2 = l;
            i3 = (i1 - k2) / 2;
            k3 = 0;
        }
        k = Math.min(k, i1);
        l = Math.min(j, l);
        imageview = new Rect(i3, k3, i3 + k2, k3 + i2);
        rect = new Rect(0, 0, k, l);
        j = k;
        k = l;
        continue; /* Loop/switch isn't completed */
_L5:
        i2 = j;
        imageview = new Rect(0, 0, i1, l);
        rect = new Rect(0, 0, k, i2);
        j = k;
        k = i2;
        continue; /* Loop/switch isn't completed */
_L2:
        k = Math.min(k, i1);
        i2 = Math.min(j, l);
        j = (i1 - k) / 2;
        l = (l - i2) / 2;
        imageview = new Rect(j, l, j + k, l + i2);
        rect = new Rect(0, 0, k, i2);
        j = k;
        k = i2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Bitmap display(Bitmap bitmap, ImageView imageview)
    {
        bitmap = roundCorners(bitmap, imageview, roundPixels);
        imageview.setImageBitmap(bitmap);
        return bitmap;
    }
}
