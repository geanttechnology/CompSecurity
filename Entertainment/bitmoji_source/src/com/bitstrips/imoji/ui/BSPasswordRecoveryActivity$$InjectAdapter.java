// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.api.BSAuthPasswordService;
import com.bitstrips.imoji.auth.FacebookService;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BSPasswordRecoveryActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding bsAuthPasswordService;
    private Binding facebookService;

    public void attach(Linker linker)
    {
        bsAuthPasswordService = linker.requestBinding("com.bitstrips.imoji.api.BSAuthPasswordService", com/bitstrips/imoji/ui/BSPasswordRecoveryActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/BSPasswordRecoveryActivity, getClass().getClassLoader());
    }

    public BSPasswordRecoveryActivity get()
    {
        BSPasswordRecoveryActivity bspasswordrecoveryactivity = new BSPasswordRecoveryActivity();
        injectMembers(bspasswordrecoveryactivity);
        return bspasswordrecoveryactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(bsAuthPasswordService);
        set1.add(facebookService);
    }

    public void injectMembers(BSPasswordRecoveryActivity bspasswordrecoveryactivity)
    {
        bspasswordrecoveryactivity.bsAuthPasswordService = (BSAuthPasswordService)bsAuthPasswordService.get();
        bspasswordrecoveryactivity.facebookService = (FacebookService)facebookService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BSPasswordRecoveryActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.BSPasswordRecoveryActivity", "members/com.bitstrips.imoji.ui.BSPasswordRecoveryActivity", false, com/bitstrips/imoji/ui/BSPasswordRecoveryActivity);
    }
}
