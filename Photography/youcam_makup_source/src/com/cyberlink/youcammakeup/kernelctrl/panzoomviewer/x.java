// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.os.Message;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            v, ImageViewer, q

public class x
    implements android.os.Handler.Callback
{

    final ImageViewer a;

    protected x(ImageViewer imageviewer)
    {
        a = imageviewer;
        super();
    }

    public boolean handleMessage(Message message)
    {
        v v1;
        if (!(message.obj instanceof v))
        {
            return false;
        }
        v1 = (v)message.obj;
        message.what;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 82
    //                   1 110;
           goto _L1 _L2 _L3
_L1:
        m.e("RenderHandlerCallback", (new StringBuilder()).append("cannot handle render command: ").append(message.what).toString());
        v1.b();
        return false;
_L2:
        a.c();
        a.J = 0;
        a.invalidate();
_L5:
        v1.b();
        return true;
_L3:
        a.H = (ImageLoader.BufferName)v1.get(1);
        a.I = (q)v1.get(2);
        a.invalidate();
        if (true) goto _L5; else goto _L4
_L4:
    }
}
