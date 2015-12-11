// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.helpshift.i.e;
import com.helpshift.i.g;
import com.helpshift.i.i;
import com.helpshift.i.o;
import com.helpshift.i.w;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, g, s, o, 
//            v, h, HSQuestion, j, 
//            a, HSConversation

public final class HSQuestionFragment extends Fragment
    implements TraceFieldInterface
{

    private Boolean A;
    private Handler B;
    public Handler a;
    public Handler b;
    android.view.View.OnClickListener c;
    android.view.View.OnClickListener d;
    private l e;
    private s f;
    private String g;
    private LinearLayout h;
    private Button i;
    private String j;
    private String k;
    private Boolean l;
    private int m;
    private h n;
    private i o;
    private Boolean p;
    private Boolean q;
    private Boolean r;
    private Boolean s;
    private Button t;
    private Button u;
    private TextView v;
    private TextView w;
    private TextView x;
    private JSONObject y;
    private Bundle z;

    public HSQuestionFragment()
    {
        g = "";
        l = Boolean.valueOf(false);
        m = 0;
        q = Boolean.valueOf(false);
        r = Boolean.valueOf(false);
        s = Boolean.valueOf(false);
        A = Boolean.valueOf(false);
        a = new Handler() {

            final HSQuestionFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, HSQuestionFragment.a(a));
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        };
        b = new Handler() {

            final HSQuestionFragment a;

            public void handleMessage(Message message)
            {
                message = (com.helpshift.g)message.obj;
                if (a.isResumed())
                {
                    HSQuestionFragment.a(a, message);
                }
                if (HSQuestionFragment.b(a).booleanValue())
                {
                    break MISSING_BLOCK_LABEL_91;
                }
                HSQuestionFragment.a(a, message.a());
                message = new JSONObject();
                message.put("id", HSQuestionFragment.c(a));
                com.helpshift.o.a("f", message);
                HSQuestionFragment.a(a, Boolean.valueOf(true));
                return;
                message;
                Log.d("HelpShiftDebug", "JSONException", message);
                return;
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        };
        B = new Handler() {

            final HSQuestionFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, HSQuestionFragment.a(a));
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        };
        c = new android.view.View.OnClickListener() {

            final HSQuestionFragment a;

            public void onClick(View view)
            {
                HSQuestionFragment.b(a, "startConversation");
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        };
        d = new android.view.View.OnClickListener() {

            final HSQuestionFragment a;

            public void onClick(View view)
            {
                view = new Intent(HSQuestionFragment.a(a), com/helpshift/HSConversation);
                view.putExtra("showInFullScreen", com.helpshift.i.e.a(HSQuestionFragment.a(a)));
                view.putExtra("chatLaunchSource", "support");
                view.putExtras(com.helpshift.HSQuestionFragment.g(a));
                view.removeExtra("isRoot");
                a.getActivity().startActivityForResult(view, 1);
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        };
    }

    static h a(HSQuestionFragment hsquestionfragment)
    {
        return hsquestionfragment.n;
    }

    static Boolean a(HSQuestionFragment hsquestionfragment, Boolean boolean1)
    {
        hsquestionfragment.q = boolean1;
        return boolean1;
    }

    static String a(HSQuestionFragment hsquestionfragment, String s1)
    {
        hsquestionfragment.g = s1;
        return s1;
    }

    private void a(Handler handler, Handler handler1, String s1, Boolean boolean1)
    {
        JSONObject jsonobject = new JSONObject();
        y = new JSONObject();
        try
        {
            y.put("id", s1);
            jsonobject.put("f", s1);
            jsonobject.put("h", boolean1);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSONException", jsonexception);
        }
        handler1 = e.a(handler1, s1, 0, jsonobject);
        e.a(handler, handler1, s1, boolean1);
    }

    static void a(HSQuestionFragment hsquestionfragment, Handler handler, Handler handler1, String s1, Boolean boolean1)
    {
        hsquestionfragment.a(handler, handler1, s1, boolean1);
    }

    static void a(HSQuestionFragment hsquestionfragment, com.helpshift.g g1)
    {
        hsquestionfragment.a(g1);
    }

    private void a(com.helpshift.g g1)
    {
        k = g1.e();
        j = g1.f();
        g = g1.a();
        l = g1.i();
        m = g1.g();
        A = Boolean.valueOf(false);
        h();
    }

    private void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            boolean1 = getResources().getString(b.g.j);
        } else
        {
            boolean1 = getResources().getString(b.g.k);
        }
        boolean1 = Toast.makeText(n, boolean1, 0);
        boolean1.setGravity(17, 0, 0);
        boolean1.show();
    }

    private void a(String s1)
    {
        if (!s1.equals("ticketAvoided")) goto _L2; else goto _L1
_L1:
        i();
        f.i("", e.A());
        f.j("", e.A());
_L4:
        Intent intent = new Intent();
        intent.putExtra("action", s1);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        return;
_L2:
        if (s1.equals("startConversation"))
        {
            com.helpshift.o.a("taf");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static Boolean b(HSQuestionFragment hsquestionfragment)
    {
        return hsquestionfragment.q;
    }

    static Boolean b(HSQuestionFragment hsquestionfragment, Boolean boolean1)
    {
        hsquestionfragment.r = boolean1;
        return boolean1;
    }

    static void b(HSQuestionFragment hsquestionfragment, String s1)
    {
        hsquestionfragment.a(s1);
    }

    static String c(HSQuestionFragment hsquestionfragment)
    {
        return hsquestionfragment.g;
    }

    static void c(HSQuestionFragment hsquestionfragment, Boolean boolean1)
    {
        hsquestionfragment.a(boolean1);
    }

    static Boolean d(HSQuestionFragment hsquestionfragment, Boolean boolean1)
    {
        hsquestionfragment.s = boolean1;
        return boolean1;
    }

    static JSONObject d(HSQuestionFragment hsquestionfragment)
    {
        return hsquestionfragment.y;
    }

    private void e()
    {
        if (!r.booleanValue() && !s.booleanValue())
        {
            v.setVisibility(0);
            t.setVisibility(0);
            u.setVisibility(0);
            x.setVisibility(8);
            i.setVisibility(8);
            w.setVisibility(8);
        }
    }

    static void e(HSQuestionFragment hsquestionfragment)
    {
        hsquestionfragment.g();
    }

    private void f()
    {
        if (p.booleanValue())
        {
            i.setVisibility(0);
        }
        if (c())
        {
            i.setVisibility(0);
            i.setText(b.g.O);
            i.setOnClickListener(c);
            com.helpshift.v.a("issue-filing");
        }
        x.setVisibility(0);
        v.setVisibility(8);
        t.setVisibility(8);
        u.setVisibility(8);
    }

    static void f(HSQuestionFragment hsquestionfragment)
    {
        hsquestionfragment.f();
    }

    static Bundle g(HSQuestionFragment hsquestionfragment)
    {
        return hsquestionfragment.z;
    }

    private void g()
    {
        v.setVisibility(8);
        t.setVisibility(8);
        u.setVisibility(8);
        w.setVisibility(0);
    }

    private void h()
    {
        Object obj1 = (LinearLayout)n.findViewById(b.c.v);
        Object obj = n.getTheme().obtainStyledAttributes(new int[] {
            0x1010031, 0x1010036
        });
        if (o == null)
        {
            o = new i(getActivity(), this);
            ((LinearLayout) (obj1)).addView(o.getLayout(), new android.widget.FrameLayout.LayoutParams(-1, -1));
            int i1 = ((TypedArray) (obj)).getColor(0, 0xffffff);
            o.setBackgroundColor(i1);
            obj1 = o.getSettings();
            ((WebSettings) (obj1)).setJavaScriptEnabled(true);
            if (android.os.Build.VERSION.SDK_INT <= 11)
            {
                ((WebSettings) (obj1)).setPluginState(android.webkit.WebSettings.PluginState.ON);
            }
            ((WebSettings) (obj1)).setTextSize(android.webkit.WebSettings.TextSize.NORMAL);
        }
        if (j.contains("<iframe"))
        {
            try
            {
                j = j.replace("https", "http");
            }
            catch (NullPointerException nullpointerexception)
            {
                Log.d("HelpShiftDebug", nullpointerexception.toString(), nullpointerexception);
            }
        }
        obj1 = String.format("#%06X", new Object[] {
            Integer.valueOf(((TypedArray) (obj)).getColor(1, 0xffffff) & 0xffffff)
        });
        ((TypedArray) (obj)).recycle();
        if (l.booleanValue())
        {
            obj = "<html dir=\"rtl\">";
        } else
        {
            obj = "<html>";
        }
        obj = (new StringBuilder()).append(((String) (obj))).append("<head>").append("<style type=\"text/css\">img, object, embed { max-width: 100%; }").append("body { margin: 0px 10px 10px 0px; padding: 0; line-height: 1.5; white-space: normal; word-wrap: break-word; color: ").append(((String) (obj1))).append("; }").append(".title { display:block; margin: -12px 0 6px 0; padding: 0; font-size: 1.3125em; line-height: 1.25 }").append("</style>").append("<script language=\"javascript\">var iframe = document.getElementsByTagName (\"iframe\") [0]; if (iframe) { iframe.width = \"100%\"; iframe.style.width = \"100%\"; }").append("document.addEventListener('click',function(event) {").append("if (event.target instanceof HTMLImageElement) { event.preventDefault(); event.stopPropagation(); }").append("}, false);").append("</script>\u200B").append("</head>").append("<body>").append("<strong class='title'>").append(k).append("</strong>").append(j).append("</body>").append("</html>").toString();
        o.loadDataWithBaseURL(null, ((String) (obj)), "text/html", "utf-8", null);
    }

    private void i()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", g);
            jsonobject.put("str", f.w(e.A()));
            com.helpshift.o.a("ta", jsonobject);
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "sendTicketAvoidedEvent", jsonexception);
        }
    }

    public void a()
    {
        if (m == 1)
        {
            g();
        } else
        {
            if (m == -1)
            {
                f();
                return;
            }
            if (m == 0)
            {
                e();
                return;
            }
        }
    }

    public void b()
    {
        Object obj1 = (ArrayList)z.get("searchTerms");
        if (!A.booleanValue() && obj1 != null && ((ArrayList) (obj1)).size() > 0)
        {
            Collections.sort(((java.util.List) (obj1)));
            Collections.reverse(((java.util.List) (obj1)));
            Object obj = new LinkedHashSet();
            String s2 = String.format("#%06X", new Object[] {
                Integer.valueOf(com.helpshift.i.w.a(getActivity(), b.a.s) & 0xffffff)
            });
            int i1;
            if (com.helpshift.i.o.a(k).equals(k) && com.helpshift.i.o.a(j).equals(j))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                int i3 = k.length();
                String s1 = "";
                ArrayList arraylist = new ArrayList();
                for (i1 = 0; i1 < i3; i1++)
                {
                    char c1 = k.charAt(i1);
                    String s6 = com.helpshift.i.o.a((new StringBuilder()).append(c1).append("").toString());
                    for (int i2 = 0; i2 < s6.length(); i2++)
                    {
                        s1 = (new StringBuilder()).append(s1).append(s6.charAt(i2)).toString();
                        arraylist.add(Integer.valueOf(i1));
                    }

                }

                String s7 = s1.toLowerCase();
                i3 = j.length();
                com.helpshift.i.o.a(j);
                s1 = "";
                ArrayList arraylist1 = new ArrayList();
                for (int j1 = 0; j1 < i3; j1++)
                {
                    char c2 = j.charAt(j1);
                    String s10 = com.helpshift.i.o.a((new StringBuilder()).append(c2).append("").toString());
                    for (int j2 = 0; j2 < s10.length(); j2++)
                    {
                        s1 = (new StringBuilder()).append(s1).append(s10.charAt(j2)).toString();
                        arraylist1.add(Integer.valueOf(j1));
                    }

                }

                s1 = s1.toLowerCase();
                obj1 = ((ArrayList) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s11 = (String)((Iterator) (obj1)).next();
                    if (s11.length() >= 3)
                    {
                        s11 = s11.toLowerCase();
                        for (int k1 = TextUtils.indexOf(s7, s11, 0); k1 >= 0; k1 = TextUtils.indexOf(s7, s11, s11.length() + k1))
                        {
                            int k2 = ((Integer)arraylist.get(k1)).intValue();
                            int j3 = ((Integer)arraylist.get((s11.length() + k1) - 1)).intValue();
                            ((LinkedHashSet) (obj)).add(k.substring(k2, j3 + 1));
                        }

                        int l1 = TextUtils.indexOf(s1, s11, 0);
                        while (l1 >= 0) 
                        {
                            int l2 = ((Integer)arraylist1.get(l1)).intValue();
                            int k3 = ((Integer)arraylist1.get((s11.length() + l1) - 1)).intValue();
                            ((LinkedHashSet) (obj)).add(j.substring(l2, k3 + 1));
                            l1 = TextUtils.indexOf(s1, s11, s11.length() + l1);
                        }
                    }
                } while (true);
            } else
            {
                Iterator iterator = ((ArrayList) (obj1)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s3 = (String)iterator.next();
                    if (s3.length() >= 3)
                    {
                        ((LinkedHashSet) (obj)).add(s3);
                    }
                } while (true);
            }
            j = (new StringBuilder()).append(">").append(j).append("<").toString();
            k = (new StringBuilder()).append(">").append(k).append("<").toString();
            Pattern pattern = Pattern.compile(">[^<]+<");
            for (obj = ((LinkedHashSet) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                String s4 = (String)((Iterator) (obj)).next();
                String s5 = k;
                for (Matcher matcher = pattern.matcher(s5); matcher.find();)
                {
                    String s8 = s5.substring(matcher.start(), matcher.end());
                    String s12 = s8.replaceAll((new StringBuilder()).append("(?i)(").append(s4).append(")").toString(), (new StringBuilder()).append("<span style=\"background-color: ").append(s2).append("\">$1</span>").toString());
                    k = k.replace(s8, s12);
                }

                s5 = j;
                Matcher matcher1 = pattern.matcher(s5);
                while (matcher1.find()) 
                {
                    String s9 = s5.substring(matcher1.start(), matcher1.end());
                    String s13 = s9.replaceAll((new StringBuilder()).append("(?i)(").append(s4).append(")").toString(), (new StringBuilder()).append("<span style=\"background-color: ").append(s2).append("\">$1</span>").toString());
                    j = j.replace(s9, s13);
                }
            }

            k = k.substring(1, k.length() - 1);
            j = j.substring(1, j.length() - 1);
            A = Boolean.valueOf(true);
            h();
        }
    }

    public boolean c()
    {
        return ((HSQuestion)getActivity()).h();
    }

    public void d()
    {
        h.setVisibility(8);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("HSQuestionFragment");
        TraceMachine.enterMethod(_nr_trace, "HSQuestionFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSQuestionFragment#onCreate", null);
          goto _L1
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "HSQuestionFragment#onCreateView", null);
_L1:
        n = (h)getActivity();
        e = new l(n);
        f = e.a;
        layoutinflater = layoutinflater.inflate(com.helpshift.b.d.i, viewgroup, false);
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "HSQuestionFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        if (o != null)
        {
            o.freeMemory();
            o.removeAllViews();
            ((ViewGroup)o.getParent()).removeView(o);
            o.destroy();
        }
        com.helpshift.v.a(null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        if (i1 == 0x102002c)
        {
            if (o != null && o.a())
            {
                o.b();
                return true;
            } else
            {
                getActivity().finish();
                return true;
            }
        }
        if (i1 == b.c.ag)
        {
            a("ticketAvoided");
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        try
        {
            if (o != null)
            {
                Class.forName("android.webkit.WebView").getMethod("onPause", (Class[])null).invoke(o, (Object[])null);
            }
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.d("HelpShiftDebug", "ClassNotFoundException : ", classnotfoundexception);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.d("HelpShiftDebug", "NoSuchMethodException : ", nosuchmethodexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.d("HelpShiftDebug", "InvocationTargetException : ", invocationtargetexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.d("HelpShiftDebug", "IllegalAccessException : ", illegalaccessexception);
        }
        super.onPause();
    }

    public void onResume()
    {
        if (o != null)
        {
            o.onResume();
        }
        if (!TextUtils.isEmpty(g) && !q.booleanValue())
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("id", g);
                com.helpshift.o.a("f", jsonobject);
                q = Boolean.valueOf(true);
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "JSONException", jsonexception);
            }
        }
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        z = n.getIntent().getExtras();
        if (z != null)
        {
            if (z.get("questionPublishId") != null)
            {
                if (z.getBoolean("decomp"))
                {
                    j.a = true;
                }
                bundle = (String)z.get("questionPublishId");
                e.c(bundle, b, B);
            }
            p = Boolean.valueOf(com.helpshift.a.a(a.a.c));
        }
        bundle = n.getTheme().obtainStyledAttributes(new int[] {
            0x1010031
        });
        int i1 = bundle.getColor(0, 0xffffff);
        bundle.recycle();
        getView().setBackgroundColor(i1);
        h = (LinearLayout)view.findViewById(com.helpshift.b.c.w);
        v = (TextView)view.findViewById(b.c.x);
        w = (TextView)view.findViewById(b.c.y);
        x = (TextView)view.findViewById(b.c.z);
        i = (Button)view.findViewById(b.c.A);
        com.helpshift.i.w.c(n, i.getCompoundDrawables()[0]);
        t = (Button)view.findViewById(b.c.B);
        t.setOnClickListener(new android.view.View.OnClickListener() {

            final HSQuestionFragment a;

            public void onClick(View view1)
            {
                HSQuestionFragment.b(a, Boolean.valueOf(true));
                HSQuestionFragment.a(a, new Handler(), a.a, HSQuestionFragment.c(a), Boolean.valueOf(true));
                com.helpshift.o.a("h", HSQuestionFragment.d(a));
                com.helpshift.HSQuestionFragment.e(a);
                HSQuestionFragment.c(a, Boolean.valueOf(true));
                if (a.c())
                {
                    HSQuestionFragment.b(a, "ticketAvoided");
                }
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        });
        u = (Button)view.findViewById(b.c.C);
        u.setOnClickListener(new android.view.View.OnClickListener() {

            final HSQuestionFragment a;

            public void onClick(View view1)
            {
                HSQuestionFragment.d(a, Boolean.valueOf(true));
                HSQuestionFragment.a(a, new Handler(), a.a, HSQuestionFragment.c(a), Boolean.valueOf(false));
                com.helpshift.o.a("u", HSQuestionFragment.d(a));
                com.helpshift.HSQuestionFragment.f(a);
                HSQuestionFragment.c(a, Boolean.valueOf(false));
            }

            
            {
                a = HSQuestionFragment.this;
                super();
            }
        });
        i.setOnClickListener(d);
        setHasOptionsMenu(true);
    }
}
