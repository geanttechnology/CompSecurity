// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.view.View;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            BasicListActivity

class this._cls0
    implements android.view.yChangeListener
{

    final BasicListActivity this$0;

    public void onChildViewAdded(View view, View view1)
    {
    }

    public void onChildViewRemoved(View view, View view1)
    {
        itemViewFactory.onViewDestroy(view1);
    }

    ()
    {
        this$0 = BasicListActivity.this;
        super();
    }
}
