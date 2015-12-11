// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.b.e;
import com.google.android.gms.common.c;
import com.google.android.gms.maps.a.ai;
import com.google.android.gms.maps.a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps:
//            MapView, d, e, GoogleMapOptions

public static final class g extends b
{

    protected e d;
    private final ViewGroup e;
    private final Context f;
    private final GoogleMapOptions g;
    private final List h = new ArrayList();

    public final void a()
    {
        if (d == null || super.a != null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        Object obj;
        com.google.android.gms.maps.d.a(f);
        obj = ai.a(f).a(com.google.android.gms.b.d.a(f), g);
        if (obj == null)
        {
            return;
        }
        d.a(new <init>(e, ((com.google.android.gms.maps.a.e) (obj))));
        obj = h.iterator();
_L1:
        com.google.android.gms.maps.e e1;
        ptions ptions;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        e1 = (com.google.android.gms.maps.e)((Iterator) (obj)).next();
        ptions = (h)super.a;
        try
        {
            ptions.a.a(new _cls1(ptions, e1));
        }
        catch (RemoteException remoteexception)
        {
            try
            {
                throw new com.google.android.gms.maps.model.d(remoteexception);
            }
            catch (RemoteException remoteexception1)
            {
                throw new com.google.android.gms.maps.model.d(remoteexception1);
            }
            catch (c c1) { }
            break MISSING_BLOCK_LABEL_161;
        }
          goto _L1
        h.clear();
        return;
    }

    protected final void a(e e1)
    {
        d = e1;
        a();
    }

    ptions(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
    {
        e = viewgroup;
        f = context;
        g = googlemapoptions;
    }
}
