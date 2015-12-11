// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            OkBuffer

class this._cls0 extends InputStream
{

    final OkBuffer this$0;

    public int available()
    {
        return (int)Math.min(size, 0x7fffffffL);
    }

    public void close()
    {
    }

    public int read()
    {
        return readByte() & 0xff;
    }

    public int read(byte abyte0[], int i, int j)
    {
        return OkBuffer.this.read(abyte0, i, j);
    }

    public String toString()
    {
        return (new StringBuilder()).append(OkBuffer.this).append(".inputStream()").toString();
    }

    ()
    {
        this$0 = OkBuffer.this;
        super();
    }
}
