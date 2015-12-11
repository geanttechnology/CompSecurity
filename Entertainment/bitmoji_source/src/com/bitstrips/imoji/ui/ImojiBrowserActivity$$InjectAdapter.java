// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.CrashlyticsService;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserActivity, ImageLoader, ImojisPreloader, IntentCreatorService

public final class  extends Binding
    implements Provider, MembersInjector
{

    private Binding analytics;
    private Binding b4mService;
    private Binding bitstripsService;
    private Binding bsAuthService;
    private Binding crashlyticsService;
    private Binding facebookService;
    private Binding fileUtil;
    private Binding floaterServiceManager;
    private Binding imageLoader;
    private Binding imojisPreloader;
    private Binding intentCreatorService;
    private Binding preferenceUtils;
    private Binding recentImojiesManager;
    private Binding templatesManager;

    public void attach(Linker linker)
    {
        analytics = linker.requestBinding("com.bitstrips.imoji.analytics.AnalyticsService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        bitstripsService = linker.requestBinding("com.bitstrips.imoji.api.BitstripsService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        bsAuthService = linker.requestBinding("com.bitstrips.imoji.api.BSAuthService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        facebookService = linker.requestBinding("com.bitstrips.imoji.auth.FacebookService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        floaterServiceManager = linker.requestBinding("com.bitstrips.imoji.manager.FloaterServiceManager", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        preferenceUtils = linker.requestBinding("com.bitstrips.imoji.util.PreferenceUtils", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        imageLoader = linker.requestBinding("com.bitstrips.imoji.ui.ImageLoader", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        templatesManager = linker.requestBinding("com.bitstrips.imoji.manager.TemplatesManager", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        imojisPreloader = linker.requestBinding("com.bitstrips.imoji.ui.ImojisPreloader", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        intentCreatorService = linker.requestBinding("com.bitstrips.imoji.ui.IntentCreatorService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        recentImojiesManager = linker.requestBinding("com.bitstrips.imoji.manager.RecentImojiesManager", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        b4mService = linker.requestBinding("com.bitstrips.imoji.services.B4MService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        fileUtil = linker.requestBinding("com.bitstrips.imoji.util.FileUtil", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
        crashlyticsService = linker.requestBinding("com.bitstrips.imoji.services.CrashlyticsService", com/bitstrips/imoji/ui/ImojiBrowserActivity, getClass().getClassLoader());
    }

    public ImojiBrowserActivity get()
    {
        ImojiBrowserActivity imojibrowseractivity = new ImojiBrowserActivity();
        injectMembers(imojibrowseractivity);
        return imojibrowseractivity;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(analytics);
        set1.add(bitstripsService);
        set1.add(bsAuthService);
        set1.add(facebookService);
        set1.add(floaterServiceManager);
        set1.add(preferenceUtils);
        set1.add(imageLoader);
        set1.add(templatesManager);
        set1.add(imojisPreloader);
        set1.add(intentCreatorService);
        set1.add(recentImojiesManager);
        set1.add(b4mService);
        set1.add(fileUtil);
        set1.add(crashlyticsService);
    }

    public void injectMembers(ImojiBrowserActivity imojibrowseractivity)
    {
        imojibrowseractivity.analytics = (AnalyticsService)analytics.get();
        imojibrowseractivity.bitstripsService = (BitstripsService)bitstripsService.get();
        imojibrowseractivity.bsAuthService = (BSAuthService)bsAuthService.get();
        imojibrowseractivity.facebookService = (FacebookService)facebookService.get();
        imojibrowseractivity.floaterServiceManager = (FloaterServiceManager)floaterServiceManager.get();
        imojibrowseractivity.preferenceUtils = (PreferenceUtils)preferenceUtils.get();
        imojibrowseractivity.imageLoader = (ImageLoader)imageLoader.get();
        imojibrowseractivity.templatesManager = (TemplatesManager)templatesManager.get();
        imojibrowseractivity.imojisPreloader = (ImojisPreloader)imojisPreloader.get();
        imojibrowseractivity.intentCreatorService = (IntentCreatorService)intentCreatorService.get();
        imojibrowseractivity.recentImojiesManager = (RecentImojiesManager)recentImojiesManager.get();
        imojibrowseractivity.b4mService = (B4MService)b4mService.get();
        imojibrowseractivity.fileUtil = (FileUtil)fileUtil.get();
        imojibrowseractivity.crashlyticsService = (CrashlyticsService)crashlyticsService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImojiBrowserActivity)obj);
    }

    public ()
    {
        super("com.bitstrips.imoji.ui.ImojiBrowserActivity", "members/com.bitstrips.imoji.ui.ImojiBrowserActivity", false, com/bitstrips/imoji/ui/ImojiBrowserActivity);
    }
}
