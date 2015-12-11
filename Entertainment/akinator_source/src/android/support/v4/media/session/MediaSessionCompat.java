// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v4.media.session:
//            MediaControllerCompat, PlaybackStateCompat, MediaSessionCompatApi23, MediaSessionCompatApi21, 
//            MediaSessionCompatApi22, MediaSessionCompatApi14, IMediaControllerCallback, MediaSessionCompatApi18, 
//            MediaSessionCompatApi8, MediaSessionCompatApi19, ParcelableVolumeInfo

public class MediaSessionCompat
{
    public static abstract class Callback
    {

        final Object mCallbackObj;

        public void onCommand(String s, Bundle bundle, ResultReceiver resultreceiver)
        {
        }

        public void onCustomAction(String s, Bundle bundle)
        {
        }

        public void onFastForward()
        {
        }

        public boolean onMediaButtonEvent(Intent intent)
        {
            return false;
        }

        public void onPause()
        {
        }

        public void onPlay()
        {
        }

        public void onPlayFromMediaId(String s, Bundle bundle)
        {
        }

        public void onPlayFromSearch(String s, Bundle bundle)
        {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle)
        {
        }

        public void onRewind()
        {
        }

        public void onSeekTo(long l)
        {
        }

        public void onSetRating(RatingCompat ratingcompat)
        {
        }

        public void onSkipToNext()
        {
        }

        public void onSkipToPrevious()
        {
        }

        public void onSkipToQueueItem(long l)
        {
        }

        public void onStop()
        {
        }

