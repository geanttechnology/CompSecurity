// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PLog

class ParseKeyValueCache
{

    static final int DEFAULT_MAX_KEY_VALUE_CACHE_BYTES = 0x200000;
    static final int DEFAULT_MAX_KEY_VALUE_CACHE_FILES = 1000;
    private static final String DIR_NAME = "ParseKeyValueCache";
    private static final Object MUTEX_IO = new Object();
    private static final String TAG = "ParseKeyValueCache";
    private static File directory;
    static int maxKeyValueCacheBytes = 0x200000;
    static int maxKeyValueCacheFiles = 1000;

    ParseKeyValueCache()
    {
    }

    static void clearFromKeyValueCache(String s)
    {
        Object obj = MUTEX_IO;
        obj;
        JVM INSTR monitorenter ;
        s = getKeyValueCacheFile(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        s.delete();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static void clearKeyValueCacheDir()
    {
        Object obj = MUTEX_IO;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = getKeyValueCacheDir();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1 = ((File) (obj1)).listFiles();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        int j = obj1.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1[i].delete();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorexit ;
    }

    private static File createKeyValueCacheFile(String s)
    {
        s = (new StringBuilder()).append(String.valueOf((new Date()).getTime())).append('.').append(s).toString();
        return new File(getKeyValueCacheDir(), s);
    }

    private static long getKeyValueCacheAge(File file)
    {
        file = file.getName();
        long l;
        try
        {
            l = Long.parseLong(file.substring(0, file.indexOf('.')));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return 0L;
        }
        return l;
    }

    private static File getKeyValueCacheDir()
    {
        return directory;
    }

    private static File getKeyValueCacheFile(String s)
    {
        s = (new StringBuilder()).append('.').append(s).toString();
        s = getKeyValueCacheDir().listFiles(new FilenameFilter(s) {

            final String val$suffix;

            public boolean accept(File file, String s1)
            {
                return s1.endsWith(suffix);
            }

            
            {
                suffix = s;
                super();
            }
        });
        if (s == null || s.length == 0)
        {
            return null;
        } else
        {
            return s[0];
        }
    }

    static void initialize(Context context)
    {
        initialize(new File(context.getCacheDir(), "ParseKeyValueCache"));
    }

    static void initialize(File file)
    {
        if (!file.isDirectory() && !file.mkdir())
        {
            throw new RuntimeException("Could not create ParseKeyValueCache directory");
        } else
        {
            directory = file;
            return;
        }
    }

    static JSONObject jsonFromKeyValueCache(String s, long l)
    {
        Object obj = loadFromKeyValueCache(s, l);
        if (obj == null)
        {
            return null;
        }
        try
        {
            obj = JSONObjectInstrumentation.init(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            PLog.e("ParseKeyValueCache", (new StringBuilder()).append("corrupted cache for ").append(s).toString(), jsonexception);
            clearFromKeyValueCache(s);
            return null;
        }
        return ((JSONObject) (obj));
    }

    static String loadFromKeyValueCache(String s, long l)
    {
        Object obj = MUTEX_IO;
        obj;
        JVM INSTR monitorenter ;
        s = getKeyValueCacheFile(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
        Date date;
        date = new Date();
        l = Math.max(0L, date.getTime() - l);
        if (getKeyValueCacheAge(s) >= l)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        s.setLastModified(date.getTime());
        s = new RandomAccessFile(s, "r");
        byte abyte0[] = new byte[(int)s.length()];
        s.readFully(abyte0);
        s.close();
        s = new String(abyte0, "UTF-8");
        obj;
        JVM INSTR monitorexit ;
        return s;
        s;
        PLog.e("ParseKeyValueCache", "error reading from cache", s);
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    static void saveToKeyValueCache(String s, String s1)
    {
        boolean flag = false;
        Object obj = MUTEX_IO;
        obj;
        JVM INSTR monitorenter ;
        File file = getKeyValueCacheFile(s);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        file.delete();
        s = createKeyValueCacheFile(s);
        int i;
        int j;
        int k;
        int l;
        try
        {
            s = new FileOutputStream(s);
            s.write(s1.getBytes("UTF-8"));
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = getKeyValueCacheDir().listFiles();
        k = s.length;
        l = s.length;
        j = 0;
        i = 0;
_L2:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s[j];
        i = (int)((long)i + s1.length());
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (k <= maxKeyValueCacheFiles && i <= maxKeyValueCacheBytes) goto _L4; else goto _L3
_L3:
        Arrays.sort(s, new Comparator() {

            public int compare(File file1, File file2)
            {
                int i1 = Long.valueOf(file1.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
                if (i1 != 0)
                {
                    return i1;
                } else
                {
                    return file1.getName().compareTo(file2.getName());
                }
            }

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((File)obj1, (File)obj2);
            }

        });
        l = s.length;
        j = i;
        i = ((flag) ? 1 : 0);
_L8:
        if (i >= l) goto _L4; else goto _L5
_L5:
        s1 = s[i];
        k--;
        j = (int)((long)j - s1.length());
        s1.delete();
        if (k > maxKeyValueCacheFiles || j > maxKeyValueCacheBytes) goto _L6; else goto _L4
_L4:
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static int size()
    {
        return getKeyValueCacheDir().listFiles().length;
    }

}
