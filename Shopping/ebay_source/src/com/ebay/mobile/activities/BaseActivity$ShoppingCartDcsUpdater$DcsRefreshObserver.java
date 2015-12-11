// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.database.DataSetObserver;
import android.view.Menu;
import com.ebay.mobile.ui_stuff.MenuHandler;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

private class optionsMenu extends DataSetObserver
{

    private Menu optionsMenu;
    private BaseActivity parent;
    final this._cls1 this$1;

    public void onChanged()
    {
        MenuHandler.prepare(parent, optionsMenu);
        optionsMenu(BaseActivity.access$300(this._cls1.this.optionsMenu));
    }

    public (BaseActivity baseactivity, Menu menu)
    {
        this$1 = this._cls1.this;
        super();
        parent = baseactivity;
        optionsMenu = menu;
    }
}
