// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.f.a;
import com.helpshift.h.e;
import com.helpshift.i.h;
import com.helpshift.i.q;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{

    private static HashMap d;
    private Context a;
    private SharedPreferences b;
    private final String c = "fullIndex.db";

    public s(Context context)
    {
        a = context;
        b = context.getSharedPreferences("HSJsonData", 0);
    }

    private JSONObject L(String s1)
        throws JSONException
    {
        return JSONObjectInstrumentation.init(b.getString(s1, "{}"));
    }

    private JSONArray M(String s1)
        throws JSONException
    {
        return JSONArrayInstrumentation.init(b.getString(s1, "[]"));
    }

    private String N(String s1)
    {
        return b.getString(s1, "");
    }

    private Integer O(String s1)
    {
        return Integer.valueOf(b.getInt(s1, 0));
    }

    private Float P(String s1)
    {
        return Float.valueOf(b.getFloat(s1, 0.0F));
    }

    private Boolean Q(String s1)
    {
        return Boolean.valueOf(b.getBoolean(s1, false));
    }

    private void R(String s1)
    {
        Object obj = com.helpshift.h.e.b(s1);
        List list = g(s1);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a(list, s1))
        {
            Object obj1 = (a)((Iterator) (obj)).next();
            String s2 = ((a) (obj1)).b();
            obj1 = Integer.valueOf(((a) (obj1)).g());
            if (!list.contains(s2) && (((Integer) (obj1)).equals(Integer.valueOf(0)) || ((Integer) (obj1)).equals(Integer.valueOf(1))))
            {
                list.add(s2);
            }
        }

    }

    private void a(String s1, Boolean boolean1)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putBoolean(s1, boolean1.booleanValue());
        editor.commit();
    }

    private void a(String s1, Float float1)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putFloat(s1, float1.floatValue());
        editor.commit();
    }

    private void a(String s1, Integer integer)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putInt(s1, integer.intValue());
        editor.commit();
    }

    private void a(String s1, JSONArray jsonarray)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        editor.putString(s1, jsonarray);
        editor.commit();
    }

    private JSONArray b(JSONArray jsonarray, JSONArray jsonarray1)
        throws JSONException
    {
        boolean flag = false;
        JSONArray jsonarray2 = new JSONArray();
        int i1 = 0;
        int j1;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= jsonarray.length())
            {
                break;
            }
            jsonarray2.put(jsonarray.get(i1));
            i1++;
        } while (true);
        for (; j1 < jsonarray1.length(); j1++)
        {
            jsonarray2.put(jsonarray1.get(j1));
        }

        return jsonarray2;
    }

    private void c(String s1, JSONObject jsonobject)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        editor.putString(s1, jsonobject);
        editor.commit();
    }

    private void p(String s1, String s2)
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.putString(s1, s2);
        editor.commit();
    }

    protected HashMap A()
    {
        return d;
    }

    protected void A(String s1)
    {
        JSONObject jsonobject = R();
        jsonobject.remove(s1);
        e(jsonobject);
    }

    protected Boolean B()
    {
        return Q("dbFlag");
    }

    protected void B(String s1)
    {
        JSONObject jsonobject = S();
        jsonobject.remove(s1);
        f(jsonobject);
    }

    protected String C(String s1)
    {
        JSONObject jsonobject;
        jsonobject = S();
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        s1 = jsonobject.getString(s1);
        return s1;
        s1;
        Log.d("HelpShiftDebug", "getFilePathForGenericAttachment : ", s1);
        return "";
    }

    protected void C()
    {
        a("dbFlag", Boolean.valueOf(true));
    }

    protected void D()
    {
        a("dbFlag", Boolean.valueOf(false));
    }

    protected void D(String s1)
    {
        JSONObject jsonobject = T();
        jsonobject.remove(s1);
        g(jsonobject);
    }

    protected String E(String s1)
    {
        JSONObject jsonobject = T();
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s1 = jsonobject.getString(s1);
        return s1;
        s1;
        Log.d("HelpShiftDebug", "getFilePathForThumbnail : ", s1);
        return "";
    }

    protected void E()
    {
        d = null;
        a.deleteFile("fullIndex.db");
        D();
    }

    protected JSONObject F()
        throws JSONException
    {
        return L("failedApiCalls");
    }

    protected void F(String s1)
    {
        JSONObject jsonobject = U();
        jsonobject.remove(s1);
        h(jsonobject);
    }

    protected Float G()
    {
        return P("serverTimeDelta");
    }

    protected String G(String s1)
    {
        JSONObject jsonobject = U();
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s1 = jsonobject.getString(s1);
        return s1;
        s1;
        Log.d("HelpShiftDebug", "getFilePathForImage : ", s1);
        return "";
    }

    protected String H()
    {
        return N("uuid");
    }

    protected void H(String s1)
    {
        JSONObject jsonobject = V();
        jsonobject.remove(s1);
        i(jsonobject);
    }

    public Boolean I()
    {
        return Q("screenShotDraft");
    }

    protected boolean I(String s1)
    {
        return V().has(s1);
    }

    public Boolean J()
    {
        return Q("isConversationShowing");
    }

    protected JSONObject J(String s1)
    {
        Object obj;
        try
        {
            s1 = L("notifications").optJSONObject(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getNotifications", s1);
            s1 = null;
        }
        obj = s1;
        if (s1 == null)
        {
            obj = new JSONObject();
        }
        return ((JSONObject) (obj));
    }

    public Boolean K()
    {
        return Q("requireEmail");
    }

    protected void K(String s1)
    {
        String s2;
        s2 = com.helpshift.f.a.c(s1);
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_31;
        }
        JSONObject jsonobject = J(s2);
        jsonobject.put(s1, null);
        b(s2, jsonobject);
        return;
        s1;
        Log.d("HelpShiftDebug", "clearNotification", s1);
        return;
    }

    public Boolean L()
    {
        return Q("fullPrivacy");
    }

    public JSONObject M()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("customMetaData");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "Exception getting meta from storage ", jsonexception);
            return null;
        }
        return jsonobject;
    }

    protected JSONObject N()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("issueCSatStates");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException : ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    public Boolean O()
    {
        return Q("hideNameAndEmail");
    }

    public String P()
    {
        return N("conversationPrefillText");
    }

    public Boolean Q()
    {
        return Q("showSearchOnNewConversation");
    }

    protected JSONObject R()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("cachedAttachmentFiles");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "getCachedAttachmentFiles : ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected JSONObject S()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("downloadedAttachmentFiles");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException : ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected JSONObject T()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("downloadedThumbnailFiles");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "getDownloadedThumbnailFiles ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected JSONObject U()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("downloadedImageFiles");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "getDownloadedImageFiles : ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected JSONObject V()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = L("activeDownloads");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "getActiveDownloads : ", jsonexception);
            return new JSONObject();
        }
        return jsonobject;
    }

    protected String W()
    {
        return N("loginIdentifier");
    }

    public String X()
    {
        return N("sdkLanguage");
    }

    public void Y()
    {
        Boolean boolean1;
        boolean flag2;
        flag2 = false;
        boolean1 = Boolean.valueOf(false);
        JSONObject jsonobject = r();
        Object obj = boolean1;
        boolean flag;
        if (!jsonobject.has("disableHelpshiftBranding"))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        flag = jsonobject.getBoolean("disableHelpshiftBranding");
        obj = Boolean.valueOf(flag);
_L1:
label0:
        {
            boolean1 = Boolean.valueOf(false);
            if (com.helpshift.g.b.a.a.containsKey("hl"))
            {
                JSONException jsonexception;
                boolean flag1;
                if (!((String)com.helpshift.g.b.a.a.get("hl")).equals("true"))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                boolean1 = Boolean.valueOf(flag1);
            }
            if (!((Boolean) (obj)).booleanValue())
            {
                flag1 = flag2;
                if (!boolean1.booleanValue())
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        a("disableHelpshiftBranding", Boolean.valueOf(flag1));
        return;
        jsonexception;
        Log.d("HelpShiftDebug", "isHelpshiftBrandingDisabled", jsonexception);
        jsonexception = boolean1;
          goto _L1
    }

    public boolean Z()
    {
        return Q("disableHelpshiftBranding").booleanValue();
    }

    public Context a()
    {
        return a;
    }

    protected JSONArray a(JSONArray jsonarray, JSONArray jsonarray1)
        throws JSONException
    {
        boolean flag = false;
        HashMap hashmap = new HashMap();
        JSONArray jsonarray2 = new JSONArray();
        ArrayList arraylist = new ArrayList();
        jsonarray = b(jsonarray, jsonarray1);
        for (int i1 = 0; i1 < jsonarray.length(); i1++)
        {
            jsonarray1 = jsonarray.getJSONObject(i1);
            if (!hashmap.containsKey(jsonarray1.get("id")))
            {
                hashmap.put(jsonarray1.get("id").toString(), jsonarray1);
                HashMap hashmap1 = new HashMap();
                hashmap1.put("id", jsonarray1.get("id"));
                hashmap1.put("created_at", jsonarray1.get("created_at"));
                arraylist.add(hashmap1);
            }
        }

        Collections.sort(arraylist, new Comparator() {

            final s a;

            public int a(HashMap hashmap2, HashMap hashmap3)
            {
                int k1;
                try
                {
                    k1 = h.a.parse(hashmap2.get("created_at").toString()).compareTo(h.a.parse(hashmap3.get("created_at").toString()));
                }
                // Misplaced declaration of an exception variable
                catch (HashMap hashmap2)
                {
                    return 0;
                }
                return k1;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((HashMap)obj, (HashMap)obj1);
            }

            
            {
                a = s.this;
                super();
            }
        });
        for (int j1 = ((flag) ? 1 : 0); j1 < arraylist.size(); j1++)
        {
            jsonarray2.put(hashmap.get(((HashMap)arraylist.get(j1)).get("id")));
        }

        return jsonarray2;
    }

    protected void a(int i1)
    {
        a("reviewCounter", Integer.valueOf(i1));
    }

    protected void a(Boolean boolean1)
    {
        a("foreground", boolean1);
    }

    protected void a(Float float1)
    {
        a("serverTimeDelta", float1);
    }

    protected void a(Integer integer)
    {
        Integer integer1 = p();
        if (integer1.intValue() <= integer.intValue())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        JSONArray jsonarray;
        JSONArray jsonarray1;
        int i1;
        int j1;
        int k1;
        try
        {
            jsonarray = o();
            jsonarray1 = new JSONArray();
            j1 = integer1.intValue();
            k1 = integer.intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            Log.d("HelpShiftDebug", "Error while updating breadcrumbs limit", integer);
            return;
        }
        i1 = 0;
        if (i1 >= integer.intValue())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray1.put(i1, jsonarray.get(Integer.valueOf(j1 - k1).intValue() + i1));
        i1++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_45;
_L1:
        a("breadCrumbs", jsonarray1);
    }

    protected void a(String s1)
    {
        Object obj;
        obj = (Boolean)com.helpshift.g.b.a.b.get("dia");
        c("", s1);
        if (((Boolean) (obj)).booleanValue()) goto _L2; else goto _L1
_L1:
        obj = com.helpshift.h.e.b(s1).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L3
_L3:
        String s2;
        Object obj1;
        List list;
        obj1 = (a)((Iterator) (obj)).next();
        s2 = ((a) (obj1)).b();
        obj1 = Integer.valueOf(((a) (obj1)).g());
        list = g(s1);
        if (!((Integer) (obj1)).equals(Integer.valueOf(0)) && !((Integer) (obj1)).equals(Integer.valueOf(1)) && (!((Integer) (obj1)).equals(Integer.valueOf(2)) || !list.contains(s2))) goto _L5; else goto _L4
_L4:
        c(s2, s1);
_L2:
        return;
_L5:
        if (((Integer) (obj1)).equals(Integer.valueOf(3)) && s2.equals(h(s1)))
        {
            d("", s1);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(String s1, int i1, int j1, String s2, String s3)
    {
        String s4;
        JSONObject jsonobject;
        s4 = com.helpshift.f.a.c(s1);
        if (TextUtils.isEmpty(s4))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        jsonobject = J(s4);
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("issueTs", i1);
        jsonobject1.put("newMessageCount", j1);
        jsonobject1.put("chatLaunchSource", s2);
        jsonobject1.put("contentTitle", s3);
        jsonobject.put(s1, jsonobject1);
        b(s4, jsonobject);
        return;
        s1;
        Log.d("HelpShiftDebug", "saveNotification", s1);
        return;
    }

    protected void a(String s1, String s2)
    {
        List list = g(s2);
        if (list.contains(s1))
        {
            list.remove(list.indexOf(s1));
            a(list, s2);
        }
        d(s1, s2);
        a(s2);
    }

    protected void a(String s1, String s2, String s3, String s4, int i1, String s5)
        throws JSONException
    {
        Date date = new Date();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("issue_id", s1);
        jsonobject.put("body", s2);
        jsonobject.put("created_at", h.a.format(date));
        jsonobject.put("type", s3);
        jsonobject.put("state", -1);
        jsonobject.put("origin", "mobile");
        jsonobject.put("refers", s4);
        jsonobject.put("id", (new StringBuilder()).append(date.getTime()).append("").toString());
        jsonobject.put("state", i1);
        a(jsonobject, s5);
    }

    protected void a(String s1, JSONObject jsonobject)
        throws JSONException
    {
        JSONObject jsonobject1 = F();
        jsonobject1.put(s1, jsonobject);
        c("failedApiCalls", jsonobject1);
    }

    protected void a(HashMap hashmap)
    {
        d = hashmap;
        try
        {
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(a.openFileOutput("fullIndex.db", 0));
            objectoutputstream.writeObject(hashmap);
            objectoutputstream.flush();
            objectoutputstream.close();
            C();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Log.d("HelpShiftDebug", "store index", hashmap);
        }
    }

    protected void a(List list, String s1)
    {
        list = new JSONArray(list);
        try
        {
            JSONObject jsonobject = L("openConversations");
            jsonobject.put(s1, list);
            c("openConversations", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Log.d("HelpShiftDebug", "setOpenConversations", list);
        }
    }

    protected void a(JSONArray jsonarray)
    {
        a("cachedImages", jsonarray);
    }

    protected void a(JSONArray jsonarray, String s1)
    {
        com.helpshift.h.e.a(com.helpshift.i.q.a(s1, jsonarray));
        R(s1);
        a(s1);
    }

    protected void a(JSONObject jsonobject)
    {
        c("config", jsonobject);
    }

    protected void a(JSONObject jsonobject, String s1)
        throws JSONException
    {
        JSONArray jsonarray = t(s1);
        jsonarray.put(jsonobject);
        b(jsonarray, s1);
    }

    protected String b()
    {
        return N("identity");
    }

    protected HashMap b(String s1)
    {
        HashMap hashmap = new HashMap();
        String s2 = "";
        try
        {
            s1 = L("issuesTs").optString(s1, "");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getIssuesTs", s1);
            s1 = s2;
        }
        if (!TextUtils.isEmpty(s1))
        {
            hashmap.put("ts", s1);
            hashmap.put("success", Boolean.valueOf(true));
        }
        return hashmap;
    }

    protected void b(int i1)
    {
        a("launchReviewCounter", Integer.valueOf(i1));
    }

    public void b(Boolean boolean1)
    {
        a("screenShotDraft", boolean1);
    }

    protected void b(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("issuesTs");
            jsonobject.put(s2, s1);
            c("issuesTs", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "setIssuesTs", s1);
        }
    }

    protected void b(String s1, JSONObject jsonobject)
    {
        try
        {
            JSONObject jsonobject1 = L("notifications");
            jsonobject1.put(s1, jsonobject);
            c("notifications", jsonobject1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "setNotifications", s1);
        }
    }

    protected void b(JSONArray jsonarray, String s1)
    {
        try
        {
            JSONObject jsonobject = L("failedMessages");
            jsonobject.put(s1, jsonarray);
            c("failedMessages", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            Log.d("HelpShiftDebug", "setFailedMessages", jsonarray);
        }
    }

    protected void b(JSONObject jsonobject)
    {
        c("appConfig", jsonobject);
    }

    protected void c()
    {
        android.content.SharedPreferences.Editor editor = b.edit();
        editor.clear();
        editor.commit();
    }

    public void c(Boolean boolean1)
    {
        a("isConversationShowing", boolean1);
    }

    protected void c(String s1)
    {
        p("identity", s1);
    }

    protected void c(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("activeConversation");
            jsonobject.put(s2, s1);
            c("activeConversation", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "setActiveConversation", s1);
        }
    }

    public void c(JSONObject jsonobject)
    {
        JSONObject jsonobject1 = jsonobject;
        if (jsonobject == null)
        {
            jsonobject1 = new JSONObject();
        }
        c("customMetaData", jsonobject1);
    }

    protected Integer d(String s1)
    {
        Integer integer = Integer.valueOf(0);
        String s2 = f(s1);
        s1 = integer;
        if (!TextUtils.isEmpty(s2))
        {
            s1 = Integer.valueOf(com.helpshift.h.e.a(s2).h());
        }
        return s1;
    }

    protected String d()
    {
        return N("apiKey");
    }

    public void d(Boolean boolean1)
    {
        a("requireEmail", boolean1);
    }

    protected void d(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("archivedConversations");
            jsonobject.put(s2, s1);
            c("archivedConversations", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "setArchivedConversation", s1);
        }
    }

    protected void d(JSONObject jsonobject)
    {
        c("issueCSatStates", jsonobject);
    }

    protected String e()
    {
        return N("domain");
    }

    public void e(Boolean boolean1)
    {
        a("fullPrivacy", boolean1);
    }

    protected void e(String s1)
        throws JSONException
    {
        com.helpshift.f.a.b(s1);
        JSONObject jsonobject = L("pushData");
        jsonobject.put(s1, 0);
        c("pushData", jsonobject);
    }

    public void e(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = y();
            jsonobject.put(s1, s2);
            c("etags", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "set etag", s1);
        }
    }

    protected void e(JSONObject jsonobject)
    {
        c("cachedAttachmentFiles", jsonobject);
    }

    protected String f()
    {
        return N("appId");
    }

    protected String f(String s1)
    {
        try
        {
            s1 = L("activeConversation").optString(s1, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getActiveConversation", s1);
            return null;
        }
        return s1;
    }

    protected JSONObject f(String s1, String s2)
        throws JSONException
    {
        JSONArray jsonarray = t(s2);
        JSONArray jsonarray1 = new JSONArray();
        JSONObject jsonobject = null;
        Object obj = null;
        if (jsonarray.length() > 0)
        {
            int i1 = 0;
            jsonobject = obj;
            while (i1 < jsonarray.length()) 
            {
                JSONObject jsonobject1 = jsonarray.getJSONObject(i1);
                if (jsonobject == null && jsonobject1.getString("id").equals(s1))
                {
                    jsonobject = jsonobject1;
                } else
                {
                    jsonarray1.put(jsonobject1);
                }
                i1++;
            }
            b(jsonarray1, s2);
        }
        return jsonobject;
    }

    protected void f(Boolean boolean1)
    {
        a("hideNameAndEmail", boolean1);
    }

    protected void f(JSONObject jsonobject)
    {
        c("downloadedAttachmentFiles", jsonobject);
    }

    public String g()
    {
        return N("email");
    }

    protected List g(String s1)
    {
        ArrayList arraylist = new ArrayList();
        s1 = L("openConversations").optJSONArray(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        int j1 = s1.length();
        int i1 = 0;
_L3:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(s1.getString(i1));
        i1++;
        if (true) goto _L3; else goto _L2
        s1;
        Log.d("HelpShiftDebug", "getOpenConversations", s1);
_L2:
        return arraylist;
    }

    protected JSONArray g(String s1, String s2)
        throws JSONException
    {
        s2 = t(s2);
        JSONArray jsonarray = new JSONArray();
        for (int i1 = 0; i1 < s2.length(); i1++)
        {
            JSONObject jsonobject = s2.getJSONObject(i1);
            if (jsonobject.getString("issue_id").equals(s1))
            {
                jsonarray.put(jsonobject);
            }
        }

        return jsonarray;
    }

    protected void g(Boolean boolean1)
    {
        a("showSearchOnNewConversation", boolean1);
    }

    protected void g(JSONObject jsonobject)
    {
        c("downloadedThumbnailFiles", jsonobject);
    }

    public String h()
    {
        return N("username");
    }

    protected String h(String s1)
    {
        try
        {
            s1 = L("archivedConversations").optString(s1, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getArchivedConversation", s1);
            return null;
        }
        return s1;
    }

    protected void h(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("allReplyTexts");
            jsonobject.put(s2, s1);
            c("allReplyTexts", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "storeReply", s1);
        }
    }

    protected void h(JSONObject jsonobject)
    {
        c("downloadedImageFiles", jsonobject);
    }

    protected String i()
    {
        String s2 = W();
        String s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = N("deviceId");
        }
        return s1;
    }

    protected void i(String s1)
    {
        p("apiKey", s1);
    }

    protected void i(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("allConversationDetails");
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("conversationText", s1);
            jsonobject1.put("conversationTextSetTime", System.nanoTime());
            jsonobject.put(s2, jsonobject1);
            c("allConversationDetails", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "storeConversationDetail", s1);
        }
    }

    protected void i(JSONObject jsonobject)
    {
        c("activeDownloads", jsonobject);
    }

    public String j()
    {
        return N("deviceToken");
    }

    protected void j(String s1)
    {
        p("domain", s1);
    }

    public void j(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = L("conversationScreenshots");
            jsonobject.put(s2, s1);
            c("conversationScreenshots", jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "setConversationScreenshot", s1);
        }
    }

    public String k()
    {
        return N("foregroundIssue");
    }

    protected void k(String s1)
    {
        p("appId", s1);
    }

    protected void k(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = R();
            jsonobject.put(s1, s2);
            e(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "addToCachedAttachmentFiles : ", s1);
        }
    }

    protected String l()
    {
        return N("libraryVersion");
    }

    protected void l(String s1)
    {
        p("email", s1);
    }

    protected void l(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = S();
            jsonobject.put(s1, s2);
            f(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "addToDownloadedGenericFiles : ", s1);
        }
    }

    protected String m()
    {
        return N("applicationVersion");
    }

    protected void m(String s1)
    {
        p("username", s1);
    }

    protected void m(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = T();
            jsonobject.put(s1, s2);
            g(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "addToDownloadedThumbnailFiles : ", s1);
        }
    }

    protected String n()
    {
        return N("sdkType");
    }

    protected void n(String s1)
    {
        p("foregroundIssue", s1);
    }

    protected void n(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = U();
            jsonobject.put(s1, s2);
            h(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "addToDownloadedImageFiles : ", s1);
        }
    }

    public JSONArray o()
        throws JSONException
    {
        return M("breadCrumbs");
    }

    protected void o(String s1)
    {
        p("libraryVersion", s1);
    }

    protected void o(String s1, String s2)
    {
        try
        {
            JSONObject jsonobject = V();
            jsonobject.put(s1, s2);
            i(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "addToActiveDownloads : ", s1);
        }
    }

    protected Integer p()
    {
        Integer integer;
        try
        {
            integer = (Integer)q().get("bcl");
        }
        catch (JSONException jsonexception)
        {
            return Integer.valueOf(10);
        }
        return integer;
    }

    protected void p(String s1)
    {
        p("applicationVersion", s1);
    }

    protected JSONObject q()
        throws JSONException
    {
        return L("config");
    }

    protected void q(String s1)
    {
        p("sdkType", s1);
    }

    public JSONObject r()
        throws JSONException
    {
        return L("appConfig");
    }

    protected void r(String s1)
    {
        int j1 = p().intValue();
        JSONArray jsonarray;
        int k1;
        jsonarray = o();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("action", s1);
        jsonobject.put("datetime", h.b.format(new Date()));
        jsonarray.put(jsonobject);
        k1 = jsonarray.length();
        if (k1 <= j1) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray1 = new JSONArray();
        int i1 = 0;
_L4:
        s1 = jsonarray1;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray1.put(i1, jsonarray.get(i1 + (k1 - j1)));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            a("breadCrumbs", s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "Error while leaving breadcrumb", s1);
        }
        return;
