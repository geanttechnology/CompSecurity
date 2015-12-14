// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.socialin.android.picsart.profile.activity.SliderActivity;

public final class l
    implements android.view.View.OnClickListener
{

    private Activity a;

    public l(Activity activity)
    {
        a = activity;
        super();
    }

    public final void onClick(View view)
    {
        view = new Intent(a, com/socialin/android/picsart/profile/activity/SliderActivity);
        view.putExtra("sliderContent", "createMembox");
        a.startActivityForResult(view, 103);
    }
}
