// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.system;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class Installation
{

    private static String sID = null;

    public Installation()
    {
    }

    public static String id(Context context)
    {
        com/comcast/cim/cmasl/android/util/system/Installation;
        JVM INSTR monitorenter ;
        if (sID != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        context = new File(context.getFilesDir(), "INSTALLATION");
        if (!context.exists())
        {
            writeInstallationFile(context);
        }
        sID = readInstallationFile(context);
        context = sID;
        com/comcast/cim/cmasl/android/util/system/Installation;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw new RuntimeException(context);
        context;
        com/comcast/cim/cmasl/android/util/system/Installation;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String readInstallationFile(File file)
        throws IOException
    {
        file = new RandomAccessFile(file, "r");
        byte abyte0[] = new byte[(int)file.length()];
        file.readFully(abyte0);
        file.close();
        return new String(abyte0);
    }

    private static void writeInstallationFile(File file)
        throws IOException
    {
        file = new FileOutputStream(file);
        file.write(UUID.randomUUID().toString().getBytes());
        file.close();
    }

}
