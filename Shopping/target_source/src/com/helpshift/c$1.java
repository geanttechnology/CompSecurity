// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            c, e, f

class  extends Handler
{

    final c a;

    public void handleMessage(Message message)
    {
        e e1 = (e)message.obj;
        message.what;
        JVM INSTR tableswitch -1 5: default 56
    //                   -1 213
    //                   0 56
    //                   1 61
    //                   2 97
    //                   3 128
    //                   4 159
    //                   5 62;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6 _L7
_L1:
        super.handleMessage(message);
_L3:
        return;
_L7:
        if (c.d() == null) goto _L3; else goto _L8
_L8:
        c.d().a(e1.f(), message.arg1, e1.h(), e1.i(), e1.j());
        return;
_L4:
        if (c.d() == null) goto _L3; else goto _L9
_L9:
        c.d().a(message.arg1, e1.h(), e1.i(), e1.j());
        return;
_L5:
        if (c.d() == null) goto _L3; else goto _L10
_L10:
        c.d().b(message.arg1, e1.h(), e1.i(), e1.j());
        return;
_L6:
        c.a(a, e1.h());
        if (c.d() != null)
        {
            c.d().a(e1.g(), message.arg1, e1.h(), e1.i(), e1.j());
        }
        a.a(e1);
        return;
_L2:
        if (c.d() != null)
        {
            c.d().c(message.arg1, e1.h(), e1.i(), e1.j());
        }
        a.a(e1);
        return;
    }

    (c c1, Looper looper)
    {
        a = c1;
        super(looper);
    }
}
