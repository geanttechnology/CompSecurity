// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.chromium.net.UrlRequestContext;

// Referenced classes of package org.chromium.net.urlconnection:
//            CronetHttpURLStreamHandler

public class CronetURLStreamHandlerFactory
    implements URLStreamHandlerFactory
{

    private final UrlRequestContext a;

    public URLStreamHandler createURLStreamHandler(String s)
    {
        if ("http".equals(s) || "https".equals(s))
        {
            return new CronetHttpURLStreamHandler(a);
        } else
        {
            return null;
        }
    }
}
