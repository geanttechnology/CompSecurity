// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.app.ak;
import android.support.v4.app.g;
import android.support.v4.app.q;
import android.support.v7.cj;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            f, g, ActionBar

public class e extends g
    implements android.support.v4.app.ak.a, a.b, f
{

    private android.support.v7.app.g n;

    public e()
    {
    }

    public Intent a()
    {
        return q.a(this);
    }

    public cj a(android.support.v7.cj.a a1)
    {
        return null;
    }

    public void a(ak ak1)
    {
        ak1.a(this);
    }

    public void a(cj cj)
    {
    }

    public void a(Toolbar toolbar)
    {
        j().a(toolbar);
    }

    public boolean a(Intent intent)
    {
        return q.a(this, intent);
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        j().b(view, layoutparams);
    }

    public a.a b()
    {
        return j().g();
    }

    public void b(Intent intent)
    {
        q.b(this, intent);
    }

    public void b(ak ak1)
    {
    }

    public void b(cj cj)
    {
    }

    public void d()
    {
        j().e();
    }

    public ActionBar g()
    {
        return j().a();
    }

    public MenuInflater getMenuInflater()
    {
        return j().b();
    }

    public boolean h()
    {
        Object obj = a();
        if (obj != null)
        {
            if (a(((Intent) (obj))))
            {
                obj = ak.a(this);
                a(((ak) (obj)));
                b(((ak) (obj)));
                ((ak) (obj)).a();
                try
                {
                    android.support.v4.app.a.a(this);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    finish();
                }
            } else
            {
                b(((Intent) (obj)));
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void i()
    {
    }

    public void invalidateOptionsMenu()
    {
        j().e();
    }

    public android.support.v7.app.g j()
    {
        if (n == null)
        {
            n = android.support.v7.app.g.a(this, this);
        }
        return n;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        j().a(configuration);
    }

    public void onContentChanged()
    {
        i();
    }

    protected void onCreate(Bundle bundle)
    {
        j().h();
        super.onCreate(bundle);
        j().a(bundle);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        j().f();
    }

    public final boolean onMenuItemSelected(int k, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(k, menuitem))
        {
            return true;
        }
        ActionBar actionbar = g();
        if (menuitem.getItemId() == 0x102002c && actionbar != null && (actionbar.b() & 4) != 0)
        {
            return h();
        } else
        {
            return false;
        }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        j().b(bundle);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        j().d();
    }

    protected void onStop()
    {
        super.onStop();
        j().c();
    }

    protected void onTitleChanged(CharSequence charsequence, int k)
    {
        super.onTitleChanged(charsequence, k);
        j().a(charsequence);
    }

    public void setContentView(int k)
    {
        j().a(k);
    }

    public void setContentView(View view)
    {
        j().a(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        j().a(view, layoutparams);
    }
}
