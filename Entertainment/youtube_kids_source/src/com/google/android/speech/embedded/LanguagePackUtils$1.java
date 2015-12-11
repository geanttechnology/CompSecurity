// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.embedded;

import com.google.android.speech.utils.SpokenLanguageUtils;
import eyc;
import eyn;
import java.util.Comparator;

final class val.config
    implements Comparator
{

    final eyc val$config;

    public final int compare(eyn eyn1, eyn eyn2)
    {
        boolean flag1 = true;
        eyn1 = SpokenLanguageUtils.getDisplayName(val$config, eyn1.a);
        eyn2 = SpokenLanguageUtils.getDisplayName(val$config, eyn2.a);
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

    ()
    {
        val$config = eyc;
        super();
    }
}
