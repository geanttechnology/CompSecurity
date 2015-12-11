// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.f;
import d.k;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Header, Hpack

final class out
{

    private final f out;

    final void writeByteString(k k1)
    {
        writeInt(k1.e(), 127, 0);
        out.a(k1);
    }

    final void writeHeaders(List list)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            k k1 = ((Header)list.get(i)).name.d();
            Integer integer = (Integer)Hpack.access$200().get(k1);
            if (integer != null)
            {
                writeInt(integer.intValue() + 1, 15, 0);
                writeByteString(((Header)list.get(i)).value);
            } else
            {
                out.a(0);
                writeByteString(k1);
                writeByteString(((Header)list.get(i)).value);
            }
            i++;
        }
    }

    final void writeInt(int i, int j, int l)
    {
        if (i < j)
        {
            out.a(l | i);
            return;
        }
        out.a(l | j);
        for (i -= j; i >= 128; i >>>= 7)
        {
            out.a(i & 0x7f | 0x80);
        }

        out.a(i);
    }

    (f f1)
    {
        out = f1;
    }
}
