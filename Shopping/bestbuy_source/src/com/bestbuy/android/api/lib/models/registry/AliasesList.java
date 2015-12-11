// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.registry;

import gs;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliasesList
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String alias;
    private String description;

    public AliasesList()
    {
    }

    public static ArrayList parseAlias(String s)
    {
        Object obj = new JSONObject(s);
        s = new ArrayList();
        obj = ((JSONObject) (obj)).optJSONArray("entities");
        for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
        {
            JSONObject jsonobject = (JSONObject)((JSONArray) (obj)).get(i);
            AliasesList aliaseslist = new AliasesList();
            aliaseslist.alias = jsonobject.optString("alias", "");
            aliaseslist.description = jsonobject.optString("description", "");
            gs.b("aliaslog", (new StringBuilder()).append("getListData respond:").append(aliaseslist.alias).toString());
            s.add(aliaseslist);
        }

        return s;
    }

    public String getAlias()
    {
        return alias;
    }

    public String getDescription()
    {
        return description;
    }
}
