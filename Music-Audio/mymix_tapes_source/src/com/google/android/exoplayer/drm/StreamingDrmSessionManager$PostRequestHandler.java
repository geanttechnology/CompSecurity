// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager, MediaDrmCallback

private class this._cls0 extends Handler
{

    final StreamingDrmSessionManager this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            throw new RuntimeException();

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_86;

        case 0: // '\0'
            break;
        }
          goto _L1
        Object obj;
        obj;
_L2:
        postResponseHandler.obtainMessage(message.what, obj).sendToTarget();
        return;
_L1:
        obj = callback.executeProvisionRequest(uuid, (android.media.uuid)message.obj);
          goto _L2
        obj = callback.executeKeyRequest(uuid, (android.media.uuid)message.obj);
          goto _L2
    }

    public (Looper looper)
    {
        this$0 = StreamingDrmSessionManager.this;
        super(looper);
    }
}
