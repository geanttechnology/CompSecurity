// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.google.ads.internal:
//            k

class a
    implements android.content.Interface.OnClickListener
{

    final String a;
    final a b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        e(b).startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", a), "Share via"));
    }

    e(e e, String s)
    {
        b = e;
        a = s;
        super();
    }
}
