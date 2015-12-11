// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package android.support.v7:
//            tr

class a
    implements android.content.gInterface.OnClickListener
{

    final String a;
    final tr b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        tr.a(b).startActivity(Intent.createChooser((new Intent("android.intent.action.SEND")).setType("text/plain").putExtra("android.intent.extra.TEXT", a), "Share via"));
    }

    terface(tr tr1, String s)
    {
        b = tr1;
        a = s;
        super();
    }
}
