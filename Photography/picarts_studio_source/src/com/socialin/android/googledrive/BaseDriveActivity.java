// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;

public class BaseDriveActivity extends AppCompatActivity
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private static final String c = com/socialin/android/googledrive/BaseDriveActivity.getSimpleName();
    protected GoogleApiClient a;
    protected String b;

    public BaseDriveActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            if (i == 1)
            {
                a.connect();
                return;
            } else
            {
                Log.w(c, (new StringBuilder("Unexpected activity request code")).append(i).toString());
                return;
            }
        } else
        {
            finish();
            return;
        }
    }

    public void onConnected(Bundle bundle)
    {
        Log.i(c, "GoogleApiClient connected");
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Log.i(c, (new StringBuilder("Connection failed: ")).append(connectionresult.getErrorCode()).toString());
        if (!connectionresult.hasResolution())
        {
            GooglePlayServicesUtil.getErrorDialog(connectionresult.getErrorCode(), this, 0).show();
            return;
        }
        try
        {
            connectionresult.startResolutionForResult(this, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionResult connectionresult)
        {
            Log.e(c, "Send intent failed", connectionresult);
        }
    }

    public void onConnectionSuspended(int i)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            b = bundle.getString("accountName");
        }
        if (b == null)
        {
            b = getIntent().getStringExtra("accountName");
        }
        if (b == null)
        {
            bundle = AccountManager.get(this).getAccountsByType("com.google");
            if (bundle.length > 0)
            {
                b = ((Account) (bundle[0])).name;
                (new StringBuilder("No account specified, selecting ")).append(b);
            } else
            {
                b = "DEFAULT ACCOUNT";
            }
        }
        if (a == null)
        {
            bundle = (new com.google.android.gms.common.api.GoogleApiClient.Builder(this)).addApi(Drive.API).addScope(Drive.SCOPE_FILE).addConnectionCallbacks(this).addOnConnectionFailedListener(this);
            if (!"DEFAULT ACCOUNT".equals(b))
            {
                bundle.setAccountName(b);
            }
            a = bundle.build();
        }
    }

    protected void onPause()
    {
        if (a != null)
        {
            a.disconnect();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        a.connect();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("accountName", b);
    }

}
