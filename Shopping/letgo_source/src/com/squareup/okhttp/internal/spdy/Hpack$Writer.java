// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Hpack, Header

static final class out
{

    private final apv out;

    void writeByteString(apy apy1)
        throws IOException
    {
        writeInt(apy1.f(), 127, 0);
        out.a(apy1);
    }

    void writeHeaders(List list)
        throws IOException
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            apy apy1 = ((Header)list.get(i)).name.e();
            Integer integer = (Integer)Hpack.access$200().get(apy1);
            if (integer != null)
            {
                writeInt(integer.intValue() + 1, 15, 0);
                writeByteString(((Header)list.get(i)).value);
            } else
            {
                out.a(0);
                writeByteString(apy1);
                writeByteString(((Header)list.get(i)).value);
            }
            i++;
        }
    }

    void writeInt(int i, int j, int k)
        throws IOException
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

    (apv apv1)
    {
        out = apv1;
    }
}
