// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.view.MotionEvent;
import myobfuscated.bw.e;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity, CloneSurfaceView

final class a
    implements e
{

    private CloneActivity a;

    public final boolean a(MotionEvent motionevent)
    {
        if (CloneActivity.b(a) == null)
        {
            return false;
        } else
        {
            CloneActivity.b(a).a(motionevent);
            return true;
        }
    }

    public final boolean b(MotionEvent motionevent)
    {
        if (CloneActivity.b(a) == null)
        {
            return false;
        } else
        {
            return CloneActivity.b(a).a(motionevent);
        }
    }

    public final boolean c(MotionEvent motionevent)
    {
        if (CloneActivity.b(a) == null)
        {
            return false;
        }
        if (!CloneActivity.b(a).g)
        {
            a.a(0x7f100139);
        }
        return CloneActivity.b(a).a(motionevent);
    }

    public final void d(MotionEvent motionevent)
    {
    }

    (CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
