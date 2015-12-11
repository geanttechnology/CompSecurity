// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.app;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7.internal.app:
//            WindowDecorActionBar

public class mMenu extends ActionMode
    implements j
{

    private final Context mActionModeContext;
    private android.support.v7.view.itleOptional mCallback;
    private WeakReference mCustomView;
    private final i mMenu;
    final WindowDecorActionBar this$0;

    public boolean dispatchOnCreate()
    {
        mMenu.f();
        boolean flag = mCallback.de(this, mMenu);
        mMenu.g();
        return flag;
        Exception exception;
        exception;
        mMenu.g();
        throw exception;
    }

    public void finish()
    {
        if (mActionMode != this)
        {
            return;
        }
        if (!WindowDecorActionBar.access$700(WindowDecorActionBar.access$500(WindowDecorActionBar.this), WindowDecorActionBar.access$600(WindowDecorActionBar.this), false))
        {
            mDeferredDestroyActionMode = this;
            mDeferredModeDestroyCallback = mCallback;
        } else
        {
            mCallback.ode(this);
        }
        mCallback = null;
        animateToMode(false);
        WindowDecorActionBar.access$800(WindowDecorActionBar.this).closeMode();
        WindowDecorActionBar.access$900(WindowDecorActionBar.this).getViewGroup().sendAccessibilityEvent(32);
        WindowDecorActionBar.access$400(WindowDecorActionBar.this).setHideOnContentScrollEnabled(mHideOnContentScroll);
        mActionMode = null;
    }

    public View getCustomView()
    {
        if (mCustomView != null)
        {
            return (View)mCustomView.get();
        } else
        {
            return null;
        }
    }

    public Menu getMenu()
    {
        return mMenu;
    }

    public MenuInflater getMenuInflater()
    {
        return new SupportMenuInflater(mActionModeContext);
    }

    public CharSequence getSubtitle()
    {
        return WindowDecorActionBar.access$800(WindowDecorActionBar.this).getSubtitle();
    }

    public CharSequence getTitle()
    {
        return WindowDecorActionBar.access$800(WindowDecorActionBar.this).getTitle();
    }

    public void invalidate()
    {
        if (mActionMode != this)
        {
            return;
        }
        mMenu.f();
        mCallback.ode(this, mMenu);
        mMenu.g();
        return;
        Exception exception;
        exception;
        mMenu.g();
        throw exception;
    }

    public boolean isTitleOptional()
    {
        return WindowDecorActionBar.access$800(WindowDecorActionBar.this).isTitleOptional();
    }

    public boolean onMenuItemSelected(i k, MenuItem menuitem)
    {
        if (mCallback != null)
        {
            return mCallback.ked(this, menuitem);
        } else
        {
            return false;
        }
    }

    public void onMenuModeChange(i k)
    {
        if (mCallback == null)
        {
            return;
        } else
        {
            invalidate();
            WindowDecorActionBar.access$800(WindowDecorActionBar.this).showOverflowMenu();
            return;
        }
    }

    public void setCustomView(View view)
    {
        WindowDecorActionBar.access$800(WindowDecorActionBar.this).setCustomView(view);
        mCustomView = new WeakReference(view);
    }

    public void setSubtitle(int k)
    {
        setSubtitle(((CharSequence) (WindowDecorActionBar.access$1000(WindowDecorActionBar.this).getResources().getString(k))));
    }

    public void setSubtitle(CharSequence charsequence)
    {
        WindowDecorActionBar.access$800(WindowDecorActionBar.this).setSubtitle(charsequence);
    }

    public void setTitle(int k)
    {
        setTitle(((CharSequence) (WindowDecorActionBar.access$1000(WindowDecorActionBar.this).getResources().getString(k))));
    }

    public void setTitle(CharSequence charsequence)
    {
        WindowDecorActionBar.access$800(WindowDecorActionBar.this).setTitle(charsequence);
    }

    public void setTitleOptionalHint(boolean flag)
    {
        super.setTitleOptionalHint(flag);
        WindowDecorActionBar.access$800(WindowDecorActionBar.this).setTitleOptional(flag);
    }

    public I(Context context, android.support.v7.view.odeImpl odeimpl)
    {
        this$0 = WindowDecorActionBar.this;
        super();
        mActionModeContext = context;
        mCallback = odeimpl;
        mMenu = (new i(context)).a(1);
        mMenu.a(this);
    }
}
