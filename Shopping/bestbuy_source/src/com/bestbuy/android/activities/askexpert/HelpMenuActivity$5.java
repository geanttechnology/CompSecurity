// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import android.view.View;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.ChatSDK;

// Referenced classes of package com.bestbuy.android.activities.askexpert:
//            HelpMenuActivity

class a
    implements android.view.r
{

    final HelpMenuActivity a;

    public void onClick(View view)
    {
        if (ChatRunningStatus.getChatRunning() && HelpMenuActivity.c() != null)
        {
            HelpMenuActivity.c().endChat();
        }
        a.finish();
        a.overridePendingTransition(0x7f040005, 0x7f040008);
    }

    A(HelpMenuActivity helpmenuactivity)
    {
        a = helpmenuactivity;
        super();
    }
}