        public Callback()
        {
            if (android.os.Build.VERSION.SDK_INT >= 23)
            {
                mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23());
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21());
                return;
            } else
            {
                mCallbackObj = null;
                return;
            }
        }
    }

    static interface MediaSessionImpl
    {

        public abstract Object getMediaSession();

        public abstract Object getRemoteControlClient();

        public abstract Token getSessionToken();

        public abstract boolean isActive();

        public abstract void release();

        public abstract void sendSessionEvent(String s, Bundle bundle);

        public abstract void setActive(boolean flag);

        public abstract void setCallback(Callback callback, Handler handler);

        public abstract void setExtras(Bundle bundle);

        public abstract void setFlags(int i);

        public abstract void setMediaButtonReceiver(PendingIntent pendingintent);

        public abstract void setMetadata(MediaMetadataCompat mediametadatacompat);

        public abstract void setPlaybackState(PlaybackStateCompat playbackstatecompat);

        public abstract void setPlaybackToLocal(int i);

        public abstract void setPlaybackToRemote(VolumeProviderCompat volumeprovidercompat);

        public abstract void setQueue(List list);

        public abstract void setQueueTitle(CharSequence charsequence);

        public abstract void setRatingType(int i);

        public abstract void setSessionActivity(PendingIntent pendingintent);
    }

    static class MediaSessionImplApi21
        implements MediaSessionImpl
    {

        private PendingIntent mMediaButtonIntent;
        private final Object mSessionObj;
        private final Token mToken;

        public Object getMediaSession()
        {
            return mSessionObj;
        }

        public Object getRemoteControlClient()
        {
            return null;
        }

        public Token getSessionToken()
        {
            return mToken;
        }

        public boolean isActive()
        {
            return MediaSessionCompatApi21.isActive(mSessionObj);
        }

        public void release()
        {
            MediaSessionCompatApi21.release(mSessionObj);
        }

        public void sendSessionEvent(String s, Bundle bundle)
        {
            MediaSessionCompatApi21.sendSessionEvent(mSessionObj, s, bundle);
        }

        public void setActive(boolean flag)
        {
            MediaSessionCompatApi21.setActive(mSessionObj, flag);
        }

        public void setCallback(Callback callback, Handler handler)
        {
            Object obj = mSessionObj;
            if (callback == null)
            {
                callback = null;
            } else
            {
                callback = ((Callback) (callback.mCallbackObj));
            }
            MediaSessionCompatApi21.setCallback(obj, callback, handler);
        }

        public void setExtras(Bundle bundle)
        {
            MediaSessionCompatApi21.setExtras(mSessionObj, bundle);
        }

        public void setFlags(int i)
        {
            MediaSessionCompatApi21.setFlags(mSessionObj, i);
        }

        public void setMediaButtonReceiver(PendingIntent pendingintent)
        {
            mMediaButtonIntent = pendingintent;
            MediaSessionCompatApi21.setMediaButtonReceiver(mSessionObj, pendingintent);
        }

        public void setMetadata(MediaMetadataCompat mediametadatacompat)
        {
            Object obj = mSessionObj;
            if (mediametadatacompat == null)
            {
                mediametadatacompat = null;
            } else
            {
                mediametadatacompat = ((MediaMetadataCompat) (mediametadatacompat.getMediaMetadata()));
            }
            MediaSessionCompatApi21.setMetadata(obj, mediametadatacompat);
        }

        public void setPlaybackState(PlaybackStateCompat playbackstatecompat)
        {
            Object obj = mSessionObj;
            if (playbackstatecompat == null)
            {
                playbackstatecompat = null;
            } else
            {
                playbackstatecompat = ((PlaybackStateCompat) (playbackstatecompat.getPlaybackState()));
            }
            MediaSessionCompatApi21.setPlaybackState(obj, playbackstatecompat);
        }

        public void setPlaybackToLocal(int i)
        {
            MediaSessionCompatApi21.setPlaybackToLocal(mSessionObj, i);
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeprovidercompat)
        {
            MediaSessionCompatApi21.setPlaybackToRemote(mSessionObj, volumeprovidercompat.getVolumeProvider());
        }

        public void setQueue(List list)
        {
            ArrayList arraylist = null;
            if (list != null)
            {
                ArrayList arraylist1 = new ArrayList();
                list = list.iterator();
                do
                {
                    arraylist = arraylist1;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    arraylist1.add(((QueueItem)list.next()).getQueueItem());
                } while (true);
            }
            MediaSessionCompatApi21.setQueue(mSessionObj, arraylist);
        }

        public void setQueueTitle(CharSequence charsequence)
        {
            MediaSessionCompatApi21.setQueueTitle(mSessionObj, charsequence);
        }

        public void setRatingType(int i)
        {
            if (android.os.Build.VERSION.SDK_INT < 22)
            {
                return;
            } else
            {
                MediaSessionCompatApi22.setRatingType(mSessionObj, i);
                return;
            }
        }

        public void setSessionActivity(PendingIntent pendingintent)
        {
            MediaSessionCompatApi21.setSessionActivity(mSessionObj, pendingintent);
        }

        public MediaSessionImplApi21(Context context, String s)
        {
            mSessionObj = MediaSessionCompatApi21.createSession(context, s);
            mToken = new Token(MediaSessionCompatApi21.getSessionToken(mSessionObj));
        }

        public MediaSessionImplApi21(Object obj)
        {
            mSessionObj = MediaSessionCompatApi21.verifySession(obj);
            mToken = new Token(MediaSessionCompatApi21.getSessionToken(mSessionObj));
        }
    }

    static class MediaSessionImplBase
        implements MediaSessionImpl
    {

        private final AudioManager mAudioManager;
        private Callback mCallback;
        private final ComponentName mComponentName;
        private final Context mContext;
        private final RemoteCallbackList mControllerCallbacks = new RemoteCallbackList();
        private boolean mDestroyed;
        private Bundle mExtras;
        private int mFlags;
        private final MessageHandler mHandler = new MessageHandler(Looper.myLooper());
        private boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        private int mLocalStream;
        private final Object mLock = new Object();
        private final PendingIntent mMediaButtonEventReceiver;
        private MediaMetadataCompat mMetadata;
        private final String mPackageName;
        private List mQueue;
        private CharSequence mQueueTitle;
        private int mRatingType;
        private final Object mRccObj;
        private PendingIntent mSessionActivity;
        private PlaybackStateCompat mState;
        private final MediaSessionStub mStub = new MediaSessionStub();
        private final String mTag;
        private final Token mToken;
        private android.support.v4.media.VolumeProviderCompat.Callback mVolumeCallback;
        private VolumeProviderCompat mVolumeProvider;
        private int mVolumeType;

        private void adjustVolume(int i, int j)
        {
            if (mVolumeType == 2)
            {
                if (mVolumeProvider != null)
                {
                    mVolumeProvider.onAdjustVolume(i);
                }
                return;
            } else
            {
                mAudioManager.adjustStreamVolume(mLocalStream, i, j);
                return;
            }
        }

        private PlaybackStateCompat getStateWithUpdatedPosition()
        {
            long l1 = -1L;
            Object obj = mLock;
            obj;
            JVM INSTR monitorenter ;
            PlaybackStateCompat playbackstatecompat = mState;
            long l = l1;
            if (mMetadata == null)
            {
                break MISSING_BLOCK_LABEL_55;
            }
            l = l1;
            if (mMetadata.containsKey("android.media.metadata.DURATION"))
            {
                l = mMetadata.getLong("android.media.metadata.DURATION");
            }
            obj;
            JVM INSTR monitorexit ;
            Object obj1;
            obj1 = null;
            obj = obj1;
            if (playbackstatecompat == null) goto _L2; else goto _L1
_L1:
            if (playbackstatecompat.getState() == 3 || playbackstatecompat.getState() == 4) goto _L4; else goto _L3
_L3:
            obj = obj1;
            if (playbackstatecompat.getState() != 5) goto _L2; else goto _L4
_L4:
            long l2;
            l1 = playbackstatecompat.getLastPositionUpdateTime();
            l2 = SystemClock.elapsedRealtime();
            obj = obj1;
            if (l1 <= 0L) goto _L2; else goto _L5
_L5:
            l1 = (long)(playbackstatecompat.getPlaybackSpeed() * (float)(l2 - l1)) + playbackstatecompat.getPosition();
            if (l < 0L || l1 <= l) goto _L7; else goto _L6
_L6:
            obj = new PlaybackStateCompat.Builder(playbackstatecompat);
            ((PlaybackStateCompat.Builder) (obj)).setState(playbackstatecompat.getState(), l, playbackstatecompat.getPlaybackSpeed(), l2);
            obj = ((PlaybackStateCompat.Builder) (obj)).build();
_L2:
            Exception exception;
            if (obj == null)
            {
                return playbackstatecompat;
            } else
            {
                return ((PlaybackStateCompat) (obj));
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
_L7:
            l = l1;
            if (l1 < 0L)
            {
                l = 0L;
            }
            if (true) goto _L6; else goto _L8
_L8:
        }

        private void sendEvent(String s, Bundle bundle)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onEvent(s, bundle);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat mediametadatacompat)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onMetadataChanged(mediametadatacompat);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List list)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onQueueChanged(list);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence charsequence)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onQueueTitleChanged(charsequence);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed()
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onSessionDestroyed();
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
            mControllerCallbacks.kill();
        }

        private void sendState(PlaybackStateCompat playbackstatecompat)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onPlaybackStateChanged(playbackstatecompat);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void sendVolumeInfoChanged(ParcelableVolumeInfo parcelablevolumeinfo)
        {
            int i = mControllerCallbacks.beginBroadcast() - 1;
            while (i >= 0) 
            {
                IMediaControllerCallback imediacontrollercallback = (IMediaControllerCallback)mControllerCallbacks.getBroadcastItem(i);
                try
                {
                    imediacontrollercallback.onVolumeInfoChanged(parcelablevolumeinfo);
                }
                catch (RemoteException remoteexception) { }
                i--;
            }
            mControllerCallbacks.finishBroadcast();
        }

        private void setVolumeTo(int i, int j)
        {
            if (mVolumeType == 2)
            {
                if (mVolumeProvider != null)
                {
                    mVolumeProvider.onSetVolumeTo(i);
                }
                return;
            } else
            {
                mAudioManager.setStreamVolume(mLocalStream, i, j);
                return;
            }
        }

        private boolean update()
        {
            boolean flag1 = false;
            if (!mIsActive) goto _L2; else goto _L1
_L1:
            if (android.os.Build.VERSION.SDK_INT < 8) goto _L4; else goto _L3
_L3:
            if (mIsMbrRegistered || (mFlags & 1) == 0) goto _L6; else goto _L5
_L5:
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                MediaSessionCompatApi18.registerMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
            } else
            {
                MediaSessionCompatApi8.registerMediaButtonEventReceiver(mContext, mComponentName);
            }
            mIsMbrRegistered = true;
