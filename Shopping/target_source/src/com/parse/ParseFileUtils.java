// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseIOUtils

class ParseFileUtils
{

    private static final long FILE_COPY_BUFFER_SIZE = 0x1e00000L;
    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 0x100000L;

    ParseFileUtils()
    {
    }

    public static void cleanDirectory(File file)
        throws IOException
    {
        if (!file.exists())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" does not exist").toString());
        }
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException((new StringBuilder()).append(file).append(" is not a directory").toString());
        }
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("Failed to list contents of ").append(file).toString());
        }
        int j = afile.length;
        file = null;
        int i = 0;
        while (i < j) 
        {
            File file1 = afile[i];
            try
            {
                forceDelete(file1);
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            i++;
        }
        if (file != null)
        {
            throw file;
        } else
        {
            return;
        }
    }

    public static void copyFile(File file, File file1)
        throws IOException
    {
        copyFile(file, file1, true);
    }

    public static void copyFile(File file, File file1, boolean flag)
        throws IOException
    {
        if (file == null)
        {
            throw new NullPointerException("Source must not be null");
        }
        if (file1 == null)
        {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists())
        {
            throw new FileNotFoundException((new StringBuilder()).append("Source '").append(file).append("' does not exist").toString());
        }
        if (file.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' exists but is a directory").toString());
        }
        if (file.getCanonicalPath().equals(file1.getCanonicalPath()))
        {
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' and destination '").append(file1).append("' are the same").toString());
        }
        File file2 = file1.getParentFile();
        if (file2 != null && !file2.mkdirs() && !file2.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file2).append("' directory cannot be created").toString());
        }
        if (file1.exists() && !file1.canWrite())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' exists but is read-only").toString());
        } else
        {
            doCopyFile(file, file1, flag);
            return;
        }
    }

    public static void deleteDirectory(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (!isSymlink(file))
            {
                cleanDirectory(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("Unable to delete directory ").append(file).append(".").toString());
            }
        }
    }

    public static boolean deleteQuietly(File file)
    {
        if (file == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            if (file.isDirectory())
            {
                cleanDirectory(file);
            }
        }
        catch (Exception exception) { }
        try
        {
            flag = file.delete();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return false;
        }
        return flag;
    }

    private static void doCopyFile(File file, File file1, boolean flag)
        throws IOException
    {
        Object obj1;
        Object obj2;
        if (file1.exists() && file1.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' exists but is a directory").toString());
        }
        obj1 = null;
        obj2 = null;
        Object obj = new FileInputStream(file);
        obj1 = new FileOutputStream(file1);
        obj2 = ((FileInputStream) (obj)).getChannel();
        FileChannel filechannel = ((FileOutputStream) (obj1)).getChannel();
        long l3 = ((FileChannel) (obj2)).size();
        long l = 0L;
          goto _L1
_L7:
        long l1;
        l1 = filechannel.transferFrom(((java.nio.channels.ReadableByteChannel) (obj2)), l, l1);
        if (l1 != 0L) goto _L3; else goto _L2
_L3:
        l += l1;
        continue; /* Loop/switch isn't completed */
        file;
        obj = null;
        file1 = null;
_L4:
        ParseIOUtils.closeQuietly(file1);
        ParseIOUtils.closeQuietly(((OutputStream) (obj2)));
        ParseIOUtils.closeQuietly(((java.io.Closeable) (obj)));
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj1)));
        throw file;
_L2:
        ParseIOUtils.closeQuietly(filechannel);
        ParseIOUtils.closeQuietly(((OutputStream) (obj1)));
        ParseIOUtils.closeQuietly(((java.io.Closeable) (obj2)));
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        l = file.length();
        l1 = file1.length();
        if (l != l1)
        {
            throw new IOException((new StringBuilder()).append("Failed to copy full contents from '").append(file).append("' to '").append(file1).append("' Expected length: ").append(l).append(" Actual: ").append(l1).toString());
        }
        if (flag)
        {
            file1.setLastModified(file.lastModified());
        }
        return;
        file;
        obj1 = obj;
        file1 = null;
        obj = null;
        continue; /* Loop/switch isn't completed */
        file;
        Object obj3 = obj;
        obj = null;
        file1 = null;
        obj2 = obj1;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        file;
        Object obj4 = obj;
        obj = obj2;
        file1 = null;
        obj2 = obj1;
        obj1 = obj4;
        continue; /* Loop/switch isn't completed */
        file;
        Object obj5 = obj;
        file1 = filechannel;
        obj = obj2;
        obj2 = obj1;
        obj1 = obj5;
        if (true) goto _L4; else goto _L1
