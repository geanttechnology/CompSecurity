// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.b;

import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.clgpuimage.IBeautyFilter2;
import com.cyberlink.clgpuimage.u;
import com.cyberlink.clgpuimage.v;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.gpuimage.GPUImagePanZoomFilter;
import com.pf.common.utility.m;

public class d
{

    private String a;
    private final u b = new u();
    private v c;
    private DevelopSetting d;
    private IBeautyFilter2 e;
    private DevelopSetting f;
    private v g;
    private u h;
    private GPUImagePanZoomFilter i;

    public d()
    {
        a = "GPUImageFilterBuilder";
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        m.c(a, (new StringBuilder()).append("GPUImageFilterBuilder has been created, ").append(this).toString());
    }

    public CLMakeupLiveFilter a()
    {
        return new CLMakeupLiveFilter(false, false, false, false, false);
    }
}
