// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;

public final class dw
{

    public static int a(MotionEvent motionevent)
    {
        return motionevent.getAction() & 0xff;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            new dy();
        } else
        {
            new dx();
        }
    }
}
