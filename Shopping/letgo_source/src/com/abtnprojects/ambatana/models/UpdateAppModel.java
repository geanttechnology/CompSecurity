// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.support.v7.aqo;
import android.support.v7.in;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateAppModel
{

    private final String fileUrl;
    private final int targetVersion;
    private final int versionToUpdateBefore;
    private final Set versionsToUpdate;

    public UpdateAppModel(int i, String s, Set set, int j)
    {
        targetVersion = i;
        fileUrl = s;
        versionsToUpdate = set;
        versionToUpdateBefore = j;
    }

    public static UpdateAppModel fromJson(JSONObject jsonobject)
    {
        HashSet hashset = null;
        if (jsonobject == null)
        {
            return null;
        }
        Object obj = in.d(jsonobject, "currentVersionInfo");
        int j = in.a(((JSONObject) (obj)), "buildNumber");
        int k = in.a(((JSONObject) (obj)), "forceUpdateBefore");
        obj = in.f(((JSONObject) (obj)), "forceUpdateVersions");
        if (obj != null)
        {
            hashset = new HashSet();
            int i = 0;
            while (i < ((JSONArray) (obj)).length()) 
            {
                try
                {
                    hashset.add(Integer.valueOf(((Integer)((JSONArray) (obj)).get(i)).intValue()));
                }
                catch (JSONException jsonexception)
                {
                    aqo.b(jsonexception, "fromJson", new Object[0]);
                }
                i++;
            }
        }
        return new UpdateAppModel(j, in.c(jsonobject, "configURL"), hashset, k);
    }

    public String getFileUrl()
    {
        return fileUrl;
    }

    public int getTargetVersion()
    {
        return targetVersion;
    }

    public boolean shouldUpdate(int i)
    {
        boolean flag;
        if (versionsToUpdate != null && versionsToUpdate.contains(Integer.valueOf(i)) || i <= versionToUpdateBefore)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && i < targetVersion;
    }
}
