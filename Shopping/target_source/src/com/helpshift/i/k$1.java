// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.f.a;
import com.helpshift.h.e;
import com.helpshift.l;
import com.helpshift.s;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift.i:
//            k, m, t, h

static final class init> extends Handler
{

    final m a;
    final l b;
    final Context c;

    public void handleMessage(Message message)
    {
        message = (JSONArray)message.obj;
        if (a != null)
        {
            a.a();
        }
          goto _L1
_L10:
        int i;
        if (i >= message.length()) goto _L3; else goto _L2
_L2:
        JSONObject jsonobject;
        Object obj;
        jsonobject = message.getJSONObject(i);
        obj = jsonobject.getString("id");
        if (b.a.k().equals(obj)) goto _L5; else goto _L4
_L4:
        Object obj1;
        obj = e.a(((String) (obj)));
        obj1 = jsonobject.getJSONArray("messages");
        if (((JSONArray) (obj1)).length() != 1) goto _L7; else goto _L6
_L6:
        obj1 = ((JSONArray) (obj1)).getJSONObject(((JSONArray) (obj1)).length() - 1);
        if (!t.b(((JSONObject) (obj1)).getString("origin"), ((JSONObject) (obj1)).getString("type"))) goto _L7; else goto _L5
_L7:
        int j = ((a) (obj)).h();
        if (j == 0) goto _L5; else goto _L8
_L8:
        int i1 = (int)com.helpshift.i.h.a.parse(jsonobject.getString("created_at")).getTime();
        com.helpshift.i.k.a(c, jsonobject.getString("id"), i1, j, "inapp", com.helpshift.i.k.a(c));
          goto _L5
        ParseException parseexception;
        parseexception;
        Log.d(com.helpshift.i.k.a(), parseexception.toString());
          goto _L5
        message;
        Log.d(com.helpshift.i.k.a(), message.getMessage());
_L3:
        return;
_L1:
        i = 0;
        continue; /* Loop/switch isn't completed */
_L5:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    ext(m m1, l l1, Context context)
    {
        a = m1;
        b = l1;
        c = context;
        super();
    }
}
