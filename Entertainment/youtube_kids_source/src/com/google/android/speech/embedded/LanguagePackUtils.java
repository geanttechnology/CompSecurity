// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import a;
import android.util.Base64;
import ejr;
import els;
import elw;
import elx;
import ely;
import emp;
import eyc;
import eyn;
import f;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LanguagePackUtils
{

    private static final String TAG = "LanguagePackUtils";

    private LanguagePackUtils()
    {
    }

    public static String buildDownloadFilename(eyn eyn1)
    {
        return (new StringBuilder()).append(eyn1.c).append(".zip").toString();
    }

    public static eyn findById(eyn eyn1, List list)
    {
        return findById(eyn1.c, list);
    }

    public static eyn findById(String s, List list)
    {
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            eyn eyn1 = (eyn)list.get(i);
            if (eyn1.c.equals(s))
            {
                return eyn1;
            }
        }

        return null;
    }

    public static Map getCompatibleLanguagePacks(Map map, List list, int ai[], int i)
    {
        HashMap hashmap = ejr.a();
        for (map = map.values().iterator(); map.hasNext(); maybeAddCompatible(hashmap, (eyn)map.next(), ai, i)) { }
        for (map = list.iterator(); map.hasNext(); maybeAddCompatible(hashmap, (eyn)map.next(), ai, i)) { }
        return hashmap;
    }

    public static boolean isCompatible(eyn eyn1, int ai[], int i)
    {
        int j = eyn1.d.size();
        if (j != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int k;
        k = ((Integer)eyn1.d.get(j - 1)).intValue();
        j = 0;
_L5:
        if (j >= ai.length)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (ai[j] != k) goto _L4; else goto _L3
_L3:
        j = 1;
_L6:
        if (j != 0 && (i >= eyn1.f || !eyn1.e))
        {
            return true;
        }
          goto _L1
_L4:
        j++;
          goto _L5
        j = 0;
          goto _L6
    }

    public static String makeChecksum(File file)
    {
        return makeChecksum(new FileInputStream(file));
    }

    static String makeChecksum(FileInputStream fileinputstream)
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(fileinputstream);
        byte abyte0[];
        fileinputstream = ely.a().a();
        abyte0 = new byte[1024];
_L3:
        int i = bufferedinputstream.read(abyte0);
        if (i == -1) goto _L2; else goto _L1
_L1:
        fileinputstream.b(abyte0, 0, i);
          goto _L3
        fileinputstream;
_L5:
        emp.a(bufferedinputstream);
        throw fileinputstream;
_L2:
        abyte0 = new byte[21];
        fileinputstream = fileinputstream.a().b();
        int j = a.a(new int[] {
            20, fileinputstream.length
        });
        f.a(0, j + 0, 21);
        System.arraycopy(fileinputstream, 0, abyte0, 0, j);
        abyte0[20] = 32;
        fileinputstream = Base64.encodeToString(abyte0, 10);
        emp.a(bufferedinputstream);
        return fileinputstream;
        fileinputstream;
        bufferedinputstream = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void maybeAddCompatible(HashMap hashmap, eyn eyn1, int ai[], int i)
    {
        String s = eyn1.a;
        if (isCompatible(eyn1, ai, i) && (!hashmap.containsKey(s) || ((eyn)hashmap.get(s)).b < eyn1.b))
        {
            hashmap.put(s, eyn1);
        }
    }

    public static Comparator newLanguagePackComparator(final eyc config)
    {
        return new _cls1();
    }

    private class _cls1
        implements Comparator
    {

        final eyc val$config;

        public final int compare(eyn eyn1, eyn eyn2)
        {
            boolean flag1 = true;
            eyn1 = SpokenLanguageUtils.getDisplayName(config, eyn1.a);
            eyn2 = SpokenLanguageUtils.getDisplayName(config, eyn2.a);
            byte byte0;
            boolean flag;
            if (eyn1 == null)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (eyn2 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag ^ byte0)
            {
                byte0 = flag1;
                if (eyn1 == null)
                {
                    byte0 = -1;
                }
                return byte0;
            }
            if (eyn1 != null && eyn2 != null)
            {
                return eyn1.compareTo(eyn2);
            } else
            {
                return 0;
            }
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((eyn)obj, (eyn)obj1);
        }

        _cls1()
        {
            config = eyc;
            super();
        }
    }

}
