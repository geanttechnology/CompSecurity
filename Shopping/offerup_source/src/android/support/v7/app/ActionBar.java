// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;

public abstract class ActionBar
{

    public ActionBar()
    {
    }

    public boolean collapseActionView()
    {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean flag)
    {
    }

    public abstract int getDisplayOptions();

    public Context getThemedContext()
    {
        return null;
    }

    public abstract void hide();

    public boolean invalidateOptionsMenu()
    {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent)
    {
        return false;
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean flag)
    {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean flag);

    public abstract void setDisplayOptions(int i, int j);

    public abstract void setDisplayShowHomeEnabled(boolean flag);

    public abstract void setDisplayShowTitleEnabled(boolean flag);

    public abstract void setDisplayUseLogoEnabled(boolean flag);

    public void setElevation(float f)
    {
        if (f != 0.0F)
        {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public void setHideOnContentScrollEnabled(boolean flag)
    {
        if (flag)
        {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        } else
        {
            return;
        }
    }

    public void setHomeActionContentDescription(int i)
    {
    }

    public void setHomeAsUpIndicator(int i)
    {
    }

    public void setHomeButtonEnabled(boolean flag)
    {
    }

    public abstract void setLogo(int i);

    public void setShowHideAnimationEnabled(boolean flag)
    {
    }

    public abstract void setTitle(CharSequence charsequence);

    public void setWindowTitle(CharSequence charsequence)
    {
    }

    public abstract void show();

    public ActionMode startActionMode(android.support.v7.view.ActionMode.Callback callback)
    {
        return null;
    }
}
