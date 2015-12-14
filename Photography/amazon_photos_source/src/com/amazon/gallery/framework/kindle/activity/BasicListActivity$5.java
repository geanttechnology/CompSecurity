// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.widget.AbsListView;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity

class val.fScrollPos
    implements Runnable
{

    final BasicListActivity this$0;
    final int val$fScrollPos;

    public void run()
    {
        listView.setSelection(val$fScrollPos);
    }

    ()
    {
        this$0 = final_basiclistactivity;
        val$fScrollPos = I.this;
        super();
    }
}
