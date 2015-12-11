// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.Context;
import com.amazon.avod.sdk.CacheLevel;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.avod.sdk.ResponseHandler;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            IntentConnection, BindingConnection

public interface AivConnection
{
    public static class Factory
    {

        public static AivConnection newConnection(Context context)
        {
            IntentConnection intentconnection = new IntentConnection(context);
            context = new BindingConnection(context, intentconnection);
            if (context.tryConnect())
            {
                return context;
            }
            if (intentconnection.tryConnect())
            {
                return intentconnection;
            } else
            {
                throw new IllegalStateException("Cannot communicate with AIV. Verify the app is installed");
            }
        }

        public Factory()
        {
        }
    }


    public abstract void disconnect();

    public abstract void playVideo(String s, Map map);

    public abstract void queryPlaybackSupport(PlaybackSupportResponse playbacksupportresponse);

    public abstract void teardownPreparedVideo(ResponseHandler responsehandler);

    public abstract boolean tryConnect();

    public abstract void whisperCacheContent(List list, CacheLevel cachelevel);
}
