// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;


// Referenced classes of package com.millennialmedia.google.gson.internal:
//            i

final class e
{

    private i a;

    e()
    {
    }

    public final i a()
    {
        i i1 = a;
        if (i1 == null)
        {
            return null;
        }
        i k = i1.a;
        i1.a = null;
        i l;
        for (i j = i1.c; j != null; j = l)
        {
            j.a = k;
            l = j.b;
            k = j;
        }

        a = k;
        return i1;
    }

    final void a(i j)
    {
        i k = null;
        i l;
        for (; j != null; j = l)
        {
            j.a = k;
            l = j.b;
            k = j;
        }

        a = k;
    }
}
