// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.SearchParameters;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ff, aqo, dk, ir, 
//            gd, gf

public class fu extends ff
{

    public fu()
    {
    }

    private List a(int i, double d, double d1, SearchParameters searchparameters, int j, 
            String s, String s1)
    {
        double d2;
        double d3;
        Object obj;
        String s2;
        Integer integer;
        String s3;
        Float float1;
        Float float2;
        Object obj1;
        if (searchparameters == null)
        {
            obj = null;
        } else
        {
            obj = searchparameters.toString();
        }
        aqo.a("getJsonUrl searchParameters %s", new Object[] {
            obj
        });
        if (searchparameters == null)
        {
            d3 = 4.9406564584124654E-324D;
        } else
        {
            d3 = searchparameters.getLatitude();
        }
        if (searchparameters == null)
        {
            d2 = 4.9406564584124654E-324D;
        } else
        {
            d2 = searchparameters.getLongitude();
        }
        if (d3 == 4.9406564584124654E-324D)
        {
            d3 = d;
        }
        if (d2 == 4.9406564584124654E-324D)
        {
            d2 = d1;
        }
        if (searchparameters == null)
        {
            obj = null;
        } else
        {
            obj = searchparameters.getCategoryIdsAsString();
        }
        if (searchparameters == null)
        {
            s2 = SearchParameters.DEFAULT_SELECTED_SORT_BY.getStringEnumForRequest();
        } else
        {
            s2 = searchparameters.getSortBy().getStringEnumForRequest();
        }
        if (searchparameters == null)
        {
            integer = null;
        } else
        {
            integer = Integer.valueOf(searchparameters.getDistance().getQueryValue());
        }
        if (searchparameters == null || TextUtils.isEmpty(searchparameters.getQuery()))
        {
            s3 = null;
        } else
        {
            s3 = searchparameters.getQuery();
        }
        float2 = null;
        float1 = float2;
        if (searchparameters != null)
        {
            float1 = float2;
            if (searchparameters.getPriceFrom() > -1F)
            {
                float1 = Float.valueOf(searchparameters.getPriceFrom());
            }
        }
        obj1 = null;
        float2 = obj1;
        if (searchparameters != null)
        {
            float2 = obj1;
            if (searchparameters.getPriceTo() > -1F)
            {
                float2 = Float.valueOf(searchparameters.getPriceTo());
            }
        }
        return (new dk(s1)).a(s3, d3, d2, ((String) (obj)), float1, float2, s, integer, j, i, s2, (new ir()).a(d, d1, 15));
    }

    protected gf a(SearchParameters searchparameters, int i, Context context, String s, LatitudeLongitude latitudelongitude, CountryCurrencyInfo countrycurrencyinfo, String s1)
    {
        if (latitudelongitude == null || !latitudelongitude.isValid())
        {
            aqo.a("LatitudeLongitude point is null", new Object[0]);
            return new gd(4);
        }
        searchparameters = a(i, latitudelongitude.getLatitude(), latitudelongitude.getLongitude(), searchparameters, 20, s, s1);
        if (searchparameters == null)
        {
            return null;
        } else
        {
            s1 = new Location("");
            s1.setLatitude(latitudelongitude.getLatitude());
            s1.setLongitude(latitudelongitude.getLongitude());
            return a(((List) (searchparameters)), context, countrycurrencyinfo, ((Location) (s1)), s, i);
        }
    }
}
