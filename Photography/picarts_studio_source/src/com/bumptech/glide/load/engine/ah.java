// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Message;

// Referenced classes of package com.bumptech.glide.load.engine:
//            ad

final class ah
    implements android.os.Handler.Callback
{

    private ah()
    {
    }

    ah(byte byte0)
    {
        this();
    }

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            ((ad)message.obj).d();
            return true;
        } else
        {
            return false;
        }
    }
}
