// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;

import com.target.mothership.util.o;

public final class e extends Enum
{

    private static final e $VALUES[];
    private static final String ACTIVE = "active";
    public static final e Active;
    private static final String INACTIVE = "Inactive";
    public static final e Inactive;
    public static final e Unknown;

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e a(String s)
    {
        if (!o.g(s))
        {
            return Unknown;
        }
        if (s.equalsIgnoreCase("active"))
        {
            return Active;
        }
        if (s.equalsIgnoreCase("Inactive"))
        {
            return Inactive;
        } else
        {
            return Unknown;
        }
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/target/mothership/common/a/e, s);
    }

    public static e[] values()
    {
        return (e[])$VALUES.clone();
    }

    static 
    {
        Active = new e("Active", 0);
        Inactive = new e("Inactive", 1);
        Unknown = new e("Unknown", 2);
        $VALUES = (new e[] {
            Active, Inactive, Unknown
        });
    }
}
