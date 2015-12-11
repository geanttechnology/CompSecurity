// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.amazon.mShop.net:
//            MShopDiskCache

public class MShopHttpHeaderHelper
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final char HEX_DIGITS[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    static final ThreadLocal STANDARD_DATE_FORMAT = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpledateformat;
        }

    };

    public MShopHttpHeaderHelper()
    {
    }

    private static void appendSavedHeader(Map map, Writer writer, Map map1, StringBuilder stringbuilder)
        throws IOException
    {
        map1 = map1.entrySet().iterator();
        do
        {
            if (!map1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map1.next();
            String s = (String)entry.getKey();
            if (!"mshop-cache-sent-time".equals(s) && !"mshop-cache-received-time".equals(s) && !map.containsKey(s))
            {
                stringbuilder.setLength(0);
                stringbuilder.append(s);
                stringbuilder.append(": ");
                stringbuilder.append((String)entry.getValue());
                stringbuilder.setCharAt(stringbuilder.length() - 1, '\n');
                writer.write(stringbuilder.toString().toLowerCase());
            }
        } while (true);
    }

    public static String convertBytesToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            char c = HEX_DIGITS[byte0 >> 4 & 0xf];
            char c1 = HEX_DIGITS[byte0 & 0xf];
            stringbuilder.append(c);
            stringbuilder.append(c1);
        }

        return stringbuilder.toString();
    }

    public static long getLastModifiedDate(Map map)
    {
        long l1 = parseHeaderDate(map, "last-modified");
        long l = l1;
        if (l1 == -1L)
        {
            long l2 = parseHeaderDate(map, "date");
            l = l2;
            if (l2 == -1L)
            {
                l = parseHeaderDate(map, "mshop-cache-sent-time");
            }
        }
        return l;
    }

    public static long parseHeaderDate(Map map, String s)
    {
        map = (String)map.get(s);
        if (!Util.isEmpty(map)) goto _L2; else goto _L1
_L1:
        return -1L;
_L2:
        if ((map = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(map.toUpperCase())) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = map.getTime();
        return l;
        map;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", map.toString());
            return -1L;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String parseHeaderDirectiveValue(Map map, String s, String s1)
    {
        map = (String)map.get(s);
        if (!Util.isEmpty(map))
        {
            map = map.split(",");
            int i = 0;
            while (i < map.length) 
            {
                s = map[i].split("=");
                if (s.length == 2 && s[0].trim().equals(s1))
                {
                    return s[1];
                }
                i++;
            }
        }
        return null;
    }

    public static long parseLong(Map map, String s)
    {
        map = (String)map.get(s);
        if (Util.isEmpty(map))
        {
            return -1L;
        }
        long l;
        try
        {
            l = Long.parseLong(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return -1L;
        }
        return l;
    }

    static Map readHeaderInf(String s, MShopDiskCachePolicy.ResidencePriority residencepriority)
    {
        residencepriority = MShopDiskCache.newInfFile(s, residencepriority);
        if (residencepriority != null) goto _L2; else goto _L1
_L1:
        s = null;
_L6:
        return s;
_L2:
        HashMap hashmap;
        Object obj1;
        Object obj2;
        hashmap = new HashMap();
        obj2 = null;
        s = null;
        obj1 = null;
        residencepriority = new BufferedReader(new InputStreamReader(new FileInputStream(residencepriority)));
        s = residencepriority.readLine();
_L4:
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = s.indexOf(":");
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        hashmap.put(s.substring(0, i).trim(), s.substring(i + 1, s.length()).trim());
        s = residencepriority.readLine();
        if (true) goto _L4; else goto _L3
_L3:
        s = hashmap;
        if (residencepriority == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        residencepriority.close();
        return hashmap;
        residencepriority;
        s = hashmap;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", residencepriority.toString());
            return hashmap;
        }
        if (true) goto _L6; else goto _L5
_L5:
        Object obj;
        obj;
        residencepriority = obj1;
_L18:
        s = residencepriority;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        s = residencepriority;
        Log.d("MShopHttpHeaderHelper", ((FileNotFoundException) (obj)).toString());
        if (residencepriority == null)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        residencepriority.close();
_L8:
        return null;
        s;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", s.toString());
        }
        if (true) goto _L8; else goto _L7
_L7:
        obj;
        residencepriority = obj2;
_L16:
        s = residencepriority;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        s = residencepriority;
        Log.d("MShopHttpHeaderHelper", ((IOException) (obj)).toString());
        if (residencepriority == null)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        residencepriority.close();
_L10:
        return null;
        s;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", s.toString());
        }
        if (true) goto _L10; else goto _L9
_L9:
        residencepriority;
_L14:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        s.close();
_L12:
        throw residencepriority;
        s;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", s.toString());
        }
        if (true) goto _L12; else goto _L11
_L11:
        obj;
        s = residencepriority;
        residencepriority = ((MShopDiskCachePolicy.ResidencePriority) (obj));
        if (true) goto _L14; else goto _L13
_L13:
        obj;
        if (true) goto _L16; else goto _L15
_L15:
        obj;
        if (true) goto _L18; else goto _L17
_L17:
    }

    private static void writeHeader(Map map, Writer writer, StringBuilder stringbuilder)
        throws IOException
    {
        for (map = map.entrySet().iterator(); map.hasNext(); writer.write(stringbuilder.toString().toLowerCase()))
        {
            Object obj = (java.util.Map.Entry)map.next();
            stringbuilder.setLength(0);
            stringbuilder.append((String)((java.util.Map.Entry) (obj)).getKey());
            stringbuilder.append(": ");
            for (obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append(","))
            {
                stringbuilder.append((String)((Iterator) (obj)).next());
            }

            stringbuilder.setCharAt(stringbuilder.length() - 1, '\n');
        }

    }

    private static void writeHeaderField(StringBuilder stringbuilder, Writer writer, String s, String s1)
        throws IOException
    {
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append(": ");
        stringbuilder.append(s1);
        stringbuilder.append('\n');
        writer.write(stringbuilder.toString());
    }

    public static boolean writeHeaderInf(String s, Map map, MShopDiskCachePolicy.ResidencePriority residencepriority, long l, long l1)
    {
        return writeHeaderInf(s, map, residencepriority, l, l1, true);
    }

    public static boolean writeHeaderInf(String s, Map map, MShopDiskCachePolicy.ResidencePriority residencepriority, long l, long l1, boolean flag)
    {
        if (map != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        Map map1;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        File file;
        obj2 = null;
        obj3 = null;
        obj5 = null;
        obj4 = null;
        obj1 = null;
        map1 = null;
        if (!flag)
        {
            map1 = readHeaderInf(s, residencepriority);
        }
        file = MShopDiskCache.newInfFile(s, residencepriority);
        obj7 = null;
        obj8 = null;
        s = null;
        obj6 = null;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        residencepriority = s;
        obj = obj5;
        file.createNewFile();
        residencepriority = s;
        obj = obj5;
        s = new FileOutputStream(file);
        residencepriority = new BufferedWriter(new OutputStreamWriter(s, "UTF-8"));
        obj = new StringBuilder(128);
        writeHeader(map, residencepriority, ((StringBuilder) (obj)));
        if (flag)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        appendSavedHeader(map, residencepriority, map1, ((StringBuilder) (obj)));
        writeHeaderField(((StringBuilder) (obj)), residencepriority, "mshop-cache-sent-time", String.valueOf(l));
        writeHeaderField(((StringBuilder) (obj)), residencepriority, "mshop-cache-received-time", String.valueOf(l1));
        residencepriority.flush();
        if (residencepriority == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        residencepriority.close();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (DEBUG)
                {
                    Log.d("MShopHttpHeaderHelper", s.toString());
                }
            }
        }
        MShopDiskCachePolicy.ResidencePriority residencepriority1;
        if (false && file.exists())
        {
            file.delete();
            return true;
        } else
        {
            return true;
        }
        map;
        residencepriority1 = obj1;
        s = obj6;
_L9:
        residencepriority = s;
        obj = residencepriority1;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        residencepriority = s;
        obj = residencepriority1;
        Log.d("MShopHttpHeaderHelper", map.toString());
        if (residencepriority1 == null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        residencepriority1.close();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (DEBUG)
                {
                    Log.d("MShopHttpHeaderHelper", s.toString());
                }
            }
        }
        if (true && file.exists())
        {
            file.delete();
            return false;
        }
          goto _L1
        map;
        residencepriority1 = obj2;
        s = obj7;
