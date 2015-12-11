// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.b.a.a;

import android.util.JsonWriter;
import com.google.api.a.e.d;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.google.api.a.b.a.a:
//            a

final class b extends d
{

    private final JsonWriter a;
    private final a b;

    b(a a1, JsonWriter jsonwriter)
    {
        b = a1;
        a = jsonwriter;
        jsonwriter.setLenient(true);
    }

    public final void a()
    {
        a.flush();
    }

    public final void a(double d1)
    {
        a.value(d1);
    }

    public final void a(float f1)
    {
        a.value(f1);
    }

    public final void a(int i)
    {
        a.value(i);
    }

    public final void a(long l)
    {
        a.value(l);
    }

    public final void a(String s)
    {
        a.name(s);
    }

    public final void a(BigDecimal bigdecimal)
    {
        a.value(bigdecimal);
    }

    public final void a(BigInteger biginteger)
    {
        a.value(biginteger);
    }

    public final void a(boolean flag)
    {
        a.value(flag);
    }

    public final void b()
    {
        a.endArray();
    }

    public final void b(String s)
    {
        a.value(s);
    }

    public final void c()
    {
        a.endObject();
    }

    public final void d()
    {
        a.nullValue();
    }

    public final void e()
    {
        a.beginArray();
    }

    public final void f()
    {
        a.beginObject();
    }

    public final void g()
    {
        a.setIndent("  ");
    }
}
