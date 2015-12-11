// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;


// Referenced classes of package com.tremorvideo.sdk.android.e:
//            m

class l extends m
{

    private final p.k a;

    l(p.k k)
    {
        a = k;
    }

    public static l a(p.k k)
    {
        return new l(k);
    }

    public String a()
    {
        return (new StringBuilder()).append("placementType: '").append(a.toString().toLowerCase()).append("'").toString();
    }
}
