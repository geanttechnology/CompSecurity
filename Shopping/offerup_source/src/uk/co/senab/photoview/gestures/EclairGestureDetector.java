// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.view.MotionEvent;
import uk.co.senab.photoview.Compat;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            CupcakeGestureDetector

public class EclairGestureDetector extends CupcakeGestureDetector
{

    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId;
    private int mActivePointerIndex;

    public EclairGestureDetector(Context context)
    {
        super(context);
        mActivePointerId = -1;
        mActivePointerIndex = 0;
    }

    float getActiveX(MotionEvent motionevent)
    {
        float f;
        try
        {
            f = motionevent.getX(mActivePointerIndex);
        }
        catch (Exception exception)
        {
            return motionevent.getX();
        }
        return f;
    }

    float getActiveY(MotionEvent motionevent)
    {
        float f;
        try
        {
            f = motionevent.getY(mActivePointerIndex);
        }
        catch (Exception exception)
        {
            return motionevent.getY();
        }
        return f;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 82
    //                   1 94
    //                   2 52
    //                   3 94
    //                   4 52
    //                   5 52
    //                   6 102;
           goto _L1 _L2 _L3 _L1 _L3 _L1 _L1 _L4
_L1:
        int i = ((flag) ? 1 : 0);
        if (mActivePointerId != -1)
        {
            i = mActivePointerId;
        }
        mActivePointerIndex = motionevent.findPointerIndex(i);
        return super.onTouchEvent(motionevent);
_L2:
        mActivePointerId = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L3:
        mActivePointerId = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        int j = Compat.getPointerIndex(motionevent.getAction());
        if (motionevent.getPointerId(j) == mActivePointerId)
        {
            if (j == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            mActivePointerId = motionevent.getPointerId(j);
            mLastTouchX = motionevent.getX(j);
            mLastTouchY = motionevent.getY(j);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
