// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.AlertDialog;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements Runnable
{

    final e a;

    public void run()
    {
        if (e.p(a) != null && e.p(a).isShowing())
        {
            e.p(a).dismiss();
        }
        e.a(a, null);
        e.d(a).destroyDrawingCache();
        a.d.a(a);
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
