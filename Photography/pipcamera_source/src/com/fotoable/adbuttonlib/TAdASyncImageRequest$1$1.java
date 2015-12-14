// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncImageRequest

class val.result
    implements Runnable
{

    final val.result this$1;
    final byte val$result[];

    public void run()
    {
        callback.downLoaded(url, val$result);
    }

    loadCallback()
    {
        this$1 = final_loadcallback;
        val$result = _5B_B.this;
        super();
    }

    // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncImageRequest$1

/* anonymous class */
    class TAdASyncImageRequest._cls1
        implements Runnable
    {

        final TAdASyncImageRequest this$0;
        final TAdASyncImageRequest.DownloadCallback val$callback;
        final String val$url;

        public void run()
        {
            final RuntimeException e1;
            try
            {
                byte abyte0[] = downloadFromUrl(url);
                TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(abyte0. new TAdASyncImageRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                e1 = new RuntimeException(exception);
            }
            TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(new TAdASyncImageRequest._cls1._cls2());
        }

            
            {
                this$0 = final_tadasyncimagerequest;
                url = s;
                callback = TAdASyncImageRequest.DownloadCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncImageRequest$1$2

/* anonymous class */
        class TAdASyncImageRequest._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
