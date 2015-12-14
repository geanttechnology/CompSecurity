// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import com.socialin.android.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class FileUtils
{

    private static final String a = com/socialin/android/util/FileUtils.getSimpleName();

    public FileUtils()
    {
    }

    public static long a(Context context)
    {
        if (context.getFilesDir() == null)
        {
            return -1L;
        } else
        {
            context = new StatFs(context.getFilesDir().getPath());
            long l = context.getBlockSize();
            return ((long)context.getAvailableBlocks() * l) / 0x100000L;
        }
    }

    public static File a(String s, InputStream inputstream)
    {
        s = new File(s);
        s.getParentFile().mkdirs();
        if (!s.exists())
        {
            s.createNewFile();
        }
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        byte abyte0[] = new byte[8192];
        do
        {
            int i = inputstream.read(abyte0);
            if (i > 0)
            {
                fileoutputstream.write(abyte0, 0, i);
            } else
            {
                fileoutputstream.flush();
                fileoutputstream.close();
                return s;
            }
        } while (true);
    }

    public static File a(String s, String s1)
    {
        s = new File(Environment.getExternalStorageDirectory(), s);
        s.mkdirs();
        return new File(s, s1);
    }

    public static File a(String s, String s1, InputStream inputstream)
    {
        return b(s, s1, inputstream);
    }

    public static Boolean a(File file, String s)
    {
        try
        {
            if (!file.exists())
            {
                file.createNewFile();
            }
            file = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            file.write(s);
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.a(file.getMessage(), file);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public static String a(Context context, String s)
    {
        Object obj = null;
        try
        {
            context = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.a(context.getMessage(), context);
            context = null;
        }
        s = obj;
        if (context != null)
        {
            s = a(((InputStream) (context)));
        }
        return s;
    }

    public static String a(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage()).toString()
            });
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage()).toString()
            });
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage()).toString()
            });
        }
        throw exception;
    }

    public static void a(File file, File file1)
    {
        file1.mkdirs();
        if (file.exists() && file.isDirectory())
        {
            file = file.listFiles();
            if (file != null)
            {
                int j = file.length;
                int i = 0;
                while (i < j) 
                {
                    File file2 = file[i];
                    if (file2.isDirectory())
                    {
                        a(file2, new File(file1, file2.getName()));
                    } else
                    {
                        b(file2, new File(file1, file2.getName()));
                    }
                    i++;
                }
            }
        }
    }

    public static void a(File file, JSONObject jsonobject)
    {
        file = new BufferedWriter(new FileWriter(file));
        file.write(jsonobject.toString());
        file.close();
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i >= 0)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                inputstream.close();
                outputstream.close();
                return;
            }
        } while (true);
    }

    public static void a(String s, ByteBuffer bytebuffer)
    {
        s = (new FileOutputStream(new File(s))).getChannel();
        s.write(bytebuffer);
        s.close();
    }

    public static boolean a()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean a(File file)
    {
        if (file.isDirectory())
        {
            String as[] = file.list();
            if (as != null)
            {
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    a(new File(file, as[i]));
                }

            }
        }
        return file.delete();
    }

    public static boolean a(String s)
    {
        s = new File(s);
        return !s.exists() || s.listFiles().length == 0;
    }

    private static File b(String s, String s1, InputStream inputstream)
    {
        File file = Environment.getExternalStorageDirectory();
        if (!file.exists() || !file.canWrite()) goto _L2; else goto _L1
_L1:
        Object obj;
        File file1;
        com.socialin.android.d.b("sdcard state:", new Object[] {
            Environment.getExternalStorageState()
        });
        s = new File(file, s);
        s.mkdirs();
        file1 = new File(s, s1);
        byte abyte0[];
        int i;
        try
        {
            file1.createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a("error creating file", s);
        }
        if (!file1.exists() || !file1.canWrite()) goto _L4; else goto _L3
_L3:
        s1 = new FileOutputStream(file1);
        s = s1;
        abyte0 = new byte[1024];
_L6:
        s = s1;
        i = inputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s1;
        s1.write(abyte0, 0, i);
        if (true) goto _L6; else goto _L5
        obj;
_L12:
        s = s1;
        com.socialin.android.d.b(d.a, "ERROR", ((Throwable) (obj)));
        if (s1 != null)
        {
            try
            {
                s1.flush();
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return file1;
            }
        }
        return file1;
_L5:
        try
        {
            s1.flush();
            s1.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return file1;
            }
            return file1;
        } else
        {
            break MISSING_BLOCK_LABEL_160;
        }
        obj;
        s1 = null;
