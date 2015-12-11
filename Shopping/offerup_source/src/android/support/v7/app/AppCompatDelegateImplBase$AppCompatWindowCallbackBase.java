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
        return AppCompatDelegateImplBase.this.dispatchKeyEvent(keyevent) || super.dispatchKeyEvent(keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyShortcutEvent(keyevent) || onKeyShortcut(keyevent.getKeyCode(), keyevent);
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
        return super.onMenuOpened(j, menu) || AppCompatDelegateImplBase.this.onMenuOpened(j, menu);
    }

    public void onPanelClosed(int j, Menu menu)
    {
        super.onPanelClosed(j, menu);
        AppCompatDelegateImplBase.this.onPanelClosed(j, menu);
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
                k.c(true);
            }
            boolean flag1 = super.onPreparePanel(j, view, menu);
            flag = flag1;
            if (k != null)
            {
                k.c(false);
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
