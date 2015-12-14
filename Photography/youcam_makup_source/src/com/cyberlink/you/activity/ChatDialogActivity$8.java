// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.SystemClock;
import android.widget.ListView;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.utility.o;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity, e

class c
    implements Runnable
{

    final boolean a;
    final MessageObj b;
    final String c;
    final ChatDialogActivity d;

    public void run()
    {
        Object obj = ChatDialogActivity.p(d);
        obj;
        JVM INSTR monitorenter ;
        if (ChatDialogActivity.a(d) == null) goto _L2; else goto _L1
_L1:
        if (a) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        i = (ChatDialogActivity.a(d).getCount() - 1) + ChatDialogActivity.c(d).getHeaderViewsCount();
        j = ChatDialogActivity.c(d).getLastVisiblePosition();
        if (i != j) goto _L6; else goto _L5
_L5:
        ChatDialogActivity.b(d, false);
_L8:
        if (ChatDialogActivity.q(d) == null)
        {
            ChatDialogActivity.a(d, new o());
            ChatDialogActivity.q(d).a(5);
        }
        if (!ChatDialogActivity.r(d) && SystemClock.uptimeMillis() - ChatDialogActivity.s(d) > 2000L && ChatDialogActivity.q(d).a(ChatDialogActivity.t(d), false))
        {
            ChatDialogActivity.a(d, SystemClock.uptimeMillis());
        }
_L4:
        ChatDialogActivity.a(d).d(b);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (i <= j) goto _L8; else goto _L7
_L7:
        ChatDialogActivity.a(d, b, c);
          goto _L8
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (ChatDialogActivity chatdialogactivity, boolean flag, MessageObj messageobj, String s)
    {
        d = chatdialogactivity;
        a = flag;
        b = messageobj;
        c = s;
        super();
    }
}
