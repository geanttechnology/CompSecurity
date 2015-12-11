// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            w

class a
    implements android.view.nKeyListener
{

    final w a;
    final b b;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 23)
        {
            b.b = true;
            view.invalidate();
        }
        return false;
    }

    ( , w w1)
    {
        b = ;
        a = w1;
        super();
    }
}
