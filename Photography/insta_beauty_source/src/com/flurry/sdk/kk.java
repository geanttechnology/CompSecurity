// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.flurry.sdk:
//            jy, lb, kg, kz, 
//            kx

public class kk
{

    private static final String a = com/flurry/sdk/kk.getSimpleName();
    private static final byte b[] = {
        113, -92, -8, 125, 121, 107, -65, -61, -74, -114, 
        -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, 
        -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, 
        -27, -64
    };
    private String c;
    private lb d;

    public kk(String s, lb lb1)
    {
        c = s;
        d = lb1;
    }

    public static void a(byte abyte0[])
    {
        if (abyte0 != null)
        {
            int j = abyte0.length;
            int k = b.length;
            int i = 0;
            while (i < j) 
            {
                abyte0[i] = (byte)(abyte0[i] ^ b[i % k] ^ (i * 31) % 251);
                i++;
            }
        }
    }

    public static void b(byte abyte0[])
    {
        a(abyte0);
    }

    public static int c(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return 0;
        } else
        {
            jy jy1 = new jy();
            jy1.update(abyte0);
            return jy1.b();
        }
    }

    public byte[] a(Object obj)
    {
        if (obj == null)
        {
            throw new IOException((new StringBuilder()).append("Encoding: ").append(c).append(": Nothing to encode").toString());
        } else
        {
            Object obj1 = new ByteArrayOutputStream();
            d.a(((java.io.OutputStream) (obj1)), obj);
            obj = ((ByteArrayOutputStream) (obj1)).toByteArray();
            kg.a(3, a, (new StringBuilder()).append("Encoding ").append(c).append(": ").append(new String(((byte []) (obj)))).toString());
            obj1 = new kz(new kx());
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ((lb) (obj1)).a(bytearrayoutputstream, obj);
            obj = bytearrayoutputstream.toByteArray();
            a(((byte []) (obj)));
            return ((byte []) (obj));
        }
    }

    public Object d(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IOException((new StringBuilder()).append("Decoding: ").append(c).append(": Nothing to decode").toString());
        } else
        {
            b(abyte0);
            abyte0 = (byte[])(new kz(new kx())).b(new ByteArrayInputStream(abyte0));
            kg.a(3, a, (new StringBuilder()).append("Decoding: ").append(c).append(": ").append(new String(abyte0)).toString());
            abyte0 = new ByteArrayInputStream(abyte0);
            return d.b(abyte0);
        }
    }

}
