// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.helpshift.b.a;
import com.helpshift.f.c;
import com.helpshift.h.e;
import com.helpshift.i.b;
import com.helpshift.i.g;
import com.helpshift.i.j;
import com.helpshift.i.q;
import com.helpshift.i.t;
import com.helpshift.i.w;
import com.helpshift.widget.CSATView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            f, s, l, h, 
//            o, c, k, ScreenshotPreviewActivity, 
//            t, v, j, HSConversation

public class HSMessagesFragment extends Fragment
    implements com.helpshift.f, com.helpshift.widget.CSATView.a, TraceFieldInterface
{
    private class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final HSMessagesFragment a;

        public void _nr_setTrace(Trace trace)
        {
            try
            {
                _nr_trace = trace;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Trace trace)
            {
                return;
            }
        }

        protected transient HashMap a(HashMap ahashmap[])
        {
            ahashmap = ahashmap[0];
            String s1 = (String)ahashmap.get("url");
            String s2 = (String)ahashmap.get("messageId");
            int i1 = ((Integer)ahashmap.get("attachId")).intValue();
            int j1 = ((Integer)ahashmap.get("position")).intValue();
            ahashmap = new HashMap();
            try
            {
                s1 = a.a(s1, s2, i1);
                ahashmap.put("success", Boolean.valueOf(true));
                ahashmap.put("filepath", s1);
                ahashmap.put("position", Integer.valueOf(j1));
            }
            catch (IOException ioexception)
            {
                Log.d("HelpShiftDebug", "Downloading image", ioexception);
                ahashmap.put("success", Boolean.valueOf(false));
                return ahashmap;
            }
            return ahashmap;
        }

        protected void a(HashMap hashmap)
        {
            if (((Boolean)hashmap.get("success")).booleanValue())
            {
                int i1 = ((Integer)hashmap.get("position")).intValue();
                ((com.helpshift.k.a)HSMessagesFragment.s(a).get(i1)).h = (String)hashmap.get("filepath");
                HSMessagesFragment.d(a).notifyDataSetChanged();
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "HSMessagesFragment$a#doInBackground", null);
_L1:
            aobj = a((HashMap[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "HSMessagesFragment$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "HSMessagesFragment$a#onPostExecute", null);
_L1:
            a((HashMap)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "HSMessagesFragment$a#onPostExecute", null);
              goto _L1
        }

        private a()
        {
            a = HSMessagesFragment.this;
            super();
        }

    }


    private ImageButton A;
    private Button B;
    private boolean C;
    private boolean D;
    private boolean E;
    private MenuItem F;
    private ViewStub G;
    private TextView H;
    private CSATView I;
    private boolean J;
    private boolean K;
    private com.helpshift.f L;
    private t.c M;
    private boolean N;
    private Handler O;
    private Handler P;
    private Handler Q;
    private Handler R;
    private final BroadcastReceiver a = new BroadcastReceiver() {

        final HSMessagesFragment a;

        public void onReceive(Context context, Intent intent)
        {
            com.helpshift.HSMessagesFragment.a(a);
        }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
    };
    private final BroadcastReceiver b = new BroadcastReceiver() {

        final HSMessagesFragment a;

        public void onReceive(Context context, Intent intent)
        {
            a.b();
        }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
    };
    private h c;
    private Bundle d;
    private String e;
    private com.helpshift.b.a f;
    private ArrayList g;
    private ListView h;
    private s i;
    private k j;
    private l k;
    private String l;
    private HashSet m;
    private HashSet n;
    private final int o = 3;
    private Thread p;
    private Handler q;
    private Boolean r;
    private Boolean s;
    private Boolean t;
    private boolean u;
    private EditText v;
    private LinearLayout w;
    private LinearLayout x;
    private RelativeLayout y;
    private ImageButton z;

    public HSMessagesFragment()
    {
        g = new ArrayList();
        m = new HashSet();
        n = new HashSet();
        u = false;
        C = false;
        D = true;
        E = true;
        I = null;
        J = false;
        K = false;
        O = new Handler() {

            final HSMessagesFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (((JSONArray)message.obj).length() > 0)
                {
                    com.helpshift.HSMessagesFragment.a(a, com.helpshift.f.a.d(com.helpshift.HSMessagesFragment.b(a)));
                    com.helpshift.HSMessagesFragment.a(a);
                    com.helpshift.HSMessagesFragment.c(a);
                    com.helpshift.HSMessagesFragment.e(a).setSelection(HSMessagesFragment.d(a).getCount() - 1);
                }
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        };
        P = new Handler() {

            final HSMessagesFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message = (Integer)((HashMap)message.obj).get("status");
                if (message.intValue() != -1 && com.helpshift.HSMessagesFragment.f(a) != null)
                {
                    com.helpshift.HSMessagesFragment.f(a).getLooper().quit();
                }
                com.helpshift.i.g.a(message.intValue(), null, com.helpshift.HSMessagesFragment.g(a));
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        };
        Q = new Handler() {

            final HSMessagesFragment a;

            public void handleMessage(Message message)
            {
                com.helpshift.HSMessagesFragment.a(a, message);
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        };
        R = new Handler() {

            final HSMessagesFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (com.helpshift.HSMessagesFragment.f(a) != null)
                {
                    com.helpshift.HSMessagesFragment.f(a).getLooper().quit();
                }
                com.helpshift.HSMessagesFragment.a(a);
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        };
    }

    static Handler a(HSMessagesFragment hsmessagesfragment, Handler handler)
    {
        hsmessagesfragment.q = handler;
        return handler;
    }

    private void a(Configuration configuration)
    {
        if (B != null)
        {
            int i1;
            int j1;
            int k1;
            if (configuration.orientation == 1)
            {
                i1 = e(28);
                k1 = e(32);
                j1 = e(28);
            } else
            {
                i1 = e(6);
                k1 = e(6);
                j1 = 0;
            }
            configuration = new android.widget.LinearLayout.LayoutParams(-2, -2);
            configuration.setMargins(0, i1, 0, k1);
            B.setLayoutParams(configuration);
            if (I != null)
            {
                I.a(0, j1, 0, 0);
            }
        }
    }

    private void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4)
    {
        i.b(Boolean.valueOf(false));
        if (!s3.equals("ar"))
        {
            k.a(s1, com.helpshift.l.a.a);
        }
        k.a(handler, handler1, s1, s2, s3, s4);
    }

    private void a(Handler handler, Handler handler1, String s1, String s2, String s3, String s4, int i1)
    {
        i.b(Boolean.valueOf(false));
        if (!s3.equals("ar"))
        {
            k.a(s1, com.helpshift.l.a.a);
        }
        k.a(handler, handler1, s1, s2, s3, s4, i1);
    }

    private void a(Message message)
    {
        message = (JSONObject)((HashMap)message.obj).get("response");
        JSONArray jsonarray = new JSONArray();
        jsonarray.put(message);
        com.helpshift.h.e.b(com.helpshift.i.q.a(jsonarray));
        h();
    }

    private void a(View view)
    {
        view.requestFocus();
        ((InputMethodManager)c.getSystemService("input_method")).showSoftInput(view, 0);
    }

    static void a(HSMessagesFragment hsmessagesfragment)
    {
        hsmessagesfragment.h();
    }

    static void a(HSMessagesFragment hsmessagesfragment, Handler handler, Handler handler1, String s1, String s2, String s3, String s4)
    {
        hsmessagesfragment.a(handler, handler1, s1, s2, s3, s4);
    }

    static void a(HSMessagesFragment hsmessagesfragment, Message message)
    {
        hsmessagesfragment.a(message);
    }

    static void a(HSMessagesFragment hsmessagesfragment, View view)
    {
        hsmessagesfragment.a(view);
    }

    static void a(HSMessagesFragment hsmessagesfragment, Boolean boolean1)
    {
        hsmessagesfragment.a(boolean1);
    }

    static void a(HSMessagesFragment hsmessagesfragment, String s1)
    {
        hsmessagesfragment.b(s1);
    }

    private void a(Boolean boolean1)
    {
        i.a(e, k.B());
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("id", e);
        if (!boolean1.booleanValue()) goto _L2; else goto _L1
_L1:
        com.helpshift.o.a("y", jsonobject);
        boolean1 = "ca";
_L3:
        try
        {
            a(Q, R, e, "", ((String) (boolean1)), "");
            k.a(e, com.helpshift.l.a.b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            Log.d("HelpShiftDebug", "JSONException", boolean1);
        }
        break MISSING_BLOCK_LABEL_121;
_L2:
        com.helpshift.o.a("n", jsonobject);
        boolean1 = "ncr";
          goto _L3
    }

    private void a(JSONArray jsonarray)
    {
        int j1;
        g.clear();
        m.clear();
        n.clear();
        j1 = jsonarray.length();
        int i1 = 0;
_L21:
        if (i1 >= j1) goto _L2; else goto _L1
_L1:
        String s2;
        JSONObject jsonobject;
        String s3;
        jsonobject = jsonarray.getJSONObject(i1);
        s2 = jsonobject.getString("id");
        s3 = jsonobject.getString("type");
        if (!s3.equals("admin_attachment_generic")) goto _L4; else goto _L3
_L3:
        Object obj = i.C(s2);
        if (!(new File(((String) (obj)))).exists()) goto _L6; else goto _L5
_L5:
        jsonobject.put("state", 3);
_L8:
        String s4;
        String s5;
        String s6;
        int k1;
        boolean flag1;
        s4 = jsonobject.getString("origin");
        s5 = jsonobject.getString("body");
        s6 = jsonobject.getString("created_at");
        k1 = jsonobject.optInt("state", 0);
        flag1 = jsonobject.optBoolean("inProgress", false);
        if (s4.equals("mobile") && s3.equals("ncr") && !D && i1 == j1 - 1)
        {
            break MISSING_BLOCK_LABEL_981;
        }
          goto _L7
_L6:
        JSONException jsonexception;
        if (!((String) (obj)).equals(""))
        {
            i.B(s2);
        }
        if (i.I(s2))
        {
            jsonobject.put("state", 1);
        }
          goto _L8
_L2:
        if (jsonarray.length() > 0)
        {
            f.notifyDataSetChanged();
        }
        return;
_L4:
        if (!s3.equals("admin_attachment_image")) goto _L8; else goto _L9
_L9:
        jsonexception = i.G(s2);
        if (!(new File(jsonexception)).exists())
        {
            break MISSING_BLOCK_LABEL_332;
        }
        jsonobject.put("screenshot", jsonexception);
        jsonobject.put("state", 3);
          goto _L8
        if (!jsonexception.equals(""))
        {
            i.F(s2);
        }
        jsonexception = i.E(s2);
        if (!(new File(jsonexception)).exists()) goto _L11; else goto _L10
_L10:
        jsonobject.put("screenshot", jsonexception);
        if (!i.I(s2)) goto _L13; else goto _L12
_L12:
        jsonobject.put("state", 2);
          goto _L8
_L13:
        jsonobject.put("state", 1);
          goto _L8
_L11:
        if (jsonexception.equals("")) goto _L8; else goto _L14
_L14:
        i.D(s2);
          goto _L8
_L7:
        Object obj1;
        jsonexception = jsonobject.optString("screenshot", "");
        if (!s3.equals("rsc"))
        {
            break MISSING_BLOCK_LABEL_515;
        }
        obj1 = jsonobject.optString("screenshot", "");
        jsonexception = ((JSONException) (obj1));
        if (!s2.startsWith("localRscMessage_"))
        {
            break MISSING_BLOCK_LABEL_515;
        }
        jsonexception = ((JSONException) (obj1));
        if (n.contains(s2))
        {
            com.helpshift.h.e.f(s2);
            break MISSING_BLOCK_LABEL_981;
        }
        Object obj2;
        Object obj3;
        if (s4.equals("admin") && s3.equals("rfr") && !com.helpshift.i.t.a(jsonarray, i1, s2))
        {
            break MISSING_BLOCK_LABEL_981;
        }
        obj2 = Boolean.valueOf(false);
        obj3 = jsonobject.optJSONObject("meta");
        obj1 = obj2;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_602;
        }
        obj3 = ((JSONObject) (obj3)).optJSONObject("response");
        obj1 = obj2;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_602;
        }
        obj1 = Boolean.valueOf(((JSONObject) (obj3)).optBoolean("state"));
        obj3 = "";
        obj2 = obj3;
        JSONObject jsonobject1;
        if (!N)
        {
            break MISSING_BLOCK_LABEL_647;
        }
        jsonobject1 = jsonobject.optJSONObject("author");
        obj2 = obj3;
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_647;
        }
        obj2 = jsonobject1.optString("name");
        HashMap ahashmap[];
        boolean flag;
        if (jsonobject.optBoolean("invisible") || ((Boolean) (obj1)).booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!com.helpshift.i.t.a(s4, s3) || m.contains(s2))
        {
            break MISSING_BLOCK_LABEL_981;
        }
        m.add(s2);
        g.add(new com.helpshift.k.a(s2, s3, s4, s5, s6, Boolean.valueOf(flag), jsonexception, k1, Boolean.valueOf(flag1), ((String) (obj2))));
        if (!s3.equals("sc"))
        {
            break MISSING_BLOCK_LABEL_981;
        }
        jsonexception = jsonobject.optJSONObject("meta");
        if (jsonexception == null)
        {
            break MISSING_BLOCK_LABEL_981;
        }
        obj1 = jsonexception.optJSONArray("attachments");
        jsonexception = jsonexception.optString("refers", s2);
        if (!jsonexception.startsWith("localRscMessage_")) goto _L16; else goto _L15
_L15:
        if (!m.contains(jsonexception)) goto _L18; else goto _L17
_L17:
        c(jsonexception);
        com.helpshift.h.e.f(jsonexception);
_L16:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_971;
        }
        if (((JSONArray) (obj1)).length() <= 0 || jsonexception == null)
        {
            break MISSING_BLOCK_LABEL_971;
        }
        obj1 = ((JSONArray) (obj1)).optJSONObject(0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_981;
        }
        String s1 = ((JSONObject) (obj1)).optString("url", "");
        obj1 = new HashMap();
        ((HashMap) (obj1)).put("url", s1);
        ((HashMap) (obj1)).put("messageId", jsonexception);
        ((HashMap) (obj1)).put("attachId", Integer.valueOf(0));
        ((HashMap) (obj1)).put("position", Integer.valueOf(g.size() - 1));
        jsonexception = new a();
        ahashmap = new HashMap[1];
        ahashmap[0] = ((HashMap) (obj1));
        if (!(jsonexception instanceof AsyncTask))
        {
            jsonexception.execute(ahashmap);
            break MISSING_BLOCK_LABEL_981;
        }
        break; /* Loop/switch isn't completed */
_L18:
        n.add(jsonexception);
        if (true) goto _L16; else goto _L19
_L19:
        try
        {
            AsyncTaskInstrumentation.execute((AsyncTask)jsonexception, ahashmap);
            break MISSING_BLOCK_LABEL_981;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "Slug in get(\"slug\") no found", jsonexception);
        }
          goto _L2
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_981;
        }
        c(s2);
        i1++;
        if (true) goto _L21; else goto _L20
