// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class BlurBitmapDisplayer
    implements BitmapDisplayer
{

    Context ctx;
    int radius;

    public BlurBitmapDisplayer(Context context, int i)
    {
        ctx = context;
        radius = i;
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        if (bitmap == null || bitmap.getConfig() == null)
        {
            return;
        } else
        {
            loadedfrom = bitmap.copy(bitmap.getConfig(), true);
            Object obj = RenderScript.create(ctx);
            bitmap = Allocation.createFromBitmap(((RenderScript) (obj)), bitmap);
            Allocation allocation = Allocation.createTyped(((RenderScript) (obj)), bitmap.getType());
            obj = ScriptIntrinsicBlur.create(((RenderScript) (obj)), Element.U8_4(((RenderScript) (obj))));
            ((ScriptIntrinsicBlur) (obj)).setRadius(radius);
            ((ScriptIntrinsicBlur) (obj)).setInput(bitmap);
            ((ScriptIntrinsicBlur) (obj)).forEach(allocation);
            allocation.copyTo(loadedfrom);
            imageaware.setImageBitmap(loadedfrom);
            return;
        }
    }
}
