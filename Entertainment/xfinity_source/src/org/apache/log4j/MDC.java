// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.ThreadLocalMap;

public class MDC
{

    static final MDC mdc = new MDC();
    boolean java1;
    Object tlm;

    private MDC()
    {
        java1 = Loader.isJava1();
        if (!java1)
        {
            tlm = new ThreadLocalMap();
        }
    }

    public static Object get(String s)
    {
        if (mdc != null)
        {
            return mdc.get0(s);
        } else
        {
            return null;
        }
    }

    private Object get0(String s)
    {
        if (java1 || tlm == null)
        {
            return null;
        }
        Hashtable hashtable = (Hashtable)((ThreadLocalMap)tlm).get();
        if (hashtable != null && s != null)
        {
            return hashtable.get(s);
        } else
        {
            return null;
        }
    }

    public static Hashtable getContext()
    {
        if (mdc != null)
        {
            return mdc.getContext0();
        } else
        {
            return null;
        }
    }

    private Hashtable getContext0()
    {
        if (java1 || tlm == null)
        {
            return null;
        } else
        {
            return (Hashtable)((ThreadLocalMap)tlm).get();
        }
    }

}
