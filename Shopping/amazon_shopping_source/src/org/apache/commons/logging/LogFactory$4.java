// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.io.IOException;
import java.security.PrivilegedAction;

// Referenced classes of package org.apache.commons.logging:
//            LogFactory

class val.name
    implements PrivilegedAction
{

    private final ClassLoader val$loader;
    private final String val$name;

    public Object run()
    {
        java.util.Enumeration enumeration;
        try
        {
            if (val$loader != null)
            {
                return val$loader.getResources(val$name);
            }
            enumeration = ClassLoader.getSystemResources(val$name);
        }
        catch (IOException ioexception)
        {
label0:
            {
                if (LogFactory.isDiagnosticsEnabled())
                {
                    LogFactory.access$000("Exception while trying to find configuration file " + val$name + ":" + ioexception.getMessage());
                    return null;
                }
                break label0;
            }
        }
        catch (NoSuchMethodError nosuchmethoderror)
        {
            return null;
        }
        return enumeration;
    }

    ()
    {
        val$loader = classloader;
        val$name = s;
    }
}
