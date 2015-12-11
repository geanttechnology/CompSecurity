// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.b;

import android.view.MotionEvent;

// Referenced classes of package com.j.a.b:
//            d

class n
    implements d
{

    n()
    {
    }

    public int a(MotionEvent motionevent)
    {
        return 1;
    }

    public int a(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }

    public float b(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return motionevent.getX();
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }

    public float c(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return motionevent.getY();
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }
}
