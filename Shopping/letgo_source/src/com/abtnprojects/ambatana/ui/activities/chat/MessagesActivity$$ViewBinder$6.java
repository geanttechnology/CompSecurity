// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            MessagesActivity

class a extends DebouncingOnClickListener
{

    final MessagesActivity a;
    final icked b;

    public void doClick(View view)
    {
        a.onUserHeaderClicked();
    }

    Q(Q q, MessagesActivity messagesactivity)
    {
        b = q;
        a = messagesactivity;
        super();
    }
}
