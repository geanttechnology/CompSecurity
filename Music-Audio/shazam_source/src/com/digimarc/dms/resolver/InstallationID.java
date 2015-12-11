// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

class InstallationID
{

    private static final String INSTALLATION = "INSTALLATION";
    private static String sID = null;

    InstallationID()
    {
    }

    static String id(Context context)
    {
        com/digimarc/dms/resolver/InstallationID;
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
        com/digimarc/dms/resolver/InstallationID;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw new RuntimeException(context);
        context;
        com/digimarc/dms/resolver/InstallationID;
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

    private static void writeInstallationFile(File file)
    {
        file = new FileOutputStream(file);
        file.write(UUID.randomUUID().toString().getBytes());
        file.close();
    }

}
