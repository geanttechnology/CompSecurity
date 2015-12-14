// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;

// Referenced classes of package com.millennialmedia.google.gson:
//            i, b

final class am.b extends i
{

    public final Object a(a a1)
    {
        if (a1.f() == JsonToken.NULL)
        {
            a1.k();
            return null;
        } else
        {
            return Long.valueOf(a1.m());
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
            b1.b(obj.toString());
            return;
        }
    }

    am.b()
    {
    }
}
