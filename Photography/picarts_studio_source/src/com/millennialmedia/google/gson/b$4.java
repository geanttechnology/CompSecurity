// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;

// Referenced classes of package com.millennialmedia.google.gson:
//            i, b

final class nit> extends i
{

    private com.millennialmedia.google.gson.b a;

    public final Object a(a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        } else
        {
            return Float.valueOf((float)a1.l());
        }
    }

    public final void a(b b1, Object obj)
    {
        obj = (Number)obj;
        if (obj == null)
        {
            b1.e();
            return;
        } else
        {
            com.millennialmedia.google.gson.b.a(((Number) (obj)).floatValue());
            b1.a(((Number) (obj)));
            return;
        }
    }

    am.b(com.millennialmedia.google.gson.b b1)
    {
        a = b1;
        super();
    }
}
