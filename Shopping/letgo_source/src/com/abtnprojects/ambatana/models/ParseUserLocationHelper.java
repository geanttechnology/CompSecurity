// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.text.TextUtils;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            ParseUserAddressData

public class ParseUserLocationHelper
{

    public ParseUserLocationHelper()
    {
    }

    public ParseUser createLocatedParseUser(ParseUserAddressData parseuseraddressdata, ParseUser parseuser)
    {
        if (parseuseraddressdata == null)
        {
            return null;
        }
        String s = parseuseraddressdata.getAddress();
        if (!TextUtils.isEmpty(s))
        {
            parseuser.put("address", s);
        }
        s = parseuseraddressdata.getCity();
        if (!TextUtils.isEmpty(s))
        {
            parseuser.put("city", s);
        }
        s = parseuseraddressdata.getCountryCode();
        if (!TextUtils.isEmpty(s))
        {
            parseuser.put("country_code", s);
        }
        s = parseuseraddressdata.getZipCode();
        if (!TextUtils.isEmpty(s))
        {
            parseuser.put("zipcode", s);
        }
        parseuser.put("precisely_located", Boolean.valueOf(parseuseraddressdata.isPreciselyLocated()));
        parseuser.put("gpscoords", parseuseraddressdata.getParseGeoPoint());
        parseuser.put("processed", Boolean.valueOf(false));
        return parseuser;
    }
}
