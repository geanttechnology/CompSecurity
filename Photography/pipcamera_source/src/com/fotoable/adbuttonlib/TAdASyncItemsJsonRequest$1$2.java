// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncItemsJsonRequest

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

    // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncItemsJsonRequest$1

/* anonymous class */
    class TAdASyncItemsJsonRequest._cls1
        implements Runnable
    {

        final TAdASyncItemsJsonRequest this$0;
        final TAdASyncItemsJsonRequest.requestCallback val$callback;
        final String val$url;

        public void run()
        {
            Error error1;
            try
            {
                final String rtncontent = TAdASyncItemsJsonRequest.access$000(TAdASyncItemsJsonRequest.this, url);
                TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(new TAdASyncItemsJsonRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                error1 = new Error("error");
            }
            TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(error1. new TAdASyncItemsJsonRequest._cls1._cls2());
        }

            
            {
                this$0 = final_tadasyncitemsjsonrequest;
                url = s;
                callback = TAdASyncItemsJsonRequest.requestCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncItemsJsonRequest$1$1

/* anonymous class */
        class TAdASyncItemsJsonRequest._cls1._cls1
            implements Runnable
        {

            final TAdASyncItemsJsonRequest._cls1 this$1;
            final String val$rtncontent;

            public void run()
            {
                if (rtncontent == null)
                {
                    Error error1 = new Error("error");
                    callback.onRequestError(error1);
                    return;
                } else
                {
                    callback.onRequestSuccess(rtncontent);
                    return;
                }
            }

                    
                    {
                        this$1 = TAdASyncItemsJsonRequest._cls1.this;
                        rtncontent = s;
                        super();
                    }
        }

    }

}
