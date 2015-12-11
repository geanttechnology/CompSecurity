// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            adc

class a
    implements android.os.r.Callback
{

    final adc a;

    public boolean handleMessage(Message message)
    {
        if (1 == message.what && adc.e().equals(message.obj))
        {
            a.a();
            if (adc.b(a) > 0 && !adc.c(a))
            {
                adc.d(a).sendMessageDelayed(adc.d(a).obtainMessage(1, adc.e()), adc.b(a));
            }
        }
        return true;
    }

    ck(adc adc1)
    {
        a = adc1;
        super();
    }
}
