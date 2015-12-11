// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ai;
import android.support.v4.app.i;
import android.support.v4.app.q;
import android.support.v7.e.a;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.a:
//            g, h, a

public class f extends i
    implements android.support.v4.app.ai.a, g
{

    private h mDelegate;

    public f()
    {
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().b(view, layoutparams);
    }

    public h getDelegate()
    {
        if (mDelegate == null)
        {
            mDelegate = android.support.v7.a.h.a(this, getWindow(), this);
        }
        return mDelegate;
    }

    public c.a getDrawerToggleDelegate()
    {
        return getDelegate().h();
    }

    public MenuInflater getMenuInflater()
    {
        return getDelegate().b();
    }

    public android.support.v7.a.a getSupportActionBar()
    {
        return getDelegate().a();
    }

    public Intent getSupportParentActivityIntent()
    {
        return q.b(this);
    }

    public void invalidateOptionsMenu()
    {
        getDelegate().f();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        getDelegate().a(configuration);
    }

    public void onContentChanged()
    {
        onSupportContentChanged();
    }

    public void onCreate(Bundle bundle)
    {
        getDelegate().i();
        super.onCreate(bundle);
        getDelegate().a(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(ai ai1)
    {
        Intent intent = null;
        if (this instanceof android.support.v4.app.ai.a)
        {
            intent = ((android.support.v4.app.ai.a)this).getSupportParentActivityIntent();
        }
        if (intent == null)
        {
            intent = q.b(this);
        }
        if (intent != null)
        {
            android.content.ComponentName componentname1 = intent.getComponent();
            android.content.ComponentName componentname = componentname1;
            if (componentname1 == null)
            {
                componentname = intent.resolveActivity(ai1.b.getPackageManager());
            }
            ai1.a(componentname);
            ai1.a.add(intent);
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        getDelegate().g();
    }

    public final boolean onMenuItemSelected(int j, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(j, menuitem))
        {
            return true;
        }
        android.support.v7.a.a a1 = getSupportActionBar();
        if (menuitem.getItemId() == 0x102002c && a1 != null && (a1.a() & 4) != 0)
        {
            return onSupportNavigateUp();
        } else
        {
            return false;
        }
    }

    public void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        getDelegate().c();
    }

    public void onPostResume()
    {
        super.onPostResume();
        getDelegate().e();
    }

    public void onPrepareSupportNavigateUpTaskStack(ai ai1)
    {
    }

    public void onStop()
    {
        super.onStop();
        getDelegate().d();
    }

    public void onSupportActionModeFinished(a a1)
    {
    }

    public void onSupportActionModeStarted(a a1)
    {
    }

    public void onSupportContentChanged()
    {
    }

    public boolean onSupportNavigateUp()
    {
        Object obj;
        boolean flag;
        flag = false;
        obj = getSupportParentActivityIntent();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!supportShouldUpRecreateTask(((Intent) (obj)))) goto _L4; else goto _L3
_L3:
        Intent aintent[];
        Context context;
        int j;
        obj = ai.a(this);
        onCreateSupportNavigateUpTaskStack(((ai) (obj)));
        onPrepareSupportNavigateUpTaskStack(((ai) (obj)));
        if (((ai) (obj)).a.isEmpty())
        {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        aintent = (Intent[])((ai) (obj)).a.toArray(new Intent[((ai) (obj)).a.size()]);
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        context = ((ai) (obj)).b;
        j = android.os.Build.VERSION.SDK_INT;
        if (j < 16) goto _L6; else goto _L5
_L5:
        context.startActivities(aintent, null);
        flag = true;
_L11:
        if (!flag)
        {
            aintent = new Intent(aintent[aintent.length - 1]);
            aintent.addFlags(0x10000000);
            ((ai) (obj)).b.startActivity(aintent);
        }
        if (android.os.Build.VERSION.SDK_INT < 16) goto _L8; else goto _L7
_L7:
        finishAffinity();
_L9:
        return true;
_L6:
        if (j >= 11)
        {
            context.startActivities(aintent);
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        try
        {
            finish();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            finish();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        supportNavigateUpTo(((Intent) (obj)));
        if (true) goto _L9; else goto _L2
_L2:
        return false;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void onTitleChanged(CharSequence charsequence, int j)
    {
        super.onTitleChanged(charsequence, j);
        getDelegate().a(charsequence);
    }

    public a onWindowStartingSupportActionMode(android.support.v7.e.a.a a1)
    {
        return null;
    }

    public void setContentView(int j)
    {
        getDelegate().a(j);
    }

    public void setContentView(View view)
    {
        getDelegate().a(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().a(view, layoutparams);
    }

    public void setSupportActionBar(Toolbar toolbar)
    {
        getDelegate().a(toolbar);
    }

    public void setSupportProgress(int j)
    {
    }

    public void setSupportProgressBarIndeterminate(boolean flag)
    {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean flag)
    {
    }

    public void setSupportProgressBarVisibility(boolean flag)
    {
    }

    public a startSupportActionMode(android.support.v7.e.a.a a1)
    {
        return getDelegate().a(a1);
    }

    public void supportInvalidateOptionsMenu()
    {
        getDelegate().f();
    }

    public void supportNavigateUpTo(Intent intent)
    {
        q.b(this, intent);
    }

    public boolean supportRequestWindowFeature(int j)
    {
        return getDelegate().b(j);
    }

    public boolean supportShouldUpRecreateTask(Intent intent)
    {
        return q.a(this, intent);
    }
}
