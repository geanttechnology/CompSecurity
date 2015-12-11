// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;


// Referenced classes of package com.tremorvideo.sdk.android.e:
//            m

class n extends m
{

    private final int a;
    private final int b;

    n(int i, int j)
    {
        a = i;
        b = j;
    }

    public static n a(int i, int j)
    {
        return new n(i, j);
    }

    public String a()
    {
        return (new StringBuilder()).append("screenSize: { width: ").append(a).append(", height: ").append(b).append(" }").toString();
    }
}
