// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.UUID;

public class i
{

    private static String a = null;

    public static String a(Context context)
    {
        com/appsflyer/i;
        JVM INSTR monitorenter ;
        File file;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        file = new File(context.getFilesDir(), "AF_INSTALLATION");
        if (!file.exists())
        {
            a(file, context);
        }
        a = a(file);
        context = a;
        com/appsflyer/i;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw new RuntimeException(context);
        context;
        com/appsflyer/i;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String a(File file)
        throws IOException
    {
        file = new RandomAccessFile(file, "r");
        byte abyte0[] = new byte[(int)file.length()];
        file.readFully(abyte0);
        file.close();
        return new String(abyte0);
    }

    private static void a(File file, Context context)
        throws IOException, android.content.pm.PackageManager.NameNotFoundException
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
