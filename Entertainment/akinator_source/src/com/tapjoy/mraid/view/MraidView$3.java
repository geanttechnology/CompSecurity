// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.view.MotionEvent;
import android.view.View;
import com.tapjoy.TapjoyLog;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements android.view.Listener
{

    final MraidView a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        TapjoyLog.i("MRAIDView", "background touch called");
        return true;
    }

    (MraidView mraidview)
    {
        a = mraidview;
        super();
    }
}
