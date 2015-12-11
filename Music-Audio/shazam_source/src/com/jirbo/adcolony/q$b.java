// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            q, p

static final class  extends Handler
{

    public final void handleMessage(Message message)
    {
        String s = (String)message.obj;
        int i = message.what;
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
        new p(flag, message, i);
        for (int j = 0; j < q.V.size(); j++)
        {
            q.V.get(j);
        }

    }

    ()
    {
    }
}
