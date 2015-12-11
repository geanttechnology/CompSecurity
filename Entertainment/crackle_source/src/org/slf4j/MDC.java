// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;

import java.util.Map;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

public class MDC
{

    private static MDCAdapter a;

    private MDC()
    {
    }

    public static void clear()
    {
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            a.clear();
            return;
        }
    }

    public static String get(String s)
        throws IllegalArgumentException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            return a.get(s);
        }
    }

    public static Map getCopyOfContextMap()
    {
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            return a.getCopyOfContextMap();
        }
    }

    public static MDCAdapter getMDCAdapter()
    {
        return a;
    }

    public static void put(String s, String s1)
        throws IllegalArgumentException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            a.put(s, s1);
            return;
        }
    }

    public static void remove(String s)
        throws IllegalArgumentException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            a.remove(s);
            return;
        }
    }

    public static void setContextMap(Map map)
    {
        if (a == null)
        {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        } else
        {
            a.setContextMap(map);
            return;
        }
    }

    static 
    {
        try
        {
            a = StaticMDCBinder.SINGLETON.getMDCA();
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            String s = noclassdeffounderror.getMessage();
            if (s != null && s.indexOf("org/slf4j/impl/StaticMDCBinder") != -1)
            {
                Util.reportFailure("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                Util.reportFailure("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
            }
            throw noclassdeffounderror;
        }
        catch (Exception exception)
        {
            Util.reportFailure((new StringBuilder()).append("Could not bind with an instance of class [").append(StaticMDCBinder.SINGLETON.getMDCAdapterClassStr()).append("]").toString(), exception);
        }
    }
}
