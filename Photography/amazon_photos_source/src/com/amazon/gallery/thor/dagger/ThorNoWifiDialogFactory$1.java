// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.amazon.gallery.thor.dagger:
//            ThorNoWifiDialogFactory

class val.context
    implements android.content.tener
{

    final ThorNoWifiDialogFactory this$0;
    final Context val$context;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = final_thornowifidialogfactory;
        val$context = Context.this;
        super();
    }
}
