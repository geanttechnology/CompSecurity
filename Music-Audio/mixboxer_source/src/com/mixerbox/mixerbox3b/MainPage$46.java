// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.actionbarsherlock.view.MenuItem;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements com.actionbarsherlock.view.ctionExpandListener
{

    final MainPage this$0;

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        menuitem.getActionView().requestFocus();
        ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(0, 2);
        return true;
    }

    Manager()
    {
        this$0 = MainPage.this;
        super();
    }
}
