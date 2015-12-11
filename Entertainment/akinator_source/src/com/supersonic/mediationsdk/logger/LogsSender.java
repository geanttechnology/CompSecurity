// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;

import com.supersonic.mediationsdk.sdk.GeneralProperties;
import com.supersonic.mediationsdk.server.HttpFunctions;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk.logger:
//            ServerLogEntry

class LogsSender
    implements Runnable
{

    private final String AUTHO_PASSWORD = "k@r@puz";
    private final String AUTHO_USERNAME = "mobilelogs";
    private final String LOG_URL = "http://mobilelogs.ec2ssa.info/log";
    private ArrayList mLogs;

    public LogsSender(ArrayList arraylist)
    {
        mLogs = arraylist;
    }

    private JSONObject getJSONToSend()
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        try
        {
            jsonobject.put("general_properties", GeneralProperties.getProperties().toJSON());
            obj = new JSONArray();
            for (Iterator iterator = mLogs.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((ServerLogEntry)iterator.next()).toJSON())) { }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            return jsonobject;
        }
        jsonobject.put("log_data", obj);
        return jsonobject;
    }

    private void sendLogs(JSONObject jsonobject)
    {
        HttpFunctions.getStringFromPostWithAutho("http://mobilelogs.ec2ssa.info/log", jsonobject.toString(), "mobilelogs", "k@r@puz");
    }

    public void run()
    {
        sendLogs(getJSONToSend());
    }
}
