// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import android.os.Message;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview:
//            AccessoryDrawingCtrl, AccessoryView

class b
    implements android.os.Handler.Callback
{

    private b()
    {
    }

    b(AccessoryDrawingCtrl._cls1 _pcls1)
    {
        this();
    }

    public boolean handleMessage(Message message)
    {
        AccessoryView accessoryview;
        accessoryview = AccessoryDrawingCtrl.m();
        if (accessoryview == null)
        {
            return false;
        }
        message.what;
        JVM INSTR tableswitch 1 6: default 52
    //                   1 54
    //                   2 67
    //                   3 81
    //                   4 92
    //                   5 99
    //                   6 106;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return false;
_L2:
        accessoryview.a((t)message.obj);
_L9:
        return true;
_L3:
        accessoryview.b((t)message.obj);
        continue; /* Loop/switch isn't completed */
_L4:
        accessoryview.setVisibility(message.arg1);
        continue; /* Loop/switch isn't completed */
_L5:
        accessoryview.b();
        continue; /* Loop/switch isn't completed */
_L6:
        accessoryview.d();
        continue; /* Loop/switch isn't completed */
_L7:
        accessoryview.a();
        if (true) goto _L9; else goto _L8
_L8:
    }
}
