// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.services:
//            B4MService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding field_facebookService;
    private Binding field_preferenceUtils;
    private Binding field_requestQueue;
    private Binding parameter_context;

    public void attach(Linker linker)
    {
        parameter_context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/services/B4MService, getClass().getClassLoader());
        field_preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/services/B4MService, getClass().getClassLoader());
        field_facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/services/B4MService, getClass().getClassLoader());
        field_requestQueue = linker.requestBinding("com.android.volley.RequestQueue", com/bitstrips/imoji/services/B4MService, getClass().getClassLoader());
    }

    public B4MService get()
    {
        B4MService b4mservice = new B4MService((Context)parameter_context.get());
        injectMembers(b4mservice);
        return b4mservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(parameter_context);
        set1.add(field_preferenceUtils);
        set1.add(field_facebookService);
        set1.add(field_requestQueue);
    }

    public void injectMembers(B4MService b4mservice)
    {
        b4mservice.preferenceUtils = (PreferenceUtils)field_preferenceUtils.get();
        b4mservice.facebookService = (FacebookService)field_facebookService.get();
        b4mservice.requestQueue = (RequestQueue)field_requestQueue.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((B4MService)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.services.B4MService", "members/com.bitstrips.imoji.services.B4MService", false, com/bitstrips/imoji/services/B4MService);
    }
}
