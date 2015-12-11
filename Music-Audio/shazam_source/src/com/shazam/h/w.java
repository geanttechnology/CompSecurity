// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.shazam.h:
//            q

public final class w
    implements q
{

    public w()
    {
    }

    public final HttpURLConnection a(URL url)
    {
        return (HttpURLConnection)url.openConnection();
    }
}
