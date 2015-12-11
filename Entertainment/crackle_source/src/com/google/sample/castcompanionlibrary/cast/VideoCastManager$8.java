// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.android.gms.cast.CastDevice;
import com.google.sample.castcompanionlibrary.cast.callbacks.IVideoCastConsumer;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

class this._cls0
    implements com.google.android.gms.cast.dCallback
{

    final VideoCastManager this$0;

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        for (castdevice = mVideoConsumers.iterator(); castdevice.hasNext();)
        {
            s = (IVideoCastConsumer)castdevice.next();
            try
            {
                s.onDataMessageReceived(s1);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(VideoCastManager.access$000(), (new StringBuilder()).append("onMessageReceived(): Failed to inform ").append(s).toString(), exception);
            }
        }

    }

    tConsumer()
    {
        this$0 = VideoCastManager.this;
        super();
    }
}
