// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity

class this._cls0
    implements android.widget.ngClickListener
{

    final BasicListActivity this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        onLongClick(view, i);
        return true;
    }

    ()
    {
        this$0 = BasicListActivity.this;
        super();
    }
}
