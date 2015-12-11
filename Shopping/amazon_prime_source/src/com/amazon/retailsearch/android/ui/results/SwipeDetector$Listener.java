// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.view.MotionEvent;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            SwipeDetector

public static interface 
{

    public abstract boolean onDown(MotionEvent motionevent);

    public abstract boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3);

    public abstract boolean onSwipe(float f, float f1, MotionEvent motionevent, float f2, float f3);
}
