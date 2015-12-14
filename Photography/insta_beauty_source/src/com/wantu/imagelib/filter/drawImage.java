// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.IOException;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class drawImage extends commenProcess
{

    public String imgName;
    public Rect rect;

    drawImage()
    {
    }

    public void process(Canvas canvas, Paint paint)
    {
        try
        {
            Object obj = context.getResources().getAssets().open(imgName);
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)), null, options);
            canvas.drawBitmap(((Bitmap) (obj)), null, rect, paint);
            ((Bitmap) (obj)).recycle();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            canvas.printStackTrace();
        }
    }
}
