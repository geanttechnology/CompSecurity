// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.DialogInterface;

// Referenced classes of package com.tapjoy.internal:
//            gi, ge

final class a
    implements android.content.gInterface.OnCancelListener
{

    final ge a;
    final gi b;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.d(b.b);
    }

    erface(gi gi1, ge ge1)
    {
        b = gi1;
        a = ge1;
        super();
    }
}
