// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import com.target.mothership.util.o;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, s, q

public class m extends c
{

    private final String mBarcode;

    private m(String s1)
    {
        mBarcode = s1;
    }

    public static m a(String s1)
    {
        return new m(s1);
    }

    private String b(String s1)
    {
        String s2 = s1;
        if (o.e(s1))
        {
            s2 = "scan error";
        }
        return s2;
    }

    protected Map b()
    {
        a a1 = new a();
        a1.put("events", "upcBarcodeScan");
        a1.put("upcCode", b(mBarcode));
        return a1;
    }

    protected s c()
    {
        return s.SearchResults;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected q i()
    {
        return q.BarcodeScan;
    }
}
