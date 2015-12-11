// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.util;

import android.os.Environment;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager
{

    private static FileManager instance;
    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/util/FileManager);

    private FileManager()
    {
    }

    public static FileManager getInstance()
    {
        com/amazon/device/analytics/util/FileManager;
        JVM INSTR monitorenter ;
        FileManager filemanager;
        if (instance == null)
        {
            instance = new FileManager();
        }
        filemanager = instance;
        com/amazon/device/analytics/util/FileManager;
        JVM INSTR monitorexit ;
        return filemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public File createFile(String s, String s1)
    {
        Object obj = null;
        File file;
        try
        {
            file = new File(Environment.getExternalStorageDirectory(), s);
            if (file.exists())
            {
                break MISSING_BLOCK_LABEL_33;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.e(s.getLocalizedMessage(), s);
            return null;
        }
        s = obj;
        if (!file.mkdirs())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        s = new File(file, s1);
        return s;
    }

    public boolean isExternalStoragePresent()
    {
        String s = Environment.getExternalStorageState();
        return "mounted".equals(s) || "mounted_ro".equals(s);
    }

    public boolean isExternalStorageWritable()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public String readFileContents(File file)
    {
        if (file != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        file = new BufferedReader(new FileReader(file));
        obj = new StringBuilder();
_L5:
        obj1 = file.readLine();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(((String) (obj1)));
          goto _L5
        obj1;
_L9:
        obj = file;
        logger.e(((Exception) (obj1)).getLocalizedMessage());
        if (file == null) goto _L1; else goto _L6
_L6:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            logger.e("Error closing bufferedReader", file);
            return null;
        }
        return null;
_L4:
        obj = ((StringBuilder) (obj)).toString();
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                logger.e("Error closing bufferedReader", file);
                return ((String) (obj));
            }
        }
        return ((String) (obj));
        file;
_L8:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                logger.e("Error closing bufferedReader", ((Throwable) (obj)));
            }
        }
        throw file;
        obj1;
        obj = file;
        file = ((File) (obj1));
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        file = ((File) (obj1));
        obj1 = exception;
          goto _L9
    }

    public boolean writeFileContents(File file, String s)
    {
        if (file != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        File file1;
        File file2;
        Object obj;
        Object obj1;
        boolean flag;
        obj = null;
        obj1 = null;
        file2 = null;
        flag = false;
        flag1 = false;
        file1 = obj1;
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_45;
        }
        file1 = obj1;
        if (!file.createNewFile())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        file1 = obj1;
        file = new BufferedWriter(new FileWriter(file));
        file.write(s);
        flag = true;
        file2 = file;
        flag1 = flag;
        if (file2 != null)
        {
            try
            {
                file2.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return flag;
            }
            return flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        file = obj;
_L8:
        file1 = file;
        logger.e(s.getLocalizedMessage());
        if (file == null) goto _L4; else goto _L5
_L5:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return false;
        }
        return false;
        file;
_L7:
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw file;
        s;
        file1 = file;
        file = s;
        if (true) goto _L7; else goto _L6
_L6:
        s;
          goto _L8
    }

}
