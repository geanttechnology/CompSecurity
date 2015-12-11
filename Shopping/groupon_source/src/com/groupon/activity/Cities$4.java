// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.AdapterView;
import com.groupon.models.division.Division;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

// Referenced classes of package com.groupon.activity:
//            Cities

class this._cls0
    implements android.widget.ew.OnItemClickListener
{

    final Cities this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((AdapterView) (listView.getItemAtPosition(i)));
        Cities.access$1000(Cities.this, (Division)adapterview);
    }

    vision()
    {
        this$0 = Cities.this;
        super();
    }
}
