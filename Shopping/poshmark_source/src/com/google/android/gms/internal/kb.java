// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            kg, jy, ke, kh

public class kb
{

    protected final Class aaf;
    protected final boolean aag;
    protected final int tag;
    protected final int type;

    private kb(int i, Class class1, int j, boolean flag)
    {
        type = i;
        aaf = class1;
        tag = j;
        aag = flag;
    }

    public static kb a(int i, Class class1, int j)
    {
        return new kb(i, class1, j, false);
    }

    protected void a(kg kg1, List list)
    {
        list.add(o(jy.n(kg1.aai)));
    }

    protected boolean cI(int i)
    {
        return i == tag;
    }

    final Object g(List list)
    {
        boolean flag = false;
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
label0:
        {
            if (!aag)
            {
                break label0;
            }
            ArrayList arraylist = new ArrayList();
            for (int i = 0; i < list.size(); i++)
            {
                kg kg1 = (kg)list.get(i);
                if (cI(kg1.tag) && kg1.aai.length != 0)
                {
                    a(kg1, arraylist);
                }
            }

            int l = arraylist.size();
            if (l == 0)
            {
                return null;
            }
            Object obj = aaf.cast(Array.newInstance(aaf.getComponentType(), l));
            int j = ((flag) ? 1 : 0);
            do
            {
                list = ((List) (obj));
                if (j >= l)
                {
                    break;
                }
                Array.set(obj, j, arraylist.get(j));
                j++;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        int k = list.size() - 1;
        kg kg2;
        for (kg2 = null; kg2 == null && k >= 0; k--)
        {
            kg kg3 = (kg)list.get(k);
            if (cI(kg3.tag) && kg3.aai.length != 0)
            {
                kg2 = kg3;
            }
        }

        if (kg2 == null)
        {
            return null;
        } else
        {
            return aaf.cast(o(jy.n(kg2.aai)));
        }
    }

    protected Object o(jy jy1)
    {
        Class class1;
        if (aag)
        {
            class1 = aaf.getComponentType();
        } else
        {
            class1 = aaf;
        }
        type;
        JVM INSTR tableswitch 10 11: default 185
    //                   10 107
    //                   11 129;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(type).toString());
_L2:
        ke ke1;
        try
        {
            ke1 = (ke)class1.newInstance();
            jy1.a(ke1, kh.cK(tag));
        }
        // Misplaced declaration of an exception variable
        catch (jy jy1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error creating instance of class ").append(class1).toString(), jy1);
        }
        // Misplaced declaration of an exception variable
        catch (jy jy1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Error creating instance of class ").append(class1).toString(), jy1);
        }
        // Misplaced declaration of an exception variable
        catch (jy jy1)
        {
            throw new IllegalArgumentException("Error reading extension field", jy1);
        }
        return ke1;
_L3:
        ke1 = (ke)class1.newInstance();
        jy1.a(ke1);
        return ke1;
    }
}
