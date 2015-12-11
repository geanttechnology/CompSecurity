// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.support.v4.app.f;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.helpshift.app.a;
import com.helpshift.app.b;
import com.helpshift.i.e;
import com.helpshift.i.g;
import com.helpshift.i.w;
import com.helpshift.i.x;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            n, l, ab, o, 
//            g, HSQuestion, h, a, 
//            j, HSConversation

public final class HSSectionFragment extends ListFragment
    implements com.helpshift.j.c.a, com.helpshift.j.c.c, n, TraceFieldInterface
{

    private boolean A;
    private boolean B;
    private String C;
    private b D;
    private Handler E;
    private Handler F;
    private ArrayList i;
    private ArrayList j;
    private h k;
    private l l;
    private ArrayAdapter m;
    private ArrayAdapter n;
    private String o;
    private String p;
    private String q;
    private ListView r;
    private View s;
    private MenuItem t;
    private String u;
    private String v;
    private String w;
    private Boolean x;
    private boolean y;
    private boolean z;

    public HSSectionFragment()
    {
        i = new ArrayList();
        j = new ArrayList();
        w = "";
        x = Boolean.valueOf(false);
        y = false;
        B = false;
        E = new Handler() {

            final HSSectionFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message = (ab)message.obj;
                com.helpshift.HSSectionFragment.a(a, message);
            }

            
            {
                a = HSSectionFragment.this;
                super();
            }
        };
        F = new Handler() {

            final HSSectionFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, HSSectionFragment.d(a));
            }

            
            {
                a = HSSectionFragment.this;
                super();
            }
        };
    }

    static MenuItem a(HSSectionFragment hssectionfragment)
    {
        return hssectionfragment.t;
    }

    static void a(HSSectionFragment hssectionfragment, ab ab1)
    {
        hssectionfragment.a(ab1);
    }

    private void a(ab ab1)
    {
        ArrayList arraylist = l.a(q);
        if (x.booleanValue() && ab1 != null)
        {
            k.i().a(ab1.b());
        }
        if (ab1 == null)
        {
            com.helpshift.i.g.a(404, null, k);
            return;
        }
        i.clear();
        o = ab1.c();
        p = ab1.a();
        int i1;
        if (getUserVisibleHint() && o != null && !B)
        {
            try
            {
                ab1 = new JSONObject();
                ab1.put("id", o);
                com.helpshift.o.a("b", ab1);
                B = true;
            }
            // Misplaced declaration of an exception variable
            catch (ab ab1)
            {
                Log.d("HelpShiftDebug", ab1.toString(), ab1);
            }
        }
        for (i1 = 0; i1 < arraylist.size(); i1++)
        {
            ab1 = (com.helpshift.g)arraylist.get(i1);
            i.add(ab1);
        }

        if (i.size() == 0)
        {
            i.add(new com.helpshift.g(getResources().getString(b.g.i), "0", "empty_status"));
        }
        m.notifyDataSetChanged();
    }

    private void a(ArrayList arraylist)
    {
        if (arraylist.size() == 0 || z)
        {
            s.setVisibility(0);
        } else
        {
            s.setVisibility(8);
        }
        j.clear();
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            com.helpshift.g g1 = (com.helpshift.g)arraylist.get(i1);
            if (g1.c().equals(p))
            {
                j.add(g1);
            }
        }

        n.notifyDataSetChanged();
    }

    static b b(HSSectionFragment hssectionfragment)
    {
        return hssectionfragment.D;
    }

    static void c(HSSectionFragment hssectionfragment)
    {
        hssectionfragment.h();
    }

    static h d(HSSectionFragment hssectionfragment)
    {
        return hssectionfragment.k;
    }

    private void d(String s1)
    {
        if (!TextUtils.isEmpty(s1.trim()) && !s1.equals(v))
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("s", s1);
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "JSONException", jsonexception);
            }
            com.helpshift.o.a("s", jsonobject);
            v = s1;
        }
    }

    static String e(HSSectionFragment hssectionfragment)
    {
        return hssectionfragment.u;
    }

    static String f(HSSectionFragment hssectionfragment)
    {
        return hssectionfragment.w;
    }

    private void h()
    {
        d(D.b(t).toString().trim());
    }

    public void a()
    {
        a(l.d(q));
    }

    public void a(ListView listview, View view, int i1, long l1)
    {
        if (y)
        {
            h();
            listview = (com.helpshift.g)j.get(i1);
        } else
        {
            listview = (com.helpshift.g)i.get(i1);
        }
        if (!listview.d().equals("empty_status"))
        {
            view = new Intent(k, com/helpshift/HSQuestion);
            view.putExtra("questionPublishId", listview.b());
            view.putExtra("decomp", x);
            view.putExtra("showInFullScreen", com.helpshift.i.e.a(k));
            view.putExtra("searchTerms", listview.j());
            view.putExtras(getActivity().getIntent().getExtras());
            view.removeExtra("isRoot");
            getActivity().startActivityForResult(view, 1);
        }
    }

    protected void a(String s1)
    {
        boolean flag = false;
        u = s1.trim();
        if (C.equals("zh") || C.equals("ja") || C.equals("ko"))
        {
            flag = true;
        }
        if (u.length() == 0 || u.length() < 3 && !flag)
        {
            c();
            return;
        } else
        {
            a(l.a(u, com.helpshift.q.a.a));
            return;
        }
    }

    public void b()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final HSSectionFragment a;

            public void run()
            {
                a.a(com.helpshift.HSSectionFragment.f(a));
            }

            
            {
                a = HSSectionFragment.this;
                super();
            }
        });
    }

    public boolean b(String s1)
    {
        return false;
    }

    protected void c()
    {
        a(l.a(p));
    }

    public boolean c(String s1)
    {
        if (s1.length() == 0)
        {
            d(w);
        } else
        {
            w = s1;
        }
        a(s1);
        return false;
    }

    protected void d()
    {
        if (r.getFooterViewsCount() != 0)
        {
            r.removeFooterView(s);
        }
        a(m);
        m.notifyDataSetChanged();
        y = false;
    }

    public boolean e()
    {
        v = "";
        w = "";
        g();
        k.b(false);
        D.c(com.helpshift.i.x.a(getActivity()));
        return true;
    }

    public boolean f()
    {
        h();
        d();
        if (com.helpshift.a.a(com.helpshift.a.a.a))
        {
            k.b(true);
        }
        return true;
    }

    protected void g()
    {
        if (r.getFooterViewsCount() == 0 && z)
        {
            r.addFooterView(s);
        } else
        {
            r.addFooterView(s, null, false);
            r.setFooterDividersEnabled(false);
        }
        c();
        a(n);
        n.notifyDataSetChanged();
        y = true;
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("HSSectionFragment");
        TraceMachine.enterMethod(_nr_trace, "HSSectionFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            q = bundle.getString("sectionPublishId");
            if (q == null)
            {
                q = "";
            }
            z = com.helpshift.a.a(com.helpshift.a.a.b);
            if (bundle.getBoolean("decomp"))
            {
                com.helpshift.j.a = true;
                x = Boolean.valueOf(true);
            }
        }
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSSectionFragment#onCreate", null);
          goto _L1
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (x.booleanValue())
        {
            t = menu.findItem(b.c.m);
            com.helpshift.i.w.a(k, t.getIcon());
            D.a(t, getResources().getString(b.g.h));
            D.a(t, this);
            D.a(t, this);
            l.r();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "HSSectionFragment#onCreateView", null);
_L1:
        k = (h)getActivity();
        D = k.i();
        l = new l(k);
        NoSuchFieldError nosuchfielderror;
        if (z)
        {
            s = layoutinflater.inflate(b.d.d, null, false);
        } else
        {
            s = layoutinflater.inflate(com.helpshift.b.d.e, null, false);
        }
        m = new ArrayAdapter(k, com.helpshift.b.d.f, i);
        n = new com.helpshift.b.b(k, com.helpshift.b.d.f, j);
        a(m);
        C = Locale.getDefault().getLanguage();
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        TraceMachine.exitMethod();
        return layoutinflater;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSSectionFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.helpshift.l.b(this);
    }

    public void onResume()
    {
        boolean flag = true;
        super.onResume();
        if ((x.booleanValue() || A) && o != null)
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("id", o);
                com.helpshift.o.a("b", jsonobject);
                B = true;
            }
            catch (JSONException jsonexception)
            {
                Log.d("HelpShiftDebug", "event data", jsonexception);
            }
        }
        if (com.helpshift.a.a(com.helpshift.a.a.a))
        {
            h h1 = k;
            if (y)
            {
                flag = false;
            }
            h1.b(flag);
        }
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
        r = f_();
        if (x.booleanValue())
        {
            r.setOnTouchListener(new android.view.View.OnTouchListener() {

                final HSSectionFragment a;

                public boolean onTouch(View view1, MotionEvent motionevent)
                {
                    if (com.helpshift.HSSectionFragment.a(a) != null)
                    {
                        com.helpshift.HSSectionFragment.b(a).c(com.helpshift.HSSectionFragment.a(a));
                    }
                    return false;
                }

            
            {
                a = HSSectionFragment.this;
                super();
            }
            });
            if (z)
            {
                ((Button)s.findViewById(b.c.n)).setOnClickListener(new android.view.View.OnClickListener() {

                    final HSSectionFragment a;

                    public void onClick(View view1)
                    {
                        HSSectionFragment.c(a);
                        view1 = new Intent(HSSectionFragment.d(a), com/helpshift/HSConversation);
                        view1.putExtra("message", com.helpshift.HSSectionFragment.e(a));
                        com.helpshift.HSSectionFragment.b(a).a(com.helpshift.HSSectionFragment.a(a));
                        view1.putExtra("showInFullScreen", com.helpshift.i.e.a(HSSectionFragment.d(a)));
                        view1.putExtra("showConvOnReportIssue", HSSectionFragment.d(a).getIntent().getExtras().getBoolean("showConvOnReportIssue"));
                        view1.putExtra("chatLaunchSource", "support");
                        a.getActivity().startActivityForResult(view1, 1);
                    }

            
            {
                a = HSSectionFragment.this;
                super();
            }
                });
            }
            setHasOptionsMenu(true);
        }
        com.helpshift.l.a(this);
        if (x.booleanValue())
        {
            l.a(q, E, F);
        } else
        {
            l.b(q, E, F);
        }
        view = new ColorDrawable(com.helpshift.i.w.a(k, b.a.p));
        r.setDivider(view);
        r.setDividerHeight(1);
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        A = flag;
        if (!flag || o == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", o);
        com.helpshift.o.a("b", jsonobject);
        B = true;
        return;
        JSONException jsonexception;
        jsonexception;
        Log.d("HelpShiftDebug", jsonexception.toString(), jsonexception);
        return;
    }
}
