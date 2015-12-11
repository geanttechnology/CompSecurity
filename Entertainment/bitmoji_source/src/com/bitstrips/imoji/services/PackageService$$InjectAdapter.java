// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.services:
//            PackageService

public final class  extends Binding
    implements MembersInjector
{

    private Binding context;

    public void attach(Linker linker)
    {
        context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/services/PackageService, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(context);
    }

    public void injectMembers(PackageService packageservice)
    {
        packageservice.context = (Context)context.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((PackageService)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.services.PackageService", false, com/bitstrips/imoji/services/PackageService);
    }
}
