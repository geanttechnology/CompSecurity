// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.view.Surface;

final class cjt extends Handler
{

    private cjs a;

    cjt(cjs cjs1)
    {
        a = cjs1;
        super();
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            cjs.a(a, (Surface)message.obj);
            if (a.b != null)
            {
                a.b.a();
            }
            return;
        } else
        {
            super.handleMessage(message);
            return;
        }
    }
}
