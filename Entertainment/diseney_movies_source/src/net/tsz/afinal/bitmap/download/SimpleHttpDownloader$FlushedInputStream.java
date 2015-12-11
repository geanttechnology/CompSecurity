// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.download;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package net.tsz.afinal.bitmap.download:
//            SimpleHttpDownloader

public class this._cls0 extends FilterInputStream
{

    final SimpleHttpDownloader this$0;

    public long skip(long l)
        throws IOException
    {
        long l1 = 0L;
_L5:
        if (l1 < l) goto _L2; else goto _L1
_L1:
        return l1;
_L2:
        long l2;
        long l3 = in.skip(l - l1);
        l2 = l3;
        if (l3 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (read() < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l2 = 1L;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        l1 += l2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public (InputStream inputstream)
    {
        this$0 = SimpleHttpDownloader.this;
        super(inputstream);
    }
}
