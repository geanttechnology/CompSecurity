// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.DialogInterface;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            b

class a
    implements android.content.Interface.OnDismissListener
{

    final a a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        b.b(a.a, false);
        if (b.f(a.a))
        {
            b.a(a.a, false);
        }
    }

    istener(istener istener)
    {
        a = istener;
        super();
    }
}
