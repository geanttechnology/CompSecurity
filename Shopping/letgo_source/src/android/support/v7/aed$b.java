// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            aed, abo

private class  extends Handler
{

    final aed a;
    private final a b;

    protected void a(String s)
    {
        b.a(a, s);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            abo.a("Don't know how to handle this message.");
            return;

        case 1: // '\001'
            a((String)message.obj);
            break;
        }
    }
}
