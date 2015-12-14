// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.operations.upload;

import com.amazon.gallery.framework.model.media.UploadPart;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadLocationResponse
{

    private ArrayList parts;
    private final String storageKey;
    private final String uploadId;

    public UploadLocationResponse(JSONObject jsonobject)
        throws JSONException
    {
        storageKey = jsonobject.getString("storageKey");
        uploadId = jsonobject.getString("uploadId");
        makePartsFromJson(jsonobject);
    }

    private void makePartsFromJson(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("multiUploadInfo") && !jsonobject.isNull("multiUploadInfo"))
        {
            jsonobject = jsonobject.getJSONArray("multiUploadInfo");
            parts = new ArrayList(jsonobject.length());
            int i = 0;
            while (i < jsonobject.length()) 
            {
                JSONObject jsonobject1 = (JSONObject)jsonobject.get(i);
                Object obj = jsonobject1.getJSONObject("headers");
                String s = jsonobject1.getString("host");
                jsonobject1 = jsonobject1.getJSONObject("params");
                obj = new UploadPart(Integer.valueOf(jsonobject1.getString("partNumber")).intValue(), s, ((JSONObject) (obj)), jsonobject1);
                parts.add(obj);
                i++;
            }
        }
    }

    public List getParts()
    {
        return parts;
    }

    public String getStorageKey()
    {
        return storageKey;
    }

    public String getUploadId()
    {
        return uploadId;
    }
}
