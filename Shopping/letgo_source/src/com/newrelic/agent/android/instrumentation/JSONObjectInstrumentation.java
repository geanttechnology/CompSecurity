// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            MetricCategory

public class JSONObjectInstrumentation
{

    private static final ArrayList categoryParams = new ArrayList(Arrays.asList(new String[] {
        "category", com/newrelic/agent/android/instrumentation/MetricCategory.getName(), "JSON"
    }));

    JSONObjectInstrumentation()
    {
    }

    public static JSONObject init(String s)
        throws JSONException
    {
        try
        {
            TraceMachine.enterMethod(null, "JSONObject#<init>", categoryParams);
            s = new JSONObject(s);
            TraceMachine.exitMethod();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TraceMachine.exitMethod();
            throw s;
        }
        return s;
    }

    public static String toString(JSONObject jsonobject)
    {
        TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
        jsonobject = jsonobject.toString();
        TraceMachine.exitMethod();
        return jsonobject;
    }

    public static String toString(JSONObject jsonobject, int i)
        throws JSONException
    {
        TraceMachine.enterMethod(null, "JSONObject#toString", categoryParams);
        try
        {
            jsonobject = jsonobject.toString(i);
            TraceMachine.exitMethod();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TraceMachine.exitMethod();
            throw jsonobject;
        }
        return jsonobject;
    }

}
