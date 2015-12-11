// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicLUT;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicLUT, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            RenderScript, Element, Allocation

class ScriptIntrinsicLUTThunker extends android.support.v8.renderscript.ScriptIntrinsicLUT
{

    ScriptIntrinsicLUT mN;

    private ScriptIntrinsicLUTThunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicLUTThunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicLUTThunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicLUT.create(renderscriptthunker.mN, element.getNObj());
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

    ScriptIntrinsicLUT getNObj()
    {
        return mN;
    }

    public void setAlpha(int i, int j)
    {
        mN.setAlpha(i, j);
    }

    public void setBlue(int i, int j)
    {
        mN.setBlue(i, j);
    }

    public void setGreen(int i, int j)
    {
        mN.setGreen(i, j);
    }

    public void setRed(int i, int j)
    {
        mN.setRed(i, j);
    }
}
