// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            MessageSettingActivity

class a
    implements android.view.ingActivity._cls6
{

    final MessageSettingActivity a;

    public void onClick(View view)
    {
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setSelected(flag);
        MessageSettingActivity.b(a);
    }

    _cls9(MessageSettingActivity messagesettingactivity)
    {
        a = messagesettingactivity;
        super();
    }
}
