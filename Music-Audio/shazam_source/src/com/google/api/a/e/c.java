// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e;

import com.google.api.a.g.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

// Referenced classes of package com.google.api.a.e:
//            d, f

public abstract class c
{

    public c()
    {
    }

    public abstract d a(OutputStream outputstream, Charset charset);

    public abstract f a(InputStream inputstream);

    public abstract f a(InputStream inputstream, Charset charset);

    public abstract f a(String s);

    final String a(Object obj, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        d d1 = a(((OutputStream) (bytearrayoutputstream)), e.a);
        if (flag)
        {
            d1.g();
        }
        d1.a(false, obj);
        d1.a();
        return bytearrayoutputstream.toString("UTF-8");
    }
}
