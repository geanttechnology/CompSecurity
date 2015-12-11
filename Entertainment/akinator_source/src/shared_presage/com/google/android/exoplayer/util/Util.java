// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import shared_presage.com.google.android.exoplayer.upstream.DataSource;
import shared_presage.com.google.android.exoplayer.upstream.DataSpec;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            Assertions, f, g

public final class Util
{

    public static final String DEVICE;
    public static final String MANUFACTURER;
    private static final long MAX_BYTES_TO_DRAIN = 2048L;
    public static final int SDK_INT;
    private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    private Util()
    {
    }

    public static boolean areEqual(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static int binarySearchCeil(List list, Object obj, boolean flag, boolean flag1)
    {
        int j = Collections.binarySearch(list, obj);
        if (j >= 0) goto _L2; else goto _L1
_L1:
        int i = ~j;
_L4:
        j = i;
        if (flag1)
        {
            j = Math.min(list.size() - 1, i);
        }
        return j;
_L2:
        i = j;
        if (!flag)
        {
            i = j + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int binarySearchCeil(long al[], long l, boolean flag, boolean flag1)
    {
        int j = Arrays.binarySearch(al, l);
        if (j >= 0) goto _L2; else goto _L1
_L1:
        int i = ~j;
_L4:
        j = i;
        if (flag1)
        {
            j = Math.min(al.length - 1, i);
        }
        return j;
_L2:
        i = j;
        if (!flag)
        {
            i = j + 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int binarySearchFloor(List list, Object obj, boolean flag, boolean flag1)
    {
        int j = Collections.binarySearch(list, obj);
        if (j >= 0) goto _L2; else goto _L1
_L1:
        int i = -(j + 2);
_L4:
        j = i;
        if (flag1)
        {
            j = Math.max(0, i);
        }
        return j;
_L2:
        i = j;
        if (!flag)
        {
            i = j - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int binarySearchFloor(long al[], long l, boolean flag, boolean flag1)
    {
        int j = Arrays.binarySearch(al, l);
        if (j >= 0) goto _L2; else goto _L1
_L1:
        int i = -(j + 2);
_L4:
        j = i;
        if (flag1)
        {
            j = Math.max(0, i);
        }
        return j;
_L2:
        i = j;
        if (!flag)
        {
            i = j - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int ceilDivide(int i, int j)
    {
        return ((i + j) - 1) / j;
    }

    public static long ceilDivide(long l, long l1)
    {
        return ((l + l1) - 1L) / l1;
    }

    public static void closeQuietly(OutputStream outputstream)
    {
        try
        {
            outputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            return;
        }
    }

    public static void closeQuietly(DataSource datasource)
    {
        try
        {
            datasource.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DataSource datasource)
        {
            return;
        }
    }

    public static boolean contains(Object aobj[], Object obj)
    {
        boolean flag1 = false;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < aobj.length)
                {
                    if (!areEqual(aobj[i], obj))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public static byte[] executePost(String s, byte abyte0[], Map map)
    {
        byte abyte1[] = null;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestMethod("POST");
        boolean flag;
        if (abyte0 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.setDoOutput(flag);
        s.setDoInput(true);
        if (map == null) goto _L2; else goto _L1
_L1:
        for (map = map.entrySet().iterator(); map.hasNext(); s.setRequestProperty((String)abyte1.getKey(), (String)abyte1.getValue()))
        {
            abyte1 = (java.util.Map.Entry)map.next();
        }

          goto _L2
        abyte0;
_L5:
        if (s != null)
        {
            s.disconnect();
        }
        throw abyte0;
_L2:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        map = s.getOutputStream();
        map.write(abyte0);
        map.close();
        abyte0 = s.getInputStream();
        map = new ByteArrayOutputStream();
        abyte1 = new byte[1024];
_L3:
        int i = abyte0.read(abyte1);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        map.write(abyte1, 0, i);
          goto _L3
        map;
        abyte0.close();
        throw map;
        abyte0;
        map.close();
        throw abyte0;
        map = map.toByteArray();
        abyte0.close();
        if (s != null)
        {
            s.disconnect();
        }
        return map;
        abyte0;
        s = abyte1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String getCommaDelimitedSimpleClassNames(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < aobj.length; i++)
        {
            stringbuilder.append(aobj[i].getClass().getSimpleName());
            if (i < aobj.length - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.toString();
    }

    public static String getHexStringFromBytes(byte abyte0[], int i, int j)
    {
        StringBuilder stringbuilder = new StringBuilder(j - i);
        for (; i < j; i++)
        {
            stringbuilder.append(String.format(Locale.US, "%02X", new Object[] {
                Byte.valueOf(abyte0[i])
            }));
        }

        return stringbuilder.toString();
    }

    public static int getIntegerCodeForString(String s)
    {
        int i = 0;
        int k = s.length();
        int j;
        boolean flag;
        if (k <= 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        j = 0;
        for (; i < k; i++)
        {
            j = j << 8 | s.charAt(i);
        }

        return j;
    }

    public static DataSpec getRemainderDataSpec(DataSpec dataspec, int i)
    {
        long l = -1L;
        if (i == 0)
        {
            return dataspec;
        }
        if (dataspec.length != -1L)
        {
            l = dataspec.length - (long)i;
        }
        return new DataSpec(dataspec.uri, dataspec.position + (long)i, l, dataspec.key, dataspec.flags);
    }

    public static String getUserAgent(Context context, String s)
    {
        try
        {
            String s1 = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = "?";
        }
        return (new StringBuilder()).append(s).append("/").append(context).append(" (Linux;Android ").append(android.os.Build.VERSION.RELEASE).append(") ExoPlayerLib/1.4.2").toString();
    }

    public static boolean isAndroidTv(Context context)
    {
        return context.getPackageManager().hasSystemFeature("android.software.leanback");
    }

    public static boolean isUrlLocalFile(URL url)
    {
        return url.getProtocol().equals("file");
    }

    public static void maybeTerminateInputStream(HttpURLConnection httpurlconnection, long l)
    {
        if (SDK_INT == 19 || SDK_INT == 20) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        try
        {
            httpurlconnection = httpurlconnection.getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            return;
        }
        if (l != -1L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (httpurlconnection.read() == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        obj = httpurlconnection.getClass().getName();
        if (((String) (obj)).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || ((String) (obj)).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"))
        {
            obj = httpurlconnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
            ((Method) (obj)).setAccessible(true);
            ((Method) (obj)).invoke(httpurlconnection, new Object[0]);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (l <= 2048L)
        {
            return;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static ExecutorService newSingleThreadExecutor(String s)
    {
        return Executors.newSingleThreadExecutor(new f(s));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(String s)
    {
        return Executors.newSingleThreadScheduledExecutor(new g(s));
    }

    public static long parseXsDateTime(String s)
    {
        Matcher matcher;
        matcher = XS_DATE_TIME_PATTERN.matcher(s);
        if (!matcher.matches())
        {
            throw new ParseException((new StringBuilder("Invalid date/time format: ")).append(s).toString(), 0);
        }
        if (matcher.group(9) != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        s = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        s.clear();
        s.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8)))
        {
            s.set(14, (new BigDecimal((new StringBuilder("0.")).append(matcher.group(8)).toString())).movePointRight(3).intValue());
        }
        long l1 = s.getTimeInMillis();
        long l = l1;
        if (i != 0)
        {
            l = l1 - (long)(60000 * i);
        }
        return l;
_L2:
        if (matcher.group(9).equalsIgnoreCase("Z"))
        {
            i = 0;
        } else
        {
            i = Integer.parseInt(matcher.group(12)) * 60 + Integer.parseInt(matcher.group(13));
            if (matcher.group(11).equals("-"))
            {
                i *= -1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static long parseXsDuration(String s)
    {
        boolean flag = true;
        double d5 = 0.0D;
        Matcher matcher = XS_DURATION_PATTERN.matcher(s);
        if (matcher.matches())
        {
            double d;
            double d1;
            double d2;
            double d3;
            double d4;
            long l;
            if (TextUtils.isEmpty(matcher.group(1)))
            {
                flag = false;
            }
            s = matcher.group(3);
            if (s != null)
            {
                d = Double.parseDouble(s) * 31556908D;
            } else
            {
                d = 0.0D;
            }
            s = matcher.group(5);
            if (s != null)
            {
                d1 = Double.parseDouble(s) * 2629739D;
            } else
            {
                d1 = 0.0D;
            }
            s = matcher.group(7);
            if (s != null)
            {
                d2 = Double.parseDouble(s) * 86400D;
            } else
            {
                d2 = 0.0D;
            }
            s = matcher.group(10);
            if (s != null)
            {
                d3 = Double.parseDouble(s) * 3600D;
            } else
            {
                d3 = 0.0D;
            }
            s = matcher.group(12);
            if (s != null)
            {
                d4 = Double.parseDouble(s) * 60D;
            } else
            {
                d4 = 0.0D;
            }
            s = matcher.group(14);
            if (s != null)
            {
                d5 = Double.parseDouble(s);
            }
            l = (long)((d4 + (d1 + d + d2 + d3) + d5) * 1000D);
            if (flag)
            {
                return -l;
            } else
            {
                return l;
            }
        } else
        {
            return (long)(Double.parseDouble(s) * 3600D * 1000D);
        }
    }

    public static long scaleLargeTimestamp(long l, long l1, long l2)
    {
        if (l2 >= l1 && l2 % l1 == 0L)
        {
            return l / (l2 / l1);
        }
        if (l2 < l1 && l1 % l2 == 0L)
        {
            return (l1 / l2) * l;
        } else
        {
            return (long)(((double)l1 / (double)l2) * (double)l);
        }
    }

    public static long[] scaleLargeTimestamps(List list, long l, long l1)
    {
        long al[] = new long[list.size()];
        if (l1 >= l && l1 % l == 0L)
        {
            l = l1 / l;
            for (int i = 0; i < al.length; i++)
            {
                al[i] = ((Long)list.get(i)).longValue() / l;
            }

        } else
        if (l1 < l && l % l1 == 0L)
        {
            l /= l1;
            for (int j = 0; j < al.length; j++)
            {
                al[j] = ((Long)list.get(j)).longValue() * l;
            }

        } else
        {
            double d = (double)l / (double)l1;
            for (int k = 0; k < al.length; k++)
            {
                al[k] = (long)((double)((Long)list.get(k)).longValue() * d);
            }

        }
        return al;
    }

    public static void scaleLargeTimestampsInPlace(long al[], long l, long l1)
    {
        boolean flag = false;
        boolean flag1 = false;
        int i = 0;
        if (l1 >= l && l1 % l == 0L)
        {
            l = l1 / l;
            for (; i < al.length; i++)
            {
                al[i] = al[i] / l;
            }

        } else
        if (l1 < l && l % l1 == 0L)
        {
            l /= l1;
            for (int j = ((flag) ? 1 : 0); j < al.length; j++)
            {
                al[j] = al[j] * l;
            }

        } else
        {
            double d = (double)l / (double)l1;
            for (int k = ((flag1) ? 1 : 0); k < al.length; k++)
            {
                al[k] = (long)((double)al[k] * d);
            }

        }
    }

    public static int[] toArray(List list)
    {
        if (list == null)
        {
            return null;
        }
        int j = list.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = ((Integer)list.get(i)).intValue();
        }

        return ai;
    }

    public static String toLowerInvariant(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.toLowerCase(Locale.US);
        }
    }

    static 
    {
        SDK_INT = android.os.Build.VERSION.SDK_INT;
        DEVICE = Build.DEVICE;
        MANUFACTURER = Build.MANUFACTURER;
    }
}
