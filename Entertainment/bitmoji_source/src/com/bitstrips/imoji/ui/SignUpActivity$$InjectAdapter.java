// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            SignUpActivity, ImageLoader

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding bitstripsService;
    private Binding bsAuthService;
    private Binding facebookService;
    private Binding floaterServiceManager;
    private Binding imageLoader;
    private Binding preferenceUtils;
    private Binding supertype;

    public void attach(Linker linker)
    {
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        bsAuthService = linker.requestBinding("com.bitstrips.imoji.api.BSAuthService", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        floaterServiceManager = linker.requestBinding("com.bitstrips.imoji.manager.FloaterServiceManager", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        imageLoader = linker.requestBinding("com.bitstrips.imoji.ui.ImageLoader", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.bitstrips.imoji.ui.OnboardingFormBaseActivity", com/bitstrips/imoji/ui/SignUpActivity, getClass().getClassLoader(), false, true);
    }

    public SignUpActivity get()
    {
        SignUpActivity signupactivity = new SignUpActivity();
        injectMembers(signupactivity);
        return signupactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analytics);
        set1.add(bsAuthService);
        set1.add(preferenceUtils);
        set1.add(facebookService);
        set1.add(floaterServiceManager);
        set1.add(bitstripsService);
        set1.add(imageLoader);
        set1.add(supertype);
    }

    public void injectMembers(SignUpActivity signupactivity)
    {
        signupactivity.analytics = (AnalyticsService)analytics.get();
        signupactivity.bsAuthService = (BSAuthService)bsAuthService.get();
        signupactivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        signupactivity.facebookService = (FacebookService)facebookService.get();
        signupactivity.floaterServiceManager = (FloaterServiceManager)floaterServiceManager.get();
        signupactivity.bitstripsService = (BitstripsService)bitstripsService.get();
        signupactivity.imageLoader = (ImageLoader)imageLoader.get();
        supertype.injectMembers(signupactivity);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SignUpActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.SignUpActivity", "members/com.bitstrips.imoji.ui.SignUpActivity", false, com/bitstrips/imoji/ui/SignUpActivity);
    }
}
