// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v4.a:
//            f

private static final class <init> extends Handler
{

    public final void handleMessage(Message message)
    {
        <init> <init>1 = (<init>)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            f.c(<init>1.a, <init>1.b[0]);
            return;

        case 2: // '\002'
            f.c();
            break;
        }
    }

    private ()
    {
    }

    (byte byte0)
    {
        this();
    }
}
