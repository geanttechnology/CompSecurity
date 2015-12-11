// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.country.Country;
import com.groupon.models.division.City;
import com.groupon.models.division.Division;
import com.groupon.models.division.converter.DivisionConverter;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.Dates;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.type.TypeReference;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CurrentDivisionManager, CurrentCountryManager

public class DivisionsService
{

    private static final String PREF_KEY_DIVISION_SERVICE_TIMESTAMP = "DivisionsServiceTimestamp";
    private Application application;
    private Lazy currentCountryManager;
    private Lazy currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;
    private Lazy divisionConverter;
    private ArraySharedPreferences divisionServiceSharedPreferences;
    private List divisions;
    protected ObjectMapperWrapper objectMapper;

    public DivisionsService()
    {
    }

    private void cacheToMemory()
    {
        Object obj = divisionServiceSharedPreferences.getString("DivisionServiceV2", null);
        if (obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            divisions = (List)objectMapper.readValue(((String) (obj)), new TypeReference() {

                final DivisionsService this$0;

            
            {
                this$0 = DivisionsService.this;
                super();
            }
            });
            obj = divisions.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Division division = (Division)((Iterator) (obj)).next();
                division.geoPoint = new GeoPoint((int)division.latE6, (int)division.lngE6);
            }
        }
        catch (IOException ioexception)
        {
            Ln.e(ioexception, "Error deserializing divisions from preferences", new Object[0]);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void doUpdateCurrentDivision()
    {
        if (((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision() != null)
        {
            Division division1 = ((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision();
            Iterator iterator = divisions.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Division division = (Division)iterator.next();
                if (Strings.equalsIgnoreCase(division.id, division1.id))
                {
                    Object obj = division;
                    if (division1 instanceof City)
                    {
                        obj = new City(division, division1.name);
                    }
                    ((CurrentDivisionManager)currentDivisionManager.get()).setCurrentDivision(((Division) (obj)));
                }
            } while (true);
        }
    }

    private void init()
    {
        currentCountryManager = new Lazy(application) {

            final DivisionsService this$0;

            
            {
                this$0 = DivisionsService.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(application) {

            final DivisionsService this$0;

            
            {
                this$0 = DivisionsService.this;
                super(context);
            }
        };
        divisionConverter = new Lazy(application) {

            final DivisionsService this$0;

            
            {
                this$0 = DivisionsService.this;
                super(context);
            }
        };
    }

    public void clearAllDivisions()
    {
        if (divisions != null)
        {
            divisions.clear();
        }
        divisionServiceSharedPreferences.edit().remove("DivisionsServiceTimestamp").apply();
    }

    public void clearTimeStamp()
    {
        divisionServiceSharedPreferences.edit().remove("DivisionsServiceTimestamp").apply();
    }

    public Division getDivisionFromServerById(String s)
        throws Exception
    {
        for (Iterator iterator = getDivisionsFromServer().iterator(); iterator.hasNext();)
        {
            Division division = (Division)iterator.next();
            if (Strings.equals(division.id, s))
            {
                return division;
            }
        }

        Ln.d((new StringBuilder()).append("Unable to find division '").append(s).append("' in the /divisions response").toString(), new Object[0]);
        return null;
    }

    public Collection getDivisions()
    {
        if (divisions == null)
        {
            cacheToMemory();
        }
        if (divisions != null)
        {
            return divisions;
        } else
        {
            return Collections.emptyList();
        }
    }

    public List getDivisionsFromServer()
        throws Exception
    {
        Object obj = new ArrayList();
        ((List) (obj)).addAll(Arrays.asList(new Serializable[] {
            "lang", deviceInfoUtil.getLanguageFromLocale(), "show_areas", Boolean.valueOf(true)
        }));
        if (((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isJapan())
        {
            ((List) (obj)).addAll(Arrays.asList(new String[] {
                "show", "default"
            }));
        }
        obj = (String)(new SyncHttp(application, java/lang/String, "/divisions", ((List) (obj)).toArray())).call();
        return ((DivisionConverter)divisionConverter.get()).fromJson((com.groupon.models.division.json.Division.List)objectMapper.readValue(((String) (obj)), com/groupon/models/division/json/Division$List));
    }

    public boolean isUpToDate()
    {
        return Dates.isToday(divisionServiceSharedPreferences.getLong("DivisionsServiceTimestamp", 0L));
    }

    public void refresh()
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        divisions = getDivisionsFromServer();
        doUpdateCurrentDivision();
        String s = objectMapper.writeValueAsString(divisions);
        divisionServiceSharedPreferences.edit().putLong("DivisionsServiceTimestamp", System.currentTimeMillis()).putString("DivisionServiceV2", s).apply();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
