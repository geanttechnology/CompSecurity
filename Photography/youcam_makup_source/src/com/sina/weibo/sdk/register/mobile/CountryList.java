// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import com.sina.weibo.sdk.exception.WeiboException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            Country

public class CountryList
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public List countries;

    public CountryList(String s)
    {
        initFromJsonStr(s);
    }

    private void initFromJsonStr(String s)
    {
        try
        {
            initFromJsonObject(new JSONObject(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void initFromJsonObject(JSONObject jsonobject)
    {
        Iterator iterator;
        countries = new ArrayList();
        iterator = jsonobject.keys();
_L1:
        if (!iterator.hasNext())
        {
            return;
        }
        String as[];
        JSONArray jsonarray;
        int i;
        Object obj;
        String s;
        try
        {
            obj = (String)iterator.next();
            JSONObject jsonobject1 = jsonobject.optJSONObject(((String) (obj)));
            s = jsonobject1.getString("code");
            jsonarray = jsonobject1.optJSONObject("rule").optJSONArray("mcc");
            as = new String[jsonarray.length()];
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            throw new WeiboException(jsonobject);
        }
        i = 0;
_L2:
label0:
        {
            if (i < jsonarray.length())
            {
                break label0;
            }
            obj = new Country(((String) (obj)), s);
            ((Country) (obj)).setMccs(as);
            countries.add(obj);
        }
          goto _L1
        as[i] = jsonarray.getString(i);
        i++;
          goto _L2
    }
}
