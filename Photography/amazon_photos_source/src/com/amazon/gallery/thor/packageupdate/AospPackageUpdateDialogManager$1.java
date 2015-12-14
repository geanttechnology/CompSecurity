// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            AospPackageUpdateDialogManager

class val.context
    implements android.content.
{

    final AospPackageUpdateDialogManager this$0;
    final Activity val$context;

    public void onDismiss(DialogInterface dialoginterface)
    {
        val$context.finish();
    }

    ()
    {
        this$0 = final_aosppackageupdatedialogmanager;
        val$context = Activity.this;
        super();
    }
}
