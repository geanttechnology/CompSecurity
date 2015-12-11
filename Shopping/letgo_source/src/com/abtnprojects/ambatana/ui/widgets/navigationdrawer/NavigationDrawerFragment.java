// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.a;
import android.support.v7.aqo;
import android.support.v7.dy;
import android.support.v7.eb;
import android.support.v7.ee;
import android.support.v7.eq;
import android.support.v7.iu;
import android.support.v7.iv;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abtnprojects.ambatana.models.DrawerMenuItem;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.parse.ParseFile;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            g, f, b, c

public class NavigationDrawerFragment extends Fragment
    implements g, TraceFieldInterface
{
    public class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final NavigationDrawerFragment a;

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

        protected transient DrawerMenuItem a(Void avoid[])
        {
            return com.abtnprojects.ambatana.ui.widgets.navigationdrawer.NavigationDrawerFragment.a(a, ParseUser.getCurrentUser());
        }

        protected void a(DrawerMenuItem drawermenuitem)
        {
            if (a.isAdded() && drawermenuitem != null)
            {
                NavigationDrawerFragment.b(a).a(drawermenuitem);
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment$a#doInBackground", null);
_L1:
            aobj = a((Void[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "NavigationDrawerFragment$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment$a#onPostExecute", null);
_L1:
            a((DrawerMenuItem)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "NavigationDrawerFragment$a#onPostExecute", null);
              goto _L1
        }

        public a()
        {
            a = NavigationDrawerFragment.this;
            super();
        }
    }


    private android.support.v7.app.a a;
    private DrawerLayout b;
    private RecyclerView c;
    private View d;
    private String e;
    private f f;
    private b g;
    private android.view.View.OnClickListener h;
    private a i;

    public NavigationDrawerFragment()
    {
    }

    static android.support.v7.app.a a(NavigationDrawerFragment navigationdrawerfragment)
    {
        return navigationdrawerfragment.a;
    }

    static DrawerMenuItem a(NavigationDrawerFragment navigationdrawerfragment, ParseUser parseuser)
    {
        return navigationdrawerfragment.a(parseuser);
    }

    private DrawerMenuItem a(ParseUser parseuser)
    {
        String s;
        String s1;
        if (iu.c(parseuser))
        {
            s1 = parseuser.getString("username_public");
            String s2 = parseuser.getString("city");
            String s3 = parseuser.getString("country_code");
            aqo.a("Menu city is %s", new Object[] {
                s2
            });
            s = s2;
            if (s2 == null)
            {
                s = s2;
                if (s3 == null)
                {
                    s = e;
                }
            }
            if (TextUtils.isEmpty(s) || "null".equals(s))
            {
                s = "";
            }
        } else
        {
            s1 = getString(0x7f0900e8);
            s = getString(0x7f0900e7);
        }
        return new DrawerMenuItem(2, 0, s1, s, b(parseuser), 0);
    }

    static f b(NavigationDrawerFragment navigationdrawerfragment)
    {
        return navigationdrawerfragment.f;
    }

    private String b(ParseUser parseuser)
    {
        if (!iu.c(parseuser))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        parseuser = parseuser.getParseFile("avatar");
        if (parseuser != null) goto _L2; else goto _L1
_L1:
        parseuser = "false";
_L4:
        return parseuser;
_L2:
        String s;
        s = parseuser.getUrl();
        parseuser = s;
        if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        return "false";
        return "false";
    }

    private void d(int j)
    {
        if (b != null)
        {
            b.i(d);
        }
        ((f)c.getAdapter()).b(j);
    }

    private void f()
    {
        if (i != null && i.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            i.cancel(true);
        }
    }

    private void g()
    {
        i = new a();
        a a1 = i;
        Void avoid[] = new Void[0];
        if (!(a1 instanceof AsyncTask))
        {
            a1.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)a1, avoid);
            return;
        }
    }

    public void a(int j)
    {
        aqo.a("onNavigationDrawerItemSelected position : %d", new Object[] {
            Integer.valueOf(j)
        });
        d(j);
        long l = f.c(j);
        g.a(l, ParseUser.getCurrentUser());
    }

    public void a(int j, DrawerLayout drawerlayout, Toolbar toolbar)
    {
        d = getActivity().findViewById(j);
        b = drawerlayout;
        a = com.abtnprojects.ambatana.ui.widgets.navigationdrawer.c.a(getActivity(), drawerlayout, toolbar, 0x7f0900e9, 0x7f0900e5, this);
        b.post(new Runnable() {

            final NavigationDrawerFragment a;

            public void run()
            {
                com.abtnprojects.ambatana.ui.widgets.navigationdrawer.NavigationDrawerFragment.a(a).a();
            }

            
            {
                a = NavigationDrawerFragment.this;
                super();
            }
        });
        b.setDrawerListener(a);
        g = new b(drawerlayout, getActivity());
        h = a.b();
    }

    public void a(boolean flag, int j)
    {
        a.a(flag);
        a.b(j);
        if (flag)
        {
            a.a(h);
            return;
        } else
        {
            a.a(new android.view.View.OnClickListener() {

                final NavigationDrawerFragment a;

                public void onClick(View view)
                {
                    if (a.isAdded())
                    {
                        a.getActivity().onBackPressed();
                    }
                }

            
            {
                a = NavigationDrawerFragment.this;
                super();
            }
            });
            return;
        }
    }

    public boolean a()
    {
        return b != null && b.j(d);
    }

    public List b()
    {
        ParseUser parseuser = ParseUser.getCurrentUser();
        ArrayList arraylist = new ArrayList();
        aqo.b("Current user value: %s", new Object[] {
            parseuser.getUsername()
        });
        aqo.b("Current user is authenticated %s", new Object[] {
            Boolean.valueOf(parseuser.isAuthenticated())
        });
        arraylist.add(a(parseuser));
        arraylist.add(new DrawerMenuItem(3, 1, getString(0x7f0900f1), "", "", 0x7f020112));
        arraylist.add(new DrawerMenuItem(4, 3, getString(0x7f0900ed), "", "", 0x7f020111));
        arraylist.add(new DrawerMenuItem(5, 1, getString(0x7f0900ee), "", "", 0x7f0200f9));
        arraylist.add(new DrawerMenuItem(6, 1, getString(0x7f0900ea), "", "", 0x7f020110));
        arraylist.add(new DrawerMenuItem(7, 1, getString(0x7f0900f0), "", "", 0x7f0200e4));
        arraylist.add(new DrawerMenuItem(8, 1, getString(0x7f0900ef), "", "", 0x7f0200db));
        arraylist.add(new DrawerMenuItem(9, 1, getString(0x7f0900ec), "", "", 0x7f0200f7));
        return arraylist;
    }

    public void b(int j)
    {
        f.a(j);
    }

    public void c()
    {
        b.i(d);
    }

    public void c(int j)
    {
        a(false, j);
        if (b != null)
        {
            b.setDrawerLockMode(1);
        }
    }

    public void d()
    {
        aqo.a("onUserLoggedIn: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        e();
    }

    public void e()
    {
        f.a(a(ParseUser.getCurrentUser()));
    }

    public void on(dy dy)
    {
        e();
    }

    public void on(eb eb)
    {
        aqo.a("on FacebookLoginFinished: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        e();
    }

    public void on(ee ee)
    {
        aqo.a("on LocationUpdatedEvent : hash %s ", new Object[] {
            Integer.valueOf(hashCode())
        });
        e();
    }

    public void on(eq eq)
    {
        aqo.a("on UserGeoReadyEvent: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        e();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a.a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("NavigationDrawerFragment");
        TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        e = getString(0x7f09011b);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "NavigationDrawerFragment#onCreate", null);
          goto _L1
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "NavigationDrawerFragment#onCreateView", null);
_L1:
        aqo.a("onCreateView : hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        layoutinflater = layoutinflater.inflate(0x7f04003b, viewgroup, false);
        c = (RecyclerView)layoutinflater.findViewById(0x7f1000ff);
        viewgroup = new LinearLayoutManager(getActivity());
        viewgroup.setOrientation(1);
        c.setLayoutManager(viewgroup);
        c.setHasFixedSize(true);
        f = new f(b());
        f.a(this);
        c.setAdapter(f);
        iv.a(this);
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "NavigationDrawerFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        aqo.a("onDestroyView: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        iv.b(this);
    }

    public void onPause()
    {
        super.onPause();
        aqo.a("onPause: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        f();
    }

    public void onResume()
    {
        super.onResume();
        aqo.a("onResume: hash %s", new Object[] {
            Integer.valueOf(hashCode())
        });
        g();
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
}
