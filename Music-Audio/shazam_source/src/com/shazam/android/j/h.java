// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j;

import android.net.Uri;

// Referenced classes of package com.shazam.android.j:
//            o

public final class h
    implements o
{

    private final com.shazam.android.p.h a;

    public h(com.shazam.android.p.h h1)
    {
        a = h1;
    }

    public final String a(String s)
    {
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return null;
        } else
        {
            return s.replace("{devicemodel}", Uri.encode((new StringBuilder()).append(a.a()).append("_").append(a.b()).toString()));
        }
    }
}
