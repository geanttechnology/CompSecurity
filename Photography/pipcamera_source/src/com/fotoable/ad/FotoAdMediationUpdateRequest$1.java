// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.lang.ref.WeakReference;

// Referenced classes of package com.fotoable.ad:
//            FotoAdMediationUpdateRequest

class questCallback
    implements Runnable
{

    final FotoAdMediationUpdateRequest this$0;
    final questCallback val$callback;
    final WeakReference val$callbackWeakRef;
    final String val$url;

    public void run()
    {
        try
        {
            final String rtncontent = FotoAdMediationUpdateRequest.access$000(FotoAdMediationUpdateRequest.this, val$url);
            FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(new Runnable() {

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
            });
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        final Error error = new Error("error");
        FotoAdMediationUpdateRequest.access$100(FotoAdMediationUpdateRequest.this).post(new Runnable() {

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
        });
    }

    questCallback()
    {
        this$0 = final_fotoadmediationupdaterequest;
        val$url = s;
        val$callbackWeakRef = weakreference;
        val$callback = questCallback.this;
        super();
    }
}
