// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapsRuntimeUtilInternal

public class AmazonMapAccountInformationProvider
{
    public class CORPFMCallback extends CompoundCallback
    {

        public String cor;
        public String pfm;
        final AmazonMapAccountInformationProvider this$0;

        protected void onFinished(Bundle bundle, boolean flag)
        {
            if (cor != null || pfm != null)
            {
                mGotAccountInfo = true;
            }
            super.onFinished(bundle, flag);
        }

        protected void onFinishedMainThread(Bundle bundle, boolean flag)
        {
            if (cor != null || pfm != null)
            {
                AmazonMapsRuntimeUtilInternal.setAccountInfo(cor, pfm);
            }
            if (flag)
            {
                mCallback.onSuccess(null);
                return;
            } else
            {
                mCallback.onError(null);
                return;
            }
        }

        public CORPFMCallback(MAPAccountManager mapaccountmanager, Context context)
        {
            this$0 = AmazonMapAccountInformationProvider.this;
            super();
            context = CustomerAttributeStore.getInstance(context);
            CompoundCallback.CallbackItem callbackitem = new _cls1();
            amazonmapaccountinformationprovider = new _cls2();
            context.getAttribute(mapaccountmanager.getAccount(), "COR", callbackitem);
            context.getAttribute(mapaccountmanager.getAccount(), "PFM", AmazonMapAccountInformationProvider.this);
        }
    }

    public abstract class CompoundCallback extends SimpleCallback
    {

        private final AtomicInteger numCallbacks = new AtomicInteger(0);
        private boolean succeeded;
        final AmazonMapAccountInformationProvider this$0;

        void addCallback()
        {
            numCallbacks.addAndGet(1);
        }

        void removeCallback(Bundle bundle, boolean flag)
        {
            boolean flag1;
            if (flag && succeeded)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            succeeded = flag1;
            if (numCallbacks.decrementAndGet() == 0)
            {
                onFinished(bundle, flag);
            }
        }

        public CompoundCallback()
        {
            this$0 = AmazonMapAccountInformationProvider.this;
            super();
            succeeded = true;
        }
    }

    public class CompoundCallback.CallbackItem extends SimpleCallback
    {

        final CompoundCallback this$1;

        protected void onFinished(Bundle bundle, boolean flag)
        {
            removeCallback(bundle, flag);
        }

        CompoundCallback.CallbackItem()
        {
            this$1 = CompoundCallback.this;
            super();
            addCallback();
        }
    }

    public static abstract class SimpleCallback
        implements Callback
    {

        public void onError(Bundle bundle)
        {
            onFinished(bundle, false);
        }

        protected void onFinished(final Bundle bundle, boolean flag)
        {
            (new Handler(Looper.getMainLooper())).post(flag. new Runnable() {

                final SimpleCallback this$0;
                final Bundle val$bundle;
                final boolean val$succeeded;

                public void run()
                {
                    onFinishedMainThread(bundle, succeeded);
                }

            
            {
                this$0 = final_simplecallback;
                bundle = bundle1;
                succeeded = Z.this;
                super();
            }
            });
        }

        protected void onFinishedMainThread(Bundle bundle, boolean flag)
        {
        }

        public void onSuccess(Bundle bundle)
        {
            onFinished(bundle, true);
        }

        public SimpleCallback()
        {
        }
    }


    private final Callback mCallback;
    private final Context mContext;
    private boolean mGotAccountInfo;

    public AmazonMapAccountInformationProvider(Context context, Callback callback)
    {
        mGotAccountInfo = false;
        mContext = context;
        mCallback = callback;
        if (mContext == null)
        {
            throw new NullPointerException("Context cannot be null");
        }
        if (mCallback == null)
        {
            throw new NullPointerException("Callback cannot be null");
        } else
        {
            return;
        }
    }

    public void getCorPfm(MAPAccountManager mapaccountmanager)
    {
        if (mGotAccountInfo)
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                mCallback.onSuccess(null);
                return;
            } else
            {
                (new Handler(Looper.getMainLooper())).post(new Runnable() {

                    final AmazonMapAccountInformationProvider this$0;

                    public void run()
                    {
                        mCallback.onSuccess(null);
                    }

            
            {
                this$0 = AmazonMapAccountInformationProvider.this;
                super();
            }
                });
                return;
            }
        } else
        {
            new CORPFMCallback(mapaccountmanager, mContext);
            return;
        }
    }



/*
    static boolean access$102(AmazonMapAccountInformationProvider amazonmapaccountinformationprovider, boolean flag)
    {
        amazonmapaccountinformationprovider.mGotAccountInfo = flag;
        return flag;
    }

*/

    // Unreferenced inner class com/amazon/geo/mapsv2/util/AmazonMapAccountInformationProvider$CORPFMCallback$1

/* anonymous class */
    class CORPFMCallback._cls1 extends CompoundCallback.CallbackItem
    {

        final CORPFMCallback this$1;
        final AmazonMapAccountInformationProvider val$this$0;

        protected void onFinished(Bundle bundle, boolean flag)
        {
            cor = bundle.getString("value_key", null);
            super.onFinished(bundle, flag);
        }

            
            {
                this$1 = final_corpfmcallback;
                this$0 = AmazonMapAccountInformationProvider.this;
                final_corpfmcallback. super();
            }
    }


    // Unreferenced inner class com/amazon/geo/mapsv2/util/AmazonMapAccountInformationProvider$CORPFMCallback$2

/* anonymous class */
    class CORPFMCallback._cls2 extends CompoundCallback.CallbackItem
    {

        final CORPFMCallback this$1;
        final AmazonMapAccountInformationProvider val$this$0;

        protected void onFinished(Bundle bundle, boolean flag)
        {
            pfm = bundle.getString("value_key", null);
            super.onFinished(bundle, flag);
        }

            
            {
                this$1 = final_corpfmcallback;
                this$0 = AmazonMapAccountInformationProvider.this;
                final_corpfmcallback. super();
            }
    }

}
