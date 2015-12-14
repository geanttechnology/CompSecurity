// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.settings;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.ParcelFileDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.FreeTimeCommon;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.ThorSettingsActivity;
import com.amazon.gallery.thor.di.AppKeys;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.settings:
//            PreferenceMigrator

public class ThorBackupAgent extends BackupAgentHelper
{

    private String preferenceGroupName;
    SharedPreferencesBackupHelper sharedPrefsHelper;

    public ThorBackupAgent()
    {
    }

    public void onBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1)
        throws IOException
    {
        getSharedPreferences(preferenceGroupName, 0).edit().putBoolean("SAVED_WAN_STATE", ((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).deviceHasWAN()).apply();
        super.onBackup(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor1);
    }

    public void onCreate()
    {
        preferenceGroupName = ThorSettingsActivity.getSharedPreferencesGroup(this);
        FreeTime freetime = (FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME);
        String as[];
        if (freetime.isFreeTimeFeatureEnabled())
        {
            List list = freetime.getFreetimeProfiles();
            String as1[] = new String[list.size() + 1];
            int i = 0;
            do
            {
                as = as1;
                if (i >= list.size())
                {
                    break;
                }
                as1[i + 1] = FreeTimeCommon.getChildPreferenceId(((Integer)list.get(i)).intValue());
                i++;
            } while (true);
        } else
        {
            as = new String[1];
        }
        as[0] = preferenceGroupName;
        sharedPrefsHelper = new SharedPreferencesBackupHelper(this, as);
        addHelper("SHARED_PREFERENCES_BACKUP", sharedPrefsHelper);
    }

    public void onRestore(BackupDataInput backupdatainput, int i, ParcelFileDescriptor parcelfiledescriptor)
        throws IOException
    {
        super.onRestore(backupdatainput, i, parcelfiledescriptor);
        backupdatainput = getSharedPreferences(preferenceGroupName, 0);
        if (backupdatainput.contains("SAVED_WAN_STATE") && backupdatainput.getBoolean("SAVED_WAN_STATE", false) != ((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).deviceHasWAN())
        {
            backupdatainput.edit().putBoolean("wan_allowed_key", false).apply();
        }
        PreferenceMigrator.updatePreferences(getApplicationContext());
    }
}
