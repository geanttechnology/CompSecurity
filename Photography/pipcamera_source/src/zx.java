// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class zx
{

    private final Context a;
    private aad b[];
    private abw c;
    private Handler d;
    private aag e;
    private boolean f;
    private String g;
    private String h;
    private aaa i;

    public zx(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            a = context.getApplicationContext();
            return;
        }
    }

    public zw a()
    {
        if (c == null)
        {
            c = abw.a();
        }
        if (d == null)
        {
            d = new Handler(Looper.getMainLooper());
        }
        Object obj;
        IdManager idmanager;
        if (e == null)
        {
            if (f)
            {
                e = new zv(3);
            } else
            {
                e = new zv();
            }
        }
        if (h == null)
        {
            h = a.getPackageName();
        }
        if (i == null)
        {
            i = aaa.d;
        }
        if (b == null)
        {
            obj = new HashMap();
        } else
        {
            obj = zw.a(Arrays.asList(b));
        }
        idmanager = new IdManager(a, h, g, ((Map) (obj)).values());
        return new zw(a, ((Map) (obj)), c, d, e, f, i, idmanager);
    }

    public transient zx a(aad aaad[])
    {
        if (b != null)
        {
            throw new IllegalStateException("Kits already set.");
        } else
        {
            b = aaad;
            return this;
        }
    }
}
