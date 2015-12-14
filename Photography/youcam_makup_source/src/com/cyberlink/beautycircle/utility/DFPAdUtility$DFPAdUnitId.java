// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.Context;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;

public final class testId extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];
    private final int id;
    private final int testId;

    public static testId valueOf(String s)
    {
        return (testId)Enum.valueOf(com/cyberlink/beautycircle/utility/DFPAdUtility$DFPAdUnitId, s);
    }

    public static testId[] values()
    {
        return (testId[])d.clone();
    }

    public String a()
    {
        Globals globals;
label0:
        {
            String s = null;
            globals = Globals.n();
            if (globals != null)
            {
                if (Globals.c() != "PRODUCTION")
                {
                    break label0;
                }
                s = globals.getString(id);
            }
            return s;
        }
        return globals.getString(testId);
    }

    static 
    {
        a = new <init>("MAIN", 0, m.bc_main_page_topbanner, m.bc_main_page_topbanner_test);
        b = new <init>("DISCOVER", 1, m.bc_discover_page_topbanner, m.bc_discover_page_topbanner_test);
        c = new <init>("PRODUCT", 2, m.bc_product_page_topbanner, m.bc_product_page_topbanner_test);
        d = (new d[] {
            a, b, c
        });
    }

    private A(String s, int i, int j, int k)
    {
        super(s, i);
        id = j;
        testId = k;
    }
}
