// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.support.v7.lj;
import android.support.v7.ll;
import android.support.v7.lm;
import android.support.v7.yz;
import android.support.v7.zv;
import android.view.ViewGroup;
import com.google.android.gms.common.c;
import com.google.android.gms.maps.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            MapView, d, e, GoogleMapOptions

static class d extends lj
{

    protected lm a;
    private final ViewGroup b;
    private final Context c;
    private final GoogleMapOptions d;
    private final List e = new ArrayList();

    protected void a(lm lm1)
    {
        a = lm1;
        g();
    }

    public void a(com.google.android.gms.maps.e e1)
    {
        if (a() != null)
        {
            ((a)a()).a(e1);
            return;
        } else
        {
            e.add(e1);
            return;
        }
    }

    public void g()
    {
        if (a == null || a() != null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        android.support.v7.yq yq;
        com.google.android.gms.maps.d.a(c);
        yq = zv.a(c).a(ll.a(c), d);
        if (yq == null)
        {
            return;
        }
        RemoteException remoteexception;
        a.a(new <init>(b, yq));
        com.google.android.gms.maps.e e1;
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((e)a()).a(e1))
        {
            e1 = (com.google.android.gms.maps.e)iterator.next();
        }

        try
        {
            e.clear();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        catch (c c1) { }
    }

    ptions(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
    {
        b = viewgroup;
        c = context;
        d = googlemapoptions;
    }
}
