// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement

class a
    implements android.view.eFragement._cls2
{

    final MagComposeFragement a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        MagComposeFragement.a(a).setVisibility(4);
        return true;
    }

    (MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }
}
