// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;

final class SharedPreferencesCollector
{

    SharedPreferencesCollector()
    {
    }

    public static String collect(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        TreeMap treemap = new TreeMap();
        treemap.put("default", PreferenceManager.getDefaultSharedPreferences(context));
        String as[] = ACRA.getConfig().additionalSharedPreferences();
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s1 = as[i];
                treemap.put(s1, context.getSharedPreferences(s1, 0));
            }

        }
        context = treemap.keySet().iterator();
        while (context.hasNext()) 
        {
            String s = (String)context.next();
            Object obj = (SharedPreferences)treemap.get(s);
            if (obj != null)
            {
                obj = ((SharedPreferences) (obj)).getAll();
                if (obj != null && ((Map) (obj)).size() > 0)
                {
                    Iterator iterator = ((Map) (obj)).keySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s2 = (String)iterator.next();
                        if (!filteredKey(s2))
                        {
                            if (((Map) (obj)).get(s2) != null)
                            {
                                stringbuilder.append(s).append('.').append(s2).append('=').append(((Map) (obj)).get(s2).toString()).append("\n");
                            } else
                            {
                                stringbuilder.append(s).append('.').append(s2).append('=').append("null\n");
                            }
                        }
                    } while (true);
                } else
                {
                    stringbuilder.append(s).append('=').append("empty\n");
                }
            } else
            {
                stringbuilder.append("null\n");
            }
            stringbuilder.append('\n');
        }
        return stringbuilder.toString();
    }

    private static boolean filteredKey(String s)
    {
        String as[] = ACRA.getConfig().excludeMatchingSharedPreferencesKeys();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (s.matches(as[i]))
            {
                return true;
            }
        }

        return false;
    }
}
