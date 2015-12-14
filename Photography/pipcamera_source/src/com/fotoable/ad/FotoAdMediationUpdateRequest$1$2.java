// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.lang.ref.WeakReference;

// Referenced classes of package com.fotoable.ad:
//            FotoAdMediationUpdateRequest

class val.error
    implements Runnable
{

    final val.error this$1;
    final Error val$error;

    public void run()
    {
        callback.onRequestError(val$error);
    }

    estCallback()
    {
        this$1 = final_estcallback;
        val$error = Error.this;
        super();
    }

    // Unreferenced inner class com/fotoable/ad/FotoAdMediationUpdateRequest$1

/* anonymous class */
    class FotoAdMediationUpdateRequest._cls1
        implements Runnable
    {

        final FotoAdMediationUpdateRequest this$0;
        final FotoAdMediationUpdateRequest.requestCallback val$callback;
        final WeakReference val$callbackWeakRef;
        final String val$url;

        public void run()
        {
            try
            {
                final String rtncontent = FotoAdMediationUpdateRequest.access$000(FotoAdMediationUpdateRequest.this, url);
                FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(new FotoAdMediationUpdateRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            Error error1 = new Error("error");
            FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(error1. new FotoAdMediationUpdateRequest._cls1._cls2());
        }

            
            {
                this$0 = final_fotoadmediationupdaterequest;
                url = s;
                callbackWeakRef = weakreference;
                callback = FotoAdMediationUpdateRequest.requestCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/ad/FotoAdMediationUpdateRequest$1$1

/* anonymous class */
        class FotoAdMediationUpdateRequest._cls1._cls1
            implements Runnable
        {

            final FotoAdMediationUpdateRequest._cls1 this$1;
            final String val$rtncontent;

            public void run()
            {
                if (callbackWeakRef.get() == null)
                {
                    return;
                }
                if (rtncontent == null)
                {
                    Error error1 = new Error("error");
                    ((FotoAdMediationUpdateRequest.requestCallback)callbackWeakRef.get()).onRequestError(error1);
                    return;
                } else
                {
                    ((FotoAdMediationUpdateRequest.requestCallback)callbackWeakRef.get()).onRequestSuccess(rtncontent);
                    return;
                }
            }

                    
                    {
                        this$1 = FotoAdMediationUpdateRequest._cls1.this;
                        rtncontent = s;
                        super();
                    }
        }

    }

}
