// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.mapper;

import android.location.Address;
import android.location.Location;
import android.support.v7.aqo;
import android.support.v7.in;
import android.text.TextUtils;
import com.abtnprojects.ambatana.datasource.entities.AddressEntity;
import com.abtnprojects.ambatana.datasource.entities.PointEntity;
import com.abtnprojects.ambatana.datasource.entities.address.AddressComponent;
import com.abtnprojects.ambatana.datasource.entities.address.Geometry;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.abtnprojects.ambatana.datasource.entities.mapper:
//            PointMapper

public class AddressMapper
{

    public AddressMapper()
    {
    }

    private String resolveCity(Address address)
    {
        if (address.getLocality() != null)
        {
            return address.getLocality();
        } else
        {
            return address.getAdminArea();
        }
    }

    private String resolveStreetName(Address address)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (address.getMaxAddressLineIndex() < 0) goto _L2; else goto _L1
_L1:
        stringbuilder.append(address.getAddressLine(0));
_L4:
        if (!TextUtils.isEmpty(address.getSubLocality()))
        {
            stringbuilder.append(", ").append(address.getSubLocality());
        }
        if (!TextUtils.isEmpty(address.getLocality()))
        {
            stringbuilder.append(", ").append(address.getLocality());
        }
        if (!TextUtils.isEmpty(address.getCountryCode()))
        {
            stringbuilder.append(", ").append(address.getCountryCode());
        }
        return stringbuilder.toString();
_L2:
        if (!TextUtils.isEmpty(address.getFeatureName()))
        {
            stringbuilder.append(address.getFeatureName());
        } else
        if (!TextUtils.isEmpty(address.getThoroughfare()))
        {
            stringbuilder.append(address.getThoroughfare());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String setFullName(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s1))
        {
            arraylist.add(s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            arraylist.add(s2);
        }
        if (TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        s1 = TextUtils.join(", ", arraylist);
_L4:
        s2 = new StringBuilder();
        if (!TextUtils.isEmpty(s1))
        {
            s2.append(s1);
        }
        if (!TextUtils.isEmpty(s))
        {
            if (s2.length() > 0)
            {
                s2.append(", ");
            }
            s2.append(s);
        }
        if (!TextUtils.isEmpty(s4))
        {
            if (s2.length() > 0)
            {
                s2.append(", ");
            }
            s2.append(s4);
        }
        if (!TextUtils.isEmpty(s5))
        {
            if (s2.length() > 0)
            {
                s2.append(", ");
            }
            s2.append(s5);
        }
        if (!TextUtils.isEmpty(s6))
        {
            if (s2.length() > 0)
            {
                s2.append(", ");
            }
            s2.append(s6);
        }
        if (!TextUtils.isEmpty(s7))
        {
            if (s2.length() > 0)
            {
                s2.append(", ");
            }
            s2.append(s7);
        }
        return s2.toString();
_L2:
        s1 = s3;
        if (TextUtils.isEmpty(s3))
        {
            s1 = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public LetgoAddress fromAddress(Address address, Location location)
    {
        String s = address.getCountryCode();
        String s1 = resolveCity(address);
        String s2 = address.getPostalCode();
        double d;
        double d1;
        try
        {
            d1 = address.getLatitude();
            d = address.getLongitude();
        }
        catch (IllegalStateException illegalstateexception)
        {
            d1 = location.getLatitude();
            d = location.getLongitude();
        }
        return new LetgoAddress(s1, s, new LatitudeLongitude(d1, d), resolveStreetName(address), s2, location.getProvider());
    }

    public LetgoAddress fromEntity(AddressEntity addressentity)
    {
        String s = addressentity.getCountryCode();
        String s1 = addressentity.getCity();
        String s2 = addressentity.getZipCode();
        PointEntity pointentity = addressentity.getPointEntity();
        return new LetgoAddress(s1, s, (new PointMapper()).fromEntity(pointentity), addressentity.getStreetName(), s2, addressentity.getProvider());
    }

    public LetgoAddress fromGoogleAddress(List list, Geometry geometry, Location location, String s)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        }
        String s1 = null;
        Object obj5 = null;
        Object obj4 = null;
        Object obj6 = null;
        Object obj3 = null;
        Object obj = null;
        Object obj2 = null;
        Object obj1 = null;
        Iterator iterator = list.iterator();
        list = obj6;
        while (iterator.hasNext()) 
        {
            Object obj7 = (AddressComponent)iterator.next();
            List list2 = ((AddressComponent) (obj7)).getTypes();
            if (list2.contains("street_number"))
            {
                s1 = ((AddressComponent) (obj7)).getLongName();
                obj7 = obj;
                obj = list;
                list = ((List) (obj7));
            } else
            if (list2.contains("route"))
            {
                obj7 = ((AddressComponent) (obj7)).getLongName();
                obj5 = list;
                list = ((List) (obj));
                obj = obj5;
                obj5 = obj7;
            } else
            if (list2.contains("locality"))
            {
                obj7 = ((AddressComponent) (obj7)).getLongName();
                list = ((List) (obj));
                obj = obj7;
            } else
            if (list2.contains("administrative_area_level_2"))
            {
                obj7 = ((AddressComponent) (obj7)).getLongName();
                obj = list;
                list = ((List) (obj7));
            } else
            if (list2.contains("establishment"))
            {
                obj7 = ((AddressComponent) (obj7)).getLongName();
                obj4 = list;
                list = ((List) (obj));
                obj = obj4;
                obj4 = obj7;
            } else
            if (list2.contains("neighborhood"))
            {
                ((AddressComponent) (obj7)).getLongName();
                obj7 = list;
                list = ((List) (obj));
                obj = obj7;
            } else
            if (list2.contains("sublocality"))
            {
                obj7 = ((AddressComponent) (obj7)).getLongName();
                obj3 = list;
                list = ((List) (obj));
                obj = obj3;
                obj3 = obj7;
            } else
            if (list2.contains("country"))
            {
                obj7 = ((AddressComponent) (obj7)).getShortName();
                obj2 = list;
                list = ((List) (obj));
                obj = obj2;
                obj2 = obj7;
            } else
            if (list2.contains("postal_code"))
            {
                obj7 = ((AddressComponent) (obj7)).getShortName();
                obj1 = list;
                list = ((List) (obj));
                obj = obj1;
                obj1 = obj7;
            } else
            {
                List list1 = list;
                list = ((List) (obj));
                obj = list1;
            }
            obj7 = obj;
            obj = list;
            list = ((List) (obj7));
        }
        obj7 = list;
        if (TextUtils.isEmpty(list))
        {
            obj7 = obj;
        }
        if (s == null)
        {
            s = setFullName(null, ((String) (obj5)), s1, ((String) (obj4)), ((String) (obj3)), ((String) (obj7)), ((String) (obj2)), ((String) (obj1)));
        }
        if (geometry != null && geometry.getLocation() != null)
        {
            list = geometry.getLocation();
            geometry = new LatitudeLongitude(list.getLat().doubleValue(), list.getLng().doubleValue());
            list = geometry;
            if (!geometry.isValid())
            {
                list = new LatitudeLongitude(location.getLatitude(), location.getLongitude());
            }
        } else
        {
            list = new LatitudeLongitude(location.getLatitude(), location.getLongitude());
        }
        return new LetgoAddress(((String) (obj7)), ((String) (obj2)), list, s, ((String) (obj1)), location.getProvider());
    }

    public LetgoAddress fromJsonObjectAddress(JSONObject jsonobject, String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        LatitudeLongitude latitudelongitude;
        Object obj9;
        Object obj10;
        Object obj11;
        String s1;
        JSONObject jsonobject1;
        ArrayList arraylist;
        int i;
        if (jsonobject == null)
        {
            return null;
        }
        jsonobject1 = in.d(jsonobject, "result");
        obj = in.d(in.d(jsonobject1, "geometry"), "location");
        jsonobject = in.b(((JSONObject) (obj)), "lat");
        obj = in.b(((JSONObject) (obj)), "lng");
        JSONArray jsonarray;
        JSONArray jsonarray1;
        int j;
        if (LatitudeLongitude.isValidLocation(jsonobject.doubleValue(), ((Double) (obj)).doubleValue()))
        {
            latitudelongitude = new LatitudeLongitude(jsonobject.doubleValue(), ((Double) (obj)).doubleValue());
        } else
        {
            latitudelongitude = new LatitudeLongitude(4.9406564584124654E-324D, 4.9406564584124654E-324D);
        }
        jsonarray1 = in.f(jsonobject1, "address_components");
        s1 = in.c(jsonobject1, "name");
        jsonobject = null;
        obj = null;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        obj9 = null;
        obj10 = null;
        arraylist = new ArrayList();
        i = 0;
_L4:
        Object obj7;
        if (i >= jsonarray1.length())
        {
            break MISSING_BLOCK_LABEL_842;
        }
        obj4 = jsonobject;
        try
        {
            obj11 = (JSONObject)jsonarray1.get(i);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            aqo.d("jsonArray parse error", new Object[0]);
            Object obj12 = obj3;
            obj7 = obj2;
            obj2 = obj;
            obj3 = obj4;
            jsonobject = ((JSONObject) (obj1));
            obj = obj12;
            obj1 = obj7;
            break MISSING_BLOCK_LABEL_967;
        }
        obj4 = jsonobject;
        jsonarray = in.f(((JSONObject) (obj11)), "types");
        obj4 = jsonobject;
        arraylist.clear();
        j = 0;
_L2:
        obj4 = jsonobject;
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj4 = jsonobject;
        arraylist.add(jsonarray.get(0).toString());
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        obj4 = jsonobject;
        if (!arraylist.contains("street_number"))
        {
            break MISSING_BLOCK_LABEL_286;
        }
        obj4 = jsonobject;
        in.c(((JSONObject) (obj11)), "long_name");
        obj4 = obj1;
        obj7 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj4));
        obj = obj7;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("route"))
        {
            break MISSING_BLOCK_LABEL_340;
        }
        obj4 = jsonobject;
        in.c(((JSONObject) (obj11)), "long_name");
        obj4 = obj1;
        obj7 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj4));
        obj = obj7;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("locality"))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        obj4 = jsonobject;
        obj11 = in.c(((JSONObject) (obj11)), "long_name");
        obj4 = jsonobject;
        obj7 = obj2;
        obj2 = obj11;
        jsonobject = ((JSONObject) (obj1));
        obj = obj3;
        obj1 = obj7;
        obj3 = obj4;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("administrative_area_level_2"))
        {
            break MISSING_BLOCK_LABEL_447;
        }
        obj4 = jsonobject;
        obj7 = in.c(((JSONObject) (obj11)), "long_name");
        obj4 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj1));
        obj = obj7;
        obj1 = obj4;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("administrative_area_level_4"))
        {
            break MISSING_BLOCK_LABEL_499;
        }
        obj4 = jsonobject;
        obj7 = in.c(((JSONObject) (obj11)), "long_name");
        obj4 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj7));
        obj = obj4;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("establishment"))
        {
            break MISSING_BLOCK_LABEL_577;
        }
        obj4 = jsonobject;
        jsonobject = in.c(((JSONObject) (obj11)), "long_name");
        obj4 = jsonobject;
        obj7 = jsonobject;
        if (!TextUtils.isEmpty(jsonobject))
        {
            break MISSING_BLOCK_LABEL_946;
        }
        obj4 = jsonobject;
        jsonobject = in.c(((JSONObject) (obj11)), "name");
        obj7 = obj3;
        obj4 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj1));
        obj = obj7;
        obj1 = obj4;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("neighborhood"))
        {
            break MISSING_BLOCK_LABEL_631;
        }
        obj4 = jsonobject;
        in.c(((JSONObject) (obj11)), "long_name");
        obj4 = obj1;
        obj7 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj4));
        obj = obj7;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("sublocality"))
        {
            break MISSING_BLOCK_LABEL_682;
        }
        obj4 = jsonobject;
        obj7 = in.c(((JSONObject) (obj11)), "long_name");
        obj2 = obj;
        obj4 = jsonobject;
        jsonobject = ((JSONObject) (obj1));
        obj = obj3;
        obj1 = obj7;
        obj3 = obj4;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        if (!arraylist.contains("country"))
        {
            break MISSING_BLOCK_LABEL_741;
        }
        obj4 = jsonobject;
        obj11 = in.c(((JSONObject) (obj11)), "short_name");
        obj4 = obj1;
        obj7 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj4));
        obj = obj7;
        obj9 = obj11;
        break MISSING_BLOCK_LABEL_967;
        obj4 = jsonobject;
        obj7 = jsonobject;
        if (!arraylist.contains("postal_code"))
        {
            break MISSING_BLOCK_LABEL_946;
        }
        obj4 = jsonobject;
        obj7 = in.c(((JSONObject) (obj11)), "short_name");
        obj10 = obj7;
        obj4 = obj1;
        obj7 = obj3;
        obj1 = obj2;
        obj2 = obj;
        obj3 = jsonobject;
        jsonobject = ((JSONObject) (obj4));
        obj = obj7;
        break MISSING_BLOCK_LABEL_967;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            if (TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    obj3 = obj1;
                }
                if (TextUtils.isEmpty(((CharSequence) (obj3))))
                {
                    obj = jsonobject;
                    if (TextUtils.isEmpty(jsonobject))
                    {
                        obj = s1;
                    }
                    jsonobject = ((JSONObject) (obj));
                } else
                {
                    jsonobject = ((JSONObject) (obj3));
                }
            } else
            {
                jsonobject = ((JSONObject) (obj2));
            }
        } else
        {
            jsonobject = ((JSONObject) (obj));
        }
        obj = null;
        if (TextUtils.isEmpty(null))
        {
            obj = in.c(jsonobject1, "formatted_address");
        }
        return new LetgoAddress(jsonobject, ((String) (obj9)), latitudelongitude, ((String) (obj)), ((String) (obj10)), s);
        jsonobject = ((JSONObject) (obj1));
        Object obj5 = obj3;
        obj1 = obj2;
        obj3 = obj7;
        obj2 = obj;
        obj = obj5;
        i++;
        Object obj6 = obj3;
        Object obj8 = obj2;
        obj2 = obj1;
        obj1 = jsonobject;
        obj3 = obj;
        obj = obj8;
        jsonobject = ((JSONObject) (obj6));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public AddressEntity toEntity(LetgoAddress letgoaddress)
    {
        LatitudeLongitude latitudelongitude = letgoaddress.getPoint();
        return new AddressEntity(new PointEntity(latitudelongitude.getLatitude(), latitudelongitude.getLongitude(), (new Date()).getTime()), letgoaddress.getCity(), letgoaddress.getCountryCode(), letgoaddress.getStreetName(), letgoaddress.getZipCode(), letgoaddress.getProvider());
    }
}
