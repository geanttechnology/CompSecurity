// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePlugins, PushHistory, ParseFileUtils, PLog, 
//            ParseTextUtils, Parse

class PushRouter
{

    private static final String LEGACY_STATE_LOCATION = "pushState";
    private static int MAX_HISTORY_LENGTH = 0;
    private static final String STATE_LOCATION = "push";
    private static final String TAG = "com.parse.ParsePushRouter";
    private static PushRouter instance;
    private final File diskState;
    private final PushHistory history;

    private PushRouter(File file, PushHistory pushhistory)
    {
        diskState = file;
        history = pushhistory;
    }

    public static PushRouter getInstance()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        PushRouter pushrouter;
        if (instance == null)
        {
            instance = pushRouterFromState(new File(ParsePlugins.get().getFilesDir(), "push"), new File(ParsePlugins.get().getParseDir(), "pushState"), MAX_HISTORY_LENGTH);
        }
        pushrouter = instance;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return pushrouter;
        Exception exception;
        exception;
        throw exception;
    }

    static PushRouter pushRouterFromState(File file, File file1, int i)
    {
        Object obj = readJSONFileQuietly(file);
        boolean flag;
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).optJSONObject("history");
        } else
        {
            obj = null;
        }
        obj = new PushHistory(i, ((JSONObject) (obj)));
        flag = false;
        i = ((flag) ? 1 : 0);
        if (((PushHistory) (obj)).getLastReceivedTimestamp() == null)
        {
            Object obj1 = readJSONFileQuietly(file1);
            i = ((flag) ? 1 : 0);
            if (obj1 != null)
            {
                obj1 = ((JSONObject) (obj1)).optString("lastTime", null);
                if (obj1 != null)
                {
                    ((PushHistory) (obj)).setLastReceivedTimestamp(((String) (obj1)));
                }
                i = 1;
            }
        }
        file = new PushRouter(file, ((PushHistory) (obj)));
        if (i != 0)
        {
            file.saveStateToDisk();
            ParseFileUtils.deleteQuietly(file1);
        }
        return file;
    }

    private static JSONObject readJSONFileQuietly(File file)
    {
        JSONObject jsonobject = null;
        if (file != null)
        {
            try
            {
                jsonobject = ParseFileUtils.readFileToJSONObject(file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return null;
            }
        }
        return jsonobject;
    }

    static void resetInstance()
    {
        com/parse/PushRouter;
        JVM INSTR monitorenter ;
        ParseFileUtils.deleteQuietly(new File(ParsePlugins.get().getFilesDir(), "push"));
        instance = null;
        com/parse/PushRouter;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void saveStateToDisk()
    {
        this;
        JVM INSTR monitorenter ;
        ParseFileUtils.writeJSONObjectToFile(diskState, toJSON());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
_L3:
        PLog.e("com.parse.ParsePushRouter", (new StringBuilder()).append("Unexpected error when serializing push state to ").append(diskState).toString(), ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
        obj;
          goto _L3
    }

    public String getLastReceivedTimestamp()
    {
        this;
        JVM INSTR monitorenter ;
        String s = history.getLastReceivedTimestamp();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean handlePush(String s, String s1, String s2, JSONObject jsonobject)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (ParseTextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        flag = ParseTextUtils.isEmpty(s1);
        if (!flag) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        flag = flag1;
        if (!history.tryInsertPush(s, s1)) goto _L2; else goto _L5
_L5:
        saveStateToDisk();
        s1 = new Bundle();
        s1.putString("com.parse.Channel", s2);
        if (jsonobject != null) goto _L7; else goto _L6
_L6:
        s1.putString("com.parse.Data", "{}");
_L8:
        s = new Intent("com.parse.push.intent.RECEIVE");
        s.putExtras(s1);
        s1 = Parse.getApplicationContext();
        s.setPackage(s1.getPackageName());
        s1.sendBroadcast(s);
        flag = true;
          goto _L2
_L7:
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        s = jsonobject.toString();
_L9:
        s1.putString("com.parse.Data", s);
          goto _L8
        s;
        throw s;
        s = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L9
    }

    JSONObject toJSON()
        throws JSONException
    {
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("history", history.toJSON());
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        MAX_HISTORY_LENGTH = 10;
    }
}