_L4:
            flag = flag1;
            if (android.os.Build.VERSION.SDK_INT < 14) goto _L8; else goto _L7
_L7:
            if (mIsRccRegistered || (mFlags & 2) == 0) goto _L10; else goto _L9
_L9:
            MediaSessionCompatApi14.registerRemoteControlClient(mContext, mRccObj);
            mIsRccRegistered = true;
            flag = true;
_L8:
            return flag;
_L6:
            if (mIsMbrRegistered && (mFlags & 1) == 0)
            {
                if (android.os.Build.VERSION.SDK_INT >= 18)
                {
                    MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
                } else
                {
                    MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
                }
                mIsMbrRegistered = false;
            }
            continue; /* Loop/switch isn't completed */
_L10:
            flag = flag1;
            if (!mIsRccRegistered) goto _L8; else goto _L11
_L11:
            flag = flag1;
            if ((mFlags & 2) != 0) goto _L8; else goto _L12
_L12:
            MediaSessionCompatApi14.setState(mRccObj, 0);
            MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
            mIsRccRegistered = false;
            return false;
_L2:
            if (mIsMbrRegistered)
            {
                if (android.os.Build.VERSION.SDK_INT >= 18)
                {
                    MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(mContext, mMediaButtonEventReceiver, mComponentName);
                } else
                {
                    MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(mContext, mComponentName);
                }
                mIsMbrRegistered = false;
            }
            flag = flag1;
            if (!mIsRccRegistered) goto _L8; else goto _L13
