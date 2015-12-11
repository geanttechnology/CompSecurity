// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.view.MotionEvent;

// Referenced classes of package co.vine.android.views:
//            TouchableRelativeLayout

public static interface A
{

    public abstract boolean onInterceptTouchEvent(MotionEvent motionevent);

    public abstract boolean onTouchEvent(MotionEvent motionevent);
}
