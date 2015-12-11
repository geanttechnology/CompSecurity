// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, PlaybackStateCompat

public final class MediaControllerCompat
{

    private static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final MediaSessionCompat.Token mToken;

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token)
        throws RemoteException
    {
        if (token == null)
        {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        mToken = token;
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
    /* block-local class not found */
    class MediaControllerImplApi21 {}

            mImpl = new MediaControllerImplApi21(context, token);
            return;
        } else
        {
    /* block-local class not found */
    class MediaControllerImplBase {}

            mImpl = new MediaControllerImplBase(mToken);
            return;
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediasessioncompat)
    {
        if (mediasessioncompat == null)
        {
            throw new IllegalArgumentException("session must not be null");
        }
        mToken = mediasessioncompat.getSessionToken();
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
    /* block-local class not found */
    class MediaControllerImplApi23 {}

            mImpl = new MediaControllerImplApi23(context, mediasessioncompat);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            mImpl = new MediaControllerImplApi21(context, mediasessioncompat);
            return;
        } else
        {
            mImpl = new MediaControllerImplBase(mToken);
            return;
        }
    }

    public void adjustVolume(int i, int j)
    {
    /* block-local class not found */
    class MediaControllerImpl {}

        mImpl.adjustVolume(i, j);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyevent)
    {
        if (keyevent == null)
        {
            throw new IllegalArgumentException("KeyEvent may not be null");
        } else
        {
            return mImpl.dispatchMediaButtonEvent(keyevent);
        }
    }

    public Bundle getExtras()
    {
        return mImpl.getExtras();
    }

    public long getFlags()
    {
        return mImpl.getFlags();
    }

    public Object getMediaController()
    {
        return mImpl.getMediaController();
    }

    public MediaMetadataCompat getMetadata()
    {
        return mImpl.getMetadata();
    }

    public String getPackageName()
    {
        return mImpl.getPackageName();
    }

    public PlaybackInfo getPlaybackInfo()
    {
        return mImpl.getPlaybackInfo();
    }

    public PlaybackStateCompat getPlaybackState()
    {
        return mImpl.getPlaybackState();
    }

    public List getQueue()
    {
        return mImpl.getQueue();
    }

    public CharSequence getQueueTitle()
    {
        return mImpl.getQueueTitle();
    }

    public int getRatingType()
    {
        return mImpl.getRatingType();
    }

    public PendingIntent getSessionActivity()
    {
        return mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken()
    {
        return mToken;
    }

    public TransportControls getTransportControls()
    {
        return mImpl.getTransportControls();
    }

    public void registerCallback(Callback callback)
    {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("callback cannot be null");
        }
        Handler handler1 = handler;
        if (handler == null)
        {
            handler1 = new Handler();
        }
        mImpl.registerCallback(callback, handler1);
    }

    public void sendCommand(String s, Bundle bundle, ResultReceiver resultreceiver)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("command cannot be null or empty");
        } else
        {
            mImpl.sendCommand(s, bundle, resultreceiver);
            return;
        }
    }

    public void setVolumeTo(int i, int j)
    {
        mImpl.setVolumeTo(i, j);
    }

    public void unregisterCallback(Callback callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("callback cannot be null");
        } else
        {
            mImpl.unregisterCallback(callback);
            return;
        }
    }

    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$Callback
    /* block-local class not found */
    class Callback {}


    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$PlaybackInfo
    /* block-local class not found */
    class PlaybackInfo {}


    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$TransportControls
    /* block-local class not found */
    class TransportControls {}


    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$TransportControlsApi21
    /* block-local class not found */
    class TransportControlsApi21 {}


    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$TransportControlsApi23
    /* block-local class not found */
    class TransportControlsApi23 {}


    // Unreferenced inner class android/support/v4/media/session/MediaControllerCompat$TransportControlsBase
    /* block-local class not found */
    class TransportControlsBase {}

}
