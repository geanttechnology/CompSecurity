// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.helpshift.f.a;
import com.helpshift.h.c;
import com.helpshift.h.e;
import com.helpshift.h.h;
import com.helpshift.h.i;
import com.helpshift.i.j;
import com.helpshift.i.k;
import com.helpshift.i.q;
import com.helpshift.i.u;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            s, k, y, ab, 
//            g, q, v, n, 
//            o, HSService

public final class l
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        private static final a g[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/helpshift/l$a, s1);
        }

        public static a[] values()
        {
            return (a[])g.clone();
        }

        static 
        {
            a = new a("CSAT_NOT_APPLICABLE", 0);
            b = new a("CSAT_APPLICABLE", 1);
            c = new a("CSAT_REQUESTED", 2);
            d = new a("CSAT_INPROGRESS", 3);
            e = new a("CSAT_DONE", 4);
            f = new a("CSAT_RETRYING", 5);
            g = (new a[] {
                a, b, c, d, e, f
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public static ArrayList d = null;
    protected static boolean e = false;
    public s a;
    public com.helpshift.k b;
    Iterator c;
    private y f;
    private h g;
    private com.helpshift.h.a h;
    private ArrayList i;
    private final int j = 10;
    private Context k;

    public l(Context context)
    {
        i = null;
        c = null;
        k = context;
        a = new s(context);
        b = new com.helpshift.k(a.e(), a.f(), a.d(), a);
        g = new i();
        h = new c();
        f = com.helpshift.y.a();
    }

    private void E()
    {
        ArrayList arraylist = a();
        i = new ArrayList();
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            ArrayList arraylist1 = b(((ab)arraylist.get(i1)).a());
            for (int j1 = 0; j1 < arraylist1.size(); j1++)
            {
                g g1 = (g)arraylist1.get(j1);
                i.add(g1);
            }

        }

    }

    private String F()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        Iterator iterator = com.helpshift.h.e.b(B()).iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                com.helpshift.f.a a1 = (com.helpshift.f.a)iterator.next();
                List list = a1.i();
                int i1 = list.size() - 1;
                do
                {
                    if (i1 <= 0)
                    {
                        continue label0;
                    }
                    com.helpshift.f.c c1 = (com.helpshift.f.c)list.get(i1);
                    if (!c1.b().startsWith("localRscMessage_"))
                    {
                        jsonobject.put(a1.b(), c1.f());
                        continue label0;
                    }
                    i1--;
                } while (true);
            }
            if (!(jsonobject instanceof JSONObject))
            {
                return jsonobject.toString();
            }
            return JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        } while (true);
    }

    private void G()
    {
        a.E();
        E();
        HashMap hashmap = com.helpshift.q.a(new ArrayList(i));
        if (hashmap != null)
        {
            a.a(hashmap);
        }
    }

    static h a(l l1)
    {
        return l1.g;
    }

    static Boolean a(l l1, Integer integer)
    {
        return l1.a(integer);
    }

    private Boolean a(Integer integer)
    {
        if (integer.intValue() >= 400 && integer.intValue() < 600 && integer.intValue() != 503 && integer.intValue() != 504)
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    static String a(l l1, String s1)
    {
        return l1.j(s1);
    }

    private JSONObject a(int i1, String s1)
    {
        JSONObject jsonobject = new JSONObject();
        i1;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 38
    //                   2 63
    //                   3 83;
           goto _L1 _L2 _L3 _L4
_L1:
        return jsonobject;
_L2:
        try
        {
            jsonobject.put("reason", i1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "getRfrFailedMessageMeta", s1);
            return jsonobject;
        }
        return jsonobject;
_L3:
        jsonobject.put("reason", i1);
        jsonobject.put("open-issue-id", s1);
        return jsonobject;
_L4:
        jsonobject.put("reason", i1);
        return jsonobject;
    }

    private JSONObject a(JSONObject jsonobject)
    {
        try
        {
            jsonobject.getJSONObject("device_info").remove("country-code");
            jsonobject.getJSONObject("custom_meta").remove("private-data");
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "Exception is filtering metaData ", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    private void a(Handler handler, int i1)
    {
        Message message = handler.obtainMessage();
        HashMap hashmap = new HashMap();
        hashmap.put("status", Integer.valueOf(i1));
        message.obj = hashmap;
        handler.sendMessage(message);
    }

    private void a(Handler handler, Handler handler1, String s1, String s2)
    {
        if (!TextUtils.isEmpty(s2))
        {
            handler = new Handler(handler) {

                final Handler a;
                final l b;

                public void handleMessage(Message message)
                {
                    Message message1 = a.obtainMessage();
                    message1.obj = message.obj;
                    a.sendMessage(message1);
                    b.t();
                }

            
            {
                b = l.this;
                a = handler;
                super();
            }
            };
            handler1 = new Handler(handler1) {

                final Handler a;
                final l b;

                public void handleMessage(Message message)
                {
                    Message message1 = a.obtainMessage();
                    message1.obj = message.obj;
                    a.sendMessage(message1);
                }

            
            {
                b = l.this;
                a = handler;
                super();
            }
            };
            b.a(handler, handler1, s2, s1);
        }
    }

    private void a(Handler handler, Handler handler1, String s1, String s2, String s3, Boolean boolean1)
        throws JSONException
    {
        a(handler, handler1, s1, s2, s3, boolean1, ((String) (null)));
    }

    private void a(Handler handler, Handler handler1, String s1, String s2, String s3, Boolean boolean1, String s4)
        throws JSONException
    {
        handler = new Handler(handler, boolean1, handler1) {

            final Handler a;
            final Boolean b;
            final Handler c;
            final l d;

            public void handleMessage(Message message)
            {
                String s5;
                JSONArray jsonarray1;
                JSONObject jsonobject;
                JSONArray jsonarray3;
                int i1;
                int j1;
                Object obj;
                JSONArray jsonarray;
                JSONArray jsonarray2;
                JSONObject jsonobject1;
                JSONObject jsonobject2;
                JSONObject jsonobject3;
                int k1;
                int l1;
                int i2;
                int j2;
                try
                {
                    message = (JSONObject)((HashMap)message.obj).get("response");
                    s5 = message.getString("timestamp");
                    jsonarray = message.getJSONArray("issues");
                    jsonarray1 = new JSONArray();
                    l1 = jsonarray.length();
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", "JSON Exception!!!", message);
                    return;
                }
                if (l1 <= 0)
                {
                    break MISSING_BLOCK_LABEL_527;
                }
                i1 = 0;
_L9:
                if (i1 >= l1)
                {
                    break MISSING_BLOCK_LABEL_527;
                }
                jsonobject = jsonarray.getJSONObject(i1);
                jsonarray2 = jsonobject.getJSONArray("messages");
                i2 = jsonarray2.length();
                jsonarray3 = new JSONArray();
                j1 = 0;
_L8:
                if (j1 >= i2) goto _L2; else goto _L1
_L1:
                jsonobject1 = jsonarray2.getJSONObject(j1);
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
                j2 = message.length();
                if (j2 <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                k1 = 0;
_L5:
                if (k1 >= j2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                jsonobject2 = message.getJSONObject(k1);
                jsonobject3 = new JSONObject();
                jsonobject3.put("issue_id", jsonobject1.getString("issue_id"));
                jsonobject3.put("author", jsonobject1.getJSONObject("author"));
                jsonobject3.put("meta", new JSONObject());
                jsonobject3.put("id", (new StringBuilder()).append(jsonobject1.getString("id")).append("_").append(k1).toString());
                if (jsonobject2 instanceof JSONObject) goto _L4; else goto _L3
_L3:
                obj = jsonobject2.toString();
_L6:
                jsonobject3.put("body", obj);
                jsonobject3.put("origin", jsonobject1.getString("origin"));
                obj = jsonobject1.getString("created_at");
                jsonobject3.put("created_at", com.helpshift.i.h.a(com.helpshift.i.h.d, ((String) (obj)), k1 + 1));
                if (!Boolean.valueOf(jsonobject2.optBoolean("image", false)).booleanValue())
                {
                    break MISSING_BLOCK_LABEL_439;
                }
                jsonobject3.put("type", "admin_attachment_image");
_L7:
                jsonarray3.put(jsonobject3);
                k1++;
                  goto _L5
_L4:
                obj = JSONObjectInstrumentation.toString((JSONObject)jsonobject2);
                  goto _L6
                jsonobject3.put("type", "admin_attachment_generic");
                  goto _L7
                j1++;
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
                i1++;
                  goto _L9
                message = JSONArrayInstrumentation.toString((JSONArray)jsonarray3);
                  goto _L10
                if (jsonarray1 instanceof JSONArray) goto _L12; else goto _L11
_L11:
                message = jsonarray1.toString();
_L15:
                Message message1;
                message = JSONArrayInstrumentation.init(message);
                d.a.b(s5, d.B());
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
                com.helpshift.l.a(d, message);
                return;
_L12:
                message = JSONArrayInstrumentation.toString((JSONArray)jsonarray1);
                  goto _L15
_L14:
                com.helpshift.l.a(d, c, -1);
                  goto _L16
                message1.obj = com.helpshift.h.e.b(d.B());
                a.sendMessage(message1);
                  goto _L16
            }

            
            {
                d = l.this;
                a = handler;
                b = boolean1;
                c = handler1;
                super();
            }
        };
        b.b(handler, handler1, s1, s2, s3, s4);
    }

    private void a(Handler handler, Handler handler1, HashMap hashmap)
    {
        b.a(handler, handler1, hashmap);
    }

    private void a(Handler handler, Handler handler1, JSONArray jsonarray, String s1, String s2)
    {
        b.a(jsonarray, s1, s2, handler, handler1);
    }

    static void a(l l1, Handler handler, int i1)
    {
        l1.a(handler, i1);
    }

    static void a(l l1, JSONArray jsonarray)
    {
        l1.a(jsonarray);
    }

    protected static void a(n n1)
    {
        if (d == null)
        {
            d = new ArrayList();
        }
        d.add(n1);
    }

    private void a(String s1, JSONObject jsonobject)
    {
        String s2 = com.helpshift.v.b();
        String s3 = a.f(B());
        if ("issue-filing".equals(s2))
        {
            a(s1, jsonobject, a(1, ((String) (null))));
            return;
        }
        if ("message-filing".equals(s2))
        {
            a(s1, jsonobject, a(3, ((String) (null))));
            return;
        }
        if (!TextUtils.isEmpty(s3) && !s3.equals(s1))
        {
            a(s1, jsonobject, a(2, s3));
            return;
        } else
        {
            b(s1, jsonobject);
            return;
        }
    }

    private void a(String s1, JSONObject jsonobject, JSONObject jsonobject1)
    {
        Object obj = null;
        try
        {
            jsonobject = jsonobject.getString("id");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.d("HelpShiftDebug", "rfrRejected", jsonobject);
            jsonobject = obj;
        }
        a(new Handler(), new Handler(), s1, "Rejected the follow-up", "rj", ((String) (jsonobject)), jsonobject1);
    }

    private void a(JSONArray jsonarray)
    {
        int i1 = 0;
_L2:
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = jsonarray.getJSONObject(i1);
        Object obj = jsonobject.getJSONArray("messages");
        if (((JSONArray) (obj)).length() > 0)
        {
            obj = ((JSONArray) (obj)).getJSONObject(((JSONArray) (obj)).length() - 1);
            if (((JSONObject) (obj)).getString("origin").equals("admin") && ((JSONObject) (obj)).getString("type").equals("rfr"))
            {
                a(jsonobject.getString("id"), ((JSONObject) (obj)));
            }
        }
        i1++;
        if (true) goto _L2; else goto _L1
        jsonarray;
        Log.d("HelpShiftDebug", "rfrCheck", jsonarray);
_L1:
    }

    static void b(l l1)
    {
        l1.G();
    }

    protected static void b(n n1)
    {
        if (d != null)
        {
            d.remove(n1);
        }
    }

    private void b(String s1, JSONObject jsonobject)
    {
        Handler handler = null;
        try
        {
            jsonobject = jsonobject.getString("id");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.d("HelpShiftDebug", "rfrAccepted", jsonobject);
            jsonobject = handler;
        }
        handler = new Handler(s1) {

            final String a;
            final l b;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                int i1;
                int j1;
                try
                {
                    message = com.helpshift.h.e.a(a);
                    i1 = message.h();
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", "rfrAccepted", message);
                    return;
                }
                if (i1 == 0)
                {
                    break MISSING_BLOCK_LABEL_85;
                }
                if (!a.equals(b.a.k()))
                {
                    j1 = (int)com.helpshift.i.h.a.parse(message.e()).getTime();
                    com.helpshift.i.k.a(com.helpshift.l.c(b), a, j1, i1, "inapp", com.helpshift.i.k.a(com.helpshift.l.c(b)));
                }
            }

            
            {
                b = l.this;
                a = s1;
                super();
            }
        };
        com.helpshift.f.a.a(s1);
        a(handler, new Handler(), s1, "Accepted the follow-up", "ra", jsonobject);
    }

    private void b(JSONArray jsonarray)
    {
        String s8 = n();
        String s9 = B();
        Object obj = b;
        String s1 = a.n();
        obj = l();
        String s2 = Build.MODEL;
        String s3 = android.os.Build.VERSION.RELEASE;
        String s4 = com.helpshift.i.u.a(a.a());
        String s5 = (new StringBuilder()).append(System.getProperty("os.version")).append(":").append(Build.FINGERPRINT).toString();
        String s6 = ((TelephonyManager)k.getSystemService("phone")).getSimCountryIso();
        String s7 = Locale.getDefault().getLanguage();
        HashMap hashmap;
        if (s8.equals(obj))
        {
            obj = null;
        }
        hashmap = new HashMap();
        hashmap.put("id", s8);
        if (obj != null)
        {
            hashmap.put("uid", obj);
        }
        if (!TextUtils.isEmpty(s9))
        {
            hashmap.put("profile-id", s9);
        }
        hashmap.put("v", "3.9.1");
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        hashmap.put("e", jsonarray);
        hashmap.put("s", s1);
        hashmap.put("dm", s2);
        hashmap.put("os", s3);
        hashmap.put("av", s4);
        hashmap.put("rs", s5);
        if (!TextUtils.isEmpty(s6))
        {
            hashmap.put("cc", s6);
        }
        hashmap.put("ln", s7);
        jsonarray = (new StringBuilder()).append("action_event_").append(Long.toString(System.currentTimeMillis())).toString();
        jsonarray = a(new Handler(), jsonarray, 2, new JSONObject(hashmap));
        a(new Handler(), jsonarray, hashmap);
    }

    static Context c(l l1)
    {
        return l1.k;
    }

    static com.helpshift.h.a d(l l1)
    {
        return l1.h;
    }

    private void d(String s1, Handler handler, Handler handler1)
    {
        handler = new Handler(handler) {

            final Handler a;
            final l b;

            public void handleMessage(Message message)
            {
                Message message1;
                message1 = a.obtainMessage();
                message = (HashMap)message.obj;
                if (message == null)
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                String s2;
                String s3;
                String s4;
                String s5;
                String s6;
                message = (JSONObject)message.get("response");
                s2 = message.getString("id");
                s3 = message.getString("publish_id");
                s4 = com.helpshift.l.a(b, message.getString("section_id"));
                s5 = message.getString("title");
                s6 = message.getString("body");
                boolean flag;
                if (message.getString("is_rtl") == "true")
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!message.has("stags"))
                {
                    break MISSING_BLOCK_LABEL_163;
                }
                message = com.helpshift.i.j.a(message.getString("stags"));
_L2:
                message = new g(0L, s2, s3, s4, s5, s6, 0, Boolean.valueOf(flag), message);
                message1.obj = message;
                a.sendMessage(message1);
                l.d(b).a(message);
                return;
                message = new ArrayList();
                if (true) goto _L2; else goto _L1
_L1:
                message;
                Log.d("HelpShiftDebug", (new StringBuilder()).append("Exception in getting question ").append(message).toString());
            }

            
            {
                b = l.this;
                a = handler;
                super();
            }
        };
        b.a(s1, handler, handler1);
    }

    private void g(Handler handler, Handler handler1)
        throws SQLException
    {
        handler = new Handler(handler) {

            final Handler a;
            final l b;

            public void handleMessage(Message message)
            {
                message = (HashMap)message.obj;
                if (message != null)
                {
                    message = (JSONArray)message.get("response");
                    com.helpshift.l.a(b).b();
                    com.helpshift.l.a(b).a(message);
                    message = a.obtainMessage();
                    message.obj = com.helpshift.l.a(b).a();
                    a.sendMessage(message);
                    message = new Thread(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            l.b(a.b);
                            l.y();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    message.setDaemon(true);
                    message.start();
                }
                l.x();
            }

            
            {
                b = l.this;
                a = handler;
                super();
            }
        };
        handler1 = new Handler(handler1) {

            final Handler a;
            final l b;

            public void handleMessage(Message message)
            {
                message = (HashMap)message.obj;
                com.helpshift.l.e = false;
                Message message1 = a.obtainMessage();
                message1.obj = message;
                a.sendMessage(message1);
            }

            
            {
                b = l.this;
                a = handler;
                super();
            }
        };
        e = true;
        b.a(handler, handler1);
    }

    private void h(Handler handler, Handler handler1)
        throws JSONException
    {
        handler = new Handler(handler) {

            final Handler a;
            final l b;

            public void handleMessage(Message message)
            {
                message = (HashMap)message.obj;
                if (message == null)
                {
                    break MISSING_BLOCK_LABEL_152;
                }
                message = (JSONObject)message.get("response");
                if (b.a.p().intValue() != message.optInt("bcl", 10))
                {
                    b.a.a(Integer.valueOf(message.optInt("bcl", 10)));
                }
                Object obj;
                JSONObject jsonobject;
                obj = b.a.q().optJSONObject("pr");
                jsonobject = message.optJSONObject("pr");
                if (obj != null)
                {
                    try
                    {
                        if (!((JSONObject) (obj)).getString("t").equals(jsonobject.getString("t")))
                        {
                            b.i();
                        }
                    }
                    catch (JSONException jsonexception)
                    {
                        Log.d("HelpShiftDebug", "Reseting counter", jsonexception);
                    }
                }
                b.a.a(message);
                obj = a.obtainMessage();
                obj.obj = message;
                a.sendMessage(((Message) (obj)));
            }

            
            {
                b = l.this;
                a = handler;
                super();
            }
        };
        b.b(handler, handler1);
    }

    private String j(String s1)
    {
        ArrayList arraylist = a();
        String s2 = "";
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            ab ab1 = (ab)arraylist.get(i1);
            if (ab1.c().equals(s1))
            {
                s2 = ab1.a();
            }
        }

        return s2;
    }

    protected static void x()
    {
        e = false;
        if (d != null)
        {
            for (int i1 = 0; i1 < d.size(); i1++)
            {
                n n1 = (n)d.get(i1);
                if (n1 != null)
                {
                    n1.a();
                }
            }

        }
    }

    protected static void y()
    {
        if (d != null)
        {
            for (int i1 = 0; i1 < d.size(); i1++)
            {
                n n1 = (n)d.get(i1);
                if (n1 != null)
                {
                    n1.b();
                }
            }

        }
    }

    protected String A()
    {
        String s1 = a.W();
        if (TextUtils.isEmpty(s1))
        {
            return m();
        } else
        {
            return f.a(s1).b();
        }
    }

    public String B()
    {
        String s1 = a.W();
        if (TextUtils.isEmpty(s1))
        {
            return a.b();
        } else
        {
            return f.b(s1);
        }
    }

    public String C()
    {
        String s1 = a.W();
        if (TextUtils.isEmpty(s1))
        {
            return a.h();
        } else
        {
            return f.c(s1);
        }
    }

    public String D()
    {
        String s1 = a.W();
        if (TextUtils.isEmpty(s1))
        {
            return a.g();
        } else
        {
            return f.d(s1);
        }
    }

    protected Handler a(Handler handler, String s1, int i1, JSONObject jsonobject)
    {
        return new Handler(handler, i1, jsonobject, s1) {

            final Handler a;
            final int b;
            final JSONObject c;
            final String d;
            final l e;

            public void handleMessage(Message message)
            {
                Message message1 = a.obtainMessage();
                message1.obj = message.obj;
                a.sendMessage(message1);
                message = (Integer)((HashMap)message.obj).get("status");
                if (com.helpshift.l.a(e, message).booleanValue())
                {
                    message = new JSONObject();
                    message.put("t", b);
                    message.put("p", c);
                    e.a.a(d, message);
                    return;
                }
                try
                {
                    e.a.a(d, null);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", "JSONException", message);
                }
                return;
            }

            
            {
                e = l.this;
                a = handler;
                b = i1;
                c = jsonobject;
                d = s1;
                super();
            }
        };
    }

    protected Boolean a(String s1, a a1)
    {
        Boolean boolean1;
        JSONObject jsonobject;
        Object obj;
        obj = a.N();
        boolean1 = Boolean.valueOf(false);
        jsonobject = ((JSONObject) (obj));
        if (obj == null)
        {
            jsonobject = new JSONObject();
        }
        obj = boolean1;
        if (a1 == a.f)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = boolean1;
        if (a1 == com.helpshift.a.e)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = boolean1;
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Boolean boolean2;
        boolean2 = boolean1;
        obj = boolean1;
        if (jsonobject.getInt(s1) == com.helpshift.a.e.ordinal())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        boolean2 = boolean1;
        obj = boolean1;
        if (jsonobject.getInt(s1) == a.f.ordinal())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = boolean1;
        try
        {
            jsonobject.put(s1, a1.ordinal());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "JSONException : ", s1);
            return ((Boolean) (obj));
        }
        obj = boolean1;
        boolean2 = Boolean.valueOf(true);
        obj = boolean2;
        a.d(jsonobject);
        return boolean2;
    }

    protected ArrayList a()
    {
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)g.a();
        }
        catch (SQLException sqlexception)
        {
            Log.d("HelpShiftDebug", "Database exception in getting sections data ", sqlexception);
            return null;
        }
        return arraylist;
    }

    protected ArrayList a(String s1)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            s1 = (ArrayList)h.c(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "Database exception in getting faqs for section", s1);
            return arraylist;
        }
        return s1;
    }

    protected ArrayList a(String s1, q.a a1)
    {
        HashMap hashmap = null;
        Object obj1;
        LinkedHashSet linkedhashset;
        if (i == null)
        {
            E();
        } else
        {
            obj1 = i.iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                ((g)((Iterator) (obj1)).next()).k();
            }
        }
        linkedhashset = new LinkedHashSet();
        obj1 = s1.toLowerCase();
        if (a.B().booleanValue())
        {
            HashMap hashmap2 = a.A();
            int i1;
            if (hashmap2 != null)
            {
                obj1 = (HashMap)hashmap2.get("i");
                hashmap = (HashMap)hashmap2.get("f");
            } else
            {
                obj1 = null;
            }
            a1 = com.helpshift.q.a(s1, ((HashMap) (obj1)), a1);
            s1 = com.helpshift.q.a(s1, hashmap);
            for (a1 = a1.iterator(); a1.hasNext(); linkedhashset.add(obj1))
            {
                HashMap hashmap1 = (HashMap)a1.next();
                obj1 = (String)hashmap1.get("f");
                obj1 = (g)i.get(Integer.decode(((String) (obj1))).intValue());
                ((g) (obj1)).a((ArrayList)hashmap1.get("t"));
            }

            Object obj;
            for (s1 = s1.iterator(); s1.hasNext(); linkedhashset.add(obj))
            {
                a1 = (HashMap)s1.next();
                obj = (String)a1.get("f");
                obj = (g)i.get(Integer.decode(((String) (obj))).intValue());
                ((g) (obj)).a((ArrayList)a1.get("t"));
            }

        } else
        {
            for (i1 = 0; i1 < i.size(); i1++)
            {
                s1 = (g)i.get(i1);
                if (s1.e().toLowerCase().indexOf(((String) (obj1))) != -1)
                {
                    linkedhashset.add(s1);
                }
            }

        }
        return new ArrayList(linkedhashset);
    }

    protected ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            if (!a((ab)arraylist.get(i1)))
            {
                arraylist1.add(arraylist.get(i1));
            }
        }

        return arraylist1;
    }

    protected JSONObject a(Boolean boolean1)
    {
        if (q().booleanValue())
        {
            return com.helpshift.i.u.a(k, boolean1, l());
        } else
        {
            return com.helpshift.i.u.a(k, boolean1, null);
        }
    }

    protected JSONObject a(Boolean boolean1, HashMap hashmap)
    {
        boolean1 = a(boolean1);
        if (hashmap != null)
        {
            try
            {
                boolean1.put("user_info", new JSONObject(hashmap));
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                Log.d("HelpShiftDebug", "userInfo JSONException", hashmap);
            }
        }
        if (a.L().booleanValue())
        {
            a(((JSONObject) (boolean1)));
        }
        return boolean1;
    }

    protected void a(Handler handler, Handler handler1)
    {
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)g.a();
        }
        catch (SQLException sqlexception)
        {
            Log.d("HelpShiftDebug", "Database exception in getting sections data ", sqlexception);
            sqlexception = null;
        }
        if (arraylist != null && arraylist.size() > 0)
        {
            Message message = handler.obtainMessage();
            message.obj = arraylist;
            handler.sendMessage(message);
            g(handler, handler1);
            return;
        } else
        {
            g(handler, handler1);
            return;
        }
    }

    protected void a(Handler handler, Handler handler1, String s1)
        throws JSONException
    {
        HashMap hashmap = a.b(B());
        String s2 = B();
        if (!TextUtils.isEmpty(s2))
        {
            if (hashmap.containsKey("success"))
            {
                a(handler, handler1, s2, (String)hashmap.get("ts"), F(), Boolean.valueOf(true), s1);
                return;
            } else
            {
                a(handler, handler1, s2, "", "", Boolean.valueOf(true), s1);
                return;
            }
        } else
        {
            a(handler1, 403);
            return;
        }
    }

    protected void a(Handler handler, Handler handler1, String s1, Boolean boolean1)
    {
        handler = new Handler(s1, boolean1, handler, handler1) {

            final String a;
            final Boolean b;
            final Handler c;
            final Handler d;
            final l e;

            public void handleMessage(Message message)
            {
                try
                {
                    if (((JSONObject)((HashMap)message.obj).get("response")).getString("status").equals("marked"))
                    {
                        l.d(e).a(a, b);
                        message = c.obtainMessage();
                        message.obj = b;
                        c.sendMessage(message);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Message message1 = d.obtainMessage();
                    d.sendMessage(message1);
                    Log.d("HelpShiftDebug", "JSON Exception", message);
                    return;
                }
            }

            
            {
                e = l.this;
                a = s1;
                b = boolean1;
                c = handler;
                d = handler1;
                super();
            }
        };
        handler1 = new Handler(s1, boolean1, handler1) {

            final String a;
            final Boolean b;
            final Handler c;
            final l d;

            public void handleMessage(Message message)
            {
                l.d(d).a(a, b);
                Message message1 = c.obtainMessage();
                message1.obj = message.obj;
                c.sendMessage(message1);
            }

            
            {
                d = l.this;
                a = s1;
                b = boolean1;
                c = handler;
                super();
            }
        };
        if (boolean1.booleanValue())
        {
            b.a(handler, handler1, s1);
            return;
        } else
        {
            b.b(handler, handler1, s1);
            return;
        }
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3)
    {
        String s4 = null;
        String s5 = (String)Class.forName("com.crittercism.app.Crittercism").getMethod("getUserUUID", (Class[])null).invoke(null, (Object[])null);
        s4 = s5;
_L2:
        handler = new Handler(handler) {

            final Handler a;
            final l b;

            public void handleMessage(Message message)
            {
                Message message1 = a.obtainMessage();
                message1.obj = message.obj;
                a.sendMessage(message1);
            }

            
            {
                b = l.this;
                a = handler;
                super();
            }
        };
        b.a(handler, handler1, s1, s2, s3, s4);
        return;
        Object obj;
        obj;
        Log.d("HelpShiftDebug", "If you are not using Crittercism. Please ignore this", ((Throwable) (obj)));
        continue; /* Loop/switch isn't completed */
        obj;
        Log.d("HelpShiftDebug", "If you are not using Crittercism. Please ignore this", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4)
    {
        a(handler, handler1, s1, s2, s3, s4, -1, null);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, int i1)
    {
        a(handler, handler1, s1, s2, s3, s4, i1, null);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, int i1, 
            String s5)
    {
        String s6 = B();
        handler1 = new Handler(s1, s2, s3, s4, i1, s6, handler1) {

            final String a;
            final String b;
            final String c;
            final String d;
            final int e;
            final String f;
            final Handler g;
            final l h;

            public void handleMessage(Message message)
            {
                Message message1;
                try
                {
                    h.a.a(a, b, c, d, e, f);
                }
                catch (JSONException jsonexception)
                {
                    Log.d("HelpShiftDebug", "JSON Exception", jsonexception);
                }
                message1 = g.obtainMessage();
                message1.obj = (HashMap)message.obj;
                g.sendMessage(message1);
            }

            
            {
                h = l.this;
                a = s1;
                b = s2;
                c = s3;
                d = s4;
                e = i1;
                f = s5;
                g = handler;
                super();
            }
        };
        b.a(handler, handler1, s6, s1, s2, s3, s4, s5);
    }

    protected void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, JSONObject jsonobject)
    {
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        a(handler, handler1, s1, s2, s3, s4, -1, ((String) (jsonobject)));
    }

    protected void a(Handler handler, Handler handler1, String s1, HashMap hashmap)
        throws com.helpshift.c.a
    {
        String s2 = B();
        if (!TextUtils.isEmpty(s2))
        {
            JSONObject jsonobject = a(Boolean.valueOf(true), hashmap);
            hashmap = new Handler(jsonobject, handler, handler1, s2, s1) {

                final JSONObject a;
                final Handler b;
                final Handler c;
                final String d;
                final String e;
                final l f;

                public void handleMessage(Message message)
                {
                    message = (HashMap)message.obj;
                    if (((Integer)message.get("status")).intValue() == 413)
                    {
                        a.remove("custom_meta");
                        com.helpshift.k k2 = f.b;
                        Handler handler2 = b;
                        Handler handler3 = c;
                        String s3 = d;
                        String s4 = e;
                        message = a;
                        if (!(message instanceof JSONObject))
                        {
                            message = message.toString();
                        } else
                        {
                            message = JSONObjectInstrumentation.toString((JSONObject)message);
                        }
                        k2.a(handler2, handler3, s3, s4, message);
                        return;
                    } else
                    {
                        Message message1 = c.obtainMessage();
                        message1.obj = message;
                        c.sendMessage(message1);
                        return;
                    }
                }

            
            {
                f = l.this;
                a = jsonobject;
                b = handler;
                c = handler1;
                d = s1;
                e = s2;
                super();
            }
            };
            com.helpshift.k k1 = b;
            if (!(jsonobject instanceof JSONObject))
            {
                handler1 = jsonobject.toString();
            } else
            {
                handler1 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            k1.a(handler, hashmap, s2, s1, handler1);
            return;
        } else
        {
            throw new com.helpshift.c.a("Identity not found");
        }
    }

    protected void a(Integer integer, String s1, String s2, Handler handler, Handler handler1)
    {
        if (integer.intValue() > 0 && integer.intValue() <= 5)
        {
            s1 = s1.trim();
            a a1 = f(s2);
            if (a1 == com.helpshift.a.c || a1 == a.f)
            {
                Handler handler2 = new Handler(handler, s2) {

                    final Handler a;
                    final String b;
                    final l c;

                    public void handleMessage(Message message)
                    {
                        if (message.obj != null)
                        {
                            message = a.obtainMessage();
                            HashMap hashmap = new HashMap();
                            hashmap.put("status", Integer.valueOf(200));
                            hashmap.put("id", b);
                            message.obj = hashmap;
                            a.sendMessage(message);
                        }
                    }

            
            {
                c = l.this;
                a = handler;
                b = s1;
                super();
            }
                };
                a(s2, com.helpshift.a.e);
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("r", integer);
                    jsonobject.put("f", s1);
                    jsonobject.put("id", s2);
                }
                catch (JSONException jsonexception)
                {
                    Log.d("HelpShiftDebug", "JSONException : ", jsonexception);
                }
                handler = new Handler(s2, handler, a(handler1, (new StringBuilder()).append("csat_").append(s2).toString(), 4, jsonobject)) {

                    final String a;
                    final Handler b;
                    final Handler c;
                    final l d;

                    public void handleMessage(Message message)
                    {
                        if (message.obj != null)
                        {
                            d.a(a, a.f);
                            message = b.obtainMessage();
                            HashMap hashmap = new HashMap();
                            hashmap.put("status", Integer.valueOf(0));
                            hashmap.put("id", a);
                            message.obj = hashmap;
                            c.sendMessage(message);
                        }
                    }

            
            {
                d = l.this;
                a = s1;
                b = handler;
                c = handler1;
                super();
            }
                };
                b.a(integer, s1, s2, handler2, handler);
                return;
            } else
            {
                integer = handler1.obtainMessage();
                s1 = new HashMap();
                s1.put("status", Integer.valueOf(400));
                s1.put("reason", (new StringBuilder()).append("CSat survey already done for ").append(s2).toString());
                integer.obj = s1;
                handler1.sendMessage(integer);
                return;
            }
        } else
        {
            integer = handler1.obtainMessage();
            s1 = new HashMap();
            s1.put("status", Integer.valueOf(400));
            s1.put("reason", "Rating not in range");
            integer.obj = s1;
            handler1.sendMessage(integer);
            return;
        }
    }

    protected void a(String s1, Handler handler, Handler handler1)
    {
        ab ab1;
        Message message;
        try
        {
            ab1 = g.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "Database exception in getting section data ", s1);
            return;
        }
        if (ab1 == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        message = handler.obtainMessage();
        message.obj = ab1;
        handler.sendMessage(message);
        g(new Handler(s1, handler) {

            final String a;
            final Handler b;
            final l c;

            public void handleMessage(Message message1)
            {
                super.handleMessage(message1);
                message1 = (ArrayList)message1.obj;
                message1 = com.helpshift.l.a(c).a(a);
                Message message2 = b.obtainMessage();
                message2.obj = message1;
                b.sendMessage(message2);
            }

            
            {
                c = l.this;
                a = s1;
                b = handler;
                super();
            }
        }, handler1);
        return;
    }

    protected void a(String s1, String s2)
    {
        s1 = new JSONArray(com.helpshift.f.c.b(s1));
        String s3 = com.helpshift.i.h.f.format((double)System.currentTimeMillis() / 1000D);
        Object obj = new JSONObject();
        String s4;
        try
        {
            ((JSONObject) (obj)).put("mids", s1);
            ((JSONObject) (obj)).put("src", s2);
            ((JSONObject) (obj)).put("at", s3);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException", jsonexception);
        }
        s4 = (new StringBuilder()).append("msg_seen_").append(Long.toString(System.currentTimeMillis())).toString();
        obj = a(new Handler(), s4, 3, ((JSONObject) (obj)));
        a(new Handler(), ((Handler) (obj)), ((JSONArray) (s1)), s2, s3);
    }

    protected void a(String s1, String s2, String s3)
    {
        a.i(s1);
        a.j(s2);
        a.k(s3);
        b = new com.helpshift.k(s2, s3, s1, a);
    }

    protected void a(List list)
    {
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            (new File(k.getFilesDir(), (String)list.get(i1))).delete();
        }

    }

    protected boolean a(ab ab1)
    {
        return a(ab1.a()).isEmpty();
    }

    protected Handler b(Handler handler, String s1, int i1, JSONObject jsonobject)
    {
        return new Handler(handler, s1) {

            final Handler a;
            final String b;
            final l c;

            public void handleMessage(Message message)
            {
                Message message1 = a.obtainMessage();
                message1.obj = message.obj;
                a.sendMessage(message1);
                try
                {
                    c.a.a(b, null);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", "JSONException", message);
                }
            }

            
            {
                c = l.this;
                a = handler;
                b = s1;
                super();
            }
        };
    }

    protected ArrayList b()
    {
        new ArrayList();
        ArrayList arraylist;
        try
        {
            arraylist = (ArrayList)g.a();
        }
        catch (SQLException sqlexception)
        {
            Log.d("HelpShiftDebug", "Database exception in getting sections data ", sqlexception);
            sqlexception = null;
        }
        return a(arraylist);
    }

    protected ArrayList b(String s1)
    {
        ArrayList arraylist = new ArrayList();
        try
        {
            s1 = (ArrayList)h.b(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "Database exception in getting faqs for section", s1);
            return arraylist;
        }
        return s1;
    }

    protected void b(Handler handler, Handler handler1)
        throws JSONException
    {
        JSONObject jsonobject = a.q();
        if (jsonobject.length() != 0)
        {
            Message message = handler.obtainMessage();
            message.obj = jsonobject;
            handler.sendMessage(message);
        }
        h(handler, handler1);
    }

    protected void b(String s1, Handler handler, Handler handler1)
    {
        s1 = g.a(s1);
        if (s1 != null)
        {
            try
            {
                handler1 = handler.obtainMessage();
                handler1.obj = s1;
                handler.sendMessage(handler1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                Log.d("HelpShiftDebug", "Database exception in getting section data ", s1);
            }
            break MISSING_BLOCK_LABEL_54;
        }
        handler1.sendMessage(handler1.obtainMessage());
        return;
    }

    protected ArrayList c()
    {
        if (i == null)
        {
            E();
        } else
        {
            Iterator iterator = i.iterator();
            while (iterator.hasNext()) 
            {
                ((g)iterator.next()).k();
            }
        }
        return i;
    }

    public void c(Handler handler, Handler handler1)
        throws JSONException
    {
        a(handler, handler1, ((String) (null)));
    }

    public void c(String s1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        ArrayList arraylist;
        JSONArray jsonarray;
        jsonarray = a.x();
        arraylist = new ArrayList();
        int i1 = 0;
_L2:
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(jsonarray.getString(i1));
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        arraylist.add(0, s1);
        if (arraylist.size() <= 10)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        s1 = arraylist.subList(0, 10);
        jsonarray = new JSONArray();
        i1 = ((flag) ? 1 : 0);
_L4:
        if (i1 >= s1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(s1.get(i1));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        int j1;
        try
        {
            a(arraylist.subList(10, arraylist.size()));
            a.a(jsonarray);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "storeFile", s1);
        }
        break MISSING_BLOCK_LABEL_223;
        s1 = new JSONArray();
        j1 = ((flag1) ? 1 : 0);
_L6:
        if (j1 >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s1.put(arraylist.get(j1));
        j1++;
        if (true) goto _L6; else goto _L5
_L5:
        a.a(s1);
        return;
    }

    protected void c(String s1, Handler handler, Handler handler1)
    {
        Object obj;
        try
        {
            obj = h.a(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.d("HelpShiftDebug", "Database exception in getting faq ", ((Throwable) (obj)));
            obj = null;
        }
        if (obj == null)
        {
            d(s1, handler, handler1);
            return;
        } else
        {
            Message message = handler.obtainMessage();
            message.obj = obj;
            handler.sendMessage(message);
            d(s1, handler, handler1);
            return;
        }
    }

    protected ab d(String s1)
    {
        return g.a(s1);
    }

    protected void d()
    {
        JSONArray jsonarray = new JSONArray();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("ts", com.helpshift.i.h.f.format((double)System.currentTimeMillis() / 1000D));
            jsonobject.put("t", "a");
            jsonarray.put(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException", jsonexception);
        }
        b(jsonarray);
    }

    protected void d(Handler handler, Handler handler1)
        throws JSONException
    {
        Object obj = B();
        HashMap hashmap = a.b(((String) (obj)));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            if (hashmap.containsKey("success"))
            {
                handler1 = com.helpshift.h.e.b(B());
                obj = handler.obtainMessage();
                obj.obj = handler1;
                handler.sendMessage(((Message) (obj)));
                return;
            } else
            {
                a(handler, handler1, ((String) (obj)), "", "", Boolean.valueOf(false));
                return;
            }
        } else
        {
            a(handler1, 403);
            return;
        }
    }

    protected JSONArray e(String s1)
    {
        try
        {
            List list = com.helpshift.h.e.a(s1).i();
            s1 = a.a(a.g(s1, B()), com.helpshift.i.q.a(list));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "JSONException", s1);
            return new JSONArray();
        }
        return s1;
    }

    protected void e()
    {
        b(com.helpshift.o.a());
    }

    protected void e(Handler handler, Handler handler1)
    {
        try
        {
            c(new Handler(handler) {

                final Handler a;
                final l b;

                public void handleMessage(Message message)
                {
                    message = b.a.d(b.B());
                    Message message1 = a.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("value", message.intValue());
                    bundle.putBoolean("cache", false);
                    message1.obj = bundle;
                    a.sendMessage(message1);
                }

            
            {
                b = l.this;
                a = handler;
                super();
            }
            }, handler1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            Log.d("HelpShiftDebug", handler.toString(), handler);
        }
    }

    protected a f(String s1)
    {
        JSONObject jsonobject;
        if (!z().booleanValue())
        {
            break MISSING_BLOCK_LABEL_56;
        }
        jsonobject = a.N();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (!jsonobject.has(s1))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        int i1 = jsonobject.getInt(s1);
        s1 = a.values()[i1];
        return s1;
        s1;
        Log.d("HelpShiftDebug", "JSONException : ", s1);
        return com.helpshift.a.a;
    }

    protected Boolean f()
    {
        if (a.w() == 0)
        {
            JSONObject jsonobject = (JSONObject)com.helpshift.g.b.a.b.get("pr");
            String s1 = (String)com.helpshift.g.b.a.b.get("rurl");
            if (jsonobject != null && jsonobject.optBoolean("s", false) && !TextUtils.isEmpty(s1))
            {
                int i1 = a.s();
                String s2 = jsonobject.optString("t", "");
                int j1 = jsonobject.optInt("i", 0);
                if (j1 > 0)
                {
                    if (s2.equals("l") && i1 >= j1)
                    {
                        return Boolean.valueOf(true);
                    }
                    if (s2.equals("s") && i1 != 0 && (new Date()).getTime() / 1000L - (long)i1 >= (long)j1)
                    {
                        return Boolean.valueOf(true);
                    }
                }
            }
        }
        return Boolean.valueOf(false);
    }

    protected void f(Handler handler, Handler handler1)
    {
        try
        {
            c(handler, handler1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Handler handler)
        {
            Log.d("HelpShiftDebug", handler.toString(), handler);
        }
    }

    protected void g()
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            jsonobject = (JSONObject)com.helpshift.g.b.a.b.get("pr");
            jsonobject1 = a.q();
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", (new StringBuilder()).append("JSON Exception:").append(jsonexception.toString()).toString());
            return;
        }
        if (jsonobject != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (jsonobject1.length() != 0)
        {
            com.helpshift.g.b.a.b(jsonobject1);
        }
    }

    protected void g(String s1)
    {
        String s2 = a.W();
        if (TextUtils.isEmpty(s2))
        {
            a.c(s1);
            return;
        } else
        {
            f.a(s2, s1);
            return;
        }
    }

    protected void h()
    {
        int j1 = a.s();
        int k1 = a.t();
        JSONObject jsonobject;
        int i1;
        if (j1 == 0)
        {
            i1 = (int)((new Date()).getTime() / 1000L);
        } else
        {
            i1 = j1;
            j1 = k1;
        }
        a.b(j1 + 1);
        g();
        jsonobject = (JSONObject)com.helpshift.g.b.a.b.get("pr");
        j1 = i1;
        if (jsonobject != null)
        {
            j1 = i1;
            if (jsonobject.optString("t", "").equals("l"))
            {
                j1 = a.t();
            }
        }
        a.a(j1);
    }

    public void h(String s1)
    {
        String s2 = a.W();
        if (TextUtils.isEmpty(s2))
        {
            a.m(s1);
            return;
        } else
        {
            f.b(s2, s1);
            return;
        }
    }

    protected void i()
    {
        int i1;
        int j1;
        i1 = 0;
        j1 = a.s();
        Object obj = a.q().optJSONObject("pr");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj = ((JSONObject) (obj)).optString("t", "");
        if (!((String) (obj)).equals("s")) goto _L2; else goto _L1
_L1:
        i1 = (int)((new Date()).getTime() / 1000L);
_L3:
        a.a(i1);
        a.b(0);
        return;
_L2:
        boolean flag = ((String) (obj)).equals("l");
        if (!flag)
        {
            i1 = j1;
        }
          goto _L3
        JSONException jsonexception;
        jsonexception;
        Log.d("HelpShiftDebug", "Reseting review counter", jsonexception);
    }

    public void i(String s1)
    {
        String s2 = a.W();
        if (TextUtils.isEmpty(s2))
        {
            a.l(s1);
            return;
        } else
        {
            f.c(s2, s1);
            return;
        }
    }

    protected void j()
    {
        a.v();
    }

    protected void k()
    {
        a.u();
    }

    protected String l()
    {
        String s1 = a.i();
        if (!TextUtils.isEmpty(s1))
        {
            return s1;
        } else
        {
            return o();
        }
    }

    protected String m()
    {
        String s2 = a.H();
        String s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = UUID.randomUUID().toString();
            a.x(s1);
        }
        return s1;
    }

    protected String n()
    {
        String s1 = a.W();
        if (TextUtils.isEmpty(s1))
        {
            return o();
        } else
        {
            return f.a(s1).b();
        }
    }

    protected String o()
    {
        String s1 = a.b();
        String s2 = a.H();
        if (!TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
        {
            return android.provider.Settings.Secure.getString(k.getContentResolver(), "android_id");
        } else
        {
            return m();
        }
    }

    protected void p()
    {
        String s1 = B();
        String s2 = a.j();
        Object obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("profile-id", s1);
            ((JSONObject) (obj)).put("device-token", s2);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException", jsonexception);
        }
        obj = a(new Handler(), (new StringBuilder()).append("push_token_").append(s1).toString(), 1, ((JSONObject) (obj)));
        a(new Handler(), ((Handler) (obj)), s1, s2);
    }

    protected Boolean q()
    {
        boolean flag;
        if (!TextUtils.isEmpty(a.i()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    protected void r()
    {
        Thread thread = new Thread(new Runnable() {

            final l a;

            public void run()
            {
                a.a.z();
            }

            
            {
                a = l.this;
                super();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    protected void s()
    {
        com.helpshift.HSService.a();
    }

    protected void t()
    {
        Intent intent = new Intent(k, com/helpshift/HSService);
        k.stopService(intent);
    }

    protected void u()
    {
        String s1;
        new JSONObject();
        s1 = a.j();
        Object obj;
        obj = a.r();
        if (!((JSONObject) (obj)).has("enableInAppNotification"))
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj = (Boolean)((JSONObject) (obj)).get("enableInAppNotification");
_L1:
        if (((Boolean) (obj)).booleanValue() && (s1.equals("") || s1.equals("unreg")))
        {
            obj = B();
            String s2 = a.f(B());
            if (!TextUtils.isEmpty(((CharSequence) (obj))) && !TextUtils.isEmpty(s2))
            {
                obj = new Intent(k, com/helpshift/HSService);
                if (!a.l().equals("3.9.1"))
                {
                    t();
                }
                k.startService(((Intent) (obj)));
            }
            return;
        } else
        {
            t();
            return;
        }
        obj;
        Log.d("HelpShiftDebug", "startInAppService JSONException", ((Throwable) (obj)));
        obj = Boolean.valueOf(true);
          goto _L1
    }

    protected void v()
    {
        JSONObject jsonobject = a.u(B());
        if (jsonobject == null)
        {
            return;
        }
        try
        {
            Handler handler = new Handler() {

                final l a;

                public void handleMessage(Message message)
                {
                    a.v();
                    message = new Intent("com.helpshift.failedMessageRequest");
                    com.helpshift.l.c(a).sendBroadcast(message);
                }

            
            {
                a = l.this;
                super();
            }
            };
            a(handler, handler, jsonobject.getString("issue_id"), jsonobject.getString("body"), jsonobject.getString("type"), jsonobject.getString("refers"), jsonobject.optInt("state", 0) - 1);
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "SendfailedMessages failed", jsonexception);
        }
        return;
    }

    protected void w()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = new Handler() {

            final l a;

            public void handleMessage(Message message)
            {
                a.w();
            }

            
            {
                a = l.this;
                super();
            }
        };
        JSONObject jsonobject;
        jsonobject = a.F();
        if (c == null)
        {
            c = jsonobject.keys();
        }
        if (!c.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1;
        int i1;
        String s1 = (String)c.next();
        obj1 = (JSONObject)jsonobject.get(s1);
        jsonobject = ((JSONObject) (obj1)).getJSONObject("p");
        i1 = ((JSONObject) (obj1)).getInt("t");
        obj1 = b(((Handler) (obj)), s1, i1, jsonobject);
        obj = a(((Handler) (obj)), s1, i1, jsonobject);
        i1;
        JVM INSTR tableswitch 0 4: default 144
    //                   0 147
    //                   1 194
    //                   2 215
    //                   3 229
    //                   4 260;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        a(((Handler) (obj1)), ((Handler) (obj)), jsonobject.getString("f"), Boolean.valueOf(jsonobject.getBoolean("h")));
          goto _L3
        obj;
        Log.d("HelpShiftDebug", "JSONException", ((Throwable) (obj)));
          goto _L3
        obj;
        throw obj;
_L5:
        a(((Handler) (obj1)), ((Handler) (obj)), jsonobject.getString("profile-id"), jsonobject.getString("device-token"));
_L6:
        a(((Handler) (obj1)), ((Handler) (obj)), com.helpshift.i.j.b(jsonobject));
          goto _L3
_L7:
        a(((Handler) (obj1)), ((Handler) (obj)), jsonobject.getJSONArray("mids"), jsonobject.getString("src"), jsonobject.getString("at"));
          goto _L3
_L8:
        a(Integer.valueOf(jsonobject.getInt("r")), jsonobject.getString("f"), jsonobject.getString("id"), ((Handler) (obj1)), ((Handler) (obj)));
          goto _L3
_L2:
        c = null;
          goto _L3
    }

    protected Boolean z()
    {
        return (Boolean)com.helpshift.g.b.a.b.get("csat");
    }

}
