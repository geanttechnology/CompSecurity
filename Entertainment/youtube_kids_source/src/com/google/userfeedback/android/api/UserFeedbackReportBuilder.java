// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.userfeedback.android.api.common.io.protocol.ProtoBuf;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackSpec, UserFeedbackReport, UserFeedback, UserFeedbackSerializer

public class UserFeedbackReportBuilder
{

    private static final Object GOOGLE_ACCOUNT = "com.google";
    private static final String REPORT_FILE_EXTENSION = ".proto.gz";
    private static final String TMP_FILE_EXTENSION = ".tmp";
    private final UserFeedbackSpec mSpec;

    protected UserFeedbackReportBuilder(UserFeedbackSpec userfeedbackspec)
    {
        mSpec = userfeedbackspec;
    }

    private String collectLogcatOutput(List list)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        list = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])list.toArray(new String[0])).getInputStream()));
        obj = list;
        obj1 = new StringBuilder();
        obj = list;
        String s = System.getProperty("line.separator");
_L2:
        obj = list;
        String s1 = list.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = list;
        ((StringBuilder) (obj1)).append(s1);
        obj = list;
        ((StringBuilder) (obj1)).append(s);
        if (true) goto _L2; else goto _L1
        obj1;
_L8:
        obj = list;
        Log.e("GFEEDBACK", ((IOException) (obj1)).getMessage());
        if (list != null)
        {
            try
            {
                list.close();
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                Log.e("GFEEDBACK", list.getMessage());
            }
        }
_L3:
        return "";
_L1:
        obj = list;
        obj1 = ((StringBuilder) (obj1)).toString();
        try
        {
            list.close();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            Log.e("GFEEDBACK", list.getMessage());
            return ((String) (obj1));
        }
        return ((String) (obj1));
        obj;
        list = ((List) (obj1));
        obj1 = obj;
_L6:
        obj = list;
        Log.e("GFEEDBACK", ((OutOfMemoryError) (obj1)).getMessage());
        if (list != null)
        {
            try
            {
                list.close();
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                Log.e("GFEEDBACK", list.getMessage());
            }
        }
          goto _L3
        list;
