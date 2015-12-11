// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            PassiveStateChangeListener

public class PassiveGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
{

    Set passiveStateChangeListeners;

    public PassiveGestureListener(PassiveStateChangeListener passivestatechangelistener)
    {
        passiveStateChangeListeners = Collections.synchronizedSet(new HashSet());
        passiveStateChangeListeners.add(passivestatechangelistener);
    }

    public PassiveGestureListener(Set set)
    {
        passiveStateChangeListeners = Collections.synchronizedSet(new HashSet());
        passiveStateChangeListeners = set;
    }

    public static boolean isDownInRange(MotionEvent motionevent, DisplayMetrics displaymetrics)
    {
        return motionevent.getX() > 0.0F && motionevent.getX() < (float)(int)((double)displaymetrics.widthPixels * 0.10000000000000001D) && motionevent.getY() > (float)(int)((double)displaymetrics.heightPixels * 0.33000000000000002D) && motionevent.getY() < (float)(int)((double)displaymetrics.heightPixels * 0.66000000000000003D) || motionevent.getX() > 0.0F && motionevent.getX() < (float)(int)((double)displaymetrics.heightPixels * 0.10000000000000001D) && motionevent.getY() > (float)(int)((double)displaymetrics.widthPixels * 0.33000000000000002D) && motionevent.getY() < (float)(int)((double)displaymetrics.widthPixels * 0.66000000000000003D);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f1) >= 2500F || Math.abs(f1) <= -2500F)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        motionevent = passiveStateChangeListeners;
        motionevent;
        JVM INSTR monitorenter ;
        for (motionevent1 = passiveStateChangeListeners.iterator(); motionevent1.hasNext(); ((PassiveStateChangeListener)motionevent1.next()).onSpeechSwipe()) { }
        break MISSING_BLOCK_LABEL_70;
        motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        throw motionevent1;
        motionevent;
        JVM INSTR monitorexit ;
        return true;
        return false;
    }
}
