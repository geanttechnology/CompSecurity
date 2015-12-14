// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.x;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.pages.b.a;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.utility.bc;
import com.cyberlink.youcammakeup.utility.be;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import com.cyberlink.youcammakeup.widgetpool.a.b;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.pf.common.restart.RestartService;
import com.pf.common.utility.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            s, t, r, GpuBenchmarkActivity, 
//            OpeningTutorialActivity, LauncherActivity, EditViewActivity, CameraActivity, 
//            CameraLandscapeActivity, MoreActivity, MoreMakeupActivity, ExtraDownloadActivity, 
//            NoticeActivity, FacebookFriendPickerActivity, FacebookPlacePickerActivity, FacebookSharingActivity, 
//            VideoPlaybackActivity, BeautyTipFilmActivity, BeautyTipCategoryActivity, SponsorAdActivity, 
//            LibraryPickerActivity, SettingActivity, AboutActivity, WebViewerExActivity, 
//            WeekStarActivity

public class SplashActivity extends Activity
{

    private int a;
    private Boolean b;
    private s c;
    private Integer d;
    private Runnable e;

    public SplashActivity()
    {
        a = 1500;
        b = Boolean.valueOf(false);
        d = null;
        e = new Runnable() {

            final SplashActivity a;

            public void run()
            {
                Intent intent1 = null;
                String s1 = Globals.d().v();
                Intent intent;
                if (!z.a("HAD_RUN_GPU_BENCHMARK", false, Globals.d()))
                {
                    intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/GpuBenchmarkActivity);
                } else
                {
                    intent = intent1;
                    if (s1 != null)
                    {
                        if (!Globals.d().N().equals("") || s1.equals(""))
                        {
                            a.finish();
                            return;
                        }
                        if (s1.equals("launcher"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
                        } else
                        if (s1.equals("editView"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/EditViewActivity);
                        } else
                        if (s1.equals("cameraView"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
                        } else
                        if (s1.equals("cameraLandscapeView"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
                        } else
                        if (s1.equals("morePage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreActivity);
                        } else
                        if (s1.equals("makeupCategoryActivity"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity);
                        } else
                        if (s1.equals("extraDownloadPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
                        } else
                        if (s1.equals("noticePage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/NoticeActivity);
                        } else
                        if (s1.equals("facebookFriendPickerPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookFriendPickerActivity);
                        } else
                        if (s1.equals("facebookPlacePickerPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookPlacePickerActivity);
                        } else
                        if (s1.equals("facebookSharingPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/FacebookSharingActivity);
                        } else
                        if (s1.equals("videoPlaybackPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/VideoPlaybackActivity);
                        } else
                        if (s1.equals("beautyTipFilmActivity"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipFilmActivity);
                        } else
                        if (s1.equals("beautyTipCategoryActivity"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipCategoryActivity);
                        } else
                        if (s1.equals("sponsorAdActivity"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SponsorAdActivity);
                        } else
                        if (s1.equals("libraryView"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
                        } else
                        if (s1.equals("settingPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SettingActivity);
                        } else
                        if (s1.equals("aboutPage"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/AboutActivity);
                        } else
                        if (s1.equals("webViewerExActivity"))
                        {
                            intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                        } else
                        {
                            intent = intent1;
                            if (s1.equals("weekStar"))
                            {
                                intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WeekStarActivity);
                            }
                        }
                    }
                }
                intent1 = intent;
                if (intent == null)
                {
                    if (!z.a("HAD_SHOWN_OPENING_TUTORIAL_V4.13.0", false, a.getApplicationContext()))
                    {
                        intent1 = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/OpeningTutorialActivity);
                    } else
                    {
                        intent1 = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
                    }
                }
                intent1.putExtra("RestartService.reason", RestartService.a(a.getIntent()));
                a.startActivity(intent1);
                a.finish();
            }

            
            {
                a = SplashActivity.this;
                super();
            }
        };
    }

    static s a(SplashActivity splashactivity)
    {
        return splashactivity.c;
    }

    public static boolean a()
    {
        for (String s1 = z.b("KEY_CURRENT_APP_VERSION_FOR_SAMPLE_IMAGE", "", Globals.d()); !com.cyberlink.youcammakeup.widgetpool.a.b.a().b().equalsIgnoreCase(s1) || !z.a("KEY_SAMPLE_IMAGE_COPIED", false, Globals.d());)
        {
            return true;
        }

        return false;
    }

    public static void b()
    {
        z.a("KEY_CURRENT_APP_VERSION_FOR_SAMPLE_IMAGE", com.cyberlink.youcammakeup.widgetpool.a.b.a().b(), Globals.d());
        z.a("KEY_SAMPLE_IMAGE_COPIED", Boolean.valueOf(true), Globals.d());
    }

    static void b(SplashActivity splashactivity)
    {
        splashactivity.e();
    }

    public static void c()
    {
        File file = new File(Exporter.g());
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        try
        {
            as = be.a;
        }
        catch (Exception exception)
        {
            m.b("SplashActivity", "removeSampleFile failed.", exception);
            return;
        }
        if (as == null) goto _L4; else goto _L3
_L3:
        i = 0;
_L8:
        if (i >= as.length) goto _L4; else goto _L5
_L5:
        File file1 = new File((new StringBuilder()).append(file).append(File.separator).append(as[i]).toString());
        if (file1.exists() && file1.isFile())
        {
            Exporter.a(Globals.d().getContentResolver(), file1);
        }
          goto _L6
_L4:
        m.b("SplashActivity", "Sample file removed");
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void d()
    {
        Object obj;
        int i;
        AssetManager assetmanager = Globals.d().getAssets();
        if (assetmanager != null);
        String as[];
        File file;
        String as1[];
        File file1;
        Object obj1;
        FileOutputStream fileoutputstream;
        try
        {
            file = new File(Exporter.g());
            if (!file.exists() && !file.mkdirs())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            return;
        }
        as1 = be.a;
        if (as1 == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L7:
        if (i >= as1.length) goto _L4; else goto _L3
_L3:
        as = as1[i].split("\\.");
        if (as.length <= 1)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        obj = as[as.length - 1];
_L8:
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (((String) (obj)).equals("jpg") || ((String) (obj)).equals("JPG"))
        {
            obj1 = (new StringBuilder()).append("sample").append(File.separator).append(as1[i]).toString();
            obj = (new StringBuilder()).append(file).append(File.separator).append(as1[i]).toString();
            file1 = new File(((String) (obj)));
            obj1 = assetmanager.open(((String) (obj1)));
            fileoutputstream = new FileOutputStream(file1);
            bb.a(((InputStream) (obj1)), fileoutputstream);
            (new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE")).setData(Uri.fromFile(file1));
            Exporter.a(((String) (obj)));
            ((InputStream) (obj1)).close();
            fileoutputstream.flush();
            fileoutputstream.close();
            obj = be.b(((String) (obj)));
            z.a(as1[i], ((String) (obj)), Globals.d().getApplicationContext());
            be.a(as1[i], ((String) (obj)));
        }
          goto _L6
_L4:
        if (as1.length != 0);
_L2:
        b();
        return;
_L6:
        i++;
          goto _L7
        obj = null;
          goto _L8
    }

    private void e()
    {
        while (b.booleanValue() || !c.a()) 
        {
            return;
        }
        b = Boolean.valueOf(true);
        int i = (int)System.nanoTime();
        i = a - (i - d.intValue()) / 0xf4240;
        if (i > 0)
        {
            (new Handler()).postDelayed(e, i);
            return;
        } else
        {
            (new Handler()).post(e);
            return;
        }
    }

    private void f()
    {
        com.cyberlink.youcammakeup.pages.b.a.a().b();
        (new AsyncTask() {

            final SplashActivity a;

            protected transient Void a(Void avoid[])
            {
                if (!Globals.d().f().a().booleanValue());
                return null;
            }

            protected void a(Void void1)
            {
                com.cyberlink.youcammakeup.activity.SplashActivity.a(a).d = Boolean.valueOf(true);
                com.cyberlink.youcammakeup.activity.SplashActivity.b(a);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = SplashActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        (new AsyncTask() {

            final SplashActivity a;

            protected transient Void a(Void avoid[])
            {
                ViewEngine.a();
                return null;
            }

            protected void a(Void void1)
            {
                com.cyberlink.youcammakeup.activity.SplashActivity.a(a).b = Boolean.valueOf(true);
                com.cyberlink.youcammakeup.activity.SplashActivity.b(a);
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = SplashActivity.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        float f1;
        if (a())
        {
            (new t(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            c.c = Boolean.valueOf(true);
            e();
        }
        f1 = bo.c();
        com.cyberlink.youcammakeup.h.a();
        if (bo.b())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.b(new bu(f1) {

                final float a;
                final SplashActivity b;

                public void a(List list)
                {
                    z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                    com.cyberlink.youcammakeup.activity.SplashActivity.a(b).a = Boolean.valueOf(true);
                    com.cyberlink.youcammakeup.activity.SplashActivity.b(b);
                }

            
            {
                b = SplashActivity.this;
                a = f1;
                super();
            }
            });
        } else
        if (z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) != f1 || bo.a())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.a(new bu(f1) {

                final float a;
                final SplashActivity b;

                public void a(List list)
                {
                    bo.u();
                    if (bo.a())
                    {
                        bo.b(new bu(this) {

                            final _cls5 a;

                            public void a(List list)
                            {
                                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, a.b);
                                com.cyberlink.youcammakeup.activity.SplashActivity.a(a.b).a = Boolean.valueOf(true);
                                com.cyberlink.youcammakeup.activity.SplashActivity.b(a.b);
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                        return;
                    } else
                    {
                        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                        com.cyberlink.youcammakeup.activity.SplashActivity.a(b).a = Boolean.valueOf(true);
                        com.cyberlink.youcammakeup.activity.SplashActivity.b(b);
                        return;
                    }
                }

            
            {
                b = SplashActivity.this;
                a = f1;
                super();
            }
            });
        } else
        {
            c.a = Boolean.valueOf(true);
            e();
        }
        if (!z.j())
        {
            (new r(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            c.e = Boolean.valueOf(true);
            e();
        }
        h();
    }

    private boolean g()
    {
        boolean flag1 = com.cyberlink.youcammakeup.jniproxy.m.b();
        boolean flag2 = com.cyberlink.youcammakeup.jniproxy.m.c();
        Object obj;
        boolean flag;
        if (flag1 && !flag2)
        {
            obj = (new StringBuilder()).append(getString(0x7f070063)).append(" [001]").toString();
            flag = true;
        } else
        if (Globals.U())
        {
            obj = (new StringBuilder()).append(getString(0x7f070064)).append(" [002]").toString();
            flag = false;
        } else
        if (!Globals.V())
        {
            obj = (new StringBuilder()).append(getString(0x7f070065)).append(" [003]").toString();
            flag = false;
        } else
        {
            obj = null;
            flag = false;
        }
        if (obj != null)
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new x(((String) (obj)), flag1, flag2));
        }
        if (obj != null && flag)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle(getString(0x7f0700ab));
            builder.setMessage(((CharSequence) (obj)));
            obj = builder.create();
            ((AlertDialog) (obj)).show();
            (new Handler()).postDelayed(new Runnable(((AlertDialog) (obj))) {

                final AlertDialog a;
                final SplashActivity b;

                public void run()
                {
                    if (a != null && a.isShowing())
                    {
                        a.dismiss();
                    }
                    b.finish();
                }

            
            {
                b = SplashActivity.this;
                a = alertdialog;
                super();
            }
            }, 3000L);
            return false;
        } else
        {
            return true;
        }
    }

    private void h()
    {
        if (!Boolean.parseBoolean(getApplicationContext().getString(0x7f070739)))
        {
            c.f = Boolean.valueOf(true);
            e();
        } else
        {
            Object obj = z.e(getApplicationContext(), "");
            if (!((String) (obj)).equals(""))
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(((String) (obj)));
                c.f = Boolean.valueOf(true);
                e();
                return;
            }
            com.cyberlink.youcammakeup.kernelctrl.sku.h.b().e();
            obj = new EditText(this);
            ((EditText) (obj)).setSingleLine(true);
            ((EditText) (obj)).setSelectAllOnFocus(true);
            obj = (new android.app.AlertDialog.Builder(this, 0x7f0a022f)).setTitle("Input secretIds").setView(((View) (obj))).setPositiveButton(0x7f0703fd, new android.content.DialogInterface.OnClickListener(((EditText) (obj))) {

                final EditText a;
                final SplashActivity b;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    Editable editable = a.getText();
                    com.cyberlink.youcammakeup.kernelctrl.sku.h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.h.b();
                    if (editable.length() > 0)
                    {
                        dialoginterface = editable.toString();
                    } else
                    {
                        dialoginterface = "none";
                    }
                    h1.a(dialoginterface);
                    if (editable.length() > 0)
                    {
                        z.d(b.getApplicationContext(), editable.toString());
                    }
                    com.cyberlink.youcammakeup.activity.SplashActivity.a(b).f = Boolean.valueOf(true);
                    com.cyberlink.youcammakeup.activity.SplashActivity.b(b);
                }

            
            {
                b = SplashActivity.this;
                a = edittext;
                super();
            }
            }).setNegativeButton(0x7f0703fa, new android.content.DialogInterface.OnClickListener() {

                final SplashActivity a;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a("none");
                    com.cyberlink.youcammakeup.activity.SplashActivity.a(a).f = Boolean.valueOf(true);
                    com.cyberlink.youcammakeup.activity.SplashActivity.b(a);
                }

            
            {
                a = SplashActivity.this;
                super();
            }
            }).create();
            Object obj1 = ((AlertDialog) (obj)).getWindow();
            Object obj2 = ((Window) (obj1)).getAttributes();
            obj2.gravity = 80;
            ((Window) (obj1)).setAttributes(((android.view.WindowManager.LayoutParams) (obj2)));
            ((Window) (obj1)).setSoftInputMode(5);
            ((AlertDialog) (obj)).show();
            int i = Color.parseColor("#A186C4");
            obj1 = ((AlertDialog) (obj)).getContext().getResources();
            obj2 = ((AlertDialog) (obj)).findViewById(((Resources) (obj1)).getIdentifier("android:id/titleDivider", null, null));
            if (obj2 != null)
            {
                ((View) (obj2)).setBackgroundColor(i);
            }
            obj = (TextView)((AlertDialog) (obj)).findViewById(((Resources) (obj1)).getIdentifier("android:id/alertTitle", null, null));
            if (obj != null)
            {
                ((TextView) (obj)).setTextColor(i);
                return;
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030199);
        if (Globals.d().c() == com.cyberlink.youcammakeup.Globals.STORE_NAME.c)
        {
            findViewById(0x7f0c012c).setVisibility(0);
        }
        if (!g())
        {
            return;
        }
        c = new s(this);
        d = Integer.valueOf((int)System.nanoTime());
        b = Boolean.valueOf(false);
        if (getIntent().getBooleanExtra(getResources().getString(0x7f0707b8), false))
        {
            Globals.d("");
            Globals.d().c("launcher");
        }
        bundle = Globals.d().v();
        if (bundle == null || bundle != null && bundle.equals("libraryView"))
        {
            StatusManager.j().G();
            BeautifierEditCenter.a().b();
            MotionControlHelper.e().u();
            MotionControlHelper.e().av();
            VenusHelper.a().F();
            f();
        } else
        {
            a = 0;
            (new Handler()).post(e);
        }
        BeautifierManager.a();
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
