// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.widget.RelativeLayout;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        a.q.requestLayout();
        a.q.invalidate();
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
