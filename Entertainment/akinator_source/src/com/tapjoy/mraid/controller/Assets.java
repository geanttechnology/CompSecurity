// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.view.MraidView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarFile;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Abstract

public class Assets extends Abstract
{

    private static final char d[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private int c;

    public Assets(MraidView mraidview, Context context)
    {
        super(mraidview, context);
        c = 0;
    }

    private String a()
    {
        return b.getFilesDir().getPath();
    }

    private static String a(String s, String s1, String s2)
    {
        s = new File((new StringBuilder()).append(s1).append(File.separator).append(s).toString());
        (new File((new StringBuilder()).append(s1).append(File.separator).append("ad").toString())).mkdir();
        s1 = new File((new StringBuilder()).append(s1).append(File.separator).append("ad").append(File.separator).append(s2).toString());
        s1.mkdir();
        s.renameTo(new File(s1, s.getName()));
        return (new StringBuilder()).append(s1.getPath()).append(File.separator).toString();
    }

    private static String a(MessageDigest messagedigest)
    {
        int j = 0;
        messagedigest = messagedigest.digest();
        char ac[] = new char[messagedigest.length * 2];
        for (int i = 0; i < messagedigest.length; i++)
        {
            int k = j + 1;
            ac[j] = d[messagedigest[i] >>> 4 & 0xf];
            j = k + 1;
            ac[k] = d[messagedigest[i] & 0xf];
        }

        return new String(ac);
    }

    private static HttpEntity a(String s)
    {
        try
        {
            s = (new DefaultHttpClient()).execute(new HttpGet(s)).getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    private static void a(StringBuffer stringbuffer, String s, String s1)
    {
        int i = stringbuffer.indexOf(s);
        TapjoyLog.d("replace ", s1);
        stringbuffer.replace(i, s.length() + i, (new StringBuilder("file://")).append(s1).toString());
    }

    private static boolean a(StringBuffer stringbuffer, String s)
    {
        int i = stringbuffer.indexOf(s);
        if (i >= 0)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_34;
        stringbuffer;
        TapjoyLog.d("contains", (new StringBuilder("html file does not contain ")).append(s).toString());
        return false;
    }

    private File b(String s)
    {
        File file = b.getFilesDir();
        return new File((new StringBuilder()).append(file.getPath()).append(File.separator).append(s).toString());
    }

    private static String c(String s)
    {
        int i = s.lastIndexOf(File.separatorChar);
        String s1 = "/";
        if (i >= 0)
        {
            s1 = s.substring(0, s.lastIndexOf(File.separatorChar));
        }
        return s1;
    }

    private static String d(String s)
    {
        String s1 = s;
        if (s.lastIndexOf(File.separatorChar) >= 0)
        {
            s1 = s.substring(s.lastIndexOf(File.separatorChar) + 1);
        }
        return s1;
    }

    public static boolean deleteDirectory(File file)
    {
        if (file.exists())
        {
            File afile[] = file.listFiles();
            int i = 0;
            while (i < afile.length) 
            {
                if (afile[i].isDirectory())
                {
                    deleteDirectory(afile[i]);
                } else
                {
                    afile[i].delete();
                }
                i++;
            }
        }
        return file.delete();
    }

    public static boolean deleteDirectory(String s)
    {
        if (s != null)
        {
            return deleteDirectory(new File(s));
        } else
        {
            return false;
        }
    }

    public void addAsset(String s, String s1)
    {
        Object obj;
        HttpEntity httpentity;
        httpentity = a(s1);
        obj = null;
        s1 = null;
        InputStream inputstream = httpentity.getContent();
        s1 = inputstream;
        obj = inputstream;
        writeToDisk(inputstream, s, false);
        s1 = inputstream;
        obj = inputstream;
        s = (new StringBuilder("MraidAdController.addedAsset('")).append(s).append("' )").toString();
        s1 = inputstream;
        obj = inputstream;
        a.injectMraidJavaScript(s);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        try
        {
            httpentity.consumeContent();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_132;
        s;
        obj = s1;
        s.printStackTrace();
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        break MISSING_BLOCK_LABEL_86;
        s;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
    }

    public int cacheRemaining()
    {
        StatFs statfs = new StatFs(b.getFilesDir().getPath());
        return statfs.getFreeBlocks() * statfs.getBlockSize();
    }

    public String copyTextFromJarIntoAssetDir(String s, String s1)
    {
        Object obj2 = null;
        Object obj = com/tapjoy/mraid/controller/Assets.getClassLoader().getResource(s1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        s1 = b.getAssets().open(s1);
_L4:
        obj = s1;
        s = writeToDisk(s1, s, false);
        obj = s;
        if (s1 != null)
        {
            Object obj1;
            int i;
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return s;
            }
            obj = s;
        }
        return ((String) (obj));
_L2:
        obj1 = ((URL) (obj)).getFile();
        obj = obj1;
        if (((String) (obj1)).startsWith("jar:"))
        {
            obj = ((String) (obj1)).substring(4);
        }
        obj1 = obj;
        if (((String) (obj)).startsWith("file:"))
        {
            obj1 = ((String) (obj)).substring(5);
        }
        i = ((String) (obj1)).indexOf("!");
        obj = obj1;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        obj = ((String) (obj1)).substring(0, i);
        obj = new JarFile(((String) (obj)));
        s1 = ((JarFile) (obj)).getInputStream(((JarFile) (obj)).getJarEntry(s1));
        if (true) goto _L4; else goto _L3
_L3:
        s;
        s1 = null;
_L8:
        obj = s1;
        TapjoyLog.e("MRAID Assets", (new StringBuilder("copyTextFromJarIntoAssetDir: ")).append(s.toString()).toString());
        obj = obj2;
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return null;
        } else
        {
            break MISSING_BLOCK_LABEL_51;
        }
        s;
        obj = null;
_L6:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void deleteOldAds()
    {
        String s = a();
        deleteDirectory(new File((new StringBuilder()).append(s).append(File.separator).append("ad").toString()));
    }

    public FileOutputStream getAssetOutputString(String s)
    {
        File file = b(c(s));
        file.mkdirs();
        return new FileOutputStream(new File(file, d(s)));
    }

    public String getAssetPath()
    {
        return (new StringBuilder("file://")).append(b.getFilesDir()).append("/").toString();
    }

    public void removeAsset(String s)
    {
        File file = b(c(s));
        file.mkdirs();
        (new File(file, d(s))).delete();
        s = (new StringBuilder("MraidAdController.assetRemoved('")).append(s).append("' )").toString();
        a.injectMraidJavaScript(s);
    }

    public void stopAllListeners()
    {
    }

    public void storePicture(String s)
    {
        TapjoyLog.d("MRAID Assets", (new StringBuilder("Storing media from ")).append(s).append(" to device photo album.  Output directory: ").append(Environment.getExternalStorageDirectory()).append(" state: ").append(Environment.getExternalStorageState()).toString());
        c = c + 1;
        Object obj;
        Object obj1;
        long l;
        obj = new URL(s);
        obj1 = (new StringBuilder("MraidMedia")).append(c).append(".jpg").toString();
        s = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append("/").append(((String) (obj1))).toString());
        l = System.currentTimeMillis();
        Log.d("MRAID Assets", "download beginning");
        Log.d("MRAID Assets", (new StringBuilder("download url:")).append(obj).toString());
        Log.d("MRAID Assets", (new StringBuilder("downloaded file name:")).append(((String) (obj1))).toString());
        obj1 = new BufferedInputStream(((URL) (obj)).openConnection().getInputStream());
        obj = new ByteArrayBuffer(50);
_L1:
        int i = ((BufferedInputStream) (obj1)).read();
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                ((ByteArrayBuffer) (obj)).append((byte)i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.d("MRAID Assets", (new StringBuilder("Error: ")).append(s).toString());
                return;
            }
        }
          goto _L1
        s = new FileOutputStream(s);
        s.write(((ByteArrayBuffer) (obj)).toByteArray());
        s.close();
        Log.d("MRAID Assets", (new StringBuilder("download ready in")).append((System.currentTimeMillis() - l) / 1000L).append(" sec").toString());
        return;
    }

    public void storePictureInit(String s)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(b);
        builder.setMessage((new StringBuilder("Are you sure you want to save file from ")).append(s).append(" to your SD card?").toString());
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new android.content.DialogInterface.OnClickListener(s) {

            final String a;
            final Assets b;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                b.storePicture(a);
            }

            
            {
                b = Assets.this;
                a = s;
                super();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    public String writeToDisk(InputStream inputstream, String s, boolean flag)
    {
        FileOutputStream fileoutputstream;
        byte abyte0[];
        fileoutputstream = null;
        abyte0 = new byte[1024];
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = MessageDigest.getInstance("MD5");
_L6:
        FileOutputStream fileoutputstream1 = getAssetOutputString(s);
_L4:
        fileoutputstream = fileoutputstream1;
        int i = inputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag || obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        fileoutputstream = fileoutputstream1;
        ((MessageDigest) (obj)).update(abyte0);
        fileoutputstream = fileoutputstream1;
        fileoutputstream1.write(abyte0, 0, i);
        if (true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        inputstream;
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw inputstream;
        obj;
        ((NoSuchAlgorithmException) (obj)).printStackTrace();
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        fileoutputstream = fileoutputstream1;
        fileoutputstream1.flush();
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        inputstream = a();
        if (flag && obj != null)
        {
            inputstream = a(s, inputstream, a(((MessageDigest) (obj))));
        }
        return (new StringBuilder()).append(inputstream).append(s).toString();
    }

    public String writeToDiskWrap(InputStream inputstream, String s, boolean flag, String s1, String s2)
    {
        Object obj1;
        byte abyte0[];
        boolean flag1;
        obj1 = null;
        flag1 = false;
        abyte0 = new byte[1024];
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = MessageDigest.getInstance("MD5");
_L6:
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
_L4:
        InputStream inputstream1 = obj1;
        int i = inputstream.read(abyte0);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag || obj == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        inputstream1 = obj1;
        ((MessageDigest) (obj)).update(abyte0);
        inputstream1 = obj1;
        bytearrayoutputstream.write(abyte0, 0, i);
        if (true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        inputstream;
        StringBuffer stringbuffer;
        try
        {
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw inputstream;
        obj;
        ((NoSuchAlgorithmException) (obj)).printStackTrace();
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        inputstream1 = obj1;
        inputstream = bytearrayoutputstream.toString();
        inputstream1 = obj1;
        if (inputstream.indexOf("</html>") >= 0)
        {
            flag1 = true;
        }
        inputstream1 = obj1;
        stringbuffer = new StringBuffer(inputstream);
        if (!flag1) goto _L8; else goto _L7
_L7:
        inputstream1 = obj1;
        if (!a(stringbuffer, "mraid.js")) goto _L10; else goto _L9
_L9:
        inputstream1 = obj1;
        a(stringbuffer, "mraid.js", s2);
_L8:
        inputstream1 = obj1;
        inputstream = getAssetOutputString(s);
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        inputstream1 = inputstream;
        inputstream.write("<html>".getBytes());
        inputstream1 = inputstream;
        inputstream.write("<head>".getBytes());
        inputstream1 = inputstream;
        inputstream.write("<meta name='viewport' content='user-scalable=no initial-scale=1.0' />".getBytes());
        inputstream1 = inputstream;
        inputstream.write("<title>Advertisement</title> ".getBytes());
        inputstream1 = inputstream;
        inputstream.write((new StringBuilder("<script src=\"file://")).append(s2).append("\" type=\"text/javascript\"></script>").toString().getBytes());
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        inputstream1 = inputstream;
        inputstream.write("<script type=\"text/javascript\">".getBytes());
        inputstream1 = inputstream;
        inputstream.write(s1.getBytes());
        inputstream1 = inputstream;
        inputstream.write("</script>".getBytes());
        inputstream1 = inputstream;
        inputstream.write("</head>".getBytes());
        inputstream1 = inputstream;
        inputstream.write("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;\">".getBytes());
        inputstream1 = inputstream;
        inputstream.write("<div align=\"center\"> ".getBytes());
        if (flag1) goto _L12; else goto _L11
_L11:
        inputstream1 = inputstream;
        inputstream.write(bytearrayoutputstream.toByteArray());
_L14:
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        inputstream1 = inputstream;
        inputstream.write("</div> ".getBytes());
        inputstream1 = inputstream;
        inputstream.write("</body> ".getBytes());
        inputstream1 = inputstream;
        inputstream.write("</html> ".getBytes());
        inputstream1 = inputstream;
        inputstream.flush();
        try
        {
            bytearrayoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
        }
        inputstream = a();
        if (flag && obj != null)
        {
            return a(s, inputstream, a(((MessageDigest) (obj))));
        } else
        {
            return inputstream;
        }
_L10:
        inputstream1 = obj1;
        if (!a(stringbuffer, "ormma.js"))
        {
            break MISSING_BLOCK_LABEL_515;
        }
        inputstream1 = obj1;
        a(stringbuffer, "ormma.js", s2);
          goto _L8
        inputstream1 = obj1;
        if (!a(stringbuffer, "ormma_bridge.js")) goto _L8; else goto _L13
_L13:
        inputstream1 = obj1;
        a(stringbuffer, "ormma_bridge.js", s2);
          goto _L8
_L12:
        inputstream1 = inputstream;
        inputstream.write(stringbuffer.toString().getBytes());
          goto _L14
    }

}
