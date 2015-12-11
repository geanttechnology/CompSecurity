// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;


// Referenced classes of package android.support.v8.renderscript:
//            ElementThunker, RenderScriptThunker, RenderScript, Element

static class mN
{

    android.renderscript.derThunker.mN mN;

    public void add(Element element, String s, int i)
    {
        element = (ElementThunker)element;
        mN.mN(((ElementThunker) (element)).mN, s, i);
    }

    public Element create(RenderScript renderscript)
    {
        return new ElementThunker(renderscript, mN.mN());
    }

    public (RenderScript renderscript)
    {
        mN = new android.renderscript.derThunker.mN(((RenderScriptThunker)renderscript).mN);
    }
}
