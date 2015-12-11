// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.chat;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.chat:
//            MessagesActivity

class a
    implements android.widget.
{

    final MessagesActivity a;
    final  b;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return a.onEditorAction(i);
    }

    Q(Q q, MessagesActivity messagesactivity)
    {
        b = q;
        a = messagesactivity;
        super();
    }
}
