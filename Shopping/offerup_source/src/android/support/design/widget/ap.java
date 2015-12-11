// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Message;

// Referenced classes of package android.support.design.widget:
//            Snackbar

final class ap
    implements android.os.Handler.Callback
{

    ap()
    {
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            ((Snackbar)message.obj).c();
            return true;

        case 1: // '\001'
            ((Snackbar)message.obj).b(message.arg1);
            break;
        }
        return true;
    }
}
