// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            af

class a
    implements android.view.OnFocusChangeListener
{

    final af a;

    public void onFocusChange(View view, boolean flag)
    {
        a.a = flag;
        af.a(a);
        view.invalidate();
    }

    (af af1)
    {
        a = af1;
        super();
    }
}
