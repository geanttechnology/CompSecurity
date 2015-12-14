// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.gpuimage.camera;

import android.content.Context;
import android.util.AttributeSet;
import com.cyberlink.clgpuimage.GPUImage;
import com.cyberlink.clgpuimage.aa;
import com.cyberlink.clgpuimage.ab;
import com.cyberlink.clgpuimage.ae;
import com.cyberlink.clgpuimage.z;

public class GPUImageCameraView extends ae
{

    public GPUImageCameraView(Context context)
    {
        super(context);
    }

    public GPUImageCameraView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public GPUImage getGPUImage()
    {
        return a;
    }

    public void setOnCameraFrameAvailableListener(aa aa)
    {
        a.a(aa);
    }

    public void setRenderFramerateListener(ab ab)
    {
        if (a != null)
        {
            z z1 = a.a();
            if (z1 != null)
            {
                z1.a(ab);
            }
        }
    }
}
