// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.api.MAPAccountManager;

public class AospPreferences
{

    private MAPAccountManager mMAPAccountManager;
    private SharedPreferences mPrefs;

    public AospPreferences(Context context)
    {
        mPrefs = context.getSharedPreferences("authentication_shared_prefs_file_key", 0);
        mMAPAccountManager = new MAPAccountManager(context);
    }

    public static String getTruthDatabaseIdHelper(Context context)
    {
        return context.getSharedPreferences("authentication_shared_prefs_file_key", 0).getString("truth_database_id_key", "");
    }

    public void clearPrefs()
    {
        mPrefs.edit().clear().apply();
    }

    public boolean getAutoSaveEnabled()
    {
        return mPrefs.getBoolean("auto_upload_enabled_notification_key", false);
    }

    public String getCustomerId()
    {
        return mPrefs.getString("customer_id", "");
    }

    public String getDeviceUUID()
    {
        return mPrefs.getString("device_uuid_key", "");
    }

    public String getEmail()
    {
        return mPrefs.getString("authentication_email_key", null);
    }

    public String getSignedInAccount()
    {
        return mPrefs.getString("authentication_account_key", null);
    }

    public String getTruthDatabaseId()
    {
        return mPrefs.getString("truth_database_id_key", "");
    }

    public boolean getUpgradedFromTruth()
    {
        return mPrefs.getBoolean("truth_upgrade_key", false);
    }

    public void removeUpgradeFromTruthKey()
    {
        mPrefs.edit().remove("truth_upgrade_key").apply();
    }

    public void setAutoSaveEnabled(boolean flag)
    {
        mPrefs.edit().putBoolean("auto_upload_enabled_notification_key", flag).apply();
    }

    public void setCustomerId(String s)
    {
        mPrefs.edit().putString("customer_id", s).apply();
    }

    public void setDeviceUUID(String s)
    {
        mPrefs.edit().putString("device_uuid_key", s).apply();
    }

    public void setEmail(String s)
    {
        if (s == null)
        {
            mPrefs.edit().remove("authentication_email_key").apply();
            return;
        } else
        {
            mPrefs.edit().putString("authentication_email_key", s).apply();
            return;
        }
    }

    public void setSignedInAccount(String s)
    {
        mPrefs.edit().putString("authentication_account_key", s).apply();
    }

    public void setTruthDatabaseId(String s)
    {
        mPrefs.edit().putString("truth_database_id_key", s).apply();
    }

    public boolean signedIn()
    {
        return mMAPAccountManager.getAccount() != null && getSignedInAccount() != null;
    }
}
