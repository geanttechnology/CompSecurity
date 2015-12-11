// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class 
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String clipId;
    private String displayName;
    private String stillImage;
    private ArrayList videos;

    public static ArrayList loadProductVideos(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        jsonobject = jsonobject.optJSONArray("videoFiles");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject(i);
                if (jsonobject1 == null)
                {
                    continue;
                }
                  = new <init>();
                .clipId = jsonobject1.optString("clipId");
                .displayName = jsonobject1.optString("displayName");
                JSONObject jsonobject2 = jsonobject1.optJSONObject("stillImage");
                if (jsonobject2 != null)
                {
                    .stillImage = jsonobject2.optString("url");
                }
                .videos = oDetails(jsonobject1.optJSONArray("sizes"));
                arraylist.add();
            }

        }
        return arraylist;
    }

    public String getClipId()
    {
        return clipId;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getStillImage()
    {
        return stillImage;
    }

    public ArrayList getVideos()
    {
        return videos;
    }

    public ()
    {
    }
}
