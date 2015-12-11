// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.h.h;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.helpshift:
//            l

class  extends Handler
{

    final Handler a;
    final l b;

    public void handleMessage(Message message)
    {
        message = (HashMap)message.obj;
        if (message != null)
        {
            message = (JSONArray)message.get("response");
            l.a(b).b();
            l.a(b).a(message);
            message = a.obtainMessage();
            message.obj = l.a(b).a();
            a.sendMessage(message);
            message = new Thread(new Runnable() {

                final l._cls1 a;

                public void run()
                {
                    l.b(a.b);
                    l.y();
                }

            
            {
                a = l._cls1.this;
                super();
            }
            });
            message.setDaemon(true);
            message.start();
        }
        l.x();
    }

    (l l1, Handler handler)
    {
        b = l1;
        a = handler;
        super();
    }
}
