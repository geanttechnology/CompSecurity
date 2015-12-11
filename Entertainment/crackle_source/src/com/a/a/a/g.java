// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.a.a.a:
//            f

class g extends Handler
{

    final f a;

    g(f f1)
    {
        a = f1;
        super();
    }

    public void handleMessage(Message message)
    {
        a.a(message);
    }
}
