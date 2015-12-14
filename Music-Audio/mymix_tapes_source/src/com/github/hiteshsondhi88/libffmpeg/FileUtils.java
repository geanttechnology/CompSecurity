// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.hiteshsondhi88.libffmpeg;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.github.hiteshsondhi88.libffmpeg:
//            Log, Util

class FileUtils
{

    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int EOF = -1;
    static final String ffmpegFileName = "ffmpeg";

    FileUtils()
    {
    }

    static String SHA1(InputStream inputstream)
    {
        Object obj;
        byte abyte1[];
        obj = MessageDigest.getInstance("SHA1");
        abyte1 = new byte[4096];
_L3:
        int i = inputstream.read(abyte1);
        if (i == -1) goto _L2; else goto _L1
_L1:
        ((MessageDigest) (obj)).update(abyte1, 0, i);
          goto _L3
        obj;
        Log.e(((Throwable) (obj)));
        Util.close(inputstream);
_L7:
        return null;
_L2:
        byte abyte0[];
        Formatter formatter;
        int j;
        formatter = new Formatter();
        abyte0 = ((MessageDigest) (obj)).digest();
        j = abyte0.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        formatter.format("%02x", new Object[] {
            Byte.valueOf(abyte0[i])
        });
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        abyte0 = formatter.toString();
        Util.close(inputstream);
        return abyte0;
        Object obj1;
        obj1;
        Log.e(((Throwable) (obj1)));
        Util.close(inputstream);
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        Util.close(inputstream);
        throw obj1;
    }

    static String SHA1(String s)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        s = new BufferedInputStream(new FileInputStream(s));
        obj = SHA1(((InputStream) (s)));
        Util.close(s);
        return ((String) (obj));
        obj;
        s = ((String) (obj1));
        obj1 = obj;
_L4:
        obj = s;
        Log.e(((Throwable) (obj1)));
        Util.close(s);
        return null;
        s;
_L2:
        Util.close(((InputStream) (obj)));
        throw s;
        obj1;
        obj = s;
        s = ((String) (obj1));
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean copyBinaryFromAssetsToData(Context context, String s, String s1)
    {
        File file = getFilesDirectory(context);
        context = context.getAssets().open(s);
        s = new FileOutputStream(new File(file, s1));
        s1 = new byte[4096];
_L1:
        int i = context.read(s1);
label0:
        {
            if (-1 == i)
            {
                break label0;
            }
            try
            {
                s.write(s1, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("issue in coping binary from assets to data. ", context);
                return false;
            }
        }
          goto _L1
        Util.close(s);
        Util.close(context);
        return true;
    }

    static String getFFmpeg(Context context)
    {
        return (new StringBuilder()).append(getFilesDirectory(context).getAbsolutePath()).append(File.separator).append("ffmpeg").toString();
    }

    static String getFFmpeg(Context context, Map map)
    {
        String s = "";
        Object obj = s;
        if (map != null)
        {
            Iterator iterator = map.entrySet().iterator();
            map = s;
            do
            {
                obj = map;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (java.util.Map.Entry)iterator.next();
                map = (new StringBuilder()).append(map).append((String)((java.util.Map.Entry) (obj)).getKey()).append("=").append((String)((java.util.Map.Entry) (obj)).getValue()).append(" ").toString();
            } while (true);
        }
        return (new StringBuilder()).append(((String) (obj))).append(getFFmpeg(context)).toString();
    }

    static File getFilesDirectory(Context context)
    {
        return context.getFilesDir();
    }
}
