// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.google.ads.internal:
//            AdWebView

class a
    implements android.view.Listener
{

    final AdWebView a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return motionevent.getAction() == 2;
    }

    (AdWebView adwebview)
    {
        a = adwebview;
        super();
    }
}
