// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bb;

import android.renderscript.Element;
import android.renderscript.RenderScript;
import java.lang.ref.WeakReference;

public final class cf extends android.renderscript.Script.FieldBase
{

    public cf(RenderScript renderscript, int i)
    {
        android.renderscript.Element.Builder builder = new android.renderscript.Element.Builder(renderscript);
        builder.add(Element.createVector(renderscript, android.renderscript.Element.DataType.SIGNED_32, 2), "rb");
        builder.add(Element.createVector(renderscript, android.renderscript.Element.DataType.SIGNED_32, 2), "rt");
        builder.add(Element.createVector(renderscript, android.renderscript.Element.DataType.SIGNED_32, 2), "lb");
        builder.add(Element.createVector(renderscript, android.renderscript.Element.DataType.SIGNED_32, 2), "lt");
        mElement = builder.create();
        init(renderscript, i);
    }

    static 
    {
        new WeakReference(null);
    }
}
