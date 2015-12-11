// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.c.aa;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.network.managers:
//            ak

class a
    implements Observer
{

    final ak a;

    public void update(Observable observable, Object obj)
    {
        observable = (String)((Map)obj).get("ACTION");
        if ("PRODUCTS_LOADED_ACTION".equals(observable))
        {
            aa.c(ak.l(), "Products Downloaded.");
            ak.a(a);
        } else
        {
            if ("ENTITLEMENTS_UPDATED_ACTION".equals(observable))
            {
                aa.c(ak.l(), "Entitlements Updated.");
                ak.a(a);
                return;
            }
            if ("SONGBOOK_SYNCED_ACTION".equals(observable))
            {
                aa.c(ak.l(), "Songbook sync completed");
                ak.a(a);
                return;
            }
        }
    }

    (ak ak1)
    {
        a = ak1;
        super();
    }
}
