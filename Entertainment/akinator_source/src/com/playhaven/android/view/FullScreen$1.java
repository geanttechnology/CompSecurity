// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.view;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package com.playhaven.android.view:
//            FullScreen

class nit> extends OrientationEventListener
{

    final FullScreen this$0;

    public void onOrientationChanged(int i)
    {
        updateFrame();
    }

    (Context context)
    {
        this$0 = FullScreen.this;
        super(context);
    }
}
