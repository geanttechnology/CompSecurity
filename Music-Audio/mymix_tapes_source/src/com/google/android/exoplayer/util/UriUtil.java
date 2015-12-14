// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UriUtil
{

    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil()
    {
    }

    private static int[] getUriIndices(String s)
    {
        int l;
        int j1;
        int ai[];
        int i;
        int j;
label0:
        {
            ai = new int[4];
            if (TextUtils.isEmpty(s))
            {
                ai[0] = -1;
                return ai;
            }
            i = s.length();
            int k = s.indexOf('#');
            j = k;
            if (k == -1)
            {
                j = i;
            }
            k = s.indexOf('?');
            if (k != -1)
            {
                i = k;
                if (k <= j)
                {
                    break label0;
                }
            }
            i = j;
        }
label1:
        {
            int i1 = s.indexOf('/');
            if (i1 != -1)
            {
                l = i1;
                if (i1 <= i)
                {
                    break label1;
                }
            }
            l = i;
        }
        int k1 = s.indexOf(':');
        j1 = k1;
        if (k1 > l)
        {
            j1 = -1;
        }
        if (j1 + 2 < i && s.charAt(j1 + 1) == '/' && s.charAt(j1 + 2) == '/')
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (l == 0) goto _L2; else goto _L1
_L1:
label2:
        {
            k1 = s.indexOf('/', j1 + 3);
            if (k1 != -1)
            {
                l = k1;
                if (k1 <= i)
                {
                    break label2;
                }
            }
            l = i;
        }
_L4:
        ai[0] = j1;
        ai[1] = l;
        ai[2] = i;
        ai[3] = j;
        return ai;
_L2:
        l = j1 + 1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String removeDotSegments(StringBuilder stringbuilder, int i, int j)
    {
        int k;
        int l;
        if (i >= j)
        {
            return stringbuilder.toString();
        }
        k = i;
        if (stringbuilder.charAt(i) == '/')
        {
            k = i + 1;
        }
        int i1 = k;
        i = k;
        l = j;
        j = i1;
_L2:
        if (i > l)
        {
            break; /* Loop/switch isn't completed */
        }
        int j1;
        if (i == l)
        {
            j1 = i;
        } else
        {
label0:
            {
                if (stringbuilder.charAt(i) != '/')
                {
                    break label0;
                }
                j1 = i + 1;
            }
        }
        if (i == j + 1 && stringbuilder.charAt(j) == '.')
        {
            stringbuilder.delete(j, j1);
            l -= j1 - j;
            i = j;
        } else
        if (i == j + 2 && stringbuilder.charAt(j) == '.' && stringbuilder.charAt(j + 1) == '.')
        {
            i = stringbuilder.lastIndexOf("/", j - 2) + 1;
            if (i > k)
            {
                j = i;
            } else
            {
                j = k;
            }
            stringbuilder.delete(j, j1);
            l -= j1 - j;
            j = i;
        } else
        {
            i++;
            j = i;
        }
        continue; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
    }

    public static String resolve(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = getUriIndices(s);
        if (s1[0] != -1)
        {
            stringbuilder.append(s);
            removeDotSegments(stringbuilder, s1[1], s1[2]);
            return stringbuilder.toString();
        }
        int ai[] = getUriIndices(s2);
        if (s1[3] == 0)
        {
            return stringbuilder.append(s2, 0, ai[3]).append(s).toString();
        }
        if (s1[2] == 0)
        {
            return stringbuilder.append(s2, 0, ai[2]).append(s).toString();
        }
        if (s1[1] != 0)
        {
            int i = ai[0] + 1;
            stringbuilder.append(s2, 0, i).append(s);
            return removeDotSegments(stringbuilder, s1[1] + i, s1[2] + i);
        }
        if (s1[1] != s1[2] && s.charAt(s1[1]) == '/')
        {
            stringbuilder.append(s2, 0, ai[1]).append(s);
            return removeDotSegments(stringbuilder, ai[1], ai[1] + s1[2]);
        }
        if (ai[0] + 2 < ai[1] && ai[1] == ai[2])
        {
            stringbuilder.append(s2, 0, ai[1]).append('/').append(s);
            return removeDotSegments(stringbuilder, ai[1], ai[1] + s1[2] + 1);
        }
        int j = s2.lastIndexOf('/', ai[2] - 1);
        if (j == -1)
        {
            j = ai[1];
        } else
        {
            j++;
        }
        stringbuilder.append(s2, 0, j).append(s);
        return removeDotSegments(stringbuilder, ai[1], s1[2] + j);
    }

    public static Uri resolveToUri(String s, String s1)
    {
        return Uri.parse(resolve(s, s1));
    }
}
