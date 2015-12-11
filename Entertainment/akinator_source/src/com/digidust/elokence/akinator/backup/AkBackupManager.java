// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.backup;


// Referenced classes of package com.digidust.elokence.akinator.backup:
//            AkBackupManagerImpl

public class AkBackupManager
{

    private static AkBackupManager _instance = null;
    private boolean canSave;
    AkBackupManagerImpl impl;

    private AkBackupManager()
    {
        canSave = false;
        impl = new AkBackupManagerImpl();
    }

    public static AkBackupManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new AkBackupManager();
        }
        return _instance;
    }

    public boolean canSave()
    {
        return canSave;
    }

    public boolean restoreBackup()
    {
        return impl.restoreBackup();
    }

    public void saveBackup()
    {
        impl.saveBackup();
    }

    public void setCanSave(boolean flag)
    {
        canSave = flag;
    }

}
