// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.client.VineAPI;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.service.GCMRegistrationService;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.SystemUtil;
import co.vine.android.util.Util;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity, SingleActivity, ProfileActivity, AppImpl

public class DebugHomeActivity extends BaseControllerActionBarActivity
{
    class _cls1CpuFilter
        implements FileFilter
    {

        final DebugHomeActivity this$0;

        public boolean accept(File file)
        {
            return Pattern.matches("cpu[0-9]+", file.getName());
        }

        _cls1CpuFilter()
        {
            this$0 = DebugHomeActivity.this;
            super();
        }
    }


    private static final boolean HIDE_SENSITIVE_DATA;

    public DebugHomeActivity()
    {
    }

    private void appendMemoryInfo(StringBuilder stringbuilder)
    {
        ActivityManager activitymanager = (ActivityManager)getSystemService("activity");
        activitymanager.getMemoryInfo(new android.app.ActivityManager.MemoryInfo());
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 11 && !BuildUtil.isExplore())
        {
            i = activitymanager.getLargeMemoryClass();
        } else
        {
            i = activitymanager.getMemoryClass();
        }
        stringbuilder.append((new StringBuilder()).append("\nMemory Info: ").append(i).append("MB").toString());
    }

    private int getNumCores()
    {
        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(new _cls1CpuFilter()).length;
        }
        catch (Exception exception)
        {
            return 1;
        }
        return i;
    }

    private void handleDebugQuery(String s)
    {
        if (s != null)
        {
            if (s.startsWith("p:"))
            {
                SingleActivity.start(this, Long.parseLong(s.substring(2)));
            }
            if (s.startsWith("s:"))
            {
                SingleActivity.start(this, s.substring(2));
            }
            if (s.startsWith("u:"))
            {
                ProfileActivity.start(this, Long.parseLong(s.substring(2)), "Debug Screen");
            }
        }
    }

    protected void onCreate(final Bundle query)
    {
        final Object debugInfo;
        super.onCreate(query, 0x7f030033, true);
        final Session session = mAppController.getActiveSession();
        query = (TextView)findViewById(0x7f0a00ca);
        debugInfo = (Button)findViewById(0x7f0a00cb);
        Object obj;
        long l;
        if (!HIDE_SENSITIVE_DATA)
        {
            ((Button) (debugInfo)).setOnClickListener(new android.view.View.OnClickListener() {

                final DebugHomeActivity this$0;
                final Session val$session;

                public void onClick(View view)
                {
                    Log.d("VINEDEBUG", (new StringBuilder()).append("vine-session-id: ").append(session.getSessionKey()).toString());
                }

            
            {
                this$0 = DebugHomeActivity.this;
                session = session1;
                super();
            }
            });
        } else
        {
            ((Button) (debugInfo)).setVisibility(8);
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        debugInfo = getSupportActionBar();
        if (debugInfo != null)
        {
            ((ActionBar) (debugInfo)).setTitle("Debug Screen");
        }
        debugInfo = new StringBuilder();
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("Device: ").append(Build.DEVICE).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nModel: ").append(Build.MODEL).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nCPU ABI - ABI2: ").append(Build.CPU_ABI).append(" - ").append(Build.CPU_ABI2).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nHardware: ").append(Build.HARDWARE).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nBrand: ").append(Build.BRAND).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nProduct: ").append(Build.PRODUCT).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nManufacturer: ").append(Build.MANUFACTURER).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nBoard: ").append(Build.BOARD).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nCores: ").append(getNumCores()).append("\n").toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nAndroid OS Version: ").append(android.os.Build.VERSION.RELEASE).append(" ").append(android.os.Build.VERSION.SDK_INT).append(android.os.Build.VERSION.INCREMENTAL).append(" (").append(android.os.Build.VERSION.CODENAME).append(")").toString());
        ((StringBuilder) (debugInfo)).append("\nApp: ");
        if (BuildUtil.isExplore())
        {
            ((StringBuilder) (debugInfo)).append("Explore\n");
        } else
        if (BuildUtil.isRegular())
        {
            ((StringBuilder) (debugInfo)).append("Main\n");
        } else
        {
            ((StringBuilder) (debugInfo)).append("Other\n");
        }
        l = VineDatabaseHelper.getDatabasePath(this).length();
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("Main database size: ").append((double)l / 1000000D).append(" MB\n").toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("Authority: ").append(BuildUtil.getAuthority("")).append("\n").toString());
        appendMemoryInfo(((StringBuilder) (debugInfo)));
        try
        {
            PackageInfo packageinfo = getPackageManager().getPackageInfo("co.vine.android", 0);
            ((StringBuilder) (debugInfo)).append("\nVine for Android Version: ").append(packageinfo.versionName);
            ((StringBuilder) (debugInfo)).append("\nVine for Android Build: ").append(packageinfo.versionCode);
            if (!HIDE_SENSITIVE_DATA)
            {
                ((StringBuilder) (debugInfo)).append("\nInstalled: ").append(Util.DATE_TIME_RFC1123.format(new Date(packageinfo.firstInstallTime)));
                ((StringBuilder) (debugInfo)).append("\nUpdated: ").append(Util.DATE_TIME_RFC1123.format(new Date(packageinfo.lastUpdateTime)));
            }
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            SLog.e("Cannot parse some info.", namenotfoundexception);
        }
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nHW Encoding Mode: ").append(BuildUtil.isIsHwEncodingEnabled()).append("\n").toString());
        ((StringBuilder) (debugInfo)).append("\nBuild Revision: b25c2a494c6fbd61ea37490c8f868560b0a75aad\n");
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("Build Time: ").append(new Date(Long.valueOf("1412095829509").longValue())).append("\n").toString());
        ((StringBuilder) (debugInfo)).append("Build Market: ");
        BuildUtil.getMarket();
        JVM INSTR tableswitch 1 3: default 748
    //                   1 1564
    //                   2 1575
    //                   3 1586;
           goto _L1 _L2 _L3 _L4
