// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.foundation.utils.log.LogOverrider;
import java.util.logging.Level;

public class ThorLogOverride
    implements LogOverrider
{

    private static final int MAX_LENGTH = 31 - "log.tag.".length();

    public ThorLogOverride()
    {
    }

    private String getPropertyKey(String s)
    {
        int i = s.lastIndexOf(".") + 1;
        if (s.length() - i > MAX_LENGTH)
        {
            return (new StringBuilder()).append("log.tag.").append(s.substring(i, MAX_LENGTH + i)).toString();
        } else
        {
            return (new StringBuilder()).append("log.tag.").append(s.substring(i)).toString();
        }
    }

    public Level getOverrideLevel(String s)
    {
        s = System.getProperty(getPropertyKey(s), "");
        if (s != null && !s.equals(""))
        {
            if (s.equals("VERBOSE"))
            {
                return Level.ALL;
            }
            if (s.equals("DEBUG"))
            {
                return Level.FINE;
            }
            if (s.equals("INFO"))
            {
                return Level.INFO;
            }
            if (s.equals("WARN"))
            {
                return Level.WARNING;
            }
            if (s.equals("ERROR"))
            {
                return Level.SEVERE;
            }
        }
        return null;
    }

}
