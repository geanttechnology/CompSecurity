// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.wantu.model.res.TResInfo;
import java.net.HttpURLConnection;
import java.net.URL;

public class ub
{

    Context a;
    TResInfo b;
    of c;

    public ub(Context context, TResInfo tresinfo)
    {
        a = context;
        b = tresinfo;
        c = new of(a);
    }

    static Context a(ub ub1)
    {
        return ub1.b();
    }

    private void a(String s, TResInfo tresinfo)
    {
        (new Thread(new Runnable(s, tresinfo) {

            final String a;
            final TResInfo b;
            final ub c;

            public void run()
            {
                Object obj;
                obj = (HttpURLConnection)(new URL(a)).openConnection();
                ((HttpURLConnection) (obj)).setConnectTimeout(8000);
                ((HttpURLConnection) (obj)).setRequestMethod("GET");
                if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                obj = ((HttpURLConnection) (obj)).getInputStream();
                  goto _L3
_L5:
                try
                {
                    obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    Crashlytics.logException(((Throwable) (obj)));
                    return;
                }
                if (obj == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (b.wxdlShareInfo.d != null && b.wxdlShareInfo.d.length() != 0)
                {
                    c.c.a(b.wxdlShareInfo, ((android.graphics.Bitmap) (obj)), true);
                    return;
                }
                if (b.wxdlShareInfo.a != null && b.wxdlShareInfo.a.length() != 0)
                {
                    c.c.b(b.wxdlShareInfo.a);
                    return;
                }
                break; /* Loop/switch isn't completed */
_L2:
                obj = null;
_L3:
                if (obj != null) goto _L5; else goto _L4
_L4:
            }

            
            {
                c = ub.this;
                a = s;
                b = tresinfo;
                super();
            }
        })).start();
    }

    static void a(ub ub1, String s, TResInfo tresinfo)
    {
        ub1.a(s, tresinfo);
    }

    private boolean a(TResInfo tresinfo)
    {
        boolean flag1 = false;
        Log.v("TResinfoDownloadLimitHelpr", (new StringBuilder()).append("TResinfoDownloadLimitHelpr isfivestarrated, reviewing :").append(sb.c()).toString());
        boolean flag = flag1;
        if (tresinfo != null)
        {
            flag = flag1;
            if (tresinfo.needReviewing)
            {
                flag = flag1;
                if (!sb.c())
                {
                    flag = true;
                    try
                    {
                        Log.v("TResinfoDownloadLimitHelpr", "TResinfoDownloadLimitHelpr installed google play store , reviewing");
                        tresinfo = new android.app.AlertDialog.Builder(b());
                        tresinfo.setTitle(b().getResources().getString(0x7f060277));
                        tresinfo.setMessage(b().getResources().getString(0x7f0600f3));
                        tresinfo.setPositiveButton(b().getResources().getString(0x7f060283), new android.content.DialogInterface.OnClickListener() {

                            final ub a;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                try
                                {
                                    dialoginterface = ub.a(a).getPackageName();
                                    ub.a(a).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(dialoginterface).toString())));
                                    sb.b();
                                    return;
                                }
                                // Misplaced declaration of an exception variable
                                catch (DialogInterface dialoginterface)
                                {
                                    Crashlytics.logException(dialoginterface);
                                    return;
                                }
                                // Misplaced declaration of an exception variable
                                catch (DialogInterface dialoginterface)
                                {
                                    Crashlytics.logException(dialoginterface);
                                }
                                sb.a();
                            }

            
            {
                a = ub.this;
                super();
            }
                        });
                        tresinfo.setNegativeButton(b().getResources().getString(0x7f060033), new android.content.DialogInterface.OnClickListener() {

                            final ub a;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                            }

            
            {
                a = ub.this;
                super();
            }
                        });
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

    private Context b()
    {
        return a;
    }

    private boolean b(TResInfo tresinfo)
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
                        if (!ew.a(b(), tresinfo.otherAppStoreId))
                        {
                            Log.v("TResinfoDownloadLimitHelpr", (new StringBuilder()).append("TResinfoDownloadLimitHelpr google play stroe package name:").append("com.android.vending").toString());
                            Log.v("TResinfoDownloadLimitHelpr", (new StringBuilder()).append("TResinfoDownloadLimitHelpr otherAppStoreId name:").append(tresinfo.otherAppStoreId).toString());
                            if (("com.android.vending" == null || !ew.a(b(), "com.android.vending")) && !ew.a(b(), "com.qihoo.appstore"))
                            {
                                break label0;
                            }
                            flag = true;
                            Log.v("TResinfoDownloadLimitHelpr", "TResinfoDownloadLimitHelpr installed google play store , down other App");
                            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b());
                            builder.setTitle(b().getResources().getString(0x7f060277));
                            builder.setMessage(b().getResources().getString(0x7f0600d5));
                            builder.setPositiveButton(b().getResources().getString(0x7f0600d8), new android.content.DialogInterface.OnClickListener(tresinfo) {

                                final TResInfo a;
                                final ub b;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    if (a.dlUrl != null && !a.dlUrl.equalsIgnoreCase(""))
                                    {
                                        dialoginterface = new Intent(ub.a(b), com/fotoable/adbuttonlib/TWebBrowActivity);
                                        dialoginterface.putExtra("webUriString", a.dlUrl);
                                        ub.a(b).startActivity(dialoginterface);
                                        return;
                                    }
                                    try
                                    {
                                        ub.a(b).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(a.otherAppStoreId).toString())));
                                        return;
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (DialogInterface dialoginterface)
                                    {
                                        Crashlytics.logException(dialoginterface);
                                        return;
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (DialogInterface dialoginterface)
                                    {
                                        Crashlytics.logException(dialoginterface);
                                    }
                                    return;
                                }

            
            {
                b = ub.this;
                a = tresinfo;
                super();
            }
                            });
                            builder.setNegativeButton(b().getResources().getString(0x7f060033), new android.content.DialogInterface.OnClickListener() {

                                final ub a;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                }

            
            {
                a = ub.this;
                super();
            }
                            });
                            builder.create().show();
                        }
                    }
                }
            }
            return flag;
        }
        Log.v("TResinfoDownloadLimitHelpr", "TResinfoDownloadLimitHelpr not installed  google play store or 360");
        return false;
    }

    private boolean c(TResInfo tresinfo)
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
                        Object obj = b().getString(0x7f060223);
                        c = new of(b().getApplicationContext());
                        String s = ((String) (obj));
                        if (tresinfo.wxdlShareInfo != null)
                        {
                            s = ((String) (obj));
                            if (c.b())
                            {
                                s = b().getString(0x7f060224);
                            }
                        }
                        obj = new android.app.AlertDialog.Builder(b());
                        ((android.app.AlertDialog.Builder) (obj)).setTitle(b().getString(0x7f060277));
                        ((android.app.AlertDialog.Builder) (obj)).setMessage(s);
                        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(b().getString(0x7f060222), new android.content.DialogInterface.OnClickListener(tresinfo) {

                            final TResInfo a;
                            final ub b;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                kf.c().f = a;
                                if (a.wxdlShareInfo.c != null && a.wxdlShareInfo.c.length() != 0)
                                {
                                    ub.a(b, a.wxdlShareInfo.c, a);
                                } else
                                if (a.wxdlShareInfo.a != null && a.wxdlShareInfo.a.length() != 0)
                                {
                                    b.c.b(a.wxdlShareInfo.a);
                                    return;
                                }
                            }

            
            {
                b = ub.this;
                a = tresinfo;
                super();
            }
                        });
                        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(b().getString(0x7f060033), new android.content.DialogInterface.OnClickListener() {

                            final ub a;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                            }

            
            {
                a = ub.this;
                super();
            }
                        });
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
            if (flag || flag1 || flag2)
            {
                return true;
            }
        }
        return false;
    }
}
