// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            av

final class aw extends av
{

    aw()
    {
    }

    public final float e(MotionEvent motionevent, int i)
    {
        return motionevent.getAxisValue(i);
    }
}