_L2:
        s1 = jsonarray;
        if (true) goto _L3; else goto _L5
_L5:
    }

    protected int s()
    {
        return O("reviewCounter").intValue();
    }

    protected String s(String s1)
    {
        try
        {
            s1 = y().optString(s1, "");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "set etag", s1);
            return "";
        }
        return s1;
    }

    protected int t()
    {
        return O("launchReviewCounter").intValue();
    }

    protected JSONArray t(String s1)
        throws JSONException
    {
        Object obj;
        try
        {
            s1 = L("failedMessages").optJSONArray(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getFailedMessages", s1);
            s1 = null;
        }
        obj = s1;
        if (s1 == null)
        {
            obj = new JSONArray();
        }
        return ((JSONArray) (obj));
    }

    protected JSONObject u(String s1)
        throws JSONException
    {
        JSONArray jsonarray = t(s1);
        JSONArray jsonarray1 = new JSONArray();
        JSONObject jsonobject = null;
        Object obj = null;
        if (jsonarray.length() > 0)
        {
            int i1 = 0;
            jsonobject = obj;
            while (i1 < jsonarray.length()) 
            {
                JSONObject jsonobject1 = jsonarray.getJSONObject(i1);
                if (jsonobject == null && jsonobject1.getInt("state") > -2)
                {
                    jsonobject = jsonobject1;
                } else
                {
                    jsonarray1.put(jsonobject1);
                }
                i1++;
            }
            b(jsonarray1, s1);
        }
        return jsonobject;
    }

    protected void u()
    {
        a("reviewed", Integer.valueOf(1));
    }

    protected String v(String s1)
    {
        try
        {
            s1 = L("allReplyTexts").optString(s1, "");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "storeReply", s1);
            return "";
        }
        return s1;
    }

    protected void v()
    {
        a("reviewed", Integer.valueOf(0));
    }

    protected int w()
    {
        return O("reviewed").intValue();
    }

    protected String w(String s1)
    {
        JSONObject jsonobject = L("allConversationDetails").optJSONObject(s1);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        long l1 = System.nanoTime() - jsonobject.getLong("conversationTextSetTime");
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (TimeUnit.NANOSECONDS.toSeconds(l1) <= 7200L)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        i(s1, "");
        return "";
        s1 = jsonobject.getString("conversationText");
        return s1;
        s1;
        Log.d("HelpShiftDebug", "getConversationDetail", s1);
        return "";
    }

    protected JSONArray x()
        throws JSONException
    {
        return M("cachedImages");
    }

    protected void x(String s1)
    {
        p("uuid", s1);
    }

    public String y(String s1)
    {
        try
        {
            s1 = L("conversationScreenshots").optString(s1, "");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getConversationScreenshot", s1);
            return "";
        }
        return s1;
    }

    protected JSONObject y()
        throws JSONException
    {
        return L("etags");
    }

    protected void z()
    {
        if (d != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        ObjectInputStream objectinputstream = new ObjectInputStream(a.openFileInput("fullIndex.db"));
        d = (HashMap)objectinputstream.readObject();
        objectinputstream.close();
        return;
        Exception exception;
        exception;
        Log.d("HelpShiftDebug", "read index", exception);
        return;
    }

    public void z(String s1)
    {
        p("conversationPrefillText", s1);
    }
}
