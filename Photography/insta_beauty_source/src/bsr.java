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

public class bsr
{

    private final Context a;
    private bsy b[];
    private bvf c;
    private Handler d;
    private btb e;
    private boolean f;
    private String g;
    private String h;
    private bsu i;

    public bsr(Context context)
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

    public bso a()
    {
        if (c == null)
        {
            c = bvf.a();
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
                e = new bsn(3);
            } else
            {
                e = new bsn();
            }
        }
        if (h == null)
        {
            h = a.getPackageName();
        }
        if (i == null)
        {
            i = bsu.d;
        }
        if (b == null)
        {
            obj = new HashMap();
        } else
        {
            obj = bso.a(Arrays.asList(b));
        }
        idmanager = new IdManager(a, h, g, ((Map) (obj)).values());
        return new bso(a, ((Map) (obj)), c, d, e, f, i, idmanager);
    }

    public transient bsr a(bsy absy[])
    {
        if (b != null)
        {
            throw new IllegalStateException("Kits already set.");
        } else
        {
            b = absy;
            return this;
        }
    }
}
