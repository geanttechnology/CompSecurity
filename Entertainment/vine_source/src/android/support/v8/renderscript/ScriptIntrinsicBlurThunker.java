// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicBlur;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicBlur, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            RenderScript, Element, Allocation

class ScriptIntrinsicBlurThunker extends android.support.v8.renderscript.ScriptIntrinsicBlur
{

    ScriptIntrinsicBlur mN;

    protected ScriptIntrinsicBlurThunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicBlurThunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicBlurThunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicBlur.create(renderscriptthunker.mN, element.getNObj());
        return renderscript;
    }

    public void forEach(Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        if (allocation != null)
        {
            mN.forEach(allocation.getNObj());
        }
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

    ScriptIntrinsicBlur getNObj()
    {
        return mN;
    }

    public void setInput(Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.setInput(allocation.getNObj());
    }

    public void setRadius(float f)
    {
        mN.setRadius(f);
    }
}
