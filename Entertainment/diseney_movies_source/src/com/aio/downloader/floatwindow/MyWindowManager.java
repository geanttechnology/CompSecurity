// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.app.ActivityManager;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package com.aio.downloader.floatwindow:
//            FloatWindowBigView, FloatWindowSmallView

public class MyWindowManager
{

    private static FloatWindowBigView bigWindow;
    private static android.view.WindowManager.LayoutParams bigWindowParams;
    private static ActivityManager mActivityManager;
    private static WindowManager mWindowManager;
    private static FloatWindowSmallView smallWindow;
    private static android.view.WindowManager.LayoutParams smallWindowParams;

    public MyWindowManager()
    {
    }

    public static void createBigWindow(Context context)
    {
        WindowManager windowmanager = getWindowManager(context);
        int i = windowmanager.getDefaultDisplay().getWidth();
        int j = windowmanager.getDefaultDisplay().getHeight();
        if (bigWindow == null)
        {
            bigWindow = new FloatWindowBigView(context);
            if (bigWindowParams == null)
            {
                bigWindowParams = new android.view.WindowManager.LayoutParams();
                bigWindowParams.x = i / 2 - FloatWindowBigView.viewWidth / 2;
                bigWindowParams.y = j / 2 - FloatWindowBigView.viewHeight / 2;
                bigWindowParams.type = 2002;
                bigWindowParams.format = 1;
                bigWindowParams.gravity = 51;
                bigWindowParams.width = FloatWindowBigView.viewWidth;
                bigWindowParams.height = FloatWindowBigView.viewHeight;
            }
        }
        windowmanager.addView(bigWindow, bigWindowParams);
    }

    public static void createSmallWindow(Context context)
    {
        WindowManager windowmanager;
        int i;
        int j;
        windowmanager = getWindowManager(context);
        i = windowmanager.getDefaultDisplay().getWidth();
        j = windowmanager.getDefaultDisplay().getHeight();
        if (smallWindow != null) goto _L2; else goto _L1
_L1:
        smallWindow = new FloatWindowSmallView(context);
        if (smallWindowParams == null)
        {
            smallWindowParams = new android.view.WindowManager.LayoutParams();
            smallWindowParams.x = i;
            smallWindowParams.y = j / 2;
            smallWindowParams.type = 2002;
            smallWindowParams.format = 1;
            smallWindowParams.gravity = 51;
            smallWindowParams.width = FloatWindowSmallView.viewWidth;
            smallWindowParams.height = FloatWindowSmallView.viewHeight;
            smallWindowParams.flags = 40;
        }
        if (FloatWindowSmallView.xLoa != 0) goto _L4; else goto _L3
_L3:
        FloatWindowSmallView.percentView.setBackgroundResource(0x7f0200b2);
_L2:
        System.out.println("\u6DFB\u52A0\u5C0F\u60AC\u6D6E\u7A97");
        smallWindow.setParams(smallWindowParams);
        windowmanager.addView(smallWindow, smallWindowParams);
        return;
_L4:
        if (FloatWindowSmallView.xLoa == 1)
        {
            FloatWindowSmallView.percentView.setBackgroundResource(0x7f0200b3);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static ActivityManager getActivityManager(Context context)
    {
        if (mActivityManager == null)
        {
            mActivityManager = (ActivityManager)context.getSystemService("activity");
        }
        return mActivityManager;
    }

    private static long getAvailableMemory(Context context)
    {
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        getActivityManager(context).getMemoryInfo(memoryinfo);
        return memoryinfo.availMem;
    }

    public static String getUsedPercentValue(Context context)
    {
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader("/proc/meminfo"));
            String s = bufferedreader.readLine();
            s = s.substring(s.indexOf("MemTotal:"));
            bufferedreader.close();
            long l = Integer.parseInt(s.replaceAll("\\D+", ""));
            context = (new StringBuilder(String.valueOf((int)(((float)(l - getAvailableMemory(context) / 1024L) / (float)l) * 100F)))).append("%").toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "0%";
        }
        return context;
    }

    private static WindowManager getWindowManager(Context context)
    {
        if (mWindowManager == null)
        {
            mWindowManager = (WindowManager)context.getSystemService("window");
        }
        return mWindowManager;
    }

    public static boolean isWindowShowing()
    {
        return smallWindow != null || bigWindow != null;
    }

    public static void removeBigWindow(Context context)
    {
        if (bigWindow != null)
        {
            getWindowManager(context).removeView(bigWindow);
            bigWindow = null;
        }
    }

    public static void removeSmallWindow(Context context)
    {
        if (smallWindow != null)
        {
            getWindowManager(context).removeView(smallWindow);
            smallWindow = null;
        }
    }

    public static void updateUsedPercent(Context context)
    {
    }
}
