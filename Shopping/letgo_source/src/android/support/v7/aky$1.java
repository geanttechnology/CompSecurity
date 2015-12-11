// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aky, akh, akf, alb, 
//            alj

static final class  extends Handler
{

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 3: default 40
    //                   3: 120
    //                   8: 70
    //                   13: 166;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new AssertionError((new StringBuilder()).append("Unknown handler message received: ").append(message.what).toString());
_L3:
        message = (List)message.obj;
        int k = message.size();
        for (int i = 0; i < k; i++)
        {
            akh akh1 = (akh)message.get(i);
            akh1.b.a(akh1);
        }

        break; /* Loop/switch isn't completed */
_L2:
        message = (akf)message.obj;
        if (message.j().l)
        {
            alj.a("Main", "canceled", ((akf) (message)).b.a(), "target got garbage collected");
        }
        aky.a(((akf) (message)).a, message.d());
_L6:
        return;
_L4:
        message = (List)message.obj;
        int l = message.size();
        int j = 0;
        while (j < l) 
        {
            akf akf1 = (akf)message.get(j);
            akf1.a.c(akf1);
            j++;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (Looper looper)
    {
        super(looper);
    }
}
