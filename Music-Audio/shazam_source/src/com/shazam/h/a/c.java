// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.a;

import com.shazam.h.e.a.b;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.h.a:
//            a

public final class c
    implements com.shazam.h.a.a
{
    public static final class a
    {

        public b a;
        public List b;
        int c;

        public final c a()
        {
            return new c(this, (byte)0);
        }

        public a()
        {
        }
    }


    private b a;
    private List b;
    private int c;

    private c(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = Math.max(a1.c, 1024);
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    public final byte[] a()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(c);
        a.a(bytearrayoutputstream);
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((com.shazam.h.e.b)iterator.next()).a(a)) { }
        a.c();
        return bytearrayoutputstream.toByteArray();
    }
}
