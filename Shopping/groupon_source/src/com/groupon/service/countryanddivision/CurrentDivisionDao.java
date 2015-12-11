// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.SharedPreferences;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.models.division.Division;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.GeoPoint;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class CurrentDivisionDao
{

    private static final String CURRENT_DIVISION_DATA = "currentDivisionData";
    private static final String CURRENT_DIVISION_DATA_TIMESTAMP = "currentDivisionTimeStamp";
    public static final Division DEFAULT_DIVISION = new Division() {

            
            {
                latE6 = CurrentDivisionDao.DEFAULT_LOCATION.getLatitudeE6();
                lngE6 = CurrentDivisionDao.DEFAULT_LOCATION.getLongitudeE6();
                geoPoint = new GeoPoint((int)latE6, (int)lngE6);
            }
    };
    private static final GeoPoint DEFAULT_LOCATION = new GeoPoint(0x27f4cf0, 0xfac6acec);
    private Application application;
    protected ObjectMapperWrapper objectMapper;

    public CurrentDivisionDao()
    {
    }

    private ArraySharedPreferences getLocationPrefs()
    {
        return (ArraySharedPreferences)RoboGuice.getInjector(application).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("localizedStore")));
    }

    public void clearDivision()
    {
        ArraySharedPreferences arraysharedpreferences = getLocationPrefs();
        if (arraysharedpreferences != null)
        {
            arraysharedpreferences.edit().remove("currentDivisionData").remove("currentDivisionTimeStamp").apply();
        }
    }

    public void clearTimeStamp()
    {
        ArraySharedPreferences arraysharedpreferences = getLocationPrefs();
        if (arraysharedpreferences != null)
        {
            arraysharedpreferences.edit().remove("currentDivisionTimeStamp").apply();
        }
    }

    public long getLastTimeStamp()
    {
        long l = -1L;
        ArraySharedPreferences arraysharedpreferences = getLocationPrefs();
        if (arraysharedpreferences != null)
        {
            l = arraysharedpreferences.getLong("currentDivisionTimeStamp", -1L);
        }
        return l;
    }

    public Division loadDivision()
    {
        ArraySharedPreferences arraysharedpreferences = getLocationPrefs();
        if (arraysharedpreferences == null)
        {
            return DEFAULT_DIVISION;
        }
        Object obj = arraysharedpreferences.getString("currentDivisionData", null);
        if (obj == null)
        {
            return DEFAULT_DIVISION;
        }
        try
        {
            obj = (Division)objectMapper.readValue(((String) (obj)), com/groupon/models/division/Division);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException("Impossible to read division as JSON.", ioexception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        Ln.d("Impossible to read division from shared prefs. Resetting it.", new Object[0]);
        arraysharedpreferences.edit().remove("currentDivisionData").apply();
        return DEFAULT_DIVISION;
        obj.geoPoint = new GeoPoint((int)((Division) (obj)).latE6, (int)((Division) (obj)).lngE6);
        return ((Division) (obj));
    }

    public void saveDivision(Division division)
    {
        ArraySharedPreferences arraysharedpreferences = getLocationPrefs();
        try
        {
            arraysharedpreferences.edit().putString("currentDivisionData", objectMapper.writeValueAsString(division)).putLong("currentDivisionTimeStamp", System.currentTimeMillis()).apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Division division)
        {
            Ln.e("Impossible to write current division", new Object[] {
                division
            });
        }
    }


}
