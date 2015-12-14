// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

public class cff extends Handler
{

    private cfg a;
    private cfg b;
    private cfg c;
    private cfg d;

    public cff()
    {
    }

    public void a(cfg cfg1)
    {
        a = cfg1;
    }

    public void handleMessage(Message message)
    {
        cfg cfg1;
        int i;
        i = message.what;
        cfg1 = null;
        i;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 61
    //                   1 53
    //                   2 77
    //                   3 69;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (cfg1 != null)
        {
            cfg1.a(message.obj);
        }
        return;
_L3:
        cfg1 = d;
        continue; /* Loop/switch isn't completed */
_L2:
        cfg1 = c;
        continue; /* Loop/switch isn't completed */
_L5:
        cfg1 = b;
        continue; /* Loop/switch isn't completed */
_L4:
        cfg1 = a;
        if (true) goto _L1; else goto _L6
_L6:
    }
}
