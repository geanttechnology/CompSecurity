// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.content.Context;
import android.support.v7.aqo;
import android.support.v7.in;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            CountryLanguage

public class CountryLanguageEntity
{

    private final Context context;

    public CountryLanguageEntity(Context context1)
    {
        context = context1;
    }

    public CountryLanguage acquireCountryLanguage()
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        Object obj4 = getJsonObject();
        Object obj3 = Locale.getDefault();
        if (obj3 == null)
        {
            obj = null;
        } else
        {
            obj = ((Locale) (obj3)).getCountry();
        }
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((String) (obj)).toLowerCase();
        }
        obj2 = obj;
        if (obj == null)
        {
            obj2 = "us";
        }
        if (obj3 == null)
        {
            obj = obj1;
        } else
        {
            obj = ((Locale) (obj3)).getLanguage();
        }
        obj3 = obj;
        if (obj == null)
        {
            obj3 = "en";
        }
        if (obj4 == null) goto _L2; else goto _L1
_L1:
        try
        {
            obj4 = getListOfLanguages(((JSONObject) (obj4)).getJSONArray(((String) (obj2))));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aqo.d("failed to find country code %s", new Object[] {
                obj2
            });
            obj1 = "us";
            obj = "en";
            continue; /* Loop/switch isn't completed */
        }
        obj = obj3;
        obj1 = obj2;
        if (((ArrayList) (obj4)).contains(obj3)) goto _L4; else goto _L3
_L3:
        if (((ArrayList) (obj4)).size() <= 0) goto _L6; else goto _L5
_L5:
        obj = (String)((ArrayList) (obj4)).get(0);
        obj1 = obj2;
_L4:
label0:
        {
            if (obj1 != null)
            {
                obj2 = obj;
                if (obj != null)
                {
                    break label0;
                }
            }
            obj1 = "us";
            obj2 = "en";
        }
        return new CountryLanguage(((String) (obj1)), ((String) (obj2)));
_L6:
        obj1 = "us";
        obj = "en";
        continue; /* Loop/switch isn't completed */
_L2:
        obj1 = "us";
        obj = "en";
        if (true) goto _L4; else goto _L7
_L7:
    }

    public JSONObject getJsonObject()
    {
        String s = in.a(context, 0x7f080004);
        JSONObject jsonobject = null;
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                jsonobject = JSONObjectInstrumentation.init(s);
            }
            catch (JSONException jsonexception)
            {
                aqo.d("failed to parse json languages file", new Object[0]);
                return null;
            }
        }
        return jsonobject;
    }

    public ArrayList getListOfLanguages(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray == null)
        {
            return arraylist;
        }
        int i = 0;
        do
        {
            if (i >= jsonarray.length())
            {
                break;
            }
            try
            {
                String s = jsonarray.get(i).toString();
                if (!TextUtils.isEmpty(s))
                {
                    arraylist.add(s);
                }
            }
            catch (JSONException jsonexception)
            {
                String s1;
                if (!(jsonarray instanceof JSONArray))
                {
                    s1 = jsonarray.toString();
                } else
                {
                    s1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
                }
                aqo.d("Failed to get json object from jsonArray : %s", new Object[] {
                    s1
                });
            }
            i++;
        } while (true);
        return arraylist;
    }
}
