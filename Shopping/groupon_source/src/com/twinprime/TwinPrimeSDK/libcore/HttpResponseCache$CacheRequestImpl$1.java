// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.twinprime.TwinPrimeSDK.libcore:
//            HttpResponseCache

class val.editor extends FilterOutputStream
{

    final out this$0;
    final out val$editor;

    public void close()
        throws IOException
    {
        super.close();
        val$editor.editor();
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
    }

    ( 1)
    {
        this$0 = final_;
        val$editor = 1;
        super(OutputStream.this);
    }
}
