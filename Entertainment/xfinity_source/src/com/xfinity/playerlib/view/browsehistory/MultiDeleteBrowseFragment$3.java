// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsehistory;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.browsehistory:
//            MultiDeleteBrowseFragment

class this._cls0
    implements android.widget.istener
{

    final MultiDeleteBrowseFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!MultiDeleteBrowseFragment.access$400(MultiDeleteBrowseFragment.this))
        {
            MultiDeleteBrowseFragment.access$500(MultiDeleteBrowseFragment.this);
            MultiDeleteBrowseFragment.access$600(MultiDeleteBrowseFragment.this, i);
        } else
        {
            MultiDeleteBrowseFragment.access$600(MultiDeleteBrowseFragment.this, i);
        }
        return true;
    }

    ()
    {
        this$0 = MultiDeleteBrowseFragment.this;
        super();
    }
}
