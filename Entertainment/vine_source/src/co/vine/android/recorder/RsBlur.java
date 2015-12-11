// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import com.edisonwang.android.slog.SLog;

public class RsBlur
{

    private Allocation mAllocationIn;
    private Allocation mAllocationOut;
    private ScriptIntrinsicBlur mBlur;
    private final int mHeight;
    private final int mWidth;

    public RsBlur(RenderScript renderscript, int i, int j, float f)
    {
        mWidth = i;
        mHeight = j;
        android.support.v8.renderscript.Type.Builder builder = new android.support.v8.renderscript.Type.Builder(renderscript, Element.RGBA_8888(renderscript));
        builder.setX(mWidth);
        builder.setY(mHeight);
        mAllocationIn = Allocation.createTyped(renderscript, builder.create());
        mAllocationOut = Allocation.createTyped(renderscript, builder.create());
        mBlur = ScriptIntrinsicBlur.create(renderscript, Element.U8_4(renderscript));
        mBlur.setRadius(f);
        mBlur.setInput(mAllocationIn);
    }

    public RsBlur(RenderScript renderscript, Bitmap bitmap, float f)
    {
        mWidth = bitmap.getWidth();
        mHeight = bitmap.getHeight();
        mAllocationOut = Allocation.createFromBitmap(renderscript, bitmap, android.support.v8.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 128);
        mAllocationIn = Allocation.createTyped(renderscript, mAllocationOut.getType());
        mBlur = ScriptIntrinsicBlur.create(renderscript, Element.U8_4(renderscript));
        mBlur.setRadius(f);
        mBlur.setInput(mAllocationIn);
    }

    public void execute(Bitmap bitmap, Bitmap bitmap1)
    {
        long l = System.currentTimeMillis();
        mAllocationIn.copyFrom(bitmap);
        mBlur.forEach(mAllocationOut);
        if (bitmap1 != null)
        {
            mAllocationOut.copyTo(bitmap1);
        }
        SLog.i("RenderScriptBlur took {}ms", Long.valueOf(System.currentTimeMillis() - l));
    }

    public void execute(Bitmap bitmap, Bitmap bitmap1, int i)
    {
        long l = System.currentTimeMillis();
        execute(bitmap, bitmap1);
        for (int j = 1; j < i; j++)
        {
            execute(bitmap1, bitmap1);
        }

        SLog.i("RenderScriptBlur loop took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
    }

    public void setRadius(float f)
    {
        mBlur.setRadius(f);
    }
}