_L20:
    }

    static boolean a(HSMessagesFragment hsmessagesfragment, boolean flag)
    {
        hsmessagesfragment.N = flag;
        return flag;
    }

    static String b(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.e;
    }

    private void b(View view)
    {
        ((InputMethodManager)c.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void b(String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s1));
        if (isResumed() && intent.resolveActivity(getActivity().getPackageManager()) != null)
        {
            startActivity(intent);
            return;
        } else
        {
            com.helpshift.i.g.a(4, null, c);
            return;
        }
    }

    static boolean b(HSMessagesFragment hsmessagesfragment, boolean flag)
    {
        hsmessagesfragment.C = flag;
        return flag;
    }

    private void c()
    {
        List list = i.g(k.B());
        Integer integer = Integer.valueOf(com.helpshift.h.e.a(e).g());
        int i1 = i.v(k.B()).trim().length();
        if (integer.equals(Integer.valueOf(0)) || integer.equals(Integer.valueOf(1)))
        {
            g();
            C = false;
        } else
        if (integer.equals(Integer.valueOf(2)))
        {
            if (list.contains(e))
            {
                d();
                return;
            }
            if (C || i1 != 0 || i.I().booleanValue())
            {
                g();
                return;
            } else
            {
                e();
                return;
            }
        }
    }

    static void c(HSMessagesFragment hsmessagesfragment)
    {
        hsmessagesfragment.c();
    }

    private void c(String s1)
    {
        Iterator iterator = g.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((com.helpshift.k.a)iterator.next()).g.equals(s1))
            {
                iterator.remove();
            }
        } while (true);
        m.remove(s1);
    }

    static com.helpshift.b.a d(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.f;
    }

    private void d()
    {
        f.a(false);
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)w.getLayoutParams();
        y.setVisibility(8);
        b(v);
        layoutparams.addRule(12);
        w.setLayoutParams(layoutparams);
        w.setVisibility(0);
        x.setVisibility(8);
        if (F != null)
        {
            F.setVisible(false);
        }
        J = true;
        d(b.g.I);
    }

    private void d(int i1)
    {
        h.removeFooterView(H);
        if (i1 != -1)
        {
            H.setText(i1);
            h.addFooterView(H);
        }
    }

    private int e(int i1)
    {
        return (int)(getResources().getDisplayMetrics().density * (float)i1);
    }

    static ListView e(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.h;
    }

    private void e()
    {
        D = false;
        f.a(false);
        b(v);
        w.setVisibility(8);
        x.setVisibility(0);
        y.setVisibility(8);
        if (F != null)
        {
            F.setVisible(false);
        }
        l.a a1 = k.f(e);
        if (a1 == com.helpshift.l.a.b || a1 == com.helpshift.l.a.c)
        {
            I = f();
            a(getResources().getConfiguration());
            d(b.g.I);
        } else
        {
            d(b.g.J);
        }
        K = true;
    }

    static Handler f(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.q;
    }

    private CSATView f()
    {
        if (G != null)
        {
            CSATView csatview = (CSATView)G.inflate();
            csatview.setCSATListener(this);
            G = null;
            k.a(e, com.helpshift.l.a.c);
            return csatview;
        } else
        {
            return null;
        }
    }

    static h g(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.c;
    }

    private void g()
    {
        f.a(true);
        w.setVisibility(8);
        x.setVisibility(8);
        y.setVisibility(0);
        if (F != null && !i.L().booleanValue())
        {
            F.setVisible(true);
        }
        d(-1);
    }

    static Handler h(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.O;
    }

    private void h()
    {
        a(k.e(e));
    }

    static Handler i(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.P;
    }

    static String j(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.l;
    }

    static l k(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.k;
    }

    static EditText l(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.v;
    }

    static s m(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.i;
    }

    static t.c n(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.M;
    }

    static void o(HSMessagesFragment hsmessagesfragment)
    {
        hsmessagesfragment.g();
    }

    static Bundle p(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.d;
    }

    static Handler q(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.Q;
    }

    static Handler r(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.R;
    }

    static ArrayList s(HSMessagesFragment hsmessagesfragment)
    {
        return hsmessagesfragment.g;
    }

    public String a(String s1, String s2, int i1)
        throws IOException
    {
        Object obj1;
        obj1 = null;
        s1 = new URL(s1);
        Object obj;
        String s3;
        s2 = (new StringBuilder()).append(s2).append(i1).append("-thumbnail").toString();
        obj = new File(c.getFilesDir(), s2);
        s3 = ((File) (obj)).getAbsolutePath();
        if (((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        k.c(s2);
        s1 = HttpInstrumentation.openConnection(s1.openConnection()).getInputStream();
        s2 = c.openFileOutput(s2, 0);
        byte abyte0[] = new byte[1024];
_L5:
        i1 = s1.read(abyte0);
        obj1 = s2;
        obj = s1;
        if (i1 == -1) goto _L4; else goto _L3
_L3:
        s2.write(abyte0, 0, i1);
          goto _L5
        obj1;
        obj = s1;
        s1 = ((String) (obj1));
_L7:
        if (s2 != null)
        {
            s2.close();
        }
        if (obj != null)
        {
            ((InputStream) (obj)).close();
        }
        throw s1;
_L2:
        obj = null;
_L4:
        if (obj1 != null)
        {
            ((FileOutputStream) (obj1)).close();
        }
        if (obj != null)
        {
            ((InputStream) (obj)).close();
        }
        return s3;
        s1;
        obj = null;
        s2 = null;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        obj = s1;
        s2 = null;
        s1 = exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a()
    {
        d(b.g.J);
    }

    public void a(double d1, int i1, String s1, String s2, int j1)
    {
        if (!s2.equals(e)) goto _L2; else goto _L1
_L1:
        s2 = (com.helpshift.k.a)g.get(i1);
        if (!s1.equals(((com.helpshift.k.a) (s2)).g)) goto _L2; else goto _L3
_L3:
        if (j1 != 6) goto _L5; else goto _L4
_L4:
        int k1;
        s2.f = 2;
        j1 = h.getFirstVisiblePosition();
        k1 = h.getLastVisiblePosition();
        i1 = j1;
_L11:
        if (i1 > k1) goto _L2; else goto _L6
_L6:
        if (!s2.equals(h.getItemAtPosition(i1))) goto _L8; else goto _L7
_L7:
        s1 = h.getChildAt(i1 - j1);
        ((ProgressBar)s1.findViewById(0x102000d)).setProgress((int)d1);
        f.getView(i1, s1, h);
_L2:
        return;
_L8:
        i1++;
        continue; /* Loop/switch isn't completed */
_L5:
        if (j1 != 7 || ((com.helpshift.k.a) (s2)).f == 2) goto _L2; else goto _L9
_L9:
        s2.f = 2;
        b(s2);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void a(int i1)
    {
        com.helpshift.k.a a1 = (com.helpshift.k.a)g.get(i1);
        if (a1.g.startsWith("localRscMessage_"))
        {
            com.helpshift.h.e.f(a1.g);
            g.remove(i1);
        } else
        {
            com.helpshift.f.c.a(a1.g, "");
            a1.h = "";
        }
        f.notifyDataSetChanged();
    }

    public void a(int i1, String s1)
    {
        s1 = s1.trim();
        k.a(Integer.valueOf(i1), s1, e, new Handler(), new Handler());
        if (M != null)
        {
            M.a(i1, s1);
        }
    }

    public void a(int i1, String s1, String s2, int j1)
    {
    }

    public void a(com.helpshift.k.a a1)
    {
        String s1;
        s1 = JSONObjectInstrumentation.init(a1.d).optString("content-type", "");
        if (!a1.b.equals("admin_attachment_generic"))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        a1 = i.C(a1.g);
_L1:
        a1 = new File(a1);
        if (!a1.exists())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        Uri uri = Uri.fromFile(a1);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, s1);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null)
        {
            startActivity(intent);
            return;
        }
        break MISSING_BLOCK_LABEL_120;
        try
        {
            a1 = i.G(a1.g);
        }
        // Misplaced declaration of an exception variable
        catch (com.helpshift.k.a a1)
        {
            Log.d("HelpShiftDebug", "launchAttachment : ", a1);
            return;
        }
          goto _L1
        if (M != null)
        {
            M.a(a1);
            return;
        }
        com.helpshift.i.g.a(4, null, c);
        return;
        com.helpshift.i.g.a(5, null, c);
        return;
    }

    public void a(String s1)
    {
        JSONObject jsonobject = k.a.f(s1, k.B());
        if (jsonobject == null)
        {
            return;
        }
        try
        {
            JSONObject jsonobject1 = new JSONObject(jsonobject, com.helpshift.i.j.a(jsonobject));
            jsonobject1.put("state", 1);
            JSONArray jsonarray = k.e(e);
            jsonarray.put(jsonobject1);
            a(jsonarray);
            k.a.a(jsonobject1, k.B());
            s1 = new Handler(s1) {

                final String a;
                final HSMessagesFragment b;

                public void handleMessage(Message message)
                {
                    super.handleMessage(message);
                    try
                    {
                        HSMessagesFragment.k(b).a.f(a, HSMessagesFragment.k(b).B());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        Log.d("HelpShiftDebug", "addMessageHandler", message);
                    }
                    com.helpshift.HSMessagesFragment.a(b);
                }

            
            {
                b = HSMessagesFragment.this;
                a = s1;
                super();
            }
            };
            a(((Handler) (s1)), ((Handler) (s1)), jsonobject.getString("issue_id"), jsonobject.getString("body"), jsonobject.getString("type"), jsonobject.getString("refers"), jsonobject.optInt("state", 0) - 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "retryMessage", s1);
        }
        return;
    }

    public void a(String s1, int i1)
    {
        com.helpshift.k.a a1 = (com.helpshift.k.a)g.get(i1);
        a1.i = Boolean.valueOf(false);
        a1.k = Boolean.valueOf(true);
        com.helpshift.f.c.b(a1.g, true);
        f.notifyDataSetChanged();
        a(((Handler) (new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a2 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                a2.i = Boolean.valueOf(false);
                a2.j = Boolean.valueOf(true);
                a2.k = Boolean.valueOf(false);
                HSMessagesFragment.d(b).notifyDataSetChanged();
                com.helpshift.f.c.b(a2.g, false);
                com.helpshift.f.c.a(a2.g, true);
                com.helpshift.HSMessagesFragment.a(b, message);
                try
                {
                    message = new JSONObject();
                    message.put("type", "conversation");
                    com.helpshift.o.a("r", message);
                    if (HSMessagesFragment.n(b) != null)
                    {
                        HSMessagesFragment.n(b).b("User reviewed the app");
                    }
                    message = HSMessagesFragment.m(b).q().optString("rurl", "").trim();
                    if (!TextUtils.isEmpty(message))
                    {
                        HSMessagesFragment.k(b).k();
                        com.helpshift.HSMessagesFragment.a(b, message);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", message.getMessage(), message);
                }
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        })), ((Handler) (new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a2 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                a2.i = Boolean.valueOf(true);
                a2.k = Boolean.valueOf(false);
                com.helpshift.f.c.b(a2.g, false);
                HSMessagesFragment.d(b).notifyDataSetChanged();
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, com.helpshift.HSMessagesFragment.g(b));
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        })), e, "", "ar", s1);
    }

    public void a(String s1, int i1, String s2, String s3, int j1)
    {
        if (!s3.equals(e)) goto _L2; else goto _L1
_L1:
        s3 = (com.helpshift.k.a)g.get(i1);
        if (!s2.equals(((com.helpshift.k.a) (s3)).g)) goto _L2; else goto _L3
_L3:
        j1;
        JVM INSTR tableswitch 6 8: default 64
    //                   6 91
    //                   7 100
    //                   8 115;
           goto _L4 _L5 _L6 _L7
_L4:
        b(s3);
        if (isResumed() && j1 != 8)
        {
            a(((com.helpshift.k.a) (s3)));
        }
_L2:
        return;
_L5:
        s3.f = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        s3.f = 3;
        s3.h = s1;
        continue; /* Loop/switch isn't completed */
_L7:
        s3.f = 1;
        s3.h = s1;
        if (true) goto _L4; else goto _L8
_L8:
    }

    public void a(String s1, Boolean boolean1, int i1)
    {
        Object obj = (com.helpshift.k.a)g.get(i1);
        obj.i = Boolean.valueOf(false);
        obj.k = Boolean.valueOf(true);
        com.helpshift.f.c.b(((com.helpshift.k.a) (obj)).g, true);
        f.notifyDataSetChanged();
        obj = new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a1 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                a1.i = Boolean.valueOf(false);
                a1.j = Boolean.valueOf(true);
                a1.k = Boolean.valueOf(false);
                HSMessagesFragment.d(b).notifyDataSetChanged();
                com.helpshift.f.c.a(a1.g, true);
                com.helpshift.f.c.b(a1.g, false);
                com.helpshift.HSMessagesFragment.a(b, message);
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        };
        Handler handler = new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a1 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                a1.i = Boolean.valueOf(true);
                a1.k = Boolean.valueOf(false);
                com.helpshift.f.c.b(a1.g, false);
                HSMessagesFragment.d(b).notifyDataSetChanged();
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, com.helpshift.HSMessagesFragment.g(b));
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        };
        if (boolean1.booleanValue())
        {
            a(((Handler) (obj)), ((Handler) (handler)), e, "", "ca", s1);
        } else
        {
            a(((Handler) (obj)), ((Handler) (handler)), e, "", "ncr", s1);
        }
        s1 = new JSONObject();
        s1.put("id", e);
        if (boolean1.booleanValue())
        {
            com.helpshift.o.a("y", s1);
            return;
        }
        try
        {
            com.helpshift.o.a("n", s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.d("HelpShiftDebug", "JSONException", s1);
        }
        return;
    }

    public void a(JSONObject jsonobject, int i1, int j1)
    {
        com.helpshift.k.a a1 = (com.helpshift.k.a)g.get(i1);
        j1;
        JVM INSTR tableswitch 6 8: default 40
    //                   6 57
    //                   7 72
    //                   8 87;
           goto _L1 _L2 _L3 _L4
_L1:
        com.helpshift.c.a(jsonobject, i1, a1.g, e, j1);
        return;
_L2:
        a1.f = 1;
        b(a1);
        continue; /* Loop/switch isn't completed */
_L3:
        a1.f = 2;
        b(a1);
        if (true) goto _L1; else goto _L4
_L4:
        if (i.I(a1.g) || (new File(i.E(a1.g))).exists())
        {
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void b()
    {
        if (q != null)
        {
            q.getLooper().quit();
            p = null;
        }
        String s1 = i.f(k.B());
        String s2 = i.h(k.B());
        if (TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
        {
            return;
        } else
        {
            p = new Thread(new Runnable() {

                final HSMessagesFragment a;

                public void run()
                {
                    Looper.prepare();
                    com.helpshift.HSMessagesFragment.a(a, new Handler(this) {

                        final _cls18 a;

                        public void handleMessage(Message message)
                        {
                            Message message1 = HSMessagesFragment.h(a.a).obtainMessage();
                            message1.obj = message.obj;
                            HSMessagesFragment.h(a.a).sendMessage(message1);
                        }

            
            {
                a = _pcls18;
                super();
            }
                    });
                    (new Runnable(this) {

                        final _cls18 a;

                        public void run()
                        {
                            try
                            {
                                HSMessagesFragment.k(a.a).a(com.helpshift.HSMessagesFragment.f(a.a), HSMessagesFragment.i(a.a), com.helpshift.HSMessagesFragment.j(a.a));
                            }
                            catch (JSONException jsonexception)
                            {
                                Log.d("HelpShiftDebug", "get issues", jsonexception);
                            }
                            com.helpshift.HSMessagesFragment.f(a.a).postDelayed(this, 3000L);
                        }

            
            {
                a = _pcls18;
                super();
            }
                    }).run();
                    Looper.loop();
                }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
            });
            p.start();
            return;
        }
    }

    public void b(int i1)
    {
        i.b(Boolean.valueOf(true));
        u = true;
        Intent intent = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (intent.resolveActivity(c.getPackageManager()) != null)
        {
            startActivityForResult(intent, i1);
        } else
        {
            Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
            intent1.setType("image/*");
            intent1.putExtra("android.intent.extra.LOCAL_ONLY", true);
            if (intent1.resolveActivity(c.getPackageManager()) != null)
            {
                startActivityForResult(intent1, i1);
                return;
            }
        }
    }

    public void b(int i1, String s1, String s2, int j1)
    {
    }

    public void b(com.helpshift.k.a a1)
    {
        int j1 = h.getFirstVisiblePosition();
        int k1 = h.getLastVisiblePosition();
        int i1 = j1;
        do
        {
label0:
            {
                if (i1 <= k1)
                {
                    if (!a1.equals(h.getItemAtPosition(i1)))
                    {
                        break label0;
                    }
                    a1 = h.getChildAt(i1 - j1);
                    f.getView(i1, a1, h);
                }
                return;
            }
            i1++;
        } while (true);
    }

    public void c(int i1)
    {
        String s1 = k.B();
        com.helpshift.k.a a1 = (com.helpshift.k.a)g.get(i1);
        a1.i = Boolean.valueOf(false);
        a1.k = Boolean.valueOf(true);
        com.helpshift.f.c.b(a1.g, true);
        f.notifyDataSetChanged();
        Handler handler = new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a2 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                JSONObject jsonobject = (JSONObject)((HashMap)message.obj).get("response");
                try
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put("type", "url");
                    jsonobject1.put("body", jsonobject.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0).getString("url"));
                    jsonobject1.put("id", com.helpshift.HSMessagesFragment.b(b));
                    com.helpshift.o.a("m", jsonobject1);
                    if (HSMessagesFragment.n(b) != null)
                    {
                        HSMessagesFragment.n(b).b("User sent a screenshot");
                    }
                }
                catch (JSONException jsonexception)
                {
                    Log.d("HelpShiftDebug", "Error while getting screenshot url", jsonexception);
                }
                try
                {
                    com.helpshift.i.b.a(b.getActivity(), HSMessagesFragment.k(b), a2.h, a2.g, 0);
                }
                catch (IOException ioexception)
                {
                    Log.d("HelpShiftDebug", "Saving uploaded screenshot", ioexception);
                }
                if (a2.g.startsWith("localRscMessage_"))
                {
                    com.helpshift.h.e.f(a2.g);
                    HSMessagesFragment.s(b).remove(a);
                } else
                {
                    a2.k = Boolean.valueOf(false);
                    a2.j = Boolean.valueOf(true);
                    a2.h = "";
                    a2.i = Boolean.valueOf(false);
                    com.helpshift.f.c.b(a2.g, false);
                    com.helpshift.f.c.a(a2.g, true);
                    com.helpshift.f.c.a(a2.g, "");
                }
                HSMessagesFragment.d(b).notifyDataSetChanged();
                com.helpshift.HSMessagesFragment.a(b, message);
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        };
        Handler handler1 = new Handler(i1) {

            final int a;
            final HSMessagesFragment b;

            public void handleMessage(Message message)
            {
                com.helpshift.k.a a2 = (com.helpshift.k.a)HSMessagesFragment.s(b).get(a);
                a2.i = Boolean.valueOf(true);
                a2.k = Boolean.valueOf(false);
                com.helpshift.f.c.b(a2.g, false);
                HSMessagesFragment.d(b).notifyDataSetChanged();
                HSMessagesFragment.s(b).set(a, a2);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, com.helpshift.HSMessagesFragment.g(b));
            }

            
            {
                b = HSMessagesFragment.this;
                a = i1;
                super();
            }
        };
        j.b(handler, handler1, s1, e, "", "sc", a1.g, a1.h);
    }

    public void c(int i1, String s1, String s2, int j1)
    {
        if (!s2.equals(e)) goto _L2; else goto _L1
_L1:
        s2 = (com.helpshift.k.a)g.get(i1);
        if (!s1.equals(((com.helpshift.k.a) (s2)).g)) goto _L2; else goto _L3
_L3:
        j1;
        JVM INSTR tableswitch 6 7: default 60
    //                   6 61
    //                   7 72;
           goto _L2 _L4 _L5
_L2:
        return;
_L4:
        s2.f = 0;
        b(s2);
        return;
_L5:
        s2.f = 1;
        b(s2);
        return;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
label0:
        {
            super.onActivityResult(i1, j1, intent);
            if (-1 == j1)
            {
                if (i1 == 32700)
                {
                    break label0;
                }
                if (com.helpshift.i.b.b(getActivity(), intent))
                {
                    intent = com.helpshift.i.b.a(getActivity(), intent);
                    if (!TextUtils.isEmpty(intent))
                    {
                        Intent intent1 = new Intent(c, com/helpshift/ScreenshotPreviewActivity);
                        intent1.putExtra("SCREENSHOT", intent);
                        intent1.putExtra("screenshot_position", i1);
                        intent1.putExtra("showInFullScreen", com.helpshift.i.e.a(c));
                        startActivityForResult(intent1, 32700);
                    }
                }
            }
            return;
        }
        String s1 = intent.getExtras().getString("SCREENSHOT");
        i1 = intent.getExtras().getInt("screenshot_position");
        if (i1 == 0)
        {
            intent = com.helpshift.i.b.a(i, e, s1);
            g.add(intent);
        } else
        {
            intent = (com.helpshift.k.a)g.get(i1);
            intent.h = s1;
        }
        com.helpshift.f.c.a(((com.helpshift.k.a) (intent)).g, s1);
        f.notifyDataSetChanged();
        c(g.indexOf(intent));
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(configuration);
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        contextmenu.add(0, view.getId(), 0, "Copy");
        contextmenu = ((TextView)view).getText().toString();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            ((ClipboardManager)c.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copy Text", contextmenu));
            return;
        } else
        {
            ((android.text.ClipboardManager)c.getSystemService("clipboard")).setText(contextmenu);
            return;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(b.e.d, menu);
        F = menu.findItem(com.helpshift.b.c.e);
        com.helpshift.i.w.a(c, F.getIcon());
        if (!i.L().booleanValue() && y != null && y.getVisibility() == 0)
        {
            F.setVisible(true);
        } else
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            menu.removeItem(com.helpshift.b.c.e);
        } else
        {
            F.setVisible(true);
        }
        if (K || J)
        {
            F.setVisible(false);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "HSMessagesFragment#onCreateView", null);
_L1:
        c = (h)getActivity();
        c.d(false);
        d = getArguments();
        d.remove("message");
        k = new l(c);
        i = k.a;
        j = k.b;
        r = Boolean.valueOf(d.getBoolean("newIssue", false));
        s = Boolean.valueOf(d.getBoolean("decomp", false));
        l = d.getString("chatLaunchSource");
        t = Boolean.valueOf(d.getBoolean("showConvOnReportIssue"));
        L = this;
        M = com.helpshift.t.a();
        setHasOptionsMenu(true);
        H = (TextView)layoutinflater.inflate(b.d.z, null);
        com.helpshift.i.f.a(H, 0.7F);
        layoutinflater = layoutinflater.inflate(com.helpshift.b.d.g, viewgroup, false);
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "HSMessagesFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.helpshift.v.a(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        if (i1 == 0x102002c)
        {
            getActivity().onBackPressed();
            return true;
        }
        if (i1 == com.helpshift.b.c.e)
        {
            b(0);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        super.onPause();
        if (q != null)
        {
            q.getLooper().quit();
        }
        try
        {
            i.e(e);
            if (M != null)
            {
                M.a(0);
            }
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", jsonexception.getMessage(), jsonexception);
        }
        i.a(Boolean.valueOf(false));
        i.n("");
        k.s();
        c.unregisterReceiver(b);
        c.unregisterReceiver(a);
        com.helpshift.c.b();
        i.h(v.getText().toString().trim(), k.B());
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        F = menu.findItem(com.helpshift.b.c.e);
        if (F != null && i.L().booleanValue())
        {
            F.setVisible(false);
        }
    }

    public void onResume()
    {
        super.onResume();
        u = false;
        ((NotificationManager)getActivity().getSystemService("notification")).cancel(e, 1);
        i.K(e);
        Object obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("android.net.conn.CONNECTIVITY_CHANGE");
        c.registerReceiver(b, ((IntentFilter) (obj)));
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("com.helpshift.failedMessageRequest");
        c.registerReceiver(a, ((IntentFilter) (obj)));
        b();
        try
        {
            i.e(e);
            if (M != null)
            {
                M.a(0);
            }
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", jsonexception.toString(), jsonexception);
        }
        i.a(Boolean.valueOf(true));
        i.n(e);
        k.a(e, l);
        obj = i.v(k.B());
        if (!K)
        {
            v.setText(((CharSequence) (obj)));
        }
        if (E && TextUtils.isEmpty(((CharSequence) (obj))))
        {
            C = false;
        }
        E = false;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            if (y != null && y.getVisibility() == 0)
            {
                F.setVisible(true);
            } else
            {
                F.setVisible(false);
            }
        }
        com.helpshift.c.a(this);
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (u)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        com.helpshift.j.a(c);
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", e);
        com.helpshift.o.a("c", jsonobject);
        return;
        JSONException jsonexception;
        jsonexception;
        Log.d("HelpShiftDebug", "JSONException", jsonexception);
        return;
    }

    public void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        if (!u)
        {
            com.helpshift.j.b(c);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        h = (ListView)view.findViewById(b.c.o);
        v = (EditText)view.findViewById(b.c.p);
        bundle = (ImageButton)view.findViewById(com.helpshift.b.c.q);
        w = (LinearLayout)view.findViewById(b.c.r);
        x = (LinearLayout)view.findViewById(b.c.s);
        y = (RelativeLayout)view.findViewById(com.helpshift.b.c.t);
        z = (ImageButton)view.findViewById(0x1020019);
        A = (ImageButton)view.findViewById(0x102001a);
        B = (Button)view.findViewById(b.c.u);
        a(getResources().getConfiguration());
        G = (ViewStub)view.findViewById(b.c.T);
        com.helpshift.i.w.c(c, B.getCompoundDrawables()[0]);
        com.helpshift.i.w.f(c, z.getDrawable());
        com.helpshift.i.w.g(c, A.getDrawable());
        z.setOnClickListener(new android.view.View.OnClickListener() {

            final HSMessagesFragment a;

            public void onClick(View view1)
            {
                HSMessagesFragment.l(a).setText("");
                HSMessagesFragment.m(a).h("", HSMessagesFragment.k(a).B());
                com.helpshift.HSMessagesFragment.a(a, Boolean.valueOf(true));
                com.helpshift.HSMessagesFragment.b(a, false);
                com.helpshift.HSMessagesFragment.c(a);
                if (HSMessagesFragment.n(a) != null)
                {
                    HSMessagesFragment.n(a).b("User accepted the solution");
                }
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        });
        A.setOnClickListener(new android.view.View.OnClickListener() {

            final HSMessagesFragment a;

            public void onClick(View view1)
            {
                com.helpshift.v.a("message-filing");
                com.helpshift.HSMessagesFragment.a(a);
                com.helpshift.HSMessagesFragment.b(a, true);
                HSMessagesFragment.o(a);
                if (HSMessagesFragment.l(a).getText().toString().trim().length() == 0)
                {
                    com.helpshift.HSMessagesFragment.a(a, HSMessagesFragment.l(a));
                }
                com.helpshift.HSMessagesFragment.a(a, Boolean.valueOf(false));
                if (HSMessagesFragment.n(a) != null)
                {
                    HSMessagesFragment.n(a).b("User rejected the solution");
                }
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        });
        B.setOnClickListener(new android.view.View.OnClickListener() {

            final HSMessagesFragment a;

            public void onClick(View view1)
            {
                view1 = new Intent(com.helpshift.HSMessagesFragment.g(a), com/helpshift/HSConversation);
                view1.putExtra("showInFullScreen", com.helpshift.i.e.a(com.helpshift.HSMessagesFragment.g(a)));
                view1.putExtra("newConversation", true);
                view1.putExtras(HSMessagesFragment.p(a));
                view1.removeExtra("isRoot");
                a.getActivity().startActivityForResult(view1, 1);
                HSMessagesFragment.m(a).d("", HSMessagesFragment.k(a).B());
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        });
        h.setDivider(null);
        f = new com.helpshift.b.a(this, 0x1090003, g);
        view = new TextView(c);
        h.addFooterView(view);
        h.setAdapter(f);
        h.removeFooterView(view);
        e = d.getString("issueId");
        N = com.helpshift.f.a.d(e);
        c();
        h();
        h.setSelection(f.getCount() - 1);
        c.i().a(true);
        if (v.getText().length() == 0)
        {
            bundle.setEnabled(false);
            bundle.setAlpha(64);
            com.helpshift.i.w.d(c, bundle.getDrawable());
        } else
        {
            bundle.setEnabled(true);
            bundle.setAlpha(255);
            com.helpshift.i.w.e(c, bundle.getDrawable());
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final HSMessagesFragment a;

            public void onClick(View view1)
            {
                view1 = HSMessagesFragment.l(a).getText().toString().trim();
                if (TextUtils.isEmpty(view1))
                {
                    break MISSING_BLOCK_LABEL_137;
                }
                HSMessagesFragment.l(a).setText("");
                com.helpshift.HSMessagesFragment.a(a, com.helpshift.HSMessagesFragment.q(a), HSMessagesFragment.r(a), com.helpshift.HSMessagesFragment.b(a), view1, "txt", "");
                if (HSMessagesFragment.n(a) != null)
                {
                    HSMessagesFragment.n(a).b(view1);
                }
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("type", "txt");
                jsonobject.put("body", view1);
                jsonobject.put("id", com.helpshift.HSMessagesFragment.b(a));
                com.helpshift.o.a("m", jsonobject);
                return;
                view1;
                Log.d("HelpShiftDebug", "JSONException", view1);
                return;
            }

            
            {
                a = HSMessagesFragment.this;
                super();
            }
        });
        v.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener(bundle) {

            final ImageButton a;
            final HSMessagesFragment b;

            public boolean onEditorAction(TextView textview, int i1, KeyEvent keyevent)
            {
                if (i1 == 4)
                {
                    a.performClick();
                }
                return false;
            }

            
            {
                b = HSMessagesFragment.this;
                a = imagebutton;
                super();
            }
        });
        v.addTextChangedListener(new TextWatcher(bundle) {

            final ImageButton a;
            final HSMessagesFragment b;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                com.helpshift.HSMessagesFragment.b(b, true);
                if (charsequence.length() == 0)
                {
                    a.setEnabled(false);
                    a.setAlpha(64);
                    com.helpshift.i.w.d(com.helpshift.HSMessagesFragment.g(b), a.getDrawable());
                    return;
                } else
                {
                    a.setEnabled(true);
                    a.setAlpha(255);
                    com.helpshift.i.w.e(com.helpshift.HSMessagesFragment.g(b), a.getDrawable());
                    return;
                }
            }

            
            {
                b = HSMessagesFragment.this;
                a = imagebutton;
                super();
            }
        });
    }
}
