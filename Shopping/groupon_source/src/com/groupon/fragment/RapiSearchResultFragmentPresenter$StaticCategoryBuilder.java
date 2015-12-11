// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragmentPresenter

private static class categoryMap
{

    private Map categoryMap;
    private Resources resources;

    public List buildCategorySectionArray()
    {
        ArrayList arraylist = new ArrayList();
        String s;
        for (Iterator iterator = categoryMap.keySet().iterator(); iterator.hasNext(); arraylist.add(new categoryMap(s, (String)categoryMap.get(s))))
        {
            s = (String)iterator.next();
        }

        return arraylist;
    }

    public List buildHourIntervals()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 24);
        calendar.set(12, 0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("h:mm a");
        ArrayList arraylist = new ArrayList();
        arraylist.add(new categoryMap(resources.getString(0x7f0802fd), null));
        for (int i = 0; i < 24; i++)
        {
            Date date = calendar.getTime();
            arraylist.add(new resources(simpledateformat.format(date), Long.toString(date.getTime())));
            calendar.add(10, 1);
        }

        return arraylist;
    }

    public List buildNPeopleArray(int i)
    {
        ArrayList arraylist = new ArrayList();
        for (int j = 1; j <= i; j++)
        {
            arraylist.add(new resources(resources.getQuantityString(0x7f0c0015, j, new Object[] {
                Integer.valueOf(j)
            }), Integer.toString(j)));
        }

        return arraylist;
    }

    public List buildNextNDays(int i)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat simpledateformat = new SimpleDateFormat("E, MMM d");
        ArrayList arraylist = new ArrayList();
        int j = 0;
        while (j < i) 
        {
            resources resources1 = new resources();
            Date date = calendar.getTime();
            resources1.resources = Long.toString(date.getTime());
            if (j == 0)
            {
                resources1. = resources.getString(0x7f0803e0);
            } else
            {
                resources1. = simpledateformat.format(date);
            }
            arraylist.add(resources1);
            calendar.add(5, 1);
            j++;
        }
        return arraylist;
    }

    public List buildPartialHourIntervals()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(12, 0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("h:mm a");
        ArrayList arraylist = new ArrayList();
        arraylist.add(new (resources.getString(0x7f0802fd), null));
        for (int i = calendar.get(11); i < 24; i++)
        {
            Date date = calendar.getTime();
            arraylist.add(new resources(simpledateformat.format(date), Long.toString(date.getTime())));
            calendar.add(10, 1);
        }

        return arraylist;
    }

    public String getCategoryString(String s)
    {
label0:
        {
            if (!categoryMap.containsValue(s))
            {
                break label0;
            }
            Iterator iterator = categoryMap.keySet().iterator();
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s1 = (String)iterator.next();
            } while (!((String)categoryMap.get(s1)).equals(s));
            return s1;
        }
        return "";
    }

    public (Resources resources1)
    {
        categoryMap = new LinkedHashMap();
        resources = resources1;
        categoryMap.put(resources1.getString(0x7f0801b5), "all");
        categoryMap.put(resources1.getString(0x7f0801b6), "beauty-and-spas");
        categoryMap.put(resources1.getString(0x7f0801b7), "skin-care");
        categoryMap.put(resources1.getString(0x7f0801b8), "hair-removal");
        categoryMap.put(resources1.getString(0x7f0801b9), "hair-salons");
        categoryMap.put(resources1.getString(0x7f0801ba), "massage");
        categoryMap.put(resources1.getString(0x7f0801bb), "nail-salons");
    }
}
