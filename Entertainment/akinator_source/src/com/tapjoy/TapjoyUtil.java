// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.tapjoy:
//            TapjoyLog, TapjoyConnectCore

public class TapjoyUtil
{

    private static String a = null;
    private static HashMap b = new HashMap();

    public TapjoyUtil()
    {
    }

    public static String SHA1(String s)
    {
        return a("SHA-1", s);
    }

    public static String SHA256(String s)
    {
        return a("SHA-256", s);
    }

    private static String a(String s, String s1)
    {
        int i;
        s = MessageDigest.getInstance(s);
        s.update(s1.getBytes("iso-8859-1"), 0, s1.length());
        s = s.digest();
        s1 = new StringBuffer();
        i = 0;
_L2:
        int j;
        int k;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        k = s[i] >>> 4 & 0xf;
        j = 0;
_L3:
        if (k >= 0 && k <= 9)
        {
            s1.append((char)(k + 48));
        } else
        {
            s1.append((char)((k - 10) + 97));
        }
        k = s[i];
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return s1.toString();
        j++;
        k &= 0xf;
          goto _L3
    }

    public static Document buildDocument(String s)
    {
        try
        {
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            s = new ByteArrayInputStream(s.getBytes("UTF-8"));
            s = documentbuilderfactory.newDocumentBuilder().parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            TapjoyLog.e("TapjoyUtil", (new StringBuilder("buildDocument exception: ")).append(s.toString()).toString());
            return null;
        }
        return s;
    }

    public static String convertURLParams(Map map, boolean flag)
    {
        Iterator iterator = map.entrySet().iterator();
        map = "";
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = map;
            if (map.length() > 0)
            {
                obj = (new StringBuilder()).append(map).append("&").toString();
            }
            if (flag)
            {
                map = (new StringBuilder()).append(((String) (obj))).append(Uri.encode((String)entry.getKey())).append("=").append(Uri.encode((String)entry.getValue())).toString();
            } else
            {
                map = (new StringBuilder()).append(((String) (obj))).append((String)entry.getKey()).append("=").append((String)entry.getValue()).toString();
            }
        }
        return map;
    }

    public static Map convertURLParams(String s, boolean flag)
    {
        HashMap hashmap = new HashMap();
        String s1 = "";
        String s3 = "";
        boolean flag2 = false;
        int i = 0;
        while (i < s.length() && i != -1) 
        {
            char c = s.charAt(i);
            String s2;
            String s4;
            boolean flag1;
            if (!flag2)
            {
                if (c == '=')
                {
                    if (flag)
                    {
                        s1 = Uri.decode(s1);
                    }
                    s2 = "";
                    flag1 = true;
                    s4 = s1;
                } else
                {
                    s2 = (new StringBuilder()).append(s1).append(c).toString();
                    s4 = s3;
                    flag1 = flag2;
                }
            } else
            {
                s4 = s3;
                s2 = s1;
                flag1 = flag2;
                if (flag2)
                {
                    if (c == '&')
                    {
                        if (flag)
                        {
                            s1 = Uri.decode(s1);
                        }
                        s2 = "";
                        hashmap.put(s3, s1);
                        flag1 = false;
                        s4 = s3;
                    } else
                    {
                        s2 = (new StringBuilder()).append(s1).append(c).toString();
                        s4 = s3;
                        flag1 = flag2;
                    }
                }
            }
            i++;
            s3 = s4;
            s1 = s2;
            flag2 = flag1;
        }
        if (flag2 && s1.length() > 0)
        {
            s = s1;
            if (flag)
            {
                s = Uri.decode(s1);
            }
            hashmap.put(s3, s);
        }
        return hashmap;
    }

    public static String copyTextFromJarIntoString(String s)
    {
        return copyTextFromJarIntoString(s, null);
    }

    public static String copyTextFromJarIntoString(String s, Context context)
    {
        Object obj;
        Object obj1;
        byte abyte0[];
        StringBuffer stringbuffer;
        obj1 = null;
        abyte0 = new byte[1024];
        stringbuffer = new StringBuffer();
        obj = com/tapjoy/TapjoyUtil.getClassLoader().getResource(s);
        if (context == null || obj != null) goto _L2; else goto _L1
_L1:
        s = context.getAssets().open(s);
_L5:
        context = s;
        int i = s.read(abyte0);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        context = s;
        stringbuffer.append((new String(abyte0)).substring(0, i));
          goto _L5
        obj;
_L8:
        context = s;
        TapjoyLog.d("TapjoyUtil", (new StringBuilder("file exception: ")).append(((Exception) (obj)).toString()).toString());
        context = s;
        ((Exception) (obj)).printStackTrace();
        context = obj1;
        if (s != null)
        {
            int j;
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            context = obj1;
        }
        return context;
_L2:
        obj = ((URL) (obj)).getFile();
        context = ((Context) (obj));
        if (((String) (obj)).startsWith("jar:"))
        {
            context = ((String) (obj)).substring(4);
        }
        obj = context;
        if (context.startsWith("file:"))
        {
            obj = context.substring(5);
        }
        j = ((String) (obj)).indexOf("!");
        context = ((Context) (obj));
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        context = ((String) (obj)).substring(0, j);
        context = new JarFile(context);
        s = context.getInputStream(context.getJarEntry(s));
          goto _L5
_L4:
        context = s;
        obj = stringbuffer.toString();
        context = ((Context) (obj));
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return ((String) (obj));
            }
            return ((String) (obj));
        } else
        {
            break MISSING_BLOCK_LABEL_131;
        }
        s;
        context = null;
