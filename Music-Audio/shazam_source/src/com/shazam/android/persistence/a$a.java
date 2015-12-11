// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence;


// Referenced classes of package com.shazam.android.persistence:
//            a

static final class c
{

    final String a;
    final int b;
    final String c;

    public final String toString()
    {
        return (new StringBuilder("PathInfo{path='")).append(a).append('\'').append(", code=").append(b).append(", contentType='").append(c).append('\'').append('}').toString();
    }

    (String s, int i, String s1)
    {
        a = s;
        b = i;
        c = s1;
    }
}
