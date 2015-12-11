// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            be, aw

static final class b
    implements android.view.OnClickListener
{

    final b a;
    final Dialog b;

    public void onClick(View view)
    {
        be.e = true;
        a.((aw)view.getTag());
        b.dismiss();
    }

    ( , Dialog dialog)
    {
        a = ;
        b = dialog;
        super();
    }
}
