// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.os.Message;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            c, WigView

class f
    implements android.os.Handler.Callback
{

    final c a;

    private f(c c1)
    {
        a = c1;
        super();
    }

    f(c c1, c._cls1 _pcls1)
    {
        this(c1);
    }

    public boolean handleMessage(Message message)
    {
        WigView wigview;
        wigview = a.n();
        if (wigview == null)
        {
            return false;
        }
        message.what;
        JVM INSTR tableswitch 1 5: default 52
    //                   1 54
    //                   2 67
    //                   3 81
    //                   4 92
    //                   5 99;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return false;
_L2:
        wigview.a((t)message.obj);
_L8:
        return true;
_L3:
        wigview.b((t)message.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        wigview.setVisibility(message.arg1);
        continue; /* Loop/switch isn't completed */
_L5:
        wigview.a();
        continue; /* Loop/switch isn't completed */
_L6:
        wigview.c();
        if (true) goto _L8; else goto _L7
_L7:
    }
}
