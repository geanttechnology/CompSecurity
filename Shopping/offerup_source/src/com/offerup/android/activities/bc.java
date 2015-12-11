// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity

final class bc
    implements android.widget.TextView.OnEditorActionListener
{

    private ChatActivity a;

    bc(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i == 4)
        {
            ChatActivity.a(a);
            flag = true;
        }
        return flag;
    }
}
