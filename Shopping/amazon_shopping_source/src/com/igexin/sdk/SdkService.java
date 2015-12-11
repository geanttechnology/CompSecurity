// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.igexin.sdk.action.PushMessageAction;
import com.igexin.sdk.bean.PushMessageBean;
import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.data.ConfigDataManager;
import com.igexin.sdk.data.DynamicConfig;
import com.igexin.sdk.data.PhoneInfo;
import com.igexin.sdk.db.DBHelper;
import com.igexin.sdk.util.StringUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// Referenced classes of package com.igexin.sdk:
//            Consts, ActionManager, CallbackListener

public class SdkService extends Service
{
    class ClientIdReceiver extends BroadcastReceiver
    {

        final SdkService this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = new Message();
            context.what = Consts.MESSAGE_RECEIVER_INTERNAL;
            context.obj = intent;
            SdkService.sendMessage(context);
        }

        ClientIdReceiver()
        {
            this$0 = SdkService.this;
            super();
        }
    }

    class InternalReceiver extends BroadcastReceiver
    {

        final SdkService this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = new Message();
            context.what = Consts.MESSAGE_RECEIVER_INTERNAL;
            context.obj = intent;
            SdkService.sendMessage(context);
        }

        InternalReceiver()
        {
            this$0 = SdkService.this;
            super();
        }
    }

    static class MsgLooperThread extends Thread
    {

        private Intent intent;

        public void run()
        {
            Looper.prepare();
            SdkService.getInstance().init();
            if (Consts.VPUSH_APPID != null && Consts.VPUSH_APPKEY != null && Consts.VPUSH_APPSECRET != null)
            {
                SdkService.msgLooperHandler = new MyHandler();
                SdkService.isThreadInit = 1;
                if (intent != null)
                {
                    Message message = new Message();
                    message.what = 11000;
                    message.obj = intent;
                    SdkService.sendMessage(message);
                }
            }
            Looper.loop();
        }

        public MsgLooperThread(Intent intent1)
        {
            intent = intent1;
        }
    }

    static class MyHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            if (message.what == Consts.MESSAGE_RECEIVER_INTERNAL)
            {
                message = (Intent)message.obj;
                SdkService.getInstance().onInternalReceiver(message);
            } else
            if (message.what == 11000)
            {
                SdkService.getInstance().getDynamicConfigAndRegister();
                message = (Intent)message.obj;
                if ("com.igexin.sdk.payloadreceived".equals(message.getAction()))
                {
                    MetricsFactory metricsfactory = SdkService.getInstance().getMetricsFactory();
                    MetricEvent metricevent = metricsfactory.createMetricEvent("MShopAndroidGetuiLib", SdkService.getInstance().getClass().getSimpleName());
                    metricevent.incrementCounter("PUSH:GETUI:MessagesReceived", 1.0D);
                    metricsfactory.record(metricevent);
                    PushMessageAction.getInstance().doPushMessageAction(message);
                    return;
                }
            }
        }

        MyHandler()
        {
        }
    }

    class PackageInstallReceiver extends BroadcastReceiver
    {

        final SdkService this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = new Message();
            context.what = Consts.MESSAGE_RECEIVER_INTERNAL;
            context.obj = intent;
            SdkService.sendMessage(context);
        }

        PackageInstallReceiver()
        {
            this$0 = SdkService.this;
            super();
        }
    }

    class PackageUninstallReceiver extends BroadcastReceiver
    {

        final SdkService this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = new Message();
            context.what = Consts.MESSAGE_RECEIVER_INTERNAL;
            context.obj = intent;
            SdkService.sendMessage(context);
        }

        PackageUninstallReceiver()
        {
            this$0 = SdkService.this;
            super();
        }
    }


    private static SdkService instance = null;
    private static volatile byte isThreadInit = 0;
    public static Handler msgLooperHandler;
    public static String pkgName = null;
    private ActionManager actionMananger;
    private ClientIdReceiver clientIDReceiver;
    private ConnectivityManager connectivityManager;
    private DBHelper dbHelper;
    private InternalReceiver doActionReceiver;
    private MetricsFactory metricsFactory;
    private PackageInstallReceiver packageInstallReceiver;
    private PackageUninstallReceiver packageUninstallReceiver;

    public SdkService()
    {
    }

    private void broadcastToCarrier(int i, String s, String s1)
    {
        Intent intent = new Intent((new StringBuilder()).append("com.igexin.sdk.action.carrier.").append(Consts.VPUSH_APPID).toString());
        intent.putExtra("type", i);
        intent.putExtra(s, s1);
        sendBroadcast(intent);
    }

    private void delDir(File file)
    {
        File afile[] = file.listFiles();
        int j = afile.length;
label0:
        for (int i = 0; i < j; i++)
        {
            File file1 = afile[i];
            do
            {
                if (!file1.exists())
                {
                    continue label0;
                }
                if (file1.isFile())
                {
                    file1.delete();
                } else
                if (!file1.delete())
                {
                    delDir(file1);
                }
            } while (true);
        }

        file.delete();
    }

    private String getCidByPackageName(String s)
    {
        System.out.println((new StringBuilder()).append("cid pkgname = ").append(s).toString());
        return BasicDataManager.getClientid(s);
    }

    private void getDynamicConfigAndRegister()
    {
        if (System.currentTimeMillis() - BasicDataManager.lastGetConfigTime > 0x5265c00L)
        {
            actionMananger.getConfig(new CallbackListener() {

                final SdkService this$0;

                public void exceptionHandler(Exception exception)
                {
                    register();
                }

                public void getCallbackData(Object obj)
                {
                    obj = (DynamicConfig)obj;
                    ConfigDataManager.setEncryptEnable(((DynamicConfig) (obj)).isEncrypt());
                    ConfigDataManager.setDownloadUrl(((DynamicConfig) (obj)).getDownloadUrl());
                    ConfigDataManager.setMasterAppID(((DynamicConfig) (obj)).getMasterAppID());
                    ConfigDataManager.setMasterPkgName(((DynamicConfig) (obj)).getMasterPkgName());
                    ConfigDataManager.setMasterServiceAction(((DynamicConfig) (obj)).getMasterServiceAction());
                    ConfigDataManager.write(((DynamicConfig) (obj)));
                    BasicDataManager.lastGetConfigTime = System.currentTimeMillis();
                    BasicDataManager.updateDBValue(4, "lastGetConfigTime", String.valueOf(BasicDataManager.lastGetConfigTime));
                    initClientIDReceiver();
                    register();
                }

            
            {
                this$0 = SdkService.this;
                super();
            }
            });
            return;
        } else
        {
            register();
            return;
        }
    }

    public static SdkService getInstance()
    {
        return instance;
    }

    private void init()
    {
        connectivityManager = (ConnectivityManager)getSystemService("connectivity");
        pkgName = getPackageName();
        Object obj = getPackageManager().getApplicationInfo(pkgName, 128);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((ApplicationInfo) (obj)).metaData == null) goto _L2; else goto _L3
