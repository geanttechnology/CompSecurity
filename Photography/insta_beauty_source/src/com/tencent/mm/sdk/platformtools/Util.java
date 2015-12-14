// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import com.tencent.mm.algorithm.MD5;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.Assert;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public final class Util
{

    public static final int BEGIN_TIME = 22;
    public static final int BIT_OF_KB = 10;
    public static final int BIT_OF_MB = 20;
    public static final int BYTE_OF_KB = 1024;
    public static final int BYTE_OF_MB = 0x100000;
    public static final String CHINA = "zh_CN";
    public static final int DAY = 0;
    public static final int END_TIME = 8;
    public static final String ENGLISH = "en";
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String HONGKONG = "zh_HK";
    public static final String LANGUAGE_DEFAULT = "language_default";
    public static final int MASK_16BIT = 65535;
    public static final int MASK_32BIT = -1;
    public static final int MASK_4BIT = 15;
    public static final int MASK_8BIT = 255;
    public static final long MAX_32BIT_VALUE = 0xffffffffL;
    public static final int MAX_ACCOUNT_LENGTH = 20;
    public static final int MAX_DECODE_PICTURE_SIZE = 0x2a3000;
    public static final int MAX_PASSWORD_LENGTH = 9;
    public static final long MILLSECONDS_OF_DAY = 0x5265c00L;
    public static final long MILLSECONDS_OF_HOUR = 0x36ee80L;
    public static final long MILLSECONDS_OF_MINUTE = 60000L;
    public static final long MILLSECONDS_OF_SECOND = 1000L;
    public static final long MINUTE_OF_HOUR = 60L;
    public static final int MIN_ACCOUNT_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final String PHOTO_DEFAULT_EXT = ".jpg";
    public static final long SECOND_OF_MINUTE = 60L;
    public static final String TAIWAN = "zh_TW";
    private static final long bt[] = {
        300L, 200L, 300L, 200L
    };
    private static final char bu[] = {
        '\t', '\n', '\r'
    };
    private static final char bv[] = {
        '<', '>', '"', '\'', '&'
    };
    private static final String bw[] = {
        "&lt;", "&gt;", "&quot;", "&apos;", "&amp;"
    };

    private Util()
    {
    }

    public static String GetHostIp()
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration;
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
_L4:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress();
        return ((String) (obj));
        Object obj1;
        obj1;
_L6:
        return null;
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int UnZipFolder(String s, String s1)
    {
        Log.v("XZip", "UnZipFolder(String, String)");
        s = new ZipInputStream(new FileInputStream(s));
_L1:
        Object obj = s.getNextEntry();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        String s2;
label0:
        {
            s2 = ((ZipEntry) (obj)).getName();
            if (!((ZipEntry) (obj)).isDirectory())
            {
                break label0;
            }
            obj = s2.substring(0, s2.length() - 1);
            (new File((new StringBuilder()).append(s1).append(File.separator).append(((String) (obj))).toString())).mkdirs();
        }
          goto _L1
        byte abyte0[];
        obj = new File((new StringBuilder()).append(s1).append(File.separator).append(s2).toString());
        ((File) (obj)).createNewFile();
        obj = new FileOutputStream(((File) (obj)));
        abyte0 = new byte[1024];
_L2:
        int i = s.read(abyte0);
label1:
        {
            if (i == -1)
            {
                break label1;
            }
            try
            {
                ((FileOutputStream) (obj)).write(abyte0, 0, i);
                ((FileOutputStream) (obj)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return -1;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return -2;
            }
        }
          goto _L2
        ((FileOutputStream) (obj)).close();
          goto _L1
        s.close();
        return 0;
    }

    private static int a(char ac[], int i, int j)
    {
        if (j <= 0)
        {
            return 0;
        }
        if (ac[i] == '#')
        {
            if (j > 1 && (ac[i + 1] == 'x' || ac[i + 1] == 'X'))
            {
                try
                {
                    i = Integer.parseInt(new String(ac, i + 2, j - 2), 16);
                }
                // Misplaced declaration of an exception variable
                catch (char ac[])
                {
                    return 0;
                }
                return i;
            }
            try
            {
                i = Integer.parseInt(new String(ac, i + 1, j - 1), 10);
            }
            // Misplaced declaration of an exception variable
            catch (char ac[])
            {
                return 0;
            }
            return i;
        } else
        {
            new String(ac, i, j);
            return 0;
        }
    }

    private static void a(Map map, String s, Node node, int i)
    {
        boolean flag = false;
        if (node.getNodeName().equals("#text"))
        {
            map.put(s, node.getNodeValue());
        } else
        {
            if (node.getNodeName().equals("#cdata-section"))
            {
                map.put(s, node.getNodeValue());
                return;
            }
            Object obj = (new StringBuilder()).append(s).append(".").append(node.getNodeName());
            if (i > 0)
            {
                s = Integer.valueOf(i);
            } else
            {
                s = "";
            }
            s = ((StringBuilder) (obj)).append(s).toString();
            map.put(s, node.getNodeValue());
            obj = node.getAttributes();
            if (obj != null)
            {
                for (i = 0; i < ((NamedNodeMap) (obj)).getLength(); i++)
                {
                    Node node1 = ((NamedNodeMap) (obj)).item(i);
                    map.put((new StringBuilder()).append(s).append(".$").append(node1.getNodeName()).toString(), node1.getNodeValue());
                }

            }
            obj = new HashMap();
            node = node.getChildNodes();
            i = ((flag) ? 1 : 0);
            while (i < node.getLength()) 
            {
                Node node2 = node.item(i);
                int j = nullAsNil((Integer)((HashMap) (obj)).get(node2.getNodeName()));
                a(map, s, node2, j);
                ((HashMap) (obj)).put(node2.getNodeName(), Integer.valueOf(j + 1));
                i++;
            }
        }
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, bytearrayoutputstream);
        if (flag)
        {
            bitmap.recycle();
        }
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return bitmap;
        }
        return bitmap;
    }

    public static boolean checkPermission(Context context, String s)
    {
        Assert.assertNotNull(context);
        Object obj = context.getPackageName();
        boolean flag;
        if (context.getPackageManager().checkPermission(s, ((String) (obj))) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(" has ");
        if (flag)
        {
            context = "permission ";
        } else
        {
            context = "no permission ";
        }
        Log.d("MicroMsg.Util", ((StringBuilder) (obj)).append(context).append(s).toString());
        return flag;
    }

    public static boolean checkSDCardFull()
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long l = statfs.getBlockCount();
            long l1 = statfs.getAvailableBlocks();
            if (l > 0L && l - l1 >= 0L)
            {
                int i = (int)(((l - l1) * 100L) / l);
                long l2 = statfs.getBlockSize();
                l2 = (long)statfs.getFreeBlocks() * l2;
                Log.d("MicroMsg.Util", (new StringBuilder("checkSDCardFull per:")).append(i).append(" blockCount:").append(l).append(" availCount:").append(l1).append(" availSize:").append(l2).toString());
                if (95 <= i && l2 <= 0x3200000L)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_70;
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
            inputstream.printStackTrace();
        }
        throw exception;
    }

    public static long currentDayInMills()
    {
        return (nowMilliSecond() / 0x5265c00L) * 0x5265c00L;
    }

    public static long currentMonthInMills()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar = new GregorianCalendar(gregoriancalendar.get(1), gregoriancalendar.get(2), 1);
        gregoriancalendar.setTimeZone(GMT);
        return gregoriancalendar.getTimeInMillis();
    }

    public static long currentTicks()
    {
        return SystemClock.elapsedRealtime();
    }

    public static long currentWeekInMills()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        GregorianCalendar gregoriancalendar1 = new GregorianCalendar(gregoriancalendar.get(1), gregoriancalendar.get(2), gregoriancalendar.get(5));
        gregoriancalendar1.setTimeZone(GMT);
        gregoriancalendar1.add(6, -(gregoriancalendar.get(7) - gregoriancalendar.getFirstDayOfWeek()));
        return gregoriancalendar1.getTimeInMillis();
    }

    public static long currentYearInMills()
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar((new GregorianCalendar()).get(1), 1, 1);
        gregoriancalendar.setTimeZone(GMT);
        return gregoriancalendar.getTimeInMillis();
    }

    public static byte[] decodeHexString(String s)
    {
        if (s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = new byte[0];
_L4:
        return abyte0;
_L2:
        byte abyte1[];
        int i;
        try
        {
            abyte1 = new byte[s.length() / 2];
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return new byte[0];
        }
        i = 0;
        abyte0 = abyte1;
        if (i >= abyte1.length) goto _L4; else goto _L3
_L3:
        abyte1[i] = (byte)(Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16) & 0xff);
        i++;
        break MISSING_BLOCK_LABEL_28;
    }

    public static String dumpArray(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(aobj[i]);
            stringbuilder.append(",");
        }

        return stringbuilder.toString();
    }

    public static String dumpHex(byte abyte0[])
    {
        int i = 0;
        if (abyte0 == null)
        {
            return "(null)";
        }
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        int l = abyte0.length;
        char ac1[] = new char[l * 3 + l / 16];
        for (int j = 0; j < l; j++)
        {
            byte byte0 = abyte0[j];
            int i1 = i + 1;
            ac1[i] = ' ';
            int j1 = i1 + 1;
            ac1[i1] = ac[byte0 >>> 4 & 0xf];
            i = j1 + 1;
            ac1[j1] = ac[byte0 & 0xf];
            if (j % 16 == 0 && j > 0)
            {
                int k = i + 1;
                ac1[i] = '\n';
                i = k;
            }
        }

        return new String(ac1);
    }

    public static String encodeHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder("");
        if (abyte0 != null)
        {
            for (int i = 0; i < abyte0.length; i++)
            {
                stringbuilder.append(String.format("%02x", new Object[] {
                    Integer.valueOf(abyte0[i] & 0xff)
                }));
            }

        }
        return stringbuilder.toString();
    }

    public static String escapeSqlValue(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        return s1;
    }

    public static String escapeStringForXml(String s)
    {
        StringBuffer stringbuffer;
        int i;
        int k;
        if (s == null)
        {
            return "";
        }
        stringbuffer = new StringBuffer();
        k = s.length();
        i = 0;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        char c = s.charAt(i);
        if ((c >= ' ' || c == bu[0] || c == bu[1] || c == bu[2]) && c <= '\177') goto _L4; else goto _L3
_L3:
        stringbuffer.append("&#");
        stringbuffer.append(Integer.toString(c));
        stringbuffer.append(';');
_L8:
        i++;
          goto _L5
_L4:
        int j = bv.length - 1;
_L9:
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        if (bv[j] != c) goto _L7; else goto _L6
_L6:
        stringbuffer.append(bw[j]);
        j = 0;
_L10:
        if (j != 0)
        {
            stringbuffer.append(c);
        }
          goto _L8
_L7:
        j--;
          goto _L9
_L2:
        return stringbuffer.toString();
        j = 1;
          goto _L10
    }

    public static String expandEntities(String s)
    {
        int j1 = s.length();
        char ac[] = new char[j1];
        int i1 = 0;
        int i = 0;
        int j = -1;
        while (i1 < j1) 
        {
            char c = s.charAt(i1);
            int k = i + 1;
            ac[i] = c;
            int l;
            if (c == '&' && j == -1)
            {
                i = k;
                l = k;
            } else
            {
                i = j;
                l = k;
                if (j != -1)
                {
                    i = j;
                    l = k;
                    if (!Character.isLetter(c))
                    {
                        i = j;
                        l = k;
                        if (!Character.isDigit(c))
                        {
                            i = j;
                            l = k;
                            if (c != '#')
                            {
                                if (c == ';')
                                {
                                    i = a(ac, j, k - j - 1);
                                    if (i > 65535)
                                    {
                                        i -= 0x10000;
                                        ac[j - 1] = (char)((i >> 10) + 55296);
                                        ac[j] = (char)((i & 0x3ff) + 56320);
                                        i = j + 1;
                                    } else
                                    if (i != 0)
                                    {
                                        ac[j - 1] = (char)i;
                                        i = j;
                                    } else
                                    {
                                        i = k;
                                    }
                                    l = i;
                                    i = -1;
                                } else
                                {
                                    i = -1;
                                    l = k;
                                }
                            }
                        }
                    }
                }
            }
            i1++;
            j = i;
            i = l;
        }
        return new String(ac, 0, i);
    }

    public static String formatSecToMin(int i)
    {
        return String.format("%d:%02d", new Object[] {
            Long.valueOf((long)i / 60L), Long.valueOf((long)i % 60L)
        });
    }

    public static String formatUnixTime(long l)
    {
        return (new SimpleDateFormat("[yy-MM-dd HH:mm:ss]")).format(new Date(1000L * l));
    }

    public static void freeBitmapMap(Map map)
    {
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Bitmap bitmap = (Bitmap)((java.util.Map.Entry)iterator.next()).getValue();
            if (bitmap != null)
            {
                bitmap.recycle();
            }
        } while (true);
        map.clear();
    }

    public static String getCutPasswordMD5(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        if (s1.length() <= 16)
        {
            return getFullPasswordMD5(s1);
        } else
        {
            return getFullPasswordMD5(s1.substring(0, 16));
        }
    }

    public static String getDeviceId(Context context)
    {
        if (context == null)
        {
            return null;
        }
        context = (TelephonyManager)context.getSystemService("phone");
        if (context == null)
        {
            return null;
        }
        context = context.getDeviceId();
        if (context == null)
        {
            return null;
        }
        context = context.trim();
        return context;
        context;
        Log.e("MicroMsg.Util", "getDeviceId failed, security exception");
_L2:
        return null;
        context;
        context.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String getFullPasswordMD5(String s)
    {
        return MD5.getMessageDigest(s.getBytes());
    }

    public static int getHex(String s, int i)
    {
        if (s == null)
        {
            return i;
        }
        long l;
        try
        {
            l = Long.decode(s).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return i;
        }
        return (int)(l & 0xffffffffL);
    }

    public static android.graphics.BitmapFactory.Options getImageOptions(String s)
    {
        android.graphics.BitmapFactory.Options options;
        boolean flag;
        if (s != null && !s.equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try
        {
            s = BitmapFactory.decodeFile(s, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MicroMsg.Util", (new StringBuilder("decode bitmap failed: ")).append(s.getMessage()).toString());
            return options;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        s.recycle();
        return options;
    }

    public static Intent getInstallPackIntent(String s, Context context)
    {
        boolean flag;
        if (s != null && !s.equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        context = new Intent("android.intent.action.VIEW");
        context.addFlags(0x10000000);
        context.setDataAndType(Uri.fromFile(new File(s)), "application/vnd.android.package-archive");
        return context;
    }

    public static int getInt(String s, int i)
    {
        if (s == null)
        {
            return i;
        }
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return i;
        }
        return j;
    }

    public static int getIntRandom(int i, int j)
    {
        boolean flag;
        if (i > j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        return (new Random(System.currentTimeMillis())).nextInt((i - j) + 1) + j;
    }

    public static String getLine1Number(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((TelephonyManager)context.getSystemService("phone") != null) goto _L1; else goto _L3
_L3:
        Log.e("MicroMsg.Util", "get line1 number failed, null tm");
        return null;
        context;
        Log.e("MicroMsg.Util", "getLine1Number failed, security exception");
        return null;
        context;
        context.printStackTrace();
        return null;
    }

    public static long getLong(String s, long l)
    {
        if (s == null)
        {
            return l;
        }
        long l1;
        try
        {
            l1 = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return l;
        }
        return l1;
    }

    public static Element getRootElementFromXML(byte abyte0[])
    {
        Object obj = DocumentBuilderFactory.newInstance();
        try
        {
            obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        if (obj == null)
        {
            Log.e("MicroMsg.Util", "new Document Builder failed");
            return null;
        }
        try
        {
            abyte0 = ((DocumentBuilder) (obj)).parse(new ByteArrayInputStream(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        if (abyte0 == null)
        {
            Log.e("MicroMsg.Util", "new Document failed");
            return null;
        } else
        {
            return abyte0.getDocumentElement();
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean flag, float f)
    {
        Assert.assertNotNull(bitmap);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectf = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xffc0c0c0);
        canvas.drawRoundRect(rectf, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (flag)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    public static String getSizeKB(long l)
    {
        if (l >> 20 > 0L)
        {
            return getSizeMB(l);
        }
        if (l >> 9 > 0L)
        {
            float f = (float)Math.round(((float)l * 10F) / 1024F) / 10F;
            return (new StringBuilder()).append(f).append("KB").toString();
        } else
        {
            return (new StringBuilder()).append(l).append("B").toString();
        }
    }

    public static String getSizeMB(long l)
    {
        float f = (float)Math.round(((float)l * 10F) / 1048576F) / 10F;
        return (new StringBuilder()).append(f).append("MB").toString();
    }

    public static String getStack()
    {
        StackTraceElement astacktraceelement[] = (new Throwable()).getStackTrace();
        if (astacktraceelement != null && astacktraceelement.length >= 2) goto _L2; else goto _L1
_L1:
        String s1 = "";
_L4:
        return s1;
_L2:
        String s;
        int i;
        s = "";
        i = 1;
_L6:
        s1 = s;
        if (i >= astacktraceelement.length) goto _L4; else goto _L3
_L3:
        s1 = s;
        if (!astacktraceelement[i].getClassName().contains("com.tencent.mm")) goto _L4; else goto _L5
_L5:
        s = (new StringBuilder()).append(s).append("[").append(astacktraceelement[i].getClassName().substring(15)).append(":").append(astacktraceelement[i].getMethodName()).append("]").toString();
        i++;
          goto _L6
    }

    public static int getSystemVersion(Context context, int i)
    {
        if (context == null)
        {
            return i;
        } else
        {
            return android.provider.Settings.System.getInt(context.getContentResolver(), "sys.settings_system_version", i);
        }
    }

    public static String getTimeZone()
    {
        String s = getTimeZoneDef();
        int j = s.indexOf('+');
        int i = j;
        if (j == -1)
        {
            i = s.indexOf('-');
        }
        if (i == -1)
        {
            s = "";
        } else
        {
            String s1 = s.substring(i, i + 3);
            s = s1;
            if (s1.charAt(1) == '0')
            {
                return (new StringBuilder()).append(s1.substring(0, 1)).append(s1.substring(2, 3)).toString();
            }
        }
        return s;
    }

    public static String getTimeZoneDef()
    {
        int j = (int)((long)TimeZone.getDefault().getRawOffset() / 60000L);
        char c = '+';
        int i = j;
        if (j < 0)
        {
            c = '-';
            i = -j;
        }
        return String.format("GMT%s%02d:%02d", new Object[] {
            Character.valueOf(c), Long.valueOf((long)i / 60L), Long.valueOf((long)i % 60L)
        });
    }

    public static String getTimeZoneOffset()
    {
        TimeZone timezone = TimeZone.getDefault();
        double d = (double)((long)(timezone.getRawOffset() * 100) / 0x36ee80L) / 100D;
        int i;
        if (timezone.useDaylightTime())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return String.format("%.2f", new Object[] {
            Double.valueOf(d + (double)i)
        });
    }

    public static String getTopActivityName(Context context)
    {
        try
        {
            context = ((android.app.ActivityManager.RunningTaskInfo)((ActivityManager)context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "(null)";
        }
        return context;
    }

    public static int guessHttpContinueRecvLength(int i)
    {
        return ((i - 1) / 1462 + 1) * 52 + 52 + i;
    }

    public static int guessHttpRecvLength(int i)
    {
        return ((i - 1) / 1462 + 1) * 52 + 208 + i;
    }

    public static int guessHttpSendLength(int i)
    {
        return ((i - 1) / 1462 + 1) * 52 + 224 + i;
    }

    public static int guessTcpConnectLength()
    {
        return 172;
    }

    public static int guessTcpDisconnectLength()
    {
        return 156;
    }

    public static int guessTcpRecvLength(int i)
    {
        return ((i - 1) / 1462 + 1) * 52 + 40 + i;
    }

    public static int guessTcpSendLength(int i)
    {
        return ((i - 1) / 1462 + 1) * 52 + 40 + i;
    }

    public static void installPack(String s, Context context)
    {
        context.startActivity(getInstallPackIntent(s, context));
    }

    public static boolean isAlpha(char c)
    {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static boolean isChinese(char c)
    {
        Character.UnicodeBlock unicodeblock = Character.UnicodeBlock.of(c);
        return unicodeblock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeblock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeblock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeblock == Character.UnicodeBlock.GENERAL_PUNCTUATION || unicodeblock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || unicodeblock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isDayTimeNow()
    {
        int i = (new GregorianCalendar()).get(11);
        return (long)i >= 6L && (long)i < 18L;
    }

    public static boolean isImgFile(String s)
    {
        if (s == null || s.length() == 0)
        {
            Log.e("MicroMsg.Util", "isImgFile, invalid argument");
        } else
        if (s.length() >= 3 && (new File(s)).exists())
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s, options);
            if (options.outWidth > 0 && options.outHeight > 0)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isIntentAvailable(Context context, Intent intent)
    {
        return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    public static boolean isLockScreen(Context context)
    {
        boolean flag;
        try
        {
            flag = ((KeyguardManager)context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    public static boolean isNightTime(int i, int j, int k)
    {
        boolean flag1 = false;
        if (j <= k) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (i < j)
            {
                flag = flag1;
                if (i > k)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        if (j < k)
        {
            flag = flag1;
            if (i <= k)
            {
                flag = flag1;
                if (i >= j)
                {
                    return true;
                }
            }
        } else
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isNullOrNil(String s)
    {
        return s == null || s.length() <= 0;
    }

    public static boolean isNullOrNil(byte abyte0[])
    {
        return abyte0 == null || abyte0.length <= 0;
    }

    public static boolean isNum(char c)
    {
        return c >= '0' && c <= '9';
    }

    public static boolean isProcessRunning(Context context, String s)
    {
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            if (runningappprocessinfo != null && runningappprocessinfo.processName != null && runningappprocessinfo.processName.equals(s))
            {
                Log.w("MicroMsg.Util", (new StringBuilder("process ")).append(s).append(" is running").toString());
                return true;
            }
        }

        Log.w("MicroMsg.Util", (new StringBuilder("process ")).append(s).append(" is not running").toString());
        return false;
    }

    public static boolean isServiceRunning(Context context, String s)
    {
        for (context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator(); context.hasNext();)
        {
            android.app.ActivityManager.RunningServiceInfo runningserviceinfo = (android.app.ActivityManager.RunningServiceInfo)context.next();
            if (runningserviceinfo != null && runningserviceinfo.service != null && runningserviceinfo.service.getClassName().toString().equals(s))
            {
                Log.w("MicroMsg.Util", (new StringBuilder("service ")).append(s).append(" is running").toString());
                return true;
            }
        }

        Log.w("MicroMsg.Util", (new StringBuilder("service ")).append(s).append(" is not running").toString());
        return false;
    }

    public static boolean isTopActivity(Context context)
    {
        String s = context.getClass().getName();
        context = getTopActivityName(context);
        Log.d("MicroMsg.Util", (new StringBuilder("top activity=")).append(context).append(", context=").append(s).toString());
        return context.equalsIgnoreCase(s);
    }

    public static boolean isTopApplication(Context context)
    {
        boolean flag;
        try
        {
            String s = ((android.app.ActivityManager.RunningTaskInfo)((ActivityManager)context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            context = context.getPackageName();
            Log.d("MicroMsg.Util", (new StringBuilder("top activity=")).append(s).append(", context=").append(context).toString());
            flag = s.contains(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        return flag;
    }

    public static boolean isValidAccount(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((s = s.trim()).length() >= 6 && s.length() <= 20 && isAlpha(s.charAt(0)))
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= s.length())
                    {
                        break label1;
                    }
                    char c = s.charAt(i);
                    if (!isAlpha(c) && !isNum(c) && c != '-' && c != '_')
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isValidEmail(String s)
    {
        if (s == null || s.length() <= 0)
        {
            return false;
        } else
        {
            return s.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        }
    }

    public static boolean isValidPassword(String s)
    {
        while (s == null || s.length() < 4) 
        {
            return false;
        }
        if (s.length() >= 9)
        {
            return true;
        }
        try
        {
            Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return true;
        }
        return false;
    }

    public static boolean isValidQQNum(String s)
    {
        if (s != null && s.length() > 0)
        {
            s = s.trim();
            long l;
            try
            {
                l = Long.valueOf(s).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return false;
            }
            if (l > 0L && l <= 0xffffffffL)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean jump(Context context, String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (!isIntentAvailable(context, intent))
        {
            Log.e("MicroMsg.Util", (new StringBuilder("jump to url failed, ")).append(s).toString());
            return false;
        } else
        {
            context.startActivity(intent);
            return true;
        }
    }

    public static String listToString(List list, String s)
    {
        if (list == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder("");
        int i = 0;
        while (i < list.size()) 
        {
            if (i == list.size() - 1)
            {
                stringbuilder.append(((String)list.get(i)).trim());
            } else
            {
                stringbuilder.append((new StringBuilder()).append(((String)list.get(i)).trim()).append(s).toString());
            }
            i++;
        }
        return stringbuilder.toString();
    }

    public static String mapToXml(String s, LinkedHashMap linkedhashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<key>");
        for (Iterator iterator = linkedhashmap.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder("</")).append(s).append(">").toString()))
        {
            s = (java.util.Map.Entry)iterator.next();
            linkedhashmap = ((LinkedHashMap) (s.getKey()));
            Object obj = s.getValue();
            s = linkedhashmap;
            if (linkedhashmap == null)
            {
                s = "unknow";
            }
            linkedhashmap = ((LinkedHashMap) (obj));
            if (obj == null)
            {
                linkedhashmap = "unknow";
            }
            stringbuilder.append((new StringBuilder("<")).append(s).append(">").toString());
            stringbuilder.append(linkedhashmap);
        }

        stringbuilder.append("</key>");
        return stringbuilder.toString();
    }

    public static long milliSecondsToNow(long l)
    {
        return System.currentTimeMillis() - l;
    }

    public static long nowMilliSecond()
    {
        return System.currentTimeMillis();
    }

    public static long nowSecond()
    {
        return System.currentTimeMillis() / 1000L;
    }

    public static int nullAs(Integer integer, int i)
    {
        if (integer == null)
        {
            return i;
        } else
        {
            return integer.intValue();
        }
    }

    public static long nullAs(Long long1, long l)
    {
        if (long1 == null)
        {
            return l;
        } else
        {
            return long1.longValue();
        }
    }

    public static String nullAs(String s, String s1)
    {
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public static boolean nullAs(Boolean boolean1, boolean flag)
    {
        if (boolean1 == null)
        {
            return flag;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public static boolean nullAsFalse(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return false;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public static int nullAsInt(Object obj, int i)
    {
        if (obj != null)
        {
            if (obj instanceof Integer)
            {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof Long)
            {
                return ((Long)obj).intValue();
            }
        }
        return i;
    }

    public static int nullAsNil(Integer integer)
    {
        if (integer == null)
        {
            return 0;
        } else
        {
            return integer.intValue();
        }
    }

    public static long nullAsNil(Long long1)
    {
        if (long1 == null)
        {
            return 0L;
        } else
        {
            return long1.longValue();
        }
    }

    public static String nullAsNil(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return s1;
    }

    public static boolean nullAsTrue(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return true;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    public static Map parseIni(String s)
    {
        if (s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        HashMap hashmap = new HashMap();
        String as[] = s.split("\n");
        int j = as.length;
        int i = 0;
        do
        {
            s = hashmap;
            if (i >= j)
            {
                continue;
            }
            s = as[i];
            if (s != null && s.length() > 0)
            {
                String as1[] = s.trim().split("=", 2);
                if (as1 != null && as1.length >= 2)
                {
                    s = as1[0];
                    String s1 = as1[1];
                    if (s != null && s.length() > 0 && s.matches("^[a-zA-Z0-9_]*"))
                    {
                        hashmap.put(s, s1);
                    }
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Map parseXml(String s, String s1, String s2)
    {
        HashMap hashmap;
        Object obj;
        if (s == null || s.length() <= 0)
        {
            return null;
        }
        hashmap = new HashMap();
        obj = DocumentBuilderFactory.newInstance();
        try
        {
            obj = ((DocumentBuilderFactory) (obj)).newDocumentBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        if (obj == null)
        {
            Log.e("MicroMsg.Util", "new Document Builder failed");
            return null;
        }
        s = new InputSource(new ByteArrayInputStream(s.getBytes()));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        s.setEncoding(s2);
        s = ((DocumentBuilder) (obj)).parse(s);
        s.normalize();
_L2:
        if (s == null)
        {
            Log.e("MicroMsg.Util", "new Document failed");
            return null;
        }
        break; /* Loop/switch isn't completed */
        s2;
        s = null;
_L3:
        s2.printStackTrace();
        if (true) goto _L2; else goto _L1
        s;
        s.printStackTrace();
        return null;
        s;
        s.printStackTrace();
        return null;
        s;
        s.printStackTrace();
        return null;
_L1:
        s = s.getDocumentElement();
        if (s == null)
        {
            Log.e("MicroMsg.Util", "getDocumentElement failed");
            return null;
        }
        if (s1 != null && s1.equals(s.getNodeName()))
        {
            a(hashmap, "", s, 0);
        } else
        {
            s = s.getElementsByTagName(s1);
            if (s.getLength() <= 0)
            {
                Log.e("MicroMsg.Util", "parse item null");
                return null;
            }
            if (s.getLength() > 1)
            {
                Log.w("MicroMsg.Util", "parse items more than one");
            }
            a(hashmap, "", s.item(0), 0);
        }
        for (s = hashmap.entrySet().iterator(); s.hasNext(); Log.v("MicroMsg.Util", (new StringBuilder("key=")).append((String)s1.getKey()).append(" value=").append((String)s1.getValue()).toString()))
        {
            s1 = (java.util.Map.Entry)s.next();
        }

        return hashmap;
        s2;
          goto _L3
    }

    public static MediaPlayer playSound(Context context, int i, android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        Object obj;
        try
        {
            obj = context.getString(i);
            context = context.getAssets().openFd(((String) (obj)));
            obj = new MediaPlayer();
            ((MediaPlayer) (obj)).setDataSource(context.getFileDescriptor(), context.getStartOffset(), context.getLength());
            context.close();
            ((MediaPlayer) (obj)).prepare();
            ((MediaPlayer) (obj)).setLooping(false);
            ((MediaPlayer) (obj)).start();
            ((MediaPlayer) (obj)).setOnCompletionListener(oncompletionlistener);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return null;
        }
        return ((MediaPlayer) (obj));
    }

    public static void playSound(Context context, int i)
    {
        playSound(context, i, ((android.media.MediaPlayer.OnCompletionListener) (new _cls1())));
    }

    public static String processXml(String s)
    {
        while (s == null || s.length() == 0 || android.os.Build.VERSION.SDK_INT >= 8) 
        {
            return s;
        }
        return expandEntities(s);
    }

    public static void saveBitmapToImage(Bitmap bitmap, int i, android.graphics.Bitmap.CompressFormat compressformat, String s, String s1, boolean flag)
    {
        if (s != null && s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        Log.d("MicroMsg.Util", (new StringBuilder("saving to ")).append(s).append(s1).toString());
        s = new File((new StringBuilder()).append(s).append(s1).toString());
        s.createNewFile();
        try
        {
            s = new FileOutputStream(s);
            bitmap.compress(compressformat, i, s);
            s.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
    }

    public static void saveBitmapToImage(Bitmap bitmap, int i, android.graphics.Bitmap.CompressFormat compressformat, String s, boolean flag)
    {
        FileOutputStream fileoutputstream;
        if (!isNullOrNil(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        Log.d("MicroMsg.Util", (new StringBuilder("saving to ")).append(s).toString());
        s = new File(s);
        s.createNewFile();
        fileoutputstream = new FileOutputStream(s);
        s = fileoutputstream;
        bitmap.compress(compressformat, i, fileoutputstream);
        s = fileoutputstream;
        fileoutputstream.flush();
        fileoutputstream.close();
        return;
        compressformat;
        bitmap = null;
_L4:
        s = bitmap;
        compressformat.printStackTrace();
        bitmap.close();
        return;
        bitmap;
        s = null;
_L2:
        s.close();
        throw bitmap;
        bitmap;
        if (true) goto _L2; else goto _L1
_L1:
        compressformat;
        bitmap = fileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static long secondsToNow(long l)
    {
        return System.currentTimeMillis() / 1000L - l;
    }

    public static void selectPicture(Context context, int i)
    {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent = Intent.createChooser(intent, null);
        ((Activity)context).startActivityForResult(intent, i);
    }

    public static void shake(Context context, boolean flag)
    {
        context = (Vibrator)context.getSystemService("vibrator");
        if (context == null)
        {
            return;
        }
        if (flag)
        {
            context.vibrate(bt, -1);
            return;
        } else
        {
            context.cancel();
            return;
        }
    }

    public static int[] splitToIntArray(String s)
    {
        if (s == null)
        {
            return null;
        }
        Object aobj[] = s.split(":");
        s = new ArrayList();
        int k = aobj.length;
        int i = 0;
        do
        {
            if (i >= k)
            {
                break;
            }
            String s1 = aobj[i];
            if (s1 != null && s1.length() > 0)
            {
                try
                {
                    s.add(Integer.valueOf(Integer.valueOf(s1).intValue()));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    Log.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
            i++;
        } while (true);
        aobj = new int[s.size()];
        for (int j = 0; j < aobj.length; j++)
        {
            aobj[j] = ((Integer)s.get(j)).intValue();
        }

        return ((int []) (aobj));
    }

    public static List stringsToList(String as[])
    {
        if (as == null || as.length == 0)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < as.length; i++)
        {
            arraylist.add(as[i]);
        }

        return arraylist;
    }

    public static long ticksToNow(long l)
    {
        return SystemClock.elapsedRealtime() - l;
    }

    public static void transClickToSelect(View view, View view1)
    {
        view.setOnTouchListener(new _cls2(view1, view));
    }


    private class _cls1
        implements android.media.MediaPlayer.OnCompletionListener
    {

        public final void onCompletion(MediaPlayer mediaplayer)
        {
            mediaplayer.release();
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements android.view.View.OnTouchListener
    {

        final View bx;
        final View by;

        public final boolean onTouch(View view, MotionEvent motionevent)
        {
            switch (motionevent.getAction())
            {
            default:
                return false;

            case 0: // '\0'
                bx.setSelected(true);
                return false;

            case 1: // '\001'
            case 3: // '\003'
            case 4: // '\004'
                bx.setSelected(false);
                return false;

            case 2: // '\002'
                bx.setSelected(by.isPressed());
                break;
            }
            return false;
        }

        _cls2(View view, View view1)
        {
            bx = view;
            by = view1;
            super();
        }
    }

}
