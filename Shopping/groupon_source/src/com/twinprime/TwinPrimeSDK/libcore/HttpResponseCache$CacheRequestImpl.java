// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            HttpResponseCache

public static final class _cls1.out extends CacheRequest
{

    private OutputStream body;
    private OutputStream cacheOut;
    private final body editor;

    public void abort()
    {
        try
        {
            editor.editor();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public OutputStream getBody()
        throws IOException
    {
        return body;
    }

    public _cls1.val.editor(_cls1.val.editor editor1)
        throws IOException
    {
        editor = editor1;
        cacheOut = editor1.(1);
        body = new FilterOutputStream(editor1) {

            final HttpResponseCache.CacheRequestImpl this$0;
            final DiskLruCache.Editor val$editor;

            public void close()
                throws IOException
            {
                super.close();
                editor.commit();
            }

            public void write(byte abyte0[], int i, int j)
                throws IOException
            {
                out.write(abyte0, i, j);
            }

            
            {
                this$0 = HttpResponseCache.CacheRequestImpl.this;
                editor = editor1;
                super(final_outputstream);
            }
        };
    }
}
