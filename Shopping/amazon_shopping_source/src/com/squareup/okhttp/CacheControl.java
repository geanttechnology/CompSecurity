// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import com.squareup.okhttp.internal.http.Headers;

public final class CacheControl
{

    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    private CacheControl(boolean flag, boolean flag1, int i, int j, boolean flag2, boolean flag3, int k, 
            int l, boolean flag4)
    {
        noCache = flag;
        noStore = flag1;
        maxAgeSeconds = i;
        sMaxAgeSeconds = j;
        isPublic = flag2;
        mustRevalidate = flag3;
        maxStaleSeconds = k;
        minFreshSeconds = l;
        onlyIfCached = flag4;
    }

    public static CacheControl parse(Headers headers)
    {
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = false;
        flag3 = false;
        j1 = -1;
        i1 = -1;
        flag2 = false;
        flag1 = false;
        l = -1;
        k = -1;
        flag = false;
        k1 = 0;
_L2:
        int i;
        int i2;
        int j2;
        int k2;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        if (k1 >= headers.size())
        {
            break MISSING_BLOCK_LABEL_540;
        }
        if (headers.name(k1).equalsIgnoreCase("Cache-Control") || headers.name(k1).equalsIgnoreCase("Pragma"))
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = flag;
        i = k;
        i2 = l;
        flag6 = flag1;
        flag7 = flag2;
        j2 = i1;
        k2 = j1;
        flag8 = flag3;
        flag9 = flag4;
_L4:
        k1++;
        flag4 = flag9;
        flag3 = flag8;
        j1 = k2;
        i1 = j2;
        flag2 = flag7;
        flag1 = flag6;
        l = i2;
        k = i;
        flag = flag5;
        if (true) goto _L2; else goto _L1
_L1:
        String s1;
        int l1;
        s1 = headers.value(k1);
        l1 = 0;
_L5:
        flag9 = flag4;
        flag8 = flag3;
        k2 = j1;
        j2 = i1;
        flag7 = flag2;
        flag6 = flag1;
        i2 = l;
        i = k;
        flag5 = flag;
        if (l1 >= s1.length()) goto _L4; else goto _L3
_L3:
        int j = HeaderParser.skipUntil(s1, l1, "=,;");
        String s2 = s1.substring(l1, j).trim();
        String s;
        if (j == s1.length() || s1.charAt(j) == ',' || s1.charAt(j) == ';')
        {
            j++;
            s = null;
        } else
        {
            l1 = HeaderParser.skipWhitespace(s1, j + 1);
            if (l1 < s1.length() && s1.charAt(l1) == '"')
            {
                j = l1 + 1;
                l1 = HeaderParser.skipUntil(s1, j, "\"");
                s = s1.substring(j, l1);
                j = l1 + 1;
            } else
            {
                j = HeaderParser.skipUntil(s1, l1, ",;");
                s = s1.substring(l1, j).trim();
            }
        }
        if ("no-cache".equalsIgnoreCase(s2))
        {
            flag4 = true;
            l1 = j;
        } else
        if ("no-store".equalsIgnoreCase(s2))
        {
            flag3 = true;
            l1 = j;
        } else
        if ("max-age".equalsIgnoreCase(s2))
        {
            j1 = HeaderParser.parseSeconds(s);
            l1 = j;
        } else
        if ("s-maxage".equalsIgnoreCase(s2))
        {
            i1 = HeaderParser.parseSeconds(s);
            l1 = j;
        } else
        if ("public".equalsIgnoreCase(s2))
        {
            flag2 = true;
            l1 = j;
        } else
        if ("must-revalidate".equalsIgnoreCase(s2))
        {
            flag1 = true;
            l1 = j;
        } else
        if ("max-stale".equalsIgnoreCase(s2))
        {
            l = HeaderParser.parseSeconds(s);
            l1 = j;
        } else
        if ("min-fresh".equalsIgnoreCase(s2))
        {
            k = HeaderParser.parseSeconds(s);
            l1 = j;
        } else
        {
            l1 = j;
            if ("only-if-cached".equalsIgnoreCase(s2))
            {
                flag = true;
                l1 = j;
            }
        }
          goto _L5
          goto _L4
        return new CacheControl(flag4, flag3, j1, i1, flag2, flag1, l, k, flag);
    }

    public boolean isPublic()
    {
        return isPublic;
    }

    public int maxAgeSeconds()
    {
        return maxAgeSeconds;
    }

    public int maxStaleSeconds()
    {
        return maxStaleSeconds;
    }

    public int minFreshSeconds()
    {
        return minFreshSeconds;
    }

    public boolean mustRevalidate()
    {
        return mustRevalidate;
    }

    public boolean noCache()
    {
        return noCache;
    }

    public boolean noStore()
    {
        return noStore;
    }

    public boolean onlyIfCached()
    {
        return onlyIfCached;
    }

    public int sMaxAgeSeconds()
    {
        return sMaxAgeSeconds;
    }
}
