// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.view.MotionEvent;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            OnGestureListener

public interface GestureDetector
{

    public abstract boolean isScaling();

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public abstract void setOnGestureListener(OnGestureListener ongesturelistener);
}
