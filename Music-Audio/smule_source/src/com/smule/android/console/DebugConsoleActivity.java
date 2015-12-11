// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.smule.android.f;
import com.smule.android.f.h;
import com.smule.android.g;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.console:
//            p, b, h, a, 
//            c, i, ConsoleScrollView, m, 
//            r, l

public class DebugConsoleActivity extends Activity
    implements p
{

    private ConsoleScrollView a;
    private i b;
    private com.smule.android.console.h c;
    private Observer d;
    private android.view.View.OnClickListener e;
    private android.view.View.OnKeyListener f;
    private Runnable g;
    private Runnable h;
    private Handler i;

    public DebugConsoleActivity()
    {
        d = new Observer() {

            final DebugConsoleActivity a;

            public void update(Observable observable, Object obj)
            {
                if (obj != null)
                {
                    observable = (Runnable)obj;
                    a.runOnUiThread(new Runnable(this, observable) {

                        final Runnable a;
                        final _cls1 b;

                        public void run()
                        {
                            (new Handler()).postDelayed(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    a.a.run();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            }, 1000L);
                        }

            
            {
                b = _pcls1;
                a = runnable;
                super();
            }
                    });
                }
                a.finish();
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final DebugConsoleActivity a;

            public void onClick(View view)
            {
                DebugConsoleActivity.a(a);
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
        f = new android.view.View.OnKeyListener() {

            final DebugConsoleActivity a;

            public boolean onKey(View view, int j, KeyEvent keyevent)
            {
                if (j == 66 && keyevent.getAction() == 1)
                {
                    DebugConsoleActivity.a(a);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
        g = new Runnable() {

            final DebugConsoleActivity a;

            public void run()
            {
                if (DebugConsoleActivity.b(a).getViewableHeight() > DebugConsoleActivity.c(a).getHeight())
                {
                    DebugConsoleActivity.c(a).scrollTo(0, DebugConsoleActivity.b(a).getHeight());
                }
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
        h = new Runnable() {

            final DebugConsoleActivity a;

            public void run()
            {
                DebugConsoleActivity.c(a).scrollTo(0, 0);
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
        i = new Handler() {

            final DebugConsoleActivity a;

            public void handleMessage(Message message)
            {
                if (message.what == m.a.ordinal())
                {
                    a.a((String)message.obj);
                } else
                {
                    if (message.what == m.b.ordinal())
                    {
                        DebugConsoleActivity.d(a);
                        return;
                    }
                    if (message.what == m.c.ordinal())
                    {
                        r.a(a.getWindowManager().getDefaultDisplay(), a);
                        return;
                    }
                    if (message.what == m.e.ordinal())
                    {
                        int j = DebugConsoleActivity.b(a).getFontSize();
                        a.b((new StringBuilder()).append(com.smule.android.console.a.a(com.smule.android.h.current_fontsize)).append(": ").append(l.a(j).name()).append(" (").append(j).append(")").toString());
                        return;
                    }
                    if (message.what == m.d.ordinal())
                    {
                        DebugConsoleActivity.a(a, ((Integer)message.obj).intValue());
                        return;
                    }
                    if (message.what == com.smule.android.console.m.f.ordinal())
                    {
                        a.finish();
                        return;
                    }
                }
            }

            
            {
                a = DebugConsoleActivity.this;
                super();
            }
        };
    }

    private void a()
    {
        EditText edittext;
        String s;
        b b1;
        edittext = (EditText)findViewById(f.inputBox);
        s = edittext.getText().toString().trim();
        b1 = com.smule.android.console.b.b(s);
        if (b1 == null) goto _L2; else goto _L1
_L1:
        c.a(b1);
_L4:
        edittext.setText("");
        return;
_L2:
        boolean flag = false;
        if (s.startsWith("!"))
        {
            flag = c.a(com.smule.android.console.a.a(s.substring(1)));
        }
        if (!flag)
        {
            c.a(new b(c.a, s, null));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(int j)
    {
        c();
        b.setFontSize(j);
    }

    static void a(DebugConsoleActivity debugconsoleactivity)
    {
        debugconsoleactivity.a();
    }

    static void a(DebugConsoleActivity debugconsoleactivity, int j)
    {
        debugconsoleactivity.a(j);
    }

    static i b(DebugConsoleActivity debugconsoleactivity)
    {
        return debugconsoleactivity.b;
    }

    private void b()
    {
        getApplicationInfo();
        Object obj = getWindowManager().getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Display) (obj)).getMetrics(displaymetrics);
        obj = (LinearLayout)findViewById(f.verticalLayout);
        b = new i(this, displaymetrics.heightPixels);
        ((LinearLayout) (obj)).addView(b);
        a = (ConsoleScrollView)findViewById(f.consoleScrollView);
        a.setScrollViewListener(b);
        ((ImageButton)findViewById(f.inputOKButton)).setOnClickListener(e);
        ((EditText)findViewById(f.inputBox)).setOnKeyListener(f);
    }

    static ConsoleScrollView c(DebugConsoleActivity debugconsoleactivity)
    {
        return debugconsoleactivity.a;
    }

    private void c()
    {
        b.a();
        a.post(h);
    }

    static void d(DebugConsoleActivity debugconsoleactivity)
    {
        debugconsoleactivity.c();
    }

    public void a(String s)
    {
        b.a(s);
        a.post(g);
    }

    public void b(String s)
    {
        b.a(s);
        b.a("\n");
        a.post(g);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(g.debug_console);
        com.smule.android.console.a.a(getApplication());
        b();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        c.a(com.smule.android.console.b.b(c.b.name()));
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j != 4);
        return super.onKeyDown(j, keyevent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        com.smule.android.f.h.a().b("NOTIFICATION_CLOSE_CONSOLE", d);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        c = new com.smule.android.console.h(i);
        com.smule.android.f.h.a().a("NOTIFICATION_CLOSE_CONSOLE", d);
    }
}
