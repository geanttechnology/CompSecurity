// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity

class a
    implements android.widget.nListener
{

    final SelectUsersActivity a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i == 3)
        {
            d.a(SelectUsersActivity.m(a), false);
            flag = true;
        }
        return flag;
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
