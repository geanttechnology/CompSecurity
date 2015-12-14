// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.View;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayView, MMLog

class a
    implements android.view.
{

    private AdViewOverlayView a;

    public void onClick(View view)
    {
        MMLog.a("AdViewOverlayView", "Close button clicked.");
        a.b();
    }

    (AdViewOverlayView adviewoverlayview)
    {
        a = adviewoverlayview;
        super();
    }
}
