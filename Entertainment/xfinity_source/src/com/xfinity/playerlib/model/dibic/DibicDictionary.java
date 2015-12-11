// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DibicDictionary
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/dibic/DibicDictionary);
    private final int tokens[];
    private final String words[];

    public DibicDictionary(int ai[], String as[])
    {
        Validate.notNull(ai);
        Validate.notNull(as);
        tokens = ai;
        words = as;
    }

    private List getStringsByRange(int i, boolean flag)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        LOG.error("Key {} is negative", Integer.valueOf(i));
        arraylist = new ArrayList();
_L4:
        return arraylist;
_L2:
        int j = i >> 10 & 0x3fffff;
        int l = (j + (i & 0x3ff)) - 1;
        if (j >= tokens.length || l >= tokens.length)
        {
            LOG.error("Key {} (firstIndex {}, lastIndex {}) is out of range (tokens.length {})", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(l), Integer.valueOf(tokens.length)
            });
            return new ArrayList();
        }
        ArrayList arraylist1 = new ArrayList();
        i = j;
        do
        {
            arraylist = arraylist1;
            if (i > l)
            {
                continue;
            }
            int k = tokens[i];
            if (k >= words.length)
            {
                LOG.error("Word index {} is out of bounds (words.length is {})", Integer.valueOf(k), Integer.valueOf(words.length));
            } else
            {
                String s = words[k];
                if (!flag || !s.equals(",") && !s.equals("|"))
                {
                    arraylist1.add(s);
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getStringByKey(int i)
    {
        Object obj = getStringsByRange(i, false);
        StringBuilder stringbuilder = new StringBuilder();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)((Iterator) (obj)).next())) { }
        return stringbuilder.toString();
    }

    public List getStringsByKey(int i)
    {
        return getStringsByRange(i, true);
    }

}
