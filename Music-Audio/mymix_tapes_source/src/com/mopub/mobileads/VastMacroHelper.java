// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.mopub.mobileads:
//            VastMacro, VastErrorCode

public class VastMacroHelper
{

    private final Map mMacroDataMap = new HashMap();
    private final List mOriginalUris;

    public VastMacroHelper(List list)
    {
        Preconditions.checkNotNull(list, "uris cannot be null");
        mOriginalUris = list;
        mMacroDataMap.put(VastMacro.CACHEBUSTING, getCachebustingString());
    }

    private String formatContentPlayHead(int i)
    {
        return String.format("%02d:%02d:%02d.%03d", new Object[] {
            Long.valueOf(TimeUnit.MILLISECONDS.toHours(i)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(i) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(i) % TimeUnit.MINUTES.toSeconds(1L)), Integer.valueOf(i % 1000)
        });
    }

    private String getCachebustingString()
    {
        return String.format(Locale.US, "%08d", new Object[] {
            Long.valueOf(Math.round(Math.random() * 100000000D))
        });
    }

    public List getUris()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mOriginalUris.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!TextUtils.isEmpty(s))
            {
                VastMacro avastmacro[] = VastMacro.values();
                int j = avastmacro.length;
                for (int i = 0; i < j; i++)
                {
                    VastMacro vastmacro = avastmacro[i];
                    String s2 = (String)mMacroDataMap.get(vastmacro);
                    String s1 = s2;
                    if (s2 == null)
                    {
                        s1 = "";
                    }
                    s = s.replaceAll((new StringBuilder()).append("\\[").append(vastmacro.name()).append("\\]").toString(), s1);
                }

                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public VastMacroHelper withAssetUri(String s)
    {
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1 = URLEncoder.encode(s, "UTF-8");
        s = s1;
_L4:
        mMacroDataMap.put(VastMacro.ASSETURI, s);
_L2:
        return this;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        MoPubLog.w("Failed to encode url", unsupportedencodingexception);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public VastMacroHelper withContentPlayHead(Integer integer)
    {
        if (integer != null)
        {
            integer = formatContentPlayHead(integer.intValue());
            if (!TextUtils.isEmpty(integer))
            {
                mMacroDataMap.put(VastMacro.CONTENTPLAYHEAD, integer);
            }
        }
        return this;
    }

    public VastMacroHelper withErrorCode(VastErrorCode vasterrorcode)
    {
        if (vasterrorcode != null)
        {
            mMacroDataMap.put(VastMacro.ERRORCODE, vasterrorcode.getErrorCode());
        }
        return this;
    }
}
