// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.MenuItem;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchResult

class this._cls0
    implements android.view.ickListener
{

    final GlobalSearchResult this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        GlobalSearchResult.access$302(GlobalSearchResult.this, 1);
        switchMode();
        toggleMenuItem();
        return false;
    }

    ner()
    {
        this$0 = GlobalSearchResult.this;
        super();
    }
}
