// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            RetrieveAvatarActivity

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding bitstripsService;
    private Binding facebookService;
    private Binding preferenceUtils;

    public void attach(Linker linker)
    {
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/RetrieveAvatarActivity, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/RetrieveAvatarActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/RetrieveAvatarActivity, getClass().getClassLoader());
    }

    public RetrieveAvatarActivity get()
    {
        RetrieveAvatarActivity retrieveavataractivity = new RetrieveAvatarActivity();
        injectMembers(retrieveavataractivity);
        return retrieveavataractivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(facebookService);
        set1.add(bitstripsService);
        set1.add(preferenceUtils);
    }

    public void injectMembers(RetrieveAvatarActivity retrieveavataractivity)
    {
        retrieveavataractivity.facebookService = (FacebookService)facebookService.get();
        retrieveavataractivity.bitstripsService = (BitstripsService)bitstripsService.get();
        retrieveavataractivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetrieveAvatarActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.RetrieveAvatarActivity", "members/com.bitstrips.imoji.ui.RetrieveAvatarActivity", false, com/bitstrips/imoji/ui/RetrieveAvatarActivity);
    }
}
