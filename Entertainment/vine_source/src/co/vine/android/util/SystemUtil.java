// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Looper;
import android.os.Process;
import android.text.ClipboardManager;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import co.vine.android.VineLoggingException;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package co.vine.android.util:
//            CrashUtil

public class SystemUtil
{
    public static final class PrefBooleanState extends Enum
    {

        private static final PrefBooleanState $VALUES[];
        public static final PrefBooleanState FALSE;
        public static final PrefBooleanState TRUE;
        public static final PrefBooleanState UNKNOWN;

        public static PrefBooleanState valueOf(String s)
        {
            return (PrefBooleanState)Enum.valueOf(co/vine/android/util/SystemUtil$PrefBooleanState, s);
        }

        public static PrefBooleanState[] values()
        {
            return (PrefBooleanState[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new PrefBooleanState("UNKNOWN", 0);
            TRUE = new PrefBooleanState("TRUE", 1);
            FALSE = new PrefBooleanState("FALSE", 2);
            $VALUES = (new PrefBooleanState[] {
                UNKNOWN, TRUE, FALSE
            });
        }

        private PrefBooleanState(String s, int i)
        {
            super(s, i);
        }
    }


    private static double MEMORY_RATIO = 0D;
    private static final int TARGET_KEY_SINGLE_PLAYER = 1;
    private static final int TARGET_KEY_VIEW_SERVER = 0;
    private static final String TARGET_PROCESS_DEFAULT = null;
    private static final String TARGET_PROCESS_RECORD = ":record";
    private static final String TARGET_SINGLE_PLAYER = ":record";
    private static final String TARGET_VIEW_SERVER = TARGET_PROCESS_DEFAULT;
    private static String mProcessName;
    private static String mSubProcessName;
    private static final SparseArray mTargetProcessInfo = new SparseArray();

    public SystemUtil()
    {
    }

    public static void copyToClip(Context context, String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            ((ClipboardManager)context.getSystemService("clipboard")).setText(s1);
            return;
        } else
        {
            ((android.content.ClipboardManager)context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(s, s1));
            return;
        }
    }

    public static Point getDisplaySize(Activity activity)
    {
        return getDisplaySize(activity.getWindowManager().getDefaultDisplay());
    }

    public static Point getDisplaySize(Context context)
    {
        return getDisplaySize(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
    }

    public static Point getDisplaySize(Display display)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            Point point = new Point();
            display.getSize(point);
            return point;
        } else
        {
            Point point1 = new Point();
            point1.x = display.getWidth();
            point1.y = display.getHeight();
            return point1;
        }
    }

    public static int getMemoryBudgetForLargeMemoryClass(Context context)
    {
        return ((ActivityManager)context.getSystemService("activity")).getLargeMemoryClass();
    }

    public static double getMemoryRatio(Context context, boolean flag)
    {
        if (MEMORY_RATIO != -1D) goto _L2; else goto _L1
_L1:
        int i = 0;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (android.os.Build.VERSION.SDK_INT < 14) goto _L4; else goto _L5
_L5:
        int j = getMemoryBudgetForLargeMemoryClass(context);
        i = j;
_L7:
        double d;
        int k;
        if (i == 0)
        {
            d = 1.0D;
        } else
        {
            d = (double)i / 128D;
        }
        MEMORY_RATIO = d;
_L2:
        return MEMORY_RATIO;
_L4:
        k = ((ActivityManager)context.getSystemService("activity")).getMemoryClass();
        i = k;
        continue; /* Loop/switch isn't completed */
        context;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String getPathFromAsset(String s)
    {
        return (new StringBuilder()).append("file:///android_asset/").append(s).toString();
    }

    public static String getPathFromResourceRaw(Context context, int i)
    {
        return (new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(i).toString();
    }

    private static void initProcessName(Context context)
    {
        co/vine/android/util/SystemUtil;
        JVM INSTR monitorenter ;
        if (mProcessName != null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        mProcessName = context.getPackageName();
        context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        context = context.iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (Process.myPid() == runningappprocessinfo.pid)
            {
                mProcessName = runningappprocessinfo.processName;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_85;
        context;
        throw context;
        int i = mProcessName.indexOf(':');
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        mSubProcessName = mProcessName.substring(i);
_L1:
        co/vine/android/util/SystemUtil;
        JVM INSTR monitorexit ;
        return;
        mSubProcessName = "";
          goto _L1
    }

    public static PrefBooleanState isNormalVideoPlayable(Context context)
    {
        return PrefBooleanState.valueOf(context.getSharedPreferences("normalVideoTestPlayable", 0).getString("normalVideoTestPlayable", PrefBooleanState.UNKNOWN.name()));
    }

    public static boolean isOnMainThread()
    {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isSinglePlayerEnabled(Context context)
    {
        return SLog.sIsAmazon || isTargetProcess(context, 1, ":record");
    }

    private static boolean isTargetProcess(Context context, int i, String s)
    {
        Boolean boolean1 = (Boolean)mTargetProcessInfo.get(i, null);
        Object obj = boolean1;
        if (boolean1 == null)
        {
            initProcessName(context);
            if (s == null)
            {
                context = Boolean.valueOf(SLog.getAuthority().equals(mProcessName));
            } else
            {
                context = Boolean.valueOf(s.equals(mSubProcessName));
            }
            mTargetProcessInfo.put(i, context);
            SLog.i("Is target process for {} a {}: {}.", Integer.valueOf(i), s, context);
            obj = context;
        }
        return ((Boolean) (obj)).booleanValue();
    }

    public static boolean isViewServerEnabled(Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (SLog.sLogsOn)
        {
            flag = flag1;
            if (isTargetProcess(context, 0, TARGET_VIEW_SERVER))
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void quietlyEnsureParentExists(File file)
    {
        try
        {
            if (file.exists())
            {
                break MISSING_BLOCK_LABEL_41;
            }
            file = file.getParentFile();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            CrashUtil.logException(new VineLoggingException("Failed to make parent folder."));
            return;
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (!file.exists())
        {
            CrashUtil.logException(new VineLoggingException("Invalid folder, but we caught it."));
            file.mkdirs();
        }
    }

    public static void setNormalVideoPlayable(Context context, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("normalVideoTestPlayable", 0).edit();
        if (flag)
        {
            context = PrefBooleanState.TRUE;
        } else
        {
            context = PrefBooleanState.FALSE;
        }
        editor.putString("normalVideoTestPlayable", context.name()).commit();
    }

    static 
    {
        MEMORY_RATIO = -1D;
    }
}