_L3:
        String s;
        String s1;
        s = ((ApplicationInfo) (obj)).metaData.getString("VPUSH_APPID");
        s1 = ((ApplicationInfo) (obj)).metaData.getString("VPUSH_APPSECRET");
        if (((ApplicationInfo) (obj)).metaData.get("VPUSH_APPKEY") == null) goto _L5; else goto _L4
_L4:
        obj = ((ApplicationInfo) (obj)).metaData.get("VPUSH_APPKEY").toString();
_L6:
        Consts.VPUSH_APPID = s;
        Consts.VPUSH_APPKEY = ((String) (obj));
        Consts.VPUSH_APPSECRET = s1;
        BasicDataManager.loadConfigFromFile();
        dbHelper = new DBHelper(this);
        BasicDataManager.init(this);
        ConfigDataManager.init();
        initDoActionReceiver();
        initPackageInstallReceiver();
        initPackageUninstallReceiver();
        initClientIDReceiver();
        actionMananger = new ActionManager();
        metricsFactory = AndroidMetricsFactoryImpl.getInstance(getApplicationContext());
        if (checkAppInstall(ConfigDataManager.getMasterPkgName()))
        {
            startMasterService();
        }
        return;
_L5:
        obj = null;
        if (true) goto _L6; else goto _L2
