// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.flurry.android.FlurryAgent;
import com.instabeauty.application.InstaBeautyApplication;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class pu
{

    private static String e = "CameraActivityTool";
    private static String f = "FirstStartBackcamera";
    private static String g = "FirstStartFrontcamera";
    private static int h = 1;
    int a;
    Context b;
    px c;
    AlertDialog d;

    public pu(int i, Context context, px px)
    {
        a = i;
        b = context;
        c = px;
    }

    public static File a(boolean flag, Context context)
    {
        if (flag)
        {
            flag = pt.b(pt.b, context, true);
        } else
        {
            flag = pt.b(pt.c, context, false);
        }
        if (flag)
        {
            File file = b(context);
            context = file;
            if (!file.exists())
            {
                context = file;
                if (!file.mkdirs())
                {
                    return null;
                }
            }
        } else
        {
            context = new File((new StringBuilder()).append(ik.a(context)).append("/camera_photo_temp").toString());
            if (!context.exists() && !context.mkdirs())
            {
                return null;
            }
            (new File(context.getAbsolutePath(), ".nomedia")).createNewFile();
        }
        String s = (new StringBuilder()).append("IMG_").append(String.valueOf(System.currentTimeMillis())).append("_").append(h).toString();
        h++;
        return new File((new StringBuilder()).append(context.getAbsolutePath()).append(File.separator).append("IMG_").append(s).append(".jpg").toString());
    }

    public static File b(Context context)
    {
        boolean flag = false;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            flag = true;
        }
        if (flag)
        {
            return new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/DCIM/Camera").toString());
        } else
        {
            return new File(context.getDir("FOTORUS", 1).getAbsolutePath());
        }
    }

    public static float d()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            ActivityManager activitymanager = (ActivityManager)InstaBeautyApplication.a.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            activitymanager.getMemoryInfo(memoryinfo);
            return (float)memoryinfo.totalMem / 1.073742E+09F;
        }
        float f1;
        BufferedReader bufferedreader;
        String s;
        String as[];
        String s1;
        int i;
        int j;
        try
        {
            bufferedreader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            s = bufferedreader.readLine();
            as = s.split("\\s+");
            j = as.length;
        }
        catch (IOException ioexception)
        {
            return -1F;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = as[i];
        Log.i(s, (new StringBuilder()).append(s1).append("\t").toString());
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_81;
_L1:
        f1 = (float)Integer.valueOf(as[1]).intValue() / 1048576F;
        bufferedreader.close();
        return f1;
    }

    public void a(Context context)
    {
        context = null;
        PackageInfo packageinfo = b.getPackageManager().getPackageInfo(b.getPackageName(), 0);
        context = packageinfo;
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if (context != null)
        {
            context = ((PackageInfo) (context)).versionName;
        } else
        {
            context = "1";
        }
        b.getSharedPreferences("ISOLDUSERVERSION", 32768).edit().putString("ISOLDUSERVERSION", context).commit();
        b.getSharedPreferences("ISOLDUSER", 32768).edit().putBoolean("ISOLDUSER", false).commit();
        return;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L1
    }

    public boolean a()
    {
        return b.getSharedPreferences("ISOLDUSER", 32768).getBoolean("ISOLDUSER", true);
    }

    public boolean a(int i)
    {
        boolean flag;
label0:
        {
            String s = (new StringBuilder()).append(f).append(String.valueOf(i)).toString();
            if (qd.c(a))
            {
                s = (new StringBuilder()).append(g).append(String.valueOf(i)).toString();
            }
            flag = b.getSharedPreferences(s, 32768).getBoolean(s, true);
            if (qd.c(a) && a())
            {
                Log.e("Adjust OldUser", b());
                a(b);
                if (!flag)
                {
                    break label0;
                }
                FlurryAgent.logEvent("User_New_Installed");
            }
            return flag;
        }
        FlurryAgent.logEvent("User_Old_Update");
        return flag;
    }

    public String b()
    {
        return b.getSharedPreferences("ISOLDUSERVERSION", 32768).getString("ISOLDUSERVERSION", "1");
    }

    public void b(int i)
    {
        String s = (new StringBuilder()).append(f).append(String.valueOf(i)).toString();
        if (qd.c(a))
        {
            s = (new StringBuilder()).append(g).append(String.valueOf(i)).toString();
        }
        b.getSharedPreferences(s, 32768).edit().putBoolean(s, false).commit();
    }

    public void c()
    {
        d = (new android.app.AlertDialog.Builder(b)).create();
        d.getWindow().clearFlags(2);
        d.setCanceledOnTouchOutside(false);
        View view = LayoutInflater.from(b).inflate(0x7f03004f, null);
        Object obj = d.getWindow().getAttributes();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)b).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        obj.gravity = 48;
        obj.x = 0;
        obj.y = yp.a(b, 50F);
        obj.height = yp.a(b, 150F);
        obj.width = -2;
        d.getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        d.show();
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        d.setContentView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
        ((FrameLayout)view.findViewById(0x7f0d01d3)).setOnClickListener(new pv(this));
        ((FrameLayout)view.findViewById(0x7f0d01d4)).setOnClickListener(new pw(this));
    }

}
