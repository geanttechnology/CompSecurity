// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class awj
{

    public final Set a = new HashSet();
    public final Map b = new HashMap();
    private String c;
    private final Context d;
    private int e;
    private Looper f;
    private int g;
    private final Set h = new HashSet();
    private final Set i = new HashSet();

    public awj(Context context)
    {
        e = -1;
        g = 2;
        d = context;
        f = context.getMainLooper();
        c = context.getPackageName();
    }

    private ClientSettings b()
    {
        return new ClientSettings(null, a, 0, null, c);
    }

    public final awi a()
    {
        Object obj;
        boolean flag;
        boolean flag1 = true;
        Object obj1;
        awy awy1;
        int k;
        if (!b.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag, "must call addApi() to add at least one API");
        if (e < 0)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        awy1 = awy.a(null);
        k = e;
        if (((j) (awy1)).w == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj = awy1.b(k);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj = ((awz) (obj)).f;
_L1:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new awq(d.getApplicationContext(), f, b(), b, h, i, e, g);
        }
        k = e;
        a.f(obj1, "GoogleApiClient instance cannot be null");
        if (awy1.a.indexOfKey(k) < 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a.a(flag, (new StringBuilder("Already managing a GoogleApiClient with id ")).append(k).toString());
        obj = new axa(((awi) (obj1)), null);
        awy1.a.put(k, obj);
        if (((j) (awy1)).w != null)
        {
            awy1.f().a(k, null, awy1);
        }
        return ((awi) (obj1));
        obj = null;
          goto _L1
        return new awq(d, f, b(), b, h, i, -1, g);
    }

    public final awj a(avt avt)
    {
        i.add(avt);
        return this;
    }
}
