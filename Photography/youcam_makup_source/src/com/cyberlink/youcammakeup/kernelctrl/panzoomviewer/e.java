// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import com.cyberlink.youcammakeup.kernelctrl.ROI;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            ImageLoader

public class e
{

    public float a;
    public ROI b;
    final ImageLoader c;

    public e(ImageLoader imageloader)
    {
        c = imageloader;
        super();
        a = 0.0F;
        b = null;
    }

    public e(ImageLoader imageloader, e e1)
    {
        Object obj = null;
        c = imageloader;
        super();
        a = 0.0F;
        b = null;
        a = e1.a;
        if (e1.b == null)
        {
            imageloader = obj;
        } else
        {
            imageloader = new ROI(e1.b);
        }
        b = imageloader;
    }
}
