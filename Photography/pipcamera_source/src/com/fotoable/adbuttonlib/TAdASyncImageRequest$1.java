// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncImageRequest

class wnloadCallback
    implements Runnable
{

    final TAdASyncImageRequest this$0;
    final wnloadCallback val$callback;
    final String val$url;

    public void run()
    {
        final RuntimeException e1;
        try
        {
            final byte result[] = downloadFromUrl(val$url);
            TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(new Runnable() {

                final TAdASyncImageRequest._cls1 this$1;
                final byte val$result[];

                public void run()
                {
                    callback.downLoaded(url, result);
                }

            
            {
                this$1 = TAdASyncImageRequest._cls1.this;
                result = abyte0;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            e1 = new RuntimeException(exception);
        }
        TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(new Runnable() {

            final TAdASyncImageRequest._cls1 this$1;
            final Exception val$e1;

            public void run()
            {
                callback.downLoadedError(e1);
            }

            
            {
                this$1 = TAdASyncImageRequest._cls1.this;
                e1 = exception;
                super();
            }
        });
    }

    wnloadCallback()
    {
        this$0 = final_tadasyncimagerequest;
        val$url = s;
        val$callback = wnloadCallback.this;
        super();
    }
}
