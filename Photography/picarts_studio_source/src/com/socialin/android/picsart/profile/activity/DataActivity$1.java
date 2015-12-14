// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            DataActivity, BottomSheetActivity

final class a
    implements android.view.tener
{

    private DataActivity a;

    public final void onClick(View view)
    {
        view = new Intent(a, com/socialin/android/picsart/profile/activity/BottomSheetActivity);
        a.startActivity(view);
    }

    vity(DataActivity dataactivity)
    {
        a = dataactivity;
        super();
    }
}
