// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a
    implements android.view.ingActivity._cls4
{

    final MessageSettingActivity a;

    private void a(View view)
    {
        if (!view.isFocused())
        {
            view.setFocusableInTouchMode(true);
            view.requestFocusFromTouch();
            d.a(a, true);
        }
    }

    public void onClick(View view)
    {
        if (!MessageSettingActivity.a(a).e.equals("Dual"))
        {
            a(view);
            MessageSettingActivity.b(a);
        }
    }

    _cls9(MessageSettingActivity messagesettingactivity)
    {
        a = messagesettingactivity;
        super();
    }
}
