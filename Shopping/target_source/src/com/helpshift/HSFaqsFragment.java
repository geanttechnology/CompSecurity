// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.support.v4.app.f;
import android.text.TextUtils;
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
import com.helpshift.app.b;
import com.helpshift.i.e;
import com.helpshift.i.g;
import com.helpshift.i.w;
import com.helpshift.i.x;
import com.helpshift.j.a;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            g, o, x, HSQuestionsList, 
//            HSQuestion, l, h, a, 
//            HSConversation, ab

public final class HSFaqsFragment extends ListFragment
    implements com.helpshift.j.c.a, com.helpshift.j.c.c, TraceFieldInterface
{

    private String A;
    private b B;
    private Handler C;
    private Handler D;
    private final String i = "HelpShiftDebug";
    private h j;
    private Bundle k;
    private String l;
    private l m;
    private ArrayAdapter n;
    private ArrayAdapter o;
    private List p;
    private List q;
    private ListView r;
    private View s;
    private a t;
    private MenuItem u;
    private String v;
    private String w;
    private boolean x;
    private boolean y;
    private boolean z;

    public HSFaqsFragment()
    {
        p = new ArrayList();
        q = new ArrayList();
        v = "";
        w = "";
        x = false;
        y = false;
        z = false;
        C = new Handler() {

            final HSFaqsFragment a;

            public void handleMessage(Message message)
            {
                int i1 = 0;
                boolean flag = false;
                super.handleMessage(message);
                new ArrayList();
                message = (ArrayList)message.obj;
                message = HSFaqsFragment.h(a).a(message);
                HSFaqsFragment.i(a).clear();
                if (message.size() == 1)
                {
                    message = HSFaqsFragment.h(a).a(((ab)message.get(0)).a());
                    for (i1 = ((flag) ? 1 : 0); i1 < message.size(); i1++)
                    {
                        com.helpshift.g g1 = (com.helpshift.g)message.get(i1);
                        HSFaqsFragment.i(a).add(new com.helpshift.g(g1.e(), g1.b(), "question"));
                    }

                } else
                {
                    for (; i1 < message.size(); i1++)
                    {
                        ab ab1 = (ab)message.get(i1);
                        if (!HSFaqsFragment.h(a).a(ab1))
                        {
                            HSFaqsFragment.i(a).add(new com.helpshift.g(ab1.b(), ab1.a(), "section"));
                        }
                    }

                }
                if (HSFaqsFragment.i(a).size() == 0)
                {
                    HSFaqsFragment.i(a).add(new com.helpshift.g(a.getResources().getString(b.g.i), "0", "empty_status"));
                }
                if (a.isResumed())
                {
                    a.a(true);
                }
                HSFaqsFragment.j(a).notifyDataSetChanged();
            }

            
            {
                a = HSFaqsFragment.this;
                super();
            }
        };
        D = new Handler() {

            final HSFaqsFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, HSFaqsFragment.d(a));
            }

            
            {
                a = HSFaqsFragment.this;
                super();
            }
        };
    }

    static MenuItem a(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.u;
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
        q.clear();
        for (int i1 = 0; i1 < arraylist.size(); i1++)
        {
            com.helpshift.g g1 = (com.helpshift.g)arraylist.get(i1);
            q.add(g1);
        }

        o.notifyDataSetChanged();
    }

    static b b(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.B;
    }

    static void c(HSFaqsFragment hsfaqsfragment)
    {
        hsfaqsfragment.g();
    }

    static h d(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.j;
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
                com.helpshift.x.b("HelpShiftDebug", "JSONException", jsonexception);
            }
            com.helpshift.o.a("s", jsonobject);
            v = s1;
        }
    }

    static String e(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.l;
    }

    static Bundle f(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.k;
    }

    private void g()
    {
        d(B.b(u).toString().trim());
    }

    static boolean g(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.y;
    }

    static l h(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.m;
    }

    static List i(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.p;
    }

    static ArrayAdapter j(HSFaqsFragment hsfaqsfragment)
    {
        return hsfaqsfragment.n;
    }

    public void a(ListView listview, View view, int i1, long l1)
    {
        if (x)
        {
            g();
            listview = (com.helpshift.g)q.get(i1);
        } else
        {
            listview = (com.helpshift.g)p.get(i1);
        }
        if (!listview.d().equals("empty_status"))
        {
            if (listview.d().equals("section"))
            {
                view = new Intent(j, com/helpshift/HSQuestionsList);
                view.putExtra("sectionPublishId", listview.b());
                listview = view;
            } else
            {
                view = new Intent(j, com/helpshift/HSQuestion);
                view.putExtra("questionPublishId", listview.b());
                view.putExtra("decomp", y);
                view.putExtra("searchTerms", listview.j());
                listview = view;
            }
            listview.putExtra("showInFullScreen", com.helpshift.i.e.a(j));
            listview.putExtras(k);
            listview.removeExtra("isRoot");
            getActivity().startActivityForResult(listview, 1);
        }
    }

    protected void a(String s1)
    {
        boolean flag = false;
        l = s1.trim();
        if (A.equals("zh") || A.equals("ja") || A.equals("ko"))
        {
            flag = true;
        }
        if (l.length() == 0 || l.length() < 3 && !flag)
        {
            b();
            return;
        } else
        {
            a(m.a(l, com.helpshift.q.a.a));
            return;
        }
    }

    protected void b()
    {
        a(m.c());
    }

    public boolean b(String s1)
    {
        return false;
    }

    protected void c()
    {
        if (r.getFooterViewsCount() != 0)
        {
            r.removeFooterView(s);
        }
        a(n);
        n.notifyDataSetChanged();
        x = false;
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
        if (r.getFooterViewsCount() == 0 && z)
        {
            r.addFooterView(s);
        } else
        {
            r.addFooterView(s, null, false);
            r.setFooterDividersEnabled(false);
        }
        b();
        a(o);
        o.notifyDataSetChanged();
        x = true;
    }

    public boolean e()
    {
        v = "";
        w = "";
        if (t != null)
        {
            t.setPagingEnabled(false);
        }
        if (!y)
        {
            B.b(0);
        }
        d();
        j.b(false);
        B.c(com.helpshift.i.x.a(getActivity()));
        return true;
    }

    public boolean f()
    {
        g();
        if (t != null)
        {
            t.setPagingEnabled(true);
        }
        c();
        if (com.helpshift.a.a(com.helpshift.a.a.a))
        {
            j.b(true);
        }
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        u = menu.findItem(b.c.m);
        com.helpshift.i.w.a(j, u.getIcon());
        B.a(u, getResources().getString(b.g.h));
        B.a(u, this);
        B.a(u, this);
        m.r();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "HSFaqsFragment#onCreateView", null);
