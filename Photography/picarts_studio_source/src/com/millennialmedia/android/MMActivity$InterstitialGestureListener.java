// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMActivity, MMAdImplController

class a extends android.view.
{

    private WeakReference a;

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        motionevent = (MMActivity)a.get();
        if (motionevent != null)
        {
            a(MMAdImplController.a(((MMActivity) (motionevent)).b));
        }
        return false;
    }

    public (MMActivity mmactivity)
    {
        a = new WeakReference(mmactivity);
    }
}
