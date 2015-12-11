// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.a;

import com.shazam.j.c;
import java.io.IOException;

// Referenced classes of package com.shazam.h.a:
//            a

public final class b
    implements com.shazam.h.a.a
{
    public static final class a
    {

        com.shazam.j.b a;
        public Object b;

        public static a a(com.shazam.j.b b1)
        {
            a a1 = new a();
            a1.a = b1;
            return a1;
        }

        public final b a()
        {
            return new b(this, (byte)0);
        }

        public a()
        {
        }
    }


    private com.shazam.j.b a;
    private Object b;

    private b(a a1)
    {
        a = a1.a;
        b = a1.b;
    }

    b(a a1, byte byte0)
    {
        this(a1);
    }

    public final byte[] a()
    {
        byte abyte0[];
        try
        {
            abyte0 = a.a(b).getBytes("UTF-8");
        }
        catch (c c1)
        {
            throw new IOException("Error serializing object", c1);
        }
        return abyte0;
    }
}