_L5:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            catch (IOException ioexception)
            {
                Log.e("GFEEDBACK", ioexception.getMessage());
            }
        }
        throw list;
        list;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
        obj1;
        list = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private String gatherLogs(String s)
    {
        ArrayList arraylist = new ArrayList(Arrays.asList(new String[] {
            "logcat", "-v", "time", "-d"
        }));
        if (s != null)
        {
            arraylist.add(s);
        }
        return collectLogcatOutput(arraylist);
    }

    private File getFilesDataDir()
    {
        File file = new File(mSpec.getContext().getFilesDir(), "reports");
        if (!file.exists() && !file.mkdirs())
        {
            throw new IOException("Unable to create directory structure for base directory provided");
        } else
        {
            return file;
        }
    }

    private byte[] getScreenshotBytes(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 70, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    private void populateBuildData(UserFeedbackReport userfeedbackreport)
    {
        userfeedbackreport.device = Build.DEVICE;
        userfeedbackreport.buildId = Build.DISPLAY;
        userfeedbackreport.buildType = Build.TYPE;
        userfeedbackreport.model = Build.MODEL;
        userfeedbackreport.board = Build.BOARD;
        userfeedbackreport.brand = Build.BRAND;
        userfeedbackreport.codename = android.os.Build.VERSION.CODENAME;
        userfeedbackreport.incremental = android.os.Build.VERSION.INCREMENTAL;
        userfeedbackreport.release = android.os.Build.VERSION.RELEASE;
        userfeedbackreport.product = Build.PRODUCT;
        try
        {
            userfeedbackreport.sdkInt = Integer.parseInt(android.os.Build.VERSION.SDK);
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            userfeedbackreport.sdkInt = -1;
        }
    }

    private void populateCommonData(UserFeedbackReport userfeedbackreport)
    {
        userfeedbackreport.description = UserFeedback.userFeedback().getFeedbackText();
        userfeedbackreport.uiLanguage = Locale.getDefault().toString();
        if (UserFeedback.userFeedback().getSpec().getProductSpecificBinaryData().size() > 0)
        {
            userfeedbackreport.productSpecificBinaryData = UserFeedback.userFeedback().getSpec().getProductSpecificBinaryData();
        }
    }

    private void populatePackageData(UserFeedbackReport userfeedbackreport)
    {
        PackageManager packagemanager = mSpec.getContext().getPackageManager();
        userfeedbackreport.packageName = mSpec.getContext().getPackageName();
        try
        {
            ApplicationInfo applicationinfo = packagemanager.getApplicationInfo(userfeedbackreport.packageName, 0);
            PackageInfo packageinfo = packagemanager.getPackageInfo(userfeedbackreport.packageName, 0);
            userfeedbackreport.processName = applicationinfo.processName;
            userfeedbackreport.packageVersion = packageinfo.versionCode;
            userfeedbackreport.packageVersionName = packageinfo.versionName;
            userfeedbackreport.installerPackageName = packagemanager.getInstallerPackageName(userfeedbackreport.packageName);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception) { }
        userfeedbackreport.processName = UserFeedback.userFeedback().getSpec().getContext().getPackageName();
        userfeedbackreport.isSystemApp = false;
    }

    private void populateReportData(UserFeedbackReport userfeedbackreport)
    {
        populateRunningApps(userfeedbackreport);
        populateBuildData(userfeedbackreport);
        populateCommonData(userfeedbackreport);
        populateTelephonyData(userfeedbackreport);
        populateSystemData(userfeedbackreport);
        populatePackageData(userfeedbackreport);
        populateUserInitiatedFeedbackData(userfeedbackreport);
    }

    private void populateRunningApps(UserFeedbackReport userfeedbackreport)
    {
        if (mSpec.isRunningAppsEnabled())
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            for (Iterator iterator = ((ActivityManager)mSpec.getContext().getSystemService("activity")).getRunningAppProcesses().iterator(); iterator.hasNext(); userfeedbackreport.runningApplications.add(runningappprocessinfo.processName))
            {
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
            }

        }
    }

    private void populateSystemData(UserFeedbackReport userfeedbackreport)
    {
        userfeedbackreport.timestamp = System.currentTimeMillis();
        userfeedbackreport.systemLog = gatherLogs(mSpec.getLogFilter());
        if ((userfeedbackreport.systemLog == null || userfeedbackreport.systemLog.equals("")) && mSpec.getLogs() != null)
        {
            userfeedbackreport.systemLog = mSpec.getLogs();
        }
        userfeedbackreport.crashData = mSpec.getCrashData();
    }

    private void populateTelephonyData(UserFeedbackReport userfeedbackreport)
    {
        TelephonyManager telephonymanager = (TelephonyManager)mSpec.getContext().getSystemService("phone");
        userfeedbackreport.phoneType = telephonymanager.getPhoneType();
        userfeedbackreport.networkType = telephonymanager.getNetworkType();
        userfeedbackreport.networkName = telephonymanager.getNetworkOperatorName();
    }

    private void populateUserInitiatedFeedbackData(UserFeedbackReport userfeedbackreport)
    {
        if (mSpec.isScreenshotEnabled() && mSpec.getCurrentScreenshot() != null)
        {
            Bitmap bitmap = mSpec.getCurrentScreenshot();
            if (!bitmap.isRecycled())
            {
                userfeedbackreport.screenshot = getScreenshotBytes(bitmap);
                userfeedbackreport.screenshotWidth = bitmap.getWidth();
                userfeedbackreport.screenshotHeight = bitmap.getHeight();
            }
        }
        userfeedbackreport.accounts = new ArrayList();
        Account aaccount[];
        int j;
        aaccount = AccountManager.get(mSpec.getContext()).getAccounts();
        j = aaccount.length;
        int i = 0;
_L2:
        Account account;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        account = aaccount[i];
        if (account.type.equals(GOOGLE_ACCOUNT))
        {
            userfeedbackreport.accounts.add(account.name);
        }
        i++;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        userfeedbackreport.numGoogleAccounts = userfeedbackreport.accounts.size();
        userfeedbackreport.categoryTag = mSpec.getCategoryTag();
        userfeedbackreport.bucket = mSpec.getBucket();
        return;
        obj;
          goto _L1
    }

    private ProtoBuf serializeReport(UserFeedbackReport userfeedbackreport)
    {
        return (new UserFeedbackSerializer(userfeedbackreport)).serialize();
    }

    private AsyncTask startBuildingReport(final UserFeedbackReport report, final BuilderListener listener)
    {
        return (new _cls1ReportBuilderTask()).execute(new Void[0]);
    }

    public AsyncTask buildReport(UserFeedbackReport userfeedbackreport)
    {
        return startBuildingReport(userfeedbackreport, null);
    }

    public void buildReportSynchronously(UserFeedbackReport userfeedbackreport)
    {
        populateReportData(userfeedbackreport);
    }

    public void buildReportWithListener(UserFeedbackReport userfeedbackreport, BuilderListener builderlistener)
    {
        startBuildingReport(userfeedbackreport, builderlistener);
    }

    protected File getFormattedFeedbackReport(UserFeedbackReport userfeedbackreport)
    {
        Object obj;
label0:
        {
            ProtoBuf protobuf = serializeReport(userfeedbackreport);
            File file = getFilesDataDir();
            long l = System.currentTimeMillis();
            int i = protobuf.hashCode();
            String s = (new StringBuilder(32)).append(l).append(".").append(i).toString();
            userfeedbackreport = String.valueOf(s);
            obj = String.valueOf(".tmp");
            if (((String) (obj)).length() != 0)
            {
                userfeedbackreport = userfeedbackreport.concat(((String) (obj)));
            } else
            {
                userfeedbackreport = new String(userfeedbackreport);
            }
            obj = new File(file, userfeedbackreport);
            userfeedbackreport = String.valueOf(s);
            s = String.valueOf(".proto.gz");
            if (s.length() != 0)
            {
                userfeedbackreport = userfeedbackreport.concat(s);
            } else
            {
                userfeedbackreport = new String(userfeedbackreport);
            }
            userfeedbackreport = new File(file, userfeedbackreport);
            try
            {
                GZIPOutputStream gzipoutputstream = new GZIPOutputStream(new FileOutputStream(((File) (obj))));
                protobuf.outputTo(gzipoutputstream);
                gzipoutputstream.close();
                if (!((File) (obj)).renameTo(userfeedbackreport))
                {
                    throw new IOException("Failed to rename temporary file");
                }
                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (UserFeedbackReport userfeedbackreport) { }
            finally
            {
                ((File) (obj)).delete();
                throw userfeedbackreport;
            }
        }
        userfeedbackreport.printStackTrace();
        throw userfeedbackreport;
        ((File) (obj)).delete();
        return userfeedbackreport;
    }



    private class _cls1ReportBuilderTask extends AsyncTask
    {

        final UserFeedbackReportBuilder this$0;
        final BuilderListener val$listener;
        final UserFeedbackReport val$report;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            populateReportData(report);
            if (listener != null)
            {
                listener.onComplete();
            }
            return null;
        }

        _cls1ReportBuilderTask()
        {
            this$0 = UserFeedbackReportBuilder.this;
            report = userfeedbackreport;
            listener = builderlistener;
            super();
        }

        private class BuilderListener
        {

            public abstract void onComplete();
        }

    }

}
