// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.homewall;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.fotoable.homewall:
//            THomewallView

class a extends Handler
{

    final THomewallView a;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 19: // '\023'
            THomewallView.access$100(a);
            break;
        }
    }

    (THomewallView thomewallview)
    {
        a = thomewallview;
        super();
    }
}
