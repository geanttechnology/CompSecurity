// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googledrive:
//            UploadInGoogleDriveActivity

public class GoogleAccountPickerActivity extends AppCompatActivity
{

    public GoogleAccountPickerActivity()
    {
    }

    static void a(GoogleAccountPickerActivity googleaccountpickeractivity, String s)
    {
        Intent intent = googleaccountpickeractivity.getIntent();
        intent.putExtra("accountName", s);
        if (intent.getBooleanExtra("fromOpenGoogleDrive", false))
        {
            googleaccountpickeractivity.setResult(-1, intent);
            googleaccountpickeractivity.finish();
        } else
        if (intent.getBooleanExtra("fromUploadGoogleDrive", false))
        {
            intent.setClass(googleaccountpickeractivity, com/socialin/android/googledrive/UploadInGoogleDriveActivity);
            googleaccountpickeractivity.startActivity(intent);
            googleaccountpickeractivity.finish();
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            setResult(-1, intent);
            finish();
            return;
        } else
        {
            setResult(0);
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b7);
        m.a(this).setText(0x7f080602);
        bundle = (ListView)findViewById(0x7f1003db);
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090003);
        Account aaccount[] = AccountManager.get(this).getAccountsByType("com.google");
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            arrayadapter.add(aaccount[i].name);
        }

        bundle.setAdapter(arrayadapter);
        bundle.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private GoogleAccountPickerActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = (String)adapterview.getItemAtPosition(k);
                GoogleAccountPickerActivity.a(a, adapterview);
            }

            
            {
                a = GoogleAccountPickerActivity.this;
                super();
            }
        });
    }
}
