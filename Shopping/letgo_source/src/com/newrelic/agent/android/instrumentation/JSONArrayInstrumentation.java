// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            MetricCategory

public class JSONArrayInstrumentation
{

    private static final ArrayList categoryParams = new ArrayList(Arrays.asList(new String[] {
        "category", com/newrelic/agent/android/instrumentation/MetricCategory.getName(), "JSON"
    }));

    JSONArrayInstrumentation()
    {
    }

    public static JSONArray init(String s)
        throws JSONException
    {
        try
        {
            TraceMachine.enterMethod("JSONArray#<init>", categoryParams);
            s = new JSONArray(s);
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

    public static String toString(JSONArray jsonarray)
    {
        TraceMachine.enterMethod("JSONArray#toString", categoryParams);
        jsonarray = jsonarray.toString();
        TraceMachine.exitMethod();
        return jsonarray;
    }

    public static String toString(JSONArray jsonarray, int i)
        throws JSONException
    {
        try
        {
            TraceMachine.enterMethod("JSONArray#toString", categoryParams);
            jsonarray = jsonarray.toString(i);
            TraceMachine.exitMethod();
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            TraceMachine.exitMethod();
            throw jsonarray;
        }
        return jsonarray;
    }

}
