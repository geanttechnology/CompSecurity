// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Message;

// Referenced classes of package android.support.design.widget:
//            e

class a
    implements android.os.ler.Callback
{

    final e a;

    public boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 0: // '\0'
            e.a(a, (a)message.obj);
            break;
        }
        return true;
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
