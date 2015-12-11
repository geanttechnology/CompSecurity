// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.Properties;

// Referenced classes of package org.apache.commons.logging:
//            LogFactory

class val.url
    implements PrivilegedAction
{

    private final URL val$url;

    public Object run()
    {
        InputStream inputstream = val$url.openStream();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        Properties properties;
        properties = new Properties();
        properties.load(inputstream);
        inputstream.close();
        return properties;
        IOException ioexception;
        ioexception;
        if (LogFactory.isDiagnosticsEnabled())
        {
            LogFactory.access$000("Unable to read URL " + val$url);
        }
        return null;
    }

    ()
    {
        val$url = url1;
    }
}
