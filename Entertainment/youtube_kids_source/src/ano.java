// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

final class ano extends Handler
{

    private anl a;

    ano(anl anl1)
    {
        a = anl1;
        super();
    }

    public final void handleMessage(Message message)
    {
        a.a(message);
    }
}
