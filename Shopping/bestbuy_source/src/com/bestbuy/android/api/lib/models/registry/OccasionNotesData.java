// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import org.json.JSONException;
import org.json.JSONObject;

public class OccasionNotesData
{

    public String location;
    public String school_name;

    public OccasionNotesData()
    {
    }

    public static OccasionNotesData loadData(JSONObject jsonobject)
    {
        OccasionNotesData occasionnotesdata = new OccasionNotesData();
        try
        {
            occasionnotesdata.school_name = jsonobject.getString("school-name");
            occasionnotesdata.location = jsonobject.getString("location");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return occasionnotesdata;
        }
        return occasionnotesdata;
    }

    public String toJsonString()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("school-name", school_name);
            jsonobject.put("location", location);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject.toString();
    }
}
