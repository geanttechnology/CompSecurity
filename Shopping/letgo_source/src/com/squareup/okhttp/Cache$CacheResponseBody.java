// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apx;
import android.support.v7.aqb;
import android.support.v7.aqe;
import android.support.v7.aqk;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, Cache, MediaType

private static class apshot extends ResponseBody
{

    private final apx bodySource;
    private final String contentLength;
    private final String contentType;
    private final com.squareup.okhttp.internal.e snapshot;

    public long contentLength()
    {
        long l = -1L;
        try
        {
            if (contentLength != null)
            {
                l = Long.parseLong(contentLength);
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1L;
        }
        return l;
    }

    public MediaType contentType()
    {
        if (contentType != null)
        {
            return MediaType.parse(contentType);
        } else
        {
            return null;
        }
    }

    public apx source()
    {
        return bodySource;
    }


    public apshot(com.squareup.okhttp.internal.pshot pshot, String s, String s1)
    {
        snapshot = pshot;
        contentType = s;
        contentLength = s1;
        bodySource = aqe.a(new aqb(pshot) {

            final Cache.CacheResponseBody this$0;
            final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

            public void close()
                throws IOException
            {
                snapshot.close();
                super.close();
            }

            
            {
                this$0 = Cache.CacheResponseBody.this;
                snapshot = snapshot1;
                super(final_aqk);
            }
        });
    }
}
