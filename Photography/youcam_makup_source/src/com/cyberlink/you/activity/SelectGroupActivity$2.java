// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.cyberlink.you.database.Group;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectGroupActivity

class a
    implements android.widget.kListener
{

    final SelectGroupActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Group)SelectGroupActivity.a(a).getItem(i);
        SelectGroupActivity.a(a, adapterview);
    }

    (SelectGroupActivity selectgroupactivity)
    {
        a = selectgroupactivity;
        super();
    }
}
