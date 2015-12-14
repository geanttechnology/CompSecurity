// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.stream;

import com.millennialmedia.google.gson.h;
import com.millennialmedia.google.gson.internal.c;
import java.util.Iterator;
import java.util.List;
import myobfuscated.ao.e;

// Referenced classes of package com.millennialmedia.google.gson.stream:
//            a, JsonToken

final class Token extends c
{

    public final void a(a a1)
    {
        if (a1 instanceof e)
        {
            a1 = (e)a1;
            a1.a(JsonToken.NAME);
            java.util.Entry entry = (java.util.Entry)((Iterator)a1.g()).next();
            ((e) (a1)).a.add(entry.getValue());
            ((e) (a1)).a.add(new h((String)entry.getKey()));
            return;
        }
        int j = com.millennialmedia.google.gson.stream.a.a(a1);
        int i = j;
        if (j == 0)
        {
            i = com.millennialmedia.google.gson.stream.a.b(a1);
        }
        if (i == 13)
        {
            com.millennialmedia.google.gson.stream.a.a(a1, 9);
            return;
        }
        if (i == 12)
        {
            com.millennialmedia.google.gson.stream.a.a(a1, 8);
            return;
        }
        if (i == 14)
        {
            com.millennialmedia.google.gson.stream.a.a(a1, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(a1.f()).append("  at line ").append(com.millennialmedia.google.gson.stream.a.c(a1)).append(" column ").append(com.millennialmedia.google.gson.stream.a.d(a1)).toString());
        }
    }

    Token()
    {
    }
}
