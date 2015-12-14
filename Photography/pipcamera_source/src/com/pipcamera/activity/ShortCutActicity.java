// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.PrintStream;

public class ShortCutActicity extends Activity
{

    public ShortCutActicity()
    {
    }

    public void a(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public boolean a(String s)
    {
        try
        {
            s = getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            s = null;
        }
        return s != null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002a);
        Log.i("com.pipcamera.acitivity", "inatamag shortcut clicked.");
        if (a("com.instamag.activity"))
        {
            bundle = getPackageManager();
            new Intent();
            bundle = bundle.getLaunchIntentForPackage("com.instamag.activity");
            if (bundle == null)
            {
                System.out.println("APP not found!");
            }
            startActivity(bundle);
            finish();
            return;
        }
        bundle = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Download/").toString();
        bundle = new File((new StringBuilder()).append(bundle).append("instamag_test.apk").toString());
        if (bundle.exists())
        {
            a(bundle);
        } else
        {
            bundle = new Intent("android.intent.action.VIEW", Uri.parse("http://ad.apps.fm/FYCH_Ql5N3baAzIds6TQga5px440Px0vtrw1ww5B54z_bcrsCgDc_LYJQVS16x9EotKI15I8WBRk1y34AVTmMXTjc5sfHHKf0iohB9rbkG3QQFtvGmGm78YegHkNWCxf"));
            try
            {
                startActivity(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                Crashlytics.logException(bundle);
            }
        }
        finish();
    }
}