_L10:
        s = s1;
        com.socialin.android.d.b(d.a, "ERROR", ((Throwable) (obj)));
        if (s1 != null)
        {
            try
            {
                s1.flush();
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return file1;
            }
            return file1;
        } else
        {
            break MISSING_BLOCK_LABEL_160;
        }
        s1;
        s = null;
_L8:
        if (s != null)
        {
            try
            {
                s.flush();
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw s1;
_L4:
        com.socialin.android.d.c(new Object[] {
            d.a, "error writing to file"
        });
        return file1;
_L2:
        com.socialin.android.d.c(new Object[] {
            d.a, "ERROR, /sdcard path not available"
        });
        return null;
        s1;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        if (true) goto _L10; else goto _L9
_L9:
        obj;
        s1 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static void b(File file)
    {
        if (file.exists() && file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                int i = 0;
                while (i < j) 
                {
                    File file1 = afile[i];
                    if (file1.isDirectory())
                    {
                        b(file1.getPath());
                    } else
                    {
                        file1.delete();
                    }
                    i++;
                }
            }
            file.delete();
        }
    }

    public static void b(String s)
    {
        b(new File(s));
    }

    public static void b(String s, String s1)
    {
        s = new File(s);
        if (s.getParentFile() != null)
        {
            s.getParentFile().mkdirs();
        }
        s1 = new File(s1);
        if (s1.getParentFile() != null)
        {
            s1.getParentFile().mkdirs();
        }
        s = new FileInputStream(s);
        s1 = new FileOutputStream(s1);
        byte abyte0[] = new byte[1024];
        do
        {
            int i = s.read(abyte0);
            if (i > 0)
            {
                s1.write(abyte0, 0, i);
            } else
            {
                s.close();
                s1.close();
                return;
            }
        } while (true);
    }

    public static void b(String s, ByteBuffer bytebuffer)
    {
        s = (new FileInputStream(s)).getChannel();
        s.position(0L);
        s.read(bytebuffer);
        s.close();
    }

    public static boolean b()
    {
        String s = Environment.getExternalStorageState();
        return "mounted".equals(s) || "mounted_ro".equals(s);
    }

    public static boolean b(File file, File file1)
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        FileInputStream fileinputstream = new FileInputStream(file);
        Object obj = new FileOutputStream(file1);
        file1 = fileinputstream.getChannel();
        obj1 = ((FileOutputStream) (obj)).getChannel();
        ((FileChannel) (obj1)).transferFrom(file1, 0L, file.length());
        fileinputstream.close();
        ((FileOutputStream) (obj)).close();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        file1.close();
        if (obj1 != null)
        {
            try
            {
                ((FileChannel) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.a(file.getMessage(), file);
            }
        }
        return true;
        file;
        com.socialin.android.d.a(file.getMessage(), file);
        fileinputstream.close();
        ((FileOutputStream) (obj)).close();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        file1.close();
        if (obj1 != null)
        {
            try
            {
                ((FileChannel) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.a(file.getMessage(), file);
            }
        }
_L1:
        return false;
        obj;
        file = null;
        file1 = null;
        fileinputstream = null;
_L4:
        com.socialin.android.d.a(((FileNotFoundException) (obj)).getMessage(), ((Throwable) (obj)));
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        fileinputstream.close();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        file1.close();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        ((FileChannel) (obj1)).close();
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.a(file.getMessage(), file);
            }
        }
          goto _L1
        file;
        file1 = null;
        obj = null;
        fileinputstream = null;
        obj1 = obj2;
_L3:
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        fileinputstream.close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        ((FileOutputStream) (obj)).close();
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        file1.close();
        if (obj1 != null)
        {
            try
            {
                ((FileChannel) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file1)
            {
                com.socialin.android.d.a(file1.getMessage(), file1);
            }
        }
        throw file;
        file;
        file1 = null;
        obj = null;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        file;
        file1 = null;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        file;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        file;
        continue; /* Loop/switch isn't completed */
        Object obj3;
        obj3;
        obj = file1;
        file1 = ((File) (obj1));
        obj1 = file;
        file = ((File) (obj3));
        if (true) goto _L3; else goto _L2
_L2:
        obj;
        file = null;
        file1 = null;
          goto _L4
        obj3;
        file = null;
        file1 = ((File) (obj));
        obj = obj3;
          goto _L4
        file;
        Object obj4 = obj;
        obj1 = null;
        obj = file;
        file = ((File) (obj1));
        obj1 = file1;
        file1 = ((File) (obj4));
          goto _L4
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        Object obj5 = obj;
        file = ((File) (obj1));
        obj = filenotfoundexception;
        obj1 = file1;
        file1 = ((File) (obj5));
          goto _L4
    }

    public static boolean b(File file, String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        File file1;
        Object obj;
        file1 = null;
        obj = null;
        file = new FileWriter(file, false);
        file1 = file;
        file.write(s);
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.a(file.getMessage(), file);
        }
        return true;
        s;
        file = null;
_L7:
        file1 = file;
        com.socialin.android.d.a(s.getMessage(), s);
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.a(file.getMessage(), file);
                return false;
            }
            return false;
        }
          goto _L1
        s;
        file = obj;
