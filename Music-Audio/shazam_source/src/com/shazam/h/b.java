// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.a.a;
import java.io.ByteArrayOutputStream;

public final class b
    implements com.shazam.h.a.a
{
    public static final class a
    {

        public byte a[];

        public a()
        {
        }
    }


    private byte a[];

    private b()
    {
    }

    private b(a a1)
    {
        a = a1.a;
    }

    b(a a1, byte byte0)
    {
        this(a1);
    }

    public final byte[] a()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(1024);
        if (a != null)
        {
            bytearrayoutputstream.write(a);
        }
        bytearrayoutputstream.close();
        return bytearrayoutputstream.toByteArray();
    }
}
