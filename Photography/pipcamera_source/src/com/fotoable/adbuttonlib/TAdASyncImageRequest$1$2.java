// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdASyncImageRequest

class val.e1
    implements Runnable
{

    final val.e1 this$1;
    final Exception val$e1;

    public void run()
    {
        callback.downLoadedError(val$e1);
    }

    loadCallback()
    {
        this$1 = final_loadcallback;
        val$e1 = Exception.this;
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
            RuntimeException runtimeexception;
            try
            {
                final byte result[] = downloadFromUrl(url);
                TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(new TAdASyncImageRequest._cls1._cls1());
                return;
            }
            catch (Exception exception)
            {
                runtimeexception = new RuntimeException(exception);
            }
            TAdASyncImageRequest.access$000(TAdASyncImageRequest.this).post(runtimeexception. new TAdASyncImageRequest._cls1._cls2());
        }

            
            {
                this$0 = final_tadasyncimagerequest;
                url = s;
                callback = TAdASyncImageRequest.DownloadCallback.this;
                super();
            }

        // Unreferenced inner class com/fotoable/adbuttonlib/TAdASyncImageRequest$1$1

/* anonymous class */
        class TAdASyncImageRequest._cls1._cls1
            implements Runnable
        {

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
        }

    }

}
