// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.amazon.avod.sdk.CacheLevel;
import com.amazon.avod.sdk.CallResponse;
import com.amazon.avod.sdk.PlaybackStateEventListener;
import com.amazon.avod.sdk.PlaybackSupportResponse;
import com.amazon.avod.sdk.ResponseHandler;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            AivConnection, BlockingBindingConnection, PlaybackEventResponseDelegate

public class BindingConnection
    implements AivConnection
{
    final class _cls1PlayVideoRunnable extends SdkRunnable
    {

        final BindingConnection this$0;
        final String val$asin;
        final Bundle val$bundle;

        public void run(AivPlaybackSdk aivplaybacksdk)
            throws RemoteException
        {
            PlaybackEventResponseDelegate playbackeventresponsedelegate = new PlaybackEventResponseDelegate(mEventListener);
            aivplaybacksdk.startPlayback(asin, bundle, playbackeventresponsedelegate);
        }

        public _cls1PlayVideoRunnable(Bundle bundle1)
        {
            this$0 = BindingConnection.this;
            asin = s;
            bundle = bundle1;
            super(final_blockingbindingconnection);
        }
    }

    final class _cls1QueryPlaybackSupportRunnable extends SdkRunnable
    {

        final BindingConnection this$0;
        final PlaybackSupportResponse val$callback;

        public void run(AivPlaybackSdk aivplaybacksdk)
            throws RemoteException
        {
            aivplaybacksdk = com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport.Factory.newPlaybackSupport(aivplaybacksdk.isPlaybackSupported(), aivplaybacksdk.isPlaybackSustainable());
            mUiHandler.post(aivplaybacksdk. new Runnable() {

                final _cls1QueryPlaybackSupportRunnable this$1;
                final com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport val$support;

                public void run()
                {
                    callback.onPlaybackSupport(support);
                }

            
            {
                this$1 = final__pcls1queryplaybacksupportrunnable;
                support = com.amazon.avod.sdk.PlaybackSupportResponse.PlaybackSupport.this;
                super();
            }
            });
        }

        public _cls1QueryPlaybackSupportRunnable(PlaybackSupportResponse playbacksupportresponse)
        {
            this$0 = BindingConnection.this;
            callback = playbacksupportresponse;
            super(final_blockingbindingconnection);
        }
    }

    final class _cls1TeardownRunnable extends SdkRunnable
    {

        final BindingConnection this$0;
        final ResponseHandler val$handler;

        public void run(AivPlaybackSdk aivplaybacksdk)
            throws RemoteException
        {
            aivplaybacksdk.teardownPreparedVideo();
            sendDefaultSuccessResponse(handler);
        }

        public _cls1TeardownRunnable(ResponseHandler responsehandler)
        {
            this$0 = BindingConnection.this;
            handler = responsehandler;
            super(final_blockingbindingconnection);
        }
    }

    final class _cls1WhisperCacheRunnable extends SdkRunnable
    {

        final BindingConnection this$0;
        final List val$asins;
        final CacheLevel val$cacheLevel;

        public void run(AivPlaybackSdk aivplaybacksdk)
            throws RemoteException
        {
            aivplaybacksdk.whisperCacheContent(asins, cacheLevel.toString());
        }

        public _cls1WhisperCacheRunnable(CacheLevel cachelevel)
        {
            this$0 = BindingConnection.this;
            asins = list;
            cacheLevel = cachelevel;
            super(final_blockingbindingconnection);
        }
    }

    private static class HandleResponseTask
        implements Runnable
    {

        private final ResponseHandler mHandler;
        private final CallResponse mResponse;

        public void run()
        {
            mHandler.handleResponse(mResponse);
        }

        private HandleResponseTask(ResponseHandler responsehandler, CallResponse callresponse)
        {
            mHandler = responsehandler;
            mResponse = callresponse;
        }

    }

    private static abstract class SdkRunnable
        implements Runnable
    {

        private final BlockingBindingConnection mServiceConnection;

        public final void run()
        {
            try
            {
                if (!mServiceConnection.isConnected())
                {
                    mServiceConnection.bind();
                }
                run(mServiceConnection.getService());
                return;
            }
            catch (RemoteException remoteexception)
            {
                Log.e("AmazonInstantVideoSDK", "RemoteException calling to the service", remoteexception);
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                Log.e("AmazonInstantVideoSDK", "InterruptedException calling to the service", interruptedexception);
            }
        }

        protected abstract void run(AivPlaybackSdk aivplaybacksdk)
            throws RemoteException;

        private SdkRunnable(BlockingBindingConnection blockingbindingconnection)
        {
            mServiceConnection = blockingbindingconnection;
        }

    }


    private static final String SERVICE_INTENT_ACTION = com/amazon/avod/sdk/internal/aidl/AivPlaybackSdk.getName();
    private final ExecutorService mBackgroundExecutor;
    private PlaybackStateEventListener mEventListener;
    private final AivConnection mFallbackConnection;
    private final BlockingBindingConnection mServiceConnection;
    private final Handler mUiHandler;

    BindingConnection(Context context, AivConnection aivconnection)
    {
        this(aivconnection, new BlockingBindingConnection(context, new Intent(SERVICE_INTENT_ACTION)), new Handler(Looper.getMainLooper()), ((ExecutorService) (new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue()))));
    }

    private BindingConnection(AivConnection aivconnection, BlockingBindingConnection blockingbindingconnection, Handler handler, ExecutorService executorservice)
    {
        mFallbackConnection = aivconnection;
        mServiceConnection = blockingbindingconnection;
        mUiHandler = handler;
        mBackgroundExecutor = executorservice;
    }

    private void callBindingAsync(SdkRunnable sdkrunnable)
    {
        if (mBackgroundExecutor.isShutdown())
        {
            Log.w("AmazonInstantVideoSDK", String.format("Attempting to call SDK method %s after cleanup, ignoring", new Object[] {
                sdkrunnable
            }));
            return;
        } else
        {
            mBackgroundExecutor.execute(sdkrunnable);
            return;
        }
    }

    private void handleResponseOnUiThread(ResponseHandler responsehandler, CallResponse callresponse)
    {
        if (responsehandler != null)
        {
            mUiHandler.post(new HandleResponseTask(responsehandler, callresponse));
        }
    }

    private void sendDefaultSuccessResponse(ResponseHandler responsehandler)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("callResponseType", com.amazon.avod.sdk.Constants.CallResponseType.SUCCESS.getResponseCode());
        handleResponseOnUiThread(responsehandler, CallResponse.fromBundle(bundle));
    }

    public void disconnect()
    {
        mFallbackConnection.disconnect();
        mBackgroundExecutor.execute(new Runnable() {

            final BindingConnection this$0;

            public void run()
            {
                mServiceConnection.unbind();
            }

            
            {
                this$0 = BindingConnection.this;
                super();
            }
        });
        mBackgroundExecutor.shutdown();
    }

    public void playVideo(String s, Map map)
    {
        Bundle bundle = new Bundle();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); bundle.putString((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        callBindingAsync(new _cls1PlayVideoRunnable(bundle));
    }

    public void queryPlaybackSupport(PlaybackSupportResponse playbacksupportresponse)
    {
        callBindingAsync(new _cls1QueryPlaybackSupportRunnable(playbacksupportresponse));
    }

    public void teardownPreparedVideo(ResponseHandler responsehandler)
    {
        callBindingAsync(new _cls1TeardownRunnable(responsehandler));
    }

    public boolean tryConnect()
    {
        if (!mFallbackConnection.tryConnect())
        {
            Log.w("AmazonInstantVideoSDK", "Could not establish fallback connection, legacy functionality will be unavailable");
        }
        boolean flag = mServiceConnection.canBind();
        if (flag)
        {
            mServiceConnection.bind();
        }
        return flag;
    }

    public void whisperCacheContent(List list, CacheLevel cachelevel)
    {
        callBindingAsync(new _cls1WhisperCacheRunnable(cachelevel));
    }





}
