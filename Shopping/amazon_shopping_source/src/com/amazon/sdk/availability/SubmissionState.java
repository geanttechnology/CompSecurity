// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger

class SubmissionState
{
    public static class Submission
    {

        private long attempts;
        private long numMeasurements;
        private boolean succeeded;
        private long timestamp;

        public JSONObject toJson()
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("numMeasurements", numMeasurements);
            jsonobject.put("timestamp", timestamp);
            jsonobject.put("attempts", attempts);
            if (!succeeded)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            jsonobject.put("status", "Succeeded");
            return jsonobject;
            try
            {
                jsonobject.put("status", "Failed");
            }
            catch (JSONException jsonexception)
            {
                Logger.e("failed to serialize object", jsonexception);
                return jsonobject;
            }
            return jsonobject;
        }

        public String toString()
        {
            return toJson().toString();
        }

        public Submission()
        {
        }
    }


    private List submissions;
    private String token;

    public SubmissionState()
    {
        submissions = new LinkedList();
    }

    public JSONObject toJson()
    {
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        obj = new JSONArray();
        try
        {
            for (Iterator iterator = submissions.iterator(); iterator.hasNext(); ((JSONArray) (obj)).put(((Submission)iterator.next()).toJson())) { }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.e("failed to serialize object", ((Throwable) (obj)));
            return jsonobject;
        }
        jsonobject.put("submissions", obj);
        jsonobject.put("token", token);
        return jsonobject;
    }

    public String toString()
    {
        return toJson().toString();
    }
}
