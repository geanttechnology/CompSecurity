// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import java.util.List;

public class aui
{

    private final PutDataRequest a;
    private final atz b = new atz();

    private aui(PutDataRequest putdatarequest, atz atz1)
    {
        a = putdatarequest;
        if (atz1 != null)
        {
            b.a(atz1);
        }
    }

    public static aui a(String s)
    {
        return new aui(PutDataRequest.a(s), null);
    }

    public atz a()
    {
        return b;
    }

    public PutDataRequest b()
    {
        agl agl1 = agk.a(b);
        a.a(aha.a(agl1.a));
        int j = agl1.b.size();
        for (int i = 0; i < j; i++)
        {
            String s = Integer.toString(i);
            Asset asset = (Asset)agl1.b.get(i);
            if (s == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("asset key cannot be null: ").append(asset).toString());
            }
            if (asset == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("asset cannot be null: key=").append(s).toString());
            }
            if (Log.isLoggable("DataMap", 3))
            {
                Log.d("DataMap", (new StringBuilder()).append("asPutDataRequest: adding asset: ").append(s).append(" ").append(asset).toString());
            }
            a.a(s, asset);
        }

        return a;
    }
}
