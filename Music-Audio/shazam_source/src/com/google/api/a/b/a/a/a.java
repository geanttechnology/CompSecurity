// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.b.a.a;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.api.a.e.c;
import com.google.api.a.e.d;
import com.google.api.a.e.f;
import com.google.api.a.g.e;
import com.google.api.a.g.w;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

// Referenced classes of package com.google.api.a.b.a.a:
//            c, b

public final class a extends c
{

    public a()
    {
        w.a(com.google.api.a.b.a.a.a(11), "running on Android SDK level %s but requires minimum %s", new Object[] {
            Integer.valueOf(android.os.Build.VERSION.SDK_INT), Integer.valueOf(11)
        });
    }

    private f a(Reader reader)
    {
        return new com.google.api.a.b.a.a.c(this, new JsonReader(reader));
    }

    public final d a(OutputStream outputstream, Charset charset)
    {
        return new b(this, new JsonWriter(new OutputStreamWriter(outputstream, charset)));
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
