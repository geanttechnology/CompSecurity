// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.lang.ref.WeakReference;

// Referenced classes of package com.fotoable.ad:
//            FotoAdMediationUpdateRequest

class val.rtncontent
    implements Runnable
{

    final val.rtncontent this$1;
    final String val$rtncontent;

    public void run()
    {
        if (callbackWeakRef.get() == null)
        {
            return;
        }
        if (val$rtncontent == null)
        {
            Error error = new Error("error");
            ((estCallback)callbackWeakRef.get()).onRequestError(error);
            return;
        } else
        {
            ((estCallback)callbackWeakRef.get()).onRequestSuccess(val$rtncontent);
            return;
        }
    }

    estCallback()
    {
        this$1 = final_estcallback;
        val$rtncontent = String.this;
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
                String s = FotoAdMediationUpdateRequest.access$000(FotoAdMediationUpdateRequest.this, url);
                FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(s. new FotoAdMediationUpdateRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            final Error error = new Error("error");
            FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(new FotoAdMediationUpdateRequest._cls1._cls2());
        }

            
            {
                this$0 = final_fotoadmediationupdaterequest;
                url = s;
                callbackWeakRef = weakreference;
                callback = FotoAdMediationUpdateRequest.requestCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/ad/FotoAdMediationUpdateRequest$1$2

/* anonymous class */
        class FotoAdMediationUpdateRequest._cls1._cls2
            implements Runnable
        {

            final FotoAdMediationUpdateRequest._cls1 this$1;
            final Error val$error;

            public void run()
            {
                callback.onRequestError(error);
            }

                    
                    {
                        this$1 = FotoAdMediationUpdateRequest._cls1.this;
                        error = error1;
                        super();
                    }
        }

    }

}
