// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, ay

class e extends aj
{

    private static final String ID;
    private static final String TD;
    private static final String TE;
    private final Context kL;

    public e(Context context)
    {
        super(ID, new String[] {
            TE
        });
        kL = context;
    }

    public boolean iy()
    {
        return true;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj = (com.google.android.gms.internal.d.a)map.get(TE);
        if (obj == null)
        {
            return di.ku();
        }
        obj = di.j(((com.google.android.gms.internal.d.a) (obj)));
        map = (com.google.android.gms.internal.d.a)map.get(TD);
        if (map != null)
        {
            map = di.j(map);
        } else
        {
            map = null;
        }
        map = ay.e(kL, ((String) (obj)), map);
        if (map != null)
        {
            return di.r(map);
        } else
        {
            return di.ku();
        }
    }

    static 
    {
        ID = a.ah.toString();
        TD = b.bS.toString();
        TE = b.bV.toString();
    }
}
