// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            f

class a extends Handler
{

    final f a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (!f.a(a))
        {
            f.b(a).a(message);
        }
    }

    (f f1, Looper looper)
    {
        a = f1;
        super(looper);
    }
}
