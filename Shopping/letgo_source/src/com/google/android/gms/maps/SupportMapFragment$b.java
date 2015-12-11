// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v7.lj;
import android.support.v7.ll;
import android.support.v7.lm;
import android.support.v7.yz;
import android.support.v7.zv;
import com.google.android.gms.common.c;
import com.google.android.gms.maps.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            SupportMapFragment, d, e

static class b extends lj
{

    protected lm a;
    private final Fragment b;
    private Activity c;
    private final List d = new ArrayList();

    private void a(Activity activity)
    {
        c = activity;
        g();
    }

    static void a(g g1, Activity activity)
    {
        g1.a(activity);
    }

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
            d.add(e1);
            return;
        }
    }

    public void g()
    {
        if (c == null || a == null || a() != null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        android.support.v7.yp yp;
        com.google.android.gms.maps.d.a(c);
        yp = zv.a(c).b(ll.a(c));
        if (yp == null)
        {
            return;
        }
        RemoteException remoteexception;
        a.a(new <init>(b, yp));
        com.google.android.gms.maps.e e1;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((d)a()).a(e1))
        {
            e1 = (com.google.android.gms.maps.e)iterator.next();
        }

        try
        {
            d.clear();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
        catch (c c1) { }
    }

    (Fragment fragment)
    {
        b = fragment;
    }
}
