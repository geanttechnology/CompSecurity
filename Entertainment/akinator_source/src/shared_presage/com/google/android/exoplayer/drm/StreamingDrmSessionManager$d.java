// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package shared_presage.com.google.android.exoplayer.drm:
//            StreamingDrmSessionManager

private final class a extends Handler
{

    final StreamingDrmSessionManager a;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            StreamingDrmSessionManager.access$700(a, message.obj);
            return;

        case 1: // '\001'
            StreamingDrmSessionManager.access$800(a, message.obj);
            break;
        }
    }

    public (StreamingDrmSessionManager streamingdrmsessionmanager, Looper looper)
    {
        a = streamingdrmsessionmanager;
        super(looper);
    }
}
