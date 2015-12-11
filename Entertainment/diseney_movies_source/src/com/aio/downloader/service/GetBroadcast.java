// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.dialog.AnzhuangDialog;
import com.aio.downloader.dialog.UninstallDailog;
import com.aio.downloader.model.AppInstalledEntity;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GetBroadcast extends BroadcastReceiver
{

    private static IntentFilter mIntentFilter;
    private static GetBroadcast mReceiver = new GetBroadcast();
    private final String ACTION_NAME_VER = "wocaonima";
    private final String DOWNLOADINSTALL = "downloadinstall";
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private AnzhuangDialog anzhuangDialog;
    private String appId;
    private android.view.View.OnClickListener itemsOnClick4;
    private String size;
    private UninstallDailog uninstallDailog;

    public GetBroadcast()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    public static void registerReceiver(Context context)
    {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addDataScheme("package");
        mIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        mIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        mIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        context.registerReceiver(mReceiver, mIntentFilter);
    }

    public static void unregisterReceiver(Context context)
    {
        context.unregisterReceiver(mReceiver);
    }

    public AppInstalledEntity getAppInfoByPackageName(String s, Context context)
    {
        PackageInfo packageinfo;
        AppInstalledEntity appinstalledentity;
        appinstalledentity = new AppInstalledEntity();
        packageinfo = null;
        PackageInfo packageinfo1 = context.getPackageManager().getPackageInfo(s, 0);
        packageinfo = packageinfo1;
_L1:
        appinstalledentity.setAppId("1");
        appinstalledentity.setAppname(packageinfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
        String s1 = packageinfo.applicationInfo.publicSourceDir;
        appinstalledentity.setApkpath(s1);
        Log.e("www", (new StringBuilder("ppppppppp=")).append(s1).toString());
        appinstalledentity.setAckageinfo(s);
        appinstalledentity.setIcon(packageinfo.applicationInfo.loadIcon(context.getPackageManager()));
        appinstalledentity.setVersion(String.valueOf(packageinfo.versionName));
        long l = (new File(packageinfo.applicationInfo.publicSourceDir)).length() / 1024L;
        float f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (l >= 1024L)
        {
            appinstalledentity.setSize((new StringBuilder(String.valueOf(f))).append("MB").toString());
            return appinstalledentity;
        } else
        {
            appinstalledentity.setSize((new StringBuilder(String.valueOf(l))).append("KB").toString());
            return appinstalledentity;
        }
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L1
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void onReceive(final Context context, Intent intent)
    {
        String s;
        Object obj;
        s = intent.getDataString().substring(8);
        obj = intent.getAction();
        if (PRO_DIR_FOME.exists()) goto _L2; else goto _L1
_L1:
        intent = context.getAssets();
        Object obj1;
        PRO_DIR.mkdirs();
        intent = intent.open("cleaner.apk");
        obj1 = new File(PRO_DIR, "cleaner.apk");
        byte abyte0[];
        ((File) (obj1)).createNewFile();
        obj1 = new FileOutputStream(((File) (obj1)));
        abyte0 = new byte[1024];
_L7:
        int i = intent.read(abyte0);
        if (i != -1) goto _L4; else goto _L3
_L3:
        ((FileOutputStream) (obj1)).flush();
        intent.close();
        ((FileOutputStream) (obj1)).close();
_L2:
        try
        {
            intent = context.getPackageManager().getPackageInfo(s, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            intent = null;
            namenotfoundexception.printStackTrace();
        }
        if (!"android.intent.action.PACKAGE_ADDED".equals(obj)) goto _L6; else goto _L5
_L5:
        Log.e("www", "PACKAGE_ADDED");
        try
        {
            intent = new Intent("downloadinstall");
            intent.putExtra("appidinstall", s);
            context.sendBroadcast(intent);
            MobclickAgent.onEvent(context, "installsuccess");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        try
        {
            intent = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            intent = null;
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
        }
        if (intent == null)
        {
            try
            {
                intent = getAppInfoByPackageName(s, context);
                appId = intent.getAppname();
                size = intent.getSize();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
            (new Thread() {

                final GetBroadcast this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install");
                }

            
            {
                this$0 = GetBroadcast.this;
                super();
            }
            }).start();
            MobclickAgent.onEvent(context, "Installpop");
            itemsOnClick4 = new android.view.View.OnClickListener() {

                final GetBroadcast this$0;
                private final Context val$context;

                public void onClick(View view)
                {
                    switch (view.getId())
                    {
                    default:
                        return;

                    case 2131165328: 
                        anzhuangDialog.dismiss();
                        return;

                    case 2131165334: 
                        MobclickAgent.onEvent(context, "Installpop_click");
                        break;
                    }
                    (new Thread() {

                        final _cls2 this$1;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click");
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).start();
                    view = null;
                    PackageInfo packageinfo = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                    view = packageinfo;
_L1:
                    android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1;
                    if (view == null)
                    {
                        if (PRO_DIR_FOME.exists())
                        {
                            view = new Intent("android.intent.action.VIEW");
                            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            view.addFlags(0x10000000);
                            context.startActivity(view);
                        } else
                        if (PRO_DIR_TO.exists())
                        {
                            (context. new AsyncTask() {

                                final _cls2 this$1;
                                private final Context val$context;

                                protected volatile transient Object doInBackground(Object aobj[])
                                {
                                    return doInBackground((Void[])aobj);
                                }

                                protected transient Void doInBackground(Void avoid[])
                                {
                                    Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                                    return null;
                                }

                                protected volatile void onPostExecute(Object obj)
                                {
                                    onPostExecute((Void)obj);
                                }

                                protected void onPostExecute(Void void1)
                                {
                                    super.onPostExecute(void1);
                                    void1 = new Intent("android.intent.action.VIEW");
                                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                                    void1.addFlags(0x10000000);
                                    context.startActivity(void1);
                                }

            
            {
                this$1 = final__pcls2;
                context = Context.this;
                super();
            }
                            }).execute(new Void[0]);
                        } else
                        {
                            view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                            view.putExtra("myid", "com.evzapp.cleanmaster");
                            view.addFlags(0x10000000);
                            context.startActivity(view);
                        }
                    } else
                    {
                        view = context.getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                        view.addFlags(0x10000000);
                        context.startActivity(view);
                    }
                    anzhuangDialog.dismiss();
                    return;
                    namenotfoundexception1;
                    namenotfoundexception1.printStackTrace();
                      goto _L1
                }


            
            {
                this$0 = GetBroadcast.this;
                context = context1;
                super();
            }
            };
            anzhuangDialog = new AnzhuangDialog(context, 0x7f0c0010, itemsOnClick4, appId, s, size);
            anzhuangDialog.setCanceledOnTouchOutside(true);
            anzhuangDialog.getWindow().setType(2003);
            (new Handler()).postDelayed(new Runnable() {

                final GetBroadcast this$0;
                private final Context val$context;

                public void run()
                {
                    anzhuangDialog.show();
                    Window window = anzhuangDialog.getWindow();
                    android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
                    window.setGravity(80);
                    layoutparams.width = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getWidth();
                    window.setAttributes(layoutparams);
                }

            
            {
                this$0 = GetBroadcast.this;
                context = context1;
                super();
            }
            }, 5000L);
        }
        return;
_L4:
        ((FileOutputStream) (obj1)).write(abyte0, 0, i);
          goto _L7
        intent;
_L10:
        intent.printStackTrace();
          goto _L2
_L6:
        if (!"android.intent.action.PACKAGE_REMOVED".equals(obj) || s.equals("com.evzapp.cleanmaster") || intent != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            intent = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            intent = null;
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
        }
        if (intent != null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        try
        {
            context.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
        }
        if (!publicTools.tagtanchuang)
        {
            (new Thread() {

                final GetBroadcast this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=uninstall");
                }

            
            {
                this$0 = GetBroadcast.this;
                super();
            }
            }).start();
            MobclickAgent.onEvent(context, "UnInstallpop");
            intent = (new StringBuilder(String.valueOf((int)(Math.random() * 100D + 100D)))).append("kb").toString();
            itemsOnClick4 = new android.view.View.OnClickListener() {

                final GetBroadcast this$0;
                private final Context val$context;

                public void onClick(View view)
                {
                    switch (view.getId())
                    {
                    case 2131165329: 
                    default:
                        return;

                    case 2131165328: 
                        uninstallDailog.dismiss();
                        return;

                    case 2131165330: 
                        MobclickAgent.onEvent(context, "UnInstall_click");
                        break;
                    }
                    (new Thread() {

                        final _cls5 this$1;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=uninstall_click");
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    }).start();
                    view = null;
                    PackageInfo packageinfo = context.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                    view = packageinfo;
_L1:
                    android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1;
                    if (view == null)
                    {
                        if (PRO_DIR_FOME.exists())
                        {
                            view = new Intent("android.intent.action.VIEW");
                            view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            view.addFlags(0x10000000);
                            context.startActivity(view);
                        } else
                        if (PRO_DIR_TO.exists())
                        {
                            (context. new AsyncTask() {

                                final _cls5 this$1;
                                private final Context val$context;

                                protected volatile transient Object doInBackground(Object aobj[])
                                {
                                    return doInBackground((Void[])aobj);
                                }

                                protected transient Void doInBackground(Void avoid[])
                                {
                                    Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                                    return null;
                                }

                                protected volatile void onPostExecute(Object obj)
                                {
                                    onPostExecute((Void)obj);
                                }

                                protected void onPostExecute(Void void1)
                                {
                                    super.onPostExecute(void1);
                                    void1 = new Intent("android.intent.action.VIEW");
                                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                                    void1.addFlags(0x10000000);
                                    context.startActivity(void1);
                                }

            
            {
                this$1 = final__pcls5;
                context = Context.this;
                super();
            }
                            }).execute(new Void[0]);
                        } else
                        {
                            view = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                            view.putExtra("myid", "com.evzapp.cleanmaster");
                            view.addFlags(0x10000000);
                            context.startActivity(view);
                        }
                    } else
                    {
                        view = context.getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                        view.addFlags(0x10000000);
                        context.startActivity(view);
                    }
                    uninstallDailog.dismiss();
                    return;
                    namenotfoundexception1;
                    namenotfoundexception1.printStackTrace();
                      goto _L1
                }


            
            {
                this$0 = GetBroadcast.this;
                context = context1;
                super();
            }
            };
            uninstallDailog = new UninstallDailog(context, 0x7f0c0010, itemsOnClick4, s, intent);
            uninstallDailog.setCanceledOnTouchOutside(true);
            uninstallDailog.getWindow().setType(2003);
            uninstallDailog.show();
            return;
        } else
        {
            break MISSING_BLOCK_LABEL_317;
        }
        if (!"android.intent.action.PACKAGE_REPLACED".equals(obj)) goto _L9; else goto _L8
_L8:
        break MISSING_BLOCK_LABEL_562;
_L9:
        break MISSING_BLOCK_LABEL_317;
        intent = new Intent("wocaonima");
        intent.putExtra("MyUpver", 1);
        context.sendBroadcast(intent);
        return;
        intent;
          goto _L10
    }






}
