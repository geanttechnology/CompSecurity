// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.ads.internal:
//            f

class 
    implements 
{

    public HttpURLConnection a(URL url)
        throws IOException
    {
        return (HttpURLConnection)url.openConnection();
    }

    ()
    {
    }
}
