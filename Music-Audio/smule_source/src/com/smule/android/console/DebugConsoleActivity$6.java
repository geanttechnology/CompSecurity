// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import com.smule.android.h;

// Referenced classes of package com.smule.android.console:
//            DebugConsoleActivity, m, r, i, 
//            a, l

class a extends Handler
{

    final DebugConsoleActivity a;

    public void handleMessage(Message message)
    {
        if (message.what == m.a.ordinal())
        {
            a.a((String)message.obj);
        } else
        {
            if (message.what == m.b.ordinal())
            {
                DebugConsoleActivity.d(a);
                return;
            }
            if (message.what == m.c.ordinal())
            {
                r.a(a.getWindowManager().getDefaultDisplay(), a);
                return;
            }
            if (message.what == m.e.ordinal())
            {
                int j = DebugConsoleActivity.b(a).getFontSize();
                a.b((new StringBuilder()).append(com.smule.android.console.a.a(h.current_fontsize)).append(": ").append(l.a(j).name()).append(" (").append(j).append(")").toString());
                return;
            }
            if (message.what == m.d.ordinal())
            {
                DebugConsoleActivity.a(a, ((Integer)message.obj).intValue());
                return;
            }
            if (message.what == m.f.ordinal())
            {
                a.finish();
                return;
            }
        }
    }

    (DebugConsoleActivity debugconsoleactivity)
    {
        a = debugconsoleactivity;
        super();
    }
}
