// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o

final class a extends Handler
{

    private o a;

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (message.arg1 == o.a(a))
        {
            o.b(a);
        }
    }

    (o o1)
    {
        a = o1;
        super();
    }
}
