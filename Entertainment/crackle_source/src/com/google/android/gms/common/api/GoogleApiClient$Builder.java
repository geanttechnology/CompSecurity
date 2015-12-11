// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            GoogleApiClient, Api, Scope

public static final class ny
{

    private String jG;
    private final Context mContext;
    private final Set ns;
    private int nt;
    private View nu;
    private String nv;
    private final Map nw;
    private final Set nx;
    private final Set ny;

    public ny addApi(Api api)
    {
        return addApi(api, null);
    }

    public ns addApi(Api api, ns ns1)
    {
        nw.put(api, ns1);
        api = api.bk();
        int j = api.size();
        for (int i = 0; i < j; i++)
        {
            ns.add(((Scope)api.get(i)).br());
        }

        return this;
    }

    public onCallbacks addConnectionCallbacks(onCallbacks oncallbacks)
    {
        nx.add(oncallbacks);
        return this;
    }

    public tionFailedListener addOnConnectionFailedListener(tionFailedListener tionfailedlistener)
    {
        ny.add(tionfailedlistener);
        return this;
    }

    public ny addScope(Scope scope)
    {
        ns.add(scope.br());
        return this;
    }

    public dt bq()
    {
        return new dt(jG, ns, nt, nu, nv);
    }

    public GoogleApiClient build()
    {
        return new GoogleApiClient(mContext, bq(), nw, nx, ny, null);
    }

    public ny setAccountName(String s)
    {
        jG = s;
        return this;
    }

    public jG setGravityForPopups(int i)
    {
        nt = i;
        return this;
    }

    public nt setViewForPopups(View view)
    {
        nu = view;
        return this;
    }

    public nu useDefaultAccount()
    {
        return setAccountName("<<default account>>");
    }

    public tionFailedListener(Context context)
    {
        ns = new HashSet();
        nw = new HashMap();
        nx = new HashSet();
        ny = new HashSet();
        mContext = context;
        nv = context.getPackageName();
    }

    public tionFailedListener(Context context, onCallbacks oncallbacks, tionFailedListener tionfailedlistener)
    {
        this(context);
        eg.b(oncallbacks, "Must provide a connected listener");
        nx.add(oncallbacks);
        eg.b(tionfailedlistener, "Must provide a connection failed listener");
        ny.add(tionfailedlistener);
    }
}
