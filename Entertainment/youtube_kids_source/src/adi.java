// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;

final class adi
    implements android.view.View.OnTouchListener
{

    private adg a;

    adi(adg adg1)
    {
        a = adg1;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        adg.a(a, motionevent);
        return false;
    }
}
