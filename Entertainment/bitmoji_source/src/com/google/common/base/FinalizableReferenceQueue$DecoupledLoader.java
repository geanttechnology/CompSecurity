// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.base:
//            FinalizableReferenceQueue

static class 
    implements 
{

    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

    URL getBaseUrl()
        throws IOException
    {
        String s = String.valueOf("com.google.common.base.internal.Finalizer".replace('.', '/')).concat(".class");
        URL url = getClass().getClassLoader().getResource(s);
        if (url == null)
        {
            throw new FileNotFoundException(s);
        }
        String s1 = url.toString();
        if (!s1.endsWith(s))
        {
            s = String.valueOf(s1);
            if (s.length() != 0)
            {
                s = "Unsupported path style: ".concat(s);
            } else
            {
                s = new String("Unsupported path style: ");
            }
            throw new IOException(s);
        } else
        {
            return new URL(url, s1.substring(0, s1.length() - s.length()));
        }
    }

    public Class loadFinalizer()
    {
        Class class1;
        try
        {
            class1 = newLoader(getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
        }
        catch (Exception exception)
        {
            FinalizableReferenceQueue.access$000().log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", exception);
            return null;
        }
        return class1;
    }

    URLClassLoader newLoader(URL url)
    {
        return new URLClassLoader(new URL[] {
            url
        }, null);
    }

    ()
    {
    }
}
