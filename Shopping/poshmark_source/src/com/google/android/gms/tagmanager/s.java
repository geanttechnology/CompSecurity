// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, bh

class s extends aj
{
    public static interface a
    {

        public abstract Object b(String s1, Map map);
    }


    private static final String ID;
    private static final String TF;
    private static final String Up;
    private final a Uq;

    public s(a a1)
    {
        super(ID, new String[] {
            Up
        });
        Uq = a1;
    }

    public boolean iy()
    {
        return false;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        String s1 = di.j((com.google.android.gms.internal.d.a)map.get(Up));
        HashMap hashmap = new HashMap();
        map = (com.google.android.gms.internal.d.a)map.get(TF);
        if (map != null)
        {
            map = ((Map) (di.o(map)));
            if (!(map instanceof Map))
            {
                bh.w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.ku();
            }
            java.util.Map.Entry entry;
            for (map = ((Map)map).entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey().toString(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        try
        {
            map = di.r(Uq.b(s1, hashmap));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            bh.w((new StringBuilder()).append("Custom macro/tag ").append(s1).append(" threw exception ").append(map.getMessage()).toString());
            return di.ku();
        }
        return map;
    }

    static 
    {
        ID = com.google.android.gms.internal.a.U.toString();
        Up = b.cJ.toString();
        TF = b.bi.toString();
    }
}
