// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncItemsJsonRequest

class val.rtncontent
    implements Runnable
{

    final val.rtncontent this$1;
    final String val$rtncontent;

    public void run()
    {
        if (val$rtncontent == null)
        {
            Error error = new Error("error");
            callback.onRequestError(error);
            return;
        } else
        {
            callback.onRequestSuccess(val$rtncontent);
            return;
        }
    }

    estCallback()
    {
        this$1 = final_estcallback;
        val$rtncontent = String.this;
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
            final Error error;
            try
            {
                String s = TAdASyncItemsJsonRequest.access$000(TAdASyncItemsJsonRequest.this, url);
                TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(s. new TAdASyncItemsJsonRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                error = new Error("error");
            }
            TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(new TAdASyncItemsJsonRequest._cls1._cls2());
        }

            
            {
                this$0 = final_tadasyncitemsjsonrequest;
                url = s;
                callback = TAdASyncItemsJsonRequest.requestCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncItemsJsonRequest$1$2

/* anonymous class */
        class TAdASyncItemsJsonRequest._cls1._cls2
            implements Runnable
        {

            final TAdASyncItemsJsonRequest._cls1 this$1;
            final Error val$error;

            public void run()
            {
                callback.onRequestError(error);
            }

                    
                    {
                        this$1 = TAdASyncItemsJsonRequest._cls1.this;
                        error = error1;
                        super();
                    }
        }

    }

}
