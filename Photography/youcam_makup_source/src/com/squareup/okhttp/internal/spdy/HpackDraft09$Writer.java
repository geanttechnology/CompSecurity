// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.d;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, HpackDraft09

final class out
{

    private final d out;

    void writeByteString(ByteString bytestring)
    {
        writeInt(bytestring.e(), 127, 0);
        out.a(bytestring);
    }

    void writeHeaders(List list)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            ByteString bytestring = ((Header)list.get(i)).name.d();
            Integer integer = (Integer)HpackDraft09.access$200().get(bytestring);
            if (integer != null)
            {
                writeInt(integer.intValue() + 1, 15, 0);
                writeByteString(((Header)list.get(i)).value);
            } else
            {
                out.a(0);
                writeByteString(bytestring);
                writeByteString(((Header)list.get(i)).value);
            }
            i++;
        }
    }

    void writeInt(int i, int j, int k)
    {
        if (i < j)
        {
            out.a(k | i);
            return;
        }
        out.a(k | j);
        for (i -= j; i >= 128; i >>>= 7)
        {
            out.a(i & 0x7f | 0x80);
        }

        out.a(i);
    }

    (d d1)
    {
        out = d1;
    }
}
