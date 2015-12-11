// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.d;

import android.os.Handler;
import android.os.Message;
import com.target.mothership.model.d;

// Referenced classes of package com.target.ui.d:
//            a, c

static class mReceiver extends Handler
{

    private d mReceiver;

    public void handleMessage(Message message)
    {
        mReceiver.b(new c());
    }

    public p.model.d(d d1)
    {
        mReceiver = d1;
    }
}
