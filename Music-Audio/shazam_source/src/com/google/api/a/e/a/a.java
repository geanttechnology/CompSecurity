// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e.a;

import com.google.api.a.e.c;
import com.google.api.a.e.d;
import com.google.api.a.e.f;
import com.google.api.a.g.e;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

// Referenced classes of package com.google.api.a.e.a:
//            c, b

public final class com.google.api.a.e.a.a extends c
{
    public static final class a
    {

        public static final com.google.api.a.e.a.a a = new com.google.api.a.e.a.a();

    }


    public com.google.api.a.e.a.a()
    {
    }

    private f a(Reader reader)
    {
        return new com.google.api.a.e.a.c(this, new com.google.b.d.a(reader));
    }

    public final d a(OutputStream outputstream, Charset charset)
    {
        return new b(this, new com.google.b.d.c(new OutputStreamWriter(outputstream, charset)));
    }

    public final f a(InputStream inputstream)
    {
        return a(((Reader) (new InputStreamReader(inputstream, e.a))));
    }

    public final f a(InputStream inputstream, Charset charset)
    {
        if (charset == null)
        {
            return a(inputstream);
        } else
        {
            return a(((Reader) (new InputStreamReader(inputstream, charset))));
        }
    }

    public final f a(String s)
    {
        return a(((Reader) (new StringReader(s))));
    }
}
