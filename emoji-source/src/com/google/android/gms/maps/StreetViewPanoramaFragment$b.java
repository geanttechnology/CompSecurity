// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaFragment, MapsInitializer

static class Mj extends a
{

    private final Fragment Mj;
    protected f ZF;
    private Activity og;

    static void a(Mj mj, Activity activity)
    {
        mj.setActivity(activity);
    }

    private void setActivity(Activity activity)
    {
        og = activity;
        jz();
    }

    protected void a(f f1)
    {
        ZF = f1;
        jz();
    }

    public void jz()
    {
        if (og == null || ZF == null || gH() != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        MapsInitializer.initialize(og);
        com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate istreetviewpanoramafragmentdelegate = u.H(og).j(e.h(og));
        ZF.a(new <init>(Mj, istreetviewpanoramafragmentdelegate));
        return;
        Object obj;
        obj;
        throw new RuntimeRemoteException(((RemoteException) (obj)));
        obj;
    }

    bleException(Fragment fragment)
    {
        Mj = fragment;
    }
}
