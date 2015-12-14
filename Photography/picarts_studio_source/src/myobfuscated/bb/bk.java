// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bb;

import android.content.Context;
import android.content.res.Resources;
import android.renderscript.Allocation;
import android.renderscript.FieldPacker;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;

public final class bk extends ScriptC
{

    public bk(RenderScript renderscript)
    {
        this(renderscript, renderscript.getApplicationContext().getResources(), renderscript.getApplicationContext().getResources().getIdentifier("rs_utils_create_integral_image", "raw", renderscript.getApplicationContext().getPackageName()));
    }

    private bk(RenderScript renderscript, Resources resources, int i)
    {
        super(renderscript, resources, i);
    }

    public final void a(Allocation allocation, Allocation allocation1)
    {
        FieldPacker fieldpacker = new FieldPacker(8);
        fieldpacker.addObj(allocation);
        fieldpacker.addObj(allocation1);
        invoke(0, fieldpacker);
    }
}
