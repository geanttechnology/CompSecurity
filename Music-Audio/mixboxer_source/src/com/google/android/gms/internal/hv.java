// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            hu

public class hv
{

    private String DT[];
    private String DU;
    private String DV;
    private String DW;
    private ArrayList DY;
    private String DZ[];
    private String jG;

    public hv(Context context)
    {
        DY = new ArrayList();
        DV = context.getPackageName();
        DU = context.getPackageName();
        DY.add("https://www.googleapis.com/auth/plus.login");
    }

    public hv aA(String s)
    {
        jG = s;
        return this;
    }

    public transient hv d(String as[])
    {
        DY.clear();
        DY.addAll(Arrays.asList(as));
        return this;
    }

    public transient hv e(String as[])
    {
        DZ = as;
        return this;
    }

    public hv eY()
    {
        DY.clear();
        return this;
    }

    public hu eZ()
    {
        if (jG == null)
        {
            jG = "<<default account>>";
        }
        String as[] = (String[])DY.toArray(new String[DY.size()]);
        return new hu(jG, as, DZ, DT, DU, DV, DW);
    }
}
