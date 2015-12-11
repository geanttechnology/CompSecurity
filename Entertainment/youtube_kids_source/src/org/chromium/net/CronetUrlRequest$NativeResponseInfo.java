// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


// Referenced classes of package org.chromium.net:
//            ResponseInfo

final class b
    implements ResponseInfo
{

    private final int a;
    private final String b;
    private final b c = new b();

    static b a(b b1)
    {
        return b1.c;
    }

    public final int a()
    {
        return a;
    }

    public final String b()
    {
        return b;
    }

    (String as[], int i, String s, boolean flag, String s1)
    {
        a = i;
        b = s;
    }
}
