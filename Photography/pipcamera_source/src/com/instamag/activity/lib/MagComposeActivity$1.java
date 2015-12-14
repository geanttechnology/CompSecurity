// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

class a
    implements android.view.seActivity._cls1
{

    final MagComposeActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (MagComposeActivity.a(a).getVisibility() == 0)
        {
            Log.e(MagComposeActivity.b(a), "maskLayout ONtoUCH");
            MagComposeActivity.c(a);
        }
        return false;
    }

    (MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }
}
