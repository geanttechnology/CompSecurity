// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, DataLayer

class u extends aj
{

    private static final String ID;
    private static final String NAME;
    private static final String UC;
    private final DataLayer TN;

    public u(DataLayer datalayer)
    {
        super(ID, new String[] {
            NAME
        });
        TN = datalayer;
    }

    public boolean iy()
    {
        return false;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj = TN.get(di.j((com.google.android.gms.internal.d.a)map.get(NAME)));
        if (obj == null)
        {
            map = (com.google.android.gms.internal.d.a)map.get(UC);
            if (map != null)
            {
                return map;
            } else
            {
                return di.ku();
            }
        } else
        {
            return di.r(obj);
        }
    }

    static 
    {
        ID = a.N.toString();
        NAME = b.dn.toString();
        UC = b.cm.toString();
    }
}
