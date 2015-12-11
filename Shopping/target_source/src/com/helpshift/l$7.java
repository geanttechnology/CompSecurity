// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.h.h;
import java.util.ArrayList;

// Referenced classes of package com.helpshift:
//            l

class  extends Handler
{

    final String a;
    final Handler b;
    final l c;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message = (ArrayList)message.obj;
        message = l.a(c).a(a);
        Message message1 = b.obtainMessage();
        message1.obj = message;
        b.sendMessage(message1);
    }

    (l l1, String s, Handler handler)
    {
        c = l1;
        a = s;
        b = handler;
        super();
    }
}
