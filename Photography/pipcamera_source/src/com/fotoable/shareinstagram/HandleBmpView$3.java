// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.view.MotionEvent;

// Referenced classes of package com.fotoable.shareinstagram:
//            HandleBmpView

class a
    implements android.view.OnGestureListener
{

    final HandleBmpView a;

    public boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        motionevent = a;
        motionevent.translation_x = ((HandleBmpView) (motionevent)).translation_x + f;
        motionevent = a;
        motionevent.translation_y = ((HandleBmpView) (motionevent)).translation_y + f1;
        HandleBmpView.access$002(a, false);
        a.invalidate();
        return true;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    er(HandleBmpView handlebmpview)
    {
        a = handlebmpview;
        super();
    }
}
