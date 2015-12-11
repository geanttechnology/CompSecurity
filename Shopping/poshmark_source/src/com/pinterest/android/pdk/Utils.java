// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKClient

public class Utils
{

    private static final String TAG = "PDK";
    private static DateFormat _dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public Utils()
    {
    }

    public static DateFormat getDateFormatter()
    {
        return _dateFormat;
    }

    public static String getUrlWithQueryParams(String s, List list)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = s.replace(" ", "%20");
            s = s1;
            if (!s1.endsWith("?"))
            {
                s = (new StringBuilder()).append(s1).append("?").toString();
            }
            s1 = s;
            if (list != null)
            {
                s1 = s;
                if (list.size() > 0)
                {
                    list = URLEncodedUtils.format(list, "utf-8");
                    return (new StringBuilder()).append(s).append(list).toString();
                }
            }
        }
        return s1;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isEmpty(Collection collection)
    {
        return collection == null || collection.size() == 0;
    }

    public static boolean isEmpty(Map map)
    {
        return map == null || map.size() == 0;
    }

    public static transient void log(String s, Object aobj[])
    {
        if (PDKClient.isDebugMode())
        {
            Log.i("PDK", String.format(s, aobj));
        }
    }

    public static transient void loge(String s, Object aobj[])
    {
        if (PDKClient.isDebugMode())
        {
            Log.e("PDK", String.format(s, aobj));
        }
    }

}
