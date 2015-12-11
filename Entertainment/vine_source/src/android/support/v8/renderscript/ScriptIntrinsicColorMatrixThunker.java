// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Matrix3f;
import android.renderscript.Matrix4f;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicColorMatrix;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicColorMatrix, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            Matrix3f, Matrix4f, RenderScript, Element, 
//            Allocation

class ScriptIntrinsicColorMatrixThunker extends android.support.v8.renderscript.ScriptIntrinsicColorMatrix
{

    ScriptIntrinsicColorMatrix mN;

    private ScriptIntrinsicColorMatrixThunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicColorMatrixThunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicColorMatrixThunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicColorMatrix.create(renderscriptthunker.mN, element.getNObj());
        return renderscript;
    }

    public void forEach(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEach(allocation.getNObj(), allocation1.getNObj());
    }

    public Script.KernelID getKernelID()
    {
        Script.KernelID kernelid = createKernelID(0, 3, null, null);
        kernelid.mN = mN.getKernelID();
        return kernelid;
    }

    volatile BaseObj getNObj()
    {
        return getNObj();
    }

    volatile Script getNObj()
    {
        return getNObj();
    }

    ScriptIntrinsicColorMatrix getNObj()
    {
        return mN;
    }

    public void setColorMatrix(android.support.v8.renderscript.Matrix3f matrix3f)
    {
        mN.setColorMatrix(new Matrix3f(matrix3f.getArray()));
    }

    public void setColorMatrix(android.support.v8.renderscript.Matrix4f matrix4f)
    {
        mN.setColorMatrix(new Matrix4f(matrix4f.getArray()));
    }

    public void setGreyscale()
    {
        mN.setGreyscale();
    }

    public void setRGBtoYUV()
    {
        mN.setRGBtoYUV();
    }

    public void setYUVtoRGB()
    {
        mN.setYUVtoRGB();
    }
}