_L13:
            MediaSessionCompatApi14.setState(mRccObj, 0);
            MediaSessionCompatApi14.unregisterRemoteControlClient(mContext, mRccObj);
            mIsRccRegistered = false;
            return false;
            if (true) goto _L4; else goto _L14
_L14:
        }

        public Object getMediaSession()
        {
            return null;
        }

        public Object getRemoteControlClient()
        {
            return mRccObj;
        }

        public Token getSessionToken()
        {
            return mToken;
        }

        public boolean isActive()
        {
            return mIsActive;
        }

        public void release()
        {
            mIsActive = false;
            mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        public void sendSessionEvent(String s, Bundle bundle)
        {
            sendEvent(s, bundle);
        }

        public void setActive(boolean flag)
        {
            if (flag != mIsActive)
            {
                mIsActive = flag;
                if (update())
                {
                    setMetadata(mMetadata);
                    setPlaybackState(mState);
                    return;
                }
            }
        }

        public void setCallback(Callback callback, Handler handler)
        {
            if (callback == mCallback)
            {
                return;
            }
            if (callback != null && android.os.Build.VERSION.SDK_INT >= 18) goto _L2; else goto _L1
_L1:
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, null);
            }
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, null);
            }
_L4:
            mCallback = callback;
            return;
_L2:
            if (handler == null)
            {
                new Handler();
            }
        /* block-local class not found */
        class _cls2 {}

            handler = new _cls2(callback);
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                Object obj = MediaSessionCompatApi18.createPlaybackPositionUpdateListener(handler);
                MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(mRccObj, obj);
            }
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                handler = ((Handler) (MediaSessionCompatApi19.createMetadataUpdateListener(handler)));
                MediaSessionCompatApi19.setOnMetadataUpdateListener(mRccObj, handler);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void setExtras(Bundle bundle)
        {
            mExtras = bundle;
        }

        public void setFlags(int i)
        {
            synchronized (mLock)
            {
                mFlags = i;
            }
            update();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void setMediaButtonReceiver(PendingIntent pendingintent)
        {
        }

        public void setMetadata(MediaMetadataCompat mediametadatacompat)
        {
            Object obj2 = null;
            Object obj = null;
            synchronized (mLock)
            {
                mMetadata = mediametadatacompat;
            }
            sendMetadata(mediametadatacompat);
            if (mIsActive)
            {
                if (android.os.Build.VERSION.SDK_INT >= 19)
                {
                    obj2 = mRccObj;
                    long l;
                    if (mediametadatacompat == null)
                    {
                        mediametadatacompat = obj;
                    } else
                    {
                        mediametadatacompat = mediametadatacompat.getBundle();
                    }
                    if (mState == null)
                    {
                        l = 0L;
                    } else
                    {
                        l = mState.getActions();
                    }
                    MediaSessionCompatApi19.setMetadata(obj2, mediametadatacompat, l);
                    return;
                }
                if (android.os.Build.VERSION.SDK_INT >= 14)
                {
                    Object obj1 = mRccObj;
                    if (mediametadatacompat == null)
                    {
                        mediametadatacompat = ((MediaMetadataCompat) (obj2));
                    } else
                    {
                        mediametadatacompat = mediametadatacompat.getBundle();
                    }
                    MediaSessionCompatApi14.setMetadata(obj1, mediametadatacompat);
                    return;
                }
            }
            return;
            mediametadatacompat;
            obj3;
            JVM INSTR monitorexit ;
            throw mediametadatacompat;
        }

        public void setPlaybackState(PlaybackStateCompat playbackstatecompat)
        {
            synchronized (mLock)
            {
                mState = playbackstatecompat;
            }
            sendState(playbackstatecompat);
            if (mIsActive) goto _L2; else goto _L1
_L1:
            return;
            playbackstatecompat;
            obj;
            JVM INSTR monitorexit ;
            throw playbackstatecompat;
_L2:
            if (playbackstatecompat != null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                MediaSessionCompatApi14.setState(mRccObj, 0);
                MediaSessionCompatApi14.setTransportControlFlags(mRccObj, 0L);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            if (android.os.Build.VERSION.SDK_INT < 18) goto _L5; else goto _L4
_L4:
            MediaSessionCompatApi18.setState(mRccObj, playbackstatecompat.getState(), playbackstatecompat.getPosition(), playbackstatecompat.getPlaybackSpeed(), playbackstatecompat.getLastPositionUpdateTime());
_L7:
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                MediaSessionCompatApi19.setTransportControlFlags(mRccObj, playbackstatecompat.getActions());
                return;
            }
            break; /* Loop/switch isn't completed */
_L5:
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                MediaSessionCompatApi14.setState(mRccObj, playbackstatecompat.getState());
            }
            if (true) goto _L7; else goto _L6
_L6:
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                MediaSessionCompatApi18.setTransportControlFlags(mRccObj, playbackstatecompat.getActions());
                return;
            }
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                MediaSessionCompatApi14.setTransportControlFlags(mRccObj, playbackstatecompat.getActions());
                return;
            }
            if (true) goto _L1; else goto _L8