_L7:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw s;
        s;
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        s = null;
          goto _L8
    }

    public static Bitmap createBitmapFromView(View view)
    {
        Canvas canvas = null;
        Bitmap bitmap = null;
        Bitmap bitmap1 = bitmap;
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        bitmap1 = bitmap;
        if (view.getLayoutParams().width <= 0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        bitmap1 = bitmap;
        if (view.getLayoutParams().height <= 0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        bitmap = canvas;
        try
        {
            bitmap1 = Bitmap.createBitmap(view.getLayoutParams().width, view.getLayoutParams().height, android.graphics.Bitmap.Config.ARGB_8888);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            TapjoyLog.i("TapjoyUtil", (new StringBuilder("error creating bitmap: ")).append(view.toString()).toString());
            return bitmap;
        }
        bitmap = bitmap1;
        canvas = new Canvas(bitmap1);
        bitmap = bitmap1;
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        bitmap = bitmap1;
        view.draw(canvas);
        return bitmap1;
    }

    public static void deleteFileOrDirectory(File file)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                deleteFileOrDirectory(afile[i]);
            }

        }
        TapjoyLog.i("TapjoyUtil", "****************************************");
        TapjoyLog.i("TapjoyUtil", (new StringBuilder("deleteFileOrDirectory: ")).append(file.getAbsolutePath()).toString());
        TapjoyLog.i("TapjoyUtil", "****************************************");
        file.delete();
    }

    public static String determineMimeType(String s)
    {
        String s2 = "";
        String s1 = s;
        if (s.endsWith("."))
        {
            s1 = s.substring(0, s.length() - 1);
        }
        s = s2;
        if (s1.lastIndexOf('.') != -1)
        {
            s = s1.substring(s1.lastIndexOf('.') + 1);
        }
        if (s.equals("css"))
        {
            return "text/css";
        }
        if (s.equals("js"))
        {
            return "text/javascript";
        }
        if (s.equals("html"))
        {
            return "text/html";
        } else
        {
            return "application/octet-stream";
        }
    }

    public static long fileOrDirectorySize(File file)
    {
        file = file.listFiles();
        int j = file.length;
        long l = 0L;
        int i = 0;
        while (i < j) 
        {
            File file1 = file[i];
            if (file1.isFile())
            {
                l += file1.length();
            } else
            {
                l += fileOrDirectorySize(file1);
            }
            i++;
        }
        return l;
    }

    public static String getNodeTrimValue(NodeList nodelist)
    {
        int i = 0;
        nodelist = (Element)nodelist.item(0);
        if (nodelist != null)
        {
            NodeList nodelist1 = nodelist.getChildNodes();
            int j = nodelist1.getLength();
            Object obj;
            for (nodelist = ""; i < j; nodelist = ((NodeList) (obj)))
            {
                Node node = nodelist1.item(i);
                obj = nodelist;
                if (node != null)
                {
                    obj = (new StringBuilder()).append(nodelist).append(node.getNodeValue()).toString();
                }
                i++;
            }

            if (nodelist != null && !nodelist.equals(""))
            {
                return nodelist.trim();
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    public static String getRedirectDomain(String s)
    {
        String s1 = "";
        if (s != null)
        {
            s1 = s.substring(s.indexOf("//") + 2, s.lastIndexOf("/"));
        }
        return s1;
    }

    public static Object getResource(String s)
    {
        return b.get(s);
    }

    public static Bitmap loadBitmapFromJar(String s, Context context)
    {
        Object obj2 = null;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        byte abyte0[] = (byte[])(byte[])getResource(s);
        float f;
        Object obj;
        Object obj1;
        Object obj3;
        int i;
        if (abyte0 != null)
        {
            BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
            obj = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        } else
        {
            obj = null;
        }
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj1 = (new StringBuilder("com/tapjoy/res/")).append(s).toString();
        s = com/tapjoy/TapjoyUtil.getClassLoader().getResource(((String) (obj1)));
        if (s != null) goto _L4; else goto _L3
_L3:
        obj3 = context.getAssets();
        obj = ((AssetManager) (obj3)).open(((String) (obj1)));
        s = ((String) (obj));
        context = ((Context) (obj));
        BitmapFactory.decodeStream(((InputStream) (obj)), null, options);
        s = ((String) (obj));
        context = ((Context) (obj));
        obj = ((AssetManager) (obj3)).open(((String) (obj1)));
_L6:
        s = ((String) (obj));
        context = ((Context) (obj));
        obj1 = BitmapFactory.decodeStream(((InputStream) (obj)));
        s = ((String) (obj1));
        obj1 = s;
        if (obj == null) goto _L2; else goto _L5
_L5:
        ((InputStream) (obj)).close();
        obj1 = s;
_L2:
        f = TapjoyConnectCore.getDeviceScreenDensityScale();
        s = ((String) (obj1));
        if (obj1 != null)
        {
            s = Bitmap.createScaledBitmap(((Bitmap) (obj1)), (int)((float)options.outWidth * f), (int)(f * (float)options.outHeight), true);
        }
        return s;
_L4:
        context = s.getFile();
        s = context;
        if (context.startsWith("jar:"))
        {
            s = context.substring(4);
        }
        context = s;
        if (s.startsWith("file:"))
        {
            context = s.substring(5);
        }
        i = context.indexOf("!");
        s = context;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        s = context.substring(0, i);
        obj3 = new JarFile(s);
        obj1 = ((JarFile) (obj3)).getJarEntry(((String) (obj1)));
        obj = ((JarFile) (obj3)).getInputStream(((java.util.zip.ZipEntry) (obj1)));
        s = ((String) (obj));
        context = ((Context) (obj));
        BitmapFactory.decodeStream(((InputStream) (obj)), null, options);
        s = ((String) (obj));
        context = ((Context) (obj));
        obj = ((JarFile) (obj3)).getInputStream(((java.util.zip.ZipEntry) (obj1)));
          goto _L6
        obj;
        context = null;
_L8:
        s = context;
        ((Exception) (obj)).printStackTrace();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return null;
        s;
        context = obj2;
_L7:
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        throw s;
        context;
        obj1 = s;
          goto _L2
        obj;
        context = s;
        s = ((String) (obj));
          goto _L7
        obj;
          goto _L8
    }

    public static void runOnMainThread(Runnable runnable)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            runnable.run();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
            return;
        }
    }

    public static void safePut(Map map, String s, String s1, boolean flag)
    {
label0:
        {
            if (s != null && s.length() > 0 && s1 != null && s1.length() > 0)
            {
                if (!flag)
                {
                    break label0;
                }
                map.put(Uri.encode(s), Uri.encode(s1));
            }
            return;
        }
        map.put(s, s1);
    }

    public static View scaleDisplayAd(View view, int i)
    {
        int j = view.getLayoutParams().width;
        int k = view.getLayoutParams().height;
        TapjoyLog.i("TapjoyUtil", (new StringBuilder("wxh: ")).append(j).append("x").append(k).toString());
        if (j > i)
        {
            int l = Double.valueOf(Double.valueOf(Double.valueOf(i).doubleValue() / Double.valueOf(j).doubleValue()).doubleValue() * 100D).intValue();
            ((WebView)(WebView)view).getSettings().setSupportZoom(true);
            ((WebView)(WebView)view).setPadding(0, 0, 0, 0);
            ((WebView)(WebView)view).setVerticalScrollBarEnabled(false);
            ((WebView)(WebView)view).setHorizontalScrollBarEnabled(false);
            ((WebView)(WebView)view).setInitialScale(l);
            view.setLayoutParams(new android.view.ViewGroup.LayoutParams(i, (k * i) / j));
        }
        return view;
    }

    public static void setResource(String s, Object obj)
    {
        b.put(s, obj);
    }

    public static void writeFileToDevice(BufferedInputStream bufferedinputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = bufferedinputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

}
