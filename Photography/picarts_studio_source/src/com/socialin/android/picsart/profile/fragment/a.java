// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.graphics.Point;
import android.os.Bundle;
import com.picsart.studio.ads.g;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import myobfuscated.cr.f;
import myobfuscated.cs.e;
import myobfuscated.f.m;

public abstract class a extends f
    implements e
{

    public g c;
    int d;
    private RecyclerViewAdapter m;
    private com.socialin.android.apiv3.model.AppProps.TabAdType n;
    private Point o;
    private com.socialin.android.apiv3.model.AppProps.AdType p;
    private boolean q;

    public a()
    {
        q = false;
    }

    public static com.socialin.android.apiv3.model.AppProps.AdType a(com.socialin.android.apiv3.model.AppProps.TabAdType tabadtype)
    {
        Object obj;
        com.socialin.android.apiv3.model.AppProps.Data data;
        data = SocialinV3.getInstance().getAppProps().getData();
        obj = null;
        if (data.adapterAds == null) goto _L2; else goto _L1
_L1:
        obj = data.adapterAds;
        _cls1.a[tabadtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 79
    //                   2 87
    //                   3 95
    //                   4 103;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        obj = new com.socialin.android.apiv3.model.AppProps.AdType();
_L9:
        obj.typeRef = tabadtype;
_L2:
        return ((com.socialin.android.apiv3.model.AppProps.AdType) (obj));
_L4:
        obj = ((com.socialin.android.apiv3.model.AppProps.NestedAds) (obj)).adArtists;
        continue; /* Loop/switch isn't completed */
_L5:
        obj = ((com.socialin.android.apiv3.model.AppProps.NestedAds) (obj)).adExplore;
        continue; /* Loop/switch isn't completed */
_L6:
        obj = ((com.socialin.android.apiv3.model.AppProps.NestedAds) (obj)).adNotifications;
        continue; /* Loop/switch isn't completed */
_L7:
        obj = ((com.socialin.android.apiv3.model.AppProps.NestedAds) (obj)).adMyNetwork;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected final RecyclerViewAdapter a(RecyclerViewAdapter recyclerviewadapter)
    {
        m = recyclerviewadapter;
        c = myobfuscated.f.m.a(getActivity(), recyclerviewadapter);
        if (c != null)
        {
            recyclerviewadapter = c;
        }
        return recyclerviewadapter;
    }

    public final void a(int i)
    {
        if (c != null)
        {
            c.notifyItemRemoved(i);
            return;
        } else
        {
            m.notifyItemRemoved(i);
            return;
        }
    }

    protected final void a(com.socialin.android.apiv3.model.AppProps.TabAdType tabadtype, Point point)
    {
        n = tabadtype;
        o = point;
    }

    public final void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            if (p == null)
            {
                p = a(n);
            }
            c.setAdapterConfigs(p, o);
            c.loadNativeAds(null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void k()
    {
        if (c != null)
        {
            c.notifyItemDataChanged(d);
            return;
        } else
        {
            m.notifyDataSetChanged();
            return;
        }
    }

    public final void l()
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            c.destroyAds();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1 = false;
        super.onCreate(bundle);
        boolean flag = flag1;
        if (getArguments() != null)
        {
            flag = flag1;
            if (getArguments().getBoolean("load.ad", false))
            {
                flag = true;
            }
        }
        q = flag;
    }

    public void onResume()
    {
        super.onResume();
        if (q)
        {
            g();
        }
    }

    /* member class not found */
    class _cls1 {}

}
