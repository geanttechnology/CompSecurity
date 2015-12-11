// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;

import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;

public class ScriptC_Filters
{

    private Allocation _output;

    public ScriptC_Filters(RenderScript renderscript)
    {
    }

    public void forEach_RGB888YUV444(Allocation allocation)
    {
    }

    public void forEach_YUV444ToYUV420(Allocation allocation)
    {
    }

    public void forEach_YUV444ToYUV420SemiPlanar(Allocation allocation)
    {
    }

    public void forEach_YUVPackedToPlanar(Allocation allocation, Allocation allocation1)
    {
    }

    public Allocation get_output()
    {
        return _output;
    }

    public void set_input(Allocation allocation)
    {
    }

    public void set_output(Allocation allocation)
    {
        _output = allocation;
    }

    public void set_output1(Allocation allocation)
    {
    }

    public void set_output2(Allocation allocation)
    {
    }
}
