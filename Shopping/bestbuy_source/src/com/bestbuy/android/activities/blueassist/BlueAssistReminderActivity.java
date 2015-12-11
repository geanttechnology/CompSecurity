// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.base.BBYBaseFragmentActivity;

public class BlueAssistReminderActivity extends BBYBaseFragmentActivity
{

    public BlueAssistReminderActivity()
    {
    }

    public void a()
    {
        Object obj1 = getIntent().getExtras();
        Object obj = (new StringBuilder()).append("Mobile Phone Appointment at Best Buy\n").append(((Bundle) (obj1)).getString(getResources().getString(0x7f080053), "")).append(" ").append(((Bundle) (obj1)).getString(getResources().getString(0x7f080054), "")).toString();
        Object obj2 = (BBYStore)((Bundle) (obj1)).getSerializable(getResources().getString(0x7f080050));
        obj1 = new StringBuilder();
        if (obj2 != null)
        {
            ((StringBuilder) (obj1)).append(((BBYStore) (obj2)).getStoreDetails().getName().replace("Best Buy Mobile - ", "").trim()).append("\n").append(((BBYStore) (obj2)).getStoreDetails().getAddress()).append("\n").append(((BBYStore) (obj2)).getStoreDetails().getCity()).append(", ").append(((BBYStore) (obj2)).getStoreDetails().getState()).append(" ").append(((BBYStore) (obj2)).getStoreDetails().getZipCode());
        }
        obj2 = new android.app.AlertDialog.Builder(this);
        ((android.app.AlertDialog.Builder) (obj2)).setMessage((new StringBuilder()).append(((String) (obj))).append("\n").append(obj1).toString());
        ((android.app.AlertDialog.Builder) (obj2)).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final BlueAssistReminderActivity a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
                a.finish();
            }

            
            {
                a = BlueAssistReminderActivity.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj2)).create();
        ((AlertDialog) (obj)).setCancelable(false);
        ((AlertDialog) (obj)).show();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a();
    }
}
