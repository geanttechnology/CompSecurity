// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bb;

import android.content.Context;
import android.content.res.Resources;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.renderscript.Type;

public final class ad extends ScriptC
{

    private Element a;

    public ad(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_lensblur", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private ad(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.I32_3(renderscript);
    }

    public final void a(Allocation allocation)
    {
        if (!allocation.getType().getElement().isCompatible(a))
        {
            throw new RSRuntimeException("Type mismatch with I32_3!");
        } else
        {
            forEach(0, null, allocation, null);
            return;
        }
    }

    public final void a(Allocation allocation, int i, int j, int k, int l)
    {
        FieldPacker fieldpacker = new FieldPacker(20);
        fieldpacker.addObj(allocation);
        fieldpacker.addI32(i);
        fieldpacker.addI32(j);
        fieldpacker.addI32(k);
        fieldpacker.addI32(l);
        invoke(0, fieldpacker);
    }
}
