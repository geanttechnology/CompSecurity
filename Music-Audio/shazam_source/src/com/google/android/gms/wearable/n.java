// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.util.Log;
import com.google.android.gms.d.kr;
import com.google.android.gms.d.ks;
import com.google.android.gms.d.lc;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.wearable:
//            h, PutDataRequest, Asset

public final class n
{

    public final h a = new h();
    private final PutDataRequest b;

    public n(PutDataRequest putdatarequest)
    {
        b = putdatarequest;
    }

    public final PutDataRequest a()
    {
        Object obj = a;
        ks ks1 = new ks();
        ArrayList arraylist = new ArrayList();
        ks1.a = kr.a(((h) (obj)), arraylist);
        obj = new com.google.android.gms.d.kr.a(ks1, arraylist);
        b.d = lc.a(((com.google.android.gms.d.kr.a) (obj)).a);
        int j = ((com.google.android.gms.d.kr.a) (obj)).b.size();
        for (int i = 0; i < j; i++)
        {
            String s = Integer.toString(i);
            Asset asset = (Asset)((com.google.android.gms.d.kr.a) (obj)).b.get(i);
            if (s == null)
            {
                throw new IllegalStateException((new StringBuilder("asset key cannot be null: ")).append(asset).toString());
            }
            if (asset == null)
            {
                throw new IllegalStateException((new StringBuilder("asset cannot be null: key=")).append(s).toString());
            }
            if (Log.isLoggable("DataMap", 3))
            {
                (new StringBuilder("asPutDataRequest: adding asset: ")).append(s).append(" ").append(asset);
            }
            b.a(s, asset);
        }

        return b;
    }
}
