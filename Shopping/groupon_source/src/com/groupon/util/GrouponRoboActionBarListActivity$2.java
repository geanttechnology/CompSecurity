// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.groupon.util:
//            GrouponRoboActionBarListActivity

class this._cls0
    implements android.widget._cls2
{

    final GrouponRoboActionBarListActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        onListItemClick((ListView)adapterview, view, i, l);
    }

    _cls9()
    {
        this$0 = GrouponRoboActionBarListActivity.this;
        super();
    }
}
