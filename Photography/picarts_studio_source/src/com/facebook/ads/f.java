// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.facebook.ads:
//            VideoAdActivity

class f
    implements android.view.View.OnTouchListener
{

    final VideoAdActivity a;

    f(VideoAdActivity videoadactivity)
    {
        a = videoadactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        VideoAdActivity.access$500(a);
        return false;
    }
}
