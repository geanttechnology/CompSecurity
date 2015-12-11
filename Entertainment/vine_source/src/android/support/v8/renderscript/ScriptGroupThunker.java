// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.ScriptGroup;

// Referenced classes of package android.support.v8.renderscript:
//            ScriptGroup, AllocationThunker, RenderScript, Allocation, 
//            RenderScriptThunker, TypeThunker, Type

class ScriptGroupThunker extends android.support.v8.renderscript.ScriptGroup
{
    public static final class Builder
    {

        android.renderscript.ScriptGroup.Builder bN;
        RenderScript mRS;

        public Builder addConnection(Type type, Script.KernelID kernelid, Script.FieldID fieldid)
        {
            type = (TypeThunker)type;
            bN.addConnection(type.getNObj(), kernelid.mN, fieldid.mN);
            return this;
        }

        public Builder addConnection(Type type, Script.KernelID kernelid, Script.KernelID kernelid1)
        {
            type = (TypeThunker)type;
            bN.addConnection(type.getNObj(), kernelid.mN, kernelid1.mN);
            return this;
        }

        public Builder addKernel(Script.KernelID kernelid)
        {
            bN.addKernel(kernelid.mN);
            return this;
        }

        public ScriptGroupThunker create()
        {
            ScriptGroupThunker scriptgroupthunker = new ScriptGroupThunker(0, mRS);
            scriptgroupthunker.mN = bN.create();
            return scriptgroupthunker;
        }

        Builder(RenderScript renderscript)
        {
            RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
            mRS = renderscript;
            bN = new android.renderscript.ScriptGroup.Builder(renderscriptthunker.mN);
        }
    }


    ScriptGroup mN;

    ScriptGroupThunker(int i, RenderScript renderscript)
    {
        super(i, renderscript);
    }

    public void execute()
    {
        mN.execute();
    }

    volatile BaseObj getNObj()
    {
        return getNObj();
    }

    ScriptGroup getNObj()
    {
        return mN;
    }

    public void setInput(Script.KernelID kernelid, Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.setInput(kernelid.mN, allocation.getNObj());
    }

    public void setOutput(Script.KernelID kernelid, Allocation allocation)
    {
        allocation = (AllocationThunker)allocation;
        mN.setOutput(kernelid.mN, allocation.getNObj());
    }
}
