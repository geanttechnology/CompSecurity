// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.cache;

import android.content.Context;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.cache:
//            Cache, Data

public abstract class DiskCache extends Cache
{

    public DiskCache()
    {
    }

    private static String bytesToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if (s.length() == 1)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static File getDiskCacheDir(Context context, String s)
    {
        context = context.getCacheDir().getPath();
        return new File((new StringBuilder()).append(context).append(File.separator).append(s).toString());
    }

    public static long getUsableSpace(File file)
    {
        return file.getUsableSpace();
    }

    private static String hashKeyForDisk(String s)
    {
        Object obj;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            obj = bytesToHexString(((MessageDigest) (obj)).digest());
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            LogUtils.logException(nosuchalgorithmexception);
            return String.valueOf(s.hashCode());
        }
        return ((String) (obj));
    }

    public Data get(Object obj)
    {
        try
        {
            obj = readFromFile(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogUtils.logException(((Exception) (obj)));
            ((FileNotFoundException) (obj)).printStackTrace();
            return null;
        }
        return ((Data) (obj));
    }

    public String processKey(Object obj)
    {
        if (obj instanceof String)
        {
            return hashKeyForDisk((String)obj);
        } else
        {
            return obj.toString();
        }
    }

    public void put(Object obj, Object obj1, int i)
    {
        try
        {
            writeToFile(obj, obj1, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogUtils.logException(((Exception) (obj)));
            ((FileNotFoundException) (obj)).printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogUtils.logException(((Exception) (obj)));
        }
        ((IOException) (obj)).printStackTrace();
    }

    public abstract Data readFromFile(Object obj)
        throws FileNotFoundException;

    public abstract void writeToFile(Object obj, Object obj1, int i)
        throws IOException, FileNotFoundException;
}
