// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;

import com.facebook.common.internal.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.facebook.cache.common:
//            WriterCallback

public class WriterCallbacks
{

    public WriterCallbacks()
    {
    }

    public static WriterCallback from(InputStream inputstream)
    {
        return new WriterCallback(inputstream) {

            final InputStream val$is;

            public void write(OutputStream outputstream)
                throws IOException
            {
                ByteStreams.copy(is, outputstream);
            }

            
            {
                is = inputstream;
                super();
            }
        };
    }

    public static WriterCallback from(byte abyte0[])
    {
        return new WriterCallback(abyte0) {

            final byte val$data[];

            public void write(OutputStream outputstream)
                throws IOException
            {
                outputstream.write(data);
            }

            
            {
                data = abyte0;
                super();
            }
        };
    }
}
