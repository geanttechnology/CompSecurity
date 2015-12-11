// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package cn.jpush.android.ui:
//            a

final class c extends Handler
{

    private final WeakReference a;

    c(a a1)
    {
        a = new WeakReference(a1);
    }

    public final void handleMessage(Message message)
    {
        a a1 = (a)a.get();
        if (a1 == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR lookupswitch 2: default 44
    //                   0: 45
    //                   4: 50;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        cn.jpush.android.ui.a.b(a1);
        return;
_L4:
        cn.jpush.android.ui.a.c(a1);
        return;
    }
}
