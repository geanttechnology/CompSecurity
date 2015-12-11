// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// Referenced classes of package com.mopub.common:
//            DiskLruCacheStrictLineReader

class this._cls0 extends ByteArrayOutputStream
{

    final DiskLruCacheStrictLineReader this$0;

    public String toString()
    {
        String s;
        int i;
        if (count > 0 && buf[count - 1] == 13)
        {
            i = count - 1;
        } else
        {
            i = count;
        }
        try
        {
            s = new String(buf, 0, i, DiskLruCacheStrictLineReader.access$000(DiskLruCacheStrictLineReader.this).name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    (int i)
    {
        this$0 = DiskLruCacheStrictLineReader.this;
        super(i);
    }
}
