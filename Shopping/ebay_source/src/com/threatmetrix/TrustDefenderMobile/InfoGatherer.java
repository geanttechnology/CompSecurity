// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            NativeGatherer, StringUtils, StatWrapper, DisplayWrapper, 
//            WrapperHelper

class InfoGatherer
{
    static class TZInfo
    {

        int dstDiff;
        int gmtOffset;

        TZInfo()
        {
            gmtOffset = 0;
            dstDiff = 0;
        }
    }


    private static final String TAG = com/threatmetrix/TrustDefenderMobile/InfoGatherer.getSimpleName();

    InfoGatherer()
    {
    }

    static List checkURLs(Context context, List list)
        throws InterruptedException
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        String as[];
        String s;
        PackageManager packagemanager;
        Iterator iterator;
        as = NativeGatherer.INSTANCE.checkURLs((String[])list.toArray(new String[list.size()]));
        s = Build.TAGS;
        packagemanager = context.getPackageManager();
        iterator = list.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        String s1;
        boolean flag1;
        s1 = (String)iterator.next();
        if (Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        flag1 = false;
        context = null;
        URI uri = new URI(s1);
        context = uri;
_L7:
        if (context == null) goto _L6; else goto _L5
_L5:
        URISyntaxException urisyntaxexception;
        boolean flag;
        if (context.getScheme().equals("file"))
        {
            flag = (new File(context)).exists();
        } else
        {
label0:
            {
                if (!context.getScheme().equals("tags"))
                {
                    break label0;
                }
                flag = flag1;
                if (s != null)
                {
                    context = context.getHost();
                    flag = flag1;
                    if (context != null)
                    {
                        flag = flag1;
                        if (!context.isEmpty())
                        {
                            flag = s.contains(context);
                        }
                    }
                }
            }
        }
_L9:
        if (flag)
        {
            arraylist.add(s1);
        } else
        {
            i++;
        }
          goto _L6
        urisyntaxexception;
        Log.d(TAG, "malformed check url", urisyntaxexception);
          goto _L7
        flag = flag1;
        if (!context.getScheme().equals("pkg")) goto _L9; else goto _L8
_L8:
        flag = flag1;
        if (packagemanager == null) goto _L9; else goto _L10
_L10:
        context = context.getHost();
        packagemanager.getPackageInfo(context, 1);
        flag = true;
          goto _L9
_L4:
        Log.d(TAG, (new StringBuilder()).append("matched ").append(i).append("/").append(list.size()).toString());
        if (as != null && as.length > 0)
        {
            int k = as.length;
            for (int j = 0; j < k; j++)
            {
                context = as[j];
                arraylist.add((new StringBuilder()).append("z").append(context).toString());
            }

        }
        Collections.sort(arraylist);
        if (!arraylist.isEmpty() && Log.isLoggable(TAG, 3))
        {
            Log.d(TAG, (new StringBuilder()).append("found ").append(StringUtils.ListToSeperatedString(arraylist, ";")).toString());
            return arraylist;
        }
          goto _L1
        context;
        flag = flag1;
          goto _L9
    }

    static String getCPUInfo()
    {
        Object obj = new ArrayList();
        Collections.addAll(((java.util.Collection) (obj)), new String[] {
            "Processor", "BogoMips", "Hardware", "Serial"
        });
        obj = getInfoFromFile("/proc/cpuinfo", ((List) (obj)), ":");
        Log.d(TAG, (new StringBuilder()).append("getCPUInfo returned: ").append(((String) (obj))).toString());
        return ((String) (obj));
    }

