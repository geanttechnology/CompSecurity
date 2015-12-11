// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.tape:
//            FileObjectQueue

class er
    implements eader
{

    final FileObjectQueue this$0;
    final er val$listener;

    public void read(InputStream inputstream, int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        inputstream.read(abyte0, 0, i);
        val$listener.onAdd(FileObjectQueue.this, FileObjectQueue.access$000(FileObjectQueue.this).from(abyte0));
    }

    er()
    {
        this$0 = final_fileobjectqueue;
        val$listener = er.this;
        super();
    }
}
