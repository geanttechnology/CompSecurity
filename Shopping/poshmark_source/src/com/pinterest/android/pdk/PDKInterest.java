// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKModel, Utils

public class PDKInterest extends PDKModel
{

    private String name;
    private String uid;

    public PDKInterest()
    {
    }

    public static PDKInterest makeInterest(Object obj)
    {
        PDKInterest pdkinterest = new PDKInterest();
        try
        {
            if (obj instanceof JSONObject)
            {
                obj = (JSONObject)obj;
                if (((JSONObject) (obj)).has("id"))
                {
                    pdkinterest.setUid(((JSONObject) (obj)).getString("id"));
                }
                if (((JSONObject) (obj)).has("name"))
                {
                    pdkinterest.setName(((JSONObject) (obj)).getString("name"));
                }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.loge("PDK: PDKInterest parse JSON error %s", new Object[] {
                ((JSONException) (obj)).getLocalizedMessage()
            });
            return pdkinterest;
        }
        return pdkinterest;
    }

    public static List makeInterestList(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        if (!(obj instanceof JSONArray)) goto _L2; else goto _L1
_L1:
        int j;
        obj = (JSONArray)obj;
        j = ((JSONArray) (obj)).length();
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(makeInterest(((JSONArray) (obj)).getJSONObject(i)));
        i++;
        if (true) goto _L3; else goto _L2
        obj;
        Utils.loge("PDK: PDKInterst parse JSON error %s", new Object[] {
            ((JSONException) (obj)).getLocalizedMessage()
        });
_L2:
        return arraylist;
    }

    public String getName()
    {
        return name;
    }

    public String getUid()
    {
        return uid;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setUid(String s)
    {
        uid = s;
    }
}
