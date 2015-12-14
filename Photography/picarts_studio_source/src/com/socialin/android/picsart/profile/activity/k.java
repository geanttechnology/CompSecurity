// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.SharedPreferences;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SaveToSDMessageActivity

final class k
    implements android.view.View.OnClickListener
{

    private SaveToSDMessageActivity a;

    private k(SaveToSDMessageActivity savetosdmessageactivity)
    {
        a = savetosdmessageactivity;
        super();
    }

    k(SaveToSDMessageActivity savetosdmessageactivity, byte byte0)
    {
        this(savetosdmessageactivity);
    }

    public final void onClick(View view)
    {
        if (view.getId() == 0x7f1007c6)
        {
            SaveToSDMessageActivity.a(a).edit().putInt("appSaveDialogCount", 3).apply();
        }
        a.a(a, 0x7f1007c4);
    }
}
