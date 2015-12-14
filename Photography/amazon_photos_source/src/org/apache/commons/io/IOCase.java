// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.Serializable;

// Referenced classes of package org.apache.commons.io:
//            FilenameUtils

public final class IOCase
    implements Serializable
{

    public static final IOCase INSENSITIVE = new IOCase("Insensitive", false);
    public static final IOCase SENSITIVE = new IOCase("Sensitive", true);
    public static final IOCase SYSTEM;
    private final String name;
    private final transient boolean sensitive;

    private IOCase(String s, boolean flag)
    {
        name = s;
        sensitive = flag;
    }

    public boolean checkEquals(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new NullPointerException("The strings must not be null");
        }
        if (sensitive)
        {
            return s.equals(s1);
        } else
        {
            return s.equalsIgnoreCase(s1);
        }
    }

    public boolean checkStartsWith(String s, String s1)
    {
        boolean flag;
        if (!sensitive)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return s.regionMatches(flag, 0, s1, 0, s1.length());
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        boolean flag = true;
        if (FilenameUtils.isSystemWindows())
        {
            flag = false;
        }
        SYSTEM = new IOCase("System", flag);
    }
}
