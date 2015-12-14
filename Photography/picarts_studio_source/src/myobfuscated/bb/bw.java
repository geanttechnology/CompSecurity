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

public final class bw extends ScriptC
{

    private Element a;

    public bw(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_utils_tent_convolve_gray_float", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private bw(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.F32(renderscript);
    }

    public final void a(Allocation allocation)
    {
        if (!allocation.getType().getElement().isCompatible(a))
        {
            throw new RSRuntimeException("Type mismatch with F32!");
        } else
        {
            forEach(0, null, allocation, null);
            return;
        }
    }

    public final void a(Allocation allocation, boolean flag)
    {
        FieldPacker fieldpacker = new FieldPacker(12);
        fieldpacker.addObj(allocation);
        fieldpacker.addI32(7);
        fieldpacker.addBoolean(flag);
        fieldpacker.skip(3);
        invoke(0, fieldpacker);
    }
}
