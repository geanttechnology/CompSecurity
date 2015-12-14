// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

public class bcn
{

    Context a;
    TPhotoComposeInfo b;
    atz c;

    public bcn(Context context, TPhotoComposeInfo tphotocomposeinfo)
    {
        a = context;
        b = tphotocomposeinfo;
        c = new atz(a);
    }

    static Context a(bcn bcn1)
    {
        return bcn1.b();
    }

    static void a(bcn bcn1, String s, TPhotoComposeInfo tphotocomposeinfo)
    {
        bcn1.a(s, tphotocomposeinfo);
    }

    private void a(String s, TPhotoComposeInfo tphotocomposeinfo)
    {
        (new Thread(new bcu(this, s, tphotocomposeinfo))).start();
    }

    private boolean a(TPhotoComposeInfo tphotocomposeinfo)
    {
        if (tphotocomposeinfo != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s = if.e(b());
        if (tphotocomposeinfo.version == null || tphotocomposeinfo.version.length() <= 0 || s == null) goto _L1; else goto _L3
_L3:
        Log.v("TMagDownloadLimitHelpr", (new StringBuilder()).append("TMagDownloadLimitHelpr downloadResInfo version:").append(tphotocomposeinfo.version).toString());
        Log.v("TMagDownloadLimitHelpr", (new StringBuilder()).append("TMagDownloadLimitHelpr client version:").append(s).toString());
        if (bgx.a(tphotocomposeinfo.version, s)) goto _L1; else goto _L4
_L4:
        Toast.makeText(b(), b().getResources().getString(0x7f06019f), 0).show();
        return true;
        tphotocomposeinfo;
        Crashlytics.logException(tphotocomposeinfo);
        return false;
    }

    private Context b()
    {
        return a;
    }

    private boolean b(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (tphotocomposeinfo != null)
        {
            flag = flag1;
            if (tphotocomposeinfo.needReviewing)
            {
                flag = flag1;
                if (!acm.c())
                {
                    flag = true;
                    try
                    {
                        Log.v("TMagDownloadLimitHelpr", "TMagDownloadLimitHelpr installed google play store , reviewing");
                        tphotocomposeinfo = new android.app.AlertDialog.Builder(b());
                        tphotocomposeinfo.setTitle(b().getResources().getString(0x7f0602ae));
                        tphotocomposeinfo.setMessage(b().getResources().getString(0x7f060105));
                        tphotocomposeinfo.setPositiveButton(b().getResources().getString(0x7f0602bd), new bco(this));
                        tphotocomposeinfo.setNegativeButton(b().getResources().getString(0x7f0600a8), new bcp(this));
                        tphotocomposeinfo.create().show();
                    }
                    // Misplaced declaration of an exception variable
                    catch (TPhotoComposeInfo tphotocomposeinfo)
                    {
                        Crashlytics.logException(tphotocomposeinfo);
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private boolean c(TPhotoComposeInfo tphotocomposeinfo)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (tphotocomposeinfo.otherAppStoreId != null)
            {
                flag = flag1;
                if (!tphotocomposeinfo.otherAppStoreId.equalsIgnoreCase("null"))
                {
                    flag = flag1;
                    if (tphotocomposeinfo.otherAppStoreId.length() > 4)
                    {
                        flag = flag1;
                        if (!yp.a(b(), tphotocomposeinfo.otherAppStoreId))
                        {
                            Log.v("TMagDownloadLimitHelpr", (new StringBuilder()).append("TMagDownloadLimitHelpr google play stroe package name:").append("com.android.vending").toString());
                            Log.v("TMagDownloadLimitHelpr", (new StringBuilder()).append("TMagDownloadLimitHelpr otherAppStoreId name:").append(tphotocomposeinfo.otherAppStoreId).toString());
                            if (("com.android.vending" == null || !yp.a(b(), "com.android.vending")) && !yp.a(b(), "com.qihoo.appstore"))
                            {
                                break label0;
                            }
                            flag = true;
                            Log.v("TMagDownloadLimitHelpr", "TMagDownloadLimitHelpr installed google play store , down other App");
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b());
                            builder.setTitle(b().getResources().getString(0x7f0602ae));
                            builder.setMessage(b().getResources().getString(0x7f0600e5));
                            builder.setPositiveButton(b().getResources().getString(0x7f0600e8), new bcq(this, tphotocomposeinfo));
                            builder.setNegativeButton(b().getResources().getString(0x7f0600a8), new bcr(this));
                            builder.create().show();
                        }
                    }
                }
            }
            return flag;
        }
        Log.v("TMagDownloadLimitHelpr", "TMagDownloadLimitHelpr not installed  google play store or 360");
        return false;
    }

    private boolean d(TPhotoComposeInfo tphotocomposeinfo)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (tphotocomposeinfo.needSharing)
        {
            flag = flag1;
            if (tphotocomposeinfo.wxdlShareInfo != null)
            {
                flag = flag1;
                if (c.b())
                {
                    flag = flag1;
                    if (!tphotocomposeinfo.hasSharedInfo())
                    {
                        Object obj = b().getString(0x7f060256);
                        c = new atz(b().getApplicationContext());
                        String s = ((String) (obj));
                        if (tphotocomposeinfo.wxdlShareInfo != null)
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
                        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(b().getString(0x7f060255), new bcs(this, tphotocomposeinfo));
                        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(b().getString(0x7f0600a8), new bct(this));
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
