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

public final class bu extends ScriptC
{

    private Element a;

    public bu(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_utils_pst_shadows_and_highlights", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private bu(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.U8_4(renderscript);
    }

    public final void a(Allocation allocation)
    {
        if (!allocation.getType().getElement().isCompatible(a))
        {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        } else
        {
            forEach(0, null, allocation, null);
            return;
        }
    }

    public final void a(Allocation allocation, Allocation allocation1, float f, float f1, float f2, float f3)
    {
        FieldPacker fieldpacker = new FieldPacker(24);
        fieldpacker.addObj(allocation);
        fieldpacker.addObj(allocation1);
        fieldpacker.addF32(2.69F);
        fieldpacker.addF32(8.11F);
        fieldpacker.addF32(1.98F);
        fieldpacker.addF32(4.94F);
        invoke(0, fieldpacker);
    }
}
