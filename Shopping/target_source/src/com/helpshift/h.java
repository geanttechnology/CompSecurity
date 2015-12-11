// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.helpshift.app.a;
import com.helpshift.i.e;
import com.helpshift.i.s;
import com.helpshift.i.w;
import com.helpshift.j.c;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, s, x, HSConversation, 
//            v, HSQuestion, a, j

class h extends a
{

    private final int a = 3;
    private Bundle b;
    private boolean c;
    private boolean d;
    private MenuItem e;
    private TextView f;
    private TextView g;
    private Thread h;
    private Handler i;
    private com.helpshift.s j;
    private l k;
    private Menu l;
    private boolean m;
    private String n;
    private float o;
    private float p;

    h()
    {
        l = null;
    }

    static Handler a(h h1, Handler handler)
    {
        h1.i = handler;
        return handler;
    }

    static l a(h h1)
    {
        return h1.k;
    }

    private void a(Menu menu)
    {
        getMenuInflater().inflate(com.helpshift.b.e.a, menu);
        e = menu.findItem(com.helpshift.b.c.a);
        menu = (LinearLayout)com.helpshift.j.c.a(e);
        if (menu == null)
        {
            return;
        } else
        {
            f = (TextView)menu.findViewById(b.c.b);
            g = (TextView)menu.findViewById(com.helpshift.b.c.c);
            w.a(this, g.getBackground());
            w.b(this, f.getBackground());
            menu.setOnClickListener(new android.view.View.OnClickListener() {

                final h a;

                public void onClick(View view)
                {
                    com.helpshift.h.c(a);
                }

            
            {
                a = h.this;
                super();
            }
            });
            b(k.B());
            return;
        }
    }

    static void a(h h1, String s1)
    {
        h1.b(s1);
    }

    static Handler b(h h1)
    {
        return h1.i;
    }

    private void b(String s1)
    {
label0:
        {
            int i1 = j.d(s1).intValue();
            if (f != null)
            {
                if (i1 <= 0)
                {
                    break label0;
                }
                g.setVisibility(8);
                f.setVisibility(0);
                f.setText((new StringBuilder()).append("").append(i1).toString());
            }
            return;
        }
        g.setVisibility(0);
        f.setVisibility(8);
    }

    static void c(h h1)
    {
        h1.o();
    }

    private void h()
    {
        if (i != null)
        {
            i.getLooper().quit();
        }
    }

    private boolean j()
    {
        if (TextUtils.isEmpty(n))
        {
            n = getResources().getString(z.g.hs__screen_type);
        }
        return !n.equals("phone");
    }

    private void k()
    {
        if (j() && l())
        {
            n();
            m();
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            int i1 = (int)((float)displaymetrics.heightPixels * p);
            int j1 = (int)((float)displaymetrics.widthPixels * o);
            getWindow().setLayout(j1, i1);
        }
    }

    private boolean l()
    {
        Boolean boolean1 = Boolean.valueOf(false);
        boolean flag = j.r().optBoolean("enableDialogUIForTablets");
        boolean1 = Boolean.valueOf(flag);
_L2:
        return boolean1.booleanValue();
        JSONException jsonexception;
        jsonexception;
        x.b("HelpShiftDebug", "isDialogUIForTabletsEnabled : ", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void m()
    {
        TypedValue typedvalue = new TypedValue();
        getResources().getValue(z.b.hs__tablet_dialog_horizontal_scale, typedvalue, true);
        o = typedvalue.getFloat();
        typedvalue = new TypedValue();
        getResources().getValue(z.b.hs__tablet_dialog_vertical_scale, typedvalue, true);
        p = typedvalue.getFloat();
    }

    private void n()
    {
        if (!m)
        {
            requestWindowFeature(8);
            getWindow().setFlags(2, 2);
            android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
            layoutparams.alpha = 1.0F;
            layoutparams.dimAmount = 0.5F;
            getWindow().setAttributes(layoutparams);
            m = true;
        }
    }

    private void o()
    {
        Intent intent = new Intent(this, com/helpshift/HSConversation);
        intent.putExtra("showInFullScreen", com.helpshift.i.e.a(this));
        intent.putExtra("chatLaunchSource", "support");
        if (b != null)
        {
            intent.putExtras(b);
        }
        intent.removeExtra("isRoot");
        startActivityForResult(intent, 1);
    }

    private void p()
    {
        Intent intent = new Intent();
        intent.putExtra("callFinish", true);
        setResult(-1, intent);
        finish();
    }

    protected void b(boolean flag)
    {
        if (e != null)
        {
            e.setVisible(flag);
        } else
        if (flag && l != null)
        {
            a(l);
            return;
        }
    }

    protected void g()
    {
        h();
        if (TextUtils.isEmpty(j.f(k.B())))
        {
            return;
        } else
        {
            h = new Thread(new Runnable() {

                final h a;

                public void run()
                {
                    Looper.prepare();
                    com.helpshift.h.a(a, new Handler(this) {

                        final _cls1 a;

                        public void handleMessage(Message message)
                        {
                            a.a.runOnUiThread(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    com.helpshift.h.a(a.a.a, com.helpshift.h.a(a.a.a).B());
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                    (new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            try
                            {
                                com.helpshift.h.a(a.a).c(h.b(a.a), new Handler());
                            }
                            catch (JSONException jsonexception)
                            {
                                x.b("HelpShiftDebug", "get issues", jsonexception);
                            }
                            h.b(a.a).postDelayed(this, 3000L);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }).run();
                    Looper.loop();
                }

            
            {
                a = h.this;
                super();
            }
            });
            h.start();
            return;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (intent != null)
        {
            boolean flag = intent.getBooleanExtra("callFinish", false);
            if (i1 == 1 && j1 == -1)
            {
                if (this instanceof HSConversation)
                {
                    onBackPressed();
                } else
                if (Boolean.valueOf(flag).booleanValue())
                {
                    p();
                    return;
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        k();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.helpshift.v.a(getApplicationContext());
        k = new l(this);
        j = k.a;
        s.a(this);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            getWindow().addFlags(0x80000000);
        }
        b = getIntent().getExtras();
        if (b != null)
        {
            d = b.getBoolean("showConvOnReportIssue", false);
        }
        k = new l(this);
        j = k.a;
        k();
        if (this instanceof HSQuestion)
        {
            c = com.helpshift.a.a(a.a.d);
            return;
        } else
        {
            c = com.helpshift.a.a(com.helpshift.a.a.a);
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        l = menu;
        if (c && !(this instanceof HSConversation))
        {
            a(menu);
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        h();
    }

    protected void onResume()
    {
        super.onResume();
        if (this instanceof HSQuestion)
        {
            c = com.helpshift.a.a(a.a.d);
        } else
        {
            c = com.helpshift.a.a(com.helpshift.a.a.a);
        }
        if (!c)
        {
            b(false);
        } else
        if (c && !(this instanceof HSConversation))
        {
            b(true);
            if (!TextUtils.isEmpty(k.B()))
            {
                b(k.B());
                g();
            }
        }
        try
        {
            JSONObject jsonobject = j.q();
            if (jsonobject.length() != 0)
            {
                com.helpshift.g.b.a.b(jsonobject);
            }
            return;
        }
        catch (JSONException jsonexception)
        {
            x.b("HelpShiftDebug", jsonexception.toString(), jsonexception);
        }
    }

    public void onStart()
    {
        super.onStart();
        com.helpshift.j.a(this);
    }

    public void onStop()
    {
        super.onStop();
        com.helpshift.j.b(this);
    }
}
