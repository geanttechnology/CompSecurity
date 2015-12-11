// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.net.URLConnection;

// Referenced classes of package com.shazam.h:
//            n

public final class aa
    implements n
{

    public aa()
    {
    }

    public final void a(URLConnection urlconnection)
    {
        urlconnection.setRequestProperty("User-Agent", String.format("%s Shazam/v%s", new Object[] {
            System.getProperty("http.agent"), "5.12.1"
        }));
    }
}
