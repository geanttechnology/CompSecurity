// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            f, ar

public final class a
    implements android.view..OnTouchListener
{

    final boolean a;
    final f b;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        f.a(b).a(motionevent);
        return motionevent.getAction() == 2 && !a;
    }

    public (f f1, boolean flag)
    {
        b = f1;
        a = flag;
        super();
    }
}
