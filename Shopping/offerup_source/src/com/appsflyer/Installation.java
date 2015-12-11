// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.UUID;

public class Installation
{

    private static final String INSTALLATION = "AF_INSTALLATION";
    private static String sID = null;

    public Installation()
    {
    }

    public static String id(Context context)
    {
        com/appsflyer/Installation;
        JVM INSTR monitorenter ;
        File file;
        if (sID != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        file = new File(context.getFilesDir(), "AF_INSTALLATION");
        if (!file.exists())
        {
            writeInstallationFile(file, context);
        }
        sID = readInstallationFile(file);
        context = sID;
        com/appsflyer/Installation;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw new RuntimeException(context);
        context;
        com/appsflyer/Installation;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String readInstallationFile(File file)
    {
        file = new RandomAccessFile(file, "r");
        byte abyte0[] = new byte[(int)file.length()];
        file.readFully(abyte0);
        file.close();
        return new String(abyte0);
    }

    private static void writeInstallationFile(File file, Context context)
    {
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        file = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            file = (new StringBuilder()).append(((PackageInfo) (file)).firstInstallTime).append("-").append(Math.abs((new Random()).nextLong())).toString();
        } else
        {
            file = UUID.randomUUID().toString();
        }
        fileoutputstream.write(file.getBytes());
        fileoutputstream.close();
    }

}
