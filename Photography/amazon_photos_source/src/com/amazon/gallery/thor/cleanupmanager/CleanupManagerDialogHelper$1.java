// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.content.DialogInterface;
import com.amazon.gallery.thor.app.activity.CleanupManagerActivity;

// Referenced classes of package com.amazon.gallery.thor.cleanupmanager:
//            CleanupManagerDialogHelper

class val.isNoDupesFound
    implements android.content.er
{

    final CleanupManagerDialogHelper this$0;
    final boolean val$isNoDupesFound;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        CleanupManagerDialogHelper.access$000(CleanupManagerDialogHelper.this).setCleanupPreference(true);
        if (val$isNoDupesFound)
        {
            showNoDupesFoundDialog();
        }
    }

    I()
    {
        this$0 = final_cleanupmanagerdialoghelper;
        val$isNoDupesFound = Z.this;
        super();
    }
}
