// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Source;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response

public static abstract class 
    implements Closeable
{

    private Source source;

    public abstract InputStream byteStream();

    public void close()
        throws IOException
    {
        byteStream().close();
    }

    public Source source()
    {
        Source source1 = source;
        if (source1 != null)
        {
            return source1;
        } else
        {
            Source source2 = Okio.source(byteStream());
            source = source2;
            return source2;
        }
    }

    public ()
    {
    }
}
