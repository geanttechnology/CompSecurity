// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.wantu.model.res.TResInfo;

public class awm
{

    Context a;
    TResInfo b;
    atz c;

    public awm(Context context, TResInfo tresinfo)
    {
        a = context;
        b = tresinfo;
        c = new atz(a);
    }

    static Context a(awm awm1)
    {
        return awm1.b();
    }

    static void a(awm awm1, String s, TResInfo tresinfo)
    {
        awm1.a(s, tresinfo);
    }

    private void a(String s, TResInfo tresinfo)
    {
        (new Thread(new awt(this, s, tresinfo))).start();
    }

    private boolean a(TResInfo tresinfo)
    {
        if (tresinfo != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s = if.e(b());
        if (tresinfo.version == null || tresinfo.version.length() <= 0 || s == null) goto _L1; else goto _L3
_L3:
        Log.v("TResinfoDownloadLimit", (new StringBuilder()).append("TResinfoDownloadLimit downloadResInfo version:").append(tresinfo.version).toString());
        Log.v("TResinfoDownloadLimit", (new StringBuilder()).append("TResinfoDownloadLimit client version:").append(s).toString());
        if (bgx.a(tresinfo.version, s)) goto _L1; else goto _L4
_L4:
        Toast.makeText(b(), b().getResources().getString(0x7f06019f), 0).show();
        return true;
        tresinfo;
        Crashlytics.logException(tresinfo);
        return false;
    }

    private Context b()
    {
        return a;
    }

    private boolean b(TResInfo tresinfo)
    {
        boolean flag1 = false;
        Log.v("TResinfoDownloadLimit", (new StringBuilder()).append("TResinfoDownloadLimit isfivestarrated, reviewing :").append(acm.c()).toString());
        boolean flag = flag1;
        if (tresinfo != null)
        {
            flag = flag1;
            if (tresinfo.needReviewing)
            {
                flag = flag1;
                if (!acm.c())
                {
                    flag = true;
                    try
                    {
                        Log.v("TResinfoDownloadLimit", "TResinfoDownloadLimit installed google play store , reviewing");
                        tresinfo = new android.app.AlertDialog.Builder(b());
                        tresinfo.setTitle(b().getResources().getString(0x7f0602ae));
                        tresinfo.setMessage(b().getResources().getString(0x7f060105));
                        tresinfo.setPositiveButton(b().getResources().getString(0x7f0602bd), new awn(this));
                        tresinfo.setNegativeButton(b().getResources().getString(0x7f0600a8), new awo(this));
                        tresinfo.create().show();
                    }
                    // Misplaced declaration of an exception variable
                    catch (TResInfo tresinfo)
                    {
                        Crashlytics.logException(tresinfo);
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private boolean c(TResInfo tresinfo)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (tresinfo.otherAppStoreId != null)
            {
                flag = flag1;
                if (!tresinfo.otherAppStoreId.equalsIgnoreCase("null"))
                {
                    flag = flag1;
                    if (tresinfo.otherAppStoreId.length() > 4)
                    {
                        flag = flag1;
                        if (!yp.a(b(), tresinfo.otherAppStoreId))
                        {
                            Log.v("TResinfoDownloadLimit", (new StringBuilder()).append("TResinfoDownloadLimit google play stroe package name:").append("com.android.vending").toString());
                            Log.v("TResinfoDownloadLimit", (new StringBuilder()).append("TResinfoDownloadLimit otherAppStoreId name:").append(tresinfo.otherAppStoreId).toString());
                            if (("com.android.vending" == null || !yp.a(b(), "com.android.vending")) && !yp.a(b(), "com.qihoo.appstore"))
                            {
                                break label0;
                            }
                            flag = true;
                            Log.v("TResinfoDownloadLimit", "TResinfoDownloadLimit installed google play store , down other App");
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b());
                            builder.setTitle(b().getResources().getString(0x7f0602ae));
                            builder.setMessage(b().getResources().getString(0x7f0600e5));
                            builder.setPositiveButton(b().getResources().getString(0x7f0600e8), new awp(this, tresinfo));
                            builder.setNegativeButton(b().getResources().getString(0x7f0600a8), new awq(this));
                            builder.create().show();
                        }
                    }
                }
            }
            return flag;
        }
        Log.v("TResinfoDownloadLimit", "TResinfoDownloadLimit not installed  google play store or 360");
        return false;
    }

    private boolean d(TResInfo tresinfo)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (tresinfo.needSharing)
        {
            flag = flag1;
            if (tresinfo.wxdlShareInfo != null)
            {
                flag = flag1;
                if (c.b())
                {
                    flag = flag1;
                    if (tresinfo.hasSharedInfo())
                    {
                        Object obj = b().getString(0x7f060256);
                        c = new atz(b().getApplicationContext());
                        String s = ((String) (obj));
                        if (tresinfo.wxdlShareInfo != null)
                        {
                            s = ((String) (obj));
                            if (c.b())
                            {
                                s = b().getString(0x7f060257);
                            }
                        }
                        obj = new android.app.AlertDialog.Builder(b());
                        ((android.app.AlertDialog.Builder) (obj)).setTitle(b().getString(0x7f0602ae));
                        ((android.app.AlertDialog.Builder) (obj)).setMessage(s);
                        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(b().getString(0x7f060255), new awr(this, tresinfo));
                        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(b().getString(0x7f0600a8), new aws(this));
                        ((android.app.AlertDialog.Builder) (obj)).create().show();
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public boolean a()
    {
        if (b != null)
        {
            boolean flag = a(b);
            boolean flag1 = b(b);
            boolean flag2 = c(b);
            boolean flag3 = d(b);
            if (flag || flag1 || flag2 || flag3)
            {
                return true;
            }
        }
        return false;
    }
}
