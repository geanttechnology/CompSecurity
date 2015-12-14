// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.you.chat.n;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectXmppServerActivity

class a
    implements android.widget.ener
{

    final SelectXmppServerActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        n.a().a(i);
        n.a().e();
    }

    (SelectXmppServerActivity selectxmppserveractivity)
    {
        a = selectxmppserveractivity;
        super();
    }
}
