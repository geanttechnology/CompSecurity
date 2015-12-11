// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.DialogInterface;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            by

static final class b
    implements android.content.gInterface.OnCancelListener
{

    final a a;
    final a b;

    public void onCancel(DialogInterface dialoginterface)
    {
        a.a = true;
        b.a(-1, "");
    }

    istener(istener istener, istener istener1)
    {
        a = istener;
        b = istener1;
        super();
    }
}
