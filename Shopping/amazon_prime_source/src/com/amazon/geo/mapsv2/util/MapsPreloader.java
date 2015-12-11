// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amazon.client.framework.acf.util.Preconditions;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            MapsInitializationOptions, MapsInitializerInternal

public class MapsPreloader
{
    class PreloadHandlerCallback
        implements android.os.Handler.Callback
    {

        Controller mController;
        final MapsPreloader this$0;

        public boolean handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return false;

            case 1: // '\001'
                mMapsPreloadObserver.onPreloadStart(mController);
                break;
            }
            mMapsPreloadObserver.onPreloadEnd(mController.result);
            return true;
        }

        PreloadHandlerCallback()
        {
            this$0 = MapsPreloader.this;
            super();
            mController = new Controller();
        }
    }

    class PreloadHandlerCallback.Controller
        implements MapsInitializerInternal.PreloadController
    {

        public MapsInitializerInternal.PreloadResult result;
        final PreloadHandlerCallback this$1;

        public void cancel()
        {
            result = MapsInitializerInternal.PreloadResult.CANCELED;
        }

        PreloadHandlerCallback.Controller()
        {
            this$1 = PreloadHandlerCallback.this;
            super();
            result = MapsInitializerInternal.PreloadResult.OK;
        }
    }


    private Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new PreloadHandlerCallback());
    private MapsInitializationOptions mInitializationOptions;
    private final MapsInitializerInternal.PreloadObserver mMapsPreloadObserver = new MapsInitializerInternal.PreloadObserver() {

        final MapsPreloader this$0;

        public void onPreloadEnd(MapsInitializerInternal.PreloadResult preloadresult)
        {
            if (mObserver != null)
            {
                mObserver.onPreloadEnd(preloadresult);
            }
        }

        public void onPreloadProgress(MapsInitializerInternal.PreloadController preloadcontroller, int i, int j)
        {
            if (mObserver != null)
            {
                mObserver.onPreloadProgress(preloadcontroller, i, j);
            }
        }

        public void onPreloadStart(MapsInitializerInternal.PreloadController preloadcontroller)
        {
            if (mObserver != null)
            {
                mObserver.onPreloadStart(preloadcontroller);
            }
        }

            
            {
                this$0 = MapsPreloader.this;
                super();
            }
    };
    private MapsInitializerInternal.PreloadObserver mObserver;
    private Executor mPreloadExecutor;
    private final int mPreloadMessage = 1;

    public MapsPreloader()
    {
        MapsInitializationOptions mapsinitializationoptions = new MapsInitializationOptions();
        mapsinitializationoptions.forceNoAccount = Boolean.valueOf(true);
        setInitializationParams(mapsinitializationoptions);
    }

    protected Bundle getInitializationOptions()
    {
        if (mInitializationOptions == null)
        {
            return null;
        } else
        {
            return mInitializationOptions.toBundle();
        }
    }

    public void preload(Context context)
    {
        preload(context, null);
    }

    public void preload(Context context, MapsInitializerInternal.PreloadObserver preloadobserver)
    {
        boolean flag;
        if (context != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Preload context cannot be null.");
        mContext = context;
        mObserver = preloadobserver;
        if (MapsInitializerInternal.isPreloaded(context))
        {
            mHandler.sendEmptyMessage(1);
            return;
        } else
        {
            MapsInitializerInternal.preload(mContext, getInitializationOptions(), mMapsPreloadObserver, mPreloadExecutor);
            return;
        }
    }

    public void setInitializationParams(MapsInitializationOptions mapsinitializationoptions)
    {
        mInitializationOptions = mapsinitializationoptions;
    }

    public void setPreloadExecutor(Executor executor)
    {
        mPreloadExecutor = executor;
    }


}
