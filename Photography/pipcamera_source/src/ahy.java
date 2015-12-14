// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

public class ahy extends Handler
{

    private ahz a;
    private ahz b;
    private ahz c;
    private ahz d;

    public ahy()
    {
    }

    public void a(ahz ahz1)
    {
        a = ahz1;
    }

    public void handleMessage(Message message)
    {
        ahz ahz1;
        int i;
        i = message.what;
        ahz1 = null;
        i;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 61
    //                   1 53
    //                   2 77
    //                   3 69;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (ahz1 != null)
        {
            ahz1.a(message.obj);
        }
        return;
_L3:
        ahz1 = d;
        continue; /* Loop/switch isn't completed */
_L2:
        ahz1 = c;
        continue; /* Loop/switch isn't completed */
_L5:
        ahz1 = b;
        continue; /* Loop/switch isn't completed */
_L4:
        ahz1 = a;
        if (true) goto _L1; else goto _L6
_L6:
    }
}
