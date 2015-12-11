// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicYuvToRGB;
import co.vine.android.VineNotSupportedException;

public class RsYuv
{

    private Allocation mAllocationIn;
    private Allocation mAllocationOut;
    private ScriptIntrinsicYuvToRGB mYuv;

    public RsYuv(RenderScript renderscript, int i, int j)
        throws VineNotSupportedException
    {
        try
        {
            mYuv = ScriptIntrinsicYuvToRGB.create(renderscript, Element.RGBA_8888(renderscript));
            android.support.v8.renderscript.Type.Builder builder = new android.support.v8.renderscript.Type.Builder(renderscript, Element.RGBA_8888(renderscript));
            builder.setX(i);
            builder.setY(j);
            mAllocationOut = Allocation.createTyped(renderscript, builder.create());
            mAllocationIn = Allocation.createSized(renderscript, Element.U8(renderscript), j * i + (j / 2) * (i / 2) * 2);
        }
        // Misplaced declaration of an exception variable
        catch (RenderScript renderscript)
        {
            throw new VineNotSupportedException();
        }
        mYuv.setInput(mAllocationIn);
    }

    public void execute(byte abyte0[], Bitmap bitmap)
    {
        mAllocationIn.copyFrom(abyte0);
        mYuv.forEach(mAllocationOut);
        mAllocationOut.copyTo(bitmap);
    }
}
