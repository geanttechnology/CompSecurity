// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicBlend;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptIntrinsicBlend, RenderScriptThunker, ElementThunker, AllocationThunker, 
//            RenderScript, Element, Allocation

class ScriptIntrinsicBlendThunker extends android.support.v8.renderscript.ScriptIntrinsicBlend
{

    ScriptIntrinsicBlend mN;

    ScriptIntrinsicBlendThunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public static ScriptIntrinsicBlendThunker create(RenderScript renderscript, Element element)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        element = (ElementThunker)element;
        renderscript = new ScriptIntrinsicBlendThunker(0, renderscript);
        renderscript.mN = ScriptIntrinsicBlend.create(renderscriptthunker.mN, element.getNObj());
        return renderscript;
    }

    public void forEachAdd(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachAdd(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachClear(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachClear(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachDst(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachDst(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachDstAtop(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachDstAtop(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachDstIn(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachDstIn(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachDstOut(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachDstOut(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachDstOver(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachDstOver(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachMultiply(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachMultiply(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSrc(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSrc(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSrcAtop(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSrcAtop(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSrcIn(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSrcIn(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSrcOut(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSrcOut(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSrcOver(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSrcOver(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachSubtract(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachSubtract(allocation.getNObj(), allocation1.getNObj());
    }

    public void forEachXor(Allocation allocation, Allocation allocation1)
    {
        allocation = (AllocationThunker)allocation;
        allocation1 = (AllocationThunker)allocation1;
        mN.forEachXor(allocation.getNObj(), allocation1.getNObj());
    }

    public Script.KernelID getKernelIDAdd()
    {
        Script.KernelID kernelid = createKernelID(34, 3, null, null);
        kernelid.mN = mN.getKernelIDAdd();
        return kernelid;
    }

    public Script.KernelID getKernelIDClear()
    {
        Script.KernelID kernelid = createKernelID(0, 3, null, null);
        kernelid.mN = mN.getKernelIDClear();
        return kernelid;
    }

    public Script.KernelID getKernelIDDst()
    {
        Script.KernelID kernelid = createKernelID(2, 3, null, null);
        kernelid.mN = mN.getKernelIDDst();
        return kernelid;
    }

    public Script.KernelID getKernelIDDstAtop()
    {
        Script.KernelID kernelid = createKernelID(10, 3, null, null);
        kernelid.mN = mN.getKernelIDDstAtop();
        return kernelid;
    }

    public Script.KernelID getKernelIDDstIn()
    {
        Script.KernelID kernelid = createKernelID(6, 3, null, null);
        kernelid.mN = mN.getKernelIDDstIn();
        return kernelid;
    }

    public Script.KernelID getKernelIDDstOut()
    {
        Script.KernelID kernelid = createKernelID(8, 3, null, null);
        kernelid.mN = mN.getKernelIDDstOut();
        return kernelid;
    }

    public Script.KernelID getKernelIDDstOver()
    {
        Script.KernelID kernelid = createKernelID(4, 3, null, null);
        kernelid.mN = mN.getKernelIDDstOver();
        return kernelid;
    }

    public Script.KernelID getKernelIDMultiply()
    {
        Script.KernelID kernelid = createKernelID(14, 3, null, null);
        kernelid.mN = mN.getKernelIDMultiply();
        return kernelid;
    }

    public Script.KernelID getKernelIDSrc()
    {
        Script.KernelID kernelid = createKernelID(1, 3, null, null);
        kernelid.mN = mN.getKernelIDSrc();
        return kernelid;
    }

    public Script.KernelID getKernelIDSrcAtop()
    {
        Script.KernelID kernelid = createKernelID(9, 3, null, null);
        kernelid.mN = mN.getKernelIDSrcAtop();
        return kernelid;
    }

    public Script.KernelID getKernelIDSrcIn()
    {
        Script.KernelID kernelid = createKernelID(5, 3, null, null);
        kernelid.mN = mN.getKernelIDSrcIn();
        return kernelid;
    }

    public Script.KernelID getKernelIDSrcOut()
    {
        Script.KernelID kernelid = createKernelID(7, 3, null, null);
        kernelid.mN = mN.getKernelIDSrcOut();
        return kernelid;
    }

    public Script.KernelID getKernelIDSrcOver()
    {
        Script.KernelID kernelid = createKernelID(3, 3, null, null);
        kernelid.mN = mN.getKernelIDSrcOver();
        return kernelid;
    }

    public Script.KernelID getKernelIDSubtract()
    {
        Script.KernelID kernelid = createKernelID(35, 3, null, null);
        kernelid.mN = mN.getKernelIDSubtract();
        return kernelid;
    }

    public Script.KernelID getKernelIDXor()
    {
        Script.KernelID kernelid = createKernelID(11, 3, null, null);
        kernelid.mN = mN.getKernelIDXor();
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

    ScriptIntrinsicBlend getNObj()
    {
        return mN;
    }
}
