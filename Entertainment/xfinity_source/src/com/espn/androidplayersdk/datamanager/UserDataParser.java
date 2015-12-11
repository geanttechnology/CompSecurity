// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            JSONParserAbstract, DataManager, FeedsDB

class UserDataParser extends JSONParserAbstract
{

    UserDataParser()
    {
    }

    public void errorHandler(int i)
    {
    }

    public void parse(JSONObject jsonobject, HashMap hashmap)
    {
        Utils.sdkLog("UserDataParser.parse()", 3, null);
        try
        {
            hashmap = new ContentValues();
            if (jsonobject.has("udid") && !jsonobject.isNull("udid"))
            {
                hashmap.put("udid", jsonobject.getString("udid"));
            }
            if (jsonobject.has("username") && !jsonobject.isNull("username"))
            {
                hashmap.put("username", jsonobject.getString("username"));
            }
            if (jsonobject.has("affiliateName") && !jsonobject.isNull("affiliateName"))
            {
                hashmap.put("affiliateName", jsonobject.getString("affiliateName"));
            }
            if (jsonobject.has("swid") && !jsonobject.isNull("swid"))
            {
                hashmap.put("swid", jsonobject.getString("swid"));
            }
            if (jsonobject.has("omniSwid") && !jsonobject.isNull("omniSwid"))
            {
                hashmap.put("omniSwid", jsonobject.getString("omniSwid"));
            }
            if (jsonobject.has("isLoggedIn") && !jsonobject.isNull("isLoggedIn"))
            {
                hashmap.put("isLoggedIn", jsonobject.getString("isLoggedIn"));
            }
            if (jsonobject.has("name") && !jsonobject.isNull("name"))
            {
                hashmap.put("name", jsonobject.getString("name"));
            }
            if (jsonobject.has("image") && !jsonobject.isNull("image"))
            {
                hashmap.put("image", jsonobject.getString("image"));
            }
            if (jsonobject.has("graceTimeLeft") && !jsonobject.isNull("graceTimeLeft"))
            {
                hashmap.put("graceTimeLeft", jsonobject.getString("graceTimeLeft"));
            }
            if (jsonobject.has("authenticated") && !jsonobject.isNull("authenticated"))
            {
                hashmap.put("authenticated", jsonobject.getString("authenticated"));
            }
            DataManager.feedsDbConn.insertIntoUserDataTable(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Utils.sdkLog("UserDataParser.Parse(); Error: ", 5, jsonobject);
        }
        errorHandler(2);
    }
}
