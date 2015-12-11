// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.h.e;
import com.helpshift.i.h;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, s

class <init> extends Handler
{

    final Handler a;
    final Boolean b;
    final Handler c;
    final l d;

    public void handleMessage(Message message)
    {
        String s1;
        JSONArray jsonarray1;
        JSONObject jsonobject;
        JSONArray jsonarray3;
        int i;
        int j;
        Object obj;
        JSONArray jsonarray;
        JSONArray jsonarray2;
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        JSONObject jsonobject3;
        int k;
        int i1;
        int j1;
        int k1;
        try
        {
            message = (JSONObject)((HashMap)message.obj).get("response");
            s1 = message.getString("timestamp");
            jsonarray = message.getJSONArray("issues");
            jsonarray1 = new JSONArray();
            i1 = jsonarray.length();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "JSON Exception!!!", message);
            return;
        }
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        i = 0;
_L9:
        if (i >= i1)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        jsonobject = jsonarray.getJSONObject(i);
        jsonarray2 = jsonobject.getJSONArray("messages");
        j1 = jsonarray2.length();
        jsonarray3 = new JSONArray();
        j = 0;
_L8:
        if (j >= j1) goto _L2; else goto _L1
_L1:
        jsonobject1 = jsonarray2.getJSONObject(j);
        obj = jsonobject1.optJSONObject("meta");
        message = new JSONArray();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        if (((JSONObject) (obj)).has("attachments") && !jsonobject1.getString("type").equals("sc"))
        {
            message = ((JSONObject) (obj)).getJSONArray("attachments");
            ((JSONObject) (obj)).put("attachments", new JSONArray());
            jsonobject1.put("meta", obj);
        }
        jsonarray3.put(jsonobject1);
        k1 = message.length();
        if (k1 <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = 0;
_L5:
        if (k >= k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject2 = message.getJSONObject(k);
        jsonobject3 = new JSONObject();
        jsonobject3.put("issue_id", jsonobject1.getString("issue_id"));
        jsonobject3.put("author", jsonobject1.getJSONObject("author"));
        jsonobject3.put("meta", new JSONObject());
        jsonobject3.put("id", (new StringBuilder()).append(jsonobject1.getString("id")).append("_").append(k).toString());
        if (jsonobject2 instanceof JSONObject) goto _L4; else goto _L3
_L3:
        obj = jsonobject2.toString();
_L6:
        jsonobject3.put("body", obj);
        jsonobject3.put("origin", jsonobject1.getString("origin"));
        obj = jsonobject1.getString("created_at");
        jsonobject3.put("created_at", h.a(h.d, ((String) (obj)), k + 1));
        if (!Boolean.valueOf(jsonobject2.optBoolean("image", false)).booleanValue())
        {
            break MISSING_BLOCK_LABEL_439;
        }
        jsonobject3.put("type", "admin_attachment_image");
_L7:
        jsonarray3.put(jsonobject3);
        k++;
          goto _L5
_L4:
        obj = JSONObjectInstrumentation.toString((JSONObject)jsonobject2);
          goto _L6
        jsonobject3.put("type", "admin_attachment_generic");
          goto _L7
        j++;
          goto _L8
_L2:
        if (jsonarray3 instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_515;
        }
        message = jsonarray3.toString();
_L10:
        jsonobject.put("messages", JSONArrayInstrumentation.init(message));
        jsonarray1.put(jsonobject);
        i++;
          goto _L9
        message = JSONArrayInstrumentation.toString((JSONArray)jsonarray3);
          goto _L10
        if (jsonarray1 instanceof JSONArray) goto _L12; else goto _L11
_L11:
        message = jsonarray1.toString();
_L15:
        Message message1;
        message = JSONArrayInstrumentation.init(message);
        d.a.b(s1, d.B());
        if (message.length() > 0)
        {
            d.a.a(message, d.B());
        }
        message1 = a.obtainMessage();
        if (!b.booleanValue())
        {
            break MISSING_BLOCK_LABEL_664;
        }
        message1.obj = message;
        if (message.length() <= 0) goto _L14; else goto _L13
_L13:
        a.sendMessage(message1);
_L16:
        l.a(d, message);
        return;
_L12:
        message = JSONArrayInstrumentation.toString((JSONArray)jsonarray1);
          goto _L15
_L14:
        l.a(d, c, -1);
          goto _L16
        message1.obj = e.b(d.B());
        a.sendMessage(message1);
          goto _L16
    }

    ion(l l1, Handler handler, Boolean boolean1, Handler handler1)
    {
        d = l1;
        a = handler;
        b = boolean1;
        c = handler1;
        super();
    }
}
