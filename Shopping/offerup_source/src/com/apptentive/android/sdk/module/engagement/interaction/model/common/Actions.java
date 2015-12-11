// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.common;

import com.apptentive.android.sdk.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Actions extends JSONArray
{

    public Actions(String s)
    {
        super(s);
    }

    public List getAsList()
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L1:
        Action action;
        if (i >= length())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        action = Action.Factory.parseAction(getJSONObject(i).toString());
        if (action == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        arraylist.add(action);
        i++;
          goto _L1
        JSONException jsonexception;
        jsonexception;
        Log.w("Exception parsing interactions array.", jsonexception, new Object[0]);
        return arraylist;
    }
}
