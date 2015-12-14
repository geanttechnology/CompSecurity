// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.widget.TextView;
import com.pf.common.utility.m;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ak

public class aj
{

    public static transient Float a(DisplayMetrics displaymetrics, ak aak[])
    {
        float f;
        int i;
        f = (float)displaymetrics.widthPixels / displaymetrics.density;
        displaymetrics = Locale.getDefault().getLanguage();
        i = 0;
_L1:
        int j;
        if (i < aak.length)
        {
            ak ak1 = aak[i];
            j = 0;
            do
            {
                if (j >= ak.a(ak1).length)
                {
                    break MISSING_BLOCK_LABEL_103;
                }
                if (displaymetrics.equalsIgnoreCase(ak.a(ak1)[j]))
                {
                    j = 1;
                    break MISSING_BLOCK_LABEL_63;
                }
                j++;
            } while (true);
        } else
        {
            return null;
        }
_L2:
        if (j != 0)
        {
            return Float.valueOf((ak.b(ak1) * f) / ak.c(ak1));
        }
        i++;
          goto _L1
        j = 0;
          goto _L2
    }

    public static Float a(Display display, ak ak1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return Float.valueOf((((float)displaymetrics.widthPixels / displaymetrics.density) * ak.b(ak1)) / ak.c(ak1));
    }

    public static transient Float a(Display display, ak aak[])
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        return a(displaymetrics, aak);
    }

    public static Map a(String s)
    {
        HashMap hashmap;
        int i;
        int k;
        s = s.replaceAll(" ", "").split(";");
        hashmap = new HashMap();
        k = s.length;
        i = 0;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        String s1;
        String as[];
        s1 = s[i];
        as = s1.split(":");
        String as1[];
        int l;
        as1 = as[2].split(",");
        l = as1.length;
        int j = 0;
_L4:
        if (j >= l)
        {
            continue; /* Loop/switch isn't completed */
        }
        hashmap.put(as1[j], new ak(Float.parseFloat(as[0]), Float.parseFloat(as[1]), new String[0]));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        m.b("MultiLangTextSizeUtils", s1, exception);
        i++;
          goto _L5
_L2:
        return hashmap;
    }

    public static void a(TextView textview, boolean flag, Map map)
    {
        DisplayMetrics displaymetrics = textview.getResources().getDisplayMetrics();
        ak ak1 = (ak)map.get(Locale.getDefault().getLanguage());
        map = (ak)map.get("default");
        float f1 = (float)displaymetrics.widthPixels / displaymetrics.density;
        if (ak1 == null && map == null)
        {
            return;
        }
        float f = textview.getTextSize();
        if (map != null)
        {
            f = TypedValue.applyDimension(1, (ak.b(map) * f1) / ak.c(map), displaymetrics);
        }
        if (ak1 != null)
        {
            float f2 = TypedValue.applyDimension(1, (ak.b(ak1) * f1) / ak.c(ak1), displaymetrics);
            f1 = f2;
            if (flag)
            {
                f1 = Math.min(f, f2);
            }
        } else
        {
            f1 = f;
        }
        textview.setTextSize(0, f1);
    }
}
