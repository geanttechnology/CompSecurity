// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.internal.view.WindowCallbackWrapper;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplBase

class this._cls0 extends WindowCallbackWrapper
{

    final AppCompatDelegateImplBase this$0;

    private boolean bypassPrepareOptionsPanelIfNeeded()
    {
        while (android.os.dowCallback < 16 && (mOriginalWindowCallback instanceof Activity) || (mOriginalWindowCallback instanceof Dialog)) 
        {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (AppCompatDelegateImplBase.this.dispatchKeyEvent(keyevent))
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        if (onKeyShortcut(keyevent.getKeyCode(), keyevent))
        {
            return true;
        } else
        {
            return super.dispatchKeyShortcutEvent(keyevent);
        }
    }

    public void onContentChanged()
    {
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        if (i == 0 && !(menu instanceof MenuBuilder))
        {
            return false;
        } else
        {
            return super.onCreatePanelMenu(i, menu);
        }
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        if (AppCompatDelegateImplBase.this.onMenuOpened(i, menu))
        {
            return true;
        } else
        {
            return super.onMenuOpened(i, menu);
        }
    }

    public void onPanelClosed(int i, Menu menu)
    {
        if (AppCompatDelegateImplBase.this.onPanelClosed(i, menu))
        {
            return;
        } else
        {
            super.onPanelClosed(i, menu);
            return;
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        if (i != 0 || (menu instanceof MenuBuilder))
        {
            if (i == 0 && bypassPrepareOptionsPanelIfNeeded())
            {
                if (mOriginalWindowCallback instanceof Activity)
                {
                    return ((Activity)mOriginalWindowCallback).onPrepareOptionsMenu(menu);
                }
                if (mOriginalWindowCallback instanceof Dialog)
                {
                    return ((Dialog)mOriginalWindowCallback).onPrepareOptionsMenu(menu);
                }
            } else
            {
                return super.onPreparePanel(i, view, menu);
            }
        }
        return false;
    }

    (android.view.wCallback wcallback)
    {
        this$0 = AppCompatDelegateImplBase.this;
        super(wcallback);
    }
}
