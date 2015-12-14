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

public final class bs extends ScriptC
{

    private Element a;

    public bs(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_utils_pst_photo_filter", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private bs(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.U8_4(renderscript);
    }

    public final void a(float f, float f1, float f2, float f3, float f4, float f5, float f6, 
            float f7, float f8)
    {
        FieldPacker fieldpacker = new FieldPacker(40);
        fieldpacker.addF32(f);
        fieldpacker.addF32(f1);
        fieldpacker.addF32(f2);
        fieldpacker.addF32(f3);
        fieldpacker.addF32(f4);
        fieldpacker.addF32(f5);
        fieldpacker.addF32(f6);
        fieldpacker.addF32(f7);
        fieldpacker.addF32(f8);
        fieldpacker.addBoolean(true);
        fieldpacker.skip(3);
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
