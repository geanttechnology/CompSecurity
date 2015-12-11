// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.app.aj;
import android.support.v4.app.p;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            g, h, a

public class f extends android.support.v4.app.f
    implements android.support.v4.app.aj.a, b.b, g
{

    private h mDelegate;

    public f()
    {
    }

    public Intent a()
    {
        return p.a(this);
    }

    public android.support.v7.d.a a(android.support.v7.d.a.a a1)
    {
        return null;
    }

    public void a(aj aj1)
    {
        aj1.a(this);
    }

    public void a(android.support.v7.d.a a1)
    {
    }

    public void a(Toolbar toolbar)
    {
        j().a(toolbar);
    }

    public boolean a(Intent intent)
    {
        return p.a(this, intent);
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        j().b(view, layoutparams);
    }

    public b.a b()
    {
        return j().g();
    }

    public void b(Intent intent)
    {
        p.b(this, intent);
    }

    public void b(aj aj1)
    {
    }

    public void b(android.support.v7.d.a a1)
    {
    }

    public void d()
    {
        j().e();
    }

    public android.support.v7.app.a g()
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
                obj = aj.a(this);
                a(((aj) (obj)));
                b(((aj) (obj)));
                ((aj) (obj)).a();
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

    public h j()
    {
        if (mDelegate == null)
        {
            mDelegate = android.support.v7.app.h.a(this, this);
        }
        return mDelegate;
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
        android.support.v7.app.a a1 = g();
        if (menuitem.getItemId() == 0x102002c && a1 != null && (a1.a() & 4) != 0)
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
