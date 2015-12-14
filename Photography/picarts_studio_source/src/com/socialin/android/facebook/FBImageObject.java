// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import com.socialin.android.NoProGuard;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.facebook:
//            g

public class FBImageObject
    implements NoProGuard, g
{

    private static final int FIXED_IMAGE_SIZE = 1024;
    private String id;
    private String imgMedium;
    private String name;
    private String picture;
    private String source;

    public FBImageObject(JSONObject jsonobject)
    {
        imgMedium = "";
        init(jsonobject);
    }

    public int getCount()
    {
        return 0;
    }

    public String getCover()
    {
        return imgMedium;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPicture()
    {
        return picture;
    }

    public String getSource()
    {
        return source;
    }

    public String getTitle()
    {
        return name;
    }

    public void init(JSONObject jsonobject)
    {
        if (jsonobject.has("source"))
        {
            source = jsonobject.getString("source");
        }
        if (jsonobject.has("picture"))
        {
            picture = jsonobject.getString("picture");
        }
        if (jsonobject.has("id"))
        {
            id = jsonobject.getString("id");
        }
        if (jsonobject.has("name"))
        {
            name = jsonobject.getString("name");
        }
        imgMedium = source;
        if (!jsonobject.has("images")) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.getJSONArray("images");
        if (jsonobject == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        if (i >= jsonobject.length()) goto _L2; else goto _L4
_L4:
        JSONObject jsonobject1;
        int j;
        int k;
        jsonobject1 = jsonobject.getJSONObject(i);
        j = jsonobject1.optInt("width");
        k = jsonobject1.optInt("height");
          goto _L5
_L9:
        if (j > 320 || k > 320 || j <= 150 || k <= 150) goto _L7; else goto _L6
_L6:
        imgMedium = jsonobject1.optString("source");
_L2:
        return;
_L7:
        i++;
          goto _L8
_L5:
        if (j >= 924 && j < 1124 && j >= k || k >= 924 && k < 1124 && j <= k)
        {
            try
            {
                source = jsonobject1.optString("source");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return;
            }
        }
          goto _L9
    }
}
