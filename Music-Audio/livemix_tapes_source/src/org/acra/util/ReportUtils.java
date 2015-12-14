// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.acra.ACRA;
import org.acra.log.ACRALog;

public final class ReportUtils
{

    public ReportUtils()
    {
    }

    public static String getApplicationFilePath(Context context)
    {
        File file = context.getFilesDir();
        if (file != null)
        {
            return file.getAbsolutePath();
        } else
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve ApplicationFilePath for : ").append(context.getPackageName()).toString());
            return "Couldn't retrieve ApplicationFilePath";
        }
    }

    public static long getAvailableInternalMemorySize()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        long l = statfs.getBlockSize();
        return (long)statfs.getAvailableBlocks() * l;
    }

    public static String getDeviceId(Context context)
    {
        String s;
        try
        {
            s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        }
        catch (RuntimeException runtimeexception)
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve DeviceId for : ").append(context.getPackageName()).toString(), runtimeexception);
            return null;
        }
        return s;
    }

    public static String getLocalIpAddress()
    {
        StringBuilder stringbuilder;
        boolean flag;
        stringbuilder = new StringBuilder();
        flag = true;
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        boolean flag1 = flag;
_L4:
        flag = flag1;
        if (!enumeration1.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        stringbuilder.append('\n');
        stringbuilder.append(inetaddress.getHostAddress().toString());
        flag1 = false;
          goto _L4
        SocketException socketexception;
        socketexception;
        ACRA.log.w(ACRA.LOG_TAG, socketexception.toString());
        return stringbuilder.toString();
    }

    public static long getTotalInternalMemorySize()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        long l = statfs.getBlockSize();
        return (long)statfs.getBlockCount() * l;
    }

    public static String sparseArrayToString(SparseArray sparsearray)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (sparsearray == null)
        {
            return "null";
        }
        stringbuilder.append('{');
        int i = 0;
        while (i < sparsearray.size()) 
        {
            stringbuilder.append(sparsearray.keyAt(i));
            stringbuilder.append(" => ");
            if (sparsearray.valueAt(i) == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(sparsearray.valueAt(i).toString());
            }
            if (i < sparsearray.size() - 1)
            {
                stringbuilder.append(", ");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
