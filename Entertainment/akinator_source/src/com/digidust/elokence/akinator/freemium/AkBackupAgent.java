// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.freemium;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.FileBackupHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.os.ParcelFileDescriptor;
import com.digidust.elokence.akinator.factories.AkLog;
import java.io.File;
import java.io.IOException;

public class AkBackupAgent extends BackupAgentHelper
{

    private static final String BACKUP_DB = "backupname.db";
    static final String DATABASE = "AkDB";
    static final String PREF_BACKUP_KEY = "AkPrefs";
    static final Object sDataLock = new Object();

    public AkBackupAgent()
    {
    }

    public File getFilesDir()
    {
        return getDatabasePath("akinator.db").getParentFile();
    }

    public void onBackup(ParcelFileDescriptor parcelfiledescriptor, BackupDataOutput backupdataoutput, ParcelFileDescriptor parcelfiledescriptor1)
        throws IOException
    {
        AkLog.d("AkBackupAgent", "OnBackup called");
        synchronized (sDataLock)
        {
            AkLog.d("AkBackupAgent", "OnBackup in-lock");
            super.onBackup(parcelfiledescriptor, backupdataoutput, parcelfiledescriptor1);
        }
        return;
        parcelfiledescriptor;
        obj;
        JVM INSTR monitorexit ;
        throw parcelfiledescriptor;
    }

    public void onCreate()
    {
        super.onCreate();
        addHelper("AkPrefs", new SharedPreferencesBackupHelper(this, new String[] {
            "settings", "bank"
        }));
        addHelper("AkDB", new FileBackupHelper(this, new String[] {
            "akinator.db"
        }));
        AkLog.d("AkBackupAgent", "OnCreate");
    }

    public void onRestore(BackupDataInput backupdatainput, int i, ParcelFileDescriptor parcelfiledescriptor)
        throws IOException
    {
        AkLog.d("AkBackupAgent", "OnRestore called");
        synchronized (sDataLock)
        {
            AkLog.d("AkBackupAgent", "OnRestore in-lock");
            super.onRestore(backupdatainput, i, parcelfiledescriptor);
        }
        return;
        backupdatainput;
        obj;
        JVM INSTR monitorexit ;
        throw backupdatainput;
    }

}