    static String getDeviceFingerprint(Context context, Context context1)
    {
        Log.d(TAG, "getDeviceFingerprint()");
        StringBuilder stringbuilder = new StringBuilder();
        if (Thread.currentThread().isInterrupted())
        {
            return "";
        }
        TelephonyManager telephonymanager = (TelephonyManager)context1.getSystemService("phone");
        context1 = "Unknown";
        if (telephonymanager.getPhoneType() == 1)
        {
            context1 = telephonymanager.getNetworkOperatorName();
        }
        stringbuilder.append(context1);
        stringbuilder.append(telephonymanager.getSimCountryIso());
        context1 = new StatWrapper(Environment.getDataDirectory().getPath());
        long l = context1.getBlockSize();
        stringbuilder.append(((float)context1.getBlockCount() * (float)l) / 1024F / 1024F / 1024F);
        context = new DisplayWrapper(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
        stringbuilder.append(context.getWidth()).append("x").append(context.getHeight());
        Log.d(TAG, "Calling getCPUInfo");
        stringbuilder.append(getCPUInfo());
        Log.d(TAG, "Calling getMemInfo");
        stringbuilder.append(getMemInfo());
        stringbuilder.append(Build.DEVICE).append(" ").append(Build.MODEL).append(" ").append(Build.PRODUCT).append(" ").append(Build.MANUFACTURER).append(" ").append(android.os.Build.VERSION.RELEASE);
        Log.d(TAG, (new StringBuilder()).append("getDeviceFingerprint returned: hash(").append(stringbuilder.toString()).append(")").toString());
        return StringUtils.MD5(stringbuilder.toString());
    }

    static String getDeviceState()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StatWrapper statwrapper = new StatWrapper(Environment.getDataDirectory().getPath());
        long l = statwrapper.getBlockSize();
        long l1 = statwrapper.getAvailableBlocks();
        float f = 1.0F;
        if (l1 * l != 0L)
        {
            f = ((float)l1 * (float)l) / 1024F / 1024F / 1024F;
        }
        stringbuilder.append(f);
        stringbuilder.append(" - ");
        stringbuilder.append(Long.toString((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000L));
        Log.d(TAG, (new StringBuilder()).append("getDeviceState: ").append(StringUtils.MD5(stringbuilder.toString())).toString());
        return StringUtils.MD5(stringbuilder.toString());
    }

    static List getFontList()
    {
        ArrayList arraylist = new ArrayList();
        File afile[] = (new File("/system/fonts/")).listFiles();
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                String s = afile[i].getName();
                if (s != null && s.endsWith(".ttf"))
                {
                    arraylist.add(s.subSequence(0, s.lastIndexOf(".ttf")).toString());
                }
                i++;
            }
        }
        return arraylist;
    }

    static String getInfoFromFile(String s, List list, String s1)
    {
        Object obj;
        Object obj1;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        obj = null;
        obj1 = null;
        if (s == null || list == null || !(new File(s)).exists()) goto _L2; else goto _L1
_L1:
        BufferedReader bufferedreader = new BufferedReader(new FileReader(new File(s)));
_L9:
        s = bufferedreader.readLine();
        if (s == null) goto _L4; else goto _L3
_L3:
        obj = "";
        if (s1 == null) goto _L6; else goto _L5
_L5:
        if (s1.isEmpty()) goto _L6; else goto _L7
_L7:
        obj1 = StringUtils.splitNonRegex(s, s1);
        if (((List) (obj1)).isEmpty()) goto _L9; else goto _L8
_L8:
        String s2 = ((String)((List) (obj1)).get(0)).trim();
        if (s2.length() == 0) goto _L9; else goto _L10
_L10:
        s = ((String) (obj));
        if (!list.contains(s2))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        s = ((String) (obj));
        if (((List) (obj1)).size() > 1)
        {
            s = ((String)((List) (obj1)).get(1)).trim();
        }
_L13:
        if (!s.isEmpty())
        {
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(",");
            }
            stringbuilder.append(s);
        }
          goto _L9
        list;
        s = bufferedreader;
_L15:
        obj = s;
        Log.d(TAG, "get info = FAILED", list);
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.d(TAG, "get info = tidy up failed", s);
            }
        }
_L2:
        return stringbuilder.toString();
_L6:
        obj1 = new StringBuilder();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (s.contains((String)iterator.next()))
            {
                if (((StringBuilder) (obj1)).length() > 0)
                {
                    ((StringBuilder) (obj1)).append(",");
                }
                ((StringBuilder) (obj1)).append(s);
            }
        } while (true);
        s = ((String) (obj));
          goto _L11
        s;
        obj = bufferedreader;
_L14:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                Log.d(TAG, "get info = tidy up failed", list);
            }
        }
        throw s;
_L11:
        if (((StringBuilder) (obj1)).length() == 0) goto _L13; else goto _L12
_L12:
        s = ((StringBuilder) (obj1)).toString();
          goto _L13
