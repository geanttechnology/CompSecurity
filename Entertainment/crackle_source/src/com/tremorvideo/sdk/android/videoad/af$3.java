// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            af

class a
    implements android.view.OnKeyListener
{

    final af a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 23)
        {
            a.a = true;
            af.a(a);
            view.invalidate();
        }
        return false;
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
