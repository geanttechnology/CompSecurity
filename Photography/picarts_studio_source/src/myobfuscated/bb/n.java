// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bb;

import android.content.Context;
import android.content.res.Resources;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.renderscript.Type;

public final class n extends ScriptC
{

    private Element a;

    public n(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_effect_24_2", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private n(RenderScript renderscript, Resources resources, int i)
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
}
