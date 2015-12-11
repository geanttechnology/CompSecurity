// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import d.ab;
import d.j;
import d.n;
import d.q;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, MediaType

class apshot extends ResponseBody
{

    private final j bodySource;
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

    public j source()
    {
        return bodySource;
    }


    public apshot(com.squareup.okhttp.internal. , String s, String s1)
    {
        snapshot = ;
        contentType = s;
        contentLength = s1;
        class _cls1 extends n
        {

            final Cache.CacheResponseBody this$0;
            final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

            public void close()
            {
                snapshot.close();
                super.close();
            }

            _cls1(com.squareup.okhttp.internal.DiskLruCache.Snapshot snapshot1)
            {
                this$0 = Cache.CacheResponseBody.this;
                snapshot = snapshot1;
                super(final_ab);
            }
        }

        bodySource = q.a(new _cls1());
    }
}
