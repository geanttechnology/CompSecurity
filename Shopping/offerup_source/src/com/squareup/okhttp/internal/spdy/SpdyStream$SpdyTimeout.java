// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.a;
import java.io.InterruptedIOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            ErrorCode, SpdyStream

class this._cls0 extends a
{

    final SpdyStream this$0;

    public void exitAndThrowIfTimedOut()
    {
        if (exit())
        {
            throw new InterruptedIOException("timeout");
        } else
        {
            return;
        }
    }

    protected void timedOut()
    {
        closeLater(ErrorCode.CANCEL);
    }

    ()
    {
        this$0 = SpdyStream.this;
        super();
    }
}
