// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package shared_presage.com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager, KeysExpiredException

private final class a extends Handler
{

    final StreamingDrmSessionManager a;

    public final void handleMessage(Message message)
    {
        if (StreamingDrmSessionManager.access$200(a) == 0 || StreamingDrmSessionManager.access$300(a) != 3 && StreamingDrmSessionManager.access$300(a) != 4)
        {
            return;
        }
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            StreamingDrmSessionManager.access$302(a, 3);
            StreamingDrmSessionManager.access$600(a);
            return;

        case 2: // '\002'
            StreamingDrmSessionManager.access$400(a);
            return;

        case 3: // '\003'
            StreamingDrmSessionManager.access$302(a, 3);
            break;
        }
        StreamingDrmSessionManager.access$500(a, new KeysExpiredException());
    }

    public (StreamingDrmSessionManager streamingdrmsessionmanager, Looper looper)
    {
        a = streamingdrmsessionmanager;
        super(looper);
    }
}
