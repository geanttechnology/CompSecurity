// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ba;

import android.content.Context;
import android.content.res.Resources;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.renderscript.Type;

public final class i extends ScriptC
{

    private Element a;

    public i(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_waterblur", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private i(RenderScript renderscript, Resources resources, int j)
    {
        super(renderscript, resources, j);
        a = Element.U8_4(renderscript);
    }

    public final void a(float f)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(0, f);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int j)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(2, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Allocation allocation, float f)
    {
        FieldPacker fieldpacker = new FieldPacker(8);
        fieldpacker.addObj(allocation);
        fieldpacker.addF32(f);
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

    public final void b(float f)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(1, f);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(int j)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(3, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
