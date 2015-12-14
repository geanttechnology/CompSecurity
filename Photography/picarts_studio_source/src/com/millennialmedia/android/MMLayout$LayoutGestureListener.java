// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, MMLog, MMLayout

class a extends android.view.Listener
{

    private WeakReference a;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (motionevent == null || motionevent1 == null || Math.abs((int)(motionevent1.getX() - motionevent.getX())) <= 200 || Math.abs(f) <= Math.abs(f1)) 
        {
            return false;
        }
        if (f <= 0.0F) goto _L2; else goto _L1
_L1:
        if (MMSDK.a == 0)
        {
            MMLog.c("MMLayout", "Enabling debug and verbose logging.");
            MMSDK.a = 3;
        } else
        {
            MMLog.c("MMLayout", "Disabling debug and verbose logging.");
            MMSDK.a = 0;
        }
_L4:
        return true;
_L2:
        motionevent = (MMLayout)a.get();
        if (motionevent != null)
        {
            MMSDK.a(((MMLayout) (motionevent)).e);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (MMLayout mmlayout)
    {
        a = new WeakReference(mmlayout);
    }
}
