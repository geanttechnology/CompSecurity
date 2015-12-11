// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicConvolve5x5;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicConvolve5x5, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            RenderScript, Element, Allocation

class ScriptIntrinsicConvolve5x5Thunker extends android.support.v8.renderscript.ScriptIntrinsicConvolve5x5
{

    ScriptIntrinsicConvolve5x5 mN;

    ScriptIntrinsicConvolve5x5Thunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicConvolve5x5Thunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicConvolve5x5Thunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicConvolve5x5.create(renderscriptthunker.mN, element.getNObj());
        return renderscript;
    }

    public void forEach(Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.forEach(allocation.getNObj());
    }

    public Script.FieldID getFieldID_Input()
    {
        Script.FieldID fieldid = createFieldID(1, null);
        fieldid.mN = mN.getFieldID_Input();
        return fieldid;
    }

    public Script.KernelID getKernelID()
    {
        Script.KernelID kernelid = createKernelID(0, 2, null, null);
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

    ScriptIntrinsicConvolve5x5 getNObj()
    {
        return mN;
    }

    public void setCoefficients(float af[])
    {
        mN.setCoefficients(af);
    }

    public void setInput(Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.setInput(allocation.getNObj());
    }
}
