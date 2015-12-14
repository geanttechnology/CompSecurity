// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner

final class l extends Handler
{

    private InMobiBanner a;

    public l(InMobiBanner inmobibanner)
    {
        a = inmobibanner;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            a.load(true);
            break;
        }
    }
}
