// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Message;

// Referenced classes of package android.support.design.widget:
//            bd, ba

final class bb
    implements android.os.Handler.Callback
{

    private ba a;

    bb(ba ba1)
    {
        a = ba1;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            ba.a(a, (bd)message.obj);
            break;
        }
        return true;
    }
}
