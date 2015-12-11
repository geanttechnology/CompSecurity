// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import net.hockeyapp.android.c.a;
import net.hockeyapp.android.c.d;
import net.hockeyapp.android.d.g;
import net.hockeyapp.android.d.h;
import net.hockeyapp.android.e.e;
import net.hockeyapp.android.e.f;
import net.hockeyapp.android.f.b;

// Referenced classes of package net.hockeyapp.android:
//            n, i, j, l, 
//            o

public class FeedbackActivity extends Activity
    implements android.view.View.OnClickListener
{

    private final int a = 0;
    private Context b;
    private TextView c;
    private EditText d;
    private EditText e;
    private EditText f;
    private EditText g;
    private Button h;
    private Button i;
    private Button j;
    private ScrollView k;
    private LinearLayout l;
    private ListView m;
    private h n;
    private Handler o;
    private g p;
    private Handler q;
    private String r;
    private a s;
    private net.hockeyapp.android.a.a t;
    private ArrayList u;
    private boolean v;
    private String w;

    public FeedbackActivity()
    {
    }

    static ArrayList a(FeedbackActivity feedbackactivity, ArrayList arraylist)
    {
        feedbackactivity.u = arraylist;
        return arraylist;
    }

    static net.hockeyapp.android.a.a a(FeedbackActivity feedbackactivity, net.hockeyapp.android.a.a a1)
    {
        feedbackactivity.t = a1;
        return a1;
    }

    static a a(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.s;
    }

    static a a(FeedbackActivity feedbackactivity, a a1)
    {
        feedbackactivity.s = a1;
        return a1;
    }

    private void a()
    {
        w = f.a.a(this);
        if (w == null)
        {
            a(false);
            return;
        } else
        {
            a(true);
            a(r, null, null, null, null, w, o, true);
            return;
        }
    }

    private void a(String s1, String s2, String s3, String s4, String s5, String s6, Handler handler, 
            boolean flag)
    {
        n = new h(b, s1, s2, s3, s4, s5, s6, handler, flag);
        n.execute(new Void[0]);
    }

    static void a(FeedbackActivity feedbackactivity, String s1)
    {
        feedbackactivity.p = new g(feedbackactivity, s1, feedbackactivity.q);
        feedbackactivity.p.execute(new Void[0]);
    }

    static void a(FeedbackActivity feedbackactivity, d d1)
    {
        feedbackactivity.runOnUiThread(new n(feedbackactivity, d1));
    }

    static void b(FeedbackActivity feedbackactivity)
    {
        feedbackactivity.runOnUiThread(new i(feedbackactivity));
    }

    static Context c(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.b;
    }

    static boolean d(FeedbackActivity feedbackactivity)
    {
        feedbackactivity.v = false;
        return false;
    }

    static ArrayList e(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.u;
    }

    static TextView f(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.c;
    }

    static net.hockeyapp.android.a.a g(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.t;
    }

    static ListView h(FeedbackActivity feedbackactivity)
    {
        return feedbackactivity.m;
    }

    protected final void a(boolean flag)
    {
        k = (ScrollView)findViewById(0x20017);
        l = (LinearLayout)findViewById(0x20015);
        m = (ListView)findViewById(0x20016);
        if (flag)
        {
            l.setVisibility(0);
            k.setVisibility(8);
            c = (TextView)findViewById(8192);
            i = (Button)findViewById(0x20010);
            i.setOnClickListener(this);
            j = (Button)findViewById(0x20011);
            j.setOnClickListener(this);
            return;
        }
        l.setVisibility(8);
        k.setVisibility(0);
        d = (EditText)findViewById(8194);
        e = (EditText)findViewById(8196);
        f = (EditText)findViewById(8198);
        g = (EditText)findViewById(8200);
        Object obj = f.a;
        Context context = b;
        if (context == null)
        {
            obj = null;
        } else
        {
            obj.a = context.getSharedPreferences("net.hockeyapp.android.prefs_name_email", 0);
            if (((e) (obj)).a == null)
            {
                obj = null;
            } else
            {
                obj = ((e) (obj)).a.getString("net.hockeyapp.android.prefs_key_name_email", null);
            }
        }
        if (obj != null)
        {
            obj = ((String) (obj)).split("\\|");
            if (obj != null && obj.length == 3)
            {
                d.setText(obj[0]);
                e.setText(obj[1]);
                f.setText(obj[2]);
            }
        } else
        {
            d.setText("");
            e.setText("");
            f.setText("");
        }
        g.setText("");
        if (f.a.a(b) != null)
        {
            f.setVisibility(8);
        } else
        {
            f.setVisibility(0);
        }
        h = (Button)findViewById(8201);
        h.setOnClickListener(this);
    }

    public final void b(boolean flag)
    {
        if (h != null)
        {
            h.setEnabled(flag);
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 8201: 
            b(false);
            if (d.getText().toString().trim().length() <= 0 || e.getText().toString().trim().length() <= 0 || f.getText().toString().trim().length() <= 0 || g.getText().toString().trim().length() <= 0)
            {
                s = new a();
                s.a = "Please provide all details";
                showDialog(0);
                b(true);
                return;
            }
            view = f.a;
            Context context = b;
            String s1 = d.getText().toString();
            String s2 = e.getText().toString();
            String s3 = f.getText().toString();
            if (context != null)
            {
                view.a = context.getSharedPreferences("net.hockeyapp.android.prefs_name_email", 0);
                if (((e) (view)).a != null)
                {
                    view.b = ((e) (view)).a.edit();
                    if (s1 == null || s2 == null || s3 == null)
                    {
                        ((e) (view)).b.putString("net.hockeyapp.android.prefs_key_name_email", null);
                    } else
                    {
                        ((e) (view)).b.putString("net.hockeyapp.android.prefs_key_name_email", String.format("%s|%s|%s", new Object[] {
                            s1, s2, s3
                        }));
                    }
                    net.hockeyapp.android.e.e.a(((e) (view)).b);
                }
            }
            a(r, d.getText().toString(), e.getText().toString(), f.getText().toString(), g.getText().toString(), f.a.a(b), o, false);
            return;

        case 131088: 
            a(false);
            v = true;
            return;

        case 131089: 
            a(r, null, null, null, null, f.a.a(b), o, true);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(new b(this));
        setTitle("Feedback");
        b = this;
        v = false;
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            r = bundle.getString("url");
        }
        o = new j(this);
        q = new l(this);
        a();
    }

    protected Dialog onCreateDialog(int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 0: // '\0'
            return (new android.app.AlertDialog.Builder(this)).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(0x1080027).setPositiveButton("OK", new o(this)).create();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (v)
            {
                v = false;
                a();
            } else
            {
                finish();
            }
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPrepareDialog(int i1, Dialog dialog)
    {
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            dialog = (AlertDialog)dialog;
            break;
        }
        if (s != null)
        {
            dialog.setMessage(s.a);
            return;
        } else
        {
            dialog.setMessage("An error has occured");
            return;
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (n != null)
        {
            h h1 = n;
            h1.a = null;
            h1.b = null;
        }
        return n;
    }
}
