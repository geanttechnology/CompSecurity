// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.socialin.android.util:
//            p, ModernAsyncTask

final class q extends Handler
{

    private q()
    {
    }

    q(byte byte0)
    {
        this();
    }

    public final void handleMessage(Message message)
    {
        p p1 = (p)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            ModernAsyncTask.access$500(p1.a, p1.b[0]);
            return;

        case 2: // '\002'
            p1.a.onProgressUpdate(p1.b);
            break;
        }
    }
}
