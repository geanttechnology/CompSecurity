// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

// Referenced classes of package com.flurry.android:
//            co, ft

final class dv extends Dialog
{

    private co fC;

    dv(co co1, Context context, int i)
    {
        fC = co1;
        super(context, i);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (ft.n(fC.dp) != null)
        {
            flag = ft.n(fC.dp).dispatchTouchEvent(motionevent);
        }
        return flag;
    }

    public final boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (ft.n(fC.dp) != null)
        {
            flag = ft.n(fC.dp).dispatchTrackballEvent(motionevent);
        }
        return flag;
    }
}
