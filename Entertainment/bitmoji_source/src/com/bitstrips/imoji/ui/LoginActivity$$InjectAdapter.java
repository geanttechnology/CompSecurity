// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            LoginActivity, IntentCreatorService

public final class _cls9 extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding b4MService;
    private Binding bitstripsService;
    private Binding facebookService;
    private Binding intentCreatorService;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/LoginActivity, getClass().getClassLoader());
    }

    public LoginActivity get()
    {
        LoginActivity loginactivity = new LoginActivity();
        injectMembers(loginactivity);
        return loginactivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(bitstripsService);
        set1.add(facebookService);
        set1.add(analytics);
        set1.add(preferenceUtils);
        set1.add(templatesManager);
        set1.add(intentCreatorService);
        set1.add(b4MService);
    }

    public void injectMembers(LoginActivity loginactivity)
    {
        loginactivity.bitstripsService = (BitstripsService)bitstripsService.get();
        loginactivity.facebookService = (FacebookService)facebookService.get();
        loginactivity.analytics = (AnalyticsService)analytics.get();
        loginactivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        loginactivity.templatesManager = (TemplatesManager)templatesManager.get();
        loginactivity.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        loginactivity.b4MService = (B4MService)b4MService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((LoginActivity)obj);
    }

    public _cls9()
    {
        super("com.bitstrips.imoji.ui.LoginActivity", "members/com.bitstrips.imoji.ui.LoginActivity", false, com/bitstrips/imoji/ui/LoginActivity);
    }
}
