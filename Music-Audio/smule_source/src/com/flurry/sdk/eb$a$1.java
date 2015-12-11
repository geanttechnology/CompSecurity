// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

class t extends Dialog
{

    final Activity a;
    final nt b;

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return a.dispatchTouchEvent(motionevent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        return a.dispatchTrackballEvent(motionevent);
    }

    t(t t, Context context, int i, Activity activity)
    {
        b = t;
        a = activity;
        super(context, i);
    }
}
