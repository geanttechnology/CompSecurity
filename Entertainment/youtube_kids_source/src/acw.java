// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

public final class acw extends Handler
{

    private act a;

    public acw(act act1)
    {
        a = act1;
        super();
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 1 && !act.a(a) && act.b(a) == cuv.b)
        {
            act.c(a).a(true);
        }
    }
}
