// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

public class du
    implements android.content.DialogInterface.OnClickListener
{

    private final Activity gs;
    private final Intent mIntent;
    private final int oZ;

    public du(Activity activity, Intent intent, int i)
    {
        gs = activity;
        mIntent = intent;
        oZ = i;
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            if (mIntent != null)
            {
                gs.startActivityForResult(mIntent, oZ);
            }
            dialoginterface.dismiss();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
