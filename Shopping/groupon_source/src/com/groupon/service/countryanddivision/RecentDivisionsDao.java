// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.models.division.Division;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class RecentDivisionsDao
{

    private static final String RECENT_CITIES_V2 = "recentCities_v2";
    private static final int RECENT_DIVISION_LIST_MAX_SIZE = 5;
    private Application application;
    protected ObjectMapperWrapper objectMapper;

    public RecentDivisionsDao()
    {
    }

    private ArraySharedPreferences getLocationPrefs()
    {
        return (ArraySharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("localizedStore")));
    }

    private void writeRecentDivisions(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext();)
        {
            Division division = (Division)list.next();
            try
            {
                arraylist.add(objectMapper.writeValueAsString(division));
            }
            catch (IOException ioexception)
            {
                Ln.d(ioexception, (new StringBuilder()).append("Impossible to create json string from division in shared prefs: ").append(division.id).toString(), new Object[0]);
            }
        }

        try
        {
            getLocationPrefs().edit().putListString("recentCities_v2", arraylist).apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Ln.e(list, "Impossible to write recent cities in shared prefs.", new Object[0]);
        }
    }

    public void addRecentDivision(Division division)
    {
        List list1 = getRecentDivisions();
        if (!list1.contains(division)) goto _L2; else goto _L1
_L1:
        List list;
        list1.remove(division);
        list = list1;
_L4:
        list.add(0, division);
        writeRecentDivisions(list);
        return;
_L2:
        list = list1;
        if (list1.size() >= 5)
        {
            list = list1.subList(0, 4);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getRecentDivisions()
    {
        ArrayList arraylist;
        Iterator iterator;
        List list = getLocationPrefs().getListString("recentCities_v2", new ArrayList());
        arraylist = new ArrayList(list.size());
        iterator = list.iterator();
_L2:
        Object obj = arraylist;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        arraylist.add((Division)objectMapper.readValue(((String) (obj)), com/groupon/models/division/Division));
        if (true) goto _L2; else goto _L1
        obj;
        Ln.d(((Throwable) (obj)), "Impossible to read divisions in shared prefs", new Object[0]);
        obj = null;
_L1:
        return ((List) (obj));
    }
}
