// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import okio.d;
import okio.i;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            NameValueBlockReader

class this._cls0 extends i
{

    final NameValueBlockReader this$0;

    public long read(d d, long l)
    {
        if (NameValueBlockReader.access$000(NameValueBlockReader.this) != 0)
        {
            if ((l = super.read(d, Math.min(l, NameValueBlockReader.access$000(NameValueBlockReader.this)))) != -1L)
            {
                NameValueBlockReader.access$022(NameValueBlockReader.this, l);
                return l;
            }
        }
        return -1L;
    }

    (r r)
    {
        this$0 = NameValueBlockReader.this;
        super(r);
    }
}
