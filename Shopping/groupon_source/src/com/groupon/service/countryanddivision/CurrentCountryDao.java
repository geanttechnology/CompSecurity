// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.content.SharedPreferences;
import com.groupon.models.country.Country;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Ln;

public class CurrentCountryDao
{

    public static final String CURRENT_COUNTRY_DATA = "currentCountryData";
    private static final String CURRENT_COUNTRY_DATA_V2 = "currentCountryDataV2";
    private static final String CURRENT_COUNTRY_ISO_NAME = "currentCountryIsoName";
    private static final String CURRENT_COUNTRY_LAST_UPDATE_TIME = "currentCountryLastUpdateTime";
    public static final String CURRENT_COUNTRY_SHORTNAME = "currentCountryShortname";
    private ObjectMapper objectMapperForJson;
    private SharedPreferences sharedPreferences;

    public CurrentCountryDao()
    {
    }

    public void clearCountry()
    {
        sharedPreferences.edit().putString("currentCountryDataV2", null).putLong("currentCountryLastUpdateTime", 0L).putString("currentCountryShortname", null).putString("currentCountryIsoName", null).apply();
    }

    public void clearTimeStamp()
    {
        sharedPreferences.edit().remove("currentCountryLastUpdateTime").apply();
    }

    public long getLastTimeStamp()
    {
        return sharedPreferences.getLong("currentCountryLastUpdateTime", 0L);
    }

    public void init()
    {
        objectMapperForJson.enableDefaultTyping();
    }

    public Country loadCountry()
    {
        Country country = null;
        String s = sharedPreferences.getString("currentCountryDataV2", null);
        if (s != null)
        {
            try
            {
                country = (Country)objectMapperForJson.readValue(s, com/groupon/models/country/Country);
            }
            catch (IOException ioexception)
            {
                throw new RuntimeException((new StringBuilder()).append("Impossible to read country from preferences. Country stored:").append(s).append(".").toString(), ioexception);
            }
        }
        return country;
    }

    public void saveCountry(Country country)
    {
        Ln.d("Storing current country data: %s", new Object[] {
            country
        });
        try
        {
            String s = objectMapperForJson.writeValueAsString(country);
            sharedPreferences.edit().putString("currentCountryDataV2", s).putLong("currentCountryLastUpdateTime", System.currentTimeMillis()).putString("currentCountryShortname", country.shortName).putString("currentCountryIsoName", country.isoName).apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Country country)
        {
            Ln.e(country, "Impossible to write country as JSON.", new Object[0]);
        }
    }
}