_L2:
        try
        {
            stopService();
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        stopService();
        return;
    }

    private void initClientIDReceiver()
    {
        if (clientIDReceiver != null)
        {
            unregisterReceiver(clientIDReceiver);
            clientIDReceiver = null;
        }
        String s = ConfigDataManager.getMasterAppID();
        if (clientIDReceiver == null && s != null && s != "")
        {
            clientIDReceiver = new ClientIdReceiver();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction((new StringBuilder()).append("com.igexin.sdk.action.").append(s).toString());
            registerReceiver(clientIDReceiver, intentfilter);
        }
    }

    private void initDoActionReceiver()
    {
        if (doActionReceiver == null)
        {
            doActionReceiver = new InternalReceiver();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("com.igexin.sdk.action.doaction");
            registerReceiver(doActionReceiver, intentfilter);
        }
    }

    private void initPackageInstallReceiver()
    {
        if (packageInstallReceiver == null)
        {
            packageInstallReceiver = new PackageInstallReceiver();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentfilter.addDataScheme("package");
            registerReceiver(packageInstallReceiver, intentfilter);
        }
    }

    private void initPackageUninstallReceiver()
    {
        if (packageUninstallReceiver == null)
        {
            packageUninstallReceiver = new PackageUninstallReceiver();
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentfilter.addDataScheme("package");
            registerReceiver(packageUninstallReceiver, intentfilter);
        }
    }

    private boolean isAppInstalled(String s, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (((PackageInfo)list.next()).packageName.equals(s))
            {
                return true;
            }
        }

        return false;
    }

    private void onInternalReceiver(Intent intent)
    {
        if (intent == null) goto _L2; else goto _L1
_L1:
        if (!intent.getAction().equals("com.igexin.sdk.action.doaction")) goto _L4; else goto _L3
_L3:
        String s1 = intent.getStringExtra("taskid");
        String s2 = intent.getStringExtra("messageid");
        String s = intent.getStringExtra("actionid");
        if (intent.getStringExtra("accesstoken").equals(BasicDataManager.internalBroadcastAccessToken))
        {
            intent = PushMessageAction.getInstance().getPushMessageCacheId(s1, s2);
            intent = (PushMessageBean)BasicDataManager.pushMessageMap.get(intent);
            PushMessageAction.getInstance().executePushMessageAction(intent, s);
        }
_L2:
        return;
_L4:
        if (!intent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (intent.getDataString().substring(8).equals(ConfigDataManager.getMasterPkgName()))
        {
            startMasterService();
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (!intent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = scanThirdPartCids();
        if (intent != null && intent.size() != 0) goto _L2; else goto _L6
_L6:
        BasicDataManager.lastBindAppTime = 0L;
        BasicDataManager.updateDBValue(3, "lastBindAppTime", String.valueOf(BasicDataManager.lastBindAppTime));
        broadcastToCarrier(2, "url", ConfigDataManager.getDownloadUrl());
        return;
        if (!intent.getAction().equals((new StringBuilder()).append("com.igexin.sdk.action.").append(ConfigDataManager.getMasterAppID()).toString())) goto _L2; else goto _L7
_L7:
        switch (intent.getExtras().getInt("action"))
        {
        default:
            return;

        case 10002: 
            registerNow();
            break;
        }
        return;
    }

    private void register()
    {
        if (System.currentTimeMillis() - BasicDataManager.lastBindAppTime > 0x5265c00L)
        {
            registerNow();
        } else
        {
            broadcastToCarrier(1, "vcid", BasicDataManager.vcid);
        }
        rmDownloadImgCache();
    }

    private void registerNow()
    {
        Object obj1;
        boolean flag;
        boolean flag1;
        obj1 = scanThirdPartCids();
        if (obj1 == null || ((List) (obj1)).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        Collections.sort(((List) (obj1)));
        flag = false;
        flag1 = false;
        String s = StringUtils.getMD5Str(JSONArray.toJSONString(((List) (obj1))));
        if (!s.equals(BasicDataManager.lastCidLists))
        {
            flag = true;
            BasicDataManager.lastCidLists = s;
            BasicDataManager.updateDBValue(5, "lastCidLists", s);
        }
        if (((List) (obj1)).size() > 3) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
_L4:
        obj1 = StringUtils.getMD5Str(JSONObject.toJSONString(BasicDataManager.phoneInfo.getJsonMap()));
        if (!((String) (obj1)).equals(BasicDataManager.lastPhoneInfo))
        {
            flag1 = true;
            BasicDataManager.lastPhoneInfo = ((String) (obj1));
            BasicDataManager.updateDBValue(6, "lastPhoneInfo", ((String) (obj1)));
        }
        if (obj != null)
        {
            actionMananger.register(((List) (obj)), flag, flag1, new CallbackListener() {

                final SdkService this$0;

                public void exceptionHandler(Exception exception)
                {
                }

                public void getCallbackData(Object obj2)
                {
                    obj2 = (String)obj2;
                    BasicDataManager.vcid = ((String) (obj2));
                    BasicDataManager.updateVcidValue(1, "vcid", ((String) (obj2)));
                    BasicDataManager.lastBindAppTime = System.currentTimeMillis();
                    BasicDataManager.updateDBValue(3, "lastBindAppTime", String.valueOf(BasicDataManager.lastBindAppTime));
                    broadcastToCarrier(1, "vcid", ((String) (obj2)));
                    BasicDataManager.saveVcidToFile(((String) (obj2)));
                }

            
            {
                this$0 = SdkService.this;
                super();
            }
            });
        }
_L6:
        return;
_L2:
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L5:
        obj = arraylist;
        if (i >= 3) goto _L4; else goto _L3
_L3:
        arraylist.add(((List) (obj1)).get(i));
        i++;
          goto _L5
        if (ConfigDataManager.getDownloadUrl() != null)
        {
            String s1 = ConfigDataManager.getMasterAppID();
            String s2 = ConfigDataManager.getMasterPkgName();
            System.out.println((new StringBuilder()).append("Download MasterSDK MasterAppID = ").append(s1).append(" MasterPkgName = ").append(s2).toString());
            if (checkAppInstall(s2))
            {
                startMasterService();
                return;
            } else
            {
                broadcastToCarrier(2, "url", ConfigDataManager.getDownloadUrl());
                return;
            }
        }
          goto _L6
    }

    private void rmDownloadImgCache()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        long l;
        l = System.currentTimeMillis();
        obj3 = null;
        obj2 = null;
        obj1 = obj2;
        obj = obj3;
        DBHelper dbhelper = getInstance().dbHelper;
        obj1 = obj2;
        obj = obj3;
        String s = (new StringBuilder()).append("createtime < '").append(l - 0x240c8400L).append("'").toString();
        obj1 = obj2;
        obj = obj3;
        obj2 = dbhelper.query("image", new String[] {
            "taskid"
        }, s, null, "taskid", null, null);
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        obj1 = obj2;
        obj = obj2;
        if (!((Cursor) (obj2)).moveToNext()) goto _L2; else goto _L3
_L3:
        obj1 = obj2;
        obj = obj2;
        obj3 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndexOrThrow("taskid"));
        obj1 = obj2;
        obj = obj2;
        getInstance().dbHelper.delete("image", new String[] {
            "taskid"
        }, new String[] {
            obj3
        });
        obj1 = obj2;
        obj = obj2;
        obj3 = new File((new StringBuilder()).append(Consts.IMGPATHDIR).append(((String) (obj3))).toString());
        obj1 = obj2;
        obj = obj2;
        if (!((File) (obj3)).exists()) goto _L1; else goto _L4
_L4:
        obj1 = obj2;
        obj = obj2;
        delDir(((File) (obj3)));
          goto _L1
        obj2;
        obj = obj1;
        ((Exception) (obj2)).printStackTrace();
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
_L6:
        return;
_L2:
        if (obj2 == null) goto _L6; else goto _L5
_L5:
        ((Cursor) (obj2)).close();
        return;
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
    }

    public static void sendMessage(Message message)
    {
        if (msgLooperHandler != null)
        {
            msgLooperHandler.sendMessage(message);
        }
    }

    private void startMasterService()
    {
        String s = getApplicationContext().getPackageName();
        Intent intent = new Intent(ConfigDataManager.getMasterServiceAction());
        intent.putExtra("appid", ConfigDataManager.getMasterAppID());
        intent.putExtra("action", "com.igexin.action.initialize");
        intent.putExtra("op_app", s);
        intent.putExtra("isSlave", true);
        startService(intent);
    }

    public boolean checkAppInstall(String s)
    {
        if (s != null && !s.equals(""))
        {
            Iterator iterator = getPackageManager().getInstalledPackages(0).iterator();
            while (iterator.hasNext()) 
            {
                if (((PackageInfo)iterator.next()).packageName.equals(s))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAppLauncher(String s)
    {
        boolean flag1 = false;
        Object obj = new Intent("android.intent.action.MAIN", null);
        ((Intent) (obj)).addCategory("android.intent.category.LAUNCHER");
        obj = getPackageManager().queryIntentActivities(((Intent) (obj)), 0).iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (!((ResolveInfo)((Iterator) (obj)).next()).activityInfo.packageName.equals(s))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    public DBHelper getDBHelper()
    {
        return dbHelper;
    }

    public String getDownloadImgCache(String s)
    {
        String s1;
        String s2;
        Cursor cursor;
        Cursor cursor1;
        s2 = "";
        cursor1 = null;
        cursor = null;
        dbHelper = getDBHelper();
        s1 = s2;
        Cursor cursor2 = dbHelper.query("image", new String[] {
            "imageurl"
        }, new String[] {
            s
        }, null, null);
        String s3 = s2;
        if (cursor2 == null) goto _L2; else goto _L1
_L1:
        cursor = cursor2;
        s1 = s2;
        s3 = s2;
        cursor1 = cursor2;
        if (!cursor2.moveToNext()) goto _L2; else goto _L3
_L3:
        cursor = cursor2;
        s1 = s2;
        cursor1 = cursor2;
        s3 = cursor2.getString(cursor2.getColumnIndexOrThrow("imagesrc"));
        s2 = s3;
        cursor = cursor2;
        s1 = s3;
        cursor1 = cursor2;
        if ((new File(s3)).exists()) goto _L1; else goto _L4
_L4:
        s2 = "";
        cursor = cursor2;
        s1 = s2;
        cursor1 = cursor2;
        dbHelper.delete("image", new String[] {
            "imageurl"
        }, new String[] {
            s
        });
          goto _L1
        s;
        cursor1 = cursor;
        s.printStackTrace();
        s = s1;
        if (cursor != null)
        {
            cursor.close();
            s = s1;
        }
_L6:
        return s;
_L2:
        s = s3;
        if (cursor2 == null) goto _L6; else goto _L5
_L5:
        cursor2.close();
        return s3;
        s;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw s;
    }

    public MetricsFactory getMetricsFactory()
    {
        return metricsFactory;
    }

    public String getNetworkType()
    {
        NetworkInfo networkinfo;
        if (connectivityManager != null)
        {
            if ((networkinfo = connectivityManager.getActiveNetworkInfo()) != null)
            {
                if (networkinfo.getType() == 1)
                {
                    return "wifi";
                }
                if (networkinfo.getType() == 0)
                {
                    return "mobile";
                }
            }
        }
        return null;
    }

    public boolean isSdkActivitySet()
    {
        String s = getApplicationContext().getPackageName();
        ActivityInfo aactivityinfo[] = getPackageManager().getPackageInfo(s, 1).activities;
        if (aactivityinfo == null) goto _L2; else goto _L1
_L1:
        int j = aactivityinfo.length;
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = aactivityinfo[i].name.indexOf("SdkActivity");
        if (k != -1)
        {
            return true;
        }
        i++;
        if (true) goto _L3; else goto _L2
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
_L2:
        return false;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        instance = this;
    }

    public void onDestroy()
    {
        if (dbHelper != null)
        {
            dbHelper.close();
        }
        if (doActionReceiver != null)
        {
            unregisterReceiver(doActionReceiver);
        }
        if (packageInstallReceiver != null)
        {
            unregisterReceiver(packageInstallReceiver);
        }
        if (clientIDReceiver != null)
        {
            unregisterReceiver(clientIDReceiver);
        }
        if (packageUninstallReceiver != null)
        {
            unregisterReceiver(packageUninstallReceiver);
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (isThreadInit == 1 && intent != null)
        {
            Message message = new Message();
            message.what = 11000;
            message.obj = intent;
            sendMessage(message);
            return 1;
        } else
        {
            (new MsgLooperThread(intent)).start();
            return 1;
        }
    }

    public List scanThirdPartCids()
    {
        Object obj;
label0:
        {
            if (Environment.getExternalStorageState().equals("mounted"))
            {
                obj = Environment.getExternalStorageDirectory().getAbsolutePath();
                obj = (new StringBuilder()).append(((String) (obj))).append("/libs").toString();
                System.out.println((new StringBuilder()).append("libsDir = ").append(((String) (obj))).toString());
                obj = new File(((String) (obj)));
                if (((File) (obj)).exists())
                {
                    String as[] = ((File) (obj)).list(new FilenameFilter() {

                        final SdkService this$0;

                        public boolean accept(File file, String s1)
                        {
                            return s1.endsWith(".db");
                        }

            
            {
                this$0 = SdkService.this;
                super();
            }
                    });
                    if (as != null)
                    {
                        List list = getPackageManager().getInstalledPackages(0);
                        ArrayList arraylist = new ArrayList();
                        int j = as.length;
                        int i = 0;
                        do
                        {
                            obj = arraylist;
                            if (i >= j)
                            {
                                break;
                            }
                            String s = as[i];
                            obj = s.substring(0, s.indexOf(".db"));
                            if (isAppInstalled(((String) (obj)), list))
                            {
                                s = getCidByPackageName(s);
                                if (s != null)
                                {
                                    System.out.println((new StringBuilder()).append(((String) (obj))).append(":").append(s).toString());
                                    arraylist.add(s);
                                }
                            }
                            i++;
                        } while (true);
                        break label0;
                    }
                }
            }
            obj = null;
        }
        return ((List) (obj));
    }

    public void stopService()
    {
        stopSelf();
    }







/*
    static byte access$402(byte byte0)
    {
        isThreadInit = byte0;
        return byte0;
    }

*/


}
