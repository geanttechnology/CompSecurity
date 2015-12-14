// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.squareup.picasso.Transformation;

public class BlurTransform
    implements Transformation
{

    private int radius;
    RenderScript rs;

    public BlurTransform(Context context, int i)
    {
        radius = i;
        if (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 17)
        {
            rs = RenderScript.create(context);
        }
    }

    public String key()
    {
        return "blur";
    }

    public Bitmap transform(Bitmap bitmap)
    {
        while (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() < 17 || Integer.valueOf(android.os.Build.VERSION.SDK).intValue() < 17) 
        {
            return bitmap;
        }
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap);
        bitmap = Allocation.createFromBitmap(rs, bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_FULL, 1);
        Allocation allocation = Allocation.createTyped(rs, bitmap.getType());
        ScriptIntrinsicBlur scriptintrinsicblur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        scriptintrinsicblur.setInput(bitmap);
        scriptintrinsicblur.setRadius(radius);
        scriptintrinsicblur.forEach(allocation);
        allocation.copyTo(bitmap1);
        return bitmap1;
    }
}
