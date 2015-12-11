// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.text.TextUtils;
import com.parse.ParseUser;
import java.util.Locale;

public class ParseUserHelper
{

    private static final String FAKE_USER_PREFIX = "usercontent";
    private final ParseUser parseUser;

    public ParseUserHelper(ParseUser parseuser)
    {
        parseUser = parseuser;
    }

    public String getCity()
    {
        return parseUser.getString("city");
    }

    public String getCountryCode()
    {
        return parseUser.getString("country_code");
    }

    public String getId()
    {
        return parseUser.getObjectId();
    }

    public String getZipCode()
    {
        return parseUser.getString("zipcode");
    }

    public boolean isDummy()
    {
        String s = parseUser.getUsername();
        return !TextUtils.isEmpty(s) && s.toLowerCase(Locale.US).startsWith("usercontent");
    }
}
