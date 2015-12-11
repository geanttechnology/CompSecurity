// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.Display;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package android.support.v7.media:
//            MediaRouter, SystemMediaRouteProvider, MediaRouteProvider, MediaRouteProviderDescriptor, 
//            MediaRouteDescriptor, MediaRouteSelector, RegisteredMediaRouteProviderWatcher, MediaRouteDiscoveryRequest, 
//            RemoteControlClientCompat

private static final class mSystemProvider
    implements allback, tcher.Callback
{
    private final class CallbackHandler extends Handler
    {

        public static final int MSG_PROVIDER_ADDED = 513;
        public static final int MSG_PROVIDER_CHANGED = 515;
        public static final int MSG_PROVIDER_REMOVED = 514;
        public static final int MSG_ROUTE_ADDED = 257;
        public static final int MSG_ROUTE_CHANGED = 259;
        public static final int MSG_ROUTE_PRESENTATION_DISPLAY_CHANGED = 261;
        public static final int MSG_ROUTE_REMOVED = 258;
        public static final int MSG_ROUTE_SELECTED = 262;
        public static final int MSG_ROUTE_UNSELECTED = 263;
        public static final int MSG_ROUTE_VOLUME_CHANGED = 260;
        private static final int MSG_TYPE_MASK = 65280;
        private static final int MSG_TYPE_PROVIDER = 512;
        private static final int MSG_TYPE_ROUTE = 256;
        private final ArrayList mTempCallbackRecords;
        final MediaRouter.GlobalMediaRouter this$0;

        private void invokeCallback(MediaRouter.CallbackRecord callbackrecord, int i, Object obj)
        {
            MediaRouter mediarouter;
            MediaRouter.Callback callback;
            mediarouter = callbackrecord.mRouter;
            callback = callbackrecord.mCallback;
            0xff00 & i;
            JVM INSTR lookupswitch 2: default 44
        //                       256: 45
        //                       512: 164;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if (callbackrecord.filterRouteEvent(((MediaRouter.RouteInfo) (obj = (MediaRouter.RouteInfo)obj))))
            {
                switch (i)
                {
                default:
                    return;

                case 257: 
                    callback.onRouteAdded(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 258: 
                    callback.onRouteRemoved(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 259: 
                    callback.onRouteChanged(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 260: 
                    callback.onRouteVolumeChanged(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 261: 
                    callback.onRoutePresentationDisplayChanged(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 262: 
                    callback.onRouteSelected(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    return;

                case 263: 
                    callback.onRouteUnselected(mediarouter, ((MediaRouter.RouteInfo) (obj)));
                    break;
                }
                return;
            }
              goto _L1
_L3:
            callbackrecord = (MediaRouter.ProviderInfo)obj;
            switch (i)
            {
            default:
                return;

            case 513: 
                callback.onProviderAdded(mediarouter, callbackrecord);
                return;

            case 514: 
                callback.onProviderRemoved(mediarouter, callbackrecord);
                return;

            case 515: 
                callback.onProviderChanged(mediarouter, callbackrecord);
                break;
            }
            return;
        }

        private void syncWithSystemProvider(int i, Object obj)
        {
            switch (i)
            {
            case 260: 
            case 261: 
            default:
                return;

            case 257: 
                mSystemProvider.onSyncRouteAdded((MediaRouter.RouteInfo)obj);
                return;

            case 258: 
                mSystemProvider.onSyncRouteRemoved((MediaRouter.RouteInfo)obj);
                return;

            case 259: 
                mSystemProvider.onSyncRouteChanged((MediaRouter.RouteInfo)obj);
                return;

            case 262: 
                mSystemProvider.onSyncRouteSelected((MediaRouter.RouteInfo)obj);
                break;
            }
        }

        public void handleMessage(Message message)
        {
            int j;
            j = message.what;
            message = ((Message) (message.obj));
            syncWithSystemProvider(j, message);
            int i = mRouters.size();
_L1:
            i--;
            if (i < 0)
            {
                break MISSING_BLOCK_LABEL_102;
            }
            MediaRouter mediarouter = (MediaRouter)((WeakReference)mRouters.get(i)).get();
            if (mediarouter != null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            mRouters.remove(i);
              goto _L1
            message;
            mTempCallbackRecords.clear();
            throw message;
            mTempCallbackRecords.addAll(mediarouter.mCallbackRecords);
              goto _L1
            int k = mTempCallbackRecords.size();
            i = 0;
_L3:
            if (i >= k)
            {
                break; /* Loop/switch isn't completed */
            }
            invokeCallback((MediaRouter.CallbackRecord)mTempCallbackRecords.get(i), j, message);
            i++;
            if (true) goto _L3; else goto _L2
_L2:
            mTempCallbackRecords.clear();
            return;
        }

        public void post(int i, Object obj)
        {
            obtainMessage(i, obj).sendToTarget();
        }

        private CallbackHandler()
        {
            this$0 = MediaRouter.GlobalMediaRouter.this;
            super();
            mTempCallbackRecords = new ArrayList();
        }

        CallbackHandler(MediaRouter._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MediaSessionRecord
    {

        private int mControlType;
        private int mMaxVolume;
        private final MediaSessionCompat mMsCompat;
        private VolumeProviderCompat mVpCompat;
        final MediaRouter.GlobalMediaRouter this$0;

        public void clearVolumeHandling()
        {
            mMsCompat.setPlaybackToLocal(mPlaybackInfo.playbackStream);
            mVpCompat = null;
        }

        public void configureVolume(int i, int j, int k)
        {
            if (mVpCompat != null && i == mControlType && j == mMaxVolume)
            {
                mVpCompat.setCurrentVolume(k);
                return;
            } else
            {
                mVpCompat = new VolumeProviderCompat(i, j, k) {

                    final MediaSessionRecord this$1;

                    public void onAdjustVolume(int i)
                    {
                        mCallbackHandler.post(i. new Runnable() {

                            final MediaSessionRecord._cls1 this$2;
                            final int val$direction;

                            public void run()
                            {
             