// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.PackageService;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.bitstrips.imoji.ui:
//            IntentCreatorService

public final class  extends Binding
    implements MembersInjector
{

    private Binding analyticsService;
    private Binding b4MService;
    private Binding context;
    private Binding facebookService;
    private Binding packageService;
    private Binding preferenceUtils;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        b4MService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        analyticsService = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        context = linker.requestBinding("android.content.Context", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        packageService = linker.requestBinding("com.bitstrips.imoji.services.PackageService", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/IntentCreatorService, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(facebookService);
        set1.add(preferenceUtils);
        set1.add(b4MService);
        set1.add(analyticsService);
        set1.add(context);
        set1.add(packageService);
        set1.add(templatesManager);
    }

    public void injectMembers(IntentCreatorService intentcreatorservice)
    {
        intentcreatorservice.facebookService = (FacebookService)facebookService.get();
        intentcreatorservice.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        intentcreatorservice.b4MService = (B4MService)b4MService.get();
        intentcreatorservice.analyticsService = (AnalyticsService)analyticsService.get();
        intentcreatorservice.context = (Context)context.get();
        intentcreatorservice.packageService = (PackageService)packageService.get();
        intentcreatorservice.templatesManager = (TemplatesManager)templatesManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((IntentCreatorService)obj);
    }

    public ()
    {
        super(null, "members/com.bitstrips.imoji.ui.IntentCreatorService", false, com/bitstrips/imoji/ui/IntentCreatorService);
    }
}
