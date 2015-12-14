// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.b;

import android.os.Message;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.v;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.b:
//            b

public class c
    implements android.os.Handler.Callback
{

    final b a;

    protected c(b b1)
    {
        a = b1;
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
    //                   1 103;
           goto _L1 _L2 _L3
_L1:
        m.e("RenderHandlerCallback", (new StringBuilder()).append("cannot handle render command: ").append(message.what).toString());
        v1.b();
        return false;
_L2:
        a.b = 0;
        a.invalidate();
_L5:
        v1.b();
        return true;
_L3:
        a.b = 1;
        a.invalidate();
        if (true) goto _L5; else goto _L4
_L4:
    }
}