_L6:
        file1 = file;
        com.socialin.android.d.a(s.getMessage(), s);
        if (file == null) goto _L1; else goto _L3
_L3:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.a(file.getMessage(), file);
            return false;
        }
        return false;
        file;
_L5:
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.a(s.getMessage(), s);
            }
        }
        throw file;
        file;
        if (true) goto _L5; else goto _L4
_L4:
        s;
          goto _L6
        s;
          goto _L7
    }

    public static long c()
    {
        StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l = statfs.getBlockSize();
        return ((long)statfs.getAvailableBlocks() * l) / 0x100000L;
    }

    public static String c(File file, String s)
    {
        file.mkdirs();
        int i = 0;
        StringBuilder stringbuilder;
        int j;
        do
        {
            stringbuilder = (new StringBuilder()).append(s);
            j = i + 1;
            i = j;
        } while ((new File(file, stringbuilder.append(j).toString())).exists());
        return (new StringBuilder()).append(s).append(j).toString();
    }

    public static JSONObject c(File file)
    {
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        file = new FileInputStream(file);
        Object obj;
        obj = file.getChannel();
        obj = ((FileChannel) (obj)).map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, ((FileChannel) (obj)).size());
        obj = Charset.defaultCharset().decode(((ByteBuffer) (obj))).toString();
        Exception exception;
        try
        {
            file.close();
            return new JSONObject(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.a(file.getMessage(), file);
        }
        break MISSING_BLOCK_LABEL_75;
        exception;
        file.close();
        throw exception;
        return null;
    }

    public static boolean c(String s)
    {
        File file = Environment.getExternalStorageDirectory();
        if (file.exists() && file.canWrite())
        {
            s = new File(s);
            if (s.exists())
            {
                return s.delete();
            } else
            {
                throw new IOException("File not exists");
            }
        } else
        {
            throw new Exception("Sd card not exist, or not avaliable");
        }
    }

    public static ImageFileFormat d(String s)
    {
        Object obj;
        s = new File(s);
        if (!s.exists() || !s.canRead())
        {
            return ImageFileFormat.UNKNOWN;
        }
        obj = new byte[4];
        FileInputStream fileinputstream = new FileInputStream(s);
        s = fileinputstream;
        fileinputstream.read(((byte []) (obj)));
        if (obj[0] != -1 || obj[1] != -40)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s = fileinputstream;
        obj = ImageFileFormat.JPEG;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return ((ImageFileFormat) (obj));
        }
        return ((ImageFileFormat) (obj));
        if (obj[0] != 71 || obj[1] != 73)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        s = fileinputstream;
        obj = ImageFileFormat.GIF;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return ((ImageFileFormat) (obj));
        }
        return ((ImageFileFormat) (obj));
        if (obj[0] != -119 || obj[1] != 80)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        s = fileinputstream;
        obj = ImageFileFormat.PNG;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return ((ImageFileFormat) (obj));
        }
        return ((ImageFileFormat) (obj));
        if (obj[0] != 46 || obj[1] != 82)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        s = fileinputstream;
        obj = ImageFileFormat.RAW;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return ((ImageFileFormat) (obj));
        }
        return ((ImageFileFormat) (obj));
        s = fileinputstream;
        obj = ImageFileFormat.UNKNOWN;
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.socialin.android.d.a(s.getMessage(), s);
            return ((ImageFileFormat) (obj));
        }
        return ((ImageFileFormat) (obj));
        IOException ioexception;
        ioexception;
        fileinputstream = null;
