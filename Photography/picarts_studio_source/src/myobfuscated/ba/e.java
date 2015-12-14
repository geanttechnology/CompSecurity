// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ba;

import android.content.Context;
import android.content.res.Resources;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.renderscript.Type;

public final class e extends ScriptC
{

    private Element a;

    public e(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_desaturate", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private e(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
        a = Element.U8_4(renderscript);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        setVar(5, 1.44F);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(0, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
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

    public final void b()
    {
        invoke(0);
    }

    public final void b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(1, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void c(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(2, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void d(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(3, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void e(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setVar(4, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
