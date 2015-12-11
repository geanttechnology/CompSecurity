// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.activity.AppRecommendKeywordsActivity;
import com.aio.downloader.activity.FunActivity1;
import com.aio.downloader.activity.TodaysPickActivity;
import com.aio.downloader.start.MainActivity;
import com.aio.downloader.utils.Myutils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.jpush:
//            JpushMainActivity

public class MyReceiver extends BroadcastReceiver
{

    private static final String TAG = "JPush";
    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Context mContext;

    public MyReceiver()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
    }

    private static String printBundle(Bundle bundle)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return stringbuilder.toString();
            }
            String s = (String)iterator.next();
            if (s.equals(JPushInterface.EXTRA_NOTIFICATION_ID))
            {
                stringbuilder.append((new StringBuilder("\nkey:")).append(s).append(", value:").append(bundle.getInt(s)).toString());
            } else
            {
                stringbuilder.append((new StringBuilder("\nkey:")).append(s).append(", value:").append(bundle.getString(s)).toString());
            }
        } while (true);
    }

    private void processCustomMessage(Context context, Bundle bundle)
    {
        if (JpushMainActivity.isForeground)
        {
            String s = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            bundle.getString(JPushInterface.EXTRA_EXTRA);
            bundle = new Intent("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
            bundle.putExtra("message", s);
            context.sendBroadcast(bundle);
        }
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

    public void onReceive(Context context, Intent intent)
    {
        Object obj;
        obj = intent.getExtras();
        mContext = context;
        if (!JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        context = ((Bundle) (obj)).getString(JPushInterface.EXTRA_REGISTRATION_ID);
        Log.e("registration", (new StringBuilder("[MyReceiver] \u63A5\u6536Registration Id : ")).append(context).toString());
_L4:
        return;
_L2:
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction()))
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u81EA\u5B9A\u4E49\u6D88\u606F: ")).append(((Bundle) (obj)).getString(JPushInterface.EXTRA_MESSAGE)).toString());
            processCustomMessage(context, ((Bundle) (obj)));
            return;
        }
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction()))
        {
            Log.d("JPush", "[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u901A\u77E5");
            int i = ((Bundle) (obj)).getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u63A5\u6536\u5230\u63A8\u9001\u4E0B\u6765\u7684\u901A\u77E5\u7684ID: ")).append(i).toString());
            return;
        }
        if (!JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_1393;
        }
        Log.d("JPush", "[MyReceiver] \u7528\u6237\u70B9\u51FB\u6253\u5F00\u4E86\u901A\u77E5");
        JPushInterface.reportNotificationOpened(context, ((Bundle) (obj)).getString(JPushInterface.EXTRA_MSG_ID));
        intent = new JSONObject(((Bundle) (obj)).getString(JPushInterface.EXTRA_EXTRA));
        if (intent.isNull("key"))
        {
            obj = new Intent(context, com/aio/downloader/start/MainActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
        }
        intent = new JSONObject(intent.getString("key"));
        if (!intent.getString("type").equals("base")) goto _L4; else goto _L3
_L3:
        obj = intent.getString("page");
        if (((String) (obj)).equals("home"))
        {
            intent = new Intent(context, com/aio/downloader/start/MainActivity);
            intent.setFlags(0x10000000);
            intent.putExtra("jpush", "jpushfan");
            context.startActivity(intent);
            return;
        }
        boolean flag;
        if (!((String) (obj)).equals("recommendid"))
        {
            break MISSING_BLOCK_LABEL_1165;
        }
        intent = intent.getString("id");
        obj = new Intent();
        ((Intent) (obj)).putExtra("myid", intent);
        ((Intent) (obj)).putExtra("linkurl", "");
        ((Intent) (obj)).putExtra("myjpush", 1);
        flag = intent.equals("com.evzapp.cleanmaster");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_572;
        }
        context = null;
        intent = mContext.getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        context = intent;
