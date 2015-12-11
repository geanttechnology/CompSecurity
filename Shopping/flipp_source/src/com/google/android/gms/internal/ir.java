// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.internal:
//            ix, io

public final class ir
{

    public final ix a;
    public final Context b;
    boolean c;
    public HashMap d;
    private ContentProviderClient e;

    public ir(Context context, ix ix1)
    {
        e = null;
        c = false;
        d = new HashMap();
        b = context;
        a = ix1;
    }

    public final Location a()
    {
        a.a();
        Location location;
        try
        {
            location = ((io)a.b()).a(b.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }
}
