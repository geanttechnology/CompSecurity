// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class FileUtil
{

    private static final String DIR = "/sdcard/targetspot";
    private static final String SDCARD = "/sdcard";
    private static boolean USEINTERNALSTORAGE = false;
    private static final Object sync = new Object();

    private FileUtil()
    {
    }

    public static boolean delete(String s, Context context)
    {
        obj;
        JVM INSTR monitorenter ;
label0:
        {
            boolean flag;
            synchronized (sync)
            {
                if (!USEINTERNALSTORAGE)
                {
                    break label0;
                }
                flag = context.deleteFile(s);
            }
            return flag;
        }
        boolean flag1 = hasSDCard();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s = getFileOnSDCard(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        flag1 = s.delete();
        obj;
        JVM INSTR monitorexit ;
        return flag1;
        s;
        s.printStackTrace();
        obj;
        JVM INSTR monitorexit ;
        return false;
    }

    public static Object get(String s, Context context)
    {
        Object obj = null;
        Object obj4 = sync;
        obj4;
        JVM INSTR monitorenter ;
        Context context1;
        Context context2;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        context1 = obj2;
        context2 = obj3;
        if (!USEINTERNALSTORAGE) goto _L2; else goto _L1
_L1:
        context1 = obj2;
        context2 = obj3;
        new ObjectInputStream(new BufferedInputStream(context.openFileInput(s)));
        context = obj1;
_L4:
        s = obj;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        context1 = context;
        context2 = context;
        s = ((String) (context.readObject()));
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        obj4;
        JVM INSTR monitorexit ;
        return s;
_L2:
        context = obj1;
        context1 = obj2;
        context2 = obj3;
        if (!hasSDCard())
        {
            continue; /* Loop/switch isn't completed */
        }
        context1 = obj2;
        context2 = obj3;
        s = getFileOnSDCard(s);
        context = obj1;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context1 = obj2;
        context2 = obj3;
        try
        {
            context = new ObjectInputStream(new BufferedInputStream(new FileInputStream(s)));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            context2 = context1;
        }
        finally
        {
            if (context2 == null) goto _L0; else goto _L0
        }
        s.printStackTrace();
        s = null;
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            finally { }
        }
        break MISSING_BLOCK_LABEL_85;
        try
        {
            context2.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        throw s;
        obj4;
        JVM INSTR monitorexit ;
        throw s;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static File getFileOnSDCard(String s)
    {
        try
        {
            s = new File((new StringBuilder()).append("/sdcard/targetspot").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static boolean hasSDCard()
    {
        boolean flag;
        try
        {
            flag = (new File("/sdcard")).exists();
        }
        catch (Throwable throwable)
        {
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        (new File("/sdcard/targetspot")).mkdirs();
        return flag;
    }

    public static boolean save(Object obj, String s, Context context)
    {
        boolean flag = true;
        Object obj4 = sync;
        obj4;
        JVM INSTR monitorenter ;
        String s1;
        String s2;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        s2 = obj2;
        s1 = obj3;
        delete(s, context);
        s2 = obj2;
        s1 = obj3;
        if (!USEINTERNALSTORAGE) goto _L2; else goto _L1
_L1:
        s2 = obj2;
        s1 = obj3;
        s = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(s, 0)));
_L8:
        if (s == null) goto _L4; else goto _L3
_L3:
        s2 = s;
        s1 = s;
        s.writeObject(obj);
_L6:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        obj4;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s2 = obj2;
        s1 = obj3;
        if (!hasSDCard())
        {
            flag = false;
            s = obj1;
            continue; /* Loop/switch isn't completed */
        }
        s2 = obj2;
        s1 = obj3;
        s = getFileOnSDCard(s);
        if (s != null)
        {
            s2 = obj2;
            s1 = obj3;
            try
            {
                s = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(s)));
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                s1 = s2;
            }
            finally
            {
                if (s1 == null) goto _L0; else goto _L0
            }
        } else
        {
            flag = false;
            s = obj1;
            continue; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        ((Throwable) (obj)).printStackTrace();
        flag = false;
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally { }
        }
        break MISSING_BLOCK_LABEL_96;
        try
        {
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        throw obj;
        obj4;
        JVM INSTR monitorexit ;
        throw obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void setUseInternalStorage(boolean flag)
    {
        USEINTERNALSTORAGE = flag;
    }

    public static boolean useInternalStorage()
    {
        return USEINTERNALSTORAGE;
    }

}
