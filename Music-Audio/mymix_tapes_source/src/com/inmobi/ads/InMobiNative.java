// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.inmobi.ads:
//            o, InMobiAdRequestStatus

public class InMobiNative
{
    public static interface NativeAdListener
    {

        public abstract void onAdDismissed(InMobiNative inmobinative);

        public abstract void onAdDisplayed(InMobiNative inmobinative);

        public abstract void onAdLoadFailed(InMobiNative inmobinative, InMobiAdRequestStatus inmobiadrequeststatus);

        public abstract void onAdLoadSucceeded(InMobiNative inmobinative);

        public abstract void onUserLeftApplication(InMobiNative inmobinative);
    }

    private static final class a extends Handler
    {

        private WeakReference a;
        private WeakReference b;

        public void handleMessage(Message message)
        {
            InMobiNative inmobinative;
            NativeAdListener nativeadlistener;
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
                                inmobinative = (InMobiNative)b.get();
                                nativeadlistener = (NativeAdListener)a.get();
                                if (inmobinative != null && nativeadlistener != null)
                                {
                                    switch (message.what)
                                    {
                                    default:
                                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, InMobiNative.TAG, "Unhandled ad lifecycle event! Ignoring ...");
                                        break;

                                    case 1: // '\001'
                                        break label4;

                                    case 2: // '\002'
                                        break label3;

                                    case 3: // '\003'
                                        break label2;

                                    case 4: // '\004'
                                        break label1;

                                    case 5: // '\005'
                                        break label0;
                                    }
                                }
                                return;
                            }
                            nativeadlistener.onAdLoadSucceeded(inmobinative);
                            return;
                        }
                        nativeadlistener.onAdLoadFailed(inmobinative, (InMobiAdRequestStatus)message.obj);
                        return;
                    }
                    nativeadlistener.onAdDisplayed(inmobinative);
                    return;
                }
                nativeadlistener.onAdDismissed(inmobinative);
                return;
            }
            nativeadlistener.onUserLeftApplication(inmobinative);
        }

        public a(InMobiNative inmobinative, NativeAdListener nativeadlistener)
        {
            super(Looper.getMainLooper());
            b = new WeakReference(inmobinative);
            a = new WeakReference(nativeadlistener);
        }
    }


    private static final String TAG = com/inmobi/ads/InMobiNative.getSimpleName();
    protected static WeakHashMap sMappedAdUnits = new WeakHashMap();
    private a mClientCallbackHandler;
    private final AdUnit.a mListener = new AdUnit.a() {

        final InMobiNative a;

        public void a()
        {
            a.mClientCallbackHandler.sendEmptyMessage(1);
        }

        public void a(InMobiAdRequestStatus inmobiadrequeststatus)
        {
            Message message = Message.obtain();
            message.what = 2;
            message.obj = inmobiadrequeststatus;
            a.mClientCallbackHandler.sendMessage(message);
        }

        public void a(Map map)
        {
        }

        public void b()
        {
            a.mClientCallbackHandler.sendEmptyMessage(3);
        }

        public void b(Map map)
        {
        }

        public void c()
        {
            a.mClientCallbackHandler.sendEmptyMessage(4);
        }

        public void d()
        {
            a.mClientCallbackHandler.sendEmptyMessage(5);
        }

            
            {
                a = InMobiNative.this;
                super();
            }
    };
    private NativeAdListener mNativeAdListener;
    protected o mNativeAdUnit;

    public InMobiNative(long l, NativeAdListener nativeadlistener)
    {
        if (!com.inmobi.commons.a.a.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please initialize the SDK before trying to create an ad.");
            return;
        }
        if (nativeadlistener == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "The Ad unit cannot be created as no event listener was supplied. Please attach a listener to proceed");
            return;
        } else
        {
            mNativeAdListener = nativeadlistener;
            mNativeAdUnit = new o(l, mListener);
            mClientCallbackHandler = new a(this, nativeadlistener);
            return;
        }
    }

    public static void bind(View view, InMobiNative inmobinative)
    {
        if (view == null || inmobinative == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please pass non-null instances of a view and InMobiNative to bind.");
        } else
        {
            if ((o)sMappedAdUnits.get(view) != null)
            {
                unbind(view);
            }
            inmobinative = inmobinative.mNativeAdUnit;
            if (inmobinative != null)
            {
                sMappedAdUnits.remove(view);
                sMappedAdUnits.put(view, inmobinative);
                inmobinative.a(view, null, null);
                return;
            }
        }
    }

    public static void unbind(View view)
    {
        if (view == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.ERROR, TAG, "Please pass a non-null view object to bind.");
        } else
        {
            o o1 = (o)sMappedAdUnits.remove(view);
            if (o1 != null)
            {
                o1.a(view);
                return;
            }
        }
    }

    public final Object getAdContent()
    {
        if (mNativeAdUnit == null)
        {
            return null;
        } else
        {
            return mNativeAdUnit.z();
        }
    }

    public final void load()
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.o();
        }
    }

    public final void pause()
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.y();
        }
    }

    public final void reportAdClick(Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, null, null);
        }
    }

    public final void reportAdClickAndOpenLandingPage(Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map, null, null);
            mNativeAdUnit.B();
        }
    }

    public final void resume()
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.x();
        }
    }

    public final void setExtras(Map map)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(map);
        }
    }

    public final void setKeywords(String s)
    {
        if (mNativeAdUnit != null)
        {
            mNativeAdUnit.a(s);
        }
    }



}
