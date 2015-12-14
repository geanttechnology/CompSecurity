// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.socialin.picsin.camera.view:
//            RightToLeftSlidingDrower

final class f extends Handler
{

    private RightToLeftSlidingDrower a;

    private f(RightToLeftSlidingDrower righttoleftslidingdrower)
    {
        a = righttoleftslidingdrower;
        super();
    }

    f(RightToLeftSlidingDrower righttoleftslidingdrower, byte byte0)
    {
        this(righttoleftslidingdrower);
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1000: 
            RightToLeftSlidingDrower.b(a);
            break;
        }
    }
}
