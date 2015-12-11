// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            SupportMapFragment, MapsInitializer

static class Cg extends a
{

    protected d BX;
    private final Fragment Cg;
    private Activity gs;

    static void a(Cg cg, Activity activity)
    {
        cg.setActivity(activity);
    }

    private void setActivity(Activity activity)
    {
        gs = activity;
        ex();
    }

    protected void a(d d1)
    {
        BX = d1;
        ex();
    }

    public void ex()
    {
        if (gs == null || BX == null || cZ() != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        MapsInitializer.initialize(gs);
        com.google.android.gms.maps.internal.IMapFragmentDelegate imapfragmentdelegate = q.u(gs).f(c.h(gs));
        BX.a(new <init>(Cg, imapfragmentdelegate));
        return;
        Object obj;
        obj;
        throw new RuntimeRemoteException(((RemoteException) (obj)));
        obj;
    }

    otAvailableException(Fragment fragment)
    {
        Cg = fragment;
    }
}
