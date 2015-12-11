// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.DialogInterface;
import android.content.Intent;
import com.groupon.activity.Carousel;
import com.groupon.events.UserMigrationClickEvent;
import com.groupon.fragment.UserMigrationDialogFragment;
import com.groupon.util.UserMigrationManager;

// Referenced classes of package com.groupon.service:
//            UserMigrationController

protected static class  extends UserMigrationController
{

    protected Intent createDownloadIntent(UserMigrationManager usermigrationmanager)
    {
        return usermigrationmanager.createSuggestedMigrationDownloadIntent();
    }

    public void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        super.negativeButtonClicked(usermigrationdialogfragment, dialoginterface);
        notifyManager(UserMigrationClickEvent.POSTPONED);
        postpone(0xf731400L);
    }

    public void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        super.positiveButtonClicked(usermigrationdialogfragment, dialoginterface);
        notifyManager(UserMigrationClickEvent.SUGGESTED_DOWNLOAD);
        postpone(0xf731400L);
        gotoDownload(usermigrationdialogfragment.getActivity());
    }

    public com.groupon.fragment.otoDownload setup(com.groupon.fragment.otoDownload otodownload)
    {
        otodownload.otoDownload(this).otoDownload(STED_MIGRATION.STED_MIGRATION()).TED_MIGRATION(com/groupon/activity/Carousel).();
        return otodownload;
    }

    protected ()
    {
    }
}
