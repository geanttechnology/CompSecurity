// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TAdASyncImageRequest
{

    private ExecutorService executorService;
    private final Handler handler = new Handler();

    public TAdASyncImageRequest()
    {
        executorService = Executors.newFixedThreadPool(1);
    }

    public byte[] download(final String url, final DownloadCallback callback)
    {
        executorService.submit(new _cls1());
        return null;
    }

    public byte[] downloadFromUrl(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
          goto _L1
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        s.close();
        return abyte0;
    }


    private class _cls1
        implements Runnable
    {

        final TAdASyncImageRequest this$0;
        final DownloadCallback val$callback;
        final String val$url;

        public void run()
        {
            final RuntimeException e1;
            try
            {
                final byte result[] = downloadFromUrl(url);
                class _cls1
                    implements Runnable
                {

                    final _cls1 this$1;
                    final byte val$result[];

                    public void run()
                    {
                        callback.downLoaded(url, result);
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    result = abyte0;
                    super();
                }

                    private class DownloadCallback
                    {

                        public abstract void downLoaded(String s, byte abyte0[]);

                        public abstract void downLoadedError(Exception exception);
                    }

                }

                handler.post(new _cls1());
                return;
            }
            catch (Exception exception)
            {
                e1 = new RuntimeException(exception);
            }
            class _cls2
                implements Runnable
            {

                final _cls1 this$1;
                final Exception val$e1;

                public void run()
                {
                    callback.downLoadedError(e1);
                }

                _cls2()
                {
                    this$1 = _cls1.this;
                    e1 = exception;
                    super();
                }
            }

            handler.post(new _cls2());
        }

        _cls1()
        {
            this$0 = TAdASyncImageRequest.this;
            url = s;
            callback = downloadcallback;
            super();
        }
    }

}
