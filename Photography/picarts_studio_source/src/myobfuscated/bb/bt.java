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

public final class bt extends ScriptC
{

    private Element a;

    public bt(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_utils_pst_selective_color_relative", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private bt(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.U8_4(renderscript);
    }

    public final void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2)
    {
        FieldPacker fieldpacker = new FieldPacker(144);
        fieldpacker.addI32(i);
        fieldpacker.addI32(j);
        fieldpacker.addI32(k);
        fieldpacker.addI32(0);
        fieldpacker.addI32(l);
        fieldpacker.addI32(i1);
        fieldpacker.addI32(j1);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(k1);
        fieldpacker.addI32(0);
        fieldpacker.addI32(l1);
        fieldpacker.addI32(i2);
        fieldpacker.addI32(j2);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(0);
        fieldpacker.addI32(k2);
        invoke(0, fieldpacker);
    }

    public final void a(Allocation allocation, Allocation allocation1)
    {
        if (!allocation.getType().getElement().isCompatible(a))
        {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        if (!allocation1.getType().getElement().isCompatible(a))
        {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type type = allocation.getType();
        Type type1 = allocation1.getType();
        if (type.getCount() != type1.getCount() || type.getX() != type1.getX() || type.getY() != type1.getY() || type.getZ() != type1.getZ() || type.hasFaces() != type1.hasFaces() || type.hasMipmaps() != type1.hasMipmaps())
        {
            throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
        } else
        {
            forEach(0, allocation, allocation1, null);
            return;
        }
    }
}
