// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.DialogInterface;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Assets

final class a
    implements android.content.erface.OnClickListener
{

    final String a;
    final Assets b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        b.storePicture(a);
    }

    ckListener(Assets assets, String s)
    {
        b = assets;
        a = s;
        super();
    }
}
