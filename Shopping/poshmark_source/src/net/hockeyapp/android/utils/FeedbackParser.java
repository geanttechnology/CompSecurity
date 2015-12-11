// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.utils;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import net.hockeyapp.android.objects.Feedback;
import net.hockeyapp.android.objects.FeedbackMessage;
import net.hockeyapp.android.objects.FeedbackResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackParser
{
    private static class FeedbackParserHolder
    {

        public static final FeedbackParser INSTANCE = new FeedbackParser();


        private FeedbackParserHolder()
        {
        }
    }


    private FeedbackParser()
    {
    }


    public static FeedbackParser getInstance()
    {
        return FeedbackParserHolder.INSTANCE;
    }

    public FeedbackResponse parseFeedbackResponse(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (s == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        Feedback feedback;
        JSONObject jsonobject1;
        jsonobject = JSONObjectInstrumentation.init(s);
        jsonobject1 = jsonobject.getJSONObject("feedback");
        feedback = new Feedback();
        JSONArray jsonarray = jsonobject1.getJSONArray("messages");
        s = null;
        if (jsonarray.length() <= 0) goto _L4; else goto _L3
_L3:
        obj = new ArrayList();
        int i = 0;
_L5:
        s = ((String) (obj));
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = jsonarray.getJSONObject(i).getString("subject").toString();
        String s1 = jsonarray.getJSONObject(i).getString("text").toString();
        String s2 = jsonarray.getJSONObject(i).getString("oem").toString();
        String s3 = jsonarray.getJSONObject(i).getString("model").toString();
        String s4 = jsonarray.getJSONObject(i).getString("os_version").toString();
        String s5 = jsonarray.getJSONObject(i).getString("created_at").toString();
        int j = jsonarray.getJSONObject(i).getInt("id");
        String s6 = jsonarray.getJSONObject(i).getString("token").toString();
        int k = jsonarray.getJSONObject(i).getInt("via");
        String s7 = jsonarray.getJSONObject(i).getString("user_string").toString();
        String s8 = jsonarray.getJSONObject(i).getString("clean_text").toString();
        String s9 = jsonarray.getJSONObject(i).getString("name").toString();
        String s10 = jsonarray.getJSONObject(i).getString("app_id").toString();
        FeedbackMessage feedbackmessage = new FeedbackMessage();
        feedbackmessage.setAppId(s10);
        feedbackmessage.setCleanText(s8);
        feedbackmessage.setCreatedAt(s5);
        feedbackmessage.setId(j);
        feedbackmessage.setModel(s3);
        feedbackmessage.setName(s9);
        feedbackmessage.setOem(s2);
        feedbackmessage.setOsVersion(s4);
        feedbackmessage.setSubjec(s);
        feedbackmessage.setText(s1);
        feedbackmessage.setToken(s6);
        feedbackmessage.setUserString(s7);
        feedbackmessage.setVia(k);
        ((ArrayList) (obj)).add(feedbackmessage);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        feedback.setMessages(s);
        feedback.setName(jsonobject1.getString("name").toString());
_L6:
        feedback.setEmail(jsonobject1.getString("email").toString());
_L7:
        feedback.setId(jsonobject1.getInt("id"));
_L8:
        feedback.setCreatedAt(jsonobject1.getString("created_at").toString());
_L9:
        s = new FeedbackResponse();
        s.setFeedback(feedback);
        s.setStatus(jsonobject.getString("status").toString());
_L10:
        s.setToken(jsonobject.getString("token").toString());
_L11:
        obj = s;
_L2:
        return ((FeedbackResponse) (obj));
        s;
        s.printStackTrace();
          goto _L6
        s;
        obj = obj1;
_L12:
        s.printStackTrace();
        return ((FeedbackResponse) (obj));
        s;
        s.printStackTrace();
          goto _L7
        s;
        s.printStackTrace();
          goto _L8
        s;
        s.printStackTrace();
          goto _L9
        obj;
        ((JSONException) (obj)).printStackTrace();
          goto _L10
        obj;
        ((JSONException) (obj)).printStackTrace();
          goto _L11
        s;
        obj = obj1;
          goto _L12
        JSONException jsonexception;
        jsonexception;
        obj = s;
        s = jsonexception;
          goto _L12
    }
}
