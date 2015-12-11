// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package jumiomobile:
//            dm

class dw extends Handler
{

    private final WeakReference a;

    public dw(dm dm1)
    {
        a = new WeakReference(dm1);
    }

    public void handleMessage(Message message)
    {
        dm dm1 = (dm)a.get();
        if (dm1 != null)
        {
            dm.a(dm1, message);
        }
    }
}