_L4:
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.d(TAG, "get info = tidy up failed", s);
            }
        }
          goto _L2
        s;
          goto _L14
        list;
        s = ((String) (obj1));
          goto _L15
    }

    static String getMemInfo()
    {
        Object obj = new ArrayList();
        Collections.addAll(((java.util.Collection) (obj)), new String[] {
            "MemTotal"
        });
        obj = getInfoFromFile("/proc/meminfo", ((List) (obj)), ":");
        Log.d(TAG, (new StringBuilder()).append("getMemInfo returned: ").append(((String) (obj))).toString());
        return ((String) (obj));
    }

    static boolean getTimeZoneInfo(TZInfo tzinfo)
    {
        if (tzinfo == null)
        {
            throw new IllegalArgumentException("tzInfo cannot be null");
        }
        TimeZone timezone = TimeZone.getDefault();
        if (timezone != null)
        {
            tzinfo.gmtOffset = timezone.getRawOffset() / 60000;
            tzinfo.dstDiff = timezone.getDSTSavings() / 60000;
            Log.d(TAG, (new StringBuilder()).append("getTimeZoneInfo: dstDiff=").append(tzinfo.dstDiff).append(" gmfOffset=").append(tzinfo.gmtOffset).toString());
            return true;
        } else
        {
            Log.w(TAG, "getTimeZoneInfo: FAILED");
            return false;
        }
    }

    static String getURLs(List list)
        throws InterruptedException
    {
        StringBuilder stringbuilder1;
        Iterator iterator;
        stringbuilder1 = new StringBuilder();
        if (list == null || list.isEmpty())
        {
            return null;
        }
        iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        URI uri;
        uri = (URI)iterator.next();
        if (Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if (uri == null) goto _L4; else goto _L3
_L3:
        if (!uri.getScheme().equals("file")) goto _L6; else goto _L5
_L5:
        Object obj1;
        obj1 = new File(uri.getPath());
        list = uri.getQuery();
        if (list != null && !list.isEmpty()) goto _L8; else goto _L7
_L7:
        if (stringbuilder1.length() > 0)
        {
            stringbuilder1.append(";");
        }
        StringBuilder stringbuilder = stringbuilder1.append(uri.getPath()).append("=");
        if (((File) (obj1)).exists())
        {
            list = "true";
        } else
        {
            list = "false";
        }
        stringbuilder.append(list);
          goto _L4
_L8:
        if (!((File) (obj1)).exists()) goto _L4; else goto _L9
_L9:
        Map map;
        boolean flag;
        map = StringUtils.splitQuery(list);
        flag = map.containsKey("grep");
        if (!flag && !map.containsKey("keys")) goto _L4; else goto _L10
_L10:
        Object obj;
label0:
        {
            String s = (String)map.get("sep");
            list = s;
            if (flag)
            {
                break label0;
            }
            if (s != null)
            {
                list = s;
                if (!s.isEmpty())
                {
                    break label0;
                }
            }
            list = ":";
        }
        if (flag)
        {
            obj = (String)map.get("grep");
        } else
        {
            obj = (String)map.get("keys");
        }
        if (obj != null && !((String) (obj)).isEmpty()) goto _L11; else goto _L2
_L2:
        if (stringbuilder1.length() > 0)
        {
            Log.d(TAG, (new StringBuilder()).append("found ").append(stringbuilder1.toString()).toString());
        }
        return stringbuilder1.toString();
_L11:
        obj = StringUtils.splitNonRegex(((String) (obj)), ",");
        list = getInfoFromFile(((File) (obj1)).getAbsolutePath(), ((List) (obj)), list);
        if (list != null && !list.isEmpty())
        {
            if (stringbuilder1.length() > 0)
            {
                stringbuilder1.append(";");
            }
            stringbuilder1.append(uri.getPath()).append("=").append(list);
        }
          goto _L4
_L6:
        if (!uri.getScheme().equals("intro")) goto _L4; else goto _L12
_L12:
        obj1 = uri.getHost();
        obj = uri.getPath();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        if (!((String) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_463;
        }
        Log.d(TAG, "getURLs: empty className");
          goto _L4
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_474;
        }
        if (!((String) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_487;
        }
        Log.d(TAG, "getURLs: empty methodName");
          goto _L4
        list = ((List) (obj));
        if (((String) (obj)).startsWith("/"))
        {
            list = ((String) (obj)).substring(1);
        }
        obj = WrapperHelper.getClass(((String) (obj1)));
label1:
        {
            if (obj != null)
            {
                break label1;
            }
            try
            {
                Log.d(TAG, (new StringBuilder()).append("getURLs: failed to find class: ").append(((String) (obj1))).toString());
            }
            // Misplaced declaration of an exception variable
            catch (List list) { }
        }
          goto _L4
        obj1 = WrapperHelper.getMethod(((Class) (obj)), list, new Class[0]);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_630;
        }
        list = ((List) (WrapperHelper.invoke(obj, ((java.lang.reflect.Method) (obj1)), new Object[0])));
        if (list == null) goto _L4; else goto _L13
_L13:
        list = list.toString();
        if (list == null) goto _L4; else goto _L14
_L14:
        if (stringbuilder1.length() > 0)
        {
            stringbuilder1.append(";");
        }
        stringbuilder1.append(uri.getHost()).append(uri.getPath()).append("=").append(list);
          goto _L4
        obj1 = WrapperHelper.getField(((Class) (obj)), list);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_708;
        }
        list = ((List) (WrapperHelper.getValue(obj, ((java.lang.reflect.Field) (obj1)))));
        if (list == null) goto _L4; else goto _L15
_L15:
        if (!(list instanceof String)) goto _L4; else goto _L16
_L16:
        if (stringbuilder1.length() > 0)
        {
            stringbuilder1.append(";");
        }
        stringbuilder1.append(uri.getHost()).append(uri.getPath()).append("=").append((String)list);
          goto _L4
        Log.d(TAG, (new StringBuilder()).append("getURLs: failed to find method or field: ").append(list).toString());
          goto _L4
    }

}