_L8:
        }

        public void setPlaybackToLocal(int i)
        {
            if (mVolumeProvider != null)
            {
                mVolumeProvider.setCallback(null);
            }
            mVolumeType = 1;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, 2, mAudioManager.getStreamMaxVolume(mLocalStream), mAudioManager.getStreamVolume(mLocalStream)));
        }

        public void setPlaybackToRemote(VolumeProviderCompat volumeprovidercompat)
        {
            if (volumeprovidercompat == null)
            {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (mVolumeProvider != null)
            {
                mVolumeProvider.setCallback(null);
            }
            mVolumeType = 2;
            mVolumeProvider = volumeprovidercompat;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(mVolumeType, mLocalStream, mVolumeProvider.getVolumeControl(), mVolumeProvider.getMaxVolume(), mVolumeProvider.getCurrentVolume()));
            volumeprovidercompat.setCallback(mVolumeCallback);
        }

        public void setQueue(List list)
        {
            mQueue = list;
            sendQueue(list);
        }

        public void setQueueTitle(CharSequence charsequence)
        {
            mQueueTitle = charsequence;
            sendQueueTitle(charsequence);
        }

        public void setRatingType(int i)
        {
            mRatingType = i;
        }

        public void setSessionActivity(PendingIntent pendingintent)
        {
            synchronized (mLock)
            {
                mSessionActivity = pendingintent;
            }
            return;
            pendingintent;
            obj;
            JVM INSTR monitorexit ;
            throw pendingintent;
        }
























        public MediaSessionImplBase(Context context, String s, ComponentName componentname, PendingIntent pendingintent)
        {
            mDestroyed = false;
            mIsActive = false;
            mIsRccRegistered = false;
            mIsMbrRegistered = false;
        /* block-local class not found */
        class _cls1 {}

            mVolumeCallback = new _cls1();
            if (componentname == null)
            {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            mContext = context;
            mPackageName = context.getPackageName();
            mAudioManager = (AudioManager)context.getSystemService("audio");
            mTag = s;
            mComponentName = componentname;
            mMediaButtonEventReceiver = pendingintent;
            mToken = new Token(mStub);
            mRatingType = 0;
            mVolumeType = 1;
            mLocalStream = 3;
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                mRccObj = MediaSessionCompatApi14.createRemoteControlClient(pendingintent);
                return;
            } else
            {
                mRccObj = null;
                return;
            }
        }
    }

    public static interface OnActiveChangeListener
    {

        public abstract void onActiveChanged();
    }

    public static final class QueueItem
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        public static QueueItem obtain(Object obj)
        {
            return new QueueItem(obj, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(obj)), MediaSessionCompatApi21.QueueItem.getQueueId(obj));
        }

        public int describeContents()
        {
            return 0;
        }

        public MediaDescriptionCompat getDescription()
        {
            return mDescription;
        }

        public long getQueueId()
        {
            return mId;
        }

        public Object getQueueItem()
        {
            if (mItem != null || android.os.Build.VERSION.SDK_INT < 21)
            {
                return mItem;
            } else
            {
                mItem = MediaSessionCompatApi21.QueueItem.createItem(mDescription.getMediaDescription(), mId);
                return mItem;
            }
        }

        public String toString()
        {
            return (new StringBuilder()).append("MediaSession.QueueItem {Description=").append(mDescription).append(", Id=").append(mId).append(" }").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            mDescription.writeToParcel(parcel, i);
            parcel.writeLong(mId);
        }


        private QueueItem(Parcel parcel)
        {
            mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            mId = parcel.readLong();
        }


        public QueueItem(MediaDescriptionCompat mediadescriptioncompat, long l)
        {
            this(null, mediadescriptioncompat, l);
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediadescriptioncompat, long l)
        {
            if (mediadescriptioncompat == null)
            {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (l == -1L)
            {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else
            {
                mDescription = mediadescriptioncompat;
                mId = l;
                mItem = obj;
                return;
            }
        }

        /* block-local class not found */
        class _cls1 {}

    }

    static final class ResultReceiverWrapper
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private ResultReceiver mResultReceiver;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            mResultReceiver.writeToParcel(parcel, i);
        }



        ResultReceiverWrapper(Parcel parcel)
        {
            mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(ResultReceiver resultreceiver)
        {
            mResultReceiver = resultreceiver;
        }

        /* block-local class not found */
        class _cls1 {}

    }

    public static interface SessionFlags
        extends Annotation
    {
    }

    public static final class Token
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private final Object mInner;

        public static Token fromToken(Object obj)
        {
            if (obj == null || android.os.Build.VERSION.SDK_INT < 21)
            {
                return null;
            } else
            {
                return new Token(MediaSessionCompatApi21.verifyToken(obj));
            }
        }

        public int describeContents()
        {
            return 0;
        }

        public Object getToken()
        {
            return mInner;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                parcel.writeParcelable((Parcelable)mInner, i);
                return;
            } else
            {
                parcel.writeStrongBinder((IBinder)mInner);
                return;
            }
        }


        Token(Object obj)
        {
            mInner = obj;
        }

        /* block-local class not found */
        class _cls1 {}

    }


    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final String TAG = "MediaSessionCompat";
    private final ArrayList mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    private MediaSessionCompat(Context context, MediaSessionImpl mediasessionimpl)
    {
        mActiveListeners = new ArrayList();
        mImpl = mediasessionimpl;
        mController = new MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(Context context, String s)
    {
        this(context, s, null, null);
    }

    public MediaSessionCompat(Context context, String s, ComponentName componentname, PendingIntent pendingintent)
    {
        mActiveListeners = new ArrayList();
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        Object obj = componentname;
        if (componentname == null)
        {
            obj = new Intent("android.intent.action.MEDIA_BUTTON");
            ((Intent) (obj)).setPackage(context.getPackageName());
            List list = context.getPackageManager().queryBroadcastReceivers(((Intent) (obj)), 0);
            if (list.size() == 1)
            {
                componentname = (ResolveInfo)list.get(0);
                obj = new ComponentName(((ResolveInfo) (componentname)).activityInfo.packageName, ((ResolveInfo) (componentname)).activityInfo.name);
            } else
            {
                obj = componentname;
                if (list.size() > 1)
                {
                    Log.w("MediaSessionCompat", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session's media button receiver");
                    obj = componentname;
                }
            }
        }
        componentname = pendingintent;
        if (obj != null)
        {
            componentname = pendingintent;
            if (pendingintent == null)
            {
                componentname = new Intent("android.intent.action.MEDIA_BUTTON");
                componentname.setComponent(((ComponentName) (obj)));
                componentname = PendingIntent.getBroadcast(context, 0, componentname, 0);
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            mImpl = new MediaSessionImplApi21(context, s);
            mImpl.setMediaButtonReceiver(componentname);
        } else
        {
            mImpl = new MediaSessionImplBase(context, s, ((ComponentName) (obj)), componentname);
        }
        mController = new MediaControllerCompat(context, this);
    }

    public static MediaSessionCompat obtain(Context context, Object obj)
    {
        return new MediaSessionCompat(context, new MediaSessionImplApi21(obj));
    }

    public void addOnActiveChangeListener(OnActiveChangeListener onactivechangelistener)
    {
        if (onactivechangelistener == null)
        {
            throw new IllegalArgumentException("Listener may not be null");
        } else
        {
            mActiveListeners.add(onactivechangelistener);
            return;
        }
    }

    public MediaControllerCompat getController()
    {
        return mController;
    }

    public Object getMediaSession()
    {
        return mImpl.getMediaSession();
    }

    public Object getRemoteControlClient()
    {
        return mImpl.getRemoteControlClient();
    }

    public Token getSessionToken()
    {
        return mImpl.getSessionToken();
    }

    public boolean isActive()
    {
        return mImpl.isActive();
    }

    public void release()
    {
        mImpl.release();
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener onactivechangelistener)
    {
        if (onactivechangelistener == null)
        {
            throw new IllegalArgumentException("Listener may not be null");
        } else
        {
            mActiveListeners.remove(onactivechangelistener);
            return;
        }
    }

    public void sendSessionEvent(String s, Bundle bundle)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("event cannot be null or empty");
        } else
        {
            mImpl.sendSessionEvent(s, bundle);
            return;
        }
    }

    public void setActive(boolean flag)
    {
        mImpl.setActive(flag);
        for (Iterator iterator = mActiveListeners.iterator(); iterator.hasNext(); ((OnActiveChangeListener)iterator.next()).onActiveChanged()) { }
    }

    public void setCallback(Callback callback)
    {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler)
    {
        MediaSessionImpl mediasessionimpl = mImpl;
        if (handler == null)
        {
            handler = new Handler();
        }
        mediasessionimpl.setCallback(callback, handler);
    }

    public void setExtras(Bundle bundle)
    {
        mImpl.setExtras(bundle);
    }

    public void setFlags(int i)
    {
        mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(PendingIntent pendingintent)
    {
        mImpl.setMediaButtonReceiver(pendingintent);
    }

    public void setMetadata(MediaMetadataCompat mediametadatacompat)
    {
        mImpl.setMetadata(mediametadatacompat);
    }

    public void setPlaybackState(PlaybackStateCompat playbackstatecompat)
    {
        mImpl.setPlaybackState(playbackstatecompat);
    }

    public void setPlaybackToLocal(int i)
    {
        mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeprovidercompat)
    {
        if (volumeprovidercompat == null)
        {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        } else
        {
            mImpl.setPlaybackToRemote(volumeprovidercompat);
            return;
        }
    }

    public void setQueue(List list)
    {
        mImpl.setQueue(list);
    }

    public void setQueueTitle(CharSequence charsequence)
    {
        mImpl.setQueueTitle(charsequence);
    }

    public void setRatingType(int i)
    {
        mImpl.setRatingType(i);
    }

    public void setSessionActivity(PendingIntent pendingintent)
    {
        mImpl.setSessionActivity(pendingintent);
    }

    // Unreferenced inner class android/support/v4/media/session/MediaSessionCompat$Callback$StubApi21
    /* block-local class not found */
    class Callback.StubApi21 {}


    // Unreferenced inner class android/support/v4/media/session/MediaSessionCompat$Callback$StubApi23
    /* block-local class not found */
    class Callback.StubApi23 {}


    // Unreferenced inner class android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$Command
    /* block-local class not found */
    class MediaSessionImplBase.Command {}


    // Unreferenced inner class android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MediaSessionStub
    /* block-local class not found */
    class MediaSessionImplBase.MediaSessionStub {}


    // Unreferenced inner class android/support/v4/media/session/MediaSessionCompat$MediaSessionImplBase$MessageHandler
    /* block-local class not found */
    class MediaSessionImplBase.MessageHandler {}

}
