// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            Permissions, InternalVariables, InternalMethods, Installer, 
//            Remounter, Runner, RootToolsException, Executer, 
//            IResult

public class RootTools
{
    public static abstract class Result
        implements IResult
    {

        private Serializable data;
        private int error;
        private Process process;

        public Serializable getData()
        {
            return data;
        }

        public int getError()
        {
            return error;
        }

        public Process getProcess()
        {
            return process;
        }

        public abstract void onComplete(int i);

        public abstract void onFailure(Exception exception);

        public abstract void process(String s)
            throws Exception;

        public abstract void processError(String s)
            throws Exception;

        public volatile IResult setData(Serializable serializable)
        {
            return setData(serializable);
        }

        public Result setData(Serializable serializable)
        {
            data = serializable;
            return this;
        }

        public volatile IResult setError(int i)
        {
            return setError(i);
        }

        public Result setError(int i)
        {
            error = i;
            return this;
        }

        public volatile IResult setProcess(Process process1)
        {
            return setProcess(process1);
        }

        public Result setProcess(Process process1)
        {
            process = process1;
            return this;
        }

        public Result()
        {
            process = null;
            data = null;
            error = 0;
        }
    }


    public static boolean debugMode = false;
    public static int lastExitCode;
    public static List lastFoundBinaryPaths = new ArrayList();
    public static int shellDelay = 0;
    public static String utilPath;

    public RootTools()
    {
    }

