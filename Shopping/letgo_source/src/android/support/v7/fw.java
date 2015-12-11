// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import java.util.Date;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            df, io, cz, aqo, 
//            dw, du

public abstract class fw extends AsyncTask
{

    protected final Context a;

    public fw(Context context)
    {
        a = context;
    }

    protected transient Location a(Void avoid[])
    {
        Object obj = (new df(null)).a();
        avoid = LetgoAddress.obtainFromJson(((JSONObject) (obj)), "UserLocationByIp");
        if (avoid != null)
        {
            io.a(avoid);
            obj = new Location("UserLocationByIp");
            ((Location) (obj)).setLatitude(avoid.getPoint().getLatitude());
            ((Location) (obj)).setLongitude(avoid.getPoint().getLongitude());
            ((Location) (obj)).setTime((new Date()).getTime());
            return ((Location) (obj));
        }
        if (obj == null)
        {
            avoid = null;
        } else
        {
            avoid = ((JSONObject) (obj)).toString();
        }
        aqo.b(new cz((new StringBuilder()).append("Unable to resolve location by ip: json : ").append(avoid).toString()), "failed location by ip", new Object[0]);
        return null;
    }

    protected void a(Location location)
    {
        if (location != null)
        {
            CurrentUserLocation currentuserlocation = CurrentUserLocation.getInstance();
            currentuserlocation.updateLocationData(location.getLatitude(), location.getLongitude(), "UserLocationByIp");
            if (a != null)
            {
                (new dw(a, new AddressMapper())).a(currentuserlocation);
            }
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Location)obj);
    }
}
