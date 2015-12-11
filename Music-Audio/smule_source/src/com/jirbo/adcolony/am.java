// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ai, ak, ah

class am extends Handler
{

    am()
    {
    }

    public void a(boolean flag, String s, int i)
    {
        if (!flag)
        {
            s = null;
        }
        sendMessage(obtainMessage(i, s));
    }

    public void handleMessage(Message message)
    {
        int i = 0;
        String s = (String)message.obj;
        int j = message.what;
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        message = s;
        if (!flag)
        {
            message = "";
        }
        message = new ai(flag, message, j);
        for (; i < ak.V.size(); i++)
        {
            ((ah)ak.V.get(i)).a(message);
        }

    }
}
