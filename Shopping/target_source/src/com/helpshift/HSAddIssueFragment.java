// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.helpshift.f.c;
import com.helpshift.g.b.a;
import com.helpshift.i.b;
import com.helpshift.i.e;
import com.helpshift.i.g;
import com.helpshift.i.l;
import com.helpshift.i.o;
import com.helpshift.i.p;
import com.helpshift.i.u;
import com.helpshift.i.w;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            h, HSConversation, ScreenshotPreviewActivity, s, 
//            l, a, SearchResultActivity, t, 
//            j, v, o, k

public class HSAddIssueFragment extends Fragment
    implements TraceFieldInterface
{

    private boolean A;
    private t.c B;
    private boolean C;
    private Handler D;
    private Handler E;
    private Handler F;
    private Handler G;
    com.helpshift.app.b a;
    public Handler b;
    public Handler c;
    private h d;
    private Bundle e;
    private s f;
    private com.helpshift.l g;
    private k h;
    private Boolean i;
    private Boolean j;
    private int k;
    private MenuItem l;
    private MenuItem m;
    private TextView n;
    private EditText o;
    private EditText p;
    private String q;
    private String r;
    private Boolean s;
    private ImageView t;
    private String u;
    private String v;
    private ImageButton w;
    private com.helpshift.k.a x;
    private boolean y;
    private boolean z;

    public HSAddIssueFragment()
    {
        k = 1;
        u = null;
        y = false;
        z = false;
        C = false;
        D = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                com.helpshift.i.g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, com.helpshift.HSAddIssueFragment.a(a));
                com.helpshift.HSAddIssueFragment.a(a, false);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
        b = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                message = (JSONObject)((HashMap)message.obj).get("response");
                com.helpshift.HSAddIssueFragment.a(a, message.getString("id"));
                JSONArray jsonarray = new JSONArray();
                jsonarray.put(message);
                com.helpshift.HSAddIssueFragment.c(a).b(message.getString("created_at"), com.helpshift.HSAddIssueFragment.b(a).B());
                com.helpshift.HSAddIssueFragment.c(a).a(jsonarray, com.helpshift.HSAddIssueFragment.b(a).B());
                com.helpshift.HSAddIssueFragment.b(a).h(HSAddIssueFragment.d(a));
                com.helpshift.HSAddIssueFragment.b(a).i(com.helpshift.HSAddIssueFragment.e(a));
                com.helpshift.HSAddIssueFragment.c(a).h("", com.helpshift.HSAddIssueFragment.b(a).B());
                com.helpshift.HSAddIssueFragment.c(a).i("", com.helpshift.HSAddIssueFragment.b(a).A());
                message = com.helpshift.HSAddIssueFragment.f(a).getText().toString().trim();
                com.helpshift.HSAddIssueFragment.f(a).setText("");
                com.helpshift.o.a("p");
                if (TextUtils.isEmpty(com.helpshift.HSAddIssueFragment.g(a)))
                {
                    break MISSING_BLOCK_LABEL_367;
                }
                com.helpshift.HSAddIssueFragment.c(a).n(HSAddIssueFragment.h(a));
                com.helpshift.HSAddIssueFragment.a(a, com.helpshift.i.b.a(com.helpshift.HSAddIssueFragment.c(a), HSAddIssueFragment.h(a), com.helpshift.HSAddIssueFragment.g(a), true));
                com.helpshift.HSAddIssueFragment.l(a).b(HSAddIssueFragment.i(a), HSAddIssueFragment.j(a), com.helpshift.HSAddIssueFragment.b(a).B(), HSAddIssueFragment.h(a), "", "sc", HSAddIssueFragment.k(a).g, HSAddIssueFragment.k(a).h);
_L2:
                com.helpshift.HSAddIssueFragment.b(a).u();
                if (HSAddIssueFragment.n(a) != null)
                {
                    HSAddIssueFragment.n(a).a(message);
                    return;
                }
                break MISSING_BLOCK_LABEL_389;
                HSAddIssueFragment.m(a);
                if (true) goto _L2; else goto _L1
_L1:
                message;
                Log.d("HelpShiftDebug", message.toString(), message);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
        E = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                com.helpshift.HSAddIssueFragment.o(a);
                HSAddIssueFragment.m(a);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
        F = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                message = (JSONObject)((HashMap)message.obj).get("response");
                try
                {
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("type", "url");
                    jsonobject.put("body", message.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0).getString("url"));
                    jsonobject.put("id", HSAddIssueFragment.h(a));
                    com.helpshift.o.a("m", jsonobject);
                    if (HSAddIssueFragment.n(a) != null)
                    {
                        HSAddIssueFragment.n(a).b("User sent a screenshot");
                    }
                    com.helpshift.i.b.a(a.getActivity(), com.helpshift.HSAddIssueFragment.b(a), com.helpshift.HSAddIssueFragment.g(a), message.getJSONObject("meta").getString("refers"), 0);
                }
                catch (IOException ioexception)
                {
                    Log.d("HelpShiftDebug", "Saving uploaded screenshot", ioexception);
                }
                catch (JSONException jsonexception)
                {
                    Log.d("HelpShiftDebug", "uploadSuccessHandler", jsonexception);
                }
                try
                {
                    message = message.getJSONObject("meta").getString("refers");
                    if (!TextUtils.isEmpty(message))
                    {
                        com.helpshift.h.e.f(message);
                    }
                    com.helpshift.HSAddIssueFragment.b(a).c(com.helpshift.HSAddIssueFragment.p(a), com.helpshift.HSAddIssueFragment.p(a));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", "uploadSuccessHandler", message);
                }
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
        G = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                com.helpshift.f.c.b(HSAddIssueFragment.k(a).g, false);
                com.helpshift.HSAddIssueFragment.o(a);
                HSAddIssueFragment.m(a);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
        c = new Handler() {

            final HSAddIssueFragment a;

            public void handleMessage(Message message)
            {
                try
                {
                    message = (JSONObject)((HashMap)message.obj).get("response");
                    com.helpshift.HSAddIssueFragment.b(a).g(message.get("id").toString());
                    com.helpshift.HSAddIssueFragment.b(a).d(new Handler(this) {

                        final _cls9 a;

                        public void handleMessage(Message message)
                        {
                            try
                            {
                                com.helpshift.HSAddIssueFragment.b(a.a).a(a.a.b, HSAddIssueFragment.q(a.a), HSAddIssueFragment.r(a.a), HSAddIssueFragment.s(a.a));
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Message message)
                            {
                                Log.d("HelpShiftDebug", "Something really foul has happened", message);
                            }
                        }

            
            {
                a = _pcls9;
                super();
            }
                    }, HSAddIssueFragment.q(a));
                    com.helpshift.HSAddIssueFragment.b(a).p();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.d("HelpShiftDebug", message.getMessage(), message);
                }
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        };
    }

    static h a(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.d;
    }

    static com.helpshift.k.a a(HSAddIssueFragment hsaddissuefragment, com.helpshift.k.a a1)
    {
        hsaddissuefragment.x = a1;
        return a1;
    }

    static String a(HSAddIssueFragment hsaddissuefragment, String s1)
    {
        hsaddissuefragment.v = s1;
        return s1;
    }

    private void a()
    {
        Toast toast = Toast.makeText(d, getString(com.helpshift.b.g.g), 0);
        toast.setGravity(16, 0, 0);
        toast.show();
    }

    private void a(View view)
    {
        ((InputMethodManager)d.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    static void a(HSAddIssueFragment hsaddissuefragment, String s1, int i1)
    {
        hsaddissuefragment.a(s1, i1);
    }

    static void a(HSAddIssueFragment hsaddissuefragment, boolean flag)
    {
        hsaddissuefragment.a(flag);
    }

    private void a(String s1, int i1)
    {
        com.helpshift.HSConversation.c(true);
        C = true;
        Intent intent = new Intent(d, com/helpshift/ScreenshotPreviewActivity);
        intent.putExtra("SCREENSHOT", s1);
        intent.putExtra("screenshot_text_type", i1);
        intent.putExtra("showInFullScreen", com.helpshift.i.e.a(d));
        startActivityForResult(intent, 32700);
    }

    private void a(boolean flag)
    {
        d.d(flag);
        boolean flag1;
        if (l != null)
        {
            Object obj = l;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((MenuItem) (obj)).setVisible(flag1);
        }
        if (w != null)
        {
            obj = w;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((ImageButton) (obj)).setEnabled(flag1);
        }
        if (t != null)
        {
            obj = t;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((ImageView) (obj)).setEnabled(flag1);
        }
        if (m != null)
        {
            if (flag || w != null && w.getVisibility() == 0)
            {
                m.setVisible(false);
            } else
            if (!f.L().booleanValue())
            {
                m.setVisible(true);
                return;
            }
        }
    }

    private boolean a(String s1)
    {
        return g.a(s1, com.helpshift.q.a.c).size() > 0;
    }

    static com.helpshift.l b(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.g;
    }

    private void b()
    {
        Intent intent = new Intent();
        intent.putExtra("callFinish", true);
        getActivity().setResult(-1, intent);
        getActivity().finish();
        com.helpshift.i.e.a();
    }

    private void b(String s1)
    {
        if (!TextUtils.isEmpty(s1))
        {
            f.j(s1, g.A());
        }
    }

    static s c(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.f;
    }

    private void c()
    {
        Boolean boolean1 = (Boolean)a.b.get("dia");
        if (j.booleanValue() && !boolean1.booleanValue())
        {
            Intent intent = new Intent(d, com/helpshift/HSConversation);
            intent.putExtra("newIssue", true);
            intent.putExtra("issueId", v);
            intent.putExtra("decomp", i);
            intent.putExtra("showConvOnReportIssue", j);
            intent.putExtra("showInFullScreen", com.helpshift.i.e.a(d));
            intent.putExtra("chatLaunchSource", "support");
            intent.putExtra("showSearchOnNewConversation", h());
            if (isResumed())
            {
                getActivity().startActivityForResult(intent, 1);
            }
        } else
        if (isResumed())
        {
            a();
            b();
            return;
        }
    }

    private void c(String s1)
    {
        android.graphics.Bitmap bitmap = com.helpshift.i.b.a(s1, -1);
        if (bitmap != null)
        {
            t.setImageBitmap(bitmap);
            t.setVisibility(0);
            w.setVisibility(0);
            u = s1;
            if (m != null)
            {
                m.setVisible(false);
            }
            n.measure(0, 0);
            int i1 = n.getMeasuredHeight();
            t.getLayoutParams().height = i1;
            t.getLayoutParams().width = (int)Math.round((double)i1 * 0.66666666666666663D);
            t.requestLayout();
        }
    }

    static String d(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.q;
    }

    private void d()
    {
        t.setVisibility(8);
        w.setVisibility(8);
        u = "";
        f.j("", g.A());
        if (!f.L().booleanValue())
        {
            m.setVisible(true);
        }
    }

    private String e()
    {
        return n.getText().toString().trim();
    }

    static String e(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.r;
    }

    static TextView f(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.n;
    }

    private HashMap f()
    {
        HashMap hashmap = null;
        if (com.helpshift.i.p.a(f))
        {
            HashMap hashmap1 = new HashMap();
            hashmap1.put("name", q);
            hashmap = hashmap1;
            if (r.trim().length() > 0)
            {
                hashmap1.put("email", r);
                hashmap = hashmap1;
            }
        }
        return hashmap;
    }

    static String g(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.u;
    }

    private void g()
    {
        A = true;
        Intent intent = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        com.helpshift.HSConversation.c(true);
        C = true;
        if (intent.resolveActivity(d.getPackageManager()) != null)
        {
            startActivityForResult(intent, 0);
        } else
        {
            Intent intent1 = new Intent("android.intent.action.GET_CONTENT");
            intent1.setType("image/*");
            intent1.putExtra("android.intent.extra.LOCAL_ONLY", true);
            if (intent1.resolveActivity(d.getPackageManager()) != null)
            {
                startActivityForResult(intent1, 0);
                return;
            }
        }
    }

    static String h(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.v;
    }

    private boolean h()
    {
        return f.Q().booleanValue();
    }

    static Handler i(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.F;
    }

    private void i()
    {
        Object obj = new HashMap();
        ((HashMap) (obj)).put("enableContactUs", com.helpshift.t.a.b);
        com.helpshift.a.a(((HashMap) (obj)));
        z = true;
        f.i(e(), g.A());
        obj = new Intent(d, com/helpshift/SearchResultActivity);
        ((Intent) (obj)).putExtra("searchQuery", e());
        ((Intent) (obj)).putExtra("showInFullScreen", com.helpshift.i.e.a(d));
        com.helpshift.HSConversation.c(true);
        startActivityForResult(((Intent) (obj)), 32699);
    }

    static Handler j(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.G;
    }

    private void j()
    {
        try
        {
            a(true);
            g.a(b, D, e(), f());
            return;
        }
        catch (com.helpshift.c.a a1)
        {
            g.a(c, D, q, r, g.A());
        }
    }

    static com.helpshift.k.a k(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.x;
    }

    private boolean k()
    {
        Boolean boolean1 = Boolean.valueOf(true);
        String s1 = n.getText().toString();
        Boolean boolean2 = Boolean.valueOf(com.helpshift.i.p.a(g));
        if (boolean2.booleanValue())
        {
            q = o.getText().toString();
            r = p.getText().toString();
        } else
        {
            q = g.C();
            r = g.D();
        }
        if (s1.trim().length() == 0)
        {
            n.setError(getString(com.helpshift.b.g.a));
            boolean1 = Boolean.valueOf(false);
        } else
        if (com.helpshift.i.l.b(s1))
        {
            n.setError(getString(com.helpshift.b.g.b));
            boolean1 = Boolean.valueOf(false);
        }
        if (boolean2.booleanValue() && q.trim().length() == 0 || com.helpshift.i.l.b(q))
        {
            o.setError(getString(com.helpshift.b.g.c));
            boolean1 = Boolean.valueOf(false);
        }
        if (s.booleanValue() && TextUtils.isEmpty(r) && !com.helpshift.i.l.a(r))
        {
            p.setError(getString(b.g.d));
            boolean2 = Boolean.valueOf(false);
        } else
        {
            boolean2 = boolean1;
            if (!TextUtils.isEmpty(r))
            {
                boolean2 = boolean1;
                if (!com.helpshift.i.l.a(r))
                {
                    p.setError(getString(b.g.d));
                    boolean2 = Boolean.valueOf(false);
                }
            }
        }
        return boolean2.booleanValue();
    }

    static k l(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.h;
    }

    static void m(HSAddIssueFragment hsaddissuefragment)
    {
        hsaddissuefragment.c();
    }

    static t.c n(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.B;
    }

    static void o(HSAddIssueFragment hsaddissuefragment)
    {
        hsaddissuefragment.d();
    }

    static Handler p(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.E;
    }

    static Handler q(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.D;
    }

    static String r(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.e();
    }

    static HashMap s(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.f();
    }

    static EditText t(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.o;
    }

    static EditText u(HSAddIssueFragment hsaddissuefragment)
    {
        return hsaddissuefragment.p;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1)
        {
            if (i1 == 0)
            {
                if (com.helpshift.i.b.b(getActivity(), intent))
                {
                    intent = com.helpshift.i.b.a(getActivity(), intent);
                    if (!TextUtils.isEmpty(intent))
                    {
                        a(intent, 1);
                    }
                }
            } else
            if (i1 == 32699)
            {
                com.helpshift.HSConversation.c(false);
                intent = intent.getStringExtra("action");
                if (!TextUtils.isEmpty(intent))
                {
                    if (intent.equals("startConversation"))
                    {
                        y = true;
                        j();
                        return;
                    }
                    if (intent.equals("ticketAvoided"))
                    {
                        getActivity().finish();
                        return;
                    }
                }
            } else
            {
                com.helpshift.HSConversation.c(false);
                intent = intent.getExtras().getString("SCREENSHOT");
                if (!TextUtils.isEmpty(intent))
                {
                    b(intent);
                    c(intent);
                    return;
                } else
                {
                    d();
                    return;
                }
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(com.helpshift.b.e.b, menu);
        a.a(menu, menuinflater);
        l = menu.findItem(b.c.d);
        com.helpshift.i.w.a(d, l.getIcon());
        m = menu.findItem(com.helpshift.b.c.e);
        com.helpshift.i.w.a(d, m.getIcon());
        if (android.os.Build.VERSION.SDK_INT < 11 && f.L().booleanValue())
        {
            menu.removeItem(com.helpshift.b.c.e);
        }
        a(false);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "HSAddIssueFragment#onCreateView", null);
_L1:
        d = (h)getActivity();
        e = getArguments();
        a = d.i();
        if (Boolean.valueOf(e.getBoolean("showInFullScreen")).booleanValue())
        {
            d.getWindow().setFlags(1024, 1024);
        }
        g = new com.helpshift.l(d);
        f = g.a;
        h = g.b;
        B = com.helpshift.t.a();
        if (h())
        {
            g.a(new Handler() {

                final HSAddIssueFragment a;

                public void handleMessage(Message message)
                {
                    com.helpshift.HSAddIssueFragment.b(a).r();
                    com.helpshift.i.o.b();
                }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
            }, new Handler());
        }
        s = Boolean.valueOf(com.helpshift.i.p.b(f));
        i = Boolean.valueOf(e.getBoolean("decomp", false));
        j = Boolean.valueOf(e.getBoolean("showConvOnReportIssue"));
        if (i.booleanValue())
        {
            com.helpshift.j.a = true;
        }
        z = false;
        setHasOptionsMenu(true);
        layoutinflater = layoutinflater.inflate(com.helpshift.b.d.b, viewgroup, false);
        TraceMachine.exitMethod();
        return layoutinflater;
        bundle;
        TraceMachine.enterMethod(null, "HSAddIssueFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.helpshift.v.a(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1;
label0:
        {
label1:
            {
                i1 = menuitem.getItemId();
                if (i1 != b.c.d)
                {
                    break label0;
                }
                if (k())
                {
                    a(n);
                    if (!h() || !a(e()))
                    {
                        break label1;
                    }
                    i();
                }
                return true;
            }
            j();
            return true;
        }
        if (i1 == 0x102002c)
        {
            getActivity().onBackPressed();
            return true;
        }
        if (i1 == com.helpshift.b.c.e)
        {
            g();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onPause()
    {
        String s1;
        super.onPause();
        a(false);
        s1 = f.P();
        if (!TextUtils.isEmpty(f.f(g.B())) || !TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        f.i(e(), g.A());
_L4:
        b(u);
        f.n("");
        return;
_L2:
        if (!TextUtils.isEmpty(s1) && e.getBoolean("dropMeta"))
        {
            com.helpshift.i.u.a(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        m = menu.findItem(com.helpshift.b.c.e);
        if (m != null && f.L().booleanValue())
        {
            m.setVisible(false);
        }
    }

    public void onResume()
    {
        super.onResume();
        com.helpshift.v.a("issue-filing");
        if (!y)
        {
            com.helpshift.o.a("i");
        }
        String s2 = "";
        String s3 = f.w(g.A());
        String s4 = f.P();
        String s1 = s2;
        if (e != null)
        {
            String s5 = e.getString("message");
            s1 = s2;
            if (s5 != null)
            {
                s1 = s2;
                if (!s5.trim().equals(""))
                {
                    s1 = (new StringBuilder()).append(s5.substring(0, 1).toUpperCase()).append(s5.substring(1)).toString();
                }
            }
        }
        if (!C)
        {
            if (z)
            {
                n.setText(s3);
            } else
            if (!TextUtils.isEmpty(s4))
            {
                n.setText(s4);
            } else
            if (!TextUtils.isEmpty(s1))
            {
                n.setText(s1);
            } else
            {
                n.setText(s3);
            }
            C = false;
        }
        y = false;
        z = false;
        n.requestFocus();
        c(f.y(g.A()));
    }

    public void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        if (!A)
        {
            com.helpshift.j.a(d);
        }
        A = false;
    }

    public void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        if (!A)
        {
            com.helpshift.j.b(d);
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        n = (TextView)view.findViewById(com.helpshift.b.c.f);
        n.addTextChangedListener(new TextWatcher() {

            final HSAddIssueFragment a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                com.helpshift.HSAddIssueFragment.f(a).setError(null);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        });
        o = (EditText)view.findViewById(com.helpshift.b.c.g);
        o.addTextChangedListener(new TextWatcher() {

            final HSAddIssueFragment a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                HSAddIssueFragment.t(a).setError(null);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        });
        p = (EditText)view.findViewById(b.c.h);
        p.addTextChangedListener(new TextWatcher() {

            final HSAddIssueFragment a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
                com.helpshift.HSAddIssueFragment.u(a).setError(null);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        });
        if (s.booleanValue())
        {
            p.setHint(getString(com.helpshift.b.g.e));
        }
        if (!com.helpshift.i.p.a(f))
        {
            o.setText("Anonymous");
        }
        if (!com.helpshift.i.p.a(g))
        {
            o.setVisibility(8);
            p.setVisibility(8);
        } else
        {
            o.setText(g.C());
            p.setText(g.D());
        }
        d.getWindow().setSoftInputMode(4);
        a.a(true);
        a.a(getString(com.helpshift.b.g.f));
        t = (ImageView)view.findViewById(b.c.i);
        t.setOnClickListener(new android.view.View.OnClickListener() {

            final HSAddIssueFragment a;

            public void onClick(View view1)
            {
                com.helpshift.HSAddIssueFragment.a(a, com.helpshift.HSAddIssueFragment.g(a), 2);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        });
        w = (ImageButton)view.findViewById(0x102001a);
        w.setOnClickListener(new android.view.View.OnClickListener() {

            final HSAddIssueFragment a;

            public void onClick(View view1)
            {
                com.helpshift.HSAddIssueFragment.o(a);
            }

            
            {
                a = HSAddIssueFragment.this;
                super();
            }
        });
    }
}
