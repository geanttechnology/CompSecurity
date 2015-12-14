// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaAction, MoaActionList, MoaFloatParameter, MoaPointParameter, 
//            MoaMetadata, MoaParameter

public final class MoaActionFactory
{

    private MoaActionFactory()
    {
    }

    public static MoaAction action(String s)
    {
        return new MoaAction(s);
    }

    public static MoaActionList actionList()
    {
        return new MoaActionList();
    }

    public static transient MoaActionList actionList(String as[])
    {
        MoaActionList moaactionlist = new MoaActionList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            moaactionlist.add(action(as[i]));
        }

        return moaactionlist;
    }

    public static MoaAction decodeAction(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("name") && jsonobject.has("description") && jsonobject.has("parameters"))
        {
            MoaAction moaaction = new MoaAction(jsonobject.getString("name"));
            moaaction.description = jsonobject.getString("description");
            moaaction.jsonParameters = jsonobject.getJSONArray("parameters");
            return moaaction;
        } else
        {
            throw new JSONException("invalid data");
        }
    }

    public static List decodeActions(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(decodeAction(jsonarray.getJSONObject(i)));
        }

        return arraylist;
    }

    static MoaParameter decodeParameter(JSONObject jsonobject)
    {
        String s;
        if (!jsonobject.has("type"))
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = jsonobject.optString("type");
        jsonobject = null;
        if (!s.equals("float")) goto _L2; else goto _L1
_L1:
        jsonobject = new MoaFloatParameter();
_L4:
        return jsonobject;
_L2:
        if (!s.equals("point")) goto _L4; else goto _L3
_L3:
        return new MoaPointParameter();
        return null;
    }

    public static MoaMetadata metadata()
    {
        return new MoaMetadata();
    }
}