_L8:
        residencepriority = s;
        obj = residencepriority1;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        residencepriority = s;
        obj = residencepriority1;
        Log.d("MShopHttpHeaderHelper", map.toString());
        if (residencepriority1 == null)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        residencepriority1.close();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (DEBUG)
                {
                    Log.d("MShopHttpHeaderHelper", s.toString());
                }
            }
        }
        if (true && file.exists())
        {
            file.delete();
            return false;
        }
          goto _L1
        map;
        residencepriority1 = obj3;
        s = obj8;
_L7:
        residencepriority = s;
        obj = residencepriority1;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        residencepriority = s;
        obj = residencepriority1;
        Log.d("MShopHttpHeaderHelper", map.toString());
        if (residencepriority1 == null)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        residencepriority1.close();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (DEBUG)
                {
                    Log.d("MShopHttpHeaderHelper", s.toString());
                }
            }
        }
        if (true && file.exists())
        {
            file.delete();
            return false;
        }
          goto _L1
        s;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        ((Writer) (obj)).close();
        if (residencepriority == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        residencepriority.close();
_L4:
        if (false && file.exists())
        {
            file.delete();
        }
        throw s;
        map;
        if (DEBUG)
        {
            Log.d("MShopHttpHeaderHelper", map.toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
        map;
        residencepriority = s;
        obj = obj4;
        s = map;
        continue; /* Loop/switch isn't completed */
        map;
        obj = residencepriority;
        residencepriority = s;
        s = map;
        if (true) goto _L6; else goto _L5
_L5:
        map;
        residencepriority1 = obj3;
          goto _L7
        map;
        residencepriority1 = residencepriority;
          goto _L7
        map;
        residencepriority1 = obj2;
          goto _L8
        map;
        residencepriority1 = residencepriority;
          goto _L8
        map;
        residencepriority1 = obj1;
          goto _L9
        map;
        residencepriority1 = residencepriority;
          goto _L9
    }

}
