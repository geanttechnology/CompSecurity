// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.n.b.a;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.common.weeklyad.c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.mothership.services.apigee.n.b.a:
//            h, a

public class b
{
    public static class a
        implements k
    {

        public b a(l l1, Type type, j j1)
            throws p
        {
            type = new b();
            l1 = l1.m();
            if (l1.b("type") == null)
            {
                return null;
            }
            b.a(type, com.target.mothership.common.weeklyad.c.a(l1.b("type").c()));
            static class _cls1
            {

                static final int $SwitchMap$com$target$mothership$common$weeklyad$Variation[];

                static 
                {
                    $SwitchMap$com$target$mothership$common$weeklyad$Variation = new int[com.target.mothership.common.weeklyad.c.values().length];
                    try
                    {
                        $SwitchMap$com$target$mothership$common$weeklyad$Variation[c.SIZES_AND_COLORS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$weeklyad$Variation[c.COLORS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$target$mothership$common$weeklyad$Variation[c.SIZES.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.target.mothership.common.weeklyad.Variation[type.a().ordinal()];
            JVM INSTR tableswitch 1 3: default 80
        //                       1 82
        //                       2 171
        //                       3 171;
               goto _L1 _L2 _L3 _L3
_L1:
            return type;
_L2:
            b.a(type, new LinkedHashMap());
            l1 = l1.b("data").m().a().iterator();
            while (l1.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)l1.next();
                b.a(type).put(entry.getKey(), (h)j1.a((l)entry.getValue(), com/target/mothership/services/apigee/n/b/a/h));
            }
            continue; /* Loop/switch isn't completed */
_L3:
            b.a(type, new ArrayList());
            l1 = l1.b("data").n().iterator();
            while (l1.hasNext()) 
            {
                l l2 = (l)l1.next();
                b.b(type).add((com.target.mothership.services.apigee.n.b.a.a)j1.a(l2, com/target/mothership/services/apigee/n/b/a/a));
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        public Object deserialize(l l1, Type type, j j1)
            throws p
        {
            return a(l1, type, j1);
        }

        public a()
        {
        }
    }


    private List mOneDimensionItems;
    private LinkedHashMap mTwoDimensionItems;
    private c mType;

    public b()
    {
    }

    static c a(b b1, c c1)
    {
        b1.mType = c1;
        return c1;
    }

    static LinkedHashMap a(b b1)
    {
        return b1.mTwoDimensionItems;
    }

    static LinkedHashMap a(b b1, LinkedHashMap linkedhashmap)
    {
        b1.mTwoDimensionItems = linkedhashmap;
        return linkedhashmap;
    }

    static List a(b b1, List list)
    {
        b1.mOneDimensionItems = list;
        return list;
    }

    static List b(b b1)
    {
        return b1.mOneDimensionItems;
    }

    public c a()
    {
        return mType;
    }

    public List b()
    {
        return mOneDimensionItems;
    }

    public LinkedHashMap c()
    {
        return mTwoDimensionItems;
    }
}
