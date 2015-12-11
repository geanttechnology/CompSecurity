// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.models.country.json.Locales;
import java.util.ArrayList;

public class Locale
{
    public static class List extends ArrayList
    {

        public List(Locales locales)
        {
            locales = locales.languages;
            int j = locales.length;
            for (int i = 0; i < j; i++)
            {
                add(new Locale(locales[i]));
            }

        }
    }


    public String language;

    public Locale()
    {
    }

    public Locale(String s)
    {
        language = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Locale)obj;
            if (language == null ? ((Locale) (obj)).language != null : !language.equals(((Locale) (obj)).language))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        if (language != null)
        {
            return language.hashCode();
        } else
        {
            return 0;
        }
    }
}
