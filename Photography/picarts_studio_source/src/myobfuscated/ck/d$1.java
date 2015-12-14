// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package myobfuscated.ck:
//            d

final class init> extends Handler
{

    private d a;

    public final void handleMessage(Message message)
    {
        super.handleMessage(message);
        if (message.arg1 == d.a(a))
        {
            d.b(a);
        }
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
