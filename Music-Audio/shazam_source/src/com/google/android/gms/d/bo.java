// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.b.d;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            bn, bl

public final class bo extends d
{

    private final bn a;
    private final List b;
    private final bl c;

    public bo(bn bn1)
    {
        b = new ArrayList();
        a = bn1;
        Iterator iterator = a.b().iterator();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        bn1 = ((bn) (iterator.next()));
        if (!(bn1 instanceof IBinder)) goto _L4; else goto _L3
_L3:
        bn1 = bk.a.a((IBinder)bn1);
_L7:
        if (bn1 == null) goto _L6; else goto _L5
_L5:
        b.add(new bl(bn1));
          goto _L6
        bn1;
        com.google.android.gms.ads.internal.util.client.b.a("Failed to get image.", bn1);
_L2:
        bn1 = a.d();
        if (bn1 == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        bn1 = new bl(bn1);
_L8:
        c = bn1;
        return;
_L4:
        bn1 = null;
          goto _L7
        bn1;
        com.google.android.gms.ads.internal.util.client.b.a("Failed to get icon.", bn1);
        bn1 = null;
          goto _L8
    }

    private c j()
    {
        c c1;
        try
        {
            c1 = a.i();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to retrieve native ad engine.", remoteexception);
            return null;
        }
        return c1;
    }

    protected final Object a()
    {
        return j();
    }

    public final CharSequence b()
    {
        String s;
        try
        {
            s = a.a();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get headline.", remoteexception);
            return null;
        }
        return s;
    }

    public final List c()
    {
        return b;
    }

    public final CharSequence d()
    {
        String s;
        try
        {
            s = a.c();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get body.", remoteexception);
            return null;
        }
        return s;
    }

    public final com.google.android.gms.ads.b.a.a e()
    {
        return c;
    }

    public final CharSequence f()
    {
        String s;
        try
        {
            s = a.e();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get call to action.", remoteexception);
            return null;
        }
        return s;
    }

    public final Double g()
    {
        double d1;
        try
        {
            d1 = a.f();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get star rating.", remoteexception);
            return null;
        }
        if (d1 == -1D)
        {
            return null;
        } else
        {
            return Double.valueOf(d1);
        }
    }

    public final CharSequence h()
    {
        String s;
        try
        {
            s = a.g();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get store", remoteexception);
            return null;
        }
        return s;
    }

    public final CharSequence i()
    {
        String s;
        try
        {
            s = a.h();
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a("Failed to get price.", remoteexception);
            return null;
        }
        return s;
    }
}
