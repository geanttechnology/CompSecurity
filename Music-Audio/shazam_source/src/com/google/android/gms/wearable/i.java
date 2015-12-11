// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.d.kr;
import com.google.android.gms.d.ks;
import com.google.android.gms.d.lb;
import com.google.android.gms.d.lc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.wearable:
//            f, h, g, Asset

public final class i
{

    private final Uri a;
    private final h b;

    private i(f f1)
    {
        a = f1.b();
        b = b((f)f1.a());
    }

    public static i a(f f1)
    {
        if (f1 == null)
        {
            throw new IllegalStateException("provided dataItem is null");
        } else
        {
            return new i(f1);
        }
    }

    private static h b(f f1)
    {
        if (f1.c() == null && f1.d().size() > 0)
        {
            throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
        }
        if (f1.c() == null)
        {
            return new h();
        }
        Object obj;
        int k;
        obj = new ArrayList();
        k = f1.d().size();
        int j = 0;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        g g1 = (g)f1.d().get(Integer.toString(j));
        if (g1 == null)
        {
            byte abyte0[];
            try
            {
                throw new IllegalStateException((new StringBuilder("Cannot find DataItemAsset referenced in data at ")).append(j).append(" for ").append(f1).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            (new StringBuilder("Unable to parse datamap from dataItem. uri=")).append(f1.b()).append(", data=").append(Base64.encodeToString(f1.c(), 0));
            throw new IllegalStateException((new StringBuilder("Unable to parse datamap from dataItem.  uri=")).append(f1.b()).toString(), ((Throwable) (obj)));
        }
        ((List) (obj)).add(Asset.a(g1.b()));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        abyte0 = f1.c();
        obj = kr.a(new com.google.android.gms.d.kr.a((ks)lc.a(new ks(), abyte0, abyte0.length), ((List) (obj))));
        return ((h) (obj));
    }

    public final h a()
    {
        return b;
    }
}
