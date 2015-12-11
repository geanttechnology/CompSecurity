// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.aqo;
import android.support.v7.ec;
import android.support.v7.ip;
import android.support.v7.iv;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.facebook.d;
import com.facebook.login.f;
import com.parse.ParseException;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            l, g, f, h, 
//            m, i, LoginActivity, SignUpActivity

public class MainSignUpActivity extends l
    implements g
{

    private d n;

    public MainSignUpActivity()
    {
    }

    public void a(int j)
    {
        super.a(j);
    }

    public void a(ParseException parseexception)
    {
label0:
        {
            if (parseexception != null)
            {
                iv.a(r);
                if (parseexception.getCode() != 203 && parseexception.getCode() != 202)
                {
                    break label0;
                }
                l();
            }
            return;
        }
        m();
    }

    void a(Boolean boolean1)
    {
        iv.a(r);
        if (boolean1 != null && boolean1.booleanValue())
        {
            return;
        } else
        {
            m();
            return;
        }
    }

    void k()
    {
        Bundle bundle;
        if (getIntent() == null)
        {
            bundle = null;
        } else
        {
            bundle = getIntent().getExtras();
        }
        o = new com.abtnprojects.ambatana.ui.signup.f(this, p, n, new h(bundle), t, s, u, this);
        o.b(this);
    }

    public void l()
    {
        b(0x7f0900ce);
    }

    public void m()
    {
        b(0x7f09011a);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040052);
        ButterKnife.bind(this);
        p();
        n = com.facebook.d.a.a();
        k();
    }

    public void onEvent(ec ec1)
    {
        a(ec1.a);
    }

    void onFacebookButtonClicked()
    {
        f.a().a(this, ip.a);
    }

    protected void onHelpPressed()
    {
        p.d();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            aqo.a("Close pressed", new Object[0]);
            o.a(this);
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onPause()
    {
        super.onPause();
        iv.b(w);
    }

    protected void onResume()
    {
        super.onResume();
        iv.a(this);
    }

    protected void onStart()
    {
        super.onStart();
        iv.a(this);
    }

    protected void p()
    {
        super.p();
        v.setNavigationIcon(0x7f0200cc);
        g().b(false);
    }

    protected void startLoginActivity()
    {
        Bundle bundle;
        if (getIntent() == null)
        {
            bundle = null;
        } else
        {
            bundle = getIntent().getExtras();
        }
        o.a(com/abtnprojects/ambatana/ui/signup/LoginActivity, new h(bundle));
    }

    protected void startSignUpActivity()
    {
        Bundle bundle;
        if (getIntent() == null)
        {
            bundle = null;
        } else
        {
            bundle = getIntent().getExtras();
        }
        o.a(com/abtnprojects/ambatana/ui/signup/SignUpActivity, new h(bundle));
    }
}
