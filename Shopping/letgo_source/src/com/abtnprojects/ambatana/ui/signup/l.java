// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dw;
import android.support.v7.ef;
import android.support.v7.eg;
import android.support.v7.en;
import android.support.v7.gh;
import android.support.v7.gs;
import android.support.v7.id;
import android.support.v7.iu;
import android.support.v7.iv;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.Toast;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.ui.widgets.NotifyScrollView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            a, m, i

public abstract class l extends e
{

    private ProgressDialog n;
    m o;
    i p;
    protected AlertDialog q;
    ProgressDialog r;
    du s;
    id t;
    protected gs u;
    Toolbar v;
    protected Object w;

    public l()
    {
        w = new Object() {

            final l a;

            public void onEvent(ef ef)
            {
                iv.a(a.r);
            }

            public void onEvent(eg eg)
            {
                a.a(3);
            }

            public void onEvent(en en1)
            {
                aqo.a("ShowLoadingDialogEvent", new Object[0]);
                a.a(en1.a);
            }

            
            {
                a = l.this;
                super();
            }
        };
    }

    static void a(l l1)
    {
        l1.m();
    }

    static void b(l l1)
    {
        l1.l();
    }

    protected static boolean c(String s1)
    {
        return !TextUtils.isEmpty(s1) && s1.length() >= 4;
    }

    private String d(int j)
    {
        switch (j)
        {
        default:
            return null;

        case 1: // '\001'
            return getString(0x7f0900cb);

        case 0: // '\0'
            return getString(0x7f0900af);

        case 2: // '\002'
            return getString(0x7f0901af);

        case 3: // '\003'
            return getString(0x7f0900cc);
        }
    }

    protected static boolean d(String s1)
    {
        return !TextUtils.isEmpty(s1) && s1.length() >= 2;
    }

    protected static boolean e(String s1)
    {
        return !TextUtils.isEmpty(s1) && Patterns.EMAIL_ADDRESS.matcher(s1).matches();
    }

    private void l()
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            v.setBackgroundDrawable(getResources().getDrawable(0x7f02003c));
            return;
        } else
        {
            v.setBackgroundResource(0x7f02003c);
            return;
        }
    }

    private void m()
    {
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            v.setBackgroundDrawable(getResources().getDrawable(0x7f02003e));
            return;
        } else
        {
            v.setBackgroundResource(0x7f02003e);
            return;
        }
    }

    void a(int j)
    {
        if (!isFinishing())
        {
            String s1 = d(j);
            aqo.b("message : %s , type : %d", new Object[] {
                s1, Integer.valueOf(j)
            });
            if (r == null || !r.isShowing())
            {
                r = new ProgressDialog(this);
                r.setIndeterminate(true);
                r.setProgress(0);
                r.setCancelable(false);
                r.show();
            }
            r.setMessage(s1);
        }
    }

    protected void a(AutoCompleteTextView autocompletetextview)
    {
        autocompletetextview.setAdapter(new ArrayAdapter(this, 0x1090003, o.a(new a(getApplicationContext()))));
    }

    public void a(String s1, String s2)
    {
        if (isFinishing())
        {
            return;
        } else
        {
            q = (new android.app.AlertDialog.Builder(this)).create();
            q.setTitle(s1);
            q.setMessage(s2);
            q.setIcon(0x7f0200ba);
            q.setButton(-1, getString(0x7f090060), new android.content.DialogInterface.OnClickListener() {

                final l a;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                }

            
            {
                a = l.this;
                super();
            }
            });
            q.show();
            return;
        }
    }

    protected void b(int j)
    {
        Toast.makeText(getApplicationContext(), j, 1).show();
    }

    protected void c(int j)
    {
        n = new ProgressDialog(this);
        n.setTitle(getString(j));
        n.setIndeterminate(false);
        n.setCancelable(false);
        n.show();
    }

    abstract void k();

    public void onActivityResult(int j, int i1, Intent intent)
    {
        super.onActivityResult(j, i1, intent);
        o.a(j, i1, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getIntent().getExtras();
        bundle = "";
        if (bundle1 != null)
        {
            bundle = bundle1.getString("login_type");
        }
        u = new gs(new gh(), bundle, new iu());
        t = new id();
        s = new dw(this, new AddressMapper());
        p = new i(this);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    protected void onDestroy()
    {
        iv.a(r);
        iv.a(n);
        super.onDestroy();
        o.c();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        super.onPause();
        iv.b(w);
        o.d(this);
    }

    protected void onResume()
    {
        super.onResume();
        iv.a(w);
        o.c(this);
    }

    protected void onStart()
    {
        super.onStart();
        iv.a(w);
        o.a();
    }

    protected void p()
    {
        v = (Toolbar)findViewById(0x7f100134);
        a(v);
    }

    protected void r()
    {
        ((NotifyScrollView)findViewById(0x7f10005c)).setListener(new com.abtnprojects.ambatana.ui.widgets.NotifyScrollView.a() {

            final l a;

            public void a(ScrollView scrollview, int j, int i1, int j1, int k1)
            {
                if (i1 > 0)
                {
                    l.a(a);
                    return;
                } else
                {
                    l.b(a);
                    return;
                }
            }

            
            {
                a = l.this;
                super();
            }
        });
    }

    public void s()
    {
        iv.a(n);
    }
}
