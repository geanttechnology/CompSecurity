// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

// Referenced classes of package com.jirbo.adcolony:
//            j

final class z
{

    private static String a = null;

    public static String a(Context context)
    {
        com/jirbo/adcolony/z;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        context = new File(context.getFilesDir(), "INSTALLATION");
        if (!context.exists())
        {
            FileOutputStream fileoutputstream = new FileOutputStream(context);
            fileoutputstream.write(UUID.randomUUID().toString().getBytes());
            fileoutputstream.close();
        }
        context = new RandomAccessFile(context, "r");
        byte abyte0[] = new byte[(int)context.length()];
        context.readFully(abyte0);
        context.close();
        a = new String(abyte0);
        context = a;
        com/jirbo/adcolony/z;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw new j(context.toString());
        context;
        com/jirbo/adcolony/z;
        JVM INSTR monitorexit ;
        throw context;
    }

}