_L1:
        j = (h)getActivity();
        k = j.getIntent().getExtras();
        if (k != null)
        {
            y = k.getBoolean("decomp");
            z = com.helpshift.a.a(com.helpshift.a.a.b);
        }
        B = j.i();
        m = new l(j);
        NoSuchFieldError nosuchfielderror;
        int i1;
        if (z)
        {
            s = layoutinflater.inflate(b.d.d, null, false);
        } else
        {
            s = layoutinflater.inflate(com.helpshift.b.d.e, null, false);
        }
        i1 = com.helpshift.b.d.f;
        n = new ArrayAdapter(j, i1, p);
        o = new com.helpshift.b.b(j, i1, q);
        a(n);
        setHasOptionsMenu(true);
        A = Locale.getDefault().getLanguage();
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        TraceMachine.exitMethod();
        return layoutinflater;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "HSFaqsFragment#onCreateView", null);
          goto _L1
    }

    public void onResume()
    {
        super.onResume();
        if (com.helpshift.a.a(com.helpshift.a.a.a))
        {
            h h1 = j;
            boolean flag;
            if (!x)
            {
                flag = true;
            } else
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
        super.onViewCreated(view, bundle);
        r = f_();
        r.setOnTouchListener(new android.view.View.OnTouchListener() {

            final HSFaqsFragment a;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                if (com.helpshift.HSFaqsFragment.a(a) != null)
                {
                    com.helpshift.HSFaqsFragment.b(a).c(com.helpshift.HSFaqsFragment.a(a));
                }
                return false;
            }

            
            {
                a = HSFaqsFragment.this;
                super();
            }
        });
        if (z)
        {
            view = (Button)s.findViewById(b.c.n);
            com.helpshift.i.w.c(j, view.getCompoundDrawables()[0]);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final HSFaqsFragment a;

                public void onClick(View view1)
                {
                    HSFaqsFragment.c(a);
                    view1 = new Intent(HSFaqsFragment.d(a), com/helpshift/HSConversation);
                    view1.putExtra("message", com.helpshift.HSFaqsFragment.e(a));
                    com.helpshift.HSFaqsFragment.b(a).a(com.helpshift.HSFaqsFragment.a(a));
                    view1.putExtra("showInFullScreen", com.helpshift.i.e.a(HSFaqsFragment.d(a)));
                    view1.putExtra("showConvOnReportIssue", com.helpshift.HSFaqsFragment.f(a).getBoolean("showConvOnReportIssue"));
                    view1.putExtra("chatLaunchSource", "support");
                    view1.putExtra("decomp", com.helpshift.HSFaqsFragment.g(a));
                    a.getActivity().startActivityForResult(view1, 1);
                }

            
            {
                a = HSFaqsFragment.this;
                super();
            }
            });
        }
        try
        {
            a(false);
            m.a(C, D);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            com.helpshift.x.b("HelpShiftDebug", view.toString(), view);
        }
        view = new ColorDrawable(com.helpshift.i.w.a(j, b.a.p));
        r.setDivider(view);
        r.setDividerHeight(1);
    }
}
