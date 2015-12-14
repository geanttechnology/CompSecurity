// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncItemsJsonRequest

class questCallback
    implements Runnable
{

    final TAdASyncItemsJsonRequest this$0;
    final questCallback val$callback;
    final String val$url;

    public void run()
    {
        final Error error;
        try
        {
            final String rtncontent = TAdASyncItemsJsonRequest.access$000(TAdASyncItemsJsonRequest.this, val$url);
            class _cls1
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

            _cls1()
            {
                this$1 = TAdASyncItemsJsonRequest._cls1.this;
                rtncontent = s;
                super();
            }
            }

            TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(new _cls1());
            return;
        }
        catch (Exception exception)
        {
            error = new Error("error");
        }
        class _cls2
            implements Runnable
        {

            final TAdASyncItemsJsonRequest._cls1 this$1;
            final Error val$error;

            public void run()
            {
                callback.onRequestError(error);
            }

            _cls2()
            {
                this$1 = TAdASyncItemsJsonRequest._cls1.this;
                error = error1;
                super();
            }
        }

        TAdASyncItemsJsonRequest.access$100(TAdASyncItemsJsonRequest.this).post(new _cls2());
    }

    questCallback()
    {
        this$0 = final_tadasyncitemsjsonrequest;
        val$url = s;
        val$callback = questCallback.this;
        super();
    }
}