    public static boolean checkUtil(String s)
    {
        if (!findBinary(s)) goto _L2; else goto _L1
_L1:
        Iterator iterator = lastFoundBinaryPaths.iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        String s1 = (String)iterator.next();
        Permissions permissions = getFilePermissions((new StringBuilder(String.valueOf(s1))).append("/").append(s).toString());
        if (permissions != null)
        {
            int i = permissions.getPermissions();
            if (i == 755 || i == 777 || i == 775)
            {
                utilPath = (new StringBuilder(String.valueOf(s1))).append("/").append(s).toString();
                return true;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean checkUtils(String as[])
        throws Exception
    {
        int i;
        int j;
        boolean flag1;
        flag1 = false;
        j = as.length;
        i = 0;
_L7:
        if (i < j) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L9:
        return flag;
_L2:
        String s = as[i];
        if (checkUtil(s)) goto _L4; else goto _L3
_L3:
        if (!checkUtil("busybox")) goto _L6; else goto _L5
_L5:
        fixUtil(s, utilPath);
_L4:
        i++;
          goto _L7
_L6:
        flag = flag1;
        if (!checkUtil("toolbox")) goto _L9; else goto _L8
_L8:
        fixUtil(s, utilPath);
          goto _L4
    }

    public static boolean findBinary(String s)
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        i = 0;
        flag1 = false;
        flag2 = false;
        flag = false;
        lastFoundBinaryPaths.clear();
        log(InternalVariables.TAG, (new StringBuilder("Checking for ")).append(s).toString());
        Object obj = getPath().iterator();
_L5:
        flag1 = flag;
        flag2 = flag;
        boolean flag3 = ((Iterator) (obj)).hasNext();
        if (flag3) goto _L2; else goto _L1
_L1:
        flag1 = flag;
        if (flag) goto _L4; else goto _L3
_L3:
        int j;
        log(InternalVariables.TAG, "Trying second method");
        log(InternalVariables.TAG, (new StringBuilder("Checking for ")).append(s).toString());
        obj = new String[8];
        obj[0] = "/sbin/";
        obj[1] = "/system/bin/";
        obj[2] = "/system/xbin/";
        obj[3] = "/data/local/xbin/";
        obj[4] = "/data/local/bin/";
        obj[5] = "/system/sd/xbin/";
        obj[6] = "/system/bin/failsafe/";
        obj[7] = "/data/local/";
        j = obj.length;
_L6:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        flag1 = flag;
_L4:
        return flag1;
_L2:
        flag1 = flag;
        flag2 = flag;
        String s1 = (String)((Iterator) (obj)).next();
        flag1 = flag;
        flag2 = flag;
        if (!(new File((new StringBuilder(String.valueOf(s1))).append("/").append(s).toString())).exists())
        {
            break MISSING_BLOCK_LABEL_295;
        }
        flag1 = flag;
        flag2 = flag;
        log((new StringBuilder(String.valueOf(s))).append(" was found here: ").append(s1).toString());
        flag1 = flag;
        flag2 = flag;
        lastFoundBinaryPaths.add(s1);
        flag = true;
          goto _L5
        flag1 = flag;
        flag2 = flag;
        log((new StringBuilder(String.valueOf(s))).append(" was NOT found here: ").append(s1).toString());
          goto _L5
        obj;
        log(InternalVariables.TAG, "TimeoutException!!!");
        flag = flag1;
          goto _L1
        obj;
        log(InternalVariables.TAG, (new StringBuilder(String.valueOf(s))).append(" was not found, more information MAY be available with Debugging on.").toString());
        flag = flag2;
          goto _L1
        String s2 = obj[i];
        if ((new File((new StringBuilder(String.valueOf(s2))).append(s).toString())).exists())
        {
            log((new StringBuilder(String.valueOf(s))).append(" was found here: ").append(s2).toString());
            lastFoundBinaryPaths.add(s2);
            flag = true;
        } else
        {
            log((new StringBuilder(String.valueOf(s))).append(" was NOT found here: ").append(s2).toString());
        }
        i++;
          goto _L6
    }

    public static void fixUtil(String s, String s1)
    {
        remount("/system", "rw");
        if (!findBinary(s)) goto _L2; else goto _L1
_L1:
        Object obj = lastFoundBinaryPaths.iterator();
_L3:
        if (((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj = (new StringBuilder(String.valueOf(s1))).append(" ln -s ").append(s1).append(" /system/bin/").append(s).toString();
        s = (new StringBuilder(String.valueOf(s1))).append(" chmod 0755 /system/bin/").append(s).toString();
        int i = InternalVariables.timeout;
        sendShell(new String[] {
            obj, s
        }, 10, i);
_L2:
        remount("/system", "ro");
        return;
        try
        {
            String s2 = (String)((Iterator) (obj)).next();
            sendShell((new StringBuilder(String.valueOf(s1))).append(" rm ").append(s2).append("/").append(s).toString(), InternalVariables.timeout);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
          goto _L3
    }

    public static List getBusyBoxApplets()
        throws Exception
    {
        List list = sendShell("busybox --list", InternalVariables.timeout);
        if (list != null)
        {
            return list;
        } else
        {
            throw new Exception();
        }
    }

    public static String getBusyBoxVersion()
    {
        log(InternalVariables.TAG, "Getting BusyBox Version");
        InternalVariables.busyboxVersion = null;
        InternalMethods internalmethods = new InternalMethods();
        int i = InternalVariables.timeout;
        internalmethods.doExec(new String[] {
            "busybox"
        }, i);
_L2:
        return InternalVariables.busyboxVersion;
        Object obj;
        obj;
        log(InternalVariables.TAG, "TimeoutException!!!");
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        log(InternalVariables.TAG, "BusyBox was not found, more information MAY be available with Debugging on.");
        return "";
    }

    public static Permissions getFilePermissions(String s)
    {
        return getFilePermissionsSymlinks(s);
    }

    public static Permissions getFilePermissionsSymlinks(String s)
    {
        log(InternalVariables.TAG, (new StringBuilder("Checking permissions for ")).append(s).toString());
        if (!(new File(s)).exists()) goto _L2; else goto _L1
_L1:
        String s1 = "";
        log((new StringBuilder(String.valueOf(s))).append(" was found.").toString());
        Object obj1;
        Object obj2;
        String as[];
        try
        {
            obj1 = (new StringBuilder("ls -l ")).append(s).toString();
            String s2 = (new StringBuilder("busybox ls -l ")).append(s).toString();
            String s3 = (new StringBuilder("/system/bin/failsafe/toolbox ls -l ")).append(s).toString();
            s = (new StringBuilder("toolbox ls -l ")).append(s).toString();
            int i = InternalVariables.timeout;
            obj1 = sendShell(new String[] {
                obj1, s2, s3, s
            }, 0, i).iterator();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s.getMessage());
            return null;
        }
        s = s1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (String)((Iterator) (obj1)).next();
        if (((String) (obj2)).split(" ")[0].length() != 10)
        {
            break; /* Loop/switch isn't completed */
        }
        log((new StringBuilder("Line ")).append(((String) (obj2))).toString());
        as = ((String) (obj2)).split(" ");
        Object obj = s;
        try
        {
            if (as[as.length - 2].equals("->"))
            {
                log("Symlink found.");
                obj = as[as.length - 1];
            }
        }
        catch (Exception exception)
        {
            exception = s;
        }
        obj2 = (new InternalMethods()).getPermissions(((String) (obj2)));
        s = ((String) (obj));
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Permissions) (obj2)).setSymlink(((String) (obj)));
        return ((Permissions) (obj2));
        s;
        log(s.getMessage());
        s = ((String) (obj));
        if (true) goto _L3; else goto _L2
_L3:
        break MISSING_BLOCK_LABEL_170;
_L2:
        return null;
    }

    public static ArrayList getMounts()
        throws Exception
    {
        InternalVariables.mounts = (new InternalMethods()).getMounts();
        if (InternalVariables.mounts != null)
        {
            return InternalVariables.mounts;
        } else
        {
            throw new Exception();
        }
    }

    public static Set getPath()
        throws Exception
    {
        if (InternalVariables.path != null)
        {
            return InternalVariables.path;
        }
        if ((new InternalMethods()).returnPath())
        {
            return InternalVariables.path;
        } else
        {
            throw new Exception();
        }
    }

    public static long getSpace(String s)
    {
        int k = 0;
        InternalVariables.getSpaceFor = s;
        int j = 0;
        String s1 = (new StringBuilder("df ")).append(s).toString();
        String as[];
        String s2;
        int i;
        int l;
        int i1;
        try
        {
            (new InternalMethods()).doExec(new String[] {
                s1
            }, -1);
        }
        catch (TimeoutException timeoutexception) { }
        log("Looking for Space");
        if (InternalVariables.space == null) goto _L2; else goto _L1
_L1:
        log("First Method");
        as = InternalVariables.space;
        l = as.length;
        i = 0;
_L5:
        if (i < l) goto _L4; else goto _L3
_L3:
        l = 0;
        i = 3;
        log("Second Method");
        if (!InternalVariables.space[0].startsWith(s))
        {
            i = 2;
        }
        s = InternalVariables.space;
        i1 = s.length;
        j = k;
        k = l;
_L6:
        if (j < i1)
        {
            break MISSING_BLOCK_LABEL_184;
        }
_L2:
        log("Returning -1, space could not be determined.");
        return -1L;
_L4:
        s2 = as[i];
        log(s2);
        if (j != 0)
        {
            return (new InternalMethods()).getConvertedSpace(s2);
        }
        if (s2.equals("used,"))
        {
            j = 1;
        }
        i++;
          goto _L5
        as = s[j];
        log(as);
        l = k;
        if (as.length() > 0)
        {
            log((new StringBuilder(String.valueOf(as))).append("Valid").toString());
            if (k == i)
            {
                return (new InternalMethods()).getConvertedSpace(as);
            }
            l = k + 1;
        }
        j++;
        k = l;
          goto _L6
    }

    public static String getSymlink(File file)
    {
        log((new StringBuilder("Looking for Symlink for ")).append(file.toString()).toString());
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_102;
        }
        log("File exists");
        file = ((String)sendShell((new StringBuilder("ls -l ")).append(file).toString(), InternalVariables.timeout).get(0)).split(" ");
        if (!file[file.length - 2].equals("->"))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        log("Symlink found.");
        file = file[file.length - 1];
        return file;
        file;
        log("Symlink not found");
        return "";
    }

    public static ArrayList getSymlinks(String s)
        throws Exception
    {
        (new InternalMethods()).doExec(new String[] {
            (new StringBuilder("find ")).append(s).append(" -type l -exec ls -l {} \\; > /data/local/symlinks.txt;").toString()
        }, -1);
        InternalVariables.symlinks = (new InternalMethods()).getSymLinks();
        if (InternalVariables.symlinks != null)
        {
            return InternalVariables.symlinks;
        } else
        {
            throw new Exception();
        }
    }

    public static String getWorkingToolbox()
    {
        if (checkUtil("busybox"))
        {
            return "busybox";
        }
        if (checkUtil("toolbox"))
        {
            return "toolbox";
        } else
        {
            return "";
        }
    }

    public static boolean hasEnoughSpaceOnSdCard(long l)
    {
        log(InternalVariables.TAG, "Checking SDcard size and that it is mounted as RW");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long l1 = statfs.getBlockSize();
            if (l < (long)statfs.getAvailableBlocks() * l1)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean installBinary(Context context, int i, String s)
    {
        return installBinary(context, i, s, "700");
    }

    public static boolean installBinary(Context context, int i, String s, String s1)
    {
        try
        {
            context = new Installer(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (debugMode)
            {
                context.printStackTrace();
            }
            return false;
        }
        return context.installBinary(i, s, s1);
    }

    public static boolean isAccessGiven()
        throws TimeoutException
    {
        shellDelay = 500;
        log(InternalVariables.TAG, "Checking for Root access");
        InternalVariables.accessGiven = false;
        InternalMethods internalmethods = new InternalMethods();
        int i = InternalVariables.timeout;
        internalmethods.doExec(new String[] {
            "id"
        }, i);
        shellDelay = 0;
        return InternalVariables.accessGiven;
    }

    public static boolean isAppletAvailable(String s)
    {
        Iterator iterator = getBusyBoxApplets().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }
            boolean flag;
            try
            {
                flag = ((String)iterator.next()).equals(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                log(s.toString());
                return false;
            }
        } while (!flag);
        return true;
    }

    public static boolean isBusyboxAvailable()
    {
        return findBinary("busybox");
    }

    public static boolean isNativeToolsReady(int i, Context context)
    {
        boolean flag;
        flag = false;
        log(InternalVariables.TAG, "Preparing Native Tools");
        InternalVariables.nativeToolsReady = false;
        context = new Installer(context);
        if (context.isBinaryInstalled("nativetools"))
        {
            InternalVariables.nativeToolsReady = true;
        } else
        {
            InternalVariables.nativeToolsReady = context.installBinary(i, "nativetools", "700");
        }
        flag = InternalVariables.nativeToolsReady;
        return flag;
        context;
        if (debugMode)
        {
            context.printStackTrace();
            return false;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_42;
_L1:
    }

    public static boolean isProcessRunning(String s)
        throws TimeoutException
    {
        log(InternalVariables.TAG, (new StringBuilder("Checks if process is running: ")).append(s).toString());
        InternalVariables.pid = null;
        InternalMethods internalmethods = new InternalMethods();
        s = (new StringBuilder("busybox pidof ")).append(s).toString();
        int i = InternalVariables.timeout;
        internalmethods.doExec(new String[] {
            s
        }, i);
        return InternalVariables.pid != null;
    }

    public static boolean isRootAvailable()
    {
        return findBinary("su");
    }

    public static boolean killProcess(String s)
    {
        log(InternalVariables.TAG, (new StringBuilder("Killing process ")).append(s).toString());
        InternalVariables.pid = null;
        try
        {
            InternalMethods internalmethods = new InternalMethods();
            s = (new StringBuilder("busybox pidof ")).append(s).toString();
            int i = InternalVariables.timeout;
            internalmethods.doExec(new String[] {
                s
            }, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (InternalVariables.pid != null)
        {
            try
            {
                s = new InternalMethods();
                String s1 = (new StringBuilder("busybox kill -9 ")).append(InternalVariables.pid).toString();
                int j = InternalVariables.timeout;
                s.doExec(new String[] {
                    s1
                }, j);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public static void log(String s)
    {
        log(null, s);
    }

    public static void log(String s, String s1)
    {
label0:
        {
            if (s1 != null && !s1.equals("") && debugMode)
            {
                if (s == null)
                {
                    break label0;
                }
                Log.d(s, s1);
            }
            return;
        }
        Log.d(InternalVariables.TAG, s1);
    }

    public static Intent offerBusyBox(Activity activity, int i)
    {
        log(InternalVariables.TAG, "Launching Market for BusyBox");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox"));
        activity.startActivityForResult(intent, i);
        return intent;
    }

    public static void offerBusyBox(Activity activity)
    {
        log(InternalVariables.TAG, "Launching Market for BusyBox");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox")));
    }

    public static Intent offerSuperUser(Activity activity, int i)
    {
        log(InternalVariables.TAG, "Launching Market for SuperUser");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su"));
        activity.startActivityForResult(intent, i);
        return intent;
    }

    public static void offerSuperUser(Activity activity)
    {
        log(InternalVariables.TAG, "Launching Market for SuperUser");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su")));
    }

    public static boolean remount(String s, String s1)
    {
        return (new Remounter()).remount(s, s1);
    }

    public static void restartAndroid()
        throws TimeoutException
    {
        log(InternalVariables.TAG, "Restart Android");
        InternalMethods internalmethods = new InternalMethods();
        int i = InternalVariables.timeout;
        internalmethods.doExec(new String[] {
            "busybox killall -9 zygote"
        }, i);
    }

    public static void runBinary(Context context, String s, String s1)
    {
        (new Runner(context, s, s1)).start();
    }

    public static List sendShell(String s, int i)
        throws IOException, RootToolsException, TimeoutException
    {
        return sendShell(s, ((Result) (null)), i);
    }

    public static List sendShell(String s, Result result, int i)
        throws IOException, RootToolsException, TimeoutException
    {
        return sendShell(new String[] {
            s
        }, 0, result, i);
    }

    public static List sendShell(String as[], int i, int j)
        throws IOException, RootToolsException, TimeoutException
    {
        return sendShell(as, i, null, j);
    }

    public static List sendShell(String as[], int i, Result result, int j)
        throws IOException, RootToolsException, TimeoutException
    {
        return sendShell(as, i, result, true, j);
    }

    public static List sendShell(String as[], int i, Result result, boolean flag, int j)
        throws IOException, RootToolsException, TimeoutException
    {
        return (new Executer()).sendShell(as, i, result, flag, j);
    }

}
