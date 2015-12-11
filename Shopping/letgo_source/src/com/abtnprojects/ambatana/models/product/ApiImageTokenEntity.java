// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            ApiImageToken

public class ApiImageTokenEntity
{

    public static final String IMAGE_ID_FIELD = "imageId";

    public ApiImageTokenEntity()
    {
    }

    public JSONArray transform(List list)
    {
        JSONArray jsonarray = new JSONArray();
        if (list == null)
        {
            return null;
        }
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s = (String)list.next();
            if (!TextUtils.isEmpty(s))
            {
                jsonarray.put(s);
            }
        } while (true);
        return jsonarray;
    }

    public JSONObject transform(ApiImageToken apiimagetoken)
    {
        if (apiimagetoken == null)
        {
            return null;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("imageId", apiimagetoken.getImageId());
        }
        // Misplaced declaration of an exception variable
        catch (ApiImageToken apiimagetoken)
        {
            apiimagetoken.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public String transformToString(List list)
    {
        if (list == null)
        {
            return null;
        }
        list = transform(list);
        if (list == null)
        {
            return null;
        }
        if (!(list instanceof JSONArray))
        {
            return list.toString();
        } else
        {
            return JSONArrayInstrumentation.toString((JSONArray)list);
        }
    }
}
