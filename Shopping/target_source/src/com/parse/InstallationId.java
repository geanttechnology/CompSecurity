// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.parse:
//            ParseFileUtils, PLog, ParseTextUtils

class InstallationId
{

    private static final String TAG = "InstallationId";
    private final File file;
    private String installationId;
    private final Object lock = new Object();

    public InstallationId(File file1)
    {
        file = file1;
    }

    private void setInternal(String s)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        ParseFileUtils.writeStringToFile(file, s, "UTF-8");
_L1:
        installationId = s;
        return;
        IOException ioexception;
        ioexception;
        PLog.e("InstallationId", "Unexpected exception writing installation id to disk", ioexception);
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void clear()
    {
        synchronized (lock)
        {
            installationId = null;
            ParseFileUtils.deleteQuietly(file);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String get()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        String s = installationId;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        installationId = ParseFileUtils.readFileToString(file, "UTF-8");
_L1:
        if (installationId == null)
        {
            setInternal(UUID.randomUUID().toString());
        }
        obj;
        JVM INSTR monitorexit ;
        return installationId;
        Object obj1;
        obj1;
        PLog.i("InstallationId", "Couldn't find existing installationId file. Creating one instead.");
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        PLog.e("InstallationId", "Unexpected exception reading installation id from disk", ((Throwable) (obj1)));
          goto _L1
    }

    public void set(String s)
    {
label0:
        {
            synchronized (lock)
            {
                if (!ParseTextUtils.isEmpty(s) && !s.equals(get()))
                {
                    break label0;
                }
            }
            return;
        }
        setInternal(s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }
}