_L5:
        if (context == null)
        {
            try
            {
                if (PRO_DIR_FOME.exists())
                {
                    context = new Intent("android.intent.action.VIEW");
                    context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    context.addFlags(0x10000000);
                    mContext.startActivity(context);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_541;
        intent;
        intent.printStackTrace();
          goto _L5
        if (!PRO_DIR_TO.exists()) goto _L4; else goto _L6
_L6:
        (new AsyncTask() {

            final MyReceiver this$0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                return null;
            }

            protected volatile void onPostExecute(Object obj1)
            {
                onPostExecute((Void)obj1);
            }

            protected void onPostExecute(Void void1)
            {
                super.onPostExecute(void1);
                void1 = new Intent("android.intent.action.VIEW");
                void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                void1.addFlags(0x10000000);
                mContext.startActivity(void1);
            }

            
            {
                this$0 = MyReceiver.this;
                super();
            }
        }).execute(new Void[0]);
        return;
        context = mContext.getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
        context.addFlags(0x10000000);
        mContext.startActivity(context);
        return;
        flag = intent.equals("com.allinone.callerid");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_730;
        }
        Log.e("myjpush", (new StringBuilder("getFileSizes(AIOCALLERAPK)=")).append(getFileSizes(AIOCALLERAPK)).toString());
        if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x4e87bdL)
        {
            context = new Intent("android.intent.action.VIEW");
            context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
            context.addFlags(0x10000000);
            mContext.startActivity(context);
            return;
        }
        break MISSING_BLOCK_LABEL_707;
_L8:
        context.printStackTrace();
        return;
        try
        {
            ((Intent) (obj)).setClass(context, com/aio/downloader/activity/AppDetailsActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (true) goto _L8; else goto _L7
_L7:
        flag = intent.equals("com.androidapp.gallary3d");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_888;
        }
        Log.e("myjpush", (new StringBuilder("getFileSizes(AIOGALLERYAPK)=")).append(getFileSizes(AIOGALLERYAPK)).toString());
        if (AIOGALLERYAPK.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
        {
            context = new Intent("android.intent.action.VIEW");
            context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
            context.addFlags(0x10000000);
            mContext.startActivity(context);
            return;
        }
        break MISSING_BLOCK_LABEL_865;
_L10:
        context.printStackTrace();
        return;
        try
        {
            ((Intent) (obj)).setClass(context, com/aio/downloader/activity/AppDetailsActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (true) goto _L10; else goto _L9
_L9:
        flag = intent.equals("com.aioapp.battery");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1015;
        }
        if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
        {
            context = new Intent("android.intent.action.VIEW");
            context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
            context.addFlags(0x10000000);
            mContext.startActivity(context);
            return;
        }
        break MISSING_BLOCK_LABEL_992;
_L12:
        context.printStackTrace();
        return;
        try
        {
            ((Intent) (obj)).setClass(context, com/aio/downloader/activity/AppDetailsActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (true) goto _L12; else goto _L11
_L11:
        flag = intent.equals("com.freepezzle.hexcrush");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1142;
        }
        if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19edc6L)
        {
            context = new Intent("android.intent.action.VIEW");
            context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
            context.addFlags(0x10000000);
            mContext.startActivity(context);
            return;
        }
        break MISSING_BLOCK_LABEL_1119;
_L14:
        context.printStackTrace();
        return;
        try
        {
            ((Intent) (obj)).setClass(context, com/aio/downloader/activity/AppDetailsActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (true) goto _L14; else goto _L13
_L13:
        ((Intent) (obj)).setClass(context, com/aio/downloader/activity/AppDetailsActivity);
        ((Intent) (obj)).setFlags(0x10000000);
        context.startActivity(((Intent) (obj)));
        return;
        if (((String) (obj)).equals("todaypickid"))
        {
            intent = intent.getString("todayid");
            obj = new Intent();
            ((Intent) (obj)).putExtra("todayid", intent);
            ((Intent) (obj)).putExtra("myjpush", 1);
            ((Intent) (obj)).setClass(context, com/aio/downloader/activity/TodaysPickActivity);
            ((Intent) (obj)).setFlags(0x10000000);
            context.startActivity(((Intent) (obj)));
            return;
        }
        if (((String) (obj)).equals("googleid"))
        {
            intent = intent.getString("google_id");
            intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(intent).toString()));
            intent.setFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        if (((String) (obj)).equals("fun"))
        {
            intent = new Intent(context, com/aio/downloader/activity/FunActivity1);
            intent.setFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        if (!((String) (obj)).equals("search")) goto _L4; else goto _L15
_L15:
        intent = intent.getString("searchid");
        obj = new Intent(context, com/aio/downloader/activity/AppRecommendKeywordsActivity);
        ((Intent) (obj)).putExtra("searchid", intent);
        ((Intent) (obj)).putExtra("searchint", 1);
        ((Intent) (obj)).setFlags(0x10000000);
        context.startActivity(((Intent) (obj)));
        return;
        if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction()))
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] \u7528\u6237\u6536\u5230\u5230RICH PUSH CALLBACK: ")).append(((Bundle) (obj)).getString(JPushInterface.EXTRA_EXTRA)).toString());
            return;
        } else
        {
            Log.d("JPush", (new StringBuilder("[MyReceiver] Unhandled intent - ")).append(intent.getAction()).toString());
            return;
        }
    }




}
