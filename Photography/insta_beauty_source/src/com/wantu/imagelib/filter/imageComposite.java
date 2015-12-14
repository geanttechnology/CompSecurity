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
import com.wantu.imagelib.cximage.CxImage;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.wantu.imagelib.filter:
//            commenProcess

class imageComposite extends commenProcess
{

    public String imgRes;
    public int op;

    imageComposite()
    {
    }

    private Bitmap getImage()
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        try
        {
            InputStream inputstream = context.getResources().getAssets().open(imgRes);
            bitmap1 = BitmapFactory.decodeStream(inputstream);
            inputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        bitmap = bitmap1;
        if (bitmap1.getWidth() * bitmap1.getHeight() != canvasBitmap.getWidth() * canvasBitmap.getHeight())
        {
            bitmap = Bitmap.createScaledBitmap(bitmap1, canvasBitmap.getWidth(), canvasBitmap.getHeight(), true);
        }
        return bitmap;
    }

    public void process(Canvas canvas, Paint paint)
    {
        CxImage cximage = new CxImage(canvasBitmap);
        Bitmap bitmap = getImage();
        if (bitmap != null)
        {
            cximage.a(bitmap, op);
            bitmap.recycle();
            canvas.drawBitmap(cximage.a(), 0.0F, 0.0F, paint);
        }
    }
}
