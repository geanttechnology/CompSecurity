// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.net.URLConnection;

// Referenced classes of package com.shazam.h:
//            n

public final class g
    implements n
{

    private final String b;
    private final String c;

    public g(String s, String s1)
    {
        b = s;
        c = s1;
    }

    public final void a(URLConnection urlconnection)
    {
        urlconnection.addRequestProperty(b, c);
    }
}
