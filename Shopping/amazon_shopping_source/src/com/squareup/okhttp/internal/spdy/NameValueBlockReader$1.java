// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.BufferedSource;
import com.squareup.okhttp.internal.okio.Deadline;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Source;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            NameValueBlockReader

class val.source
    implements Source
{

    final NameValueBlockReader this$0;
    final BufferedSource val$source;

    public void close()
        throws IOException
    {
        val$source.close();
    }

    public Source deadline(Deadline deadline1)
    {
        val$source.deadline(deadline1);
        return this;
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (NameValueBlockReader.access$000(NameValueBlockReader.this) == 0)
        {
            return -1L;
        }
        l = val$source.read(okbuffer, Math.min(l, NameValueBlockReader.access$000(NameValueBlockReader.this)));
        if (l == -1L)
        {
            return -1L;
        } else
        {
            NameValueBlockReader.access$022(NameValueBlockReader.this, l);
            return l;
        }
    }

    ()
    {
        this$0 = final_namevalueblockreader;
        val$source = BufferedSource.this;
        super();
    }
}
