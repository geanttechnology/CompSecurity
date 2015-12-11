// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;


// Referenced classes of package com.tremorvideo.sdk.android.e:
//            m

class o extends m
{

    private final p.l a;

    o(p.l l)
    {
        a = l;
    }

    public static o a(p.l l)
    {
        return new o(l);
    }

    public String a()
    {
        return (new StringBuilder()).append("state: '").append(a.toString().toLowerCase()).append("'").toString();
    }
}
