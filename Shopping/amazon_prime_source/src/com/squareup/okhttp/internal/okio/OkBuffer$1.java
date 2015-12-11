// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            OkBuffer

class this._cls0 extends OutputStream
{

    final OkBuffer this$0;

    public void close()
    {
    }

    public void flush()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(this).append(".outputStream()").toString();
    }

    public void write(int i)
    {
        writeByte((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
    {
        OkBuffer.this.write(abyte0, i, j);
    }

    ()
    {
        this$0 = OkBuffer.this;
        super();
    }
}
