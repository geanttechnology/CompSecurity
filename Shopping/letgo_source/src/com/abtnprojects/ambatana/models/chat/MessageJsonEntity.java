// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.chat;

import android.support.v7.aqo;
import android.support.v7.in;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Date;
import org.json.JSONException;

// Referenced classes of package com.abtnprojects.ambatana.models.chat:
//            Message

public class MessageJsonEntity
{

    public MessageJsonEntity()
    {
    }

    public Message transform(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        Object obj;
        try
        {
            Object obj1 = JSONObjectInstrumentation.init(s);
            obj = in.c(((org.json.JSONObject) (obj1)), "m");
            int i = in.a(((org.json.JSONObject) (obj1)), "n_t");
            obj1 = in.c(((org.json.JSONObject) (obj1)), "u");
            obj = new Message(0, ((String) (obj)), i, new Date(), ((String) (obj1)), null, null);
        }
        catch (JSONException jsonexception)
        {
            aqo.b(jsonexception, "Error parsing %s", new Object[] {
                s
            });
            return null;
        }
        return ((Message) (obj));
    }
}
