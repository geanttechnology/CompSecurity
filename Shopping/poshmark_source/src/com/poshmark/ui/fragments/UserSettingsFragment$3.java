// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            UserSettingsFragment

class this._cls0
    implements android.view.gsFragment._cls3
{

    final UserSettingsFragment this$0;

    public void onClick(View view)
    {
        view = (ttingsButtonInfo)view.getTag();
        if (view != null)
        {
            UserSettingsFragment.access$000(UserSettingsFragment.this, view);
        }
    }

    ttingsButtonInfo()
    {
        this$0 = UserSettingsFragment.this;
        super();
    }
}
