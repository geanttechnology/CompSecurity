// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.gallery.framework.kindle.timeline.model.ExpandableListComponent;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class this._cls0
    implements android.widget.ner
{

    final TimelineNavigatorListImpl this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onTimeNavBarClick(i, (ExpandableListComponent)adapterview.getItemAtPosition(i));
    }

    t()
    {
        this$0 = TimelineNavigatorListImpl.this;
        super();
    }
}
