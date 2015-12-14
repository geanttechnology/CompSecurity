// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.WindowCallbackWrapper;
import android.support.v7.internal.view.menu.i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

// Referenced classes of package android.support.v7.app:
//            AppCompatDelegateImplBase

class this._cls0 extends WindowCallbackWrapper
{

    final AppCompatDelegateImplBase this$0;

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

    public boolean onCreatePanelMenu(int j, Menu menu)
    {
        if (j == 0 && !(menu instanceof i))
        {
            return false;
        } else
        {
            return super.onCreatePanelMenu(j, menu);
        }
    }

    public boolean onMenuOpened(int j, Menu menu)
    {
        if (AppCompatDelegateImplBase.this.onMenuOpened(j, menu))
        {
            return true;
        } else
        {
            return super.onMenuOpened(j, menu);
        }
    }

    public void onPanelClosed(int j, Menu menu)
    {
        if (AppCompatDelegateImplBase.this.onPanelClosed(j, menu))
        {
            return;
        } else
        {
            super.onPanelClosed(j, menu);
            return;
        }
    }

    public boolean onPreparePanel(int j, View view, Menu menu)
    {
        i k;
        boolean flag;
        if (menu instanceof i)
        {
            k = (i)menu;
        } else
        {
            k = null;
        }
        if (j == 0 && k == null)
        {
            flag = false;
        } else
        {
            if (k != null)
            {
                k.e(true);
            }
            boolean flag1 = super.onPreparePanel(j, view, menu);
            flag = flag1;
            if (k != null)
            {
                k.e(false);
                return flag1;
            }
        }
        return flag;
    }

    (android.view.lbackBase lbackbase)
    {
        this$0 = AppCompatDelegateImplBase.this;
        super(lbackbase);
    }
}
