// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;


// Referenced classes of package android.support.v8.renderscript:
//            ScriptGroupThunker, RenderScriptThunker, TypeThunker, RenderScript, 
//            Type

public static final class bN
{

    android.renderscript.er.Builder.bN bN;
    RenderScript mRS;

    public bN addConnection(Type type, bN bn, bN bn1)
    {
        type = (TypeThunker)type;
        bN.ection(type.getNObj(), bn.bN, bn1.bN);
        return this;
    }

    public bN addConnection(Type type, bN bn, bN bn1)
    {
        type = (TypeThunker)type;
        bN.ection(type.getNObj(), bn.bN, bn1.bN);
        return this;
    }

    public bN addKernel(bN bn)
    {
        bN.el(bn.bN);
        return this;
    }

    public ScriptGroupThunker create()
    {
        ScriptGroupThunker scriptgroupthunker = new ScriptGroupThunker(0, mRS);
        scriptgroupthunker.mN = bN.bN();
        return scriptgroupthunker;
    }

    (RenderScript renderscript)
    {
        RenderScriptThunker renderscriptthunker = (RenderScriptThunker)renderscript;
        mRS = renderscript;
        bN = new android.renderscript.er.Builder.bN(renderscriptthunker.mN);
    }
}
