// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements android.view.onExpandListener
{

    final MainActivity this$0;

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        menuitem = getIntent();
        finish();
        startActivity(menuitem);
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return true;
    }

    pandListener()
    {
        this$0 = MainActivity.this;
        super();
    }
}
