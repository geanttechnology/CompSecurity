// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;

// Referenced classes of package com.millennialmedia.google.gson:
//            i

final class c extends i
{

    i a;

    c()
    {
    }

    public final Object a(a a1)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            return a.a(a1);
        }
    }

    public final void a(b b, Object obj)
    {
        if (a == null)
        {
            throw new IllegalStateException();
        } else
        {
            a.a(b, obj);
            return;
        }
    }
}
