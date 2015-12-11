// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements android.content.gInterface.OnClickListener
{

    final Uri a;
    final ap b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.VIEW", a);
        b.startActivity(dialoginterface);
    }

    Listener(ap ap1, Uri uri)
    {
        b = ap1;
        a = uri;
        super();
    }
}
