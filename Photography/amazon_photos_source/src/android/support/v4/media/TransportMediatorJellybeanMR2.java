// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

// Referenced classes of package android.support.v4.media:
//            TransportMediatorCallback

class TransportMediatorJellybeanMR2
    implements android.media.RemoteControlClient.OnGetPlaybackPositionListener, android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
{

    final TransportMediatorCallback mTransportCallback;

    public long onGetPlaybackPosition()
    {
        return mTransportCallback.getPlaybackPosition();
    }

    public void onPlaybackPositionUpdate(long l)
    {
        mTransportCallback.playbackPositionUpdate(l);
    }

    // Unreferenced inner class android/support/v4/media/TransportMediatorJellybeanMR2$3

/* anonymous class */
    class _cls3 extends BroadcastReceiver
    {

        final TransportMediatorJellybeanMR2 this$0;

        public void onReceive(Context context, Intent intent)
        {
            try
            {
                context = (KeyEvent)intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                mTransportCallback.handleKey(context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("TransportController", context);
            }
        }
    }

}