_L4:
        s = fileinputstream;
        com.socialin.android.d.a(ioexception.getMessage(), ioexception);
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.a(s.getMessage(), s);
            }
        }
        return ImageFileFormat.UNKNOWN;
        Exception exception;
        exception;
        s = null;
_L2:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.a(s.getMessage(), s);
            }
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String d(File file)
    {
        if (!file.exists())
        {
            return null;
        }
        Object obj;
        obj = new StringBuilder();
        file = new BufferedReader(new FileReader(file.getAbsolutePath()));
_L1:
        String s = file.readLine();
label0:
        {
            if (s == null)
            {
                break label0;
            }
            try
            {
                ((StringBuilder) (obj)).append(s).append("\n");
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                com.socialin.android.d.a(file.getMessage(), file);
                return null;
            }
        }
          goto _L1
        obj = ((StringBuilder) (obj)).toString();
        file.close();
        return ((String) (obj));
    }

    public static boolean d()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static List e(File file)
    {
        LinkedList linkedlist = new LinkedList();
        file = new BufferedReader(new FileReader(file));
_L1:
        String s = file.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        linkedlist.add(s);
          goto _L1
        Exception exception;
        exception;
        try
        {
            file.close();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            com.socialin.android.d.a(file.getMessage(), file);
        }
        return linkedlist;
        file.close();
        return linkedlist;
    }

    public static byte[] f(File file)
    {
        file = new RandomAccessFile(file, "r");
        long l = file.length();
        int i;
        i = (int)l;
        if ((long)i == l)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        throw new IOException("File size >= 2 GB");
        Exception exception;
        exception;
        file.close();
        throw exception;
        byte abyte0[];
        abyte0 = new byte[i];
        file.readFully(abyte0);
        file.close();
        return abyte0;
    }

    public static long g(File file)
    {
        long l1 = 0L;
        long l = l1;
        if (file.exists())
        {
            if (file.isDirectory())
            {
                file = file.listFiles();
                l = l1;
                if (file != null)
                {
                    int j = file.length;
                    int i = 0;
                    do
                    {
                        l = l1;
                        if (i >= j)
                        {
                            break;
                        }
                        File file1 = file[i];
                        if (file1.isDirectory())
                        {
                            l1 += g(file1);
                        } else
                        {
                            l1 += file1.length();
                        }
                        i++;
                    } while (true);
                }
            } else
            {
                l = 0L + file.length();
            }
        }
        return l;
    }


    private class ImageFileFormat extends Enum
    {

        private static final ImageFileFormat $VALUES[];
        public static final ImageFileFormat GIF;
        public static final ImageFileFormat JPEG;
        public static final ImageFileFormat PNG;
        public static final ImageFileFormat RAW;
        public static final ImageFileFormat UNKNOWN;

        public static ImageFileFormat valueOf(String s)
        {
            return (ImageFileFormat)Enum.valueOf(com/socialin/android/util/FileUtils$ImageFileFormat, s);
        }

        public static ImageFileFormat[] values()
        {
            return (ImageFileFormat[])$VALUES.clone();
        }

        static 
        {
            PNG = new ImageFileFormat("PNG", 0);
            JPEG = new ImageFileFormat("JPEG", 1);
            GIF = new ImageFileFormat("GIF", 2);
            RAW = new ImageFileFormat("RAW", 3);
            UNKNOWN = new ImageFileFormat("UNKNOWN", 4);
            $VALUES = (new ImageFileFormat[] {
                PNG, JPEG, GIF, RAW, UNKNOWN
            });
        }

        private ImageFileFormat(String s, int i)
        {
            super(s, i);
        }
    }

}
