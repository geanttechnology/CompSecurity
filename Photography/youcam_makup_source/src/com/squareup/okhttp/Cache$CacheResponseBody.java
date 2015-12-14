// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import okio.f;
import okio.i;
import okio.l;
import okio.r;

// Referenced classes of package com.squareup.okhttp:
//            ResponseBody, MediaType

class apshot extends ResponseBody
{

    private final f bodySource;
    private final String contentLength;
    private final String contentType;
    private final com.squareup.okhttp.internal.e snapshot;

    public long contentLength()
    {
        long l1 = -1L;
        try
        {
            if (contentLength != null)
            {
                l1 = Long.parseLong(contentLength);
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1L;
        }
        return l1;
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

    public f source()
    {
        return bodySource;
    }


    public apshot(com.squareup.okhttp.internal.pshot pshot, String s, String s1)
    {
        snapshot = pshot;
        contentType = s;
        contentLength = s1;
        bodySource = l.a(new i(pshot) {

            final Cache.CacheResponseBody this$0;
            final com.squareup.okhttp.internal.DiskLruCache.Snapshot val$snapshot;

            public void close()
            {
                snapshot.close();
                super.close();
            }

            
            {
                this$0 = Cache.CacheResponseBody.this;
                snapshot = snapshot1;
                super(final_r);
            }
        });
    }
}
