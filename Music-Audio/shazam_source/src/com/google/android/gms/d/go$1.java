// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.d:
//            go

final class a
    implements android.content.gInterface.OnClickListener
{

    final String a;
    final go b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        b.a.startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", a), "Share via"));
    }

    e(go go1, String s)
    {
        b = go1;
        a = s;
        super();
    }
}