_L1:
        if (l >= l3) goto _L2; else goto _L5
_L5:
        long l2 = l3 - l;
        l1 = l2;
        if (l2 > 0x1e00000L)
        {
            l1 = 0x1e00000L;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void forceDelete(File file)
        throws IOException
    {
        if (file.isDirectory())
        {
            deleteDirectory(file);
        } else
        {
            boolean flag = file.exists();
            if (!file.delete())
            {
                if (!flag)
                {
                    throw new FileNotFoundException((new StringBuilder()).append("File does not exist: ").append(file).toString());
                } else
                {
                    throw new IOException((new StringBuilder()).append("Unable to delete file: ").append(file).toString());
                }
            }
        }
    }

    public static boolean isSymlink(File file)
        throws IOException
    {
        if (file == null)
        {
            throw new NullPointerException("File must not be null");
        }
        if (file.getParent() != null)
        {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static void moveFile(File file, File file1)
        throws IOException
    {
        if (file == null)
        {
            throw new NullPointerException("Source must not be null");
        }
        if (file1 == null)
        {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists())
        {
            throw new FileNotFoundException((new StringBuilder()).append("Source '").append(file).append("' does not exist").toString());
        }
        if (file.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Source '").append(file).append("' is a directory").toString());
        }
        if (file1.exists())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' already exists").toString());
        }
        if (file1.isDirectory())
        {
            throw new IOException((new StringBuilder()).append("Destination '").append(file1).append("' is a directory").toString());
        }
        if (!file.renameTo(file1))
        {
            copyFile(file, file1);
            if (!file.delete())
            {
                deleteQuietly(file1);
                throw new IOException((new StringBuilder()).append("Failed to delete original file '").append(file).append("' after copy to '").append(file1).append("'").toString());
            }
        }
    }

    public static FileInputStream openInputStream(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canRead())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be read").toString());
            } else
            {
                return new FileInputStream(file);
            }
        } else
        {
            throw new FileNotFoundException((new StringBuilder()).append("File '").append(file).append("' does not exist").toString());
        }
    }

    public static FileOutputStream openOutputStream(File file)
        throws IOException
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' exists but is a directory").toString());
            }
            if (!file.canWrite())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' cannot be written to").toString());
            }
        } else
        {
            File file1 = file.getParentFile();
            if (file1 != null && !file1.exists() && !file1.mkdirs())
            {
                throw new IOException((new StringBuilder()).append("File '").append(file).append("' could not be created").toString());
            }
        }
        return new FileOutputStream(file);
    }

    public static byte[] readFileToByteArray(File file)
        throws IOException
    {
        File file1 = null;
        file = openInputStream(file);
        file1 = file;
        byte abyte0[] = ParseIOUtils.toByteArray(file);
        ParseIOUtils.closeQuietly(file);
        return abyte0;
        file;
        ParseIOUtils.closeQuietly(file1);
        throw file;
    }

    public static JSONObject readFileToJSONObject(File file)
        throws IOException, JSONException
    {
        return JSONObjectInstrumentation.init(readFileToString(file, "UTF-8"));
    }

    public static String readFileToString(File file, String s)
        throws IOException
    {
        return readFileToString(file, Charset.forName(s));
    }

    public static String readFileToString(File file, Charset charset)
        throws IOException
    {
        return new String(readFileToByteArray(file), charset);
    }

    public static void writeByteArrayToFile(File file, byte abyte0[])
        throws IOException
    {
        File file1 = null;
        file = openOutputStream(file);
        file1 = file;
        file.write(abyte0);
        ParseIOUtils.closeQuietly(file);
        return;
        file;
        ParseIOUtils.closeQuietly(file1);
        throw file;
    }

    public static void writeJSONObjectToFile(File file, JSONObject jsonobject)
        throws IOException
    {
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        writeByteArrayToFile(file, jsonobject.getBytes(Charset.forName("UTF-8")));
    }

    public static void writeStringToFile(File file, String s, String s1)
        throws IOException
    {
        writeStringToFile(file, s, Charset.forName(s1));
    }

    public static void writeStringToFile(File file, String s, Charset charset)
        throws IOException
    {
        writeByteArrayToFile(file, s.getBytes(charset));
    }
}
