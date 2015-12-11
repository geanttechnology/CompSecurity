// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import net.hockeyapp.android.c.a;
import net.hockeyapp.android.d.d;
import net.hockeyapp.android.e.i;
import net.hockeyapp.android.f.c;

// Referenced classes of package net.hockeyapp.android:
//            x, r, s, t, 
//            u

public class UpdateActivity extends Activity
    implements android.view.View.OnClickListener, x
{

    protected d a;
    protected i b;
    private final int c = 0;
    private a d;
    private Context e;

    public UpdateActivity()
    {
    }

    static a a(UpdateActivity updateactivity)
    {
        updateactivity.d = null;
        return null;
    }

    private String c()
    {
        Object obj;
        try
        {
            obj = getPackageManager();
            obj = ((PackageManager) (obj)).getApplicationLabel(((PackageManager) (obj)).getApplicationInfo(getPackageName(), 0)).toString();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "";
        }
        return ((String) (obj));
    }

    protected final void a()
    {
        a = new d(this, getIntent().getStringExtra("url"), new r(this));
        a.execute(new String[0]);
    }

    public final void b()
    {
        findViewById(4100).setEnabled(true);
    }

    public int getCurrentVersionCode()
    {
        int j;
        try
        {
            j = getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        return j;
    }

    public void onClick(View view)
    {
        boolean flag;
        if (e.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            d = new a();
            d.a = "The permission to access the external storage permission is not set. Please contact the developer.";
            runOnUiThread(new s(this));
            return;
        }
        Object obj = new String[1];
        obj[0] = "value";
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            obj = getContentResolver().query(android.provider.Settings.Global.CONTENT_URI, ((String []) (obj)), "name = ? AND value = ?", new String[] {
                "install_non_market_apps", "1"
            }, null);
        } else
        {
            obj = getContentResolver().query(android.provider.Settings.Secure.CONTENT_URI, ((String []) (obj)), "name = ? AND value = ?", new String[] {
                "install_non_market_apps", "1"
            }, null);
        }
        if (((Cursor) (obj)).getCount() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            d = new a();
            d.a = "The installation from unknown sources is not enabled. Please check the device settings.";
            runOnUiThread(new t(this));
            return;
        } else
        {
            a();
            view.setEnabled(false);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle("App Update");
        setContentView(new c(this));
        e = this;
        b = new i(getIntent().getStringExtra("json"), this);
        ((TextView)findViewById(4098)).setText(c());
        ((TextView)findViewById(4099)).setText((new StringBuilder("Version ")).append(b.a()).append("\n").append(b.b()).toString());
        ((Button)findViewById(4100)).setOnClickListener(this);
        bundle = (WebView)findViewById(4101);
        bundle.clearCache(true);
        bundle.destroyDrawingCache();
        bundle.loadDataWithBaseURL("https://sdk.hockeyapp.net/", b.c(), "text/html", "utf-8", null);
        a = (d)getLastNonConfigurationInstance();
        if (a != null)
        {
            a.a = this;
        }
    }

    protected Dialog onCreateDialog(int j)
    {
        switch (j)
        {
        default:
            return null;

        case 0: // '\0'
            return (new android.app.AlertDialog.Builder(this)).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(0x1080027).setPositiveButton("OK", new u(this)).create();
        }
    }

    protected void onPrepareDialog(int j, Dialog dialog)
    {
        switch (j)
        {
        default:
            return;

        case 0: // '\0'
            dialog = (AlertDialog)dialog;
            break;
        }
        if (d != null)
        {
            dialog.setMessage(d.a);
            return;
        } else
        {
            dialog.setMessage("An unknown error has occured.");
            return;
        }
    }

    public Object onRetainNonConfigurationInstance()
    {
        if (a != null)
        {
            d d1 = a;
            d1.a = null;
            d1.b = null;
        }
        return a;
    }
}
