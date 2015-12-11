// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class arh extends Handler
{

    private arc a;

    public arh(arc arc1, Looper looper)
    {
        a = arc1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            throw new RuntimeException();

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_89;

        case 0: // '\0'
            break;
        }
          goto _L1
        Object obj;
        obj;
_L2:
        a.e.obtainMessage(message.what, obj).sendToTarget();
        return;
_L1:
        obj = a.d;
        java.util.UUID uuid = a.f;
        obj = ((arb) (obj)).a((android.media.MediaDrm.ProvisionRequest)message.obj);
          goto _L2
        obj = a.d;
        java.util.UUID uuid1 = a.f;
        obj = ((arb) (obj)).a((android.media.MediaDrm.KeyRequest)message.obj);
          goto _L2
    }
}
