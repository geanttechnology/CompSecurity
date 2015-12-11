// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.DialogInterface;
import android.content.Intent;
import com.groupon.activity.Countries;
import com.groupon.events.UserMigrationClickEvent;
import com.groupon.fragment.UserMigrationDialogFragment;
import com.groupon.util.UserMigrationManager;

// Referenced classes of package com.groupon.service:
//            UserMigrationController

protected static class  extends UserMigrationController
{

    protected Intent createDownloadIntent(UserMigrationManager usermigrationmanager)
    {
        return usermigrationmanager.createForcedMigrationDownloadIntent();
    }

    public boolean hasNotificationsDisabled()
    {
        return true;
    }

    public void negativeButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        super.negativeButtonClicked(usermigrationdialogfragment, dialoginterface);
        notifyManager(UserMigrationClickEvent.CHANGE_COUNTRY);
    }

    public void positiveButtonClicked(UserMigrationDialogFragment usermigrationdialogfragment, DialogInterface dialoginterface)
    {
        super.positiveButtonClicked(usermigrationdialogfragment, dialoginterface);
        notifyManager(UserMigrationClickEvent.FORCED_DOWNLOAD);
        gotoDownload(usermigrationdialogfragment.getActivity());
    }

    public com.groupon.fragment.otoDownload setup(com.groupon.fragment.otoDownload otodownload)
    {
        otodownload.er(this).er(RCED_MIGRATION.me()).e(com/groupon/activity/Countries).nCountries().nCountries();
        return otodownload;
    }

    protected ()
    {
    }
}
