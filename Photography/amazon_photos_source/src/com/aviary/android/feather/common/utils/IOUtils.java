// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.URLEncodedUtils;

public final class IOUtils
{

    private static final String ANDROID_ASSET = "android_asset";
    private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
    public static final int KILOBYE = 1024;
    private static final String LOG_TAG = "io-utils";
    public static final int MEGABYTE = 0x100000;
    public static final String NO_MEDIA = ".nomedia";
    static final OkUrlFactory OK_URL_FACTORY = new OkUrlFactory(new OkHttpClient());

    private IOUtils()
    {
    }

    public static void cleanDirectory(File file)
        throws IOException
    {
        Log.i("io-utils", (new StringBuilder()).append("cleanDirectory: ").append(file.getAbsolutePath()).toString());
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
        file = null;
        int j = afile.length;
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

    public static void closeSilently(Cursor cursor)
    {
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        cursor.close();
        return;
        cursor;
    }

    public static void closeSilently(ParcelFileDescriptor parcelfiledescriptor)
    {
        if (parcelfiledescriptor == null)
        {
            return;
        }
        try
        {
            parcelfiledescriptor.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParcelFileDescriptor parcelfiledescriptor)
        {
            return;
        }
    }

    public static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static void closeSilently(ZipFile zipfile)
    {
        if (zipfile == null)
        {
            return;
        }
        try
        {
            zipfile.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ZipFile zipfile)
        {
            return;
        }
    }

    public static void copyFile(File file, File file1)
        throws IOException
    {
        if (file.exists())
        {
            file = new FileInputStream(file);
            file1 = new FileOutputStream(file1);
            copyFile(((InputStream) (file)), ((OutputStream) (file1)));
            closeSilently(file);
            closeSilently(file1);
        }
    }

    public static void copyFile(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[4096];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void copyFile(InputStream inputstream, ByteBuffer bytebuffer)
        throws IOException
    {
        if (inputstream.available() > 0)
        {
            byte abyte0[];
            int i;
            if (inputstream.available() > 1024)
            {
                i = 1024;
            } else
            {
                i = inputstream.available();
            }
            abyte0 = new byte[i];
            do
            {
                if (inputstream.read(abyte0) == -1)
                {
                    break;
                }
                bytebuffer.put(abyte0);
                if (inputstream.available() > 0)
                {
                    if (inputstream.available() > 1024)
                    {
                        i = 1024;
                    } else
                    {
                        i = inputstream.available();
                    }
                    abyte0 = new byte[i];
                }
            } while (true);
        }
    }

    public static void copyFile(String s, String s1)
        throws IOException
    {
        copyFile(new File(s), new File(s1));
    }

    public static void copyFileChannel(File file, File file1)
        throws IOException
    {
        file = new FileInputStream(file);
        file1 = new FileOutputStream(file1);
        FileChannel filechannel = file.getChannel();
        file1.getChannel().transferFrom(filechannel, 0L, filechannel.size());
        file.close();
        file1.close();
    }

    public static void createNoMediaFile(File file)
    {
        if (file == null || !file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        file = new File(file, ".nomedia");
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_34;
        }
        file.createNewFile();
        return;
        file;
        file.printStackTrace();
        return;
    }

    public static void deleteDirectory(File file)
        throws IOException
    {
        Log.i("io-utils", (new StringBuilder()).append("deleteDirectory: ").append(file.getAbsolutePath()).toString());
        if (file.exists())
        {
            if (!FileUtils.isSymlink(file))
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

    public static ByteArrayInputStream download(String s, List list)
        throws IOException
    {
        String s1 = s;
        if (list != null)
        {
            s1 = (new StringBuilder()).append(s).append(URLEncodedUtils.format(list, "utf-8")).toString();
        }
        Log.i("io-utils", (new StringBuilder()).append("download: ").append(s1).toString());
        s = OK_URL_FACTORY.open(new URL(s1));
        int i = s.getResponseCode();
        if (i >= 300)
        {
            list = s.getResponseMessage();
            s.disconnect();
            throw new IOException((new StringBuilder()).append(i).append(": ").append(list).toString());
        } else
        {
            s = s.getInputStream();
            list = org.apache.commons.io.IOUtils.toByteArray(s);
            closeSilently(s);
            return new ByteArrayInputStream(list);
        }
    }

    public static InputStream ensureMarkSupported(InputStream inputstream)
        throws IOException
    {
        Object obj = inputstream;
        if (!inputstream.markSupported())
        {
            obj = new ByteArrayOutputStream();
            copyFile(inputstream, ((OutputStream) (obj)));
            closeSilently(inputstream);
            obj = new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
        }
        return ((InputStream) (obj));
    }

    public static void forceDelete(File file)
        throws IOException
    {
        Log.i("io-utils", (new StringBuilder()).append("forceDelete: ").append(file.getAbsolutePath()).toString());
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

    public static ByteArrayInputStream fromStream(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        copyFile(inputstream, bytearrayoutputstream);
        bytearrayoutputstream.flush();
        return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
    }

    public static String getNewFileName(String s)
    {
        Object obj = new File(s);
        String s1 = ".tmp";
        if (s.indexOf(".") > -1)
        {
            s1 = s.substring(s.lastIndexOf("."));
        }
        s = new File(((File) (obj)).getParent());
        int i = 0;
        obj = ((File) (obj)).getName();
        obj = ((String) (obj)).substring(0, ((String) (obj)).lastIndexOf("."));
        int j;
        do
        {
            j = i + 1;
            i = j;
        } while ((new File((new StringBuilder()).append(s.toString()).append("/").append(((String) (obj))).append("-").append(j).append(s1).toString())).exists());
        return (new StringBuilder()).append(((String) (obj))).append("-").append(j).append(".").append(s1).toString();
    }

    public static String getRealFilePath(Context context, Uri uri)
    {
        if (uri != null)
        {
            String s = uri.getScheme();
            Object obj = null;
            if (s == null)
            {
                return uri.getPath();
            }
            if ("file".equals(s))
            {
                return uri.getPath();
            }
            if ("content".equals(s))
            {
                try
                {
                    uri = context.getContentResolver().query(uri, new String[] {
                        "_data"
                    }, null, null, null);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return null;
                }
                if (uri != null)
                {
                    context = obj;
                    if (uri.moveToFirst())
                    {
                        int i = uri.getColumnIndex("_data");
                        context = obj;
                        if (i > -1)
                        {
                            context = uri.getString(i);
                        }
                    }
                    uri.close();
                    return context;
                }
            }
        }
        return null;
    }

    public static InputStream hunt(Context context, String s)
        throws IOException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IOException("url cannot be null");
        }
        Log.i("io-utils", (new StringBuilder()).append("hunt: ").append(s).toString());
        Uri uri = Uri.parse(s);
        String s1 = uri.getScheme();
        if ("content".equals(s1))
        {
            return context.getContentResolver().openInputStream(uri);
        }
        if ("file".equals(s1) || s1 == null)
        {
            if (!uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0)))
            {
                s = uri.toString().substring(ASSET_PREFIX_LENGTH);
                return context.getAssets().open(s);
            } else
            {
                return context.getContentResolver().openInputStream(uri);
            }
        } else
        {
            return download(s, null);
        }
    }

    private static boolean mkdir(File file)
    {
        if (file.exists())
        {
            return true;
        } else
        {
            return file.mkdirs();
        }
    }

    public static File mkdirs(File file, String s)
    {
        if (file.exists() && file.isDirectory())
        {
            File file1 = file.getAbsoluteFile();
            String as[];
            if (File.separatorChar == '\\')
            {
                file = "\\\\";
            } else
            {
                file = File.separator;
            }
            as = s.split(file);
            if (as.length > 1)
            {
                int i = 0;
                s = file1;
                do
                {
                    file = s;
                    if (i >= as.length)
                    {
                        break;
                    }
                    s = new File(s, as[i]);
                    Log.d("io-utils", (new StringBuilder()).append("file: ").append(s.getAbsolutePath()).toString());
                    i++;
                } while (true);
            } else
            {
                file = file1;
                if (as.length == 1)
                {
                    file = new File(file1, s);
                }
            }
            if (!file.exists())
            {
                break MISSING_BLOCK_LABEL_140;
            }
            while (file.isDirectory()) 
            {
                do
                {
                    return file;
                } while (file.mkdirs() || file.isDirectory());
                return null;
            }
        }
        return null;
    }

    public static boolean readFileFromZip(ZipFile zipfile, String s, OutputStream outputstream)
        throws IOException
    {
        s = zipfile.getEntry(s);
        if (s != null)
        {
            copyFile(zipfile.getInputStream(s), outputstream);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean readFileFromZip(ZipInputStream zipinputstream, String s, OutputStream outputstream)
        throws IOException
    {
        do
        {
            ZipEntry zipentry;
label0:
            {
                if (zipinputstream.available() > 0)
                {
                    zipentry = zipinputstream.getNextEntry();
                    if (zipentry != null)
                    {
                        break label0;
                    }
                }
                return false;
            }
            if (zipentry.getName().equals(s))
            {
                copyFile(zipinputstream, outputstream);
                zipinputstream.closeEntry();
                return true;
            }
            zipinputstream.closeEntry();
        } while (true);
    }

    public static boolean readFileFromZip(ZipInputStream zipinputstream, String s, ByteBuffer bytebuffer)
        throws IOException
    {
        do
        {
            ZipEntry zipentry;
label0:
            {
                if (zipinputstream.available() > 0)
                {
                    zipentry = zipinputstream.getNextEntry();
                    if (zipentry != null)
                    {
                        break label0;
                    }
                }
                return false;
            }
            if (zipentry.getName().equals(s))
            {
                copyFile(zipinputstream, bytebuffer);
                zipinputstream.closeEntry();
                return true;
            }
            zipinputstream.closeEntry();
        } while (true);
    }

    public static String readFully(InputStream inputstream)
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (inputstream = new Scanner(inputstream); inputstream.hasNextLine(); stringbuilder.append(inputstream.nextLine())) { }
        return stringbuilder.toString();
    }

    public static void saveFile(File file, String s)
        throws IOException
    {
        s = new ByteArrayInputStream(s.getBytes("UTF8"));
        file = new FileOutputStream(file);
        copyFile(s, file);
        closeSilently(file);
        closeSilently(s);
        return;
        Exception exception;
        exception;
        closeSilently(file);
        closeSilently(s);
        throw exception;
    }

    public static void unzip(InputStream inputstream, File file)
        throws IOException
    {
        if (file == null)
        {
            throw new IOException("destination folder is null");
        }
        if (inputstream == null)
        {
            throw new IOException("Input is null");
        }
        Log.i("io-utils", (new StringBuilder()).append("unzip to ").append(file.getAbsolutePath()).toString());
        boolean flag = false;
        inputstream = new ZipInputStream(inputstream);
        do
        {
            ZipEntry zipentry = inputstream.getNextEntry();
            if (zipentry == null)
            {
                break;
            }
            unzipEntry(zipentry, inputstream, file);
            flag = true;
            inputstream.closeEntry();
        } while (true);
        closeSilently(inputstream);
        if (!flag)
        {
            throw new IOException("invalid zip file");
        } else
        {
            return;
        }
    }

    private static void unzipEntry(ZipEntry zipentry, ZipInputStream zipinputstream, File file)
        throws IOException
    {
        if (zipentry.isDirectory())
        {
            mkdirs(file, zipentry.getName());
            return;
        }
        zipentry = new File(file, zipentry.getName());
        if (!zipentry.getParentFile().exists())
        {
            mkdir(zipentry.getParentFile());
        }
        zipentry = new BufferedOutputStream(new FileOutputStream(zipentry));
        copyFile(zipinputstream, zipentry);
        zipentry.flush();
        closeSilently(zipentry);
    }

}
