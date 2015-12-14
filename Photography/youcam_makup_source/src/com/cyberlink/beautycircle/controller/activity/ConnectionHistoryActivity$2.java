// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.network.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ConnectionHistoryActivity

class a
    implements android.widget.ner
{

    final ConnectionHistoryActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (m)adapterview.getItemAtPosition(i);
        c.a(a, ((m) (adapterview)).a);
    }

    (ConnectionHistoryActivity connectionhistoryactivity)
    {
        a = connectionhistoryactivity;
        super();
    }
}
