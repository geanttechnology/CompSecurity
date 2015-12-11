// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.reviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class TagDimension
{

    private String id;
    private String label;
    private String tagKey;
    private List values;

    public TagDimension()
    {
    }

    public static ArrayList loadTagDimensionData(JSONObject jsonobject, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s = (String)arraylist.get(i);
            JSONObject jsonobject1 = jsonobject.optJSONObject(s);
            if (jsonobject1 == null)
            {
                continue;
            }
            TagDimension tagdimension = new TagDimension();
            tagdimension.tagKey = s;
            if (jsonobject1.optString("Values") != null)
            {
                tagdimension.values = Arrays.asList(jsonobject1.optString("Values").split("\\s*,\\s*"));
            }
            tagdimension.label = jsonobject1.optString("Label");
            tagdimension.id = jsonobject1.optString("Id");
            arraylist1.add(tagdimension);
        }

        return arraylist1;
    }

    public String getId()
    {
        return id;
    }

    public String getLabel()
    {
        return label;
    }

    public String getTagKey()
    {
        return tagKey;
    }

    public List getValues()
    {
        return values;
    }
}
