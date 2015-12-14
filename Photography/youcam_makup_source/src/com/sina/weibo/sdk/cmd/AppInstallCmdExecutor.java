// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Environment;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.SDKNotification;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            CmdExecutor, AppInstallCmd, BaseCmd

class AppInstallCmdExecutor
    implements CmdExecutor
{

    private static final int MESSAGE_DO_CMD = 1;
    private static final int MESSAGE_QUIT_LOOP = 2;
    private static final String TAG = com/sina/weibo/sdk/cmd/AppInstallCmdExecutor.getName();
    private static final String WB_APK_FILE_DIR = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/Android/org_share_data/").toString();
    private boolean isStarted;
    private Context mContext;
    private InstallHandler mHandler;
    private Looper mLooper;
    private HandlerThread thread;

    public AppInstallCmdExecutor(Context context)
    {
        isStarted = false;
        mContext = context.getApplicationContext();
    }

    private static PendingIntent buildInstallApkIntent(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(s)), "application/vnd.android.package-archive");
            return PendingIntent.getActivity(context, 0, intent, 16);
        } else
        {
            return PendingIntent.getActivity(context, 0, new Intent(), 16);
        }
    }

    private static boolean checkApkInstalled(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 1);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean checkApkSign(PackageInfo packageinfo, String s)
    {
        if (packageinfo != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (packageinfo.signatures != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        String s1 = "";
        int i = 0;
        do
        {
label0:
            {
                if (i < packageinfo.signatures.length)
                {
                    break label0;
                }
                if (s1 != null)
                {
                    return s1.equals(s);
                }
            }
            if (true)
            {
                continue;
            }
            byte abyte0[] = packageinfo.signatures[i].toByteArray();
            if (abyte0 != null)
            {
                s1 = MD5.hexdigest(abyte0);
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static boolean checkPackageName(PackageInfo packageinfo, String s)
    {
        if (packageinfo == null)
        {
            return false;
        } else
        {
            return s.equals(packageinfo.packageName);
        }
    }

    private static String generateSaveFileName(String s)
    {
        String s1 = "";
        int i = s.lastIndexOf("/");
        if (i != -1)
        {
            s1 = s.substring(i + 1, s.length());
        }
        return s1;
    }

    private static String getNotificationTitle(Context context, String s)
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = ResourceManager.getString(context, "Weibo", "\u5FAE\u535A", "\u5FAE\u535A");
        }
        return s1;
    }

    private void handleCmd(AppInstallCmd appinstallcmd)
    {
        if (needActivate(mContext, appinstallcmd)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        String s1;
        s = WB_APK_FILE_DIR;
        s1 = appinstallcmd.getDownloadUrl();
        long l = appinstallcmd.getAppVersion();
        Pair pair = walkDir(mContext, s, appinstallcmd);
        if (pair != null && pair.second != null && (long)((Integer)pair.first).intValue() >= l)
        {
            showNotification(mContext, appinstallcmd, ((File)pair.second).getAbsolutePath());
            return;
        }
        if (!NetworkHelper.isWifiValid(mContext) || TextUtils.isEmpty(s1)) goto _L1; else goto _L3
_L3:
        String s2;
        s1 = NetUtils.internalGetRedirectUri(mContext, s1, "GET", new WeiboParameters(""));
        s2 = generateSaveFileName(s1);
        if (!TextUtils.isEmpty(s2) && s2.endsWith(".apk"))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        LogUtil.e(TAG, "redirectDownloadUrl is illeagle");
        if (TextUtils.isEmpty("")) goto _L1; else goto _L4
_L4:
        showNotification(mContext, appinstallcmd, "");
        return;
        s = NetUtils.internalDownloadFile(mContext, s1, s, s2);
        if (!TextUtils.isEmpty(s))
        {
            showNotification(mContext, appinstallcmd, s);
            return;
        }
          goto _L1
        Object obj;
        obj;
        ((WeiboException) (obj)).printStackTrace();
        if (TextUtils.isEmpty("")) goto _L1; else goto _L5
_L5:
        showNotification(mContext, appinstallcmd, "");
        return;
        obj;
        if (!TextUtils.isEmpty(""))
        {
            showNotification(mContext, appinstallcmd, "");
        }
        throw obj;
    }

    private static boolean isSpecifiedApk(PackageInfo packageinfo, List list, String s)
    {
        list = list.iterator();
_L2:
        boolean flag;
        if (list.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
_L3:
        boolean flag1 = checkApkSign(packageinfo, s);
        return flag && flag1;
        if (!checkPackageName(packageinfo, (String)list.next())) goto _L2; else goto _L1
_L1:
        flag = true;
          goto _L3
    }

    private static boolean needActivate(Context context, AppInstallCmd appinstallcmd)
    {
        List list = appinstallcmd.getAppPackage();
        if (list == null || list.size() == 0 || TextUtils.isEmpty(appinstallcmd.getAppSign()) || TextUtils.isEmpty(appinstallcmd.getDownloadUrl()) || TextUtils.isEmpty(appinstallcmd.getNotificationText()))
        {
            return false;
        }
        if (list.contains("com.sina.weibo"))
        {
            context = WeiboAppManager.getInstance(context).getWeiboInfo();
            return context == null || !context.isLegal();
        }
        appinstallcmd = list.iterator();
        do
        {
            if (!appinstallcmd.hasNext())
            {
                return true;
            }
        } while (!checkApkInstalled(context, (String)appinstallcmd.next()));
        return false;
    }

    private static void showNotification(Context context, AppInstallCmd appinstallcmd, String s)
    {
        com.sina.weibo.sdk.utils.SDKNotification.SDKNotificationBuilder.buildUpon().setNotificationContent(appinstallcmd.getNotificationText()).setNotificationPendingIntent(buildInstallApkIntent(context, s)).setNotificationTitle(getNotificationTitle(context, appinstallcmd.getNotificationTitle())).setTickerText(appinstallcmd.getNotificationText()).build(context).show(1);
    }

    private static Pair walkDir(Context context, String s, AppInstallCmd appinstallcmd)
    {
        Object obj = null;
        File afile[];
        if (!TextUtils.isEmpty(s))
        {
            if ((s = new File(s)).exists() && s.isDirectory() && (afile = s.listFiles()) != null)
            {
                int k = afile.length;
                int j = 0;
                int i = 0;
                s = obj;
                do
                {
                    File file;
                    Object obj1;
label0:
                    {
                        if (j >= k)
                        {
                            return new Pair(Integer.valueOf(i), s);
                        }
                        file = afile[j];
                        obj1 = file.getName();
                        if (!file.isFile() || !((String) (obj1)).endsWith(".apk"))
                        {
                            break label0;
                        }
                        obj1 = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 64);
                    }
                    while (false) 
                    {
                        if (isSpecifiedApk(((PackageInfo) (obj1)), appinstallcmd.getAppPackage(), appinstallcmd.getAppSign()) && ((PackageInfo) (obj1)).versionCode > i)
                        {
                            i = ((PackageInfo) (obj1)).versionCode;
                            s = file;
                        }
                        j++;
                    }
                } while (true);
            }
        }
        return null;
    }

    public boolean doExecutor(AppInstallCmd appinstallcmd)
    {
        if (thread == null || mHandler == null)
        {
            throw new RuntimeException("no thread running. please call start method first!");
        }
        if (appinstallcmd != null)
        {
            Message message = mHandler.obtainMessage();
            message.what = 1;
            message.obj = appinstallcmd;
            mHandler.sendMessage(message);
        }
        return false;
    }

    public volatile boolean doExecutor(BaseCmd basecmd)
    {
        return doExecutor((AppInstallCmd)basecmd);
    }

    public void start()
    {
        if (isStarted)
        {
            return;
        } else
        {
            isStarted = true;
            thread = new HandlerThread("");
            thread.start();
            mLooper = thread.getLooper();
            mHandler = new InstallHandler(mLooper);
            return;
        }
    }

    public void stop()
    {
        if (thread == null || mHandler == null)
        {
            LogUtil.w(TAG, "no thread running. please call start method first!");
            return;
        } else
        {
            Message message = mHandler.obtainMessage();
            message.what = 2;
            mHandler.sendMessage(message);
            return;
        }
    }





    private class InstallHandler extends Handler
    {

        final AppInstallCmdExecutor this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                handleCmd((AppInstallCmd)message.obj);
                return;

            case 2: // '\002'
                mLooper.quit();
                break;
            }
            isStarted = false;
        }

        public InstallHandler(Looper looper)
        {
            this$0 = AppInstallCmdExecutor.this;
            super(looper);
        }
    }

}
