// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.country.json;

import java.util.Arrays;

public class Locales
{

    public String languages[];

    public Locales()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Locales)obj;
            if (!Arrays.equals(languages, ((Locales) (obj)).languages))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (languages != null)
        {
            return Arrays.hashCode(languages);
        } else
        {
            return 0;
        }
    }
}
