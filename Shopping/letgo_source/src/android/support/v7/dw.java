// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.abtnprojects.ambatana.datasource.entities.AddressEntity;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            du, iq, afi, aev, 
//            aeu, aqo

public class dw
    implements du
{

    final SharedPreferences a;
    final AddressMapper b;

    public dw(Context context, AddressMapper addressmapper)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("You must provide a valid context to the PrefsAddressCache");
        } else
        {
            a = context.getSharedPreferences(iq.a, 0);
            b = addressmapper;
            return;
        }
    }

    public LetgoAddress a()
    {
        Object obj = (new aev()).a();
        String s = a.getString("address", "");
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            obj = (AddressEntity)((aeu) (obj)).a(s, com/abtnprojects/ambatana/datasource/entities/AddressEntity);
            obj = b.fromEntity(((AddressEntity) (obj)));
        }
        catch (afi afi1)
        {
            a.edit().remove("address").apply();
            return null;
        }
        return ((LetgoAddress) (obj));
    }

    public void a(CurrentUserLocation currentuserlocation)
    {
        if (currentuserlocation.getLatitude() != 4.9406564584124654E-324D && currentuserlocation.getLongitude() != 4.9406564584124654E-324D)
        {
            android.content.SharedPreferences.Editor editor = a.edit();
            editor.putString("LOCATION_PREF", currentuserlocation.toJSON());
            editor.commit();
        }
    }

    public void a(LetgoAddress letgoaddress)
    {
        aqo.a("save address", new Object[0]);
        if (letgoaddress == null)
        {
            throw new IllegalArgumentException("You must provide a valid address to save");
        } else
        {
            android.content.SharedPreferences.Editor editor = a.edit();
            editor.remove("address");
            editor.putString("address", b.toEntity(letgoaddress).asJson());
            editor.commit();
            return;
        }
    }

    public CurrentUserLocation b()
    {
        return CurrentUserLocation.fromJSON(a.getString("LOCATION_PREF", null));
    }

    public LatitudeLongitude c()
    {
        com.parse.ParseGeoPoint parsegeopoint = ParseUser.getCurrentUser().getParseGeoPoint("gpscoords");
        Object obj = b();
        CurrentUserLocation.getInstance().updateLocationData(((CurrentUserLocation) (obj)));
        obj = CurrentUserLocation.getInstance().getLatitudeLongitude();
        if (LatitudeLongitude.isValidLocation(((LatitudeLongitude) (obj)).getLatitude(), ((LatitudeLongitude) (obj)).getLongitude()))
        {
            return ((LatitudeLongitude) (obj));
        } else
        {
            return new LatitudeLongitude(parsegeopoint);
        }
    }

    public boolean d()
    {
        LatitudeLongitude latitudelongitude = c();
        return latitudelongitude != null && latitudelongitude.isValid();
    }
}
