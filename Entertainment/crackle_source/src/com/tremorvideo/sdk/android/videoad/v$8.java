// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.AlertDialog;
import android.widget.VideoView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            v

class a
    implements Runnable
{

    final v a;

    public void run()
    {
        if (v.p(a) != null && v.p(a).isShowing())
        {
            v.p(a).dismiss();
        }
        v.a(a, null);
        v.e(a).destroyDrawingCache();
        v.s(a).a(null);
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
