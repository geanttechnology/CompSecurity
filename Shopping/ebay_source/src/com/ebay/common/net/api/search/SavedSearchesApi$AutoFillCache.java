// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static final class baseUrl
{

    public final String autofillVersion;
    public final String baseUrl;
    public final HashMap cache = new HashMap();
    public final String siteId;

    public final String[] get(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String[])cache.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public final URL getAutoFillUrl(String s)
    {
        Object obj;
        obj = null;
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_471;
        }
        char c;
        int i;
        int j;
        if (baseUrl.endsWith("/"))
        {
            obj = baseUrl.substring(0, baseUrl.length() - 1);
        } else
        {
            obj = baseUrl;
        }
        j = s.length();
        i = j;
        if (j > 4)
        {
            i = 4;
        }
        j = 0;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        c = s.charAt(j);
        obj = (new StringBuilder()).append(((String) (obj))).append('/').toString();
        c;
        JVM INSTR lookupswitch 9: default 180
    //                   33: 281
    //                   39: 350
    //                   40: 373
    //                   41: 396
    //                   42: 419
    //                   45: 258
    //                   46: 304
    //                   95: 235
    //                   126: 327;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L6:
        break MISSING_BLOCK_LABEL_419;
_L9:
        break; /* Loop/switch isn't completed */
_L1:
        obj = (new StringBuilder()).append(((String) (obj))).append(Uri.encode(String.valueOf(c)).toLowerCase(Locale.getDefault()).replace('%', '_')).toString();
_L14:
        j++;
        if (true) goto _L12; else goto _L11
_L12:
        break MISSING_BLOCK_LABEL_61;
_L11:
        obj = (new StringBuilder()).append(((String) (obj))).append("_5f").toString();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = (new StringBuilder()).append(((String) (obj))).append("_2d").toString();
        continue; /* Loop/switch isn't completed */
_L2:
        obj = (new StringBuilder()).append(((String) (obj))).append("_21").toString();
        continue; /* Loop/switch isn't completed */
_L8:
        obj = (new StringBuilder()).append(((String) (obj))).append("_2e").toString();
        continue; /* Loop/switch isn't completed */
_L10:
        obj = (new StringBuilder()).append(((String) (obj))).append("_7e").toString();
        continue; /* Loop/switch isn't completed */
_L3:
        obj = (new StringBuilder()).append(((String) (obj))).append("_27").toString();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = (new StringBuilder()).append(((String) (obj))).append("_28").toString();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = (new StringBuilder()).append(((String) (obj))).append("_29").toString();
        continue; /* Loop/switch isn't completed */
        obj = (new StringBuilder()).append(((String) (obj))).append("_2a").toString();
        if (true) goto _L14; else goto _L13
_L13:
        s = (new StringBuilder()).append(((String) (obj))).append(".js").toString();
        try
        {
            obj = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public final String[] put(String s, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        s = (String[])cache.put(s, as);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public (String s, String s1)
    {
        siteId = s;
        autofillVersion = s1;
        baseUrl = EbaySettings.getAutoFillRequest(s, s1);
    }
}