_L1:
        ((StringBuilder) (debugInfo)).append("Other\n");
_L12:
        obj = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        ((StringBuilder) (debugInfo)).append("\nScreen Density: ");
        ((DisplayMetrics) (obj)).densityDpi;
        JVM INSTR lookupswitch 6: default 852
    //                   120: 1597
    //                   160: 1608
    //                   213: 1630
    //                   240: 1619
    //                   320: 1641
    //                   480: 1652;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_1652;
_L5:
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append(" UNKNOWN: ").append(((DisplayMetrics) (obj)).densityDpi).toString());
_L13:
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nScreen Size: ").append(((DisplayMetrics) (obj)).widthPixels).append("x").append(((DisplayMetrics) (obj)).heightPixels).toString());
        ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nNormal Video Playable: ").append(SystemUtil.isNormalVideoPlayable(this)).append(" account: ").append(VineAccountHelper.isNormalVideoPlayable(this)).toString());
        ((StringBuilder) (debugInfo)).append("\nLogged in user: ").append(session.getLoginEmail());
        if (!HIDE_SENSITIVE_DATA)
        {
            ((StringBuilder) (debugInfo)).append("\nLogged in user id: ").append(session.getUserId());
            ((StringBuilder) (debugInfo)).append("\nLogged in session key: ").append(session.getSessionKey());
        }
        ((StringBuilder) (debugInfo)).append("\nLogged in name: ").append(session.getName());
        if (!HIDE_SENSITIVE_DATA)
        {
            ((StringBuilder) (debugInfo)).append("\nLogged in avatar: ").append(session.getAvatarUrl());
        }
        session = AccountManager.get(this);
        obj = VineAccountHelper.getAccount(this, mAppController.getActiveSession().getLoginEmail());
        if (Integer.parseInt(session.getUserData(((android.accounts.Account) (obj)), "account_login_type")) == 2)
        {
            ((StringBuilder) (debugInfo)).append("\nLogged in with Twitter.");
        } else
        {
            ((StringBuilder) (debugInfo)).append("\nNot logged in with Twitter.");
        }
        if (TextUtils.isEmpty(VineAccountHelper.getTwitterToken(session, ((android.accounts.Account) (obj)))))
        {
            ((StringBuilder) (debugInfo)).append("\nNot connected to Twitter.");
        } else
        {
            ((StringBuilder) (debugInfo)).append("\nConnected to Twitter.");
        }
        if (!HIDE_SENSITIVE_DATA)
        {
            session = GCMRegistrationService.getGCMPreferences(this);
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\n\nGCM: ").append(session.getString("registrationId", "Not registered")).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nGCM sent to vinepi: ").append(session.getBoolean("registrationIdSent", false)).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\n\nAPI: ").append(VineAPI.getInstance(this).getBaseUrl()).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nAmazon: ").append(getString(0x7f0e004b)).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nAmazon Bucket: ").append(BuildUtil.getAmazonBucket(this)).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nTwitter: ").append(getString(0x7f0e0251)).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nRTC: ").append(VineAPI.getInstance(this).getRtcUrl()).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nMedia: ").append(VineAPI.getInstance(this).getMediaUrl()).toString());
            ((StringBuilder) (debugInfo)).append((new StringBuilder()).append("\nExplore: ").append(VineAPI.getInstance(this).getExploreUrl()).toString());
        }
        AppImpl.getInstance().appendDebugInfo(this, ((StringBuilder) (debugInfo)), HIDE_SENSITIVE_DATA);
        query.setText(((StringBuilder) (debugInfo)).toString());
        if (BuildUtil.isLogsOn())
        {
            session = new Button(this);
            session.setText("Send Logs");
            session.setOnClickListener(new android.view.View.OnClickListener() {

                final DebugHomeActivity this$0;
                final StringBuilder val$debugInfo;

                public void onClick(View view)
                {
                    view = new File(getExternalCacheDir(), "vine_log.txt");
                    try
                    {
                        view = new OutputStreamWriter(new FileOutputStream(view));
                        view.write(debugInfo.toString());
                        view.flush();
                        view.close();
                        view = new Intent("co.vine.android.intent.action.SEND_LOGS");
                        startActivity(view);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        Toast.makeText(DebugHomeActivity.this, "Failed to send log.", 0).show();
                    }
                }

            
            {
                this$0 = DebugHomeActivity.this;
                debugInfo = stringbuilder;
                super();
            }
            });
            ((ViewGroup)query.getParent()).addView(session);
        }
        if (!HIDE_SENSITIVE_DATA)
        {
            query = (EditText)findViewById(0x7f0a00cd);
            findViewById(0x7f0a00ce).setOnClickListener(new android.view.View.OnClickListener() {

                final DebugHomeActivity this$0;
                final EditText val$query;

                public void onClick(View view)
                {
                    handleDebugQuery(query.getText().toString());
                }

            
            {
                this$0 = DebugHomeActivity.this;
                query = edittext;
                super();
            }
            });
            return;
        } else
        {
            ((LinearLayout)findViewById(0x7f0a00cc)).setVisibility(8);
            return;
        }
_L2:
        ((StringBuilder) (debugInfo)).append("Google\n");
          goto _L12
_L3:
        ((StringBuilder) (debugInfo)).append("Amazon\n");
          goto _L12
_L4:
        ((StringBuilder) (debugInfo)).append("Astar\n");
          goto _L12
_L6:
        ((StringBuilder) (debugInfo)).append(" LDPI");
          goto _L13
_L7:
        ((StringBuilder) (debugInfo)).append(" MDPI");
          goto _L13
_L9:
        ((StringBuilder) (debugInfo)).append(" HDPI");
          goto _L13
_L8:
        ((StringBuilder) (debugInfo)).append(" TVDPI");
          goto _L13
_L10:
        ((StringBuilder) (debugInfo)).append(" XHDPI");
          goto _L13
        ((StringBuilder) (debugInfo)).append(" XXHDPI");
          goto _L13
    }

    static 
    {
        boolean flag;
        if (!BuildUtil.isLogsOn())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        HIDE_SENSITIVE_DATA = flag;
    }

}
