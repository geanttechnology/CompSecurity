// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

// Referenced classes of package net.lingala.zip4j.util:
//            Zip4jUtil

public class CRCUtil
{

    private static final int BUF_SIZE = 16384;

    public CRCUtil()
    {
    }

    public static long computeFileCRC(String s)
        throws ZipException
    {
        return computeFileCRC(s, null);
    }

    public static long computeFileCRC(String s, ProgressMonitor progressmonitor)
        throws ZipException
    {
        Object obj;
        CRC32 crc32;
        Object obj1;
        Object obj2;
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(s))
        {
            throw new ZipException("input file is null or empty, cannot calculate CRC for the file");
        }
        obj2 = null;
        obj1 = null;
        crc32 = null;
        obj = obj2;
        Zip4jUtil.checkFileReadAccess(s);
        obj = obj2;
        s = new FileInputStream(new File(s));
        obj = new byte[16384];
        crc32 = new CRC32();
_L2:
        int i = s.read(((byte []) (obj)));
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        long l = crc32.getValue();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new ZipException("error while closing the file after calculating crc");
            }
        }
        return l;
        crc32.update(((byte []) (obj)), 0, i);
        if (progressmonitor == null) goto _L2; else goto _L1
_L1:
        progressmonitor.updateWorkCompleted(i);
        if (!progressmonitor.isCancelAllTasks()) goto _L2; else goto _L3
_L3:
        progressmonitor.setResult(3);
        progressmonitor.setState(0);
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new ZipException("error while closing the file after calculating crc");
            }
        }
        return 0L;
        s;
        obj = crc32;
_L7:
        throw new ZipException(s);
        s;
_L4:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new ZipException("error while closing the file after calculating crc");
            }
        }
        throw s;
        s;
        obj = obj1;
_L5:
        throw new ZipException(s);
        progressmonitor;
        obj = s;
        s = progressmonitor;
          goto _L4
        progressmonitor;
        obj = s;
        s = progressmonitor;
          goto _L5
        progressmonitor;
        obj = s;
        s = progressmonitor;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
