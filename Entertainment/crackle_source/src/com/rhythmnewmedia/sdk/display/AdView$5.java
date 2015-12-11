// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

final class a
    implements android.view.uchListener
{

    final AdView a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }

    (AdView adview)
    {
        a = adview;
        super();
    }
}
