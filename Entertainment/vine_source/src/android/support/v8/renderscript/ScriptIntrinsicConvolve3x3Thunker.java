// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicConvolve3x3;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicConvolve3x3, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            RenderScript, Element, Allocation

class ScriptIntrinsicConvolve3x3Thunker extends android.support.v8.renderscript.ScriptIntrinsicConvolve3x3
{

    ScriptIntrinsicConvolve3x3 mN;

    ScriptIntrinsicConvolve3x3Thunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicConvolve3x3Thunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicConvolve3x3Thunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicConvolve3x3.create(renderscriptthunker.mN, element.getNObj());
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

    ScriptIntrinsicConvolve3x3 getNObj()
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
